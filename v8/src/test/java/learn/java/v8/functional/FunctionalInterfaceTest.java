package learn.java.v8.functional;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import org.junit.Test;

public class FunctionalInterfaceTest {

	@Test
	public void test() {
		//MyFunctionalInterface mfi = MyFunctionalInterfaceImpl::hello;
		Function<MyFunctionalInterface, String> func = MyFunctionalInterface::hello;
		
		MyFunctionalInterface myFunc = new MyFunctionalInterfaceImpl();
		
		System.out.println(func.apply(myFunc));
	}

	@Test
	public void testStaticContext(){
		List<Animal> animalList = Arrays.asList(new Animal("Dog"), new Animal("Cat"));
		Animal animal = new Animal("Cow");
		animalList.forEach(Animal::getSpicies);
		animalList.forEach(System.out::println);
		//Consumer<String> consumer = animal::getSpicies;
		Consumer<String> consumer = System.out::println;
		//Predicate<Animal> predicate = animal::getSpicies;
		Function<Animal, Boolean> function = animal::equals;
		//animalList.stream().fi
	}

}
