package application;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.xml.bind.JAXB;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Controller_Assignment5 {
    private enum PenSize {
        SMALL(2),
        MEDIUM(6),
        LARGE(10),
        XLARGE(14);
        final int radius;
        PenSize(int radius) {
            this.radius = radius;
        }
    }
    private PenSize penSize = PenSize.SMALL;

    private enum DrawColor {
        BLACK(Color.BLACK),
        RED(Color.RED),
        GREEN(Color.GREEN),
        BLUE(Color.BLUE),
        BROWN(Color.BROWN);
        final Color color;
        DrawColor(Color color) {
            this.color = color;
        }
    }
    private DrawColor drawColor = DrawColor.BLACK;

    @FXML
    private RadioButton rbBrown;

    @FXML
    private RadioButton rbBlack;

    @FXML
    private ToggleGroup tgColor;

    @FXML
    private RadioButton rbGreen;

    @FXML
    private RadioButton rbRed;

    @FXML
    private RadioButton rbBlue;

    @FXML
    private RadioButton rbSmall;

    @FXML
    private ToggleGroup tgPenSize;

    @FXML
    private RadioButton rbMed;

    @FXML
    private RadioButton rbLarge;

    @FXML
    private RadioButton rbxLarge;

    @FXML
    private TextField txtBlue;

    @FXML
    private Button btnUndo;

    @FXML
    private Button btnClear;

    @FXML
    private Pane panelDraw;

    @FXML
    private Slider sldColor;

    @FXML
    private Button btnXML;

    private ListA5Shape shapeList = new ListA5Shape();

    @FXML
    void serializeBtnEventHandler(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FileChooser fc = new FileChooser();
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("XML (*.xml)", "*.xml");
        fc.getExtensionFilters().add(filter);
        File file = fc.showSaveDialog(stage);
        BufferedWriter bw = Files.newBufferedWriter(Paths.get(String.valueOf(file)));
        JAXB.marshal(shapeList, bw);
        bw.flush();
        bw.close();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        panelDraw.getChildren().add(new Circle(event.getX(), event.getY(), penSize.radius, drawColor.color));
        shapeList.myShapeList.add(new A5Shape(event.getX(), event.getY(), penSize.radius));
    }

    @FXML
    void colorChangeEventHandler(ActionEvent event) {
        if (rbBlack.isSelected())
            drawColor = DrawColor.BLACK;
        else if (rbGreen.isSelected())
            drawColor = DrawColor.GREEN;
        else if (rbRed.isSelected())
            drawColor = DrawColor.RED;
        else if (rbBlue.isSelected())
            drawColor = DrawColor.BLUE;
        else
            drawColor = DrawColor.BROWN;
    }

    @FXML
    void penSizeChangeEventHandler(ActionEvent event) {
        if (rbSmall.isSelected())
            penSize = PenSize.SMALL;
        else if (rbMed.isSelected())
            penSize = PenSize.MEDIUM;
        else if (rbLarge.isSelected())
            penSize = PenSize.LARGE;
        else
            penSize = PenSize.XLARGE;
    }

    @FXML
    void undoButtonEventHandler(ActionEvent event) {
        panelDraw.getChildren().remove(panelDraw.getChildren().size() - 1);
        shapeList.myShapeList.remove(shapeList.size()-1);
    }

    @FXML
    void clearButtonEventHandler(ActionEvent event) {
        panelDraw.getChildren().clear();
        shapeList.clear();
    }

    @FXML
    void initialize() {
        assert rbBlack != null : "fx:id=\"rbBlack\" was not injected: check your FXML file 'Assignment5.fxml'.";
        assert rbBrown != null : "fx:id=\"rbBrown\" was not injected: check your FXML file 'Assignment5.fxml'.";
        assert tgColor != null : "fx:id=\"tgColor\" was not injected: check your FXML file 'Assignment5.fxml'.";
        assert rbGreen != null : "fx:id=\"rbGreen\" was not injected: check your FXML file 'Assignment5.fxml'.";
        assert rbRed != null : "fx:id=\"rbRed\" was not injected: check your FXML file 'Assignment5.fxml'.";
        assert rbBlue != null : "fx:id=\"rbBlue\" was not injected: check your FXML file 'Assignment5.fxml'.";
        assert rbSmall != null : "fx:id=\"rbSmall\" was not injected: check your FXML file 'Assignment5.fxml'.";
        assert tgPenSize != null : "fx:id=\"tgPenSize\" was not injected: check your FXML file 'Assignment5.fxml'.";
        assert rbMed != null : "fx:id=\"rbMed\" was not injected: check your FXML file 'Assignment5.fxml'.";
        assert rbLarge != null : "fx:id=\"rbLarge\" was not injected: check your FXML file 'Assignment5.fxml'.";
        assert rbxLarge != null : "fx:id=\"rbLarge\" was not injected: check your FXML file 'Assignment5.fxml'.";
        assert btnUndo != null : "fx:id=\"btnUndo\" was not injected: check your FXML file 'Assignment5.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'Assignment5.fxml'.";
        assert panelDraw != null : "fx:id=\"panelDraw\" was not injected: check your FXML file 'Assignment5.fxml'.";
        assert sldColor != null : "fx:id=\"sldColor\" was not injected: check your FXML file 'Assignment5.fxml'.";
        assert btnXML != null : "fx:id=\"btnXML\" was not injected: check your FXML file 'Assignment5.fxml'.";
        sldColor.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number oldValue, Number newValue) {
                txtBlue.setText(String.valueOf(((Double)((double)newValue/2.55)).intValue() + "% Blue"));
                if (newValue.intValue() == 00) {
                    panelDraw.setStyle("-fx-background-color:#FFFFFF");
                } else if (newValue.intValue() < 16) {
                    panelDraw.setStyle("-fx-background-color:#00000" + Integer.toHexString(newValue.intValue()));
                } else {
                    panelDraw.setStyle("-fx-background-color:#0000" + Integer.toHexString(newValue.intValue())); }
            }
        });
    }
}

