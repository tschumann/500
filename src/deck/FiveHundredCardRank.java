package deck;

import java_card.ICardRank;

/**
 * Make this a class because enums can't be extended
 */
public class FiveHundredCardRank implements ICardRank
{
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

	private Rank rank;

	public FiveHundredCardRank(Rank rank)
	{
		this.rank = rank;
	}

	public Rank getSuit()
	{
		return rank;
	}

	public int ordinal()
	{
		return rank.ordinal();
	}
}
