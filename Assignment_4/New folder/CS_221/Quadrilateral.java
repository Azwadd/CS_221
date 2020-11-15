package CS_221; /*Created by Azwad Shameem*/
import java.awt.*;

/**Quadrilateral extends Shape2D and is instantiated in test file for 2D shapes*/
public class Quadrilateral extends Shape2D {
    /**Quadrilateral class constructor to store the fields of Shape2D by using super
     * @param id input id for the Quadrilateral
     * @param name name of the Quadrilateral
     * @param description description of the Quadrilateral
     * @param color color of the Quadrilateral
     * @param height the height of a Quadrilateral
     * @param width the width of a Quadrilateral*/
    public Quadrilateral(int id, String name, String description, Color color, double height, double width) { super(id, name, description, color, height, width); }

    /**This implementation finds the 2D area of the shape
     * @return returns a 2D shape's area*/
    @Override
    public double area() { return (width*height); }

    /**This implementation finds the 2D perimeter of the shape
     * @return returns a 2D shape's perimeter*/
    @Override
    public double perimeter() { return (2*(height*width)); }

}