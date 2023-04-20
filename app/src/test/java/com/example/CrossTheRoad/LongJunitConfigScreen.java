package com.example.CrossTheRoad;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LongJunitConfigScreen {
    private Player player;
    @Before
    public void setUp() {
        player = new Player();
    }
    @Test
    public void checkEmptyStringName() {
        assertTrue(player.isEmptyStringName("") == true);
        assertTrue(player.isEmptyStringName("MyName") == false);
    }
}