package com.bnp.rover.model;

public class Plateau {
    private int maxX;
    private int maxY;

    public Plateau(int maxX, int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
    }

    /**
     *
     * @param x position on the x-axis
     * @param y position on the y-axis
     * @return true if the robot is within the plateau, false if the position is outside the plateau
     */
    public boolean isValidPosition(int x, int y) {
        return x >= 0 && x <= maxX && y >= 0 && y <= maxY;
    }
}
