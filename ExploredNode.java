
/**
* A Node to save a state when explored, to ease the backtracking.
* Author: Kelvin Roche
* Last Update: 3/12/2019
*/
public class ExploredNode
{
  private PuzzleState state;
  private ExploredNode previousState;

  public ExploredNode(PuzzleState state, ExploredNode previousState)
  {
    this.state = state;
    this.previousState = previousState;
  }

  public PuzzleState getState()
  {
    return state;
  }

  public ExploredNode getPrev()
  {
    return previousState;
  }

}
