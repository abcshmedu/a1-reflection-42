package edu.hm.m.schmid.swa.a1_reflection_42;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Raphael Furch on 29.03.2017.
 */
public class Renderer {

    private final Object renderObject;
    public Renderer(Object toRender){
        if(toRender == null)
            throw new NullPointerException("Null is not allowed as parameter.");
        this.renderObject = toRender;

    }
    protected Object getRenderObject(){return renderObject;}

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
