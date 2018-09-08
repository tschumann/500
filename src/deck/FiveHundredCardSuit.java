package deck;

import java_card.ICardSuit;

/**
 * Make this a class because enums can't be extended
 */
public class FiveHundredCardSuit implements ICardSuit
{
	public enum Suit
	{
		SPADE,
		DIAMOND,
		CLUB,
		HEART,
		NO_TRUMP,
		BLACK // use the black joker
	}
	
	private Suit suit;
	
	public FiveHundredCardSuit(Suit suit)
	{
		this.suit = suit;
	}

	public Suit getSuit()
	{
		return suit;
	}
	
	public int ordinal()
	{
		return suit.ordinal();
	}
}
