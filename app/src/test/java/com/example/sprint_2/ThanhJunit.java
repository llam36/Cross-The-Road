package com.example.sprint_2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ThanhJunit {

    private Player player;

    @Before
    public void setUp() {
        player = new Player("Hard", "testName", R.drawable.chicken);
    }
    @Test
    public void checkPlayerLife() {
        assertTrue(player.getLives() == 6);
        player = new Player("Medium", "testName", R.drawable.chicken);
        assertTrue(player.getLives() == 8);
        player = new Player("Easy", "testName", R.drawable.chicken);
        assertTrue(player.getLives() == 10);
    }
    @Test
    public void checkPlayerSprite() {
        assertTrue(player.getImageOption() == R.drawable.chicken);
        player.setImageOption(R.drawable.duck);
        assertTrue(player.getImageOption() == R.drawable.duck);
        player.setImageOption(R.drawable.rabbit);
        assertTrue(player.getImageOption() == R.drawable.rabbit);
    }
}