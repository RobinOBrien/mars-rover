package com.next45.challenge.object;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AreaTest
{
    private Area area;

    @Before
    public void init()
    {
        area = new Area(9, 9);
    }

    @Test
    public void testValidPosition()
    {
        Position validPosition1 = new Position(8, 8);
        assertTrue("Position should be valid", area.validPosition(validPosition1));

        Position validPosition2 = new Position(area.getMaxX(), area.getMaxY());
        assertTrue("Position should be valid", area.validPosition(validPosition2));
    }

    @Test
    public void testInvalidPosition()
    {
        Position validPosition1 = new Position(10, 9);
        assertFalse("Position should be invalid", area.validPosition(validPosition1));

        Position validPosition2 = new Position(12, 10);
        assertFalse("Position should be invalid", area.validPosition(validPosition2));
    }
}