import java.util.*;
public class MazeRunner {
    static Maze myMap=new Maze();
    static int totalMoves=0;
    public static void main(String[] args){
        boolean mywin=false;
        intro(myMap);
        while (!mywin) {
            String direction=userMove();
            canMove(direction);
        }

    }
    public static void intro(Maze m){
        System.out.println("Hello, this is the current state of the Maze");
        m.printMap();
    }
    public static String userMove() {
        Scanner mo = new Scanner(System.in);
        System.out.println("Which way would you like to move? Right(R), Left(L), Up(U), Donw(D)");
        String move = mo.next();
        char m = move.charAt(0);
        if (m=='R'||m=='L'||m=='D'||m=='U'){
            System.out.println("nice move");
        }else userMove();
        return move;
    }
    public static boolean canMove(String direction){
        boolean mywin;
        if(direction.equals("R")&&(myMap.canIMoveRight())){
            myMap.moveRight();
            myMap.printMap();
            System.out.println("Nice Move");
            mywin=myMap.didIWin();
        }else if(direction.equals("L")&&(myMap.canIMoveLeft())){
            myMap.moveLeft();
            myMap.printMap();
            System.out.println("Nice Move");
            mywin=myMap.didIWin();
        }else if(direction.equals("U")&&(myMap.canIMoveUp())){
            myMap.moveUp();
            myMap.printMap();
            System.out.println("Nice Move");
            mywin=myMap.didIWin();
        }else if(direction.equals("D")&&(myMap.canIMoveDown())){
            myMap.moveDown();
            myMap.printMap();
            System.out.println("Nice Move");
            mywin=myMap.didIWin();
        }else{
            System.out.println("Sorry you've hit a wall");
            myMap.printMap();
            mywin=myMap.didIWin();
        }
        return mywin;

    }
}
