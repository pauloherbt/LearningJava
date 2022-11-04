package imposto;

public class PrivatePerson extends Person {
	private double healthSpending;
	
	public PrivatePerson(String name, double anualRent, double healthSpending) {
		super(name, anualRent);
		this.healthSpending=healthSpending;
	}

	@Override
	public double taxAmount() {
		double tax;
		if(super.getAnualRent()>=20000) {
			tax= 0.25;
		}
		else
			tax=0.15;
		return healthSpending>0? super.getAnualRent()*tax-(healthSpending*(0.5)):super.getAnualRent()*tax;
	}
	public String toString() {
		return super.getName()+"Tax: "+taxAmount()+"\n";
	}

}
