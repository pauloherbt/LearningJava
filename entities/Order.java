package entities;

import java.util.ArrayList;
import java.util.Date;

import entities.enums.OrderStatus;

public class Order {
	private Date moment;
	private OrderStatus orderStatus;
	private Client client;
	private ArrayList<OrderItem> items= new ArrayList<>();
	
	public Order(Client client,Date moment, OrderStatus orderStatus) {
		this.client=client;
		this.moment = moment;
		this.orderStatus = orderStatus;
	}
	public void addItem(OrderItem item) {
		this.items.add(item);
	}
	public void removeItem(OrderItem item) {
		this.items.remove(item);
	}
	public double total() {
		double soma=0;
		for (OrderItem item : items) {
			soma+=item.subTotal();
		}
		return soma;
	}
	public Date getMoment() {
		return moment;
	}
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}
	public Client getClient() {
		return client;
	}
	public ArrayList<OrderItem> getItems() {
		return items;
	}
	
}
