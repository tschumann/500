package game;

import java.util.ArrayList;

import java_card.Card;
import java_card.CardPlayer;
import java_card.ICard;

public abstract class AbstractPlayer extends CardPlayer
{
	protected ArrayList<ICard> hand;
	protected Team team;
	protected Game game;
	
	public AbstractPlayer(Team team, Game game)
	{
		this.hand = new ArrayList<ICard>(Game.HAND_SIZE);
		this.isDealer = false;
		this.team = team;
		this.game = game;
	}
	
	public Team getTeam()
	{
		return this.team;
	}
	
	public void receive(Card card)
	{
		this.hand.add(card);
	}
	
	public abstract Bid bid();
	public abstract ArrayList<ICard> processKitty(ArrayList<ICard> kitty);
}
