package com.example.sprint_2;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class DorsaJunitTest {
    private Player player;
    private Map map;
    private Obstacle obstacle;
    @Before
    public void setUp() {
        player = new Player("Hard","MyName",0);
        map = new Map("Hard", player);
        obstacle = new Obstacle(15,20,4,23,1);

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
    @Test
    public void checkThePositionAfterCollision(){
        while (!map.getLanes()[map.getPlayer().getPosY()].getType().equals("Road")) {
            map.getPlayer().updatePlayerLocation("up");
            player.updateScore(map, "up");
        }
        player.resetLocationScore();
        int x = 4;//initial x loc
        int y = 9;//initial y loc
        assertEquals(x,player.getPosX());
        assertEquals(y,player.getPosY());



    }
    @Test
    public void checkTheScoreAfterVehicleCollision(){
            while (!map.getLanes()[map.getPlayer().getPosY()].getType().equals("Road")) {
                map.getPlayer().updatePlayerLocation("up");
                player.updateScore(map, "up");
            }
            int score = player.getScore();
            player.resetLocationScore();
            assertNotEquals(score, player.getScore());
            assertEquals(0, player.getScore());
        }
    @Test
    public void OnLogLifeNotChanging() {
        player.setLives(5);
        player.onLog(obstacle); //put the player on log
        assertEquals(5,player.getLives());
    }
    @Test
    public void OnLogNotReturnToStart() {
        map.getPlayer().updatePlayerLocation("up");//moving thr player away from the starting point
        map.getPlayer().updatePlayerLocation("right");
        player.onLog(obstacle); //putting player on log
        int x = 4;//initial x loc
        int y = 9;//initial y loc
        assertNotEquals(x,player.getPosX());
        assertNotEquals(y,player.getPosY());


    }

    }

