/*********************************************
 * Hafsa Alaparmak
 * CS2336.001
 * 11/28/2022
 **********************************************/
import java.util.Scanner;

public class HumanPlayer extends APlayer {
    Scanner input = new Scanner(System.in);

    HumanPlayer(String mark) {
        super(mark);
    }

    public int selectRowValue(int range) {
        char row;
        do{
            System.out.println("\nPlease select a valid row on the board (0 to " + (range-1) + ")");
            row = input.next().charAt(0);
        }while(!Character.isDigit(row) || (row - '0') >= range);

        System.out.println("\nSelected Row : " + row);
        return (row - '0');
    }

    public int selectColValue(int range) {
        char col;
        do {
            System.out.println("\nPlease select a valid col on the board (0 to " + (range-1) + ")");
            col = input.next().charAt(0);
        }while (!Character.isDigit(col) || (col - '0') >= range);

        System.out.println("Selected Col : " + col);
        return (col - '0');
    }

    public int selectBoardValue(int range) {
        char b;
        do {
            System.out.println("\nPlease select a valid board (0 to " + (range-1) + ")");
            b = input.next().charAt(0);
        } while (!Character.isDigit(b) || (b - '0') >= range);
        System.out.println("Selected Board is : " + b);
        return (b - '0');
    }
}