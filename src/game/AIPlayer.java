package game;

import java.util.ArrayList;
import java.util.Collection;

import java_card.ICard;

import deck.FiveHundredCard;
import deck.FiveHundredCardSuit;

public class AIPlayer extends Player
{
	private ArrayList<ICard> memory;
	
	public AIPlayer(Team team, Game game)
	{
		super(team, game);
		this.memory = new ArrayList<ICard>();
	}
	
	public Bid bid(Bid previousBid)
	{
		int spades = numberOfSuit(FiveHundredCard.spades);
		int diamonds = numberOfSuit(FiveHundredCard.diamonds);
		int clubs = numberOfSuit(FiveHundredCard.clubs);
		int hearts = numberOfSuit(FiveHundredCard.hearts);
		int highCards = numberOfHighCards();
		int number = 6;
		FiveHundredCardSuit suit = FiveHundredCard.spades;
		
		// if we have a lot of high cards
		if( highCards >= 5 )
		{
			// bid no trumps
			suit = FiveHundredCard.notrumps;
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
	
	private int numberOfSuit(FiveHundredCardSuit suit)
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
			
			/*
			if( hand.get(i).getRank().ordinal() >= Rank.JACK.ordinal() )
			{
				count++;
			}
			*/
		}
		
		return count;
	}
}
