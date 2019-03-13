import java.util.HashMap;

/*
* The Main Class of the Eight Puzzle Solver using
* A* algorithm.
*
* Author: Kelvin Roche
* Last Update: 3/12/2019
*/
public class EightPuzzle
{

  public static void main(String[] args)
  {

    PuzzleState initial_state; //The initial state of the puzzle
    PuzzleState goal_state; //The goal state of the puzzle
    HashMap<Integer, PuzzleState> states; //A map with all the states and an
                                          //identifier for it
    HashMap<Integer,Integer> MD; //A map containing the Manhattan Distance of
                                //every state
    ExploredList explored = new ExploredList();

    //Setting Up Initial State
    int[][] initial = new int[][]
    {
      {7,2,4},
      {5,0,6},
      {8,3,1}
    };

    //Setting Up Goal State
    int[][] goal = new int[][]
    {
      {0,1,2},
      {3,4,5},
      {6,7,8}
    };

    initial_state = new PuzzleState(initial); //Creating the initial state Object
    goal_state = new PuzzleState(goal); //Creating the goal state object

    //Testing
    int[] located = initial_state.locateEmpty();
    System.out.println(initial_state);
    initial_state.moveLeft(located[0],located[1]);
    //located = initial_state.locateEmpty();
    System.out.println(initial_state);


  }

}
