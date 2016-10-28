package learn.java.v8.lambda;

import java.util.Comparator;

public class SimpleComparator {
	
	public Comparator<String> getStringComparator(){
		//type of parameters can be omitted, '{' omitted as single line block
		Comparator<String> comparator = (String s1, String s2) -> 
			s1.compareTo(s2);
		return comparator;
		
	}
}
