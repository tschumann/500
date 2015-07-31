package game;

import java.util.ArrayList;

import deck.Card;
import deck.Card.Suit;

public class Player implements IPlayer
{
	private ArrayList<Card> hand;
	private boolean isDealer;
	
	public Player()
	{
		hand = new ArrayList<Card>(Game.HAND_SIZE);
		isDealer = false;
	}
	
	public boolean getIsDealer()
	{
		return isDealer;
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
}
