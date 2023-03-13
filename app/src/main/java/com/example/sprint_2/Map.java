package com.example.sprint_2;

public class Map {

    private final Lane[] lanes;
    private Player player;
    private String difficulty;

    public Map(String difficulty, Player player) {
        this.player = player;
        lanes = new Lane[10];
        this.difficulty = difficulty;

        if (difficulty.equals("Easy") || difficulty.equals("Medium")) {
            // range for safe tile
            int lowerBound = 3;
            int higherBound = 7;

            //generate the map =
            lanes[0] =  new GoalTile();
            int safeTileId = (int) Math.floor(Math.random()
                    * (higherBound - lowerBound + 1) + lowerBound);
            for (int i = 1; i < safeTileId; i++) {
                lanes[i] = new River();
            }
            lanes[safeTileId] =  new SafeTile();
            for (int i = safeTileId + 1; i < 10; i++) {
                lanes[i] = new Road(i);
            }
            lanes[0] =  new GoalTile();
        } else {
            // range for safe tile
            int lowerBound1 = 2;
            int higherBound1 = 4;

            int lowerBound2 = 6;
            int higherBound2 = 7;

            //generate the map =
            lanes[0] =  new GoalTile();
            int safeTileId1 = (int) Math.floor(Math.random()
                    * (higherBound1 - lowerBound1 + 1) + lowerBound1);
            int safeTileId2 = (int) Math.floor(Math.random()
                    * (higherBound2 - lowerBound2 + 1) + lowerBound2);
            for (int i = 1; i < safeTileId1; i++) {
                lanes[i] = new Road(i);
            }
            lanes[safeTileId1] =  new SafeTile();
            for (int i = safeTileId1 + 1; i < safeTileId2; i++) {
                lanes[i] = new River();
            }
            lanes[safeTileId2] =  new SafeTile();
            for (int i = safeTileId2 + 1; i < 10; i++) {
                lanes[i] = new Road(i);
            }
            lanes[0] =  new GoalTile();
        }
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
}
