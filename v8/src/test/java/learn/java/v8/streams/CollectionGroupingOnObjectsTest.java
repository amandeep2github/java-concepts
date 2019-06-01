package learn.java.v8.streams;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import learn.java.domain.ecommerce.Order;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

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

	@Test
	public void testGroupingMappingSumming(){
		List<Order> items = new ArrayList<>();
		items.add(new Order(101, "Potato", 5.0, 3, "KG"));
		items.add(new Order(102, "Tomato", 50.0, 5, "KG"));
		items.add(new Order(101, "Potato", 6.0, 5, "KG"));
		items.add(new Order(103, "Mango", 100.0, 2, "KG"));
		items.add(new Order(101, "Potato", 5.0, 3, "KG"));
		items.add(new Order(102, "Tomato", 40.0, 10, "KG"));

		Map<String, Double> itemToTotalSaleMap = items.stream().collect(Collectors.groupingBy(Order::getItemName, Collectors.mapping(item -> item.getRate()*item.getUnits(), Collectors.summingDouble(d -> d))));
		assertThat(itemToTotalSaleMap.get("Potato")).isEqualTo(Double.valueOf(60));
	}

	@Test
	public void testToMapWithJoining(){
		List<Order> items = new ArrayList<>();
		items.add(new Order(101, "Potato", 5.0, 3, "KG"));
		items.add(new Order(102, "Tomato", 50.0, 5, "KG"));
		items.add(new Order(101, "Potato", 6.0, 5, "KG"));
		items.add(new Order(103, "Mango", 100.0, 2, "KG"));
		items.add(new Order(101, "Potato", 5.0, 3, "KG"));
		items.add(new Order(102, "Tomato", 40.0, 10, "KG"));




	}

}
