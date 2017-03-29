package edu.hm.m.schmid.swa.a1_reflection_42;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.lang.reflect.Field;
import java.util.Arrays;

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
    private Object getRenderObject(){return renderObject;}

    public String render(){

        StringBuilder renderStringBuilder = new StringBuilder();
        Class<?> renderObjectClass = this.getRenderObject().getClass();
        Field[] fields =renderObjectClass.getFields();

        for (Field field: fields) {

            if(field.isAnnotationPresent(RenderMe.class)){
                try {
                    renderStringBuilder.append(field.getName() +" (Type " + field.getType() +"): " + field.get(this.getRenderObject()));
                } catch (IllegalAccessException e) {
                    renderStringBuilder.append("No access at " + field.getName());
                }
            }

        }

        return renderStringBuilder.toString();


    }
}
