package enums4;

import java.util.ArrayList;
import java.util.Calendar;

import enums4.enums.WorkerLevel;

public class Worker {
	private String name;
	private WorkerLevel workerLevel;
	private double baseSalary;
	private ArrayList<HourContract> contracts;

	public Worker(String name, WorkerLevel workerLevel, double baseSalary) {
		this.name = name;
		this.workerLevel = workerLevel;
		this.baseSalary = baseSalary;
		this.contracts = new ArrayList<>();
	}

	public void addContract(HourContract contract) {
		this.contracts.add(contract);
	}

	public void removeContract(HourContract contract) {
		this.contracts.remove(contract);
	}

	public double income(Integer month, Integer year) {
		double monthSomatory=0;
		for (HourContract hourContract : contracts) {
			monthSomatory+=calculateContract(month, year, hourContract);
		}
		return baseSalary+monthSomatory;
	}

	private double calculateContract(Integer month, Integer year,HourContract contract) {
		Calendar dataConvertida = convertDate(contract);
		if (month.equals(dataConvertida.get(Calendar.MONTH))) {
			if (year.equals(dataConvertida.get(Calendar.YEAR))) {
				return contract.totalValue();
			}
		}
		return 0;
	}

	public Calendar convertDate(HourContract contract) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(contract.getDate());
		return calendar;
	}

	public ArrayList<HourContract> getContracts() {
		return contracts;
	}

	public String getName() {
		return name;
	}
	
}
