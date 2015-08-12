package game;

import deck.Card.Suit;

public class Bid
{
	public static final int MIN_NUMBER = 6;
	
	private int number;
	private Suit suit;
	
	public Bid(int number, Suit suit)
	{
		assert number < MIN_NUMBER;
		assert suit != Suit.RED;
		assert suit != Suit.BLACK;

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
	
	/*
	 * Return true if this bid is better than the given bid.
	 */
	public boolean isBetter(Bid bid)
	{
		// if the suits are the same but the number is higher
		if( this.suit == bid.suit && this.number > bid.number )
		{
			// this bid is better
			return true;
		}
		
		// if the suit is better but the number is the same
		if( this.suit.ordinal() > bid.suit.ordinal() && this.number == bid.number )
		{
			// this bid is better
			return true;
		}
		
		return false;
	}
}
