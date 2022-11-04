package tag;

public class Product {
	private String name;
	private double price;
	
	public Product(String name, double price) {
		this.name = name;
		this.price = price;
	}
	public String priceTag() {
		return "Product: "+ name+" price:"+ price;
	}
	public double getPrice() {
		return price;
	}
	public String getName() {
		return name;
	}
	
	
}
