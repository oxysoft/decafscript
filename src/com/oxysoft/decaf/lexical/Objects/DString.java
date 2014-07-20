package com.oxysoft.decaf.lexical.Objects;

import com.oxysoft.decaf.lexical.DObject;

/**
 * Created by oxysoft on 20/07/14.
 */
public class DString extends DObject {

	private String _string;

	public DString(String string) {
		this._string = string;
	}

	@Override
	public Object get() {
		return _string;
	}
}
