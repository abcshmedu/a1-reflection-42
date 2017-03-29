package edu.hm.m.schmid.swa.a1_reflection_42;

/**
 * Hello world!
 *
 */
public class App 
{
    @RenderMe
    public int MagicNumber = 42;

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        App a = new App();
        Renderer re = new Renderer(a);
        System.out.println(re.render());
    }
}
