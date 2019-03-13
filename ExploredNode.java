
/**
* A Node to save a state when explored, to ease the backtracking.
* Author: Kelvin Roche
* Last Update: 3/12/2019
*/
public class ExploredNode
{
  private PuzzleState state;
  private ExploredNode previousState;
  private int runningSum;

  public ExploredNode(PuzzleState state, ExploredNode previousState)
  {
    this.state = state;
    this.previousState = previousState;
    if(previousState == null)
    {
      this.runningSum = 0;
    }
    else
    {
      this.runningSum = previousState.runningSum + 1;
    }
  }

  public PuzzleState getState()
  {
    return state;
  }

  public ExploredNode getPrev()
  {
    return previousState;
  }

  public int getRunningSum()
  {
    return runningSum;
  }

  public int getManhattanDistance()
  {
    return state.ManDistance();
  }

}
