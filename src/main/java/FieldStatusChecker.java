import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;

import java.util.List;

public class FieldStatusChecker {
    public boolean isPieceOnTheField(List<Circle> allPieces, Integer col, Integer row) {
        for (Circle circle : allPieces) {
            if (GridPane.getColumnIndex(circle).equals(col) && GridPane.getRowIndex(circle).equals(row)) {
                return true;
            }
        }
        return false;
    }

    public boolean isPieceOnTheFieldOpposite (Integer[] pieceCoordinates, List<Circle> pieces, Integer col, Integer row) {
        if (pieceCoordinates[0] - col == 1 && pieceCoordinates[1] - row == -1) {
            return isPieceOnTheField(pieces, col + 2, row - 2);
        } else if (pieceCoordinates[0] - col == -1 && pieceCoordinates[1] - row == -1){
            return isPieceOnTheField(pieces, col - 2, row - 2);
        } else if (pieceCoordinates[0] - col == -1 && pieceCoordinates[1] - row == 1) {
            return isPieceOnTheField(pieces, col - 2, row + 2);
        } else if (pieceCoordinates[0] - col == 1 && pieceCoordinates[1] - row == 1) {
            return isPieceOnTheField(pieces, col + 2, row + 2);
        }
        return true;
    }

    public boolean isTargetFieldWithinBoard (Integer[] clickedNodeCoordinates) {
        Integer col = clickedNodeCoordinates[0];
        Integer row = clickedNodeCoordinates[1];
        if (col + 1 <= 8 && col - 1 >= 1 && row + 1 <= 8 & row -1 >= 1) {
            return true;
        }
        return false;
    }
}
