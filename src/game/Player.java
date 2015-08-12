package game;

import java.util.ArrayList;

import deck.Card;
import deck.Card.Suit;

public class Player implements IPlayer
{
	private ArrayList<Card> hand;
	private boolean isDealer;
	private int team;
	
	public Player(int team)
	{
		this.hand = new ArrayList<Card>(Game.HAND_SIZE);
		this.isDealer = false;
		this.team = team;
	}
	
	public boolean getIsDealer()
	{
		return this.isDealer;
	}
	
	public int getTeam()
	{
		return this.team;
	}
	
	public void setIsDealer(boolean isDealer)
	{
		this.isDealer = isDealer;
	}
	
	public void receive(Card card)
	{
		hand.add(card);
	}
	
	public Bid bid()
	{
		int number = 6;
		Suit suit = Suit.SPADE;
		
		return new Bid(number, suit);
	}
	
	public Card play(Card[] played)
	{
		return this.hand.get(0);
	}
	
	public ArrayList<Card> processKitty(ArrayList<Card> kitty)
	{
		return kitty;
	}
}
