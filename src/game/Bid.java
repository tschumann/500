package game;

import deck.Card.Suit;

public class Bid
{
	private int number;
	private Suit suit;
	
	public Bid(int number, Suit suit)
	{
		this.number = number;
		this.suit = suit;
	}
	
	public int getNumber()
	{
		return this.number;
	}
	
	public Suit getSuit()
	{
		return this.suit;
	}
}
