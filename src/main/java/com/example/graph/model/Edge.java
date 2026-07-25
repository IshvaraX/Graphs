package com.example.graph.model;

/** An immutable weighted edge between two nodes. */
public class Edge {
    private final String source;
    private final String target;
    private final double weight;

    public Edge(String source, String target, double weight) {
        if (source == null || target == null) {
            throw new IllegalArgumentException("source and target are required");
        }
        if (weight < 0) {
            throw new IllegalArgumentException("weight cannot be negative");
        }
        this.source = source;
        this.target = target;
        this.weight = weight;
    }

    public String getSource() {
        return source;
    }

    public String getTarget() {
        return target;
    }

    public double getWeight() {
        return weight;
    }
}
