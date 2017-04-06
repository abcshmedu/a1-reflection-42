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
package edu.hm;

import java.util.Date;

import edu.hm.m.schmid.swa.a1_reflection_42.RenderMe;

/**
 * A class for general test.
 */
public class SomeClass {
    @RenderMe
    private int foo;
    @RenderMe(with = "edu.hm.m.schmid.swa.a1_reflection_42.ArrayRenderer")
    private int[] array = {1, 2, 2 + 1, };

    private final int dateInInt = 123456789;
    @RenderMe
    private Date date = new Date(dateInInt);

    /**
     * C.
     * @param foo = foo to render.
     */
    public SomeClass(int foo) {
        this.foo = foo;
    }

}
