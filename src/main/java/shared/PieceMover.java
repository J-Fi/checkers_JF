package shared;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PieceMover {

    private Integer chosenPiece_col;
    private Integer chosenPiece_row;
    private Integer clickedNode_col;
    private Integer clickedNode_row;

    private NodeCoordinatesFinder coordinatesFinder = new NodeCoordinatesFinder();

    public void movePieceAhead (Circle chosenPiece, Integer[] clickedNodeCoordinates, String whitePieceColorWhenChosen, String blackPieceColor) {

        Integer[] chosenPieceCoordinates = coordinatesFinder.getCoordinates(chosenPiece);

        chosenPiece_col = chosenPieceCoordinates[0];
        chosenPiece_row = chosenPieceCoordinates[1];
        clickedNode_col = clickedNodeCoordinates[0];
        clickedNode_row = clickedNodeCoordinates[1];

        if (chosenPiece.getFill().equals(Color.web(whitePieceColorWhenChosen))) {
            if (clickedNode_row > chosenPiece_row) {
                GridPane.setColumnIndex(chosenPiece, clickedNode_col);
                GridPane.setRowIndex(chosenPiece, clickedNode_row);
            }
        } else if (chosenPiece.getFill().equals(Color.web(blackPieceColor))) {
            if (clickedNode_row < chosenPiece_row) {
                GridPane.setColumnIndex(chosenPiece, clickedNode_col);
                GridPane.setRowIndex(chosenPiece, clickedNode_row);
            }
        }
    }

    public void movePieceToBeat (Circle chosenPiece, Integer[] chosenPieceCoordinates, Integer[] clickedNodeCoordinates) {
        chosenPiece_col = chosenPieceCoordinates[0];
        chosenPiece_row = chosenPieceCoordinates[1];
        clickedNode_col = clickedNodeCoordinates[0];
        clickedNode_row = clickedNodeCoordinates[1];

        if (chosenPiece_col > clickedNode_col) {
            if (chosenPiece_row > clickedNode_row) {
                GridPane.setColumnIndex(chosenPiece, clickedNode_col - 1);
                GridPane.setRowIndex(chosenPiece, clickedNode_row - 1);
            } else {
                GridPane.setColumnIndex(chosenPiece, clickedNode_col - 1);
                GridPane.setRowIndex(chosenPiece, clickedNode_row + 1);
            }
        } else{
            if (chosenPiece_row > clickedNode_row) {
                GridPane.setColumnIndex(chosenPiece, clickedNode_col + 1);
                GridPane.setRowIndex(chosenPiece, clickedNode_row - 1);
            } else {
                GridPane.setColumnIndex(chosenPiece, clickedNode_col + 1);
                GridPane.setRowIndex(chosenPiece, clickedNode_row + 1);
            }
        }
    }
}
