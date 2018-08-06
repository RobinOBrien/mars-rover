package com.next45.challenge.util;

import com.next45.challenge.command.Command;
import com.next45.challenge.command.MoveCommand;
import com.next45.challenge.command.TurnCommand;
import com.next45.challenge.object.*;

import java.util.ArrayList;
import java.util.List;

public class MarsRoverUtils
{
    /**
     * Creates new Area from the give String representing the area
     * Eg: 98 representing an area of size (x by y) 9 x 8
     *
     * @param line string containing the areas x and y data
     * @return new Area representing the movable area
     */
    public static Area createArea(String line)
    {
        return new Area(Integer.parseInt(line.substring(0, 1)), Integer.parseInt(line.substring(1, 2)));
    }

    /**
     * Creates a new rover in the given area with a String array containing the starting data
     * Eg: 12 E representing a start position of x=1 and y=2 with the Direction of E.
     *
     * @param area         movable area
     * @param startingData starting data array
     * @return new Rover representing its current position and direction within the given area.
     */
    public static Rover createRover(Area area, String[] startingData)
    {
        Position position = new Position(Integer.parseInt(startingData[0].substring(0, 1)), Integer.parseInt(startingData[0].substring(1, 2)));
        Direction direction = Direction.fromString(startingData[1]);

        return new Rover(area, position, direction);
    }

    /**
     * Creates a new list of commands from the given character input
     * Eg: MRM creates a list of commands as follows: MoveCommand TurnCommand MoveCommand
     *
     * @param commands character array of commands
     * @return List of com.next45.challenge.command objects
     */
    public static List<Command> createCommands(char[] commands)
    {
        List<Command> result = new ArrayList<Command>(commands.length);

        for (char move : commands) {
            switch (move) {
                case ('M'):
                    result.add(new MoveCommand());
                    break;
                case ('R'):
                    result.add(new TurnCommand(Turn.RIGHT));
                    break;
                case ('L'):
                    result.add(new TurnCommand(Turn.LEFT));
                    break;
            }
        }

        return result;
    }
}
