package edu.hm;

import java.util.Date;

import edu.hm.m.schmid.swa.a1_reflection_42.RenderMe;

public class SomeClass {
	@RenderMe
	private int foo;
	@RenderMe(with="edu.hm.m.schmid.swa.a1_reflection_42.ArrayRenderer")
	int[] array = {1, 2, 3, };
	@RenderMe
	private Date date = new Date(123456789);
	
	public SomeClass(int foo) {
		this.foo = foo;
	}
	
}
