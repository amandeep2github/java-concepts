package learn.java.v8.lambda;

public class Person {
	private String firstName;
	private String lastName;
	
	public Person(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String getFullName(){
		return String.format("%s %s", firstName, lastName);
		
	}
	
}
