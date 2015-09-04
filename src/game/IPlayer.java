package game;

import java.util.ArrayList;

import deck.Card;

public interface IPlayer
{
	public boolean getIsDealer();
	public Team getTeam();
	public Bid bid();
	public void receive(Card card);
	public Card play(ArrayList<Card> played);
	public ArrayList<Card> processKitty(ArrayList<Card> kitty);
}
