package com.next45.challenge.object;

import com.next45.challenge.command.Command;
import com.next45.challenge.command.MoveCommand;
import com.next45.challenge.command.TurnCommand;

import java.util.List;

public class Rover
{
    private Area area;
    private Position position;
    private Direction direction;

    public Rover(Area area, Position position, Direction direction)
    {
        this.area = area;
        this.position = position;
        this.direction = direction;
    }

    /**
     * Moves rover 1 position forward in the direction it is currently facing
     */
    public void move()
    {
        Position projectedPosition = new Position(position.getXCoordinate(), position.getYCoordinate());

        switch (direction) {
            case NORTH:
                projectedPosition.increaseY();
                break;
            case EAST:
                projectedPosition.increaseX();
                break;
            case SOUTH:
                projectedPosition.decreaseY();
                break;
            case WEST:
                projectedPosition.decreaseX();
                break;
        }

        if (area.validPosition(projectedPosition)) {
            position = projectedPosition;
        }
    }

    /**
     * Turns the rover left or right
     *
     * @param turn com.next45.challenge.object representing which turn to make
     */
    public void turn(Turn turn)
    {
        direction = direction.turn(turn);
    }

    /**
     * Executes the given list of commands
     *
     * @param commandList list containing all the commands to execute
     */
    public void executeCommands(List<? extends Command> commandList)
    {
        for (Command command : commandList) {
            executeCommand(command);
        }
    }

    /**
     * Executes the given com.next45.challenge.command
     *
     * @param command com.next45.challenge.object representing the com.next45.challenge.command to run
     */
    public void executeCommand(Command command)
    {
        if (command instanceof TurnCommand) {
            turn(((TurnCommand) command).getTurn());
        } else if (command instanceof MoveCommand) {
            move();
        }
    }

    public Area getArea()
    {
        return area;
    }

    public Position getPosition()
    {
        return position;
    }

    public Direction getDirection()
    {
        return direction;
    }

    public void setDirection(Direction direction)
    {
        this.direction = direction;
    }

    @Override
    public String toString()
    {
        return String.format("Rover: %s %s",
                position,
                direction);
    }
}
