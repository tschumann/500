package deck;

public class Card
{
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
	
	private Suit suit;
	private Rank rank;
	
	public Card(Suit suit, Rank rank)
	{
		this.suit = suit;
		this.rank = rank;
	}
	
	public Rank getRank()
	{
		return rank;
	}
	
	public Suit getSuit()
	{
		return suit;
	}
}
