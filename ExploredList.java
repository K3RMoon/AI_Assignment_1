public class ExploredList
{
  ExploredNode lastAdded;
  int size;

  public ExploredList()
  {
    lastAdded = null;
    size = 0;
  }

  public add(ExploredNode node)
  {
    lastAdded = node;
    size++;
  }

  public boolean isEmpty()
  {
    return size<=0;
  }

  public ExploredNode getLast()
  {
    return lastAdded;
  }
}
