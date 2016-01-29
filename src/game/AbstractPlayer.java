package game;

import java.util.ArrayList;

import java_card.Card;
import java_card.ICard;
import java_card.ICardPlayer;

public abstract class AbstractPlayer implements ICardPlayer
{
	protected ArrayList<ICard> hand;
	protected boolean isDealer;
	protected Team team;
	protected Game game;
	
	public AbstractPlayer(Team team, Game game)
	{
		this.hand = new ArrayList<ICard>(Game.HAND_SIZE);
		this.isDealer = false;
		this.team = team;
		this.game = game;
	}
	
	public boolean getIsDealer()
	{
		return this.isDealer;
	}
	
	public Team getTeam()
	{
		return this.team;
	}
	
	public void setIsDealer(boolean isDealer)
	{
		this.isDealer = isDealer;
	}
	
	public void receive(Card card)
	{
		this.hand.add(card);
	}
}
