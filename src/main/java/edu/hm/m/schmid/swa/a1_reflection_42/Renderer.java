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
    public Renderer(Object toRender){
        if(toRender == null)
            throw new NullPointerException("Null is not allowed as parameter.");
        this.renderObject = toRender;

    }

    /**
     * Gets the object which should be rendered.
     * @return object.
     */
    protected Object getRenderObject(){return renderObject;}

    /**
     * Renders the object which was given in constructor as parameter.
     * @return rendered object as string.
     */
    public String render(){

        StringBuilder renderStringBuilder = new StringBuilder();
        Class<?> renderObjectClass = this.getRenderObject().getClass();
        Field[] fields =renderObjectClass.getDeclaredFields();
        
        renderStringBuilder.append("Instance of " + renderObjectClass.getName() + ":\n");
        
        for (Field field: fields) {
            if(field.isAnnotationPresent(RenderMe.class)){
            	field.setAccessible(true);
                RenderMe annotation = field.getAnnotation(RenderMe.class);
                try {
                	renderStringBuilder.append(field.getName() + " ");
                    if(annotation.with().equals(""))
                        renderStringBuilder.append("(Type " + field.getType() +"): " + field.get(this.getRenderObject()) + "\n");
                    else{
                        Class<?> act = Class.forName(annotation.with());
                        Renderer obj = (Renderer)act.getDeclaredConstructor(field.getType()).newInstance(field.get(this.getRenderObject()));
                        renderStringBuilder.append(obj.render());
                    }
                } catch (Exception e) {
                    renderStringBuilder.append("No access at " + field.getName());
                }
            }

        }
        
        Method[] methods = renderObjectClass.getDeclaredMethods();
        for (Method method : methods) {
        	method.setAccessible(true);
        	if(method.isAnnotationPresent(RenderMe.class) && method.getParameterCount() == 0 && method.getReturnType() != void.class) {
        		RenderMe annotation = method.getAnnotation(RenderMe.class);
				try {
					renderStringBuilder.append(method.getName() + " ");
					if(annotation.with().equals(""))
						renderStringBuilder.append("(Type " + method.getReturnType() +"): " + method.invoke(getRenderObject(), new Object[0]) + "\n");
					else {
						Class<?> act = Class.forName(annotation.with());
						Renderer obj = (Renderer)act.getDeclaredConstructor(method.getReturnType()).newInstance(method.invoke(getRenderObject(), new Object[0]));
						renderStringBuilder.append(obj.render());
						
					}
				} catch (IllegalAccessException e) {
					// Couldn't happen, every methods is set accessible
				} catch (IllegalArgumentException e) {
					// Couldn't happen, only methods without Parameters are executed
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

        return renderStringBuilder.toString();


    }
}
