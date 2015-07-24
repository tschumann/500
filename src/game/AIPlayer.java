package game;

import java.util.ArrayList;

import deck.Card;

public class AIPlayer
{
	private ArrayList<Card> hand;
	
	public Bid bid()
	{
		int spades = 0;
		int diamonds = 0;
		int clubs = 0;
		int hearts = 0;
		int number = 0;
		int suit = 0;
		boolean hasJoker = false;
		
		for (Card card: hand)
		{
			switch(card.getSuit())
			{
			case Card.Suit.SPADE:
				spades++;
			case Card.Suit.DIAMOND:
				diamonds++;
			case Card.Suit.CLUB:
				clubs++;
			case Card.Suit.HEART:
				hearts++;
			case Game.KEPT_JOKER_SUIT:
				hasJoker = true;
			}
		}
		
		// if we have the joker
		if( hasJoker )
		{
			// we can definitely win a hand with it, so increment the bid
			number++;
		}
		
		return new Bid(number, suit);
	}
}
