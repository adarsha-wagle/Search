public class Node implements  Comparable<Node> {
    int nodeId;
    String name;
    boolean visited;
    int cost;
    Node(int nodeId,String name,boolean visited)
    {
        this.nodeId = nodeId;
        this.name = name;
        this.visited = visited;
//        this.cost = Integer.MAX_VALUE;
    }

    public String getName()
    {
        return name;
    }
    public void setCost(int cost)
    {
        this.cost = cost;
    }
    public int getCost()
    {
        return cost;
    }
    @Override
    public int compareTo(Node other)
    {
//        System.out.println("current "+this.getName()+" "+this.cost + " other ="+other.cost);
        return Integer.compare(this.cost,other.cost);
    }
}
