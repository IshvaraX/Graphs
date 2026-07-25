package com.example.graph;

import com.example.graph.algorithms.Dijkstra;
import com.example.graph.model.Edge;
import com.example.graph.model.Graph;

/** Small runnable demo for the graph library. */
public class App {

    public static void main(String[] args) {
        Graph graph = new Graph(true);
        graph.addEdge(new Edge("A", "B", 1.0));
        graph.addEdge(new Edge("B", "C", 2.0));
        graph.addEdge(new Edge("A", "C", 5.0));

        Dijkstra dijkstra = new Dijkstra(graph);
        System.out.println(dijkstra.shortestPaths("A"));
    }
}
