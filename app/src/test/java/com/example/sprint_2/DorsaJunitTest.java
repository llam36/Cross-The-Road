package com.example.sprint_2;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class DorsaJunitTest {
    private Player player;
    @Before
    public void setUp() {
        player = new Player("Hard","MyName",0);
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
}