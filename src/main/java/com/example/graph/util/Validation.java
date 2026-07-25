package com.example.graph.util;

/** Reusable argument validation helpers. */
public final class Validation {

    private Validation() {
    }

    public static void requireNonNull(Object value, String name) {
        if (value == null) {
            throw new IllegalArgumentException(name + " must not be null");
        }
    }

    public static double requireNonNegative(double value, String name) {
        if (value < 0) {
            throw new IllegalArgumentException(name + " must be non-negative");
        }
        return value;
    }
}
