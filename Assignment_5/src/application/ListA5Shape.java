package application;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;

public class ListA5Shape {
    @XmlElement
    ArrayList<A5Shape> myShapeList = new ArrayList<>();

    public int size() { return myShapeList.size(); }

    public void clear() { myShapeList.clear(); }
}
