package com.next45.challenge.object;

public class Position implements Cloneable
{
    private int xCoordinate;
    private int yCoordinate;

    public Position(int xCoordinate, int yCoordinate)
    {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public int getXCoordinate()
    {
        return xCoordinate;
    }

    public int getYCoordinate()
    {
        return yCoordinate;
    }

    /**
     * Increase the x value by 1 unit
     */
    public void increaseX()
    {
        xCoordinate++;
    }

    /**
     * Increase the y value by 1 unit
     */
    public void increaseY()
    {
        yCoordinate++;
    }

    /**
     * Decrease the x value by 1 unit
     */
    public void decreaseX()
    {
        xCoordinate--;
    }

    /**
     * Decrease the y value by 1 unit
     */
    public void decreaseY()
    {
        yCoordinate--;
    }

    @Override
    public String toString()
    {
        return String.format("Position: %d/%d",
                xCoordinate,
                yCoordinate);
    }
}
