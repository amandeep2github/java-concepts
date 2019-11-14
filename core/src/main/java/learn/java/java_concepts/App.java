package learn.java.java_concepts;

//import learn.java.v8.lambda.Util;

import java.util.function.Supplier;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
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
//        Supplier<String> hello = Util::hello;
//        System.out.println(hello.get());
    }


}
