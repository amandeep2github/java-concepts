package learn.java.java_concepts;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        AbstractClass abstractClass = new AbstractClass() {
            @Override
            public void overrideMe() {
                System.out.println("wont be called untill called");
            }

            {
            String param = "Hello there";
            callMe(param);
        }
        };
    }
    
    
}
