package tag;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		Product x = new Product("Corsa", 100);
		Product y = new ImportedProduct("Caranga", 1200, 20);
		Date data = new Date();
		SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
		String date=sc.nextLine();
		data = sdf.parse(date);
		Product z = new UsedProduct("mt fogla", 1100, data);
		System.out.println(x.priceTag());
		System.out.println(y.priceTag());
		System.out.println(z.priceTag());
	}

}
