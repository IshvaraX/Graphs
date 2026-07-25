package com.example.graph.algorithms;

import com.example.graph.model.Graph;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/** Computes single-source shortest paths using Dijkstra's algorithm. */
public class Dijkstra {
    private final Graph graph;

    public Dijkstra(Graph graph) {
        this.graph = graph;
    }

    public Map<String, Double> shortestPaths(String source) {
        if (!graph.nodes().contains(source)) {
            throw new IllegalArgumentException("Unknown source: " + source);
        }
        Map<String, Double> distances = new HashMap<>();
        for (String node : graph.nodes()) {
            distances.put(node, Double.POSITIVE_INFINITY);
        }
        distances.put(source, 0.0);

        PriorityQueue<String> queue = new PriorityQueue<>(Comparator.comparingDouble(distances::get));
        queue.add(source);
        while (!queue.isEmpty()) {
            String node = queue.poll();
            for (Map.Entry<String, Double> entry : graph.neighbors(node).entrySet()) {
                double candidate = distances.get(node) + entry.getValue();
                if (candidate < distances.get(entry.getKey())) {
                    distances.put(entry.getKey(), candidate);
                    queue.add(entry.getKey());
                }
            }
        }
        return distances;
    }
}
