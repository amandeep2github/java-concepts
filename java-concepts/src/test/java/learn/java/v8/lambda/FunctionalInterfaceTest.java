package learn.java.v8.lambda;

import java.util.function.Function;

import org.junit.Test;

public class FunctionalInterfaceTest {

	@Test
	public void test() {
		//MyFunctionalInterface mfi = MyFunctionalInterfaceImpl::hello;
		Function<MyFunctionalInterface, String> func = MyFunctionalInterface::hello;
		
		MyFunctionalInterface myFunc = new MyFunctionalInterfaceImpl();
		
		System.out.println(func.apply(myFunc));
	}

}
