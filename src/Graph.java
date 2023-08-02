
import java.util.*;

public class Graph {

    HashMap<Node, LinkedList<Node>> adjancencyMap;
    boolean directed;

    Graph(boolean directed) {
        this.directed = directed;
        adjancencyMap = new HashMap<>();
    }

    public void addNode(Node node) {
        //add unique node to map
        if (!adjancencyMap.containsKey(node)) {
            adjancencyMap.put(node, new LinkedList<>());
        }
    }

    public void insertEdge(Node source, Node target,int cost) {
        if (!adjancencyMap.keySet().contains(source)) {
            LinkedList<Node> tmp = new LinkedList<Node>();
            tmp.add(target);
            adjancencyMap.put(source, tmp);
        } else {
            LinkedList<Node> tmp = adjancencyMap.get(source);
            tmp.add(target);
            adjancencyMap.put(source, tmp);
        }
        target.setCost(cost);
        System.out.println(target.getName()+""+target.getCost());
    }

    public void printEdges() {
        for (Node node : adjancencyMap.keySet()) {
            System.out.println(node.getName());
        }

    }

    public void dfs(Node ns, Node nf) {
        Stack<Node> stack = new Stack<>();

        stack.push(ns);
        ns.visited = true;
        while (!stack.isEmpty()) {
            Node current = stack.pop();
            System.out.println("Visiting Node: " + current.getName());
            if (current == nf) {
                System.out.println("Found target node " + nf.getName());
                return;
            }
            //get the neighbors of the current node if there is else return new linked list
            List<Node> neighbors = adjancencyMap.getOrDefault(current, new LinkedList<>());
            for (Node neighbor : neighbors) {
                System.out.println("neighbor"+neighbor.getName()+""+neighbor.getCost());

                if (!neighbor.visited) {
                    stack.push(neighbor);
                    neighbor.visited = true;
                }
            }
        }
    }

    public void bfs(Node ns, Node nf) {
        LinkedList<Node> queue = new LinkedList<Node>();

        queue.offer(ns);
        ns.visited = true;

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.println("Bfs: Visiting node: " + current.getName());
            if (current == nf) {
                System.out.println("BFS: Found target node: " + nf.getName());
                return;
            }
            List<Node> neighbors = adjancencyMap.getOrDefault(current, new LinkedList<>());
            for (Node neighbor : neighbors) {
                System.out.println("neighbor"+neighbor.getName()+""+neighbor.getCost());
                if (!neighbor.visited) {
                    queue.offer(neighbor);
                    neighbor.visited = true;
                }
            }
            System.out.println("BFS: Target Node: " + nf.getName() + " Not found");
        }
    }

    public void uniformCostSearch(Node ns, Node nf)
    {

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();

        priorityQueue.offer(ns);
        ns.visited = true;

        Map<Node,Integer> costMap = new HashMap<>();
        costMap.put(ns,0);

        while(!priorityQueue.isEmpty())
        {
            Node current = priorityQueue.poll();
            System.out.println("UCS: visiting node: "+current.getName());
            if(current == nf)
            {
                System.out.println("UCS: Found target node: "+nf.getName());
                return;

            }
            List<Node> neighbors = adjancencyMap.getOrDefault(current,new LinkedList<>());
            for(Node neighbor:neighbors)
            {
//                System.out.println("neihbor cost = "+neighbor.getName()+""+neighbor.getCost());
//                int newCost = costMap.get(current) +neighbor.cost;
                if(!neighbor.visited )
                {
//                    costMap.put(neighbor,newCost);
                    priorityQueue.offer(neighbor);
                    neighbor.visited = true;
                }
            }

        }
        System.out.println("UCS: Target Node: "+nf.getName() + "Not found");

    }

}

