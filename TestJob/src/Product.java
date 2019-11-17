
import java.io.Serializable;

import Exception.IllegalArgument;

public abstract class Product implements Serializable {
	
	private static int count = 0;
	protected int year;
	protected double price;
	protected String pName;
	protected int catalogNumber;

	public Product(int year, double price, String pName) throws IllegalArgument {
		setYear(year);
		setPrice(price);
		setpName(pName);
		count++;
		this.catalogNumber = count;
	}

	public int getCatalogNumber() {
		return catalogNumber;
	}
	public int getYear() {
		return year;
	}

	public double getPrice() {
		return price;
	}

	public String getpName() {
		return pName;
	}

	public abstract void setYear(int year) throws IllegalArgument;
		/*if((year > 1000 && year < 2019) && CheckYear(year))
			this.year = year;
	}
	public boolean CheckYear(int Year) {
		if(Character.isAlphabetic(year)) {
			return false;
		}
		return true;
	}
	*/
	public abstract void setPrice(double price) throws IllegalArgument;
	

	public void setpName(String pName) throws IllegalArgument {
		if(pName.length() > 2)
			this.pName = pName;
		else throw new IllegalArgument("Name product isnt illegal");
	}


	public boolean equals(Object other) {
		return(other instanceof Product) && getYear() == (((Product)other).getYear()) && getPrice() == (((Product)other).getPrice())&&
				getCatalogNumber() == (((Product)other).catalogNumber) && getpName().equals(((Product)other).getpName());
	}

	public String toString() {
		return(this.getClass().getName()+"\nThe Catalog Number :"+ catalogNumber+"\nThe year of Product: "+year
				+"\nThe price of Product: "+price+"\nThe Name of Product: "+pName);
	}
	
	/*public String stringToCsv() {
		return "Catalog Number, Product Name, Year, Price";
	}
	
	public String getValueToCsv() {
		return (getCatalogNumber()+","+getpName()+","+getYear()+","+getPrice());
	}*/
	

}
