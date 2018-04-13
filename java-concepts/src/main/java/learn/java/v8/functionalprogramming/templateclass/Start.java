package learn.java.v8.functionalprogramming.templateclass;

public class Start {

	public static void main(String[] args) {
		AlgoTemplateForTypesWithoutFP<Animal> algoWithoutFP = new AlgoTemplateForTypesWithoutFP<>();
		
		System.out.println(algoWithoutFP.getType(new Animal("Lion")));

		AlgoTemplateForTypesWithFP<Animal> algoWithFP = new AlgoTemplateForTypesWithFP<>();
		
		System.out.println(algoWithFP.getType(new Animal("Lion"), a -> a.getSpicies()));
	}

}
