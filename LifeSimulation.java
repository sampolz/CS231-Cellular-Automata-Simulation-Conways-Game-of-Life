/*
 * Sam Polyakov
 * LifeSimulation.java
 * 02/19/2023
 * Project 2
 * CS231 B
 */

import java.util.Scanner;

public class LifeSimulation {
    // Runs LifeSimulation by advancing a landscape 1000 times.
    // When run, asks user to input rows, cols, and density of landscape
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter rows, cols, and density (eg: 100 100 .25): ");

        int xcor = scanner.nextInt();
        int ycor = scanner.nextInt();
        double density = scanner.nextDouble();

        Landscape scape = new Landscape(xcor, ycor, density);
        LandscapeDisplay display = new LandscapeDisplay(scape, 6);

        for(int i = 0; i < 1000; i++) {
            Thread.sleep(250);
            scape.advance();
            display.repaint();
        }

        scanner.close();
    }
}
