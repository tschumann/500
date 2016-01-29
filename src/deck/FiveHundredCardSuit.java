package deck;

import java_card.CardSuit;

public class FiveHundredCardSuit implements CardSuit
{
	public enum FiveHundredSuit
	{
		SPADE,
		DIAMOND,
		CLUB,
		HEART
	}
	
	private FiveHundredSuit suit;
	
	public FiveHundredCardSuit(FiveHundredSuit suit)
	{
		this.suit = suit;
	}
	
	public int ordinal()
	{
		return suit.ordinal();
	}
}
