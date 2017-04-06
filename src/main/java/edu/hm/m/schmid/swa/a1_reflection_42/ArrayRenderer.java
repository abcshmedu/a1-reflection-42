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
 * Created by Raphael Furch on 05.04.2017.
 * Converts a int[] to a representative string.
 * This class inherits from edu.hm.m.schmid.swa.a1_reflection_42.Renderer.class the object administration.
 */
public class ArrayRenderer extends Renderer {

    /**
     * C.
     * @param toRender = int[] to render.
     */
    public ArrayRenderer(int[] toRender){
        super(toRender); // call super C.
    }

    /**
     * Renders the object which was given in constructor as parameter.
     * @return rendered object as string.
     */
    @Override
    public String render(){
        StringBuilder builder = new StringBuilder();
        builder.append("(Type int[]) [");

        int[] intArray = (int[])this.getRenderObject();
        for (int i = 0; i < intArray.length; i++) {
            builder.append(intArray[i] + ", ");
        }
        builder.append("]\n");
        return builder.toString();
    }
}
