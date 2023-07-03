/*
file name:      LandscapeTests.java
Authors:        Max Bender & Naser Al Madi & Sam Polyakov
last modified:  2/19/2023

How to run:     java -ea LandscapeTests
*/


import java.util.ArrayList;

public class LandscapeTests {

    public static void landscapeTests() {

        // case 1: testing Landscape(int, int)
        {
            // set up
            Landscape l1 = new Landscape(2, 4, 0.5);
            Landscape l2 = new Landscape(10, 10, 0.5);

            // verify
            System.out.println(l1);
            System.out.println("\n");
            System.out.println(l2);

            // test
            assert l1 != null : "Error in Landscape::Landscape(int, int)";
            assert l2 != null : "Error in Landscape::Landscape(int, int)";
        }

        // case 2: testing reset()
        {
            // set up
            Landscape l1 = new Landscape(2, 4, 0.5);
            Landscape l2 = new Landscape(10, 10, 0.5);

            l1.reset();
            l2.reset();
            // verify
            System.out.println(l1);
            System.out.println(l2);

            // test
            assert l1.getCell(0, 0) != l1.getCell(1, 1) : "Error in Landscape::reset()";
            assert l1.getCell(1, 2) != l1.getCell(0, 3) : "Error in Landscape::reset()";


            assert l2.getCell(0, 0) != l2.getCell(1, 1) : "Error in Landscape::reset()";
            assert l2.getCell(0, 1) != l2.getCell(1, 2) : "Error in Landscape::reset()";
            assert l2.getCell(2, 2) != l2.getCell(3, 3) : "Error in Landscape::reset()";
            assert l2.getCell(4, 4) != l2.getCell(5, 5) : "Error in Landscape::reset()";
            assert l2.getCell(7, 7) != l2.getCell(9, 9) : "Error in Landscape::reset()";
        }

        // case 3: testing getRows()
        {
            // set up
            Landscape l1 = new Landscape(2, 4, 0.5);
            Landscape l2 = new Landscape(10, 10, 0.5);

            // verify
            System.out.println(l1.getRows());
            System.out.println(l2.getRows());
            System.out.println("\n");

            // test
            assert l1.getRows() == 2 : "Error in Landscape::getRows()";
            assert l2.getRows() == 10 : "Error in Landscape::getRows()";
        }

        // case 4: testing getCols()
        {
            // set up
            Landscape l1 = new Landscape(2, 4, 0.5);
            Landscape l2 = new Landscape(10, 10, 0.5);

            // verify
            System.out.println(l1.getCols());
            System.out.println(l2.getCols());
            System.out.println("\n");
            // test
            assert l1.getCols() == 4 : "Error in Landscape::getCols()";
            assert l2.getCols() == 10 : "Error in Landscape::getCols()";
        }

        // case 5: testing getCell(int, int)
        {
            // set up
            Landscape l = new Landscape(3, 3, 0.5);

            // verify
            System.out.println(l.getCell(0, 0));
            System.out.println(l.getCell(1, 2));
            System.out.println(l.getCell(2, 1));
            System.out.println(l.getCell(0, 2));
            System.out.println(l.getCell(2, 0));
            System.out.println("\n");


            // test
            assert l.getCell(0, 0) == l.getCell(0, 0) : "Error in Landscape::getCell";
            assert l.getCell(1, 2) == l.getCell(1, 2) : "Error in Landscape::getCell";
            assert l.getCell(2, 1) == l.getCell(2, 1) : "Error in Landscape::getCell";
            assert l.getCell(0, 2) == l.getCell(0, 2) : "Error in Landscape::getCell";
            assert l.getCell(2, 0) == l.getCell(2, 0) : "Error in Landscape::getCell";
        }
        

        // case 6: testing getNeighbors()
        {
            // set up
            Landscape l = new Landscape(5, 5, 0.5);

            // // verify
            System.out.println(l.getNeighbors(0, 0));
            System.out.println(l.getNeighbors(2, 0));
            System.out.println(l.getNeighbors(2, 2));
            System.out.println(l.getNeighbors(3, 3));
            System.out.println(l.getNeighbors(4, 4));
            System.out.println("\n");

            // test
            assert l.getNeighbors(0, 0) != null : "Error in Landscape::getNeighbors";
            assert l.getNeighbors(2, 0) != null : "Error in Landscape::getNeighbors";
            assert l.getNeighbors(2, 2) != null : "Error in Landscape::getNeighbors";
            assert l.getNeighbors(3, 3) != null : "Error in Landscape::getNeighbors";
            assert l.getNeighbors(4, 4) != null : "Error in Landscape::getNeighbors";
        }

        // case 7: testing advance()
        {
            // set up
            Landscape l = new Landscape(3, 3, 0.5);

            // verify
            System.out.println(l);
            l.advance();
            System.out.println(l);

            // test
            assert l != null : "Error in Landscape::advance";
        }

    
    }

    public static void main(String[] args) {

        landscapeTests();
    }
}