package game;

import java.util.ArrayList;

import deck.Card;
import deck.Card.Rank;
import deck.Card.Suit;

public class AIPlayer extends Player implements IPlayer 
{
	private ArrayList<Card> memory;
	
	public AIPlayer(Team team, Game game)
	{
		super(team, game);
		memory = new ArrayList<Card>();
	}
	
	public Bid bid(Bid previousBid)
	{
		int spades = numberOfSuit(Suit.SPADE);
		int diamonds = numberOfSuit(Suit.DIAMOND);
		int clubs = numberOfSuit(Suit.CLUB);
		int hearts = numberOfSuit(Suit.HEART);
		int highCards = numberOfHighCards();
		int number = 6;
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
		
		return new Bid(number, suit, this);
	}
	
	public Card play(ArrayList<Card> played)
	{
		// TODO: find the most appropriate card based on what has been played
		return this.hand.get(0);
	}
	
	public void seePlayedHand(ArrayList<Card> hand)
	{
		// TODO: remember memorable cards - add a skill attribute to affect this?
	}
	
	public ArrayList<Card> processKitty(ArrayList<Card> kitty)
	{
		ArrayList<Card> disposals = new ArrayList<Card>(3);
		
		for( Card card: kitty )
		{
			if( card.getRank() == Card.Rank.JOKER )
			{
				// TODO: find the worst card and swap it for the Joker
			}
		}
		
		return disposals;
	}
	
	private boolean hasJoker()
	{
		for( Card card: hand )
		{
			if( card.getSuit() == Game.KEPT_JOKER_SUIT )
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
			// Jack or better is considered high
			if( hand.get(i).getRank().ordinal() >= Rank.JACK.ordinal() )
			{
				count++;
			}
		}
		
		return count;
	}
}
