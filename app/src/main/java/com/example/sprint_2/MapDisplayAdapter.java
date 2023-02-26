package com.example.sprint_2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MapDisplayAdapter extends ArrayAdapter<Lane> {
    public MapDisplayAdapter(@NonNull Context context, Lane[] lanes) {
        super(context, 0, lanes);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View laneView = convertView;
        if (laneView == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            laneView = LayoutInflater.from(getContext()).inflate(R.layout.lane, parent, false);
        }

        Lane lane = getItem(position);
        ImageView laneIV = laneView.findViewById(R.id.idIVLane);

        int laneIVSrc;
        switch (lane.getType()) {
        case "river":
            laneIVSrc = R.drawable.river;
            break;
        case "road":
            laneIVSrc = R.drawable.road;
            break;
        case "safe tile":
            laneIVSrc = R.drawable.safe_tile;
            break;
        case "goal tile":
            laneIVSrc = R.drawable.goal_tile;
            break;
        default:
            laneIVSrc = 0;
            break;
        }
        laneIV.setImageResource(laneIVSrc);

        ImageView spriteIV = laneView.findViewById(R.id.idIVSprite);
        spriteIV.setImageResource(R.drawable.sprite_chicken);
        if (position == 0) {
            spriteIV.setVisibility(View.VISIBLE);
        }
        return laneView;
    }
}
