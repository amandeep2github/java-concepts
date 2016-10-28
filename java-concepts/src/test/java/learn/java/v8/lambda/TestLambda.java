package learn.java.v8.lambda;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;

import org.junit.Assert;
import org.junit.Test;

public class TestLambda {

	@Test
	public void testStringComparator() {
		String[] strArr = new String[]{"B", "A", "C"};
		Arrays.sort(strArr, new SimpleComparator().getStringComparator());
		Assert.assertArrayEquals(new String[]{"A", "B", "C"}, strArr);
	}
	
	@Test
	public void testLambdaReference(){
		Function<Person, String> fn = person -> person.getFullName();
		Person person = new Person("Amandeep", "Singh");
		Assert.assertEquals("Amandeep Singh", fn.apply(person));
		
	}
	
	@Test
	public void testFunctionalReference(){
		Function<Person, String> fn = Person::getFullName;
		Person person = new Person("Amandeep", "Singh");
		Assert.assertEquals("Amandeep Singh", fn.apply(person));
		
	}
	
	@Test
	public void testFunctionalReferenceOnSystemOut(){
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(bos);
		System.setOut(ps);
		Consumer<String> cons = System.out::print;
		cons.accept("Amandeep Singh");
		Assert.assertEquals("Amandeep Singh", bos.toString());
		
	}
	

}
