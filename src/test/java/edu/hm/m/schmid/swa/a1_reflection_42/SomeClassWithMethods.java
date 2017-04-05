package edu.hm.m.schmid.swa.a1_reflection_42;

import java.util.Date;

import edu.hm.m.schmid.swa.a1_reflection_42.RenderMe;

public class SomeClassWithMethods {
	@RenderMe
	private int foo;
	@RenderMe(with="edu.hm.m.schmid.swa.a1_reflection_42.ArrayRenderer")
	int[] array = {1, 2, 3, };
	@RenderMe
	private Date date = new Date(123456789);
	
	public SomeClassWithMethods(int foo) {
		this.foo = foo;
	}
	
	@RenderMe
	public int getFoo() {
		return foo;
	}
	
	@RenderMe(with="edu.hm.m.schmid.swa.a1_reflection_42.ArrayRenderer")
	private int[] getArray() {
		return array;
	}
	
}
