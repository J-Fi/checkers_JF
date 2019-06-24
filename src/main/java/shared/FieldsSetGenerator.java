package shared;

import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;

import java.util.List;
import java.util.stream.Collectors;

public class FieldsSetGenerator {
    public List<Rectangle> getAllFields (GridPane gridPane) {
        List<Rectangle> allFields = gridPane.getChildren().stream()
                .filter(field -> field instanceof Rectangle)
                .map(field -> (Rectangle) field)
                .collect(Collectors.toList());
        return allFields;
    }
}
