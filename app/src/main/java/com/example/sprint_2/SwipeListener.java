package com.example.sprint_2;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class SwipeListener implements View.OnTouchListener {
    private GestureDetector gestureDetector;

    SwipeListener(View view, Map gameMap, MapDisplayAdapter adapter) {
        int threshold = 100;
        int velocityThreshold = 100;
        GestureDetector.SimpleOnGestureListener listener = new
                GestureDetector.SimpleOnGestureListener() {
                public boolean onDown(MotionEvent e) {
                    return true;
                }

                public boolean onFling(MotionEvent e1,
                                       MotionEvent e2, float velocityX, float velocityY) {
                    float xDiff = e2.getX() - e1.getX();
                    float yDiff = e2.getY() - e1.getY();
                    if (Math.abs(xDiff) > Math.abs(yDiff)) {
                        if (Math.abs(xDiff) > threshold && Math.abs(velocityX)
                                > velocityThreshold) {
                            if (xDiff > 0) {
                                gameMap.updatePlayerLocation("right", adapter);
                                System.out.println("current player x: "
                                        + gameMap.getCurrentPlayerX());
                                System.out.println("current player y: "
                                        + gameMap.getCurrentPlayerY());
                            } else {
                                gameMap.updatePlayerLocation("left", adapter);
                                System.out.println("current player x: "
                                        + gameMap.getCurrentPlayerX());
                                System.out.println("current player y: "
                                        + gameMap.getCurrentPlayerY());
                            }
                            return true;
                        }
                    } else {
                        if (Math.abs(yDiff) > threshold
                                && Math.abs(velocityY) > velocityThreshold) {
                            if (yDiff > 0) {
                                gameMap.updatePlayerLocation("down", adapter);
                                System.out.println("current player x: "
                                        + gameMap.getCurrentPlayerX());
                                System.out.println("current player y: "
                                        + gameMap.getCurrentPlayerY());
                            } else {
                                gameMap.updatePlayerLocation("up", adapter);
                                System.out.println("current player x: "
                                        + gameMap.getCurrentPlayerX());
                                System.out.println("current player y: "
                                        + gameMap.getCurrentPlayerY());
                            }
                            return true;
                        }

                    }

                    return false;
                }
            };
        gestureDetector = new GestureDetector(listener);
        view.setOnTouchListener(this);
    }
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return gestureDetector.onTouchEvent(motionEvent);
    }
}
