package com.next45.challenge.object;

public enum Direction
{
    NORTH("N", 0),
    EAST("E", 90),
    SOUTH("S", 180),
    WEST("W", 270);

    private String value;
    private int degrees;

    private static final int FULL_CIRCLE = 360;

    Direction(String value, int degrees)
    {
        this.value = value;
        this.degrees = degrees;
    }

    /**
     * Change direction either turning left of right
     *
     * @param turn object representing the direction in which to turn
     * @return the new direction
     */
    public Direction turn(Turn turn)
    {
        return fromDegrees(this.degrees + turn.getDegrees());
    }

    /**
     * Get the correct direction based on the degrees supplied
     *
     * @param degrees degrees of the direction
     * @return the correct direction
     */
    public static Direction fromDegrees(int degrees)
    {
        for (Direction direction : Direction.values()) {
            if (direction.getDegrees() == (degrees % FULL_CIRCLE)) {
                return direction;
            }
        }

        return NORTH;
    }

    /**
     * Get the direction based on the directional string supplied
     * Eg: N
     *
     * @param string the String used to select the correct direction
     * @return the correct direction
     */
    public static Direction fromString(String string)
    {
        for (Direction direction : Direction.values()) {
            if (direction.getValue().equals(string)) {
                return direction;
            }
        }

        return NORTH;
    }


    public String getValue()
    {
        return value;
    }

    public int getDegrees()
    {
        return degrees;
    }

    @Override
    public String toString()
    {
        return String.format("Direction: %s", getValue());
    }
}
