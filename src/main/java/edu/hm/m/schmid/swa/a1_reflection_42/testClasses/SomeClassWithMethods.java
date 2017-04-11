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
package edu.hm.m.schmid.swa.a1_reflection_42.testClasses;

import java.util.Date;

import edu.hm.m.schmid.swa.a1_reflection_42.RenderMe;

/**
 * Some class to test.
 */
public class SomeClassWithMethods {
    /**
     * a int.
     */
    @RenderMe
    private int foo;

    /**
     * a array to render.
     */
    @RenderMe(with = "edu.hm.m.schmid.swa.a1_reflection_42.ArrayRenderer")
    private int[] array = {1, 2, 2+1, };

    /**
     * Date as long.
     */
    private final long dateAsLong = 123456789;
    /**
     * a date to test.
     */
    @RenderMe
    private Date date = new Date(dateAsLong);

    /**
     * C.
     * @param foo = int to test.
     */
    public SomeClassWithMethods(int foo) {
        this.foo = foo;
    }

    /**
     * A getter to test.
     * @return a int.
     */
    @RenderMe
    public int getFoo() {
        return foo;
    }

    /**
     * A array getter to test.
     * @return a array.
     */
    @RenderMe(with = "edu.hm.m.schmid.swa.a1_reflection_42.ArrayRenderer")
    private int[] getArray() {
        return array;
    }

}
