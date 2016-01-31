package game;

import java.util.ArrayList;
import java.util.Collection;

import deck.FiveHundredCardSuit;
import deck.FiveHundredCardSuit.Suit;

import java_card.ICard;

public class Player extends AbstractPlayer
{
	public Player(Team team, Game game)
	{
		super(team, game);
	}
	
	public Bid bid()
	{
		int number = 6;
		FiveHundredCardSuit suit = new FiveHundredCardSuit(Suit.SPADE);
		
		return new Bid(number, suit, this);
	}
	
	public void receive(ICard card)
	{
		this.hand.add(card);		
	}
	
	public ICard play(Collection<ICard> played)
	{
		return this.hand.get(0);
	}
	
	public Team getTeam()
	{
		return this.team;
	}
	
	/*
	 * Do nothing - the physical player will
	 * see and remember what they can.
	 */
	public void seePlayedHand(Collection<ICard> hand)
	{
	}
	
	public ArrayList<ICard> processKitty(ArrayList<ICard> kitty)
	{
		return kitty;
	}
}
