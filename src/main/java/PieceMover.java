import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.util.List;

public class PieceMover {

    public Circle getChosenPiece(List<Circle> pieces, String pieceColorWhenChosen) {
        PieceSelector pieceSelector = new PieceSelector();
        return pieceSelector.findChosenPiece(pieces, pieceColorWhenChosen);
    }

    public Integer[] getClickedNodeCoordinates(Object obj) {
        return getCoordinates((Node) obj);
    }

    public Integer[] getChosenPieceCoordinates(List<Circle> pieces, String pieceColorWhenChosen){
        Circle chosenPiece = getChosenPiece(pieces, pieceColorWhenChosen);
        return getCoordinates(chosenPiece);
     }

    public void movePieceAhead (Circle chosenPiece, Integer[] clickedNodeCoordinates) {
        GridPane.setColumnIndex(chosenPiece, clickedNodeCoordinates[0]);
        GridPane.setRowIndex(chosenPiece, clickedNodeCoordinates[1]);
    }

    public void movePieceToBeat (Circle chosenPiece, Integer[] chosenPieceCoordinates, Integer[] clickedNodeCoordinates) {
        Integer chosenPieceCoordinate_X = chosenPieceCoordinates[0];
        Integer chosenPieceCoordinate_Y = chosenPieceCoordinates[1];

        Integer clickedNodeCoordinate_X = clickedNodeCoordinates[0];
        Integer clickedNodeCoordinate_Y = clickedNodeCoordinates[1];

        if (chosenPieceCoordinate_X > clickedNodeCoordinate_X) {
            if (chosenPieceCoordinate_Y > clickedNodeCoordinate_Y) {
                GridPane.setColumnIndex(chosenPiece, clickedNodeCoordinates[0] - 1);
                GridPane.setRowIndex(chosenPiece, clickedNodeCoordinates[1] - 1);
            } else {
                GridPane.setColumnIndex(chosenPiece, clickedNodeCoordinates[0] - 1);
                GridPane.setRowIndex(chosenPiece, clickedNodeCoordinates[1] + 1);
            }
        } else {
            if (chosenPieceCoordinate_Y > clickedNodeCoordinate_Y) {
                GridPane.setColumnIndex(chosenPiece, clickedNodeCoordinates[0] + 1);
                GridPane.setRowIndex(chosenPiece, clickedNodeCoordinates[1] - 1);
            } else {
                GridPane.setColumnIndex(chosenPiece, clickedNodeCoordinates[0] + 1);
                GridPane.setRowIndex(chosenPiece, clickedNodeCoordinates[1] + 1);
            }
        }
    }

    public void movePieceByUser (Object obj, List<Circle> whitePieces, GridPane gridPane, String pieceColor, String pieceColorWhenChosen, String opponentPieceColor, List<Circle> allPieces) {

        Integer[] chosenPieceCoordinates = getChosenPieceCoordinates(whitePieces, pieceColorWhenChosen);
        Integer[] clickedNodeCoordinates = getClickedNodeCoordinates(obj);
        Circle chosenPiece = getChosenPiece(whitePieces, pieceColorWhenChosen);
        if (Math.abs(clickedNodeCoordinates[0] - chosenPieceCoordinates[0]) == 1 && Math.abs(clickedNodeCoordinates[1] - chosenPieceCoordinates[1]) == 1) {
            if (obj instanceof Circle) {
                if (((Circle) obj).getFill().equals(Paint.valueOf(opponentPieceColor))  && (!isPieceOnTheField(allPieces, (clickedNodeCoordinates[0] + 1), (clickedNodeCoordinates[1] + 1)) || !isPieceOnTheField(allPieces, (clickedNodeCoordinates[0] - 1), (clickedNodeCoordinates[1] - 1)))) {
                    movePieceToBeat(chosenPiece, chosenPieceCoordinates, clickedNodeCoordinates);
                    gridPane.getChildren().remove(obj);
                }
            } else if (obj instanceof Rectangle) {
                if (!isPieceOnTheField(allPieces, clickedNodeCoordinates[0], clickedNodeCoordinates[1])) {
                    movePieceAhead(chosenPiece, clickedNodeCoordinates);
                }
            }
            chosenPiece.setFill(Color.web(pieceColor));
        }
    }

    Integer[] getCoordinates(Node n) {
        Integer x = GridPane.getColumnIndex(n);
        Integer y = GridPane.getRowIndex(n);
        Integer[] coordinates = {x,y};
        //System.out.println(x + " " + y);

        return coordinates;

    }

    public boolean isPieceOnTheField(List<Circle> allPieces, Integer col, Integer row) {
        for (Circle circle : allPieces) {
            if (GridPane.getColumnIndex(circle).equals(col) && GridPane.getRowIndex(circle).equals(row)) {
                return true;
            }
        }
        return false;
    }

    public Rectangle getRectangle (List<Rectangle> allBronzeFields, Integer col, Integer row) {
        for (Rectangle bronzeRectangle : allBronzeFields) {
            if (GridPane.getColumnIndex(bronzeRectangle).equals(col) && GridPane.getRowIndex(bronzeRectangle).equals(row)) {
                return bronzeRectangle;
            }
        }
        return null;
    }

    public Circle getPiece (List<Circle> whitePieces, Integer col, Integer row) {
        for (Circle whitePiece : whitePieces) {
            if (GridPane.getColumnIndex(whitePiece).equals(col) && GridPane.getRowIndex(whitePiece).equals(row)) {
                return whitePiece;
            }
        }
        return null;
    }
}
