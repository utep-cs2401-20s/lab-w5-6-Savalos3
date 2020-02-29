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

    public int[] findTailExhaustive(){ //Used same concept of game of life to look through neighbors
        resetCounters();
        int[] tail = new int[3];
        int count = 0; //Used to find checks
        int length = 0;
        for (int i = 0; i < Snake.length; i++) {
           for (int j = 0; j < Snake[i].length; j++) {

        if(Snake[i][j] == true){
            length++;
        }

        if(i==0 && j ==0){
            count++;
            if(Snake[i][j] == true && (i != HeadPosition[0] || j != HeadPosition[1])){//if one of these conditionals is true then the solution was found
            if(Snake[i][j+1] == true && Snake[i+1][j] == false ){ ExhaustiveChecks = count; tail[0]=i;tail[1]=j;}
            if(Snake[i][j+1] == false && Snake[i+1][j] == true ){ ExhaustiveChecks = count; tail[0]=i;tail[1]=j;}
            }
        }
        if(i==0 && j!= 0 && j!= Snake.length-1){
            count++;
            if(Snake[i][j] == true && (i != HeadPosition[0] || j != HeadPosition[1])){
            if(Snake[i][j-1] == false && Snake[i+1][j] == false && Snake[i][j+1] == true){ ExhaustiveChecks = count; tail[0]=i;tail[1]=j;}
            if(Snake[i][j-1] == true && Snake[i+1][j] == false && Snake[i][j+1] == false){ ExhaustiveChecks = count; tail[0]=i;tail[1]=j;}
            if(Snake[i][j-1] == false && Snake[i+1][j] == true && Snake[i][j+1] == false){ ExhaustiveChecks = count; tail[0]=i;tail[1]=j;}
            }

        }
        if(i == 0 && j == Snake.length-1){
            count++;
            if(Snake[i][j] == true && (i != HeadPosition[0] || j != HeadPosition[1])){
            if(Snake[i][j-1] == true && Snake[i+1][j] == false){  ExhaustiveChecks = count; tail[0]=i;tail[1]=j;}
            if(Snake[i][j-1] == false && Snake[i+1][j] == true){  ExhaustiveChecks = count; tail[0]=i;tail[1]=j;}
            }
        }
        if(i != 0 && j== 0 && i != Snake.length-1){
            count++;
            if(Snake[i][j] == true && (i != HeadPosition[0] || j != HeadPosition[1])){
            if(Snake[i-1][j] == false && Snake[i][j+1] == false && Snake[i+1][j] == true){ ExhaustiveChecks = count; tail[0]=i;tail[1]=j;}
            if(Snake[i-1][j] == true && Snake[i][j+1] == false && Snake[i+1][j] == false){ ExhaustiveChecks = count; tail[0]=i;tail[1]=j;}
            if(Snake[i-1][j] == false && Snake[i][j+1] == true && Snake[i+1][j] == false){ ExhaustiveChecks = count; tail[0]=i;tail[1]=j;}
            }

        }
        if(i == Snake.length-1 && j ==0){
            count++;
            if(Snake[i][j] == true && (i != HeadPosition[0] || j != HeadPosition[1])){
            if(Snake[i-1][j] == false && Snake[i][j+1] == true){ ExhaustiveChecks = count; tail[0]=i;tail[1]=j;}
            if(Snake[i-1][j] == true && Snake[i][j+1] == false){ ExhaustiveChecks = count; tail[0]=i;tail[1]=j;}
            }

        }
        if(i == Snake.length-1 && j !=0 && j!= Snake.length-1){
            count++;
            if(Snake[i][j] == true && (i != HeadPosition[0] || j != HeadPosition[1])){
            if(Snake[i][j-1] == false && Snake[i-1][j] == false && Snake[i][j+1] == true){ ExhaustiveChecks = count; tail[0]=i;tail[1]=j;}
            if(Snake[i][j-1] == true && Snake[i-1][j] == false && Snake[i][j+1] == false){ ExhaustiveChecks = count; tail[0]=i;tail[1]=j;}
            if(Snake[i][j-1] == false && Snake[i-1][j] == true && Snake[i][j+1] == false){ ExhaustiveChecks = count; tail[0]=i;tail[1]=j;}
            }

        }
        if(i == Snake.length-1 && j== Snake.length-1){
            count++;
            if(Snake[i][j] == true && (i != HeadPosition[0] || j != HeadPosition[1])){
            if(Snake[i][j-1] == false && Snake[i-1][j] == true){ ExhaustiveChecks = count; tail[0]=i;tail[1]=j;}
            if(Snake[i][j-1] == true && Snake[i-1][j] == false){ ExhaustiveChecks = count; tail[0]=i;tail[1]=j;}
            }

        }
        if(i != 0 && j == Snake.length-1 && i != Snake.length-1){
            count++;
            if(Snake[i][j] == true && (i != HeadPosition[0] || j != HeadPosition[1])){
            if(Snake[i+1][j] == false && Snake[i][j-1] == false && Snake[i-1][j] == true){ ExhaustiveChecks = count; tail[0]=i;tail[1]=j;}
            if(Snake[i+1][j] == true && Snake[i][j-1] == false && Snake[i-1][j] == false){ ExhaustiveChecks = count; tail[0]=i;tail[1]=j;}
            if(Snake[i+1][j] == false && Snake[i][j-1] == true && Snake[i-1][j] == false){ ExhaustiveChecks = count; tail[0]=i;tail[1]=j;}
            }

        }if(i != 0 && j != 0 && i != Snake.length-1 && j!=Snake.length-1){
            count++;
            if(Snake[i][j] == true && (i != HeadPosition[0] || j != HeadPosition[1])){
            if(Snake[i][j+1] == false && Snake[i][j-1] == false && Snake[i+1][j] == false && Snake[i-1][j] == true){ ExhaustiveChecks = count; tail[0]=i;tail[1]=j;}
            if(Snake[i][j+1] == true && Snake[i][j-1] == false && Snake[i+1][j] == false && Snake[i-1][j] == false){ ExhaustiveChecks = count; tail[0]=i;tail[1]=j;}
            if(Snake[i][j+1] == false && Snake[i][j-1] == true && Snake[i+1][j] == false && Snake[i-1][j] == false){ ExhaustiveChecks = count; tail[0]=i;tail[1]=j;}
            if(Snake[i][j+1] == false && Snake[i][j-1] == false && Snake[i+1][j] == true && Snake[i-1][j] == false){ ExhaustiveChecks = count; tail[0]=i;tail[1]=j;}
            }
        }

            }
        }
        if(ExhaustiveChecks == 0){ //This makes sure that even in an array with just a head it checks all the parts of the board.
            ExhaustiveChecks =  Snake.length *  Snake.length;
        }
        tail[2] = length;
        return tail;
    }
    public int[] findTailRecursive(){//Only sends Headposition
        resetCounters();
        int[] tail = new int[3];
        tail = findTailRecursive1(HeadPosition,HeadPosition);
        System.out.println("end1");
        return tail;
    }
    private int[] findTailRecursive1(int[] currentPosition, int[] previousPosition){ //Used System.out.print to try to track code.
        System.out.println("findTailRecursive------------------------------------------------------");
        if(currentPosition[0] == previousPosition[0] && currentPosition[1] == previousPosition[1]){
        resetCounters();
        RecursiveChecks++;}
        int[] tail = new int[3];
        int length = 0;
        int i = currentPosition[0];
        int j = currentPosition[1];
        int x = previousPosition[0];
        int y = previousPosition[1];

        System.out.println("currentPos [" + i + ", " + j + "]");
        System.out.println();
        System.out.println("previousPos [" + x + ", " + y + "]");

        if(i==0 && j ==0){
            RecursiveChecks++;
            length++;

                if(Snake[i][j+1] == true && (i != previousPosition[0] || j+1 != previousPosition[1])){
                    System.out.println("x");
                    tail[0]=i;tail[1]=j; currentPosition[0]= i; currentPosition[1]= j+1;tail =
                            findTailRecursive1(currentPosition,tail);}
                if((i+1 != previousPosition[0] || j != previousPosition[1]) && Snake[i+1][j] == true ){
                    System.out.println("x");
                    tail[0]=i;tail[1]=j; currentPosition[0]= i+1; currentPosition[1]= j;findTailRecursive1(currentPosition,tail);}

        }
        if(i==0 && j!= 0 && j!= Snake.length-1){
            RecursiveChecks++;
            RecursiveChecks++;
            length++;
                if((i != previousPosition[0] || j+1 != previousPosition[1]) && Snake[i][j+1] == true){
                    System.out.println("x");
                    tail[0]=i;tail[1]=j; currentPosition[0]= i; currentPosition[1]= j+1;findTailRecursive1(currentPosition,tail);}
                if(Snake[i][j-1] == true && (i != previousPosition[0] || j-1 != previousPosition[1])){
                    System.out.println("x");
                    tail[0]=i;tail[1]=j; currentPosition[0]= i; currentPosition[1]= j-1;findTailRecursive1(currentPosition,tail);}
                if((i+1 != previousPosition[0] || j != previousPosition[1]) && Snake[i+1][j] == true){
                    System.out.println("x");
                    tail[0]=i;tail[1]=j; currentPosition[0]= i+1; currentPosition[1]= j;findTailRecursive1(currentPosition,tail);}


        }
        if(i == 0 && j == Snake.length-1){
            RecursiveChecks++;
            length++;
                if(Snake[i][j-1] == true && (i != previousPosition[0] || j-1 != previousPosition[1])){
                    System.out.println("x");
                    tail[0]=i;tail[1]=j; currentPosition[0]= i; currentPosition[1]= j-1;findTailRecursive1(currentPosition,tail);}
                if((i+1 != previousPosition[0] || j != previousPosition[1]) && Snake[i+1][j] == true){
                    System.out.println("x");
                    tail[0]=i;tail[1]=j; currentPosition[0]= i+1; currentPosition[1]= j;findTailRecursive1(currentPosition,tail);}

        }
        if(i != 0 && j== 0 && i != Snake.length-1){
            RecursiveChecks++;
            RecursiveChecks++;
            length++;
                if((i+1 != previousPosition[0] || j != previousPosition[1]) && Snake[i+1][j] == true){
                    System.out.println("x");
                    tail[0]=i;tail[1]=j; currentPosition[0]= i+1; currentPosition[1]= j;findTailRecursive1(currentPosition,tail);}
                if(Snake[i-1][j] == true && (i-1 != previousPosition[0] || j != previousPosition[1])){
                    System.out.println("x");
                    tail[0]=i;tail[1]=j; currentPosition[0]= i-1; currentPosition[1]= j;findTailRecursive1(currentPosition,tail);}
                if((i != previousPosition[0] || j+1 != previousPosition[1]) && Snake[i][j+1] == true){
                    System.out.println("x");
                    tail[0]=i;tail[1]=j; currentPosition[0]= i; currentPosition[1]= j+1;findTailRecursive1(currentPosition,tail);}

        }
        if(i == Snake.length-1 && j ==0){
            RecursiveChecks++;
            length++;
                if((i != previousPosition[0] || j+1 != previousPosition[1]) && Snake[i][j+1] == true){
                    System.out.println("x");
                    tail[0]=i;tail[1]=j; currentPosition[0]= i; currentPosition[1]= j+1;findTailRecursive1(currentPosition,tail);}
                if(Snake[i-1][j] == true && (i-1 != previousPosition[0] || j != previousPosition[1])){
                    System.out.println("x");
                    tail[0]=i;tail[1]=j; currentPosition[0]= i-1; currentPosition[1]= j;findTailRecursive1(currentPosition,tail);}

        }
        if(i == Snake.length-1 && j !=0 && j!= Snake.length-1){
            RecursiveChecks++;
            RecursiveChecks++;
            length++;
                if((i != previousPosition[0] || j+1 != previousPosition[1]) && Snake[i][j+1] == true){
                    System.out.println("x");
                    tail[0]=i;tail[1]=j; currentPosition[0]= i; currentPosition[1]= j+1;findTailRecursive1(currentPosition,tail);}
                if(Snake[i][j-1] == true && (i != previousPosition[0] || j-1 != previousPosition[1])){
                    System.out.println("x");
                    tail[0]=i;tail[1]=j; currentPosition[0]= i; currentPosition[1]= j-1;findTailRecursive1(currentPosition,tail);}
                if((i-1 != previousPosition[0] || j != previousPosition[1]) && Snake[i-1][j] == true){
                    System.out.println("x");
                    tail[0]=i;tail[1]=j; currentPosition[0]= i-1; currentPosition[1]= j;findTailRecursive1(currentPosition,tail);}

        }
        if(i == Snake.length-1 && j== Snake.length-1){
            RecursiveChecks++;
            length++;
                if((i-1 != previousPosition[0] || j != previousPosition[1]) && Snake[i-1][j] == true){
                    System.out.println("x");
                    tail[0]=i;tail[1]=j; currentPosition[0]= i-1; currentPosition[1]= j;findTailRecursive1(currentPosition,tail);}
                if(Snake[i][j-1] == true && (i != previousPosition[0] || j-1 != previousPosition[1])){
                    System.out.println("x");
                    tail[0]=i;tail[1]=j; currentPosition[0]= i; currentPosition[1]= j-1;findTailRecursive1(currentPosition,tail);}

        }
        if(i != 0 && j == Snake.length-1 && i != Snake.length-1){
            RecursiveChecks++;
            RecursiveChecks++;
            length++;
                if((i-1 != previousPosition[0] || j != previousPosition[1]) && Snake[i-1][j] == true){
                    System.out.print("up");
                    tail[0]=i;tail[1]=j; currentPosition[0]= i-1; currentPosition[1]= j;findTailRecursive1(currentPosition,tail);}
                if(Snake[i+1][j] == true && (i+1 != previousPosition[0] || j != previousPosition[1])){
                    System.out.print("down");
                    tail[0]=i;tail[1]=j; currentPosition[0]= i+1; currentPosition[1]= j;findTailRecursive1(currentPosition,tail);}
                if((i != previousPosition[0] || j-1 != previousPosition[1]) && Snake[i][j-1] == true){
                    System.out.println("leftx");
                    tail[0]=i;tail[1]=j; currentPosition[0]= i; currentPosition[1]= j-1;findTailRecursive1(currentPosition,tail);}

        }if(i != 0 && j != 0 && i != Snake.length-1 && j!=Snake.length-1){
            RecursiveChecks++;
            RecursiveChecks++;
            RecursiveChecks++;
            length++;
                if((i-1 != previousPosition[0] || j != previousPosition[1]) && Snake[i-1][j] == true){
                    System.out.println("bottom");
                    tail[0]=i;tail[1]=j; currentPosition[0]= i-1; currentPosition[0]= j; findTailRecursive1(currentPosition,tail);}
                if(Snake[i][j+1] == true && (i != previousPosition[0] || j+1 != previousPosition[1])){
                    System.out.println("right");

                    tail[0]=i;tail[1]=j; currentPosition[0]= i; currentPosition[1]= j+1;
                    System.out.println("tail: " + tail[0]+ "" + tail[1] + "" +tail[2]);
                   findTailRecursive1(currentPosition,tail);
                }
                if((i != previousPosition[0] || j-1 != previousPosition[1]) && Snake[i][j-1] == true){
                    System.out.println("left");
                    tail[0]=i;tail[1]=j; currentPosition[0]= i; currentPosition[1]= j-1;findTailRecursive1(currentPosition,tail);}
                if(Snake[i+1][j] == true && (i+1 != previousPosition[0] || j != previousPosition[1])){
                    System.out.print("up");
                    tail[0]=i;tail[1]=j; currentPosition[0]= i+1; currentPosition[0]= j; findTailRecursive1(currentPosition,tail);}
        }
        System.out.println("tail: " + tail[0]+ "" + tail[1] + "" +tail[2]);
        System.out.println("end");

       return tail;
    }

}
