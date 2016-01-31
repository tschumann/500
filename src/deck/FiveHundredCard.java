package deck;

import java_card.Card;

public class FiveHundredCard extends Card
{
	public static final FiveHundredCardSuit spades = new FiveHundredCardSuit(FiveHundredCardSuit.Suit.SPADE);
	public static final FiveHundredCardSuit diamonds = new FiveHundredCardSuit(FiveHundredCardSuit.Suit.DIAMOND);
	public static final FiveHundredCardSuit clubs = new FiveHundredCardSuit(FiveHundredCardSuit.Suit.CLUB);
	public static final FiveHundredCardSuit hearts = new FiveHundredCardSuit(FiveHundredCardSuit.Suit.HEART);
	public static final FiveHundredCardSuit notrumps = new FiveHundredCardSuit(FiveHundredCardSuit.Suit.NO_TRUMP);
	
	public enum Suit
	{
		SPADE,
		CLUB,
		DIAMOND,
		HEART,
		BLACK,
		RED,
		NO_TRUMP,
	}

	public enum Rank
	{
		TWO,
		THREE,
		FOUR,
		FIVE,
		SIX,
		SEVEN,
		EIGHT,
		NINE,
		TEN,
		JACK,
		QUEEN,
		KING,
		ACE,
		JOKER,
	}

	@Override
	public int compareTo(Card card) {
		// TODO: implement
		return 0;
	}
}
