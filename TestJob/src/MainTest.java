

import java.io.IOException;
import java.util.ArrayList;

import Exception.GeneralException;

public class MainTest {

	public static void main(String[] args) {
		try {
		Shop shopList = new Shop("ASOS");
		Author author1 = new Author("123456789", "Aviv", "Tapiro", 26, "Male");
		Author author2 = new Author("484686611", "Tal", "Yanon", 26, "Female");
		
		Author[] authorList = new Author[2];
		authorList[0] = author1;
		authorList[1] = author2;
		
		
		Book book1 = new Book(authorList[0], 1980, 76, "Harry Potter", 590, typeBook.Action);
		Book book2 = new Book(authorList[1], 2006, 89, "Pinokyo", 74, typeBook.ScienceFiction);
		Book book3 = new Book(authorList[0], 1997, 76, "Hero", 301, typeBook.Humor);
		BoardGame boardGame1 = new BoardGame(2001, 102, "Rami", 1, true, false);
		BoardGame boardGame2 = new BoardGame(1978, 46, "Monapol", 4, false, true);
		AudioBook audioBook1 = new AudioBook(2016, 88, "Fire", 25000, true, "Time", 12.6);
		AudioBook audioBook2 = new AudioBook(2015, 99, "Snow", 4000, false, "Soccer", 6.9);
		VideoGame videoGame1 = new VideoGame(2016, 110, "Call of duty", 52000, true, true, TypeGame.Action, ManufacturerCompany.EA);
		VideoGame videoGame2 = new VideoGame(2008, 150, "Fifa", 58000, false, true, TypeGame.Sport, ManufacturerCompany.EA);
		VideoGame videoGame3 = new VideoGame(2010, 105, "Far cry", 4980, true, false, TypeGame.Adventure, ManufacturerCompany.Rockstar);
		
		
		
		shopList.addProduct(book1);
		shopList.addProduct(book2);
		shopList.addProduct(book3);
		shopList.addProduct(boardGame1);
		shopList.addProduct(boardGame2);
		shopList.addProduct(audioBook1);
		shopList.addProduct(audioBook2);
		shopList.addProduct(videoGame1);
		shopList.addProduct(videoGame2);
		shopList.addProduct(videoGame3);
		
		System.out.println(shopList.searchBLenghtAudio(6));
		
		
		
		
		
		//System.out.println(shopList); // The List products
		
		/*shopList.saveToCsv();
		
		shopList.removeProduct(videoGame3); // Remove product
		System.out.println(shopList.findTheCheapestProduct()); // The Cheapest Product
		System.out.println(shopList.findTheNewestProducts());  // Product form 2015
		System.out.println("The comunt of Audio Book in List: "+shopList.audioBooksgetNumOf()); // The number of Audio Book in List
		System.out.println(shopList.searchByNumOfPages(300)); // The Books have more then 300 pages
		System.out.println("The total Megabytes is: "+shopList.getTotalMegabytes()); // Total Megabyte
		System.out.println("If can play Single Player: "+"\nCall of duty: "+videoGame1.singleP);  // If can play single Player in videogame1
		System.out.println("If can Play together :"+"\nRami: "+boardGame1.singlePlayer()); // If can play together in boargame1
		
		shopList.saveDataTxt();
		Shop newShop = shopList.loadDataTxt();
		System.out.println(newShop);
	
		//shopList.saveToCsv("Car List");  
		
		
		System.out.println("Done!");
		*/
		}
		catch (GeneralException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		/*
		catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		*/
		
		

	}

}
