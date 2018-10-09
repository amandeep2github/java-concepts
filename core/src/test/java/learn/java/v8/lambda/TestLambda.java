package learn.java.v8.lambda;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;

public class TestLambda {

	@Test
	public void testStringComparator() {
		String[] strArr = new String[]{"B", "A", "C"};
		//Arrays.sort(strArr, new SimpleComparator().getStringComparator());
		Arrays.sort(strArr, (String s1, String s2) -> s1.compareTo(s2));
		Assert.assertArrayEquals(new String[]{"A", "B", "C"}, strArr);
	}
	
	@Test
	public void testLambdaReference(){
		Function<Person, String> fn = (person) -> person.getFullName();
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

	@Test
	public void testReduce(){
		List<Integer> integerList = Arrays.asList(1 ,2, 3, 4, 5);
		Integer reduce1 = integerList.stream().reduce(0, (a, b) -> a + b);
		Assert.assertEquals(15, reduce1.intValue());

		Integer sum = integerList.stream().collect(Collectors.summingInt(ele -> ele));
		Assert.assertEquals(15, sum.intValue());
	}
	

}
