package deck;

import java_card.Card;
import java_card.ICardRank;

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

	public int ordinal() {
		return 0;
	}

	public int compareTo(Card card)
	{
		// TODO: implement
		return 0;
	}
}
