package employes;

public class Employee {
	private String name;
	private int workedTime;
	private double valueOfHour;
	
	public Employee(String name, int workedTime, double valueOfHour) {
		this.name = name;
		this.workedTime = workedTime;
		this.valueOfHour = valueOfHour;
	}
	
	public double payment() {
		return valueOfHour*workedTime;
	}

	public String getName() {
		return name;
	}

	public int getWorkedTime() {
		return workedTime;
	}

	public double getValueOfHour() {
		return valueOfHour;
	}
	
}
