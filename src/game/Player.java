package game;

import java.util.ArrayList;

import deck.Card;
import deck.Card.Suit;

public class Player extends AbstractPlayer
{
	public Player(Team team, Game game)
	{
		super(team, game);
	}
	
	public Bid bid()
	{
		int number = 6;
		Suit suit = Suit.SPADE;
		
		return new Bid(number, suit, this);
	}
	
	public Card play(ArrayList<Card> played)
	{
		return this.hand.get(0);
	}
	
	public ArrayList<Card> processKitty(ArrayList<Card> kitty)
	{
		return kitty;
	}
}
