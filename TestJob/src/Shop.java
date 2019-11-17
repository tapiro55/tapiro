
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Shop implements Serializable{

	protected String shopName;
	ArrayList<Product>products;

	public Shop(String shopName) {
		products = new ArrayList<Product>();
	}

	public String getShopName() {
		return shopName;
	}

	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setShopName(String shopName) {  // ���� ��� �����
		if(shopName.length() > 3)
			this.shopName = shopName;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}

	public void addProduct(Product p) {   // ������� ������ ����
		if (!(products.contains(p)))      // ���� �� ����� �� ���� ������ �����. ���� ����� ����� ������
			products.add(p);

		else
			System.out.println("This Proudct Is Already In The Proudcts List.");
	}

	public void removeProduct(Product p) {  // ������� ����� ����
		if (products.contains(p))			// ���� �� ����� ���� ������ �� ���� ����. ���� ����� ����� ������
			products.remove(p);

		else
			System.out.println("This Product Is Already Not In The Proudct List.");
	}

	public Product findTheCheapestProduct() {  // ������� ������ ����� ���� �����
		Product chepestProudct = products.get(0); // ����� ���� ����, ����� �� ������� �� ���� ����� 0.
		for (Product p : products) {				// ����� �� ����� �������
			if(p.getPrice() < chepestProudct.getPrice())  
				chepestProudct= p; // �� ����� �� ����� ��� ������ �� ����� ������. ����� �� ������
		}
		return chepestProudct; // ����� ����� ���� �����
	}
	

	public String findTheNewestProducts() {  // ������� ������ ������� ������ ������
		String message ="";       
		for (Product p : products) {
			if(p.getYear() >= 2015 )
				message +=p+"\n";
		}
		return message;
	}

	public int audioBooksgetNumOf() {      // ������� ������ ����� �������� ������ �������
		int countBook=0;
		for (Product aBook : products) {   // ����� �� ����� �������
			if(aBook instanceof AudioBook) // ����� ��� ����� ���� ����� ��������
				countBook++;
		}
		return countBook;
	}

	public ArrayList<Book> searchByNumOfPages(int num) { // ������� ������ ����� ��� ���� ������
		ArrayList<Book> Books = new ArrayList<>();   // ����� ����� ���� ����
		for (Product numBook : products) {
			if((numBook instanceof Book) && (((Book) numBook).getPageNum() >= num)) // ���� ����� ���� ��� ��� ��� �� ���� ������ ��� �������
				Books.add((Book) numBook); // �� ����� ������ ����� ������ �����
		}
		Collections.sort(Books);  //  ����� ��� ���� �� ���� ����
		return Books;
	}
	
	public ArrayList<AudioBook> searchBLenghtAudio(double len){
		ArrayList<AudioBook> aBook = new ArrayList<AudioBook>();
		for(Product auBood : products) {
			if((auBood instanceof AudioBook)&& (((AudioBook)auBood).getRecordingLength()>=len))
				aBook.add((AudioBook)auBood);
		}
		Collections.sort(aBook);
		return aBook;
	}

	public int getTotalMegabytes() {  // ������� ������ ���� ���� �� ��� ����
		int totalMb=0;
		for (Product size : products) {
			if(size instanceof Video_Audio) // ���� �� ����� ���� ����� �� ����� �����
				totalMb += ((Video_Audio) size).fileSize;
		}
		return totalMb;
	}

	public String toString() {
		String strToReturn = "";
		for (int i = 0; i < products.size(); i ++) {
			strToReturn += products.get(i);
			if (!(products.get(i).equals(products.get(products.size() - 1))))
				strToReturn += "\n\n";
		}	
		return strToReturn;
	}

	public void saveToCsv() throws FileNotFoundException {
		String strToReturn = "Catalog Number, Product Name, Year, Price";
		PrintWriter outFile = new PrintWriter("ProductDetails.csv");
		outFile.println(strToReturn);

		for (Product Pp : products) {
			outFile.print(Pp.getCatalogNumber());
			outFile.print(","+ Pp.getpName());
			outFile.print(","+Pp.getYear());
			outFile.print(","+Pp.getPrice());

			outFile.println();
		}
		outFile.close();
	}

		public void saveDataTxt() throws IOException {
			ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Shop.txt"));
			output.writeObject(this);
			output.close();
		}

		public Shop loadDataTxt() throws ClassNotFoundException, IOException{
			ObjectInputStream input = new ObjectInputStream(new FileInputStream("Shop.txt"));
			return (Shop)(input.readObject());
		}

	/*public void saveToCsv(String name) throws FileNotFoundException {
		PrintWriter outFile = new PrintWriter(name + ".csv");
		
		for (Product Pp : products) {
			outFile.println(Pp.stringToCsv());
			outFile.println(Pp.getValueToCsv());
			
		}
		outFile.close();
	}*/
}
