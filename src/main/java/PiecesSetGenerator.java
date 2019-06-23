import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.List;
import java.util.stream.Collectors;

public class PiecesSetGenerator {

    public List<Circle> getAllWhitePieces (GridPane gridPane, String color, String colorWhenChosen) {
        List<Circle> whitePieces = gridPane.getChildren().stream()
                .filter(piece -> piece instanceof Circle)
                .map(piece -> (Circle) piece)
                .filter(piece -> (piece.getFill().equals(Color.web(color)) || piece.getFill().equals(Color.web(colorWhenChosen))))
                .collect(Collectors.toList());
        return whitePieces;
    }

    public List<Circle> getAllBlackPieces (GridPane gridPane, String color) {
        List<Circle> blackPieces = gridPane.getChildren().stream()
                .filter(piece -> piece instanceof Circle)
                .map(piece -> (Circle) piece)
                .filter(piece -> piece.getFill().equals(Color.web(color)))
                .collect(Collectors.toList());
        return blackPieces;
    }

    public List<Circle> getAllPieces (GridPane gridPane) {
        List<Circle> allPieces = gridPane.getChildren().stream()
                .filter(piece -> piece instanceof Circle)
                .map(piece -> (Circle) piece)
                .collect(Collectors.toList());
        return allPieces;
    }
}
