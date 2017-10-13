package game

import deck.FiveHundredCardSuit
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

class BidTestTest {

    @Test
    fun testGetAttributes() {
        val game = FiveHundredGame(0);
        val team = FiveHundredTeam(0)
        val player = Player(team, game);
        val count = 6;
        val suit = FiveHundredCardSuit.Suit.SPADE;
        val bid = Bid(count, FiveHundredCardSuit(suit), player);
        assertEquals(bid.number, count);
        assertEquals(bid.suit.suit, suit);
        assertNotNull(bid.player);
    }
}
