package com.example.sprint_2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import java.util.ArrayList;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ThanhJunit {

    private Player player;
    private String difficulty;
    private Map map;
    private ArrayList<Road> roads;

    private Obstacle log;


    @Before
    public void setUp() {
        difficulty = "Easy";
        player = new Player("Easy", "testName", R.drawable.chicken);
        map = new Map("Easy", player);
        roads = map.getRoad();


    }
    @Test
    public void checkPlayerLife() {
        player = new Player("Hard", "testName", R.drawable.chicken);
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

    @Test
    public void checkCorrectCarOnRoad() {
        Road road1 = roads.get(0);
        String vehicleType1 = road1.getVehicleType();
        System.out.println(vehicleType1);
        assertTrue(vehicleType1.equals("car"));
        Road road2 = roads.get(1);
        String vehicleType2 = road2.getVehicleType();
        assertTrue(vehicleType2.equals("truck"));
        Road road3 = roads.get(2);
        String vehicleType3 = road3.getVehicleType();
        assertTrue(vehicleType3.equals("motorcycle"));
    }

    @Test
    public void checkVelocityBasedOnCarType() {
        Road road1 = roads.get(0);
        Obstacle obstacle = road1.getVehicles().get(0);
        assertTrue(obstacle.getVelocity() ==  1300);
        Road road2 = roads.get(1);
        Obstacle obstacle2 = road2.getVehicles().get(0);
        assertTrue(obstacle2.getVelocity() ==  1800);
        Road road3 = roads.get(2);
        Obstacle obstacle3 = road3.getVehicles().get(0);
        assertTrue(obstacle3.getVelocity() ==  800);
    }

    @Test

    public void checkCollisionStandingStill() {
        Road road = (Road) map.getLanes()[8];
        ArrayList<Obstacle> obstacles = road.getVehicles();

        //player moves up one so that it can enter the road with cars
        player.updatePlayerLocation("up");
        int position = player.getPos();
        int liveNum = player.getLives();
        boolean crash = false;

        //standing still so that it can wait for the collision
        while (!crash) {
            for (int j = 0; j < obstacles.size(); j++) {
                if (obstacles.get(j).getPos() == position) {
                    crash = true;
                    map.getPlayer().resetLocationScore();
                }
            }
        }

        assertEquals(crash, true);
        assertEquals(liveNum - 1, map.getPlayer().getLives());
    }

    @Test
    public void checkCollisionMovingRight() {
        Road road = (Road) map.getLanes()[8];
        ArrayList<Obstacle> obstacles = road.getVehicles();

        //player moves up one so that it can enter the road with cars
        player.updatePlayerLocation("up");
        int position = player.getPos();
        int liveNum = player.getLives();
        boolean crash = false;

        //moving right until the collision
        while (!crash) {
            for (int j = 0; j < obstacles.size(); j++) {
                if (obstacles.get(j).getPos() == position) {
                    player.updatePlayerLocation("right");
                    crash = true;
                    map.getPlayer().resetLocationScore();
                }
            }
        }

        assertEquals(crash, true);
        assertEquals(liveNum - 1, map.getPlayer().getLives());
    }

    @Test
    public void checkMoveSpriteMoveLeftWithLog() {
        log = new Obstacle(2,0, 1, 1, 1);
        int live = map.getPlayer().getLives();
        map.getPlayer().onLog(log);
        boolean crash = true;
        // move player on log off left screen
        while (crash) {
            if (!((log.getPos() % 8) != 0 || map.getPlayer().getPosX() == 0)) {
                continue;
            } else  {
                crash = false;
            }
        };
        assertEquals(crash, false);
    }

    @Test
    public void checkMoveSpriteMoveRightWithLog() {
        log = new Obstacle(6,0, 1, 1, -1);
        int live = map.getPlayer().getLives();
        map.getPlayer().onLog(log);
        boolean crash = true;
        // move player on log off left screen
        while (crash) {
            if (!((log.getPos() % 8) != 7 || map.getPlayer().getPosX() == 7)) {
                continue;
            } else  {
                crash = false;
            }
        };
        assertEquals(crash, false);
    }

}