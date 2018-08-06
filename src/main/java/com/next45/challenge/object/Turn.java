package com.next45.challenge.object;

public enum Turn
{
    RIGHT(90),
    LEFT(270);

    private int degrees;

    Turn(int degrees)
    {
        this.degrees = degrees;
    }

    public int getDegrees()
    {
        return degrees;
    }
}
