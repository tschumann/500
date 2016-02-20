package game;

import java.util.ArrayList;

import java_card.CardGame;
import java_card.CardPlay;
import java_card.ICard;
import java_card.ICardPlayer;

import deck.Deck;
import deck.FiveHundredCardSuit;
import deck.FiveHundredCardSuit.Suit;

public class FiveHundredGame extends CardGame
{
	public static final int HAND_SIZE = 10;
	public static final int NUMBER_OF_HANDS = 10;
	public static final int KITTY_SIZE = 3;
	public static final int WINNING_SCORE = 500;
	public static final int LOSING_SCORE = -500;
	// public static final Suit REMOVED_JOKER_SUIT = Suit.BLACK;
	// public static final Suit KEPT_JOKER_SUIT = Suit.RED;
	public static final int PLAYER_COUNT = 4;
	
	public static final int NONE = 101;
	public static final int MISERE = 102;
	public static final int OPEN_MISERE = 103;
	
	private Deck deck;
	private ArrayList<ICard> kitty;
	private ArrayList<ICard> hand;
	private ArrayList<ICardPlayer> players;
	private ArrayList<FiveHundredTeam> teams;
	private Suit trumpSuit;
	private int misere;
	
	// TODO: just reorder this.players?
	private int[] playerOrder;
	
	public FiveHundredGame(int bots)
	{
		this.kitty = new ArrayList<ICard>(KITTY_SIZE);
		this.deck = new Deck(true);
		this.players = new ArrayList<ICardPlayer>(FiveHundredGame.PLAYER_COUNT);
		this.teams = new ArrayList<FiveHundredTeam>(FiveHundredTeam.MAX_PLAYERS);
		this.teams.add(new FiveHundredTeam(1, FiveHundredTeam.MAX_PLAYERS));
		this.teams.add(new FiveHundredTeam(2, FiveHundredTeam.MAX_PLAYERS));
		
		// TODO: allow multiple human players?
		players.add(new Player(this.teams.get(0), this));
		
		for( int i = 1; i < 4; i++ )
		{
			players.add(new AIPlayer(this.teams.get(i % 2), this));
		}
		
		trumpSuit = Suit.NO_TRUMP;
		misere = NONE;
		
		// remove the unused cards from the deck
		
		/*
		deck.remove(Suit.SPADE, Rank.TWO);
		deck.remove(Suit.DIAMOND, Rank.TWO);
		deck.remove(Suit.CLUB, Rank.TWO);
		deck.remove(Suit.HEART, Rank.TWO);
		deck.remove(Suit.SPADE, Rank.THREE);
		deck.remove(Suit.DIAMOND, Rank.THREE);
		deck.remove(Suit.CLUB, Rank.THREE);
		deck.remove(Suit.HEART, Rank.THREE);
		deck.remove(REMOVED_JOKER_SUIT, Rank.JOKER);
		*/
	}
	
	public void deal()
	{
		// deal three cards to each player
		for( int i = 0; i < players.size(); i++ )
		{
			// players.get(i).receive(deck.draw(false));
			// players.get(i).receive(deck.draw(false));
			// players.get(i).receive(deck.draw(false));
		}
		
		// deal a card to the kitty
		// kitty.add(deck.draw(false));
		
		// deal four cards to each player
		for( int i = 0; i < players.size(); i++ )
		{
			// players.get(i).receive(deck.draw(false));
			// players.get(i).receive(deck.draw(false));
			// players.get(i).receive(deck.draw(false));
			// players.get(i).receive(deck.draw(false));
		}
		
		// deal a card to the kitty
		// kitty.add(deck.draw(false));
		
		// deal three cards to each player
		for( int i = 0; i < players.size(); i++ )
		{
			// players.get(i).receive(deck.draw(false));
			// players.get(i).receive(deck.draw(false));
			// players.get(i).receive(deck.draw(false));
		}
		
		// deal a card to the kitty
		// kitty.add(deck.draw(false));
	}
	
	public ICardPlayer hand()
	{
		ArrayList<CardPlay> play = new ArrayList<CardPlay>(4);
		// let the best card be the first card by default
		ICard bestCard = hand.get(0);
		// let the winning player be the player who played the first card be default
		ICardPlayer winner = this.players.get(this.playerOrder[0]);
		
		for( int i = 0; i < playerOrder.length; i++ )
		{
			Player player = (Player)this.players.get(i);
			// get the player to play a card based on the currently played cards,
			// then add the card they played to the list of currently played cards
			play.add(new CardPlay(player, player.play(play), this));
		}
		
		for( int i = 0; i < playerOrder.length; i++ )
		{
			this.players.get(i).seePlayedCards(play);
		}
		
		// if it's no trumps
		if( trumpSuit == Suit.NO_TRUMP )
		{
			// look at each card
			for( int i = 0; i < hand.size(); i++ )
			{
				ICard card = hand.get(i);
				
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
					ICard card = hand.get(i);
					
					// if the next card is a trump and the best isn't a trump
					
					/*
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
					*/
				}
			}
		}
		
		return winner;
	}
	
	public Bid bidding()
	{
		// TODO: get the player with the highest bid, then reorder the players to make them first, the person on the other team next etc
		return ((Player)players.get(0)).bid();
	}
	
	public ArrayList<ICard> kitty(ICardPlayer player)
	{
		return ((Player)player).processKitty(kitty);
	}
	
	public void play()
	{
		// to keep track of who wins each hand
		ArrayList<ICardPlayer> winners = new ArrayList<ICardPlayer>(NUMBER_OF_HANDS);
		
		deal();
		Bid bid = bidding();
		kitty(players.get(0));
		
		for( int i = 0; i < NUMBER_OF_HANDS; i++ )
		{
			winners.add(hand());
		}
		
		for( ICardPlayer winner: winners )
		{
			if( ((Player)winner).getTeam().getId() == 1 )
			{
				this.team1().addWin();
			}
			else
			{
				this.team2().addWin();
			}
		}
		
		if( ((Player)(players.get(0))).getTeam().getId() == 1 )
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
	
	public FiveHundredCardSuit trump()
	{
		return null;
	}
	
	private FiveHundredTeam team1()
	{
		return this.teams.get(0);
	}
	
	private FiveHundredTeam team2()
	{
		return this.teams.get(1);
	}
}
