/** Hochschule Muenchen, Fakultaet 07 Informatik und Mathematik
 *  Praktikum Software Architektur IF4B SS2017
 *  Loesung von Aufgabe 1
 *
 *  Autor: Raphael Furch, rfurch@hm.edu
 *  Autor: Michael Schmid, m.schmid@hm.edu
 *  Datum: 29.03.2017
 *  Software: Windows 10, Java 1.8.0_60 SE
 *  System: Intel Core i7-2677m, 4GB RAM
 *
 */
package edu.hm.m.schmid.swa.a1_reflection_42;

import static org.junit.Assert.*;

import org.junit.Test;
import edu.hm.m.schmid.swa.a1_reflection_42.testClasses.*;
import edu.hm.SomeClass;

/**
 *
 */
public class RendererTest {	
	
	@Test(expected=NullPointerException.class)
	public void rendererObjectWithParameterNull() {
		@SuppressWarnings("unused")
		final Renderer renderer = new Renderer(null);
	}
	
	@Test
	public void testRendering() throws Exception {
		final SomeClass toRender = new SomeClass(5);
		final Renderer renderer = new Renderer(toRender);
		assertEquals("Instance of edu.hm.SomeClass:\n" +
				"array (Type int[]) [1, 2, 3, ]\n"+
				"date (Type class java.util.Date): Fri Jan 02 11:17:36 CET 1970\n"+
				"foo (Type int): 5\n"
				, renderer.render());
	}
	@Test
	public void renderWithMethods() throws Exception {
		final SomeClassWithMethods toRenderMethods = new SomeClassWithMethods(42);
		final Renderer renderer = new Renderer(toRenderMethods);
		String render = renderer.render();
		assertEquals("Instance of edu.hm.m.schmid.swa.a1_reflection_42.testClasses.SomeClassWithMethods:\n" +
				"array (Type int[]) [1, 2, 3, ]\n" +
				"date (Type class java.util.Date): Fri Jan 02 11:17:36 CET 1970\n" +
				"foo (Type int): 42\n" +
				"getArray (Type int[]) [1, 2, 3, ]\n"+
				"getFoo (Type int): 42\n"
				, render);
	}
	
	@Test
	public void renderVoidAndParameter() throws Exception {
		final VoidAndParameterMethod toRenderMethods = new VoidAndParameterMethod();
		final Renderer renderer = new Renderer(toRenderMethods);
		assertEquals("Instance of edu.hm.m.schmid.swa.a1_reflection_42.testClasses.VoidAndParameterMethod:\n", renderer.render());
	}

}
