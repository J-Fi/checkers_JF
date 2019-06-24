package computerPlayer;

import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.util.List;

class ComputerPlayerNodeGetter {

    Rectangle getRectangle(List<Rectangle> fields, Integer col, Integer row) {
        for (Rectangle bronzeRectangle :fields) {
            if (GridPane.getColumnIndex(bronzeRectangle).equals(col) && GridPane.getRowIndex(bronzeRectangle).equals(row)) {
                return bronzeRectangle;
            }
        }
        return null;
    }

    Circle getPiece(List<Circle> pieces, Integer col, Integer row) {
        for (Circle piece : pieces) {
            if (GridPane.getColumnIndex(piece).equals(col) && GridPane.getRowIndex(piece).equals(row)) {
                return piece;
            }
        }
        return null;
    }
}
