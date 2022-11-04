package imposto;

public abstract class Person {
	private String name;
	private double anualRent;
	
	
	public Person(String name, double anualRent) {
		super();
		this.name = name;
		this.anualRent = anualRent;
	}
	public abstract double taxAmount();
	
	public String getName() {
		return name;
	}
	public double getAnualRent() {
		return anualRent;
	}
	
	
}
