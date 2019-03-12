import java.util.HashMap;


public class EightPuzzle
{

  public static void main(String[] args)
  {

    PuzzleState initial_state;
    PuzzleState goal_state;
    HashMap<Integer, PuzzleState> states;
    HashMap<Integer,Integer> MD;

    int[][] initial = new int[][]
    {
      {7,2,4},
      {5,0,6},
      {8,3,1}
    };
    int[][] goal = new int[][]
    {
      {0,1,2},
      {3,4,5},
      {6,7,8}
    };

    initial_state = new PuzzleState(initial);
    goal_state = new PuzzleState(goal);
    int[] located = initial_state.locateEmpty();
    System.out.println(initial_state);
    initial_state.moveLeft(located[0],located[1]);
    //located = initial_state.locateEmpty();
    System.out.println(initial_state);


  }

}
