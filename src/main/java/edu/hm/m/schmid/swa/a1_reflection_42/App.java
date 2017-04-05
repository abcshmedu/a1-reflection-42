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

/**
 * Hello world!
 * For fast tests.
 */
public class App 
{
    @RenderMe
    public int MagicNumber = 42;

    @RenderMe
    private int getMagicNumber() {
    	return MagicNumber;
    }
    
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        App a = new App();
        Renderer re = new Renderer(a);
        System.out.println(re.render());
    }
}
