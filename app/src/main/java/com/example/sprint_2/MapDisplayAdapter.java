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

public class MapDisplayAdapter extends ArrayAdapter<Tile> {
    private Map gameMap;
    private int imageOption;
    public MapDisplayAdapter(@NonNull Context context, Tile[] tiles, Map gameMap, int imageOption) {
        super(context, 0, tiles);
        this.gameMap = gameMap;
        this.imageOption = imageOption;
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

        //setting visibility of spriteIV and its image display
        ImageView spriteIV = tileView.findViewById(R.id.IVSprite);
        spriteIV.setImageResource(imageOption);
        if (position == gameMap.getPlayer().getPos()) {
            spriteIV.setVisibility(View.VISIBLE);
        } else {
            spriteIV.setVisibility(View.INVISIBLE);
        }

        //setting visibility of vehicle and its image display
        ImageView vehicalIV = tileView.findViewById(R.id.vehicle);
        vehicalIV.setImageResource(R.drawable.white);
        //System.out.println("Image Option: " + imageOption);
        ArrayList<Road> roadList = gameMap.getRoad();
        vehicalIV.setVisibility(View.INVISIBLE);

        for (int i = 0; i < roadList.size(); i++) {
            ArrayList<Vehicle> vehicleList = roadList.get(i).getVehicles();
            for (int j = 0; j < vehicleList.size(); j++) {
                if (vehicleList.get(j).getPos() == position) {
                    vehicalIV.setImageResource(vehicleList.get(j).getImageId());
                    vehicalIV.setVisibility(View.VISIBLE);
                }
            }
        }
        return tileView;
    }
}
