package CS_221; /*Made by Azwad Shameem*/

import java.util.Calendar; /** Calendar used to find the current date */

public class StepsToMiles
{
    private String name;   /** Declared private name variable */
private double feet;   /** Declared private feet variable */
private double inches; /** Declared private inches variable */

    /** Default constructor with the default variable values as listed in the pdf */
    public StepsToMiles()
    {
        this.name = null;   /** Set name to null as stated by the PDF */
        this.feet = -1;     /** Set feet to -1 as stated by the PDF   */
        this.inches = -1;   /** Set inches to -1 as stated by the PDF */
    }

    /** Non-default constructor to initialize with the input variables in the parameter */
    public StepsToMiles(String name, double feet, double inches)
    {
        this.name = name;
        this.feet = feet;
        this.inches = inches;
    }

    public void setFeet(double feet) { this.feet = feet; } /** function to set the value of feet */

public void setInches(double inches) { this.inches = inches; } /** function to set value of inches */

public void setName(String name) { this.name = name; } /** function to set the name */

public String getName() { return name; } /* function to get the current value of name */

    public double getFeet() { return feet; } /* function to get the current value of feet */

    public double getInches() { return inches; } /** function to get hte current value of inches */

public double height_inches() { return (this.feet*12 + this.inches); } /** function to find the total inches of height */

public double strideLength_Inches() { return height_inches()*0.413; } /** function to return the total inches of height then multiply by 0.413 to get the stride length */

public double miles(int steps) { return ((strideLength_Inches()*steps)/(12*5280)); } /** function to get the stride length and then multiply by the steps then divide by 12*5280 to find and return the miles traveled */

    /** function to format all the values and prints them by name, height, stride, steps, walk */
    public String formatAsString(int steps)
    {
        /** String A is a formatted string version of the name from getName() */
        String a = String.format("%14s%s%n", "Name: ", getName());
        /** String B is a formatted string version of the version from getFeet() and getInches*/
        String b = String.format("%14s%.2f' %.2f\"%n", "Height: ", getFeet(), getInches());
        /** String c is a formatted string version of the stride from strideLength_Inches */
        String c = String.format("%14s%.2f%n", "Stride: ", strideLength_Inches());
        /** String d is a formatted string version of how many steps the person takes from steps() */
        String d = String.format("%14s%,d%n", "Steps: ", steps);
        /** String e is a formatted string version of the miles by calling the miles(steps) function */
        String e = String.format("%14s%.2f%s%n%n", "Walk: ", miles(steps), " miles");
        /** returns a multi-line string that is the combinations of the strongs formatted and adjusted to specifications  */
        return a+b+c+d+e;
    }

    /** function to retrieve and get current date */
    public String currDate()
    {
        Calendar c = Calendar.getInstance(); /** Calender c object is created and gets values by calling .getInstance()*/
        /** String date is a formatted string that contains today's date */
        String date =  String.format("%n%14s%d%s%d%s%d%n%n", "Today's Date: ", c.get(Calendar.MONTH), "/", c.get(Calendar.DAY_OF_MONTH), "/", c.get(Calendar.YEAR));
        return date; /** Returns date - which is a formatted string that contains today's date */
    }
}
