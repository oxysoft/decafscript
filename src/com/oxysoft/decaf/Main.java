package com.oxysoft.decaf;

/**
 * Created by oxysoft on 20/07/14.
 */
public class Main {

	public static void main(String[] args) {
		DecafParser interpreter = new DecafParser();
		interpreter.parse("println 'Hello world!' 'Another string!' ");
	}


}
