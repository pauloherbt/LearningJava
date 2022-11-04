package enums4;

import java.util.Date;

public class HourContract {
	private Date date;
	private double valueperHour;
	private Integer hours;
	
	public HourContract(Date date, double valueperHour, Integer hours) {
		this.date = date;
		this.valueperHour = valueperHour;
		this.hours = hours;
	}
	public double totalValue() {
		return hours*valueperHour;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}
