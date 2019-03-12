

public class PuzzleState
{
  private int[][] arr;
  public PuzzleState(int[][] arr)
  {
    this.arr = arr;
  }

  public int[][] getState()
  {
    return arr;
  }

  public boolean equals(int[][] otherArr)
  {
    for(int i = 0; i < 3; i++)
    {
      for(int j = 0; j < 3; j++)
      {
        if(this.arr[i][j] != otherArr[i][j])
          return false;
      }
    }

    return true;
  }

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

  public void moveLeft(int i, int j)
  {
    this.arr[i][j] = this.arr[i][j-1];
    this.arr[i][j-1] = 0;
  }

  public void moveRight(int i, int j)
  {
    this.arr[i][j] = this.arr[i][j+1];
    this.arr[i][j+1] = 0;
  }

  public void moveUp(int i, int j)
  {
    this.arr[i][j] = this.arr[i-1][j];
    this.arr[i-1][j] = 0;
  }

  public void moveDown(int i, int j)
  {
    this.arr[i][j] = this.arr[i+1][j];
    this.arr[i+1][j] = 0;
  }

  public String toString()
  {
    String toReturn = "\n------------\n| "+this.arr[0][0]+" | "+this.arr[0][1]+" | "+this.arr[0][2]+" |\n------------\n| "+this.arr[1][0]+" | "+this.arr[1][1]+" | "+this.arr[1][2]+ " |\n------------\n| " +this.arr[2][0]+" | "+this.arr[2][1]+" | "+this.arr[2][2]+" |\n------------\n";
    return toReturn;
  }

}
