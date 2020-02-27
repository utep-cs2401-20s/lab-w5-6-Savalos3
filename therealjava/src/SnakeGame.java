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

    public static int getExhaustiveChecks() { return ExhaustiveChecks; }

    public static int getRecursiveChecks() { return RecursiveChecks; }

    private void resetCounters(){
        ExhaustiveChecks = 0;
        RecursiveChecks = 0;
    }

    public int[] findTailExhaustive(){
        resetCounters();
        int[] tail = new int[3];
        int count = 0;
        int length = 0;
        for (int i = 0; i < Snake.length; i++) {
           for (int j = 0; j < Snake[i].length; j++) {

        if(Snake[i][j] == true){
            length++;
        }

        if(i==0 && j ==0){
            count++;
            if(Snake[i][j] == true && i != HeadPosition[0] && j != HeadPosition[1]){
            if(Snake[i][j+1] == true && Snake[i+1][j] == false ){ ExhaustiveChecks = count; tail[0]=i;tail[1]=j;}
            if(Snake[i][j+1] == false && Snake[i+1][j] == true ){ ExhaustiveChecks = count; tail[0]=i;tail[1]=j;}
            }
        }
        if(i==0 && j!= 0 && j!= Snake.length){
            count++;
            if(Snake[i][j] == true && i != HeadPosition[0] && j != HeadPosition[1]){
            if(Snake[i][j-1] == false && Snake[i+1][j] == false && Snake[i][j+1] == true){ ExhaustiveChecks = count; tail[0]=i;tail[1]=j;}
            if(Snake[i][j-1] == true && Snake[i+1][j] == false && Snake[i][j+1] == false){ ExhaustiveChecks = count; tail[0]=i;tail[1]=j;}
            if(Snake[i][j-1] == false && Snake[i+1][j] == true && Snake[i][j+1] == false){ ExhaustiveChecks = count; tail[0]=i;tail[1]=j;}
            }

        }
        if(i == 0 && j == Snake.length){
            count++;
            if(Snake[i][j] == true && i != HeadPosition[0] && j != HeadPosition[1]){
            if(Snake[i][j-1] == true && Snake[i+1][j] == false){  ExhaustiveChecks = count; tail[0]=i;tail[1]=j;}
            if(Snake[i][j-1] == false && Snake[i+1][j] == true){  ExhaustiveChecks = count; tail[0]=i;tail[1]=j;}
            }
        }
        if(i != 0 && j== 0 && i != Snake.length){
            count++;
            if(Snake[i][j] == true && i != HeadPosition[0] && j != HeadPosition[1]){
            if(Snake[i-1][j] == false && Snake[i][j+1] == false && Snake[i+1][j] == true){ ExhaustiveChecks = count; tail[0]=i;tail[1]=j;}
            if(Snake[i-1][j] == true && Snake[i][j+1] == false && Snake[i+1][j] == false){ ExhaustiveChecks = count; tail[0]=i;tail[1]=j;}
            if(Snake[i-1][j] == false && Snake[i][j+1] == true && Snake[i+1][j] == false){ ExhaustiveChecks = count; tail[0]=i;tail[1]=j;}
            }

        }
        if(i == Snake.length && j ==0){
            count++;
            if(Snake[i][j] == true && i != HeadPosition[0] && j != HeadPosition[1]){
            if(Snake[i-1][j] == false && Snake[i][j+1] == true){ ExhaustiveChecks = count; tail[0]=i;tail[1]=j;}
            if(Snake[i-1][j] == true && Snake[i][j+1] == false){ ExhaustiveChecks = count; tail[0]=i;tail[1]=j;}
            }

        }
        if(i == Snake.length && j !=0 && j!= Snake.length){
            count++;
            if(Snake[i][j] == true && i != HeadPosition[0] && j != HeadPosition[1]){
            if(Snake[i][j-1] == false && Snake[i-1][j] == false && Snake[i][j+1] == true){ ExhaustiveChecks = count; tail[0]=i;tail[1]=j;}
            if(Snake[i][j-1] == true && Snake[i-1][j] == false && Snake[i][j+1] == false){ ExhaustiveChecks = count; tail[0]=i;tail[1]=j;}
            if(Snake[i][j-1] == false && Snake[i-1][j] == true && Snake[i][j+1] == false){ ExhaustiveChecks = count; tail[0]=i;tail[1]=j;}
            }

        }
        if(i == Snake.length && j== Snake.length){
            count++;
            if(Snake[i][j] == true && i != HeadPosition[0] && j != HeadPosition[1]){
            if(Snake[i][j-1] == false && Snake[i-1][j] == true){ ExhaustiveChecks = count; tail[0]=i;tail[1]=j;}
            if(Snake[i][j-1] == true && Snake[i-1][j] == false){ ExhaustiveChecks = count; tail[0]=i;tail[1]=j;}
            }

        }
        if(i != 0 && j == Snake.length && i != Snake.length){
            count++;
            if(Snake[i][j] == true && i != HeadPosition[0] && j != HeadPosition[1]){
            if(Snake[i+1][j] == false && Snake[i][j-1] == false && Snake[i-1][j] == true){ ExhaustiveChecks = count; tail[0]=i;tail[1]=j;}
            if(Snake[i+1][j] == true && Snake[i][j-1] == false && Snake[i-1][j] == false){ ExhaustiveChecks = count; tail[0]=i;tail[1]=j;}
            if(Snake[i+1][j] == false && Snake[i][j-1] == true && Snake[i-1][j] == false){ ExhaustiveChecks = count; tail[0]=i;tail[1]=j;}
            }

        }if(i != 0 && j != 0 && i != Snake.length && j!=Snake.length){
            count++;
            if(Snake[i][j] == true && i != HeadPosition[0] && j != HeadPosition[1]){
            if(Snake[i][j+1] == false && Snake[i][j-1] == false && Snake[i+1][j] == false && Snake[i-1][j] == true){ ExhaustiveChecks = count; tail[0]=i;tail[1]=j;}
            if(Snake[i][j+1] == true && Snake[i][j-1] == false && Snake[i+1][j] == false && Snake[i-1][j] == false){ ExhaustiveChecks = count; tail[0]=i;tail[1]=j;}
            if(Snake[i][j+1] == false && Snake[i][j-1] == true && Snake[i+1][j] == false && Snake[i-1][j] == false){ ExhaustiveChecks = count; tail[0]=i;tail[1]=j;}
            if(Snake[i][j+1] == false && Snake[i][j-1] == false && Snake[i+1][j] == true && Snake[i-1][j] == false){ ExhaustiveChecks = count; tail[0]=i;tail[1]=j;}
            }
        }

            }
        }
        tail[2] = length;
        return tail;
    }
    public int[] findTailRecursive(){
        resetCounters();
        return findTailRecursive(HeadPosition,HeadPosition);
    }
    private int[] findTailRecursive(int[] currentPosition, int[] previousPosition){
        int[] tail = new int[3];
        int length = 0;
        int i = currentPosition[0];
        int j = currentPosition[1];
        if(i==0 && j ==0){
            RecursiveChecks++;


                if(Snake[i][j+1] == true && previousPosition[0] != i && previousPosition[1] != j+1){ tail[0]=i;tail[1]=j;}
                if(previousPosition[0] != i+1 && previousPosition[1] != j && Snake[i+1][j] == true ){ tail[0]=i;tail[1]=j;}

        }
        if(i==0 && j!= 0 && j!= Snake.length){
            RecursiveChecks++;
            RecursiveChecks++;

                if(previousPosition[0] != i && previousPosition[1] != j+1 && Snake[i][j+1] == true){ tail[0]=i;tail[1]=j;}
                if(Snake[i][j-1] == true && previousPosition[0] != i && previousPosition[1] != j-1 ){ tail[0]=i;tail[1]=j;}
                if(previousPosition[0] != i+1 && previousPosition[1] != j && Snake[i+1][j] == true){ tail[0]=i;tail[1]=j;}


        }
        if(i == 0 && j == Snake.length){
            RecursiveChecks++;

                if(Snake[i][j-1] == true && previousPosition[0] != i && previousPosition[1] != j-1){ tail[0]=i;tail[1]=j;}
                if(previousPosition[0] != i+1 && previousPosition[1] != j && Snake[i+1][j] == true){ tail[0]=i;tail[1]=j;}

        }
        if(i != 0 && j== 0 && i != Snake.length){
            RecursiveChecks++;
            RecursiveChecks++;

                if(previousPosition[0] != i+1 && previousPosition[1] != j && Snake[i+1][j] == true){ tail[0]=i;tail[1]=j;}
                if(Snake[i-1][j] == true && previousPosition[0] != i-1 && previousPosition[1] != j){ tail[0]=i;tail[1]=j;}
                if(previousPosition[0] != i && previousPosition[1] != j+1 && Snake[i][j+1] == true){ tail[0]=i;tail[1]=j;}

        }
        if(i == Snake.length && j ==0){
            RecursiveChecks++;

                if(previousPosition[0] != i && previousPosition[1] != j+1 && Snake[i][j+1] == true){ tail[0]=i;tail[1]=j;}
                if(Snake[i-1][j] == true && previousPosition[0] != i-1 && previousPosition[1] != j){ tail[0]=i;tail[1]=j;}

        }
        if(i == Snake.length && j !=0 && j!= Snake.length){
            RecursiveChecks++;
            RecursiveChecks++;

                if(previousPosition[0] != i && previousPosition[1] != j+1 && Snake[i][j+1] == true){ tail[0]=i;tail[1]=j;}
                if(Snake[i][j-1] == true && previousPosition[0] != i && previousPosition[1] != j-1){ tail[0]=i;tail[1]=j;}
                if(previousPosition[0] != i-1 && previousPosition[1] != j && Snake[i-1][j] == true){ tail[0]=i;tail[1]=j;}

        }
        if(i == Snake.length && j== Snake.length){
            RecursiveChecks++;

                if(previousPosition[0] != i-1 && previousPosition[1] != j && Snake[i-1][j] == true){ tail[0]=i;tail[1]=j;}
                if(Snake[i][j-1] == true && previousPosition[0] != i && previousPosition[1] != j-1){ tail[0]=i;tail[1]=j;}

        }
        if(i != 0 && j == Snake.length && i != Snake.length){
            RecursiveChecks++;
            RecursiveChecks++;

                if(previousPosition[0] != i-1 && previousPosition[1] != j && Snake[i-1][j] == true){ tail[0]=i;tail[1]=j;}
                if(Snake[i+1][j] == true && previousPosition[0] != i+1 && previousPosition[1] != j){ tail[0]=i;tail[1]=j;}
                if(previousPosition[0] != i && previousPosition[1] != j-1 && Snake[i][j-1] == true){ tail[0]=i;tail[1]=j;}

        }if(i != 0 && j != 0 && i != Snake.length && j!=Snake.length){
            RecursiveChecks++;
            RecursiveChecks++;
            RecursiveChecks++;

                if(Snake[i][j+1] == false && Snake[i][j-1] == false && Snake[i+1][j] == false && Snake[i-1][j] == true){ tail[0]=i;tail[1]=j;}
                if(Snake[i][j+1] == true && Snake[i][j-1] == false && Snake[i+1][j] == false && Snake[i-1][j] == false){ tail[0]=i;tail[1]=j;}
                if(Snake[i][j+1] == false && Snake[i][j-1] == true && Snake[i+1][j] == false && Snake[i-1][j] == false){ tail[0]=i;tail[1]=j;}
                if(Snake[i][j+1] == false && Snake[i][j-1] == false && Snake[i+1][j] == true && Snake[i-1][j] == false){ tail[0]=i;tail[1]=j;}
        }
    }
}
