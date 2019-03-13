import java.lang.Math;
import java.util.*;
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


  private HashMap<Integer,Integer[]> pStates;

  /*
  * Constructor of PuzzleState Object
  * param: arr - a two dimensional array representing the state
  */
  public PuzzleState(int[][] arr)
  {
    this.arr = arr;
    pStates = new HashMap<Integer,Integer[]>();
    pStates.put(0,new Integer[]{0,0});
    pStates.put(1,new Integer[]{0,1});
    pStates.put(2,new Integer[]{0,2});
    pStates.put(3,new Integer[]{1,0});
    pStates.put(4,new Integer[]{1,1});
    pStates.put(5,new Integer[]{1,2});
    pStates.put(6,new Integer[]{2,0});
    pStates.put(7,new Integer[]{2,1});
    pStates.put(8,new Integer[]{2,2});
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

  public boolean canMoveRight (int j){
  		if((j+1)==3)
  		return false;
  	return true;
  }

  public boolean canMoveLeft (int j){
  		if((j-1)==-1)
  		return false;
  	return true;
  }

  public boolean canMoveDown(int i){
  		if((i+1)==3)
  		return false;
  	return true;
  }
  public boolean canMoveUp (int i){
  		if((i-1)==-1)
  		return false;
  	return true;
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
    toReturn = toReturn.replace('0',' ');
    return toReturn;
  }

  public int ManDistance()
  {
    int mdReturn = 0;
    for(int i = 0; i < 3; i++)
    {
      for(int j = 0; j < 3; j++)
      {
        int actualPos = arr[i][j];
        if(actualPos != 0)
        {
          Integer[] actualCoor = pStates.get(actualPos);
          mdReturn += Math.abs(i-actualCoor[0]) + Math.abs(j-actualCoor[1]);
        }
      }
    }
    return mdReturn;
  }

  public PuzzleState clone()
  {
    int[][] newArr = new int[3][3];
    for(int i = 0; i < 3; i++)
    {
      for(int j = 0; j < 3; j++)
      {
        newArr[i][j] = arr[i][j];
      }
    }

    return new PuzzleState(newArr);
  }

  public PuzzleState[] possibleMoves()
  {
    PuzzleState[] nodes = new PuzzleState[4];
    int counter = 0;
    int[] empty = locateEmpty();
    if(canMoveUp(empty[0]))
    {
      PuzzleState pU = this.clone();
      pU.moveUp(empty[0],empty[1]);
      nodes[counter] = pU;
      counter++;
    }

    if(canMoveDown(empty[0]))
    {
      PuzzleState pD = this.clone();
      pD.moveDown(empty[0],empty[1]);
      nodes[counter] = pD;
      counter++;
    }

    if(canMoveLeft(empty[1]))
    {
      PuzzleState pL = this.clone();
      pL.moveLeft(empty[0],empty[1]);
      nodes[counter] = pL;
      counter++;
    }

    if(canMoveRight(empty[1]))
    {
      PuzzleState pR = this.clone();
      pR.moveRight(empty[0],empty[1]);
      nodes[counter] = pR;
      counter++;
    }

    return nodes;
  }


}
