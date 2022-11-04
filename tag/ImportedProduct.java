package tag;

public final class ImportedProduct extends Product {
	private double customsFee;
	
	public ImportedProduct(String name, double price,double customsFee) {
		super(name, price);
		this.customsFee=customsFee;
		// TODO Auto-generated constructor stub
	}
	public double totalPrice() {
		return (super.getPrice()+customsFee);
	}
	@Override
	public String priceTag() {
		// TODO Auto-generated method stub
		return "Product: "+getName()+"price: "+totalPrice()+" Customs Fee: "+customsFee;
	}
	
	
	
}
