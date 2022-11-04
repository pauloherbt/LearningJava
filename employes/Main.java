package employes;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String flag = "";
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("quantos funcionarios?");
		int n=sc.nextInt();
		ArrayList<Employee> employes = new ArrayList<>();
		for (int i = 0; i <n; i++) {
			sc.nextLine();
			System.out.println("Outsorced?[y/n]");
			flag = sc.nextLine();
			if (flag.equals("y")) {
				System.out.println("name");
				String name = sc.nextLine();
				System.out.println("hours");
				int hours = sc.nextInt();
				System.out.println("value per hour");
				double value = sc.nextDouble();
				System.out.println("additional");
				double additional = sc.nextDouble();
				employes.add(new OutsourcedEmployee(name, hours, value, additional));
			} else {
				System.out.println("name");
				String name = sc.nextLine();
				System.out.println("hours");
				int hours = sc.nextInt();
				System.out.println("value per hour");
				double value = sc.nextDouble();
				employes.add(new Employee(name, hours, value));
			}
		}
		for (Employee employ : employes) {
			System.out.println(employ.getName()+" - $ "+String.format("%.2f", employ.payment()));
		}
	}
}
