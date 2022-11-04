package tag;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends Product{
	private Date date;
	
	public UsedProduct(String name, double price,Date date) {
		super(name, price);
		this.date=date;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String priceTag() {
		SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");// TODO Auto-generated method stub
		return super.priceTag()+" Manufacture Date: "+sdf.format(date) ;
	}
	
}
