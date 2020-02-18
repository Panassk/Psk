import java.util.*;
public class MazeRunner {
    static Maze myMap = new Maze();
    static int totalMoves = 0;
    static boolean mywin = false;

    public static void main(String[] args) {
        intro(myMap);
        while (!mywin) {
            String direction = userMove();
            canMove(direction);
        }
        if ((mywin) && totalMoves <= 100)
            System.out.println("Congratulations, you win and you made it in" + totalMoves + " moves");
        if (totalMoves > 100) System.out.println("Sorry, but you didn't escape in time----YOU LOSE!");
    }

    public static void intro(Maze m) {
        System.out.println("Hello, this is the current state of the Maze");
        m.printMap();
    }

    public static String userMove() {
        Scanner mo = new Scanner(System.in);
        System.out.println("Which way would you like to move? Right(R), Left(L), Up(U), Donw(D)");
        String move = mo.next();
        char m = move.charAt(0);
        totalMoves++;
        if (m == 'R' || m == 'L' || m == 'D' || m == 'U') {
            System.out.println("nice move");
        } else userMove();
        if (totalMoves == 50) System.out.println("Warning: You have made 50 moves, you have 50 remaining before the maze exit closes");
        if (totalMoves == 75) System.out.println("Alert! You have made 75 moves, you only have 25 left to escape");
        if (totalMoves == 90) System.out.println("DANGER! You have made 90 moves, you only have 10 moves left to escape");
        if (totalMoves > 100) mywin = true;
        return move;
    }

    public static boolean canMove(String direction) {
        boolean j, win;
        if (mywin == false) {
            if (direction.equals("R") && (myMap.canIMoveRight())) {
                j = navigatePit(direction);
                if (j) {
                    myMap.moveRight();
                    myMap.printMap();
                    System.out.println("Nice Move");
                    mywin = myMap.didIWin();
                }
            }
        } else if (direction.equals("L") && (myMap.canIMoveLeft())) {
            j = navigatePit(direction);
            if (j) {
                j = navigatePit(direction);
                myMap.moveLeft();
                myMap.printMap();
                System.out.println("Nice Move");
                mywin = myMap.didIWin();
            }
        } else if (direction.equals("U") && (myMap.canIMoveUp())) {
            j = navigatePit(direction);
            if (j) {
                j = navigatePit(direction);
                myMap.moveUp();
                myMap.printMap();
                System.out.println("Nice Move");
                mywin = myMap.didIWin();
            }
        } else if (direction.equals("D") && (myMap.canIMoveDown())) {
            j = navigatePit(direction);
            if (j) {
                myMap.moveDown();
                myMap.printMap();
                System.out.println("Nice Move");
                mywin = myMap.didIWin();
            }
        } else {
            System.out.println("Sorry you've hit a wall");
            myMap.printMap();
            mywin = myMap.didIWin();
        }
        win=mywin;
        return win;
    }
    public static boolean navigatePit(String direction) {
        Scanner jump = new Scanner(System.in);
        boolean ju = false;
        if (myMap.isThereAPit(direction)) {
            System.out.println("There is a pit in front do you want to jump it?");
            String j = jump.nextLine();
            if (j.equals("Yes")) {
                myMap.jumpOverPit(direction);
            }
            ju=true;
        }
        return ju;
    }
}
