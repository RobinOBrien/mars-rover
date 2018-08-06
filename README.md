## Mars Rover

Welcome to my implementation of the Mars Rover Challenge. I have made certain assumptions which are outlined below.
I have also included unit testing for the main functions that the Rover and related objects can perform.

### Assumptions

1. User input will always be correct. This is not really a real world assumption but for the purposes of this challenge I have made this assumption. 
2. When at the boundary of the area, any move that will cause the rover to exit the area is ignored. Thus the rover can only move around within the defined area. 

### Requirements
This project assumes you have Java 7's JDK installed correctly along with Maven. 

### User input 
User input is in the format as follows:
<br>
<br>
XY - maximum X value followed by the maximum Y value. This defines the size of the board. 
<br>
XY D - x position and y position of the Rover. D is the direction the rover is facing (N,S,W,E)
<br>
MRL - Moves the Rover is to carry out. (M - Move, R - Turn right, L - Turn left)
<br>
<br>
Example:
<pre>
88
12 E
MMLMRMMRRMML
</pre>

This above example creates the movable area of 8x8. This means a board of 64 blocks.<br>
The initial position of the Rover is x=1,y=2 and the Rover is facing East. <br>
If the rover executes the moves in the last line, its final position will be 3 3 S.

### Output

Once the program has run to completion, the Rovers current state will be printed in the following format: <br>
<pre>
Rover: Position: 2/4 Direction: N
</pre>
This means the rover is the position x=2, y=4 facing North.
 

### Testing, Building and Running Rover

Change directory to the project directory. All subsequent commands are executed relative to this directory. 

#### Testing

Tests have been created using JUnit. Tests can be executed using the following command:

<pre>
mvn test
</pre>

#### Building

This project makes use of Maven. Thus we are able to build the project using the following com.next45.challenge.command: 
<pre>
mvn package
</pre>

This will generate a JAR file. 

#### Running

To run rover, we need to execute the built JAR artifact. The following com.next45.challenge.command can be used:

<pre>
java -jar target/rover-1.0-SNAPSHOT.jar
</pre>
