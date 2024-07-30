package datastructures;

import org.junit.Test;

public class GraphTest {

    @Test
    public void testAddVertex() {
        Graph myGraph = new Graph();

        myGraph.addVertex("A");
        myGraph.addVertex("B");

        System.out.println("Graph:");
        myGraph.printGraph();

    }

    @Test
    public void testAddEdge() {
        Graph myGraph = new Graph();

        myGraph.addVertex("A");
        myGraph.addVertex("B");


        System.out.println("Graph before addEdge():");
        myGraph.printGraph();


        myGraph.addEdge("A", "B");


        System.out.println("\nGraph after addEdge():");
        myGraph.printGraph();
    }

    @Test
    public void testRemoveEdge() {
        Graph myGraph = new Graph();

        myGraph.addVertex("A");
        myGraph.addVertex("B");
        myGraph.addVertex("C");

        myGraph.addEdge("A", "B");
        myGraph.addEdge("A", "C");
        myGraph.addEdge("B", "C");


        System.out.println("Graph before removeEdge():");
        myGraph.printGraph();

        myGraph.removeEdge("A", "B");

        System.out.println("\nGraph after removeEdge():");
        myGraph.printGraph();
    }

    @Test
    public void testRemoveVertex() {
        Graph myGraph = new Graph();

        myGraph.addVertex("A");
        myGraph.addVertex("B");
        myGraph.addVertex("C");
        myGraph.addVertex("D");

        myGraph.addEdge("A", "B");
        myGraph.addEdge("A", "C");
        myGraph.addEdge("A", "D");
        myGraph.addEdge("B", "D");
        myGraph.addEdge("C", "D");


        System.out.println("Graph before removeVertex():");
        myGraph.printGraph();

        myGraph.removeVertex("D");

        System.out.println("\nGraph after removeVertex():");
        myGraph.printGraph();
    }
}
