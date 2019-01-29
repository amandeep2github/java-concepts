package learn.java.v8.streams;

public class Student {
	private int rollNumber;
	private String name;
	private double score;
	
	
	
	public Student(int rollNumber, String name, double score) {
		super();
		this.rollNumber = rollNumber;
		this.name = name;
		this.score = score;
	}
	public int getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	
	
}
