package com.example.graph.algorithms;

import com.example.graph.model.Graph;

/** Detects whether a directed graph contains a cycle. */
public class CycleDetector {
    private final TopologicalSort topologicalSort = new TopologicalSort();

    public boolean hasCycle(Graph graph) {
        try {
            topologicalSort.sort(graph);
            return false;
        } catch (IllegalStateException ex) {
            return true;
        }
    }
}
