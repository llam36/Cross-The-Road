package com.example.sprint_2;
import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;

public class MapDisplayAdapter extends ArrayAdapter<Tile> {
    private final int gridHeight = 8;
    private final int laneLength = 8;
    private Map gameMap;
    private int imageOption;

    private Context context;

    public MapDisplayAdapter(@NonNull Context context, Tile[] tiles, Map gameMap, int imageOption) {
        super(context, 0, tiles);
        this.gameMap = gameMap;
        this.imageOption = imageOption;
        this.context = context;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //tileView: contains the images
        View tileView = convertView;
        if (tileView == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            tileView = LayoutInflater.from(getContext())
                    .inflate(R.layout.lane_layout, parent, false);
        }

        //get the corresponding position of tile ?
        Tile tile = getItem(position);

        //setting image display for the tile
        ImageView tileIV = tileView.findViewById(R.id.IVTile);
        int tileVSrc;
        switch (tile.getType()) {
        case "River":
            tileVSrc = R.drawable.river;
            break;
        case "Road":
            tileVSrc = R.drawable.road;
            break;
        case "SafeTile":
            tileVSrc = R.drawable.safe_tile;
            break;
        case "GoalTile":
            tileVSrc = R.drawable.goal_tile;
            break;
        default:
            tileVSrc = 0;
            break;
        }
        tileIV.setImageResource(tileVSrc);

        //initialize variables for setting
        boolean hasSprite = false;
        boolean hasVehical = false;
        boolean onRiver = false;
        boolean onLog = false;


        //Log display
        ImageView logIV = tileView.findViewById(R.id.log);
        logIV.setImageResource(R.drawable.log);
        ArrayList<River> riverList = gameMap.getRiver();
        logIV.setVisibility(View.INVISIBLE);
        Log currentLog = new Log(0, 0, 0, 0, 1);
        int direction = 0;

        for (int i = 0; i < riverList.size(); i++) {
            ArrayList<Log> logList = riverList.get(i).getLogs();
            for (int j = 0; j < logList.size(); j++) {
                if (logList.get(j).getPos() == position) {
                    currentLog = logList.get(j);
                    direction = logList.get(j).getDirection();
                    onLog = true;
                    logIV.setVisibility(View.VISIBLE);
                }
            }
        }

        ArrayList<Integer> riverListId = gameMap.getRiverIndex();
        int riverLowerBound = riverListId.get(0) * gridHeight;
        int riverHigherBound = riverListId.get(riverListId.size() - 1) * gridHeight + 7;
        if (riverLowerBound < position && position < riverHigherBound) {
            onRiver = true;
        }

        //Sprite display
        ImageView spriteIV = tileView.findViewById(R.id.IVSprite);
        spriteIV.setImageResource(imageOption);
        if (position == gameMap.getPlayer().getPos()) {
            hasSprite = true;
            spriteIV.setVisibility(View.VISIBLE);
        } else {
            spriteIV.setVisibility(View.INVISIBLE);
        }

        //Vehicle display
        ImageView vehicalIV = tileView.findViewById(R.id.vehicle);
        vehicalIV.setImageResource(R.drawable.white);
        ArrayList<Road> roadList = gameMap.getRoad();
        vehicalIV.setVisibility(View.INVISIBLE);

        for (int i = 0; i < roadList.size(); i++) {
            ArrayList<Vehicle> vehicleList = roadList.get(i).getVehicles();
            for (int j = 0; j < vehicleList.size(); j++) {
                if (vehicleList.get(j).getPos() == position) {
                    vehicalIV.setImageResource(vehicleList.get(j).getImageId());
                    hasVehical = true;
                    vehicalIV.setVisibility(View.VISIBLE);
                }
            }
        }

        //get hit by car check
        if (hasVehical && hasSprite) {
            AlertDialog.Builder alertBuilder = new AlertDialog.Builder(context);
            AlertDialog crashDialog = alertBuilder.create();
            crashDialog.setMessage("You crashed into the car!!!");
            crashDialog.show();
//            gameMap.stopUpdate();
//            if (!crashDialog.isShowing()) {
//                gameMap.continueUpdate();
//            }
            gameMap.getPlayer().resetLocationScore();
        }

        //jump into the water check
        if (!onLog && onRiver && hasSprite) {
            AlertDialog.Builder alertBuilder = new AlertDialog.Builder(context);
            AlertDialog crashDialog = alertBuilder.create();
            crashDialog.setMessage("You fell into river and cannot swim! Too bad!");
            crashDialog.show();
//            gameMap.stopUpdate();
//            if (!crashDialog.isShowing()) {
//                gameMap.continueUpdate();
//            }
            gameMap.getPlayer().resetLocationScore();

        }

        //update player's current log
        if (hasSprite && onLog) {
            gameMap.getPlayer().onLog(currentLog);

            if (direction == 1 && ((position % gridHeight) == 0) && gameMap.getPlayer().getPosX() != 0) {
                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(context);
                AlertDialog crashDialog = alertBuilder.create();
                crashDialog.setMessage("The log brings you to the other side of the world :D");
                crashDialog.show();
//                gameMap.stopUpdate();
//                gameMap.getPlayer().resetLocationScore();
//
//                if (!crashDialog.isShowing()) {
//                    gameMap.continueUpdate();
//                }
                gameMap.getPlayer().offLog();
                gameMap.getPlayer().resetLocationScore();
            }

            if (direction == -1 && ((position % gridHeight) == 7) && gameMap.getPlayer().getPosX() != 7) {
                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(context);
                AlertDialog crashDialog = alertBuilder.create();
                crashDialog.setMessage("The log brings you to the other side of the world :D");
                crashDialog.show();
//                gameMap.stopUpdate();
//                gameMap.getPlayer().resetLocationScore();
//
//                if (!crashDialog.isShowing()) {
//                    gameMap.continueUpdate();
//                }
                gameMap.getPlayer().offLog();
                gameMap.getPlayer().resetLocationScore();
            }
        }



        return tileView;
    }
}
