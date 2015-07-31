package deck;

import java.util.ArrayList;

import deck.Card.Rank;
import deck.Card.Suit;

public class Deck
{
	public static final int INITIAL_DECK_SIZE = 54;
	
	private ArrayList<Card> deck;
	
	public Deck(boolean jokers)
	{
		deck = new ArrayList<Card>(INITIAL_DECK_SIZE);
		
		// easier and probably faster to just add each card manually
		if( jokers )
		{
			deck.add(new Card(Suit.BLACK, Rank.JOKER));
			deck.add(new Card(Suit.RED, Rank.JOKER));
		}
		deck.add(new Card(Suit.SPADE, Rank.ACE));
		deck.add(new Card(Suit.SPADE, Rank.TWO));
		deck.add(new Card(Suit.SPADE, Rank.THREE));
		deck.add(new Card(Suit.SPADE, Rank.FOUR));
		deck.add(new Card(Suit.SPADE, Rank.FIVE));
		deck.add(new Card(Suit.SPADE, Rank.SIX));
		deck.add(new Card(Suit.SPADE, Rank.SEVEN));
		deck.add(new Card(Suit.SPADE, Rank.EIGHT));
		deck.add(new Card(Suit.SPADE, Rank.NINE));
		deck.add(new Card(Suit.SPADE, Rank.TEN));
		deck.add(new Card(Suit.SPADE, Rank.JACK));
		deck.add(new Card(Suit.SPADE, Rank.QUEEN));
		deck.add(new Card(Suit.SPADE, Rank.KING));
		deck.add(new Card(Suit.DIAMOND, Rank.ACE));
		deck.add(new Card(Suit.DIAMOND, Rank.TWO));
		deck.add(new Card(Suit.DIAMOND, Rank.THREE));
		deck.add(new Card(Suit.DIAMOND, Rank.FOUR));
		deck.add(new Card(Suit.DIAMOND, Rank.FIVE));
		deck.add(new Card(Suit.DIAMOND, Rank.SIX));
		deck.add(new Card(Suit.DIAMOND, Rank.SEVEN));
		deck.add(new Card(Suit.DIAMOND, Rank.EIGHT));
		deck.add(new Card(Suit.DIAMOND, Rank.NINE));
		deck.add(new Card(Suit.DIAMOND, Rank.TEN));
		deck.add(new Card(Suit.DIAMOND, Rank.JACK));
		deck.add(new Card(Suit.DIAMOND, Rank.QUEEN));
		deck.add(new Card(Suit.DIAMOND, Rank.KING));
		deck.add(new Card(Suit.CLUB, Rank.ACE));
		deck.add(new Card(Suit.CLUB, Rank.TWO));
		deck.add(new Card(Suit.CLUB, Rank.THREE));
		deck.add(new Card(Suit.CLUB, Rank.FOUR));
		deck.add(new Card(Suit.CLUB, Rank.FIVE));
		deck.add(new Card(Suit.CLUB, Rank.SIX));
		deck.add(new Card(Suit.CLUB, Rank.SEVEN));
		deck.add(new Card(Suit.CLUB, Rank.EIGHT));
		deck.add(new Card(Suit.CLUB, Rank.NINE));
		deck.add(new Card(Suit.CLUB, Rank.TEN));
		deck.add(new Card(Suit.CLUB, Rank.JACK));
		deck.add(new Card(Suit.CLUB, Rank.QUEEN));
		deck.add(new Card(Suit.CLUB, Rank.KING));
		deck.add(new Card(Suit.HEART, Rank.ACE));
		deck.add(new Card(Suit.HEART, Rank.TWO));
		deck.add(new Card(Suit.HEART, Rank.THREE));
		deck.add(new Card(Suit.HEART, Rank.FOUR));
		deck.add(new Card(Suit.HEART, Rank.FIVE));
		deck.add(new Card(Suit.HEART, Rank.SIX));
		deck.add(new Card(Suit.HEART, Rank.SEVEN));
		deck.add(new Card(Suit.HEART, Rank.EIGHT));
		deck.add(new Card(Suit.HEART, Rank.NINE));
		deck.add(new Card(Suit.HEART, Rank.TEN));
		deck.add(new Card(Suit.HEART, Rank.JACK));
		deck.add(new Card(Suit.HEART, Rank.QUEEN));
		deck.add(new Card(Suit.HEART, Rank.KING));
	}
	
	public int count()
	{
		return deck.size();
	}
	
	/*
	 * @arg leave: whether or not to leave the card in the deck after drawing
	 */
	public Card draw(boolean leave)
	{
		return draw(leave, 0);
	}
	
	/*
	 * @arg leave: whether or not to leave the card in the deck after drawing
	 * @arg index: what number card to draw
	 */
	public Card draw(boolean leave, int index)
	{
		Card card = null;
		
		if( leave == true )
		{
			card = deck.get(index);
		}
		else
		{
			card = deck.remove(index);
		}
		
		return card;
	}
	
	public void remove(Suit suit, Rank rank)
	{
		for( int i = 0; i < deck.size(); i++ )
		{
			// get the card at the given index
			Card card = this.draw(true, i);
			
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
		ArrayList<Card> shuffled = new ArrayList<Card>(INITIAL_DECK_SIZE);
		
		for( int i = 0; i < deck.size(); i++ )
		{
			shuffled.add(this.draw(false, util.Util.random(0, deck.size())));
		}
		
		deck = shuffled;
	}
}
