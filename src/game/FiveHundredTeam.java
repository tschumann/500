package game;

import java.util.ArrayList;

import java_card.ICardPlayer;
import java_card.Team;

public class FiveHundredTeam extends Team
{
	public static final int MAX_PLAYERS = 2;
	
	private int id;
	private int score;
	private ArrayList<ICardPlayer> players;
	
	public FiveHundredTeam(int id)
	{
		this.id = id;
		this.score = 0;
		this.wins = 0;
		this.players = new ArrayList<ICardPlayer>(2);
	}
	
	public int getId()
	{
		return this.id;
	}
	
	public int getScore()
	{
		return this.score;
	}
	
	public void addPlayer(ICardPlayer player) throws Exception
	{
		// if there's an attempt to add too many players
		if( this.players.size() == MAX_PLAYERS )
		{
			throw new Exception();
		}
		
		this.players.add(player);
	}
	
	public void addPoints(int points)
	{
		this.score += points;
	}
	
	public void addWin()
	{
		this.wins += 1;
	}
}
