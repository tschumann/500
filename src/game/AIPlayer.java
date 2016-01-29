package game;

import java.util.ArrayList;
import java.util.Collection;

import java_card.Card;
import java_card.ICard;

import deck.FiveHundredCardSuit;
import deck.Card.Rank;
import deck.Card.Suit;

public class AIPlayer extends Player
{
	private ArrayList<Card> memory;
	
	public AIPlayer(Team team, Game game)
	{
		super(team, game);
		memory = new ArrayList<Card>();
	}
	
	public Bid bid(Bid previousBid)
	{
		int spades = numberOfSuit(FiveHundredCardSuit.FiveHundredSuit.SPADE);
		int diamonds = numberOfSuit(FiveHundredCardSuit.FiveHundredSuit.DIAMOND);
		int clubs = numberOfSuit(FiveHundredCardSuit.FiveHundredSuit.CLUB);
		int hearts = numberOfSuit(FiveHundredCardSuit.FiveHundredSuit.HEART);
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
	
	public ICard play(Collection<ICard> played)
	{
		// TODO: find the most appropriate card based on what has been played
		return this.hand.get(0);
	}
	
	public void seePlayedHand(Collection<ICard> hand)
	{
		// TODO: remember memorable cards - add a skill attribute to affect this?
	}
	
	public ArrayList<ICard> processKitty(ArrayList<ICard> kitty)
	{
		ArrayList<ICard> disposals = new ArrayList<ICard>(3);
		
		for( ICard card: kitty )
		{
			/*
			if( card.getRank() == CardRank.JOKER )
			{
				// TODO: find the worst card and swap it for the Joker
			}
			*/
		}
		
		return disposals;
	}
	
	private boolean hasJoker()
	{
		for( ICard card: hand )
		{
			/*
			if( card.getSuit() == Game.KEPT_JOKER_SUIT )
			{
				return true;
			}
			*/
		}
		
		return false;
	}
	
	private int numberOfSuit(FiveHundredCardSuit.FiveHundredSuit suit)
	{
		int count = 0;
		
		for( int i = 0; i < hand.size(); i++ )
		{
			/*
			if( hand.get(i).getSuit() == suit )
			{
				count++;
			}
			*/
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
