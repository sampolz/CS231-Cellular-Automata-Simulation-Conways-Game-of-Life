/*
 * Sam Polyakov
 * Landscape.java
 * 02/19/2023
 * Project 2
 * CS231 B
 */

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Landscape {

    /**
     * The underlying grid of Cells for Conway's Game
     */
    private Cell[][] landscape;

    /**
     * The original probability each individual Cell is alive
     */
    private double initialChance;

    /**
     * Constructs a Landscape of the specified number of rows and columns.
     * All Cells are initially dead.
     * 
     * @param rows    the number of rows in the Landscape
     * @param columns the number of columns in the Landscape
     */
    public Landscape(int rows, int columns) {
        landscape = new Cell[rows][columns];
        initialChance = 0;
        this.reset();
    }

    /**
     * Constructs a Landscape of the specified number of rows and columns.
     * Each Cell is initially alive with probability specified by chance.
     * 
     * @param rows    the number of rows in the Landscape
     * @param columns the number of columns in the Landscape
     * @param chance  the probability each individual Cell is initially alive
     */
    public Landscape(int rows, int columns, double chance) {
        landscape = new Cell[rows][columns];
        initialChance = chance;
        this.reset();

        for(int i =0; i<getRows(); i++){
            for(int j=0; j<getCols(); j++){
                landscape[i][j] = new Cell();

                if(Math.random() < initialChance){
                    landscape[i][j].setAlive(true);
                }
                else{
                    landscape[i][j].setAlive(false);
                }
            }
        }
    }

    /**
     * Recreates the Landscape according to the specifications given
     * in its initial construction.
     */
    public void reset() {
        // ASK ABT THIS
        for(int i =0; i<getRows(); i++){
            for(int j=0; j<getCols(); j++){
                landscape[i][j] = new Cell();

                landscape[i][j].setAlive(false);
                }
            }
    }

    /**
     * Returns the number of rows in the Landscape.
     * 
     * @return the number of rows in the Landscape
     */
    public int getRows() {
        return landscape.length;
    }

    /**
     * Returns the number of columns in the Landscape.
     * 
     * @return the number of columns in the Landscape
     */
    public int getCols() {
        return landscape[0].length;
    }

    /**
     * Returns the Cell specified the given row and column.
     * 
     * @param row the row of the desired Cell
     * @param col the column of the desired Cell
     * @return the Cell specified the given row and column
     */
    public Cell getCell(int row, int col) {
        return landscape[row][col];
    }

    /**
     * Returns a String representation of the Landscape.
     */
    public String toString() {
        String rep = "";
        for(int i =0; i<getRows(); i++){
            for(int j=0; j<getCols(); j++){
                rep += getCell(i, j);
            }
            rep += "\n";
        }
        return rep;
    }

    /**
     * Returns an ArrayList of the neighboring Cells to the specified location.
     * 
     * @param row the row of the specified Cell
     * @param col the column of the specified Cell
     * @return an ArrayList of the neighboring Cells to the specified location
     */
    public ArrayList<Cell> getNeighbors(int row, int col) {
        ArrayList<Cell> neighbors = new ArrayList<Cell>();
        for(int r = row-1; r <= row+1; r++){
            for(int c = col-1; c <= col+1; c++){
                if(r >= 0 && c >= 0 && r < getRows() && c < getCols()){
                    neighbors.add(landscape[r][c]); 
                }
            }
        }
        neighbors.remove(landscape[row][col]);
        return neighbors;
    }

    /**
     * Advances the current Landscape by one step. 
     */
    public void advance() {
        Cell[][] copy = new Cell[getRows()][getCols()];
        copy = landscape;
        
        for(int i =0; i<getRows(); i++){
            for(int j=0; j<getCols(); j++){
                Cell c = copy[i][j];
                c.updateState(getNeighbors(i, j));
            }
        }
        landscape = copy;
    }

    /**
     * Draws the Cell to the given Graphics object at the specified scale.
     * An alive Cell is drawn with a black color; a dead Cell is drawn gray.
     * 
     * @param g     the Graphics object on which to draw
     * @param scale the scale of the representation of this Cell
     */
    public void draw(Graphics g, int scale) {
        for (int x = 0; x < getRows(); x++) {
            for (int y = 0; y < getCols(); y++) {
                g.setColor(getCell(x, y).getAlive() ? Color.BLACK : Color.gray);
                g.fillOval(x * scale, y * scale, scale, scale);
            }
        }
    }

    public static void main(String[] args) {
        // Landscape landscape = new Landscape(30, 20, .25);
        // landscape.draw();
    }
}