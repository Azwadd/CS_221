package CS_221; /*Created by Azwad Shameem*/
import java.util.Random;/**This import allows us to randomly create a number between two numbers*/

public class TortoiseAndHare {
    private static final Random r = new Random();/**Initiates the random number generator r*/
    public static final int MAX_MOVES = 100; /**Sets the maximum number of squares in the race*/
    public static final int MAX_ITERATIONs = 2000; /**Sets the maxiumum number of iterations in the race*/
    /**Declares the variable to store the position of the tortoise and hare*/
    public static int t = 0;
    public static int h = 0;
    private int iterations = 0; /**Declares the number of iterations starting at 0*/

    public TortoiseAndHare()
    {
        /**Step 1 - Printing starting message for the race*/
        System.out.println("ON YOUR MARK, GET SET");
        System.out.println("BANG !!!!!");
        System.out.println("AND THEY'RE OFF !!!!!");
        printPositions();
        /**Step 2 - Prints the original location of the Hare and Tortoise at the start of the race
         Step 3 - Repeats the simulation of the movement of the Hare and Tortoise until one wins or max_iterations*/
        while (t != (MAX_MOVES-1) && h != (MAX_MOVES-1) && iterations < MAX_ITERATIONs)
        {
            simulateTortoiseMove();
            simulateHareMove();
            printPositions();
            ++iterations;
        }
        /**Prints the results of the race*/
        if (iterations == MAX_ITERATIONs)
        {
            System.out.println("Time Out!");
        }
        if (h == t)
        {
            System.out.println("It's a tie");
        } else if (t > h)
        {
            System.out.println("TORTOISE WINS!!! YAY!!!");
        } else
        {
            System.out.println("Hare wins. Yuch!");
        }
        System.out.printf("%s%d","Time Elapsed = seconds ", iterations);
    }

    public static void main(String[] var0) { new TortoiseAndHare(); }

    private void printPositions() {
        System.out.printf("%s%d%n","Iteration: ", iterations);
        /**Prints the race track and shows the position of the Tortoise and the Hare.
         Use the Letter 'T' to represent the Tortoise, 'H' for the Hare,
         and 'B' if both are on the same square.
         Below uses an instance of the for loop as per requested by the pdf*/
        for (int i = 0;i < MAX_MOVES;i++)
        {
            if (i == t && h == t) {
                /**If the tortoise and hare are at the same location print B*/
                System.out.print('B');
            } else if (i == t)
            {
                /**Prints T at the location of the Tortoise */
                System.out.print('T');
            } else if (i == h)
            {
                /**Prints the H at the location of the Hare*/
                System.out.print('H');
            } else
            {
                /**prints a space for every square on the race 0-99*/
                System.out.print(' ');
            }
        }
        /**Replaces the spaces with '-' for each square so that the simulation looks like a race*/
        System.out.printf(String.format("%n%100s%n", "").replace(' ', '-'));
    }

    private static int randomBetween(int min, int max) {
        /**returns an integer random number between two limits (inclusive)*/
        return r.nextInt(max - min + 1) + min;
    }

    private void simulateHareMove()
    {
        /**function which simulates the movements of the Hare
         Uses a switch to call randomBetween to decide a number from 1-10,
         each number from 1-10 has a probability of 10%
         10% chance of sleeping resulting in no movement
         30% chance of jumping forwards for any number between 1-5 squares
         20% chance of having a small slip backwards for any number between 1-2 squares
         10% chance of having a big slip backwards for any number between 1-7 squares
         30% chance of walking forward for any number between 0-1 squares*/
        switch (randomBetween(1, 10))
        {
            case 1:
                /**10% chance of sleeping resulting in no movement*/
                break;
            case 2:
            case 3:
            case 4:
                /**Cases 2,3,4 : a total of 3 cases equal 30% probability
                 30% chance of jumping forwards for any number between 1-5 squares*/
                h += randomBetween(1, 5);
                break;
            case 5:
            case 6:
                /**Cases 5,6: a total of 2 cases equal 20% probability
                 20% chance of having a small slip backwards for any number between 1-2 squares*/
                h -= randomBetween(1, 2);
                break;
            case 7:
                /**Case 7 is one total case resulting in 10% probability
                 10% chance of having a big slip backwards for any number between 1-7 squares*/
                h -= randomBetween(1, 7);
                break;
            case 8:
            case 9:
            case 10:
                /**Cases 8,9,10: a total of 3 cases equals 30% probability
                 30% chance of walking forward for any number between 0-1 squares*/
                h += randomBetween(0, 1);
        }
        /**Boundary checker - Makes sure the tortoise stay in bounds of the race*/
        if (h < 0) { h = 0; } else if (h > (MAX_MOVES-1)) { h = (MAX_MOVES-1); }
    }

    private void simulateTortoiseMove()
    {
        /*function which simulates the movements of the Tortoise
        Uses a switch to call randomBetween to decide a number from 1-10,
        each number from 1-10 has a probability of 10%
        10% chance of sleeping resulting in no movement
        40% chance of jumping forwards for any number between 1-3 squares
        30% chance of slipping backwards for any number between 1-6 squares
        20% chance of walking forwards for any number between 0-1 squares*/
        switch (randomBetween(1, 10))
        {
            case 1:
                /**10% chance of sleeping resulting in no movement*/
                break;
            case 2:
            case 3:
            case 4:
            case 5:
                /**Case 2,3,4,5 in total 4 cases are equal to 40% probability
                 40% chance of jumping forwards for any numbers between 1-3 squares*/
                t += randomBetween(1,3);
                break;
            case 6:
            case 7:
            case 8:
                /**Case 6,7,8 in total 3 cases are equal to 30% probability
                 30% chance of slipping backwards for any numbers between 1-6 squares*/
                t -= randomBetween(1,6);
                break;
            case 9:
            case 10:
                /**Case 9,10 in total 2 cases are equal to 20% probability
                 20% chance of walking forwards for any numbers between 0-1 squares*/
                t += randomBetween(0,1);
        }
        /**Boundary checker - Makes sure the tortoise stay in bounds of the race*/
        if (t < 0) { t = 0; } else if (t > (MAX_MOVES-1)) { t = (MAX_MOVES-1); }
    }
}