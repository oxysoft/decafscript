package com.oxysoft.decaf.exceptions;

/**
 * Created by oxysoft on 20/07/14.
 */
public class SymbolNotFoundException extends DecafException {

	public SymbolNotFoundException(String name) {
		super("Symbol '" + name + "' not found");
	}
}
