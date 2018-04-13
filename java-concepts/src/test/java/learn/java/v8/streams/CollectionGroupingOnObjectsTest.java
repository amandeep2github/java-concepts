package learn.java.v8.streams;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Test;

public class CollectionGroupingOnObjectsTest {

	@Test
	public void testPartition() {
		List<Student> students = new ArrayList<>();
		students.add(new Student(101, "Amandeep", 8.5));
		students.add(new Student(102, "Amit", 4.5));
		students.add(new Student(101, "Sumit", 9.5));
		students.add(new Student(101, "Navin", 8));
		
		Map<Boolean, List<Student>> passingFailing = students.stream().collect(Collectors.partitioningBy(rec->rec.getScore()>=8));
		System.out.println(passingFailing);
	}

}
