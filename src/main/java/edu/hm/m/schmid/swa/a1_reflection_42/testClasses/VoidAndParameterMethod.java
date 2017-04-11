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

import edu.hm.m.schmid.swa.a1_reflection_42.RenderMe;

/**
 * Just testing return void and methods with parameter tests.
 */
public class VoidAndParameterMethod {

    /**
     * Method with parameter.
     * @param number = number.
     * @return a number.
     */
    @RenderMe
    public int getNumber(int number) {
        return number;
    }

    /**
     * Void method to test.
     */
    @RenderMe
    public void toNothing() {
        int i = 0;
    }

}
