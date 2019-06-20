import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PieceSelector {

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

    public List<Rectangle> getAllFields (GridPane gridPane) {
        List<Rectangle> allFields = gridPane.getChildren().stream()
                .filter(field -> field instanceof Rectangle)
                .map(field -> (Rectangle) field)
                .collect(Collectors.toList());
        return allFields;
    }



    /*
    * selectPieceToMove is responsible for selecting a piece to move
    */
    public void selectPieceToMove (Circle circle, List<Circle> pieces, String pieceColor, String pieceColorWhenChosen) {
        Circle chosenCircle = findChosenPiece(pieces, pieceColorWhenChosen);
        if ((circle.getFill()).equals(Color.web(pieceColor))) {
            if (chosenCircle == null) {
                circle.setFill(Paint.valueOf(pieceColorWhenChosen));
            } else {
                chosenCircle.setFill(Color.web(pieceColor));
                circle.setFill(Paint.valueOf(pieceColorWhenChosen));
            }
        } else if (circle.getFill().equals(Paint.valueOf(pieceColorWhenChosen))) {
            circle.setFill(Color.web(pieceColor));
        }
    }

    /*
    * findYellowPiece() method confirms if there are any yellow pieces on the board already
    * */
    public Circle findChosenPiece(List<Circle> list, String pieceColorWhenChosen) {
        for (Circle circle : list) {
            if (circle.getFill().equals(Paint.valueOf(pieceColorWhenChosen))) {
                return circle;
            }
        }
        return null;
    }
}
