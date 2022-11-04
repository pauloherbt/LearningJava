package enums4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import enums4.enums.WorkerLevel;

public class SetupWorkers {
	public void run() {
		ArrayList<Worker> workers = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		loadWorkers(sc, workers);
		for (Worker worker : workers) {
			System.out.println("Enter a month and a year to calculate income(MM/yyyy):");
			sc.nextLine();
			Date date = convertDataNoDays(sc.nextLine());
			System.out.println(printWorker(worker,date));
			
		}
	}
	private String printWorker(Worker worker, Date date) {
		SimpleDateFormat sdf= new SimpleDateFormat("MM/yyyy");
		return "Name "+worker.getName()+
				"\nIncome for "+(sdf.format(date))+": "+searchWorkerIncome(worker, date);
	}
	private double searchWorkerIncome(Worker worker,Date date) {
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(date);
		return worker.income(calendar.get(Calendar.MONTH),calendar.get(Calendar.YEAR));
		}

	private Date convertDataNoDays(String dateString) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/yyyy");
		try {
			return sdf.parse(dateString);
		} catch (ParseException e) {
			System.out.println("Input error");
			e.printStackTrace();
		}
		return null;

	}

	private void loadWorkers(Scanner sc, ArrayList<Worker> workers) {
		System.out.println("How many workers to add?");
		int n = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < n; i++) {
			workers.add(loadWorkerdata(sc, i));
		}
	}

	private Worker loadWorkerdata(Scanner sc, int i) {
		System.out.printf("Enter worker #%d data:\n", i + 1);
		System.out.println("Name?");
		String name = sc.nextLine();
		System.out.println("Level?");
		String level = sc.nextLine();
		System.out.println("Base salary?");
		double salary = sc.nextDouble();
		Worker worker = new Worker(name, WorkerLevel.valueOf(level), salary);
		System.out.println("How many contracts to this worker?");
		loadContracts(sc.nextInt(), sc, worker);
		return worker;
	}

	private void loadContracts(int n, Scanner sc, Worker worker) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		for (int j = 0; j < n; j++) {
			sc.nextLine();
			System.out.printf("Enter contract #%d data", j + 1);
			System.out.println("Date (DD/MM/YYYY)");
			Date date = null;
			try {
				date = sdf.parse(sc.nextLine());
			} catch (ParseException e) {
				System.out.println("Input Error");
				e.printStackTrace();
			}
			System.out.println("Value per Hour?");
			double value = sc.nextDouble();
			System.out.println("duration (hours)");
			int hours = sc.nextInt();
			worker.addContract(new HourContract(date, value, hours));
		}
	}
}
