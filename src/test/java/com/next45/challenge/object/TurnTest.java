package com.next45.challenge.object;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TurnTest
{
    @Test
    public void testTurnDegrees()
    {
        assertEquals("Degrees incorrect", 270, Turn.LEFT.getDegrees());
        assertEquals("Degrees incorrect", 90, Turn.RIGHT.getDegrees());

    }
}
