package edu.hm.m.schmid.swa.a1_reflection_42;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.hm.SomeClass;

public class RendererTest {	
	
	@Test
	public void testRendering() throws Exception {
		final SomeClass toRender = new SomeClass(5);
		final Renderer renderer = new Renderer(toRender);
		assertEquals("Instance of edu.hm.SomeClass:\n" +
				"foo (Type int): 5\narray (Type int[]) [1, 2, 3, ]\n" + 
				"date (Type class java.util.Date): Fri Jan 02 11:17:36 CET 1970\n", renderer.render());
	}
	@Test
	public void renderWithMethods() {
		final SomeClassWithMethods toRenderMethods = new SomeClassWithMethods(42);
		final Renderer renderer = new Renderer(toRenderMethods);
		assertEquals("Instance of edu.hm.m.schmid.swa.a1_reflection_42.SomeClassWithMethods:\n" +
				"foo (Type int): 42\n" + 
				"array (Type int[]) [1, 2, 3, ]\n" + 
				"date (Type class java.util.Date): Fri Jan 02 11:17:36 CET 1970\n" +
				"getFoo (Type int): 42\n" + 
				"getArray (Type int[]) [1, 2, 3, ]\n", renderer.render());
	}
	
	@Test
	public void renderVoidAndParameter() {
		final VoidAndParameterMethod toRenderMethods = new VoidAndParameterMethod();
		final Renderer renderer = new Renderer(toRenderMethods);
		assertEquals("Instance of edu.hm.m.schmid.swa.a1_reflection_42.VoidAndParameterMethod:\n", renderer.render());
	}

}
