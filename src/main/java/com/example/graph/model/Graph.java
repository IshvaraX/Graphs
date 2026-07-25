package com.example.graph.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/** An adjacency-map based weighted graph, directed or undirected. */
public class Graph {
    private final boolean directed;
    private final Map<String, Map<String, Double>> adjacency = new HashMap<>();

    public Graph(boolean directed) {
        this.directed = directed;
    }

    public boolean isDirected() {
        return directed;
    }

    public void addNode(String node) {
        adjacency.computeIfAbsent(node, key -> new HashMap<>());
    }

    public void addEdge(Edge edge) {
        addNode(edge.getSource());
        addNode(edge.getTarget());
        adjacency.get(edge.getSource()).put(edge.getTarget(), edge.getWeight());
        if (!directed) {
            adjacency.get(edge.getTarget()).put(edge.getSource(), edge.getWeight());
        }
    }

    public Map<String, Double> neighbors(String node) {
        return adjacency.getOrDefault(node, Collections.emptyMap());
    }

    public Set<String> nodes() {
        return adjacency.keySet();
    }
}
