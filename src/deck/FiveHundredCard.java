package deck;

import game.FiveHundredGame;
import java_card.Card;

public class FiveHundredCard extends Card
{
	public static final FiveHundredCardSuit spades = new FiveHundredCardSuit(FiveHundredCardSuit.Suit.SPADE);
	public static final FiveHundredCardSuit diamonds = new FiveHundredCardSuit(FiveHundredCardSuit.Suit.DIAMOND);
	public static final FiveHundredCardSuit clubs = new FiveHundredCardSuit(FiveHundredCardSuit.Suit.CLUB);
	public static final FiveHundredCardSuit hearts = new FiveHundredCardSuit(FiveHundredCardSuit.Suit.HEART);
	public static final FiveHundredCardSuit notrumps = new FiveHundredCardSuit(FiveHundredCardSuit.Suit.NO_TRUMP);
	public static final FiveHundredCardSuit black = new FiveHundredCardSuit(FiveHundredCardSuit.Suit.BLACK);

	public int compareTo(Card card)
	{
		// TODO: implement
		return 0;
	}
	
	/*
	 * Whether this card is of the trump suit
	 */
	public boolean isTrump()
	{
		FiveHundredGame game = (FiveHundredGame)this.getGame();

		// TODO: check for no trumps

		return this.getSuit() == game.trump();
	}
}
