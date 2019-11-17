import Exception.IllegalArgument;

public class Book extends Product implements Comparable<Book> {  


	private int pageNum;
	private typeBook typeBook;
	private Author author;

	public Book(Author author,int year, double price, String pName,int pageNum,typeBook typeBook) throws IllegalArgument {
		super(year, price, pName);
		setPrice(price);
		setYear(year);
		setPageNum(pageNum);
		this.author=author;
	}

	@Override
	public void setYear(int year) throws IllegalArgument {
		if(year > 1918)  //Exception
			this.year=year;
		else throw new IllegalArgument("Year is not illegal");
	}

	@Override
	public void setPrice(double price) throws IllegalArgument{
		if(price >= 20 && price <= 110) //Exception
			this.price=price;
		else throw new IllegalArgument("Price product isnt illegal");
	}

	public int getPageNum() {
		return pageNum;
	}

	public typeBook getTypeBook() {
		return typeBook;
	}

	public void setPageNum(int pageNum) throws IllegalArgument {
		if(pageNum >=0)
			this.pageNum = pageNum;
		else throw new IllegalArgument("Page number isnt illegal");
	}

	public void setTypeBook(typeBook typeBook) {
		this.typeBook = typeBook;
	}

	public Author getAuthor() {
		return author;
	}

	@Override
	public boolean equals(Object other) {
		return (super.equals(other) && getPageNum()==(((Book)other).pageNum) &&
				getTypeBook()==(((Book)other).typeBook) &&
				getAuthor().equals(((Book)other).getAuthor()));
	}

	@Override
	public String toString() {
		return (super.toString()+ "The count of pages: "+pageNum+"\n"+
				"The Type of Book is: "+ typeBook+"\n"+"The Author of Book is: "+ author);
	}
	@Override
	public int compareTo(Book other) {
		int diffPage = this.pageNum - other.getPageNum();
		if(diffPage < 0)
			return -1;
		if(diffPage > 0)
			return 1;
		if(diffPage == 0)
			return 0;
		return diffPage;
	}

	/*@Override
	public String stringToCsv() {
		return (super.stringToCsv()+"Page Number, Type Book");
	}
	
	@Override
	public String getValueToCsv() {
		return (super.getValueToCsv()+","+getPageNum()+","+getTypeBook());
	}*/

}
