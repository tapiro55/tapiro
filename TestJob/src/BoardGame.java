import Exception.IllegalArgument;

public class BoardGame extends Product implements PlayAble {
	// Instance Variables
	
	protected int soldierNum;
	protected boolean isDice;
	protected boolean isCards;
	
	// Constructor
	
	public BoardGame(int year, double price, String pName,int soldierNum,boolean isDice,boolean isCards)
			throws IllegalArgument {
		super(year, price, pName);
		setSoldierNum(soldierNum);
		this.isCards=isCards;
		this.isDice=isDice;
	}

	// Setters & Getters
	
	@Override
	public void setYear(int year) throws IllegalArgument {
		if(year > 1950)
			this.year=year;
		else throw new IllegalArgument("Year isnt illgeal");
	}

	@Override
	public void setPrice(double price) throws IllegalArgument{
		if(price >= 30 && price <= 120)
			this.price=price;
		else throw new IllegalArgument("Price Board Game isnt illegal");
	}
	
	public void setSoldierNum(int soldierNum) throws IllegalArgument {
		if(soldierNum >= 0)
		this.soldierNum = soldierNum;
		else throw new IllegalArgument("Soldier number isnt illegal");
	}

	public int getSoldierNum() {
		return soldierNum;
	}
	
	public boolean getIsDice(){
		return this.isDice;
	}
	
	public boolean getIsCards(){
		return this.isCards;
	}
	
	@Override
	public boolean equals(Object other) {
		return (super.equals(other) && getSoldierNum() == (((BoardGame)other).getSoldierNum()) &&
				getIsCards() == (((BoardGame)other).getIsCards()) && getIsDice() == (((BoardGame)other).getIsDice()));
	}
	
	@Override
	public String toString() {
		return (super.toString()+ "Ther number of Soldier Game is: "+soldierNum+"\nThis game have Dick: "+isDice+
				"\nThis game have Cards: "+isCards+"\n");
	}

	@Override
	public boolean singlePlayer() {
		return getSoldierNum() > 1;
	}
}
