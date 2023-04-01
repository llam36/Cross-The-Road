package com.example.sprint_2;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class DorsaJunitTest {
    private Player player;
    private Map map;
    @Before
    public void setUp() {
        player = new Player("Hard","MyName",0);
        map = new Map("Hard", player);
    }
    @Test
    public void checkThenull() {
        assertTrue(player.isNullName(null) == true);
        assertTrue(player.isNullName("MyName") == false);
    }
    @Test
    public void checkThewhiteSpace() {
        assertTrue(player.isWhiteSpaceOnlyName("") == true);
        assertTrue(player.isWhiteSpaceOnlyName("MyName") == false);

    }
    @Test
    public void checkTheScoreUp() {
        int x = player.getScore() + 1;
        player.updateScore(map,"up");
        assertEquals(x,player.getScore());
    }
    @Test
    public void checkTheScoreDown() {
        int x = player.getScore();
        player.updateScore(map,"down");
        assertEquals(x,player.getScore());
    }

}