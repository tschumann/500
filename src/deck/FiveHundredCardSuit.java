package deck;

import java_card.ICardSuit;

public class FiveHundredCardSuit implements ICardSuit
{
	public enum Suit
	{
		SPADE,
		DIAMOND,
		CLUB,
		HEART,
		NO_TRUMP
	}
	
	public enum Colour
	{
		BLACK,
		RED
	}
	
	private Suit suit;
	
	public FiveHundredCardSuit(Suit spade)
	{
		this.suit = spade;
	}
	
	public int ordinal()
	{
		return suit.ordinal();
	}
	
	public Colour getColour()
	{
		switch(this.suit)
		{
		case SPADE:
			return Colour.BLACK;
		case DIAMOND:
			return Colour.RED;
		case CLUB:
			return Colour.BLACK;
		case HEART:
			return Colour.RED;
		}
		
		// should never get here - raise an exception?
		return null;
	}
}
