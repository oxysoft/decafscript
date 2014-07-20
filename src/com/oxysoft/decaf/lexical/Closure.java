package com.oxysoft.decaf.lexical;

/**
 * Created by oxysoft on 20/07/14.
 */
public abstract class Closure extends DObject {
	@Override
	public Object get() {
		return null;
	}

	public abstract void execute(DObject... params);
}
