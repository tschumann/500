package deck;

import java.util.ArrayList;

import java_card.ICard;
import java_card.ICardSuit;

public class Deck
{
	public static final int INITIAL_DECK_SIZE = 54;
	
	private ArrayList<ICard> deck;
	
	public Deck(boolean jokers)
	{
		deck = new ArrayList<ICard>(INITIAL_DECK_SIZE);

		ICardSuit spade = new FiveHundredCardSuit(FiveHundredCardSuit.Suit.SPADE);

		if( jokers )
		{
			// deck.add(new Card(Suit.BLACK, Rank.JOKER));
			// deck.add(new Card(Suit.RED, Rank.JOKER));
		}
		// deck.add(new Card(spade, Rank.ACE));
		// deck.add(new Card(spade, Rank.TWO));
		// deck.add(new Card(spade, Rank.THREE));
		// deck.add(new Card(spade, Rank.FOUR));
		// deck.add(new Card(spade, Rank.FIVE));
		// deck.add(new Card(spade, Rank.SIX));
		// deck.add(new Card(spade, Rank.SEVEN));
		// deck.add(new Card(spade, Rank.EIGHT));
		// deck.add(new Card(spade, Rank.NINE));
		// deck.add(new Card(spade, Rank.TEN));
		// deck.add(new Card(spade, Rank.JACK));
		// deck.add(new Card(spade, Rank.QUEEN));
		// deck.add(new Card(spade, Rank.KING));
		// deck.add(new Card(Suit.DIAMOND, Rank.ACE));
		// deck.add(new Card(Suit.DIAMOND, Rank.TWO));
		// deck.add(new Card(Suit.DIAMOND, Rank.THREE));
		// deck.add(new Card(Suit.DIAMOND, Rank.FOUR));
		// deck.add(new Card(Suit.DIAMOND, Rank.FIVE));
		// deck.add(new Card(Suit.DIAMOND, Rank.SIX));
		// deck.add(new Card(Suit.DIAMOND, Rank.SEVEN));
		// deck.add(new Card(Suit.DIAMOND, Rank.EIGHT));
		// deck.add(new Card(Suit.DIAMOND, Rank.NINE));
		// deck.add(new Card(Suit.DIAMOND, Rank.TEN));
		// deck.add(new Card(Suit.DIAMOND, Rank.JACK));
		// deck.add(new Card(Suit.DIAMOND, Rank.QUEEN));
		// deck.add(new Card(Suit.DIAMOND, Rank.KING));
		// deck.add(new Card(Suit.CLUB, Rank.ACE));
		// deck.add(new Card(Suit.CLUB, Rank.TWO));
		// deck.add(new Card(Suit.CLUB, Rank.THREE));
		// deck.add(new Card(Suit.CLUB, Rank.FOUR));
		// deck.add(new Card(Suit.CLUB, Rank.FIVE));
		// deck.add(new Card(Suit.CLUB, Rank.SIX));
		// deck.add(new Card(Suit.CLUB, Rank.SEVEN));
		// deck.add(new Card(Suit.CLUB, Rank.EIGHT));
		// deck.add(new Card(Suit.CLUB, Rank.NINE));
		// deck.add(new Card(Suit.CLUB, Rank.TEN));
		// deck.add(new Card(Suit.CLUB, Rank.JACK));
		// deck.add(new Card(Suit.CLUB, Rank.QUEEN));
		// deck.add(new Card(Suit.CLUB, Rank.KING));
		// deck.add(new Card(Suit.HEART, Rank.ACE));
		// deck.add(new Card(Suit.HEART, Rank.TWO));
		// deck.add(new Card(Suit.HEART, Rank.THREE));
		// deck.add(new Card(Suit.HEART, Rank.FOUR));
		// deck.add(new Card(Suit.HEART, Rank.FIVE));
		// deck.add(new Card(Suit.HEART, Rank.SIX));
		// deck.add(new Card(Suit.HEART, Rank.SEVEN));
		// deck.add(new Card(Suit.HEART, Rank.EIGHT));
		// deck.add(new Card(Suit.HEART, Rank.NINE));
		// deck.add(new Card(Suit.HEART, Rank.TEN));
		// deck.add(new Card(Suit.HEART, Rank.JACK));
		// deck.add(new Card(Suit.HEART, Rank.QUEEN));
		// deck.add(new Card(Suit.HEART, Rank.KING));
	}
	
	/*
	 * @arg leave: whether or not to leave the card in the deck after drawing
	 */
	public FiveHundredCard draw(boolean leave)
	{
		return draw(leave, 0);
	}
	
	/*
	 * @arg leave: whether or not to leave the card in the deck after drawing
	 * @arg index: what number card to draw
	 */
	public FiveHundredCard draw(boolean leave, int index)
	{
		ICard card = null;
		
		if( leave )
		{
			card = deck.get(index);
		}
		else
		{
			card = deck.remove(index);
		}
		
		return (FiveHundredCard)card;
	}
	
	public void remove(FiveHundredCardSuit suit, FiveHundredCardRank rank)
	{
		for( int i = 0; i < deck.size(); i++ )
		{
			// get the card at the given index
			ICard card = this.draw(true, i);
			
			// if it's the card that needs to be removed
			if( card.getSuit() == suit && card.getRank() == rank )
			{
				// remove it from the deck
				this.draw(false, i);
			}
		}
	}
	
	public void shuffle()
	{
		ArrayList<ICard> shuffled = new ArrayList<ICard>(INITIAL_DECK_SIZE);
		
		for( int i = 0; i < this.deck.size(); i++ )
		{
			// draw a card with random index and it add it to the shuffled array
			shuffled.add(this.draw(false, util.Util.random(0, this.deck.size())));
		}
		
		this.deck = shuffled;
	}
}
