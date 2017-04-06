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
