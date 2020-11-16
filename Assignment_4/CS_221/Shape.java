package CS_221; /*Created by Azwad Shameem*/
import java.awt.*;

/**An abstract class which implements Java’s comparable interface*/
public abstract class Shape implements Comparable<Shape> {
    protected final Integer id; // An integer variable to store the id of the shape //
    protected final String name; // A string to store the shape's name //
    protected final String description; // A string to store the description of the shape //
    protected Color color; // A Color object to store the color //

    /**Shape class constructor stores the default fields for the shape
     * @param id input id for the Shape
     * @param name name of the Shape
     * @param description description of the Shape
     * @param color color of the Shape*/
    public Shape(int id, String name, String description, Color color) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.color = color;
    }

    /**Declares an area abstract method to be implemented in Quadrilateral and Quadrilateral3D
     * @return Quadrilateral or Quadrilateral3D will determine what area it will return*/
    public abstract double area();
    /**Declares an perimeter abstract method to be implemented in Quadrilateral and Quadrilateral3D
     * @return Quadrilateral or Quadrilateral3D will determine what perimeter it will return*/
    public abstract double perimeter();

    /**Compares the instance s to the current instance of shape by the name then the color
     * @param s takes a Shape instance to compare
     * @return returns a value that is used to compare the shape instance in the TreeSet to find where to sort it*/
    public int compareTo(Shape s) {
        int result = this.name.compareTo(s.name); // First compares name //
        if (result == 0) { result = this.getColorName(this.color).compareTo(s.getColorName(s.color)); } // Then compares color //
        return result;
    }

    /**Takes the current instance of shape and converts it into a multi-line string
     * @return returns a formatted string with all the fields organized in a specific order*/
    public String toString() { return String.format("%d %s %s %s", id, name, getColorName(this.color), description); }

    /**Checks which color is equal to the instance's color then returns the string of that color
     * @param c takes the a Color instance and compares it to Color.*
     * @return returns a string version of the color*/
    public String getColorName(Color c) {
        if (Color.BLACK.equals(c)) {
            return "BLACK";
        } else if (Color.WHITE.equals(c)) {
            return "WHITE";
        } else if (Color.BLUE.equals(c)) {
            return "BLUE";
        } else if (Color.CYAN.equals(c)) {
            return "CYAN";
        } else if (Color.YELLOW.equals(c)) {
            return "YELLOW";
        } else if (Color.GREEN.equals(c)) {
            return "GREEN";
        } else if (Color.RED.equals(c)) {
            return "RED";
        } return null;
    }
}