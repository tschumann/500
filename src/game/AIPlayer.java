package game;

import java.util.ArrayList;

import deck.Card;

public class AIPlayer extends Player implements IPlayer 
{
	private ArrayList<Card> hand;
	
	public Bid bid()
	{
		int spades = numberOfSuit(Card.Suit.SPADE);
		int diamonds = numberOfSuit(Card.Suit.DIAMOND);
		int clubs = numberOfSuit(Card.Suit.CLUB);
		int hearts = numberOfSuit(Card.Suit.HEART);
		int number = 0;
		int suit = Card.Suit.SPADE;
		
		// if we have the joker
		if( hasJoker() )
		{
			// we can definitely win a hand with it, so increment the bid
			number++;
		}
		
		return new Bid(number, suit);
	}
	
	public Card play()
	{
		return this.hand.get(0);
	}
	
	private boolean hasJoker()
	{
		for (Card card: hand)
		{
			if( card.getSuit() == Game.KEPT_JOKER_SUIT)
			{
				return true;
			}
		}
		
		return false;
	}
	
	private int numberOfSuit(int suit)
	{
		int count = 0;
		
		for( int i = 0; i < hand.size(); i++ )
		{
			if( hand.get(i).getSuit() == suit )
			{
				count++;
			}
		}
		
		return count;
	}
	
	private int numberOfHighCards(int suit)
	{
		int count = 0;
		
		for( int i = 0; i < hand.size(); i++ )
		{
			if( hand.get(i).getSuit() == suit )
			{
				count++;
			}
		}
		
		return count;
	}
}
