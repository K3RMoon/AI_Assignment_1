# AI_Assignment_1
Solving 8-puzzle using A* algorithm.

To change the initial state of the puzzle:
  1. Go to EightPuzzle.java file
  2. Go to main method.
  3. Edit the 'initial' two-dimensional array that represents the state of the puzzle.
    - Use '0' to represent the empty tile.
  4. The pre-filled state in the code is representing the state:
    -------------
    | 7 | 2 | 4 |
    -------------
    | 5 |   | 6 |
    -------------
    | 8 | 3 | 1 |
    -------------
 
To run the code with the initial state set you must have Java installed, and should be able to run javac and java commands in your terminal:
  1. Go to your terminal
  2. Run command:
    cd (Path of Project)/AI_Assignment_1
  3. Run the following commands:
    javac EightPuzzle.java
    java EightPuzzle
  4. The code may take a while, but it should print the optimal path for solving the puzzle and should show a final state:
    -------------
    |   | 1 | 2 |
    -------------
    | 3 | 4 | 5 |
    -------------
    | 6 | 7 | 8 |
    -------------
    
 ENJOY!
