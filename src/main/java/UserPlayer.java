import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.util.List;

public class UserPlayer {

    PieceMover pieceMover = new PieceMover();
    FieldStatusChecker fieldStatusChecker = new FieldStatusChecker();
    NodeCoordinatesFinder coordinatesFinder = new NodeCoordinatesFinder();

    public void movePieceByUser (Object obj, List<Circle> whitePieces, GridPane gridPane, String pieceColor, String pieceColorWhenChosen, String opponentPieceColor, List<Circle> allPieces) {
        Integer[] chosenPieceCoordinates = getChosenPieceCoordinates(whitePieces, pieceColorWhenChosen);
        Integer[] clickedNodeCoordinates = getClickedNodeCoordinates(obj);
        Circle chosenPiece = getChosenPiece(whitePieces, pieceColorWhenChosen);
        if (Math.abs(clickedNodeCoordinates[0] - chosenPieceCoordinates[0]) == 1 && Math.abs(clickedNodeCoordinates[1] - chosenPieceCoordinates[1]) == 1) {
            if (obj instanceof Circle) {
                if (((Circle) obj).getFill().equals(Paint.valueOf(opponentPieceColor))) {
                    if (fieldStatusChecker.isTargetFieldWithinBoard(clickedNodeCoordinates) && !fieldStatusChecker.isPieceOnTheFieldOpposite(clickedNodeCoordinates, allPieces, chosenPieceCoordinates[0], chosenPieceCoordinates[1])) { //(clickedNodeCoordinates[0] + 1), (clickedNodeCoordinates[1] + 1)) || !isPieceOnTheField(allPieces, (clickedNodeCoordinates[0] - 1), (clickedNodeCoordinates[1] + 1))
                        pieceMover.movePieceToBeat(chosenPiece, chosenPieceCoordinates, clickedNodeCoordinates);
                        gridPane.getChildren().remove(obj);
                    }
                }
            } else if (obj instanceof Rectangle) {
                if (!fieldStatusChecker.isPieceOnTheField(allPieces, clickedNodeCoordinates[0], clickedNodeCoordinates[1])) {
                    pieceMover.movePieceAhead(chosenPiece, clickedNodeCoordinates, pieceColorWhenChosen, pieceColor);
                }
            }
            chosenPiece.setFill(Color.web(pieceColor));
        }
    }

    public Circle getChosenPiece(List<Circle> pieces, String pieceColorWhenChosen) {
        PieceSelector pieceSelector = new PieceSelector();
        return pieceSelector.findChosenPiece(pieces, pieceColorWhenChosen);
    }

    public Integer[] getClickedNodeCoordinates(Object obj) {
        return coordinatesFinder.getCoordinates((Node) obj);
    }

    public Integer[] getChosenPieceCoordinates(List<Circle> pieces, String pieceColorWhenChosen){
        Circle chosenPiece = getChosenPiece(pieces, pieceColorWhenChosen);
        return coordinatesFinder.getCoordinates(chosenPiece);
    }
}
