/*
 * Sam Polyakov
 * Cell.java
 * 02/19/2023
 * Project 2
 * CS231 B
 */

import java.util.ArrayList;

public class Cell {
    /**
     * The status of the Cell.
     */
    private boolean alive;

    /**
     * Constructs a dead cell.
     */
    public Cell() {
        this(false);
    }

    /**
     * Constructs a cell with the specified status.
     * 
     * @param status a boolean to specify if the Cell is initially alive
     */
    public Cell(boolean status) {
        alive = status;
    }

    /**
     * Returns whether the cell is currently alive.
     * 
     * @return whether the cell is currently alive
     */
    public boolean getAlive() {
        return alive;
    }

    /**
     * Sets the current status of the cell to the specified status.
     * 
     * @param status a boolean to specify if the Cell is alive or dead
     */
    public void setAlive(boolean status) {
        alive = status;
    }

    /**
     * Updates the state of the Cell.
     * 
     * If this Cell is alive and if there are 2 or 3 alive neighbors,
     * this Cell stays alive. Otherwise, it dies.
     * 
     * If this Cell is dead and there are 3 alive neighbors,
     * this Cell comes back to life. Otherwise, it stays dead.
     * 
     * @param neighbors An ArrayList of Cells
     */
    public void updateState(ArrayList<Cell> neighbors) {
        boolean cellStatus = this.getAlive();
        int aliveNeighbors = 0;

        for(int i = 0; i<neighbors.size(); i++){
            Cell c = neighbors.get(i);
            if(c.getAlive()==true){
                aliveNeighbors++;
            }
        }
        if(cellStatus == true){
            if(aliveNeighbors >= 2 && aliveNeighbors <= 3){
                this.setAlive(true);
            }
            else{
                this.setAlive(false);
            }
        }
        else if(cellStatus== false && aliveNeighbors == 3){
            this.setAlive(true);
        }
        else{
            this.setAlive(false);
        }
    }

    /**
     * Returns a String representation of this Cell.
     * 
     * @return 1 if this Cell is alive, otherwise 0.
     */
    public String toString() {
        if(this.getAlive()==true){
            return "1";
        }
        else{
            return "0";
        }
    }
}