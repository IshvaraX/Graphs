package com.example.graph.algorithms;

import com.example.graph.model.Graph;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** Produces a topological ordering of a directed acyclic graph. */
public class TopologicalSort {

    public List<String> sort(Graph graph) {
        if (!graph.isDirected()) {
            throw new IllegalStateException("Topological sort requires a directed graph");
        }

        Map<String, Integer> indegree = new HashMap<>();
        for (String node : graph.nodes()) {
            indegree.putIfAbsent(node, 0);
            for (String neighbor : graph.neighbors(node).keySet()) {
                indegree.merge(neighbor, 1, Integer::sum);
            }
        }

        Deque<String> queue = new ArrayDeque<>();
        for (Map.Entry<String, Integer> entry : indegree.entrySet()) {
            if (entry.getValue() == 0) {
                queue.add(entry.getKey());
            }
        }

        List<String> order = new ArrayList<>();
        while (!queue.isEmpty()) {
            String node = queue.poll();
            order.add(node);
            for (String neighbor : graph.neighbors(node).keySet()) {
                indegree.merge(neighbor, -1, Integer::sum);
                if (indegree.get(neighbor) == 0) {
                    queue.add(neighbor);
                }
            }
        }

        if (order.size() != graph.nodes().size()) {
            throw new IllegalStateException("Graph contains a cycle");
        }
        return order;
    }
}
