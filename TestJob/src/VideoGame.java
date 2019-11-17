import Exception.IllegalArgument;

public class VideoGame extends Video_Audio implements PlayAble {

	protected boolean singleP;
	protected TypeGame typeGame;
	protected ManufacturerCompany manufacturerCompany;

	public VideoGame(int year, double price, String pName,int fileSize,boolean download,
			boolean singleP,TypeGame typeGame,ManufacturerCompany manufacturerCompany) throws IllegalArgument {
		super(year, price, pName, fileSize, download);
		this.singleP= singleP;
		this.typeGame=typeGame;
		this.manufacturerCompany=manufacturerCompany;
	}

	public boolean getisSingleP() {
		return singleP;
	}

	public TypeGame getTypeGame() {
		return typeGame;
	}

	public ManufacturerCompany getManufacturerCompany() {
		return manufacturerCompany;
	}

	@Override
	public void setFileSize(int fileSize) throws IllegalArgument{
		if(fileSize >=1 && fileSize <= 60000) //Exception
			this.fileSize=fileSize;
		else throw new IllegalArgument("File Size is illegal");
	}

	@Override
	public void setYear(int year) throws IllegalArgument {
		if(year > 2000) //Exception
			this.year=year;
		else throw new IllegalArgument("Year is illegal");
	}

	@Override
	public void setPrice(double price) throws IllegalArgument{
		if((price > 0 && price <= 550) || price == 0) //Exception
			this.price=price;
		else throw new IllegalArgument("Price is illegal");
	}

	@Override
	public boolean equals(Object other) {
		return(super.equals(other) && getisSingleP() == (((VideoGame)other).singleP) &&
				getTypeGame() == (((VideoGame)other).typeGame) && getManufacturerCompany() == (((VideoGame)other).manufacturerCompany));
	}

	@Override
	public String toString() {
		return (super.toString()+ "This game gave Single Player: "+singleP+"\nThe Type of Game: "+typeGame+
				"\nThe Manufacturer Company is: "+manufacturerCompany+"\n");
	}

	@Override
	public boolean singlePlayer() {
		return getisSingleP();
	}
	
	

}
