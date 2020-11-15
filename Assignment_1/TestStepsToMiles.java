package CS_221; /*Made by Azwad Shameem*/

import java.util.Scanner; /** Imports scanner so that the user can input values as the parameter values for StepsToMiles */

public class TestStepsToMiles { /** <---- Class represents the TestStepsToMiles.java file by using the name before .java */

public static void main(String[] args) /** <---- Main */
{
    /**---------------------Part A of TestStepsToMiles from PDF----------------*/
    /** Declaration of instance1 */
    StepsToMiles instance1 = new StepsToMiles();
    /** Assigning values to the class private members */
    instance1.setName("Jane Doe"); /** Set name to the match figure 1 listed in the PDF */
    instance1.setFeet(5);          /** Set feet to the match figure 1 listed in the PDF */
    instance1.setInches(4.5);      /** Set inches to match figure 1 listed in the PDF   */

    /**--------------------Part B of TestSteps To Miles From PDF---------------------------*/
    /** Prompts user for name */
    System.out.printf("%26s", "Enter Name: ");
    /** Scanner created to get inputs **/
    Scanner input = new Scanner(System.in);
    /** Saves the input as a string called name **/
    String name = input.nextLine();
    /** Prompts the user for height and ft of the person */
    System.out.printf("%26s", "Enter Height (ft and in): ");
    /** Saves the first and second input as feet and inches respectively */
    double feet = input.nextDouble();
    double inches = input.nextDouble();

    /**------------Part C of TestStepsToMiles from PDF-------------------------*/
    /** Declares second instance of StepsToMiles using non-default constructor */
    StepsToMiles instance2 = new StepsToMiles(name, feet, inches);

    /** --------------Part D of TestStepsToMiles from PDF---------------------*/
    System.out.printf(instance1.currDate()); /** Printing from 1st instance today's date */
    /** Using the 1st instance print the results of calling the function formatAsString in the printf func */
    System.out.printf(instance1.formatAsString(12345));
    /** Using the 2nd instance print the results of calling the function formatAsString in the printf func */
    System.out.printf(instance2.formatAsString(1000));

    /** Closes the Scanner */
    input.close();
}

}
