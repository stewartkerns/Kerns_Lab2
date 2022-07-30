/*
 * Stewart Kerns
 * CPSC 5002, Seattle University
 * This is free and unencumbered software released into the public domain.
 */
package Kerns_Lab2;

import java.util.Random;    //import the Random class

/**
 * This class allows for a creation of a "loaded die" which will land on a
 * chosen side a chosen percentage more often, otherwise it will land on the
 * other sides an even amount of times
 *
 * @author Stewart Kerns
 * @version 1.0
 */
public class LoadedDie {
    //declare an integer to hold the loaded number to roll more
    private int loadedNumber;
    //declare an integer to hold the percentage it rolls the loaded number more
    private int moreTimesPerHundred;
    //declare an integer to hold the result of the roll
    private int result;

    //declare a final integer to hold the number of sides on the die
    private final int SIDES;
    //declare a final integer to hold the upper bound of the percentage number
    private final int MAX;


    /**
     * The constructor performs an initial roll of the die and sets the sides
     * of the die, and max/min for percentage
     *
     * @param loadedNumber        which number should come up more often
     * @param moreTimesPerHundred how many times per 100 rolls to come up with
     *                            the loaded number (instead of uniform random)
     */
    public LoadedDie(int loadedNumber, int moreTimesPerHundred){
        //set loadedNumber to the input received
        this.loadedNumber = loadedNumber;
        //set moreTimesPerHundred to the input received
        this.moreTimesPerHundred = moreTimesPerHundred;
        //Set the sides of the die to 6
        this.SIDES = 6;
        //Set the max to 100
        this.MAX = 100;

        //roll the die for an initial roll
        roll();
    }

    /**
     * The roll method simulates the rolling of the die. It will typically set
     * this die's value to a random value with uniform distribution between
     * 1 and 6. Occasionally, it will a priori return the favored value
     * (with frequency determined by the moreTimesPerHundred argument that was
     * passed to the constructor).
     */
    public void roll(){
        //create a new random object
        Random rand = new Random();
        //make a random number between 1 and 100
        int between100 = rand.nextInt(MAX);
        //if the number is falls below moreTimesPerHundred the result is the
        //loaded number
        if (between100 < moreTimesPerHundred){
            //set result to the loadedNumber
            result = loadedNumber;
        }
        //otherwise roll the die normally
        else{
            //set the result to between 1 and 6
            result = rand.nextInt(SIDES) + 1;
        }
    }

    /**
     * This method returns the result of the roll
     *
     * @return int value of the roll
     */
    public int getResult(){
        //return the result of the roll
        return result;
    }

    /**
     * This method allows the loaded number to be changed after the constructor
     * sets it
     *
     * @param loadedNumber the number to roll more frequently
     */
    public void setLoadedNumber(int loadedNumber){
        //set the loaded number
        this.loadedNumber = loadedNumber;
    }

    /**
     * This method allows the percentage of times the loaded number will be used
     * to be changed after the constructor sets it
     *
     * @param moreTimesPerHundred the percentage the loaded number will be
     *                            chosen
     */
    public void setMoreTimesPerHundred(int moreTimesPerHundred){
        //set moreTimesPerHundred
        this.moreTimesPerHundred = moreTimesPerHundred;
    }

    /**
     * This method allows for getting of the number of sides on the die
     *
     * @return int value for the number of sides of the die
     */
    public int getSides(){
        //return the number of sides
        return SIDES;
    }

}
