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
     * @param x position selon l'axe des abscisses
     * @param y position selon l'axe des ordonnées
     * @return true si le robot est dans le plateau et false si la position au-dehors du plateau
     */
    public boolean isValidPosition(int x, int y) {
        return x >= 0 && x <= maxX && y >= 0 && y <= maxY;
    }
}
