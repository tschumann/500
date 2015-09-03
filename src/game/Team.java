package game;

import java.util.ArrayList;

public class Team
{
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
	
	public void addPlayer(IPlayer player)
	{
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
