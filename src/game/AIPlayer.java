package game;

import java.util.ArrayList;

import deck.Card;
import deck.Card.Rank;
import deck.Card.Suit;

public class AIPlayer extends Player implements IPlayer 
{
	private ArrayList<Card> hand;
	
	public Bid bid(Bid previousBid)
	{
		int spades = numberOfSuit(Suit.SPADE);
		int diamonds = numberOfSuit(Suit.DIAMOND);
		int clubs = numberOfSuit(Suit.CLUB);
		int hearts = numberOfSuit(Suit.HEART);
		int highCards = numberOfHighCards();
		int number = 0;
		Suit suit = Suit.SPADE;
		
		// if we have a lot of high cards
		if( highCards >= 5 )
		{
			// bid no trumps
			suit = Suit.NO_TRUMP;
			number += highCards;
		}
		else 
		{
			// if we have the joker
			if( hasJoker() )
			{
			// we can definitely win a hand with it, so increment the bid
				number++;
			}
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
	
	private int numberOfSuit(Suit suit)
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
	
	private int numberOfHighCards()
	{
		int count = 0;
		
		for( int i = 0; i < hand.size(); i++ )
		{
			if( hand.get(i).getRank().ordinal() >= Rank.JACK.ordinal() )
			{
				count++;
			}
		}
		
		return count;
	}
}
