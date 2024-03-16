package org.jetbrains.assignment.model;

public enum Direction {
    EAST("EAST"),
    WEST("WEST"),
    NORTH("NORTH"),
    SOUTH("SOUTH");

    private final String direction;
    Direction(String direction) {
        this.direction = direction;
    }

    public String toString() {
        return this.direction;
    }
}
