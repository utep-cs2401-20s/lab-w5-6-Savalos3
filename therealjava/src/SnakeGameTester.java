import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class SnakeGameTester {


    @Test
    public void testSG() { //I tested these values first to see if my code ran correctly.

        boolean[][] A = {{false, false, false, false},
                         {false, true, true, false},
                         {false, false, true, false},
                         {false, false, false, false}};
        int i = 1;
        int j = 1;
        int[] B = {2, 2, 3};
        SnakeGame test = new SnakeGame(A, i, j);
        assertArrayEquals(B, test.findTailExhaustive());

        test.findTailExhaustive();
        System.out.println(test.getExhaustiveChecks());//Prints the amount of checks.
    }

    @Test
    public void testSG1() { //This test case see

        boolean[][] A = {{true, true, true, true},
                         {false, false, false, false},
                         {false, false, false, false},
                         {false, false, false, false}};
        int i = 0;
        int j = 0;
        int[] B = {0, 3, 4};
        SnakeGame test = new SnakeGame(A, i, j);

        assertArrayEquals(B, test.findTailExhaustive());
        test.findTailExhaustive();
        System.out.println(test.getExhaustiveChecks());//Prints the amount of checks.
    }

    @Test
    public void testSG2() {

        boolean[][] A = {{false, false, false, false},
                         {false, false, false, false},
                         {false, true, false, false},
                         {false, true, true, true}};
        int i = 3;
        int j = 3;
        int[] B = {2, 1, 4};
        SnakeGame test = new SnakeGame(A, i, j);

        assertArrayEquals(B, test.findTailExhaustive());
        test.findTailExhaustive();
        System.out.println(test.getExhaustiveChecks());//Prints the amount of checks.
    }

    @Test
    public void testSG3() { //This tests an unnatural pattern and sees if code functions correctly.

        boolean[][] A = {{false, true, false, false},
                         {false, true, true, false},
                         {false, false, true, false},
                         {false, false, true, true}};
        int i = 0;
        int j = 1;
        int[] B = {3, 3, 6};
        SnakeGame test = new SnakeGame(A, i, j);

        assertArrayEquals(B, test.findTailExhaustive());
        test.findTailExhaustive();
        System.out.println(test.getExhaustiveChecks());//Prints the amount of checks.
    }

    @Test
    public void testSG4() { //This test case sees how the code reacts to an all vertical snake.

        boolean[][] A = {{false, false, true, false},
                         {false, false, true, false},
                         {false, false, true, false},
                         {false, false, false, false}};
        int i = 0;
        int j = 1;
        int[] B = {2, 2, 3};
        SnakeGame test = new SnakeGame(A, i, j);

        assertArrayEquals(B, test.findTailExhaustive());
        test.findTailExhaustive();
        System.out.println(test.getExhaustiveChecks());//Prints the amount of checks.
    }

    @Test
    public void testSG5() {//This test case sees how a snake that wraps around the map reacts.

        boolean[][] A = {{true, true, true, true},
                         {false, false, false, true},
                         {true, false, false, true},
                         {true, true, true, true}};
        int i = 0;
        int j = 0;
        int[] B = {2, 0, 11};
        SnakeGame test = new SnakeGame(A, i, j);

        assertArrayEquals(B, test.findTailExhaustive());
        test.findTailExhaustive();
        System.out.println(test.getExhaustiveChecks());//Prints the amount of checks.
    }

    @Test
    public void testSG6() {

        boolean[][] A = {{false, false, false, false},
                         {false, true, false, false},
                         {false, false, false, false},
                         {false, false, false, false}};
        int i = 1;
        int j = 1;
        int[] B = {0, 0, 1};
        SnakeGame test = new SnakeGame(A, i, j);

        assertArrayEquals(B, test.findTailExhaustive());

        test.findTailExhaustive();
        System.out.println(test.getExhaustiveChecks());//Prints the amount of checks.
    }

    @Test
    public void testSG7() { // This test case really makes sure in a larger board my code works.

        boolean[][] A = {{true, true, true, true,true, true, true},
                         {false, false, false, false, false, false, true},
                         {true, true, true, true, true, false, true},
                         {true, false, false, false, true, false, true},
                         {true, false, true, true, true, false, true},
                         {true, false, false, false, false, false, true},
                         {true, true, true, true, true, true, true}};
        int i = 0;
        int j = 0;
        int[] B = {4, 2, 31};
        SnakeGame test = new SnakeGame(A, i, j);

        assertArrayEquals(B, test.findTailExhaustive());
        test.findTailExhaustive();
        System.out.println(test.getExhaustiveChecks());//Prints the amount of checks.
    }

    @Test
    public void testSG8() { // Such as an earlier case this really makes sure all count are correct when there is no tail.

        boolean[][] A = {{false, false, false, false,false, false, false},
                         {false, false, false, false, false, false, false},
                         {false, false, false, false, false, false, false},
                         {false, false, false, true, false, false, false},
                         {false, false, false, false, false, false, false},
                         {false, false, false, false, false, false, false},
                         {false, false, false, false, false, false, false}};
        int i = 3;
        int j = 3;
        int[] B = {0, 0, 1};
        SnakeGame test = new SnakeGame(A, i, j);

        assertArrayEquals(B, test.findTailExhaustive());
        test.findTailExhaustive();
        System.out.println(test.getExhaustiveChecks());//Prints the amount of checks.
    }

    @Test
    public void testSG9() { // This final test case was just to show that no matter the pattern of the snake that
                            // in all cases my code runs perfectly

        boolean[][] A = {{true, false, false, false,false, false, false},
                         {false, true, true, false, false, false, false},
                         {false, false, true, true, false, false, false},
                         {false, false, false, false, true, false, false},
                         {false, false, false, false, true, true, false},
                         {false, false, false, false, false, true, false},
                         {false, false, false, false, false, true, true}};
        int i = 0;
        int j = 0;
        int[] B = {6, 6, 11};
        SnakeGame test = new SnakeGame(A, i, j);

        assertArrayEquals(B, test.findTailExhaustive());
        test.findTailExhaustive();
        System.out.println(test.getExhaustiveChecks());//Prints the amount of checks.
    }

    @Test
    public void testSGR() { //Could not figure this method out :((

        boolean[][] A = {{false, false, false, false},
                         {false, false, true, false},
                         {false, false, true, false},
                         {false, false, true, false}};
        int i = 1;
        int j = 2;
        int[] B = {1, 2, 1};
        SnakeGame test = new SnakeGame(A, i, j);
        //test.findTailRecursive();
        //System.out.println(test.getRecursiveChecks());
        assertArrayEquals(B, test.findTailRecursive());
        //System.out.println(test.getRecursiveChecks());
    }

    @Test
    public void testSGR1() { //Could not figure this method out :((

        boolean[][] A = {{false, false, false, false},
                         {false, true, true, true},
                         {false, false, false, false},
                         {false, false, false, false}};
        int i = 1;
        int j = 1;
        int[] B = {1, 3, 3};
        SnakeGame test = new SnakeGame(A, i, j);

        assertArrayEquals(B, test.findTailRecursive());
       // test.findTailRecursive();
       // System.out.println(test.getRecursiveChecks());
    }
    @Test
    public void testSGR2() {

        boolean[][] A = {{false, false, false, false},
                         {false, false, true, false},
                         {false, false, true, false},
                         {false, false, true, false}};
        int i = 1;
        int j = 2;
        int[] B = {0, 0, 1};
        SnakeGame test = new SnakeGame(A, i, j);
        //test.findTailRecursive();
        //System.out.println(test.getRecursiveChecks());
        assertArrayEquals(B, test.findTailRecursive());
        //System.out.println(test.getRecursiveChecks());
    }
    @Test
    public void testSGR3() {

        boolean[][] A = {{false, false, false, false},
                         {false, false, true, false},
                         {false, false, true, false},
                         {false, false, true, false}};
        int i = 1;
        int j = 2;
        int[] B = {0, 0, 1};
        SnakeGame test = new SnakeGame(A, i, j);
        //test.findTailRecursive();
        //System.out.println(test.getRecursiveChecks());
        assertArrayEquals(B, test.findTailRecursive());
        //System.out.println(test.getRecursiveChecks());
    }
    @Test
    public void testSGR4() {

        boolean[][] A = {{false, false, false, false},
                         {false, false, true, false},
                         {false, false, true, false},
                         {false, false, true, false}};
        int i = 1;
        int j = 2;
        int[] B = {0, 0, 1};
        SnakeGame test = new SnakeGame(A, i, j);
        //test.findTailRecursive();
        //System.out.println(test.getRecursiveChecks());
        assertArrayEquals(B, test.findTailRecursive());
        //System.out.println(test.getRecursiveChecks());
    }
    @Test
    public void testSGR5() {

        boolean[][] A = {{false, false, false, false},
                         {false, false, true, false},
                         {false, false, true, false},
                         {false, false, true, false}};
        int i = 1;
        int j = 2;
        int[] B = {0, 0, 1};
        SnakeGame test = new SnakeGame(A, i, j);
        //test.findTailRecursive();
        //System.out.println(test.getRecursiveChecks());
        assertArrayEquals(B, test.findTailRecursive());
        //System.out.println(test.getRecursiveChecks());
    }
    @Test
    public void testSGR6() {

        boolean[][] A = {{false, false, false, false},
                         {false, false, true, false},
                         {false, false, true, false},
                         {false, false, true, false}};
        int i = 1;
        int j = 2;
        int[] B = {0, 0, 1};
        SnakeGame test = new SnakeGame(A, i, j);
        //test.findTailRecursive();
        //System.out.println(test.getRecursiveChecks());
        assertArrayEquals(B, test.findTailRecursive());
        //System.out.println(test.getRecursiveChecks());
    }
    @Test
    public void testSGR7() {

        boolean[][] A = {{false, false, false, false},
                         {false, false, true, false},
                         {false, false, true, false},
                         {false, false, true, false}};
        int i = 1;
        int j = 2;
        int[] B = {0, 0, 1};
        SnakeGame test = new SnakeGame(A, i, j);
        //test.findTailRecursive();
        //System.out.println(test.getRecursiveChecks());
        assertArrayEquals(B, test.findTailRecursive());
        //System.out.println(test.getRecursiveChecks());
    }
    @Test
    public void testSGR8() {

        boolean[][] A = {{false, false, false, false},
                         {false, false, true, false},
                         {false, false, true, false},
                         {false, false, true, false}};
        int i = 1;
        int j = 2;
        int[] B = {0, 0, 1};
        SnakeGame test = new SnakeGame(A, i, j);
        //test.findTailRecursive();
        //System.out.println(test.getRecursiveChecks());
        assertArrayEquals(B, test.findTailRecursive());
        //System.out.println(test.getRecursiveChecks());
    }
    @Test
    public void testSGR9() {

        boolean[][] A = {{false, false, false, false},
                         {false, false, true, false},
                         {false, false, true, false},
                         {false, false, true, false}};
        int i = 1;
        int j = 2;
        int[] B = {0, 0, 1};
        SnakeGame test = new SnakeGame(A, i, j);
        //test.findTailRecursive();
        //System.out.println(test.getRecursiveChecks());
        assertArrayEquals(B, test.findTailRecursive());
    }
}