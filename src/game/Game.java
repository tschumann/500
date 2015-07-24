package game;

import java.util.ArrayList;

import deck.Deck;
import deck.Card;
import deck.Card.Rank;
import deck.Card.Suit;

public class Game
{
	public static final int HAND_SIZE = 10;
	public static final int KITTY_SIZE = 3;
	public static final int REMOVED_JOKER_SUIT = Suit.BLACK;
	public static final int KEPT_JOKER_SUIT = Suit.RED;
	
	public static final int NO_TRUMP = 100;
	public static final int NONE = 101;
	public static final int MISERE = 102;
	public static final int OPEN_MISERE = 103;
	
	private ArrayList<Card> kitty;
	private Deck deck;
	private Player[] players;
	private int[] playerOrder;
	private int trump;
	private int misere;
	
	public Game()
	{
		kitty = new ArrayList<Card>(KITTY_SIZE);
		deck = new Deck(true);
		players = new Player[4];
		trump = NO_TRUMP;
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
		for( int i = 0; i < players.length; i++ )
		{
			players[i].receive(deck.draw(false));
			players[i].receive(deck.draw(false));
			players[i].receive(deck.draw(false));
		}
		
		// deal a card to the kitty
		kitty.add(deck.draw(false));
		
		// deal four cards to each player
		for( int i = 0; i < players.length; i++ )
		{
			players[i].receive(deck.draw(false));
			players[i].receive(deck.draw(false));
			players[i].receive(deck.draw(false));
			players[i].receive(deck.draw(false));
		}
		
		// deal a card to the kitty
		kitty.add(deck.draw(false));
		
		// deal three cards to each player
		for( int i = 0; i < players.length; i++ )
		{
			players[i].receive(deck.draw(false));
			players[i].receive(deck.draw(false));
			players[i].receive(deck.draw(false));
		}
		
		// deal a card to the kitty
		kitty.add(deck.draw(false));
	}
	
	public Player hand()
	{
		ArrayList<Card> hand = new ArrayList<Card>(4);
		// assume that the best card is the first card
		Card bestCard = hand.get(0);
		// assume that the winning player is the player who played the first hand
		Player winner = this.players[this.playerOrder[0]];
		
		for( int i = 0; i < playerOrder.length; i++ )
		{
			hand.add(this.players[i].play());
		}
		
		// if it's no trumps
		if( this.trump == NO_TRUMP )
		{
			// look at each card
			for( int i = 0; i < hand.size(); i++ )
			{
				Card card = hand.get(i);
				
				// if the next card is higher than the current best
				if( card.getRank() > bestCard.getRank() )
				{
					// it is now the next best card
					bestCard = hand.get(i);
				}
			}
		}
		else
		{
			// if it's a misere hand
			if( this.misere == MISERE || this.misere == OPEN_MISERE )
			{
				//
			}
			else
			{
				for( int i = 0; i < hand.size(); i++ )
				{
					Card card = hand.get(i);
					
					// if the next card is a trump and the best isn't a trump
					if( card.getSuit() == trump && bestCard.getSuit() != this.trump )
					{
						// the next card is the next best
						bestCard = card;
					}
					else
					{
						if( card.getSuit() == bestCard.getSuit() && card.getRank() > bestCard.getRank() )
						{
							bestCard = card;
						}
					}
				}
			}
		}
		
		return winner;
	}
}
