package game;

import java.util.ArrayList;

import deck.Deck;
import deck.Card;
import deck.Card.Rank;
import deck.Card.Suit;

public class Game
{
	public static final int HAND_SIZE = 10;
	public static final int NUMBER_OF_HANDS = 10;
	public static final int KITTY_SIZE = 3;
	public static final int WINNING_SCORE = 500;
	public static final int LOSING_SCORE = -500;
	public static final Suit REMOVED_JOKER_SUIT = Suit.BLACK;
	public static final Suit KEPT_JOKER_SUIT = Suit.RED;
	
	public static final int NONE = 101;
	public static final int MISERE = 102;
	public static final int OPEN_MISERE = 103;
	
	private ArrayList<Card> kitty;
	private Deck deck;
	private ArrayList<IPlayer> players;
	private ArrayList<Team> teams;
	private int[] playerOrder;
	private Suit trumpSuit;
	private int misere;
	
	public Game(int bots)
	{
		this.kitty = new ArrayList<Card>(KITTY_SIZE);
		this.deck = new Deck(true);
		this.players = new ArrayList<IPlayer>(4);
		this.teams = new ArrayList<Team>(2);
		this.teams.add(new Team(1));
		this.teams.add(new Team(2));
		
		// TODO: allow multiple human players?
		players.add(new Player(this.teams.get(0)));
		
		for( int i = 1; i < 4; i++ )
		{
			players.add(new AIPlayer(this.teams.get(i % 2)));
		}
		
		trumpSuit = Suit.NO_TRUMP;
		misere = NONE;
		
		// remove the unused cards from the deck
		deck.remove(Suit.SPADE, Rank.TWO);
		deck.remove(Suit.DIAMOND, Rank.TWO);
		deck.remove(Suit.CLUB, Rank.TWO);
		deck.remove(Suit.HEART, Rank.TWO);
		deck.remove(Suit.SPADE, Rank.THREE);
		deck.remove(Suit.DIAMOND, Rank.THREE);
		deck.remove(Suit.CLUB, Rank.THREE);
		deck.remove(Suit.HEART, Rank.THREE);
		deck.remove(REMOVED_JOKER_SUIT, Rank.JOKER);
	}
	
	public void deal()
	{
		// deal three cards to each player
		for( int i = 0; i < players.size(); i++ )
		{
			players.get(i).receive(deck.draw(false));
			players.get(i).receive(deck.draw(false));
			players.get(i).receive(deck.draw(false));
		}
		
		// deal a card to the kitty
		kitty.add(deck.draw(false));
		
		// deal four cards to each player
		for( int i = 0; i < players.size(); i++ )
		{
			players.get(i).receive(deck.draw(false));
			players.get(i).receive(deck.draw(false));
			players.get(i).receive(deck.draw(false));
			players.get(i).receive(deck.draw(false));
		}
		
		// deal a card to the kitty
		kitty.add(deck.draw(false));
		
		// deal three cards to each player
		for( int i = 0; i < players.size(); i++ )
		{
			players.get(i).receive(deck.draw(false));
			players.get(i).receive(deck.draw(false));
			players.get(i).receive(deck.draw(false));
		}
		
		// deal a card to the kitty
		kitty.add(deck.draw(false));
	}
	
	public IPlayer hand()
	{
		ArrayList<Card> hand = new ArrayList<Card>(4);
		// let the best card is the first card by default
		Card bestCard = hand.get(0);
		// let the winning player be the player who played the first card be default
		IPlayer winner = this.players.get(this.playerOrder[0]);
		
		for( int i = 0; i < playerOrder.length; i++ )
		{
			// get the currently played cards
			Card played[] = hand.toArray(new Card[hand.size()]);
			// get the next player to play a card based on the already dealt cards
			hand.add(this.players.get(i).play(played));
		}
		
		// if it's no trumps
		if( trumpSuit == Suit.NO_TRUMP )
		{
			// look at each card
			for( int i = 0; i < hand.size(); i++ )
			{
				Card card = hand.get(i);
				
				// if the next card is higher than the current best
				if( card.getRank().ordinal() > bestCard.getRank().ordinal() )
				{
					// it is now the next best card
					bestCard = hand.get(i);
				}
			}
		}
		else
		{
			// if it's a misere hand
			if( misere == MISERE || misere == OPEN_MISERE )
			{
				//
			}
			else
			{
				for( int i = 0; i < hand.size(); i++ )
				{
					Card card = hand.get(i);
					
					// if the next card is a trump and the best isn't a trump
					if( card.getSuit() == trumpSuit && bestCard.getSuit() != trumpSuit )
					{
						// the next card is the next best
						bestCard = card;
					}
					else
					{
						if( card.getSuit() == bestCard.getSuit() && card.getRank().ordinal() > bestCard.getRank().ordinal() )
						{
							bestCard = card;
						}
					}
				}
			}
		}
		
		return winner;
	}
	
	public Bid bidding()
	{
		// TODO: get the player with the highest bid, then reorder the players to make them first, the person on the other team next etc
		return players.get(0).bid();
	}
	
	public ArrayList<Card> kitty(IPlayer player)
	{
		return player.processKitty(kitty);
	}
	
	public void play()
	{
		// to keep track of who wins each hand
		ArrayList<IPlayer> winners = new ArrayList<IPlayer>(NUMBER_OF_HANDS);
		
		deal();
		Bid bid = bidding();
		kitty(players.get(0));
		
		for( int i = 0; i < NUMBER_OF_HANDS; i++ )
		{
			winners.add(hand());
		}
		
		for( IPlayer winner: winners )
		{
			if( winner.getTeam().getId() == 1 )
			{
				this.team1().addWin();
			}
			else
			{
				this.team2().addWin();
			}
		}
		
		if( players.get(0).getTeam().getId() == 1 )
		{
			if( this.team1().getWins() >= bid.getNumber() )
			{
				// TODO: the bid was met
			}
			else
			{
				// TODO: the bid failed
			}
		}
		else
		{
			if( this.team2().getWins() >= bid.getNumber() )
			{
				// TODO: the bid was met
			}
			else
			{
				// TODO: the bid failed
			}
		}
		
		if( this.team1().getScore() >= WINNING_SCORE )
		{
			// TODO:
		}
		else if( this.team2().getScore() >= WINNING_SCORE )
		{
			// TODO:
		}
		else if( this.team1().getScore() <= LOSING_SCORE )
		{
			// TODO:
		}
		else if( this.team2().getScore() <= LOSING_SCORE )
		{
			// TODO:
		}
	}
	
	private Team team1()
	{
		return this.teams.get(0);
	}
	
	private Team team2()
	{
		return this.teams.get(1);
	}
}
