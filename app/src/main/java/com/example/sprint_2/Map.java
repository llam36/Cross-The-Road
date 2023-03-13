package com.example.sprint_2;

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
        int higherBound = 6;

        //generate the map =
        lanes[0] =  new GoalTile();
        int safeTileId = (int) Math.floor(Math.random()
                * (higherBound - lowerBound + 1) + lowerBound);

        for (int i = 1; i < safeTileId; i++) {
            lanes[i] = new River();
        }
        lanes[safeTileId] =  new SafeTile();
        for (int i = safeTileId + 1; i < 9; i++) {
            lanes[i] = new Road(i);
        }
        lanes[9] =  new SafeTile();

    }
    public void updatePlayerLocation(String s, MapDisplayAdapter adapter) {
        player.updatePlayerLocation(s);
        adapter.notifyDataSetChanged();
    }

    public void updateVehicleLocation(MapDisplayAdapter adapter) {

        adapter.notifyDataSetChanged();
    }

    public Player getPlayer() { return player; }

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

    public Road[] getRoad() {
        Road[] list = new Road[10];
        int count = 0;
        for (int i = 0; i < lanes.length; i++) {
            if (lanes[i].getType().equals("Road")) {
                list[count] = (Road) lanes[i];
                ++count;
            }
        }
        return list;
    }

    public River[] getRiver() {
        River[] list = new River[10];
        int count = 0;
        for (int i = 0; i < lanes.length; i++) {
            if (lanes[i].getType().equals("River")) {
                list[count] = (River) lanes[i];
                ++count;
            }
        }
        return list;
    }
}
