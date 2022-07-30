/*
 * Stewart Kerns
 * CPSC 5002, Seattle University
 * This is free and unencumbered software released into the public domain.
 */
package Kerns_Lab2;

import java.util.Scanner;   //Import the scanner class

/**
 * This program allows the user to roll dice against the computer and after 10
 * games it will display who won overall
 *
 * @author Stewart Kerns
 * @version 1.0
 */
public class DiceGame {

    /**
     * The main method welcomes the user, creates a Scanner object runs the
     * game, and prints a goodbye message to the user once they're done running
     * the game as many times as they want
     *
     * @param args a String array containing the command line arguments
     */
    public static void main(String[] args){
        //create a new Scanner object for reading user input
        Scanner keyboardIn = new Scanner(System.in);
        //Welcome the player to the game
        welcome();
        //play the game
        playGame(keyboardIn);
        //Print a goodbye message to the user
        goodbye();
        //close the Scanner object
        keyboardIn.close();
    }

    /**
     * This method plays the game by rolling the dice 10 times, telling the user
     * who won the round, and then telling the user who won overall, the user
     * can play as many times as they choose
     * @param keyboardIn A scanner object for reading keyboard input
     */
    public static void playGame(Scanner keyboardIn){
        //create a final int for the number of times to play
        final int NUM_PLAY = 10;
        //create a final char to continue the game if requested
        final char CONT_GAME = 'Y';

        //make a do while loop to run the game as many times as requested
        do{
            //create two LoadedDie objects for the user and computer
            LoadedDie computer = new LoadedDie(6, 30);
            LoadedDie user = new LoadedDie(1, 30);
            //create two final ints for the elements where scores will be stored
            final int COMP_ELEMENT = 0;
            final int USER_ELEMENT = 1;

            //Create an array to hold the winner scores
            int[] countWin = {0, 0};

            //Run the first game out of the for loop since constructor rolled
            System.out.println("\nRoll 1 of 10:");
            //compare the results of the user and computers initial rolls
            compareResults(computer.getResult(), user.getResult(), countWin,
                    keyboardIn, COMP_ELEMENT, USER_ELEMENT);

            //run a for loop for the rest of the 10 games
            for (int i = 2; i <= NUM_PLAY; i++){
                //Tell the user what roll they're on
                System.out.println("\nRoll " + i + " of 10:");
                //roll for the computer
                computer.roll();
                //roll for the user
                user.roll();
                //compare the results of the user and computer and tell winner
                compareResults(computer.getResult(), user.getResult(), countWin,
                        keyboardIn, COMP_ELEMENT, USER_ELEMENT);
            }
            //Compare how many wins the user and computer have and output winner
            compareWins(countWin[COMP_ELEMENT], countWin[USER_ELEMENT] );

        //continue to play the whole game as long as the user wants
        } while (continuePrgrm(keyboardIn) == CONT_GAME);
    }

    /**
     * This method takes in how many times the user and computer won out of ten
     * times and then compares the results, it then lets the user know who won
     * the overall game
     * @param compWins how many times the computer won
     * @param userWins how many times the user won
     */
    public static void compareWins(int compWins, int userWins)
    {
        //Print how many times the computer won
        System.out.println("\nI won " + compWins +
                " times");
        //print how many times the user won
        System.out.println("You won " + userWins +
                " times");
        //print a message if the computer won
        if (compWins > userWins){
            System.out.println("Grand winner is me!");
        }
        //print a different message if the user won
        else if (compWins < userWins){
            System.out.println("Grand winner is user you...for now");
        }
        //print a message if there was a tie
        else {
            System.out.println("No one is the grand winner!");
        }
    }

    /**
     * This method compares asks the user to hit enter when they want to roll
     * and also prints what the results of both the computer and user rolls were
     * before printing who is the winner for that round
     *
     * @param compResult the result of the computer roll
     * @param userResult the result of the user roll
     * @param countWin an array that holds how many times each has won
     * @param keyboardIn a Scanner object for taking keyboard input
     * @param COMP_ELEMENT the element the computer score is in
     * @param USER_ELEMENT the element the user score is in
     */
    public static void compareResults(int compResult, int userResult,
                                      int[] countWin, Scanner keyboardIn,
                                      final int COMP_ELEMENT,
                                      final int USER_ELEMENT){

        //print what the computer rolled
        System.out.println("I rolled a " + compResult);
        //ask the user to hit enter to roll
        System.out.print("Ready to roll? (Press ENTER when ready)");
        //take in the "enter" from the user and go to the next line
        keyboardIn.nextLine();
        //tell the user what they rolled
        System.out.println("You rolled a " + userResult);

        //compare the results to each other
        if (compResult > userResult){
            //add 1 to the computer wins if their result was higher
            countWin[COMP_ELEMENT]++;
            //print that the computer won
            System.out.println("I win this round!");
        }
        else if (compResult < userResult){
            //add 1 to the user wins if their result was higher
            countWin[USER_ELEMENT]++;
            //print that the user won
            System.out.println("You win this round...");
        }
        else{
            //if no one won, print that there was a tie, don't add points at all
            System.out.println("We tied! No one gets a point!");
        }

    }
    /**
     * This method asks the user if they would like to run the program again
     * and returns the first character of their answer in upper case
     * @param keyboardIn A scanner object to read keyboard input
     * @return char the first character of their response in upper case
     */
    public static char continuePrgrm(Scanner keyboardIn){
        //ask the user if they want to run again
        System.out.print("\nWould you like to run the program again? (Y/N): ");
        return keyboardIn.nextLine().toUpperCase().charAt(0);
    }

    /**
     * This method prints a welcome message to the user
     */
    public static void welcome(){
        //print the message
        System.out.println("This is a game of you vs the computer.  We will " +
                "each\nhave one die. We will roll our own die and the higher " +
                "number\nwins. We roll ten times and the one with the higher " +
                "number\nof wins is the grand winner.");
    }

    /**
     * This method prints a goodbye message to the user
     */
    public static void goodbye(){
        //print the message
        System.out.println("\nThanks for playing!");
    }
}
