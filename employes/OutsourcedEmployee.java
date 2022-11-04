package employes;

public class OutsourcedEmployee extends Employee {
	private double additional;
	
	public OutsourcedEmployee(String name, int workedTime, double valueOfHour, double additional) {
		super(name, workedTime, valueOfHour);
		this.additional=additional;
		// TODO Auto-generated constructor stub
	}

	@Override
	public double payment() {
		// TODO Auto-generated method stub
		return (double)super.payment()+(1.1*additional);
	}
	
	

}
