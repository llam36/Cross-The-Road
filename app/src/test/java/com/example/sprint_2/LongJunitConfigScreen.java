package com.example.sprint_2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LongJunitConfigScreen {
    @Before
    public void setUp() {}
    @Test
    public void checkEmptyStringName() {
        assertTrue(ConfigScreen.isEmptyStringName("") == true);
        assertTrue(ConfigScreen.isEmptyStringName("MyName") == false);
    }
}