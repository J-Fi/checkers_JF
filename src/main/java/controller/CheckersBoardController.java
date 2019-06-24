package controller;

import computerPlayer.*;
import shared.*;
import userPlayer.*;

import java.util.*;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class CheckersBoardController {

    private final static String WHITE_PIECE_COLOR = "#e4f5de";
    private final static String WHITE_PIECE_COLOR_WHEN_CHOSEN = "yellow";
    private final static String BLACK_PIECE_COLOR = "black";

    private PiecesSetGenerator psg = new PiecesSetGenerator();
    private FieldsSetGenerator fsg = new FieldsSetGenerator();
    private PieceSelector pieceSelector = new PieceSelector();
    private UserPlayer userPlayer = new UserPlayer();
    private ComputerPlayer computerMove = new ComputerPlayer();

    public CheckersBoardController() {
    }

    @FXML // fx:id="checkersBoard"
    private GridPane checkersBoard;

    private List<Circle> blackPieces() {
        return psg.getAllBlackPieces(checkersBoard, BLACK_PIECE_COLOR);
    }

    private List<Circle> whitePieces() {
        return psg.getAllWhitePieces(checkersBoard, WHITE_PIECE_COLOR, WHITE_PIECE_COLOR_WHEN_CHOSEN);
    }

    private List<Circle> allPieces() {
        return psg.getAllPieces(checkersBoard);
    }

    private List<Rectangle> allFields() {
        return fsg.getAllFields(checkersBoard);
    }

    @FXML
    void markPiece (MouseEvent event) { //
        Circle circle = (Circle) event.getSource();
        pieceSelector.selectPieceToMove(circle, whitePieces(), WHITE_PIECE_COLOR, WHITE_PIECE_COLOR_WHEN_CHOSEN);
    }

    @FXML
    void move (MouseEvent event) {
        Object obj = event.getSource();
        userPlayer.movePieceByUser(obj, whitePieces(), checkersBoard, WHITE_PIECE_COLOR, WHITE_PIECE_COLOR_WHEN_CHOSEN, BLACK_PIECE_COLOR, allPieces());
    }

    @FXML
    void computerMove () {
        computerMove.computerMovesPiece(blackPieces(), whitePieces(), allPieces(), allFields(), checkersBoard, WHITE_PIECE_COLOR_WHEN_CHOSEN, BLACK_PIECE_COLOR);
    }
}
