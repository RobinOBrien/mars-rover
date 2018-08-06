package com.next45.challenge.object;

import com.google.common.collect.Lists;
import com.next45.challenge.command.Command;
import com.next45.challenge.command.MoveCommand;
import com.next45.challenge.command.TurnCommand;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class RoverTest
{
    private Area area;
    private Position position;
    private Direction direction;
    private Rover rover;

    @Before
    public void init()
    {
        area = new Area(1, 1);
        position = new Position(0, 0);
        direction = Direction.EAST;

        rover = new Rover(area, position, direction);
    }

    @Test
    public void testTurn()
    {
        rover.turn(Turn.LEFT);
        assertEquals("Rover did not turn correctly", Direction.NORTH, rover.getDirection());

        rover.turn(Turn.LEFT);
        assertEquals("Rover did not turn correctly", Direction.WEST, rover.getDirection());

        rover.turn(Turn.RIGHT);
        assertEquals("Rover did not turn correctly", Direction.NORTH, rover.getDirection());

        rover.turn(Turn.RIGHT);
        assertEquals("Rover did not turn correctly", Direction.EAST, rover.getDirection());
    }

    @Test
    public void testMove()
    {
        rover.setDirection(Direction.EAST);
        rover.move();

        assertEquals("Rover did not move correctly", 1, rover.getPosition().getXCoordinate());
        assertEquals("Rover did not move correctly", 0, rover.getPosition().getYCoordinate());

        rover.setDirection(Direction.NORTH);
        rover.move();

        assertEquals("Rover did not move correctly", 1, rover.getPosition().getXCoordinate());
        assertEquals("Rover did not move correctly", 1, rover.getPosition().getYCoordinate());

        rover.move();

        assertEquals("Rover did not move correctly", 1, rover.getPosition().getXCoordinate());
        assertEquals("Rover did not move correctly", 1, rover.getPosition().getYCoordinate());
    }

    @Test
    public void testExecuteCommands()
    {
        rover.setDirection(Direction.NORTH);

        List<? extends Command> commands = Lists.newArrayList(new MoveCommand());
        rover.executeCommands(commands);

        assertEquals("Direction not correct", Direction.NORTH, rover.getDirection());
        assertEquals("Rover did not move correctly", 0, rover.getPosition().getXCoordinate());
        assertEquals("Rover did not move correctly", 1, rover.getPosition().getYCoordinate());

        commands = Lists.newArrayList(new MoveCommand(), new TurnCommand(Turn.RIGHT));
        rover.executeCommands(commands);

        assertEquals("Direction not correct", Direction.EAST, rover.getDirection());
        assertEquals("Rover did not move correctly", 0, rover.getPosition().getXCoordinate());
        assertEquals("Rover did not move correctly", 1, rover.getPosition().getYCoordinate());

        commands = Lists.newArrayList(new MoveCommand());
        rover.executeCommands(commands);

        assertEquals("Direction not correct", Direction.EAST, rover.getDirection());
        assertEquals("Rover did not move correctly", 1, rover.getPosition().getXCoordinate());
        assertEquals("Rover did not move correctly", 1, rover.getPosition().getYCoordinate());
    }

}

