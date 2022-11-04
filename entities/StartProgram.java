package entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.enums.OrderStatus;

public class StartProgram {

	public void run() {
		Scanner sc = new Scanner(System.in);
		Order order = loadOrder(sc);
		System.out.println(orderSumary(order));
	}

	public Order loadOrder(Scanner sc) {
		Client client = loadClient(sc);
		System.out.println("Enter order data:");
		System.out.println("Status:");
		OrderStatus status = OrderStatus.valueOf(sc.nextLine());
		Date orderDate = new Date();
		Order order = new Order(client, orderDate, status);
		System.out.println("How many items to this order?");
		int n = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < n; i++) {
			order.addItem(loadItem(sc));
		}
		return order;
	}

	private OrderItem loadItem(Scanner sc) {
		System.out.println("Enter product data");
		System.out.println("Product name:");
		String name = sc.nextLine();
		System.out.println("Price:");
		double price = sc.nextDouble();
		Product product = new Product(name, price);
		System.out.println("Quantity:");
		int quantity = sc.nextInt();
		sc.nextLine();
		return new OrderItem(product, quantity);
	}

	public Client loadClient(Scanner sc) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Enter client data");
		System.out.println("Name:");
		String name = sc.nextLine();
		System.out.println("Email:");
		String email = sc.nextLine();
		System.out.println("Date: dd/MM/yyyy");
		Date date = new Date();
		try {
			date = sdf.parse(sc.nextLine());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("INPUT ERROR");
			e.printStackTrace();
		}
		return new Client(name, email, date);

	}

	public String orderSumary(Order order) {
		StringBuilder sb = new StringBuilder();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf1= new SimpleDateFormat();
		sb.append("Order Sumary\n");
		sb.append("Order Moment: " + sdf1.format(order.getMoment()) + "\n");
		sb.append("Order Status: " + order.getOrderStatus() + "\n");
		sb.append("Client: " + order.getClient().getName() + " (" + sdf.format(order.getClient().getBirthday()) + ")");
		sb.append("- " + order.getClient().getEmail() + "\n");
		sb.append("Order Items:");
		for (OrderItem item : order.getItems()) {
			sb.append("\n");
			sb.append(item.getProduct().getName());
			sb.append(", $");
			sb.append(item.getProduct().getPrice());
			sb.append(", Quantity: ");
			sb.append(item.getQuantity());
			sb.append(", Subtotal: $");
			sb.append(item.subTotal());
		}
		sb.append("\nTotal price: $");
		sb.append(order.total());

		return sb.toString();
	}
}
