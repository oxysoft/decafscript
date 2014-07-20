package com.oxysoft.decaf.lexical;

/**
 * Created by oxysoft on 20/07/14.
 */
public class DefaultClosures {

	public static final Closure println = new Closure() {
		@Override
		public void execute(DObject... params) {
			System.out.println(params);
		}
	};

}
