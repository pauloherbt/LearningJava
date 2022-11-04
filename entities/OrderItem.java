package entities;

public class OrderItem {
	private int quantity;
	private Product product;
	
	public OrderItem(Product product,int quantity) {
		this.product=product;
		this.quantity = quantity;
	}

	public double subTotal() {
		return quantity*product.getPrice();
	}

	public int getQuantity() {
		return quantity;
	}

	public Product getProduct() {
		return product;
	}
	
}
