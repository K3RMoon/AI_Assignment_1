import java.util.HashMap;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Comparator;

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
    initial_state = new PuzzleState(initial);

    ArrayList<PuzzleState> solution = runAStar(initial_state);
    for(PuzzleState state : solution)
    {
      System.out.println(state);
    }


  }

  public static ArrayList<PuzzleState> runAStar(PuzzleState initial_state)
  {
    Comparator<ExploredNode> comparator = new NodeComparator();
    PriorityQueue<ExploredNode> frontier = new PriorityQueue<>(10, comparator);
    //the number 10 means nothing, were just obligated to have an initial capacity,
           //but it grows as needed
           /**
            * Method names according to the JAVA API:
            * add(element)
            * peek() --> equivalent to min()
            * poll() --> equivalent to poll()
            */
    ExploredList explored = new ExploredList();
    ArrayList<PuzzleState> toReturn = new ArrayList<PuzzleState>();

    frontier.add(new ExploredNode(initial_state, null));

    while(explored.isEmpty() || explored.getLast().getManhattanDistance() != 0)
    {
        explored.add(frontier.poll());
        PuzzleState[] possibleStates = explored.getLast().getState().possibleMoves();
        int counter = 0;
        while(counter != 4 && possibleStates[counter] != null)
        {
          PuzzleState possState = possibleStates[counter];
          ExploredNode newNode = new ExploredNode(possState, explored.getLast());
          frontier.add(newNode);
          counter++;
        }

    }
    ExploredNode check = explored.getLast();
    while(check != null)
    {
      toReturn.add(check.getState());
      check = check.getPrev();
    }
    return toReturn;
  }

}
