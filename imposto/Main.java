package imposto;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO-generated method stub
		ArrayList<Person> contributors= new ArrayList<>();
		Scanner sc= new Scanner(System.in); //entrada de dados
		String verify;
		System.out.println("Insert contributors amount");
		int n=sc.nextInt();
		for (int i = 0; i <n; i++) {
			System.out.printf("Contributor %d Data\n", i+1);
			System.out.println("LegalPerson or PrivatePerson? [L/P]");
			verify=sc.next();
			System.out.println("Name?");
			String name = sc.next();
			System.out.println("Anual Rent?");
			double anualRent=sc.nextDouble();
			if(verify.equals("L")) {
				System.out.println("Employers Amount?");
				int employers_Amount=sc.nextInt();
				contributors.add(new LegalPerson(name, anualRent, employers_Amount));
			}
			else {
				System.out.println("Health Spendings?");
				double healthSpendings=sc.nextDouble();
				contributors.add(new PrivatePerson(name, anualRent, healthSpendings));
			}
		}
		System.out.println("TAXES PAID:");
		double totalTax=0;
		for (Person person : contributors) {
			System.out.println(person.toString());
			totalTax+=person.taxAmount();
		}
		System.out.println("Total Taxes: "+totalTax);

	}

}
