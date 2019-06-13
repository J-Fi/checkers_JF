import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.LinkedList;

public class PiecesCollections {
    private CheckersBoardController controller; // = new CheckersBoardController();
    private LinkedList<Circle> whitePieces; // = new LinkedList<>();
    private LinkedList<Circle> blackPieces = new LinkedList<>();
    private ArrayList<Rectangle> fields = new ArrayList<>();

    public LinkedList<Circle> generateWhitePiecesCollection() {
        controller = new CheckersBoardController();
        whitePieces = new LinkedList<>();
        whitePieces.add(controller.getPiece_E7());
        whitePieces.add(controller.getPiece_A7());
        whitePieces.add(controller.getPiece_B8());
        whitePieces.add(controller.getPiece_C7());
        whitePieces.add(controller.getPiece_D8());
        whitePieces.add(controller.getPiece_F8());
        whitePieces.add(controller.getPiece_G7());
        whitePieces.add(controller.getPiece_H8());

        return whitePieces;
    }

    public Circle findOtherYellowPiece(LinkedList<Circle> list) {
        for (Circle circle : list) {
            if (circle.getFill().equals(Paint.valueOf("yellow"))) {
                return circle;
            }
        }
        return null;
    }

}
