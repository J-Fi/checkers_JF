import java.util.*;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class CheckersBoardController {

    private final String whitePieceColor = "#e4f5de";
    private final String whitePieceColorWhenChosen = "yellow";
    private final String blackPieceColor = "black";

    public CheckersBoardController() {
    }

    @FXML // fx:id="checkersBoard"
    private GridPane checkersBoard;

    public List<Circle> blackPieces() {
        PiecesSetGenerator psg = new PiecesSetGenerator();
        List<Circle> blackPieces = psg.getAllBlackPieces(checkersBoard, blackPieceColor);
        return blackPieces;
    }

    public List<Circle> whitePieces() {
        PiecesSetGenerator psg = new PiecesSetGenerator();
        List<Circle> whitePieces = psg.getAllWhitePieces(checkersBoard, whitePieceColor, whitePieceColorWhenChosen);
        return whitePieces;
    }

    public List<Circle> allPieces() {
        PiecesSetGenerator psg = new PiecesSetGenerator();
        List<Circle> allPieces = psg.getAllPieces(checkersBoard);
        return allPieces;
    }

    public List<Rectangle> allFields() {
        FieldsSetGenerator fsg = new FieldsSetGenerator();
        List<Rectangle> allFields = fsg.getAllFields(checkersBoard);
        return allFields;
    }

    @FXML
    void markPiece (MouseEvent event) { //
        Circle circle = (Circle) event.getSource();
        PieceSelector pieceSelector = new PieceSelector();
        pieceSelector.selectPieceToMove(circle, whitePieces(), whitePieceColor, whitePieceColorWhenChosen);
    }

    @FXML
    void move (MouseEvent event) {
        Object obj = event.getSource();
        UserPlayer userPlayer = new UserPlayer();
        userPlayer.movePieceByUser(obj, whitePieces(), checkersBoard, whitePieceColor, whitePieceColorWhenChosen, blackPieceColor, allPieces());
    }

    @FXML
    void computerMove () {
        ComputerPlayer computerMove = new ComputerPlayer();
        computerMove.computerMovesPiece(blackPieces(), whitePieces(), allPieces(), allFields(), checkersBoard, whitePieceColorWhenChosen, blackPieceColor);
    }
}
