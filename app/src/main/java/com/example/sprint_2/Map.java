package com.example.sprint_2;
import java.util.ArrayList;

public class Map {

    private final Lane[] lanes;
    private Player player;
    private String difficulty;

    public Map(String difficulty, Player player) {
        this.player = player;
        lanes = new Lane[10];
        this.difficulty = difficulty;
        // range for safe tile
        int lowerBound = 3;
        int higherBound = 5;

        //generate the map =
        lanes[0] =  new GoalTile();
        int safeTileId = (int) Math.floor(Math.random()
                * (higherBound - lowerBound + 1) + lowerBound);

        for (int i = 1; i < safeTileId; i++) {
            lanes[i] = new River();
        }
        lanes[safeTileId] =  new SafeTile();
        int count = 0;
        for (int i = safeTileId + 1; i < 9; i++) {
            if (count == 0) {
                lanes[i] = new Road(i, difficulty, 1);
                ++count;
            } else if (count == 1) {
                lanes[i] = new Road(i, difficulty, 2);
                ++count;
            } else if (count == 2) {
                lanes[i] = new Road(i, difficulty, 3);
                ++count;
            } else {
                int randomType = (int) Math.floor(Math.random()
                        * (3 - 1 + 1) + 1);
                lanes[i] = new Road(i, difficulty, randomType);
            }
        }
        lanes[9] =  new SafeTile();

    }
    public void updatePlayerLocation(String s, MapDisplayAdapter adapter) {
        player.updatePlayerLocation(s);
        adapter.notifyDataSetChanged();
        // check water/vehicle collision -> player.resetLocationScore -> adaper.notify
    }

    public void updateVehicleLocation(MapDisplayAdapter adapter) {
        adapter.notifyDataSetChanged();
    }

    public Player getPlayer() {
        return player;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getInfo(int x, int y) {
        return lanes[y].getTile(x).getInfo();
    }

    public Lane[] getLanes() {
        return lanes;
    }

    public void setLanes(int i, Lane data) {
        lanes[i] = data;
    }

    public ArrayList<Road> getRoad() {
        ArrayList<Road> list = new ArrayList<Road>();
        for (int i = 0; i < lanes.length; i++) {
            if (lanes[i].getType().equals("Road")) {
                list.add((Road) lanes[i]);
            }
        }
        return list;
    }

    public ArrayList<River> getRiver() {
        ArrayList<River> list = new ArrayList<River>();
        for (int i = 0; i < lanes.length; i++) {
            if (lanes[i].getType().equals("Road")) {
                list.add((River) lanes[i]);
            }
        }
        return list;
    }
}
