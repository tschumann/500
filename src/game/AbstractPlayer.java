package game;

import java.util.ArrayList;

import java_card.Card;
import java_card.CardPlayer;
import java_card.ICard;

public abstract class AbstractPlayer extends CardPlayer
{
	protected ArrayList<ICard> hand;
	protected FiveHundredTeam team;
	protected FiveHundredGame game;
	
	public AbstractPlayer(FiveHundredTeam team, FiveHundredGame game)
	{
		this.hand = new ArrayList<ICard>(FiveHundredGame.HAND_SIZE);
		this.team = team;
		this.game = game;
	}
	
	public FiveHundredTeam getTeam()
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
