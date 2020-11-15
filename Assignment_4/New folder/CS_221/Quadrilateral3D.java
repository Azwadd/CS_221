package CS_221; /*Created by Azwad Shameem*/
import java.awt.*;

/**Quadrilateral3D extends Shape3D and is instantiated in test file for 3D shapes*/
public class Quadrilateral3D extends Shape3D {
    /**Quadrilateral3D class constructor to store the fields of Shape3D by using super
     * @param id input id for the Quadrilateral3D
     * @param name name of the Quadrilateral3D
     * @param description description of the Quadrilateral3D
     * @param color color of the Quadrilateral3D
     * @param height the height of a Quadrilateral3D
     * @param width the width of a Quadrilateral3D
     * @param length the length of a Quadrilateral3D*/
    public Quadrilateral3D(int id, String name, String description, Color color, double height, double width, double length) { super(id, name, description, color, height, width, length); }

    /**This implementation finds the 3D area of the shape
     * @return returns a 3D shape's area(volume)*/
    @Override
    public double area() { return (2*(width*height)+(width*length)+(height*length)); }

    /**This implementation finds the 3D perimeter of the shape
     * @return returns a 3D shape's perimeter*/
    @Override
    public double perimeter() { return (4*(width+height+length)); }
}