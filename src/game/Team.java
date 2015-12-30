package game;

import java.util.ArrayList;

public class Team
{
	public static final int MAX_PLAYERS = 2;
	
	private int id;
	private int score;
	private int wins;
	private ArrayList<IPlayer> players;
	
	public Team(int id)
	{
		this.id = id;
		this.score = 0;
		this.wins = 0;
		this.players = new ArrayList<IPlayer>(2);
	}
	
	public int getId()
	{
		return this.id;
	}
	
	public int getScore()
	{
		return this.score;
	}
	
	public int getWins()
	{
		return this.wins;
	}
	
	public void addPlayer(IPlayer player) throws Exception
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
