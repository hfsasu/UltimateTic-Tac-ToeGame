/*********************************************
 * Hafsa Alaparmak
 * CS2336.001
 * 11/28/2022
 **********************************************/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("===== WELCOME TO THE ULTIMATE TIC-TAC-TOE GAME!! =====\n");
        System.out.println("Please select game modality: ");
        System.out.println("1) Player   vs Computer");
        System.out.println("2) Computer vs Computer");
        System.out.println("3) Player   vs Player");

        //get user input for the menu of choices
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();

        //create a new TTT game. game is the object of TTTGame class
        TTTGame game = new TTTGame();

        //According to the user's menu choice, choose the players
        if (num == 1) {
            game.setPlayers(new HumanPlayer(Mark.X.getMark()), new ComputerPlayer(Mark.O.getMark()));
        } else if (num == 2) {
            game.setPlayers(new ComputerPlayer(Mark.X.getMark()), new ComputerPlayer(Mark.O.getMark()));
        } else if (num == 3) {
            game.setPlayers(new HumanPlayer(Mark.X.getMark()), new HumanPlayer(Mark.O.getMark()));
        }

        //start the game
        game.start();

    }
}