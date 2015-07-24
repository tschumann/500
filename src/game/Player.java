package game;

import java.util.ArrayList;

import deck.Card;

public class Player
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
		int suit = Card.Suit.SPADE;
		
		return new Bid(number, suit);
	}
	
	public Card play()
	{
		return this.hand.get(0);
	}
}
