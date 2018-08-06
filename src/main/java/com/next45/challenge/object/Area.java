package com.next45.challenge.object;

public class Area
{
    private int maxX;
    private int maxY;

    public Area(int maxX, int maxY)
    {
        this.maxX = maxX;
        this.maxY = maxY;
    }

    /**
     * Validates the give position within the current Area.
     *
     * @param position com.next45.challenge.object representing an x and y coordinate
     * @return true if position is within the current area.
     */
    public boolean validPosition(Position position)
    {
        int currentX = position.getXCoordinate();
        int currentY = position.getYCoordinate();

        if ((currentX <= maxX && currentX >= 0) && currentY <= maxY && currentY >= 0) {
            return true;
        } else {
            return false;
        }
    }

    public int getMaxX()
    {
        return maxX;
    }

    public int getMaxY()
    {
        return maxY;
    }
}
