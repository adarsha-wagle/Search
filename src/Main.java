import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Graph graph = new Graph(false);
        Scanner scan = new Scanner(System.in);

        Node ns = new Node(1,"Arad",false);
        graph.addNode(ns);
        Node n2 = new Node(2,"Zerind",false);
        graph.addNode(n2);
        Node n3 = new Node(3,"Oradea",false);
        graph.addNode(n3);
        Node n4 = new Node(4,"Sibiu",false);
        graph.addNode(n4);
        Node n5 = new Node(5,"Fagaras",false);
        graph.addNode(n5);
        Node n6 = new Node(6,"Rimnicu Vilcea",false);
        graph.addNode(n6);
        Node n7 = new Node(7,"Pitesti",false);
        graph.addNode(n7);

        Node n8 = new Node(8,"Timisoara",false);
        graph.addNode(n8);
        Node n9 = new Node(9,"Lugoj",false);
        graph.addNode(n9);
        Node n10 = new Node(10,"Mehadia",false);
        graph.addNode(n10);
        Node n11 = new Node (11,"Dobreta",false) ;
        graph.addNode(n11);
        Node n12 = new Node(12,"Craiova",false);
        graph.addNode(n12);
        Node nf = new Node(13,"Bucharest",false);
        graph.addNode(nf);

       //Arad to
        graph.insertEdge(ns,n2,75);
        graph.insertEdge(ns,n4,140);
        graph.insertEdge(ns,n8,118);

        //Zerind to
        graph.insertEdge(n2,n3,71);

        //Sibiu to
        graph.insertEdge(n4,n5,99);
        graph.insertEdge(n4,n6,80);

        //Timisoara to
        graph.insertEdge(n8,n9,111);


        //Oradea to
        graph.insertEdge(n3,n4,151);


        //Fagaras to
        graph.insertEdge(n5,nf,211);

        //Rimnicu Vilcea to
        graph.insertEdge(n6,n7,97);
        graph.insertEdge(n6,n12,146);

        //Lugoj to
        graph.insertEdge(n9,n10,70);

        //Mehadia to
        graph.insertEdge(n10,n11,75);

        //Dobreta to
        graph.insertEdge(n11,n12,120);

        //Craiova to
//        graph.insertEdge(n12,n6,146);
        graph.insertEdge(n12,n7,138);

        //Pitesti to
        graph.insertEdge(n7,nf,101);

        System.out.println("What you want to peform: ");
        System.out.println("1.BFS");
        System.out.println("2.DFS");
        System.out.println("3.Uniform Cost Search");
        int selectId = scan.nextInt();

        if(selectId == 1)
        {
            System.out.println("Starting BFS: ");
            graph.bfs(ns,nf);
        }

        else if (selectId == 2)
        {
            System.out.println("Starting DFS: ");
            graph.dfs(ns,nf);
        }
        else if (selectId==3)
        {
            System.out.println("Starting UCS: ");
            graph.uniformCostSearch(ns,nf);
        }
        else {
            System.out.println("Select Valid Option");
        }
    }
}