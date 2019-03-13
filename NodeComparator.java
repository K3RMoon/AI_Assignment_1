import java.util.Comparator;

public class NodeComparator implements Comparator<ExploredNode>{
    // Used for sorting in ascending order of
    // f(n) + h(n)
    public int compare(ExploredNode a, ExploredNode b)
    {
        return (a.getRunningSum()+a.getManhattanDistance()) - (b.getRunningSum()+b.getManhattanDistance());
    }
}
