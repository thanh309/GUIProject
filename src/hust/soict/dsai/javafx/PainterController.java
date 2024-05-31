package hust.soict.dsai.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;

    @FXML
    private RadioButton eraserRadioButton;

    @FXML
    private RadioButton penRadioButton;

    @FXML
    private ToggleGroup toolsToggleGroup;

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        RadioButton selectedRadioButton = (RadioButton) toolsToggleGroup.getSelectedToggle();
        if (selectedRadioButton == penRadioButton) {
            Circle newCircle = new Circle(event.getX(),
                    event.getY(), 4, Color.BLACK);
            drawingAreaPane.getChildren().add(newCircle);
        } else {
            Rectangle newRectangle = new Rectangle(20, 20, Color.WHITE);
            newRectangle.setX(event.getX() - 10);
            newRectangle.setY(event.getY() - 10);
            drawingAreaPane.getChildren().add(newRectangle);
        }
    }
}
