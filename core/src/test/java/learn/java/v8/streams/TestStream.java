package learn.java.v8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class TestStream {

	
	
	@Test
	public void arrayListConversionStream(){
		Integer numbers[] = new Integer[] { 3000, 1000, 5000, 3000, 6000, 2000, 8000, 5000, 9000, 4000 };
		List<Integer> listofInt = Arrays.asList(numbers); 
		Arrays.asList(numbers).stream().forEach(num->System.out.print(num));
		String arr [] = new String[]{"1","2","1","3","4","2"};
		Arrays.asList(arr).stream().forEach(val-> System.out.print(val));
	}
	
	
	@Test
	//@Ignore
	public void testFilter() {
		String arr [] = new String[]{"1","2","1","3","4","2"};
		
		List<String> list = Arrays.asList(arr);
		Arrays.asList(arr).stream().forEach(val-> System.out.print(val));
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
	
	@Test
	public void removeDuplicates(){
		String arr [] = new String[]{"1","2","1","3","4","2"};
		Map<Object, List<String>> withoutDuplicates1 = Arrays.stream(arr).collect(Collectors.groupingBy(val->val, Collectors.toList()));
		System.out.println(withoutDuplicates1.keySet());
		Set<String> withoutDuplicates2 = Arrays.stream(arr).collect(Collectors.toSet());
		System.out.println(withoutDuplicates2);
	}

}
