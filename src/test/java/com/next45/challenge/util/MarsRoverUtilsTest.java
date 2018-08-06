package com.next45.challenge.util;

import com.next45.challenge.command.Command;
import com.next45.challenge.command.MoveCommand;
import com.next45.challenge.command.TurnCommand;
import com.next45.challenge.object.Area;
import com.next45.challenge.object.Direction;
import com.next45.challenge.object.Rover;
import com.next45.challenge.object.Turn;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MarsRoverUtilsTest
{

    private final String areaInput1 = "88";
    private final String areaInput2 = "97";

    private final String commandString1 = "MRL";
    private final String commandString2 = "MMRMMLMM";

    private final String[] startingData1 = {"01", "E"};
    private final String[] startingData2 = {"23", "S"};

    @Test
    public void testCreateArea()
    {
        Area area1 = MarsRoverUtils.createArea(areaInput1);
        assertEquals("Area's max x not set correctly", 8, area1.getMaxX());
        assertEquals("Area's max y not set correctly", 8, area1.getMaxY());

        Area area2 = MarsRoverUtils.createArea(areaInput2);
        assertEquals("Area's max x not set correctly", 9, area2.getMaxX());
        assertEquals("Area's max y not set correctly", 7, area2.getMaxY());
    }

    @Test
    public void testCreateCommands()
    {
        List<Command> commands1 = MarsRoverUtils.createCommands(commandString1.toCharArray());
        assertTrue("Command type not set correctly", commands1.get(0) instanceof MoveCommand);
        assertTrue("Command type not set correctly", commands1.get(1) instanceof TurnCommand);
        assertEquals("Turn com.next45.challenge.command direction not set correctly", Turn.RIGHT, ((TurnCommand) commands1.get(1)).getTurn());
        assertTrue("Command type not set correctly", commands1.get(2) instanceof TurnCommand);
        assertEquals("Turn com.next45.challenge.command direction not set correctly", Turn.LEFT, ((TurnCommand) commands1.get(2)).getTurn());

        List<Command> commands2 = MarsRoverUtils.createCommands(commandString2.toCharArray());

        assertTrue("Command type not set correctly", commands2.get(0) instanceof MoveCommand);
        assertTrue("Command type not set correctly", commands2.get(1) instanceof MoveCommand);

        assertTrue("Command type not set correctly", commands2.get(2) instanceof TurnCommand);
        assertEquals("Turn com.next45.challenge.command direction not set correctly", Turn.RIGHT, ((TurnCommand) commands2.get(2)).getTurn());

        assertTrue("Command type not set correctly", commands2.get(3) instanceof MoveCommand);
        assertTrue("Command type not set correctly", commands2.get(4) instanceof MoveCommand);

        assertTrue("Command type not set correctly", commands2.get(5) instanceof TurnCommand);
        assertEquals("Turn com.next45.challenge.command direction not set correctly", Turn.LEFT, ((TurnCommand) commands2.get(5)).getTurn());

        assertTrue("Command type not set correctly", commands2.get(6) instanceof MoveCommand);
        assertTrue("Command type not set correctly", commands2.get(6) instanceof MoveCommand);
    }

    @Test
    public void testCreateVehicle()
    {
        Area area = new Area(4, 4);

        Rover rover1 = MarsRoverUtils.createRover(area, startingData1);
        assertEquals("Rover's area not set correctly", area, rover1.getArea());
        assertEquals("Rover's x position not set correctly", 0, rover1.getPosition().getXCoordinate());
        assertEquals("Rover's y position not set correctly", 1, rover1.getPosition().getYCoordinate());
        assertEquals("Rover's direction not set correctly", Direction.EAST, rover1.getDirection());

        Rover rover2 = MarsRoverUtils.createRover(area, startingData2);
        assertEquals("Rover's area not set correctly", area, rover2.getArea());
        assertEquals("Rover's x position not set correctly", 2, rover2.getPosition().getXCoordinate());
        assertEquals("Rover's y position not set correctly", 3, rover2.getPosition().getYCoordinate());
        assertEquals("Rover's direction not set correctly", Direction.SOUTH, rover2.getDirection());
    }
}
