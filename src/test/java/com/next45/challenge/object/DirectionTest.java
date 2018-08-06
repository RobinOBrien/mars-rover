package com.next45.challenge.object;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DirectionTest
{

    private static int NORTH_IN_DEGREES = 0;
    private static int EAST_IN_DEGREES = 90;
    private static int SOUTH_IN_DEGREES = 180;
    private static int WEST_IN_DEGREES = 270;

    private static int THREE_SIXTY = 360;
    private static int FOUR_FIFTY = 450;


    @Test
    public void testFromDegrees()
    {
        assertEquals("Direction incorrect", Direction.NORTH, Direction.fromDegrees(NORTH_IN_DEGREES));
        assertEquals("Direction incorrect", Direction.EAST, Direction.fromDegrees(EAST_IN_DEGREES));
        assertEquals("Direction incorrect", Direction.SOUTH, Direction.fromDegrees(SOUTH_IN_DEGREES));
        assertEquals("Direction incorrect", Direction.WEST, Direction.fromDegrees(WEST_IN_DEGREES));

        assertEquals("Direction incorrect", Direction.NORTH, Direction.fromDegrees(THREE_SIXTY));
        assertEquals("Direction incorrect", Direction.EAST, Direction.fromDegrees(FOUR_FIFTY));
    }

    @Test
    public void testFromString()
    {
        assertEquals("Direction incorrectly determined", Direction.NORTH, Direction.fromString("N"));
        assertEquals("Direction incorrect determined", Direction.EAST, Direction.fromString("E"));
        assertEquals("Direction incorrect determined", Direction.SOUTH, Direction.fromString("S"));
        assertEquals("Direction incorrect determined", Direction.WEST, Direction.fromString("W"));

    }

    @Test
    public void testTurn()
    {
        assertEquals("Direction incorrect after turning left", Direction.NORTH, Direction.EAST.turn(Turn.LEFT));
        assertEquals("Direction incorrect after turning right", Direction.SOUTH, Direction.EAST.turn(Turn.RIGHT));

        assertEquals("Direction incorrect after turning left", Direction.WEST, Direction.NORTH.turn(Turn.LEFT));
        assertEquals("Direction incorrect after turning right", Direction.EAST, Direction.NORTH.turn(Turn.RIGHT));

        assertEquals("Direction incorrect after turning left", Direction.EAST, Direction.SOUTH.turn(Turn.LEFT));
        assertEquals("Direction incorrect after turning right", Direction.WEST, Direction.SOUTH.turn(Turn.RIGHT));
    }


}
