import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class SnakeGameTester {


    @Test
    public void testSG() { //Neighbors Game of life test cases

        boolean[][] A = {{false, false, false, false},
                         {false, true, true, false},
                         {false, false, true, false},
                         {false, false, false, false}};
        int i = 1;
        int j = 1;
        int[] B = {2, 2, 3};
       // int[] C = {2, 2, 8};
        SnakeGame test = new SnakeGame(A, i, j);

        assertArrayEquals(B, test.findTailExhaustive());
    }

//    @Test
//    public void testSG1() {
//        int[][] A = {{1, 1, 0, 1, 1},
//                {0, 1, 1, 1, 0},
//                {0, 1, 0, 1, 1},
//                {1, 1, 1, 1, 0},
//                {0, 0, 0, 1, 1}
//        };
//        int[][] B = {{0, 1, 0, 0, 0},
//                {0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0},
//                {0, 1, 0, 0, 0},
//                {0, 0, 0, 0, 0}
//        };
//        GameOfLife test = new GameOfLife(A);
//        test.oneStep();
//        assertArrayEquals(B, test.getBoard());
//    }
}