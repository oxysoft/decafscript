package com.oxysoft.decaf.exceptions;

/**
 * Created by oxysoft on 20/07/14.
 */
public class ClosureNotFoundException extends DecafException {

	public ClosureNotFoundException(String name) {
		super("Closure '" + name + "' not found");
	}

}
