
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

	public void setShopName(String shopName) {  // תנאי לשם החנות
		if(shopName.length() > 3)
			this.shopName = shopName;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}

	public void addProduct(Product p) {   // פונקציה להוספת מוצר
		if (!(products.contains(p)))      // תנאי אם המוצר לא נמצא ברשימה תוסיף. אחרת תוציא הודעה מתאימה
			products.add(p);

		else
			System.out.println("This Proudct Is Already In The Proudcts List.");
	}

	public void removeProduct(Product p) {  // פונקציה להסרת מוצר
		if (products.contains(p))			// תנאי אם המוצר נמצא ברשימה אז תסיר אותו. אחרת תוציא הודעה מתאימה
			products.remove(p);

		else
			System.out.println("This Product Is Already Not In The Proudct List.");
	}

	public Product findTheCheapestProduct() {  // פונקציה למציאת המוצר הזול ביותר
		Product chepestProudct = products.get(0); // משתנה מסוג מוצר, שמקבל את הנתונים של מוצר במקום 0.
		for (Product p : products) {				// לולאה על רשימת המוצרים
			if(p.getPrice() < chepestProudct.getPrice())  
				chepestProudct= p; // אם המחיר של המוצר קטן מהמחיר של המוצר בלולאה. תחליף את המשתנה
		}
		return chepestProudct; // החזרת המוצר הזול ביותר
	}
	

	public String findTheNewestProducts() {  // פונקציה למציאת המוצרים מתאריך מסויים
		String message ="";       
		for (Product p : products) {
			if(p.getYear() >= 2015 )
				message +=p+"\n";
		}
		return message;
	}

	public int audioBooksgetNumOf() {      // פונקציה לספירת ספרים מוקליטים ברשימת המוצרים
		int countBook=0;
		for (Product aBook : products) {   // לולאה על רשימת המוצרים
			if(aBook instanceof AudioBook) // בדיקה האם המוצר מסוג ספרים מוקליטים
				countBook++;
		}
		return countBook;
	}

	public ArrayList<Book> searchByNumOfPages(int num) { // פונקציה לחיפוש ספרים מעל עמוד מסויים
		ArrayList<Book> Books = new ArrayList<>();   // רשימת ספרים בלבד חדשה
		for (Product numBook : products) {
			if((numBook instanceof Book) && (((Book) numBook).getPageNum() >= num)) // תנאי שמוצר מסוג ספר וגם שיש לו יותר עמודים ממה שמבקשים
				Books.add((Book) numBook); // אם התנאי מתקיים תוסיף לרשימה החדשה
		}
		Collections.sort(Books);  //  הדפסת לפי הספר עם יותר דפים
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

	public int getTotalMegabytes() {  // פונקציה לחישוב גודל כולל של מגה בייט
		int totalMb=0;
		for (Product size : products) {
			if(size instanceof Video_Audio) // תנאי אם המוצר מסוג וידאו או אודיו תמשיך
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
