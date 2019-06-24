package shared;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

import java.util.List;

public class PieceSelector {

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
    * findChosenPiece() method confirms if there are any yellow pieces on the board already
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
