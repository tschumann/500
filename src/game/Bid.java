package game;

public class Bid
{
	private int number;
	private int suit;
	
	public Bid(int number, int suit)
	{
		this.number = number;
		this.suit = suit;
	}
	
	public int getNumber()
	{
		return this.number;
	}
	
	public int getSuit()
	{
		return this.suit;
	}
}
