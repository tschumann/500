package game;

import java_card.ICardPlayer;
import deck.FiveHundredCardSuit;

public class Bid
{
	public static final int MIN_NUMBER = 6;
	
	private int number;
	private FiveHundredCardSuit suit;
	private ICardPlayer player;
	
	public Bid(int number, FiveHundredCardSuit suit, ICardPlayer player)
	{
		assert number < MIN_NUMBER;

		this.number = number;
		this.suit = suit;
		this.player = player;
	}
	
	public int getNumber()
	{
		return this.number;
	}
	
	public FiveHundredCardSuit getSuit()
	{
		return this.suit;
	}
	
	public ICardPlayer getPlayer()
	{
		return this.player;
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
