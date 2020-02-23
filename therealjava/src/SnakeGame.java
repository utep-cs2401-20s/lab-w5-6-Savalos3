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
            count++;
            if(Snake[i][j] == true && Snake[i][j] != Snake[HeadPosition[0]][HeadPosition[1]]){
            if(Snake[i][j+1] == true && Snake[i+1][j] == false ){ count--; tail[0]=i;tail[1]=j;}
            if(Snake[i][j+1] == false && Snake[i+1][j] == true ){ count--; tail[0]=i;tail[1]=j;}
            }
        }
        if(i==0 && j!= 0 && j!= Snake.length){
            count++;
            count++;
            count++;
            if(Snake[i][j] == true){
            if(Snake[i][j-1] == false && Snake[i+1][j] == false && Snake[i][j+1] == true){ count--; tail[0]=i;tail[1]=j;}
            if(Snake[i][j-1] == true && Snake[i+1][j] == false && Snake[i][j+1] == false){ count--; tail[0]=i;tail[1]=j;}
            if(Snake[i][j-1] == false && Snake[i+1][j] == true && Snake[i][j+1] == false){ count--; tail[0]=i;tail[1]=j;}
            }

        }
        if(i == 0 && j == Snake.length){
            count++;
            count++;
            if(Snake[i][j] == true && Snake[i][j] != Snake[HeadPosition[0]][HeadPosition[1]]){
            if(Snake[i][j-1] == true && Snake[i+1][j] == false){ count--; tail[0]=i;tail[1]=j;}
            if(Snake[i][j-1] == false && Snake[i+1][j] == true){ count--; tail[0]=i;tail[1]=j;}
            }
        }
        if(i != 0 && j== 0 && i != Snake.length){
            count++;
            count++;
            count++;
            if(Snake[i][j] == true && Snake[i][j] != Snake[HeadPosition[0]][HeadPosition[1]]){
            if(Snake[i-1][j] == false && Snake[i][j+1] == false && Snake[i+1][j] == true){count--; tail[0]=i;tail[1]=j;}
            if(Snake[i-1][j] == true && Snake[i][j+1] == false && Snake[i+1][j] == false){count--; tail[0]=i;tail[1]=j;}
            if(Snake[i-1][j] == false && Snake[i][j+1] == true && Snake[i+1][j] == false){count--; tail[0]=i;tail[1]=j;}
            }

        }
        if(i == Snake.length && j ==0){
            count++;
            count++;
            if(Snake[i][j] == true && Snake[i][j] != Snake[HeadPosition[0]][HeadPosition[1]]){
            if(Snake[i-1][j] == false && Snake[i][j+1] == true){count--; tail[0]=i;tail[1]=j;}
            if(Snake[i-1][j] == true && Snake[i][j+1] == false){count--; tail[0]=i;tail[1]=j;}
            }

        }
        if(i == Snake.length && j !=0 && j!= Snake.length){
            count++;
            count++;
            count++;
            if(Snake[i][j] == true && Snake[i][j] != Snake[HeadPosition[0]][HeadPosition[1]]){
            if(Snake[i][j-1] == false && Snake[i-1][j] == false && Snake[i][j+1] == true){ count--; tail[0]=i;tail[1]=j;}
            if(Snake[i][j-1] == true && Snake[i-1][j] == false && Snake[i][j+1] == false){ count--; tail[0]=i;tail[1]=j;}
            if(Snake[i][j-1] == false && Snake[i-1][j] == true && Snake[i][j+1] == false){ count--; tail[0]=i;tail[1]=j;}
            }

        }
        if(i == Snake.length && j== Snake.length){
            count++;
            count++;
            if(Snake[i][j] == true && Snake[i][j] != Snake[HeadPosition[0]][HeadPosition[1]]){
            if(Snake[i][j-1] == false && Snake[i-1][j] == true){ count--; tail[0]=i;tail[1]=j;}
            if(Snake[i][j-1] == true && Snake[i-1][j] == false){ count--; tail[0]=i;tail[1]=j;}
            }

        }
        if(i != 0 && j == Snake.length && i != Snake.length){
            count++;
            count++;
            if(Snake[i][j] == true && Snake[i][j] != Snake[HeadPosition[0]][HeadPosition[1]]){
            if(Snake[i+1][j] == false && Snake[i][j-1] == false && Snake[i-1][j] == true){ count--; tail[0]=i;tail[1]=j;}
            if(Snake[i+1][j] == true && Snake[i][j-1] == false && Snake[i-1][j] == false){ count--; tail[0]=i;tail[1]=j;}
            if(Snake[i+1][j] == false && Snake[i][j-1] == true && Snake[i-1][j] == false){ count--; tail[0]=i;tail[1]=j;}
            }

        }if(i != 0 && j != 0 && i != Snake.length && j!=Snake.length){
            count++;
            count++;
            count++;
            count++;
            if(Snake[i][j] == true && Snake[i][j] != Snake[HeadPosition[0]][HeadPosition[1]]){
            if(Snake[i][j+1] == false && Snake[i][j-1] == false && Snake[i+1][j] == false && Snake[i-1][j] == true){ count--; tail[0]=i;tail[1]=j;}
            if(Snake[i][j+1] == true && Snake[i][j-1] == false && Snake[i+1][j] == false && Snake[i-1][j] == false){ count--; tail[0]=i;tail[1]=j;}
            if(Snake[i][j+1] == false && Snake[i][j-1] == true && Snake[i+1][j] == false && Snake[i-1][j] == false){ count--; tail[0]=i;tail[1]=j;}
            if(Snake[i][j+1] == false && Snake[i][j-1] == false && Snake[i+1][j] == true && Snake[i-1][j] == false){ count--; tail[0]=i;tail[1]=j;}
            }
        }

            }
        }
        tail[2] = length;
        return tail;
    }
}
