package com.next45.challenge.command;

import com.next45.challenge.object.Turn;

public class TurnCommand extends Command
{
    private Turn turn;

    public TurnCommand(Turn turn)
    {
        this.turn = turn;
    }

    public Turn getTurn()
    {
        return turn;
    }
}
