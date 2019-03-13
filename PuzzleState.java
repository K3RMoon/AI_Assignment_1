
/**
* An object class to represent the state of the puzzle and control it
* For the sake of this project, we are representing the 'empty' tile with
* a '0'.
*
* Author: Kelvin Roche
* Last Update: 3/12/2019
**/
public class PuzzleState
{
  /*
  * Two-dimensional array to represent state of puzzle
  */
  private int[][] arr;

  /*
  * Constructor of PuzzleState Object
  * param: arr - a two dimensional array representing the state
  */
  public PuzzleState(int[][] arr)
  {
    this.arr = arr;
  }

  /*
  * Return the state of the puzzle
  * returns: a two-dimensional array representing the state of the puzzle
  * Author: Kelvin
  */
  public int[][] getState()
  {
    return arr;
  }

  /*
  * Verifies if this state is equal to another state
  * returns: true if the second state is representing the same state as this
  * one; false otherwise
  * Author: Kelvin
  */
  public boolean equals(PuzzleState otherState)
  {
    for(int i = 0; i < 3; i++)
    {
      for(int j = 0; j < 3; j++)
      {
        if(this.arr[i][j] != otherState.getState()[i][j])
          return false; //there's a difference, return false
      }
    }

    return true; //no differences, return true
  }

  /*
  * Returns the coordinates of the empty tile
  * returns: an array with 2 numbers, the first being the row number and the
  * second one being the column number
  * Author: Kelvin
  */
  public int[] locateEmpty()
  {
    for(int i = 0; i < 3; i++)
    {
      for(int j = 0; j < 3; j++)
      {
        if(this.arr[i][j] == 0)
          return new int[]{i,j};
      }
    }
     return null;
  }

  /*
  * Moves the empty tile to the left, switching its position with the tile
  * to its left (if any)
  * params: i is the row coordinate of the empty tile, j is the column
  * coordinate of the empty tile
  * Author: Kelvin
  */
  public void moveLeft(int i, int j)
  {
    this.arr[i][j] = this.arr[i][j-1];
    this.arr[i][j-1] = 0;
  }

  /*
  * Moves the empty tile to the right, switching its position with the tile
  * to its right (if any)
  * params: i is the row coordinate of the empty tile, j is the column
  * coordinate of the empty tile
  * Author: Kelvin
  */
  public void moveRight(int i, int j)
  {
    this.arr[i][j] = this.arr[i][j+1];
    this.arr[i][j+1] = 0;
  }

  /*
  * Moves the empty tile up, switching its position with the tile
  * right above it (if any)
  * params: i is the row coordinate of the empty tile, j is the column
  * coordinate of the empty tile
  * Author: Kelvin
  */
  public void moveUp(int i, int j)
  {
    this.arr[i][j] = this.arr[i-1][j];
    this.arr[i-1][j] = 0;
  }

  /*
  * Moves the empty tile down, switching its position with the tile
  * right below it (if any)
  * params: i is the row coordinate of the empty tile, j is the column
  * coordinate of the empty tile
  * Author: Kelvin
  */
  public void moveDown(int i, int j)
  {
    this.arr[i][j] = this.arr[i+1][j];
    this.arr[i+1][j] = 0;
  }

  /*
  * Returns a String representation of the puzzle state to print in screen
  * returns: a string representing the puzzle state
  * Author: Kelvin
  */
  public String toString()
  {
    String toReturn = "\n------------\n| "+this.arr[0][0]+" | "+this.arr[0][1]+" | "+this.arr[0][2]+" |\n------------\n| "+this.arr[1][0]+" | "+this.arr[1][1]+" | "+this.arr[1][2]+ " |\n------------\n| " +this.arr[2][0]+" | "+this.arr[2][1]+" | "+this.arr[2][2]+" |\n------------\n";
    return toReturn;
  }

}
