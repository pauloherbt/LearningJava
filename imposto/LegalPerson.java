package imposto;

public class LegalPerson extends Person {
	private int employesAmount;
	
	public LegalPerson(String name, double anualRent,int employesAmount) {
		super(name, anualRent);
		this.employesAmount=employesAmount;
	}

	@Override
	public double taxAmount() {
		double tax=0;
		if(employesAmount>10) {
			tax=0.14;
		}
		else
			tax=0.16;
		return super.getAnualRent()*tax;
	}

	@Override
	public String toString() {
		return super.getName() + "Tax: "+String.format("%.2f", taxAmount())+"\n";
	}

}
