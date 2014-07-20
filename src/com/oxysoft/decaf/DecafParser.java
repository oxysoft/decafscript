package com.oxysoft.decaf;

import com.oxysoft.decaf.exceptions.ClosureNotFoundException;
import com.oxysoft.decaf.exceptions.DecafException;
import com.oxysoft.decaf.exceptions.SymbolNotFoundException;
import com.oxysoft.decaf.lexical.*;
import com.oxysoft.decaf.lexical.Objects.DString;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by oxysoft on 20/07/14.
 */
public class DecafParser {

	public void parse(String code) {
		try {
			String[] statements = code.split("\\\\r?\\\\n|;");
			Scope mainScope = Scope.getTopLevelScope();
			Scope lastScope = mainScope;
			for (String statement : statements) {
				statement = statement.trim();
				if (statement.endsWith("{")) {
					Scope scope = new Scope(lastScope);
					lastScope = scope;
				} else if (statement.startsWith("}")) {
					if (lastScope.parentScope == null) {

					}
				} else {
					Statement stat = consumeStatement(lastScope, statement);
				}
			}
		} catch (DecafException e) {
			System.out.println(e);
		}
	}

	private Statement consumeStatement(Scope scope, String code) throws DecafException {
		return consumeStatementFunction(scope, code);
	}

	private StatementFunction consumeStatementFunction(Scope scope, String code) throws ClosureNotFoundException {
		// println ''
		// println ""
		// println ("")
		// println("")

		StatementFunction statement = new StatementFunction();

		if (code.contains("(") || code.contains(")")) {

		} else {
			String closureName = code.split(" ")[0];

			Closure closure = scope.getClosure(closureName);

			if (closure == null) {
				throw new ClosureNotFoundException(closureName);
			} else {
				String argsStr = code.substring(closureName.length() + 1) + ' ';

				List<String> params = new ArrayList<>();
				Character strChar = null;
				StringBuffer sb = new StringBuffer();
				for (char chr : argsStr.toCharArray()) {
					if (strChar == null && chr == ' ') {
						params.add(sb.toString());
						sb.setLength(0); // clear the buffer
					} else if (strChar == null && (chr == '\'' || chr == '\"')) {
						strChar = chr;
					} else if (chr == '\'' || chr == '\"') {
						strChar = null;
					}

					if (chr != ' ' || strChar != null)
						sb.append(chr);
				}

				statement.parameters = new DObject[params.size()];
				for (String arg : params) {
					if (arg.endsWith(",")) {
						arg = arg.substring(0, arg.length() - 1);
					}

					DObject object = consumeSymbolDecl(scope, arg);
				}
			}
		}

		return statement;
	}

	private DObject consumeSymbolDecl(Scope scope, String decl) {
		if ((decl.startsWith("'") && decl.endsWith("'")) || (decl.startsWith("\"") && decl.endsWith("\"")))
			return new DString(decl.substring(1, decl.length() - 1));
		return null;
	}

	public void parseFile(File file) {
	}


}
