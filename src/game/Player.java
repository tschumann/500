package game;

import java.util.ArrayList;
import java.util.List;

import deck.FiveHundredCardSuit;
import deck.FiveHundredCardSuit.Suit;

import java_card.CardPlay;
import java_card.ICard;

public class Player extends AbstractPlayer
{
	public Player(FiveHundredTeam team, FiveHundredGame game)
	{
		super(team, game);
	}
	
	public Bid bid()
	{
		int number = Bid.MIN_NUMBER;
		FiveHundredCardSuit suit = new FiveHundredCardSuit(Suit.SPADE);
		
		return new Bid(number, suit, this);
	}
	
	public void receive(ICard card)
	{
		this.hand.add(card);		
	}
	
	public ICard play(List<CardPlay> played)
	{
		return this.hand.get(0);
	}
	
	public FiveHundredTeam getTeam()
	{
		return this.team;
	}
	
	/*
	 * Do nothing - the physical player will
	 * see and remember what they can.
	 */
	public void seePlayedCards(List<CardPlay> played)
	{
	}
	
	public ArrayList<ICard> processKitty(ArrayList<ICard> kitty)
	{
		return kitty;
	}
}
