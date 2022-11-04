package trycatch;

import java.util.Scanner;

import trycatch.exceptions.withdrawException;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter account data");
			System.out.println("Name:");
			String holder = sc.nextLine();
			System.out.println("number");
			int number = sc.nextInt();
			System.out.println("Initial Balance");
			double balance = sc.nextDouble();
			System.out.println("Withdraw Limit");
			double limit = sc.nextDouble();
			Account ac = new Account(holder, number, balance, limit);
			System.out.println("Insert amount to withdraw");
			double amount = sc.nextDouble();
			ac.withdraw(amount);
			System.out.println("Balance: "+String.format("%.2f",ac.getBalance() ));
		} 
		catch (withdrawException e) {
			System.out.println(e.getMessage());
			for (StackTraceElement string : e.getStackTrace()) {
				System.out.println(string);
			}
		}
		catch(RuntimeException e) {
			System.out.println("Unexpected Error");
		}
	}
}
