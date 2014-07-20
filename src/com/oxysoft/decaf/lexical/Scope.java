package com.oxysoft.decaf.lexical;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

/**
 * Created by oxysoft on 20/07/14.
 */
public class Scope {

	public Scope parentScope;
	public Map<String, DObject> variables = new HashMap<>();
	String[] statements;

	public Scope(Scope parentScope) {
		this.parentScope = parentScope;
	}

	public Scope() {
	}

	public static Scope getTopLevelScope() {
		Scope scope = new Scope();

		scope.variables.put("println", DefaultClosures.println);

		return scope;
	}

	public Object getSymbol(String name) {
		if (variables.containsKey(name)) {
			return variables.get(name);
		} else {
			if (parentScope != null) {
				return parentScope.getSymbol(name);
			} else {
				return null;
			}
		}
	}

	public Closure getClosure(String closureName) {
		Optional<Entry<String, DObject>> entry = variables.entrySet().stream().filter(p -> p.getValue() instanceof Closure).filter(p -> p.getKey().equals(closureName)).findFirst();

		if (entry.isPresent())
			return (Closure) entry.get().getValue();
		else
			return null;
	}
}
