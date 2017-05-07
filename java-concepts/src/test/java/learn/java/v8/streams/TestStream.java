package learn.java.v8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class TestStream {

	@Test
	@Ignore
	public void testFilter() {
		String arr [] = new String[]{"1","2","1","3","4","2"};
		
		List<String> list = Arrays.asList(arr);
		Stream<String> filtered = list.stream().filter(ele -> ele.equals("2"));
		//filtered.forEach(t-> System.out.println(t));
		assertEquals("2", filtered.findFirst().get());
		//assertEquals("2", filtered.count());
	}
	
	@Test
	public void testAggregateFunction() {
		String arr [] = new String[]{"1","2","1","3","4","2"};
		
		List<String> list = Arrays.asList(arr);
		//int sum = list.stream().filter(ele -> ele.equals("2")).mapToInt(t -> Integer.getInteger(t).intValue()).sum();
		//assertEquals(4, sum);
		System.out.println(list.stream().filter(ele -> ele.equals("2")).mapToInt(t -> Integer.getInteger(t)));
		list.stream().filter(ele -> ele.equals("2")).mapToInt(t -> Integer.getInteger(t)).forEach(
				t ->System.out.println(t)
				);
		
	}
	
	@Test
	public void testListTrimString() {
		String arr [] = new String[]{" Amandeep","Sumit "," Virender Kumar ","Amit","Mayank"," Priyank"};
		
		
		List<String> list = Arrays.asList(arr);
		List<String> list1 = list.stream().map(rec -> rec.trim()).collect(Collectors.toList());
		assertEquals("Amandeep", list1.get(0));
		assertEquals("Sumit", list1.get(1));
		
	}

}
