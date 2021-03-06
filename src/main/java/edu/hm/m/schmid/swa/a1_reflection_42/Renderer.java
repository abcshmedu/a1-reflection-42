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

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Raphael Furch on 29.03.2017.
 */
public class Renderer {

    /**
     * Object to render.
     */
    private final Object renderObject;

    /**
     * C.
     * @param toRender = object to render. Null is n
     */
    public Renderer(Object toRender) {
        if (toRender == null) {
            throw new NullPointerException("Null is not allowed as parameter.");
        }
        this.renderObject = toRender;

    }

    /**
     * Gets the object which should be rendered.
     * @return object.
     */
    protected Object getRenderObject() {
        return renderObject;
    }

    /**
     * Renders the object which was given in constructor as parameter.
     * @return rendered object as string.
     * @throws ClassNotFoundException the annotated renderer doesn't exists
     * @throws NoSuchMethodException the annotated renderer hasn't a constructor with this type
     * @throws InstantiationException the construction of the annotated renderer failed 
     * @throws InvocationTargetException the render method of the annotated renderer throws an exception
     */
    public String render() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, InvocationTargetException {

        StringBuilder renderStringBuilder = new StringBuilder();
        // Get all classes
        Class< ? > renderObjectClass = this.getRenderObject().getClass();
        // Get all fields
        Field[] fields = renderObjectClass.getDeclaredFields();
        // Sort by abc.
        Arrays.sort(fields, Comparator.comparing(Field::getName));
        renderStringBuilder.append("Instance of " + renderObjectClass.getName() + ":\n");

        // Render all fields.
        for (Field field: fields) {
            if (field.isAnnotationPresent(RenderMe.class)) {
                field.setAccessible(true); // make private accessible.
                RenderMe annotation = field.getAnnotation(RenderMe.class);
                try {
                    renderStringBuilder.append(field.getName() + " ");
                    if (annotation.with().equals("")) { // default renderer.
                        renderStringBuilder.append("(Type " + field.getType() + "): " + field.get(this.getRenderObject()) + "\n");
                    }
                    else { // call custom render.
                        Class< ? > act = Class.forName(annotation.with());
                        Renderer obj = (Renderer)act.getDeclaredConstructor(field.getType()).newInstance(field.get(this.getRenderObject()));
                        renderStringBuilder.append(obj.render());
                    }
                } catch (IllegalAccessException e) {
                    // Couldn't happen, every field is set accessible
                }
            }

        }
        // Get all methods.
        Method[] methods = renderObjectClass.getDeclaredMethods();
        // SOrt b abc.
        Arrays.sort(methods, Comparator.comparing(Method::getName));
        for (Method method : methods) {
            method.setAccessible(true);
            // Render method if it returns a value and has no parameter.
            if (method.isAnnotationPresent(RenderMe.class) && method.getParameterCount() == 0 && method.getReturnType() != void.class) {
                RenderMe annotation = method.getAnnotation(RenderMe.class);
                try {
                    renderStringBuilder.append(method.getName() + " ");
                    if (annotation.with().equals("")) {
                        renderStringBuilder.append("(Type " + method.getReturnType() + "): " + method.invoke(getRenderObject(), new Object[0]) + "\n");
                    }
                    else {
                        Class< ? > act = Class.forName(annotation.with());
                        Renderer obj = (Renderer)act.getDeclaredConstructor(method.getReturnType()).newInstance(method.invoke(getRenderObject(), new Object[0]));
                        renderStringBuilder.append(obj.render());

                    }
                } catch (IllegalAccessException e) {
                    // Couldn't happen, every methods is set accessible
                }
            }
        }

        return renderStringBuilder.toString();


    }
}
