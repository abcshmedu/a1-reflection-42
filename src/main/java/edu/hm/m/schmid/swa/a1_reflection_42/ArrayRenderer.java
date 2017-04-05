package edu.hm.m.schmid.swa.a1_reflection_42;

/**
 * Created by rapha on 05.04.2017.
 */
public class ArrayRenderer extends Renderer {

    public ArrayRenderer(int[] o){
        super(o);
    }

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
