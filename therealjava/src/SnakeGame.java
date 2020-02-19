public class SnakeGame {

    private boolean[][] Snake;
    private int[] HeadPosition;
    private static int ExhaustiveChecks;
    private static int RecursiveChecks;

    public SnakeGame() {
    }

    public SnakeGame(boolean[][] board) {
       int Size = board.length;
        Snake = new boolean[Size][Size];
        Snake = board;
    }
    public SnakeGame(boolean[][] board , int x , int y) {

        HeadPosition = new int[2];
        HeadPosition[0] = x;
        HeadPosition[1] = y;

        int Size = board.length;
        Snake = new boolean[Size][Size];
        Snake = board;
    }

    private void setSnake(boolean [][] Snake) { this.Snake = Snake; }

    private void setHeadPosition(int[] HeadPosition) { this.HeadPosition = HeadPosition; }

    private void setExhaustiveChecks(int ExhaustiveChecks) { this.ExhaustiveChecks = ExhaustiveChecks; }

    private void setRecursiveChecks(int RecursiveChecks) { this.RecursiveChecks = RecursiveChecks; }

    private boolean[][] getSnake() { return Snake; }

    private int[] getHeadPosition() { return HeadPosition; }

    private int getExhaustiveChecks() { return ExhaustiveChecks; }

    private int getRecursiveChecks() { return RecursiveChecks; }

    public int[] findTailExhaustive(){

        int[] tail
        int count = 0;
        int length = 0;
        for (int i = 0; i < Snake.length; i++) {
           for (int j = 0; j < Snake[i].length; j++) {

        if(Snake[i][j] == true){
            length++;
        }

        if(i==0 && j ==0){
            count++;
            count++;
            if(Snake[i][j+1] == true ){ count--;}
            if(Snake[i+1][j] == true ){ count--;}
        }
        if(i==0 && j!= 0 && j!= Snake.length){

            if(Snake[i][j-1] == false && Snake[i+1][j] == false && Snake[i][j+1] == false ){

            }
            if(Snake[i][j-1] == true ){ count++;}
            if(Snake[i+1][j] == true ){ count++;}
            if(Snake[i][j+1] == true ){ count++;}
        }
        if(i == 0 && j == Snake.length){
            if(Snake[i][j-1] == true ){ count++;}
            if(Snake[i+1][j] == true ){ count++;}
        }
        if(i != 0 && j== 0 && i != Snake.length){
            if(Snake[i-1][j] == true ){count++;}
            if(Snake[i][j+1] == true ){ count++;}
            if(Snake[i+1][j] == true ){ count++;}
        }
        if(i == Snake.length && j ==0){
            if(Snake[i-1][j] == true ){count++;}
            if(Snake[i][j+1] == true ){ count++;}
        }
        if(i == Snake.length && j !=0 && j!= Snake.length){
            if(Snake[i][j-1] == true ){ count++;}
            if(Snake[i-1][j] == true ){count++;}
            if(Snake[i][j+1] == true ){ count++;}
        }
        if(i == Snake.length && j== Snake.length){
            if(Snake[i][j-1] == true ){ count++;}
            if(Snake[i-1][j] == true ){count++;}
        }
        if(i != 0 && j == Snake.length && i != Snake.length){
            if(Snake[i+1][j] == true ){ count++;}
            if(Snake[i][j-1] == true ){ count++;}
            if(Snake[i-1][j] == true ){count++;}
        }if(i != 0 && j != 0 && i != Snake.length && j!=Snake.length){
            if(Snake[i][j+1] == true ){ count++;}
            if(Snake[i][j-1] == true ){ count++;}
            if(Snake[i+1][j] == true ){ count++;}
            if(Snake[i-1][j] == true ){count++;}
        }
        return count;

            }
        }
    }
//    public void oneStep() {
//        int[][] future =new int[Size][Size];
//        for (int i = 0; i < Board.length; i++) {
//            for (int j = 0; j < Board[i].length; j++) {
//                Previous[i][j] = Board[i][j];
//                int a = neighbors(i,j);
//                if(Board[i][j] == 1 ){
//                    future[i][j] = 0;
//                    if (a == 2 || a == 3) {
//                        future[i][j] = 1;
//                    }
//
//                }else{
//                    future[i][j] = 0;
//                    if (a == 3) {
//                        future[i][j] = 1;
//                    }
//                }
//
//            }
//        }
//        Board = future;
//    }
//

