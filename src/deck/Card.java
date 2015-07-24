package deck;

public class Card
{
	public class Suit
	{
		public static final int SPADE = 0;
		public static final int CLUB = 1;
		public static final int DIAMOND = 2;
		public static final int HEART = 3;
		public static final int BLACK = 10;
		public static final int RED = 11;
	}

	public class Rank
	{
		public static final int TWO = 0;
		public static final int THREE = 1;
		public static final int FOUR = 2;
		public static final int FIVE = 3;
		public static final int SIX = 4;
		public static final int SEVEN = 5;
		public static final int EIGHT = 6;
		public static final int NINE = 7;
		public static final int TEN = 8;
		public static final int JACK = 9;
		public static final int QUEEN = 10;
		public static final int KING = 11;
		public static final int ACE = 12;
		public static final int JOKER = 100;
	}
	
	private int suit;
	private int rank;
	
	public Card(int suit, int rank)
	{
		this.suit = suit;
		this.rank = rank;
	}
	
	public int getRank()
	{
		return rank;
	}
	
	public int getSuit()
	{
		return suit;
	}
}
