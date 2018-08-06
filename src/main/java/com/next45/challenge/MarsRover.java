package com.next45.challenge;

import com.next45.challenge.command.Command;
import com.next45.challenge.object.Area;
import com.next45.challenge.object.Rover;
import com.next45.challenge.util.MarsRoverUtils;

import java.util.List;
import java.util.Scanner;

public class MarsRover
{

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        Area area = MarsRoverUtils.createArea(scanner.nextLine());
        Rover rover = MarsRoverUtils.createRover(area, scanner.nextLine().split(" "));

        char[] moves = scanner.nextLine().toCharArray();
        List<Command> commands = MarsRoverUtils.createCommands(moves);
        rover.executeCommands(commands);

        System.out.println(rover);

        scanner.close();
    }
}