/**
 * Sample Skeleton for 'checkersBoard.fxml' Controller Class
 */

import java.lang.reflect.Array;
import java.net.URL;
import java.util.*;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.InputEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

public class CheckersBoardController {

    private final String whitePieceColor = "#e4f5de";
    private final String whitePieceColorWhenChosen = "yellow";
    private final String blackPieceColor = "black";
    private final String blackPieceColorWhenChosen = "grey";

    public CheckersBoardController() {

    }

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="fieldB2"
    private Rectangle fieldB2; // Value injected by FXMLLoader

    @FXML // fx:id="fieldD4"
    private Rectangle fieldD4; // Value injected by FXMLLoader

    @FXML // fx:id="fieldF6"
    private Rectangle fieldF6; // Value injected by FXMLLoader

    @FXML // fx:id="fieldH8"
    private Rectangle fieldH8; // Value injected by FXMLLoader

    @FXML // fx:id="fieldD2"
    private Rectangle fieldD2; // Value injected by FXMLLoader

    @FXML // fx:id="fieldF4"
    private Rectangle fieldF4; // Value injected by FXMLLoader

    @FXML // fx:id="fieldH6"
    private Rectangle fieldH6; // Value injected by FXMLLoader

    @FXML // fx:id="fieldB6"
    private Rectangle fieldB6; // Value injected by FXMLLoader

    @FXML // fx:id="fieldD8"
    private Rectangle fieldD8; // Value injected by FXMLLoader

    @FXML // fx:id="fieldB4"
    private Rectangle fieldB4; // Value injected by FXMLLoader

    @FXML // fx:id="fieldD6"
    private Rectangle fieldD6; // Value injected by FXMLLoader

    @FXML // fx:id="fieldF8"
    private Rectangle fieldF8; // Value injected by FXMLLoader

    @FXML // fx:id="fieldF2"
    private Rectangle fieldF2; // Value injected by FXMLLoader

    @FXML // fx:id="fieldH4"
    private Rectangle fieldH4; // Value injected by FXMLLoader

    @FXML // fx:id="fieldH2"
    private Rectangle fieldH2; // Value injected by FXMLLoader

    @FXML // fx:id="fieldB8"
    private Rectangle fieldB8; // Value injected by FXMLLoader

    @FXML // fx:id="fieldA1"
    private Rectangle fieldA1; // Value injected by FXMLLoader

    @FXML // fx:id="fieldC3"
    private Rectangle fieldC3; // Value injected by FXMLLoader

    @FXML // fx:id="fieldE5"
    private Rectangle fieldE5; // Value injected by FXMLLoader

    @FXML // fx:id="fieldG7"
    private Rectangle fieldG7; // Value injected by FXMLLoader

    @FXML // fx:id="fieldC1"
    private Rectangle fieldC1; // Value injected by FXMLLoader

    @FXML // fx:id="fieldE3"
    private Rectangle fieldE3; // Value injected by FXMLLoader

    @FXML // fx:id="fieldG5"
    private Rectangle fieldG5; // Value injected by FXMLLoader

    @FXML // fx:id="fieldA5"
    private Rectangle fieldA5; // Value injected by FXMLLoader

    @FXML // fx:id="fieldC7"
    private Rectangle fieldC7; // Value injected by FXMLLoader

    @FXML // fx:id="fieldA3"
    private Rectangle fieldA3; // Value injected by FXMLLoader

    @FXML // fx:id="fieldC5"
    private Rectangle fieldC5; // Value injected by FXMLLoader

    @FXML // fx:id="fieldE7"
    private Rectangle fieldE7; // Value injected by FXMLLoader

    @FXML // fx:id="fieldE1"
    private Rectangle fieldE1; // Value injected by FXMLLoader

    @FXML // fx:id="fieldG3"
    private Rectangle fieldG3; // Value injected by FXMLLoader

    @FXML // fx:id="fieldG1"
    private Rectangle fieldG1; // Value injected by FXMLLoader

    @FXML // fx:id="fieldA7"
    private Rectangle fieldA7; // Value injected by FXMLLoader

    @FXML // fx:id="pieceWhite_1"
    private Circle pieceWhite_1; // Value injected by FXMLLoader

    @FXML // fx:id="pieceWhite_2"
    private Circle pieceWhite_2; // Value injected by FXMLLoader

    @FXML // fx:id="pieceWhite_3"
    private Circle pieceWhite_3; // Value injected by FXMLLoader

    @FXML // fx:id="pieceWhite_4"
    private Circle pieceWhite_4; // Value injected by FXMLLoader

    @FXML // fx:id="pieceWhite_5"
    private Circle pieceWhite_5; // Value injected by FXMLLoader

    @FXML // fx:id="pieceWhite_6"
    private Circle pieceWhite_6; // Value injected by FXMLLoader

    @FXML // fx:id="pieceWhite_7"
    private Circle pieceWhite_7; // Value injected by FXMLLoader

    @FXML // fx:id="pieceWhite_8"
    private Circle pieceWhite_8; // Value injected by FXMLLoader

    @FXML // fx:id="pieceBlack_1"
    private Circle pieceBlack_1; // Value injected by FXMLLoader

    @FXML // fx:id="pieceBlack_2"
    private Circle pieceBlack_2; // Value injected by FXMLLoader

    @FXML // fx:id="pieceBlack_3"
    private Circle pieceBlack_3; // Value injected by FXMLLoader

    @FXML // fx:id="pieceBlack_4"
    private Circle pieceBlack_4; // Value injected by FXMLLoader

    @FXML // fx:id="pieceBlack_5"
    private Circle pieceBlack_5; // Value injected by FXMLLoader

    @FXML // fx:id="pieceBlack_6"
    private Circle pieceBlack_6; // Value injected by FXMLLoader

    @FXML // fx:id="pieceBlack_7"
    private Circle pieceBlack_7; // Value injected by FXMLLoader

    @FXML // fx:id="pieceBlack_8"
    private Circle pieceBlack_8; // Value injected by FXMLLoader

    @FXML // fx:id="checkersBoard"
    private GridPane checkersBoard;

    @FXML
    private Button computerTurn;

    public List<Rectangle> bronzeFieldsCollection() {
        Rectangle[] bronzeFields = new Rectangle[] {fieldA1, fieldA3, fieldA5, fieldA7,
                                                    fieldB2, fieldB4, fieldB6, fieldB8,
                                                    fieldC1, fieldC3, fieldC5, fieldC7,
                                                    fieldD2, fieldD4, fieldD6, fieldD8,
                                                    fieldE1, fieldE3, fieldE5, fieldE7,
                                                    fieldF2, fieldF4, fieldF6, fieldF8,
                                                    fieldG1, fieldG3, fieldG5, fieldG7,
                                                    fieldH2, fieldH4, fieldH6, fieldH8};
        return Arrays.asList(bronzeFields);
    }


    public List<Circle> whitePiecesCollection() {
        Circle[] whitePieces = new Circle[] {pieceWhite_1, pieceWhite_2, pieceWhite_3,
                                            pieceWhite_4, pieceWhite_5, pieceWhite_6,
                                            pieceWhite_7, pieceWhite_8};
        return Arrays.asList(whitePieces);
    }

/*    public ArrayList<Circle> whitePiecesCollection() {
        ArrayList<Circle> whitePiecesCollection = new ArrayList<>();
        whitePiecesCollection.add(pieceWhite_1);
        whitePiecesCollection.add(pieceWhite_2);
        whitePiecesCollection.add(pieceWhite_3);
        whitePiecesCollection.add(pieceWhite_4);
        whitePiecesCollection.add(pieceWhite_5);
        whitePiecesCollection.add(pieceWhite_6);
        whitePiecesCollection.add(pieceWhite_7);
        whitePiecesCollection.add(pieceWhite_8);
        return whitePiecesCollection;
    }*/

    public List<Circle> blackPiecesCollection() {
        Circle[] blackPieces = new Circle[] {pieceBlack_1, pieceBlack_2, pieceBlack_3,
                                            pieceBlack_4, pieceBlack_5, pieceBlack_6,
                                            pieceBlack_7, pieceBlack_8};
        return Arrays.asList(blackPieces);
    }

    public List<Circle> mergedPiecesCollection() {
        List<Circle> mergedList = new ArrayList<>(whitePiecesCollection());
        mergedList.addAll(blackPiecesCollection());

        return mergedList;
    }

    public List<Circle> blackPieces() {
        PieceSelector pieceSelector = new PieceSelector();
        List<Circle> blackPieces = pieceSelector.getAllBlackPieces(checkersBoard, blackPieceColor);
        return blackPieces;
    }

    public List<Circle> whitePieces() {
        PieceSelector pieceSelector = new PieceSelector();
        List<Circle> whitePieces = pieceSelector.getAllWhitePieces(checkersBoard, whitePieceColor, whitePieceColorWhenChosen);
        return whitePieces;
    }

    public List<Circle> allPieces() {
        PieceSelector pieceSelector = new PieceSelector();
        List<Circle> allPieces = pieceSelector.getAllPieces(checkersBoard);
        return allPieces;
    }

    public List<Rectangle> allFields() {
        PieceSelector pieceSelector = new PieceSelector();
        List<Rectangle> allFields = pieceSelector.getAllFields(checkersBoard);
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
        PieceMover pieceMover = new PieceMover();
        pieceMover.movePieceByUser(obj, whitePieces(), checkersBoard, whitePieceColor, whitePieceColorWhenChosen, blackPieceColor, allPieces());
        //computerMove();
    }

    @FXML
    void computerMove () {
        ComputerPlayer computerMove = new ComputerPlayer();
        //computerMove.computerChoosesPiece(blackPiecesCollection(), blackPieceColorWhenChosen);
        /*PieceSelector pieceSelector = new PieceSelector();
        List<Circle> blackPieces = pieceSelector.getOneColorPieces(checkersBoard, blackPieceColor);
        List<Circle> whitePieces = pieceSelector.getOneColorPieces(checkersBoard, whitePieceColor);
        List<Circle> allPieces = pieceSelector.getAllPieces(checkersBoard);
        List<Rectangle> allFields = pieceSelector.getAllFields(checkersBoard);*/
        System.out.println("All rectangles " + allFields().size());
        System.out.println("All whitePieces " + whitePieces().size());
        System.out.println("All blackPieces " + blackPieces().size());
        System.out.println("All blackPieces " + blackPieces().size());
        System.out.println("fx:id " + pieceWhite_3.getId());
        computerMove.computerMovesPiece(blackPieces(), whitePieces(), allPieces(), allFields(), checkersBoard);
    }



    /*@FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert pieceBlack_8 != null : "fx:id=\"pieceBlack_8\" was not injected: check your FXML file 'checkersBoard.fxml'.";
        assert pieceBlack_7 != null : "fx:id=\"pieceBlack_7\" was not injected: check your FXML file 'checkersBoard.fxml'.";
        assert pieceBlack_6 != null : "fx:id=\"pieceBlack_6\" was not injected: check your FXML file 'checkersBoard.fxml'.";
        assert pieceBlack_5 != null : "fx:id=\"pieceBlack_5\" was not injected: check your FXML file 'checkersBoard.fxml'.";
        assert pieceBlack_4 != null : "fx:id=\"pieceBlack_4\" was not injected: check your FXML file 'checkersBoard.fxml'.";
        assert pieceBlack_3 != null : "fx:id=\"pieceBlack_3\" was not injected: check your FXML file 'checkersBoard.fxml'.";
        assert pieceBlack_2 != null : "fx:id=\"pieceBlack_2\" was not injected: check your FXML file 'checkersBoard.fxml'.";
        assert pieceBlack_1 != null : "fx:id=\"pieceBlack_1\" was not injected: check your FXML file 'checkersBoard.fxml'.";
        assert pieceWhite_8 != null : "fx:id=\"pieceWhite_8\" was not injected: check your FXML file 'checkersBoard.fxml'.";
        assert pieceWhite_7 != null : "fx:id=\"pieceWhite_7\" was not injected: check your FXML file 'checkersBoard.fxml'.";
        assert pieceWhite_6 != null : "fx:id=\"pieceWhite_6\" was not injected: check your FXML file 'checkersBoard.fxml'.";
        assert pieceWhite_5 != null : "fx:id=\"pieceWhite_5\" was not injected: check your FXML file 'checkersBoard.fxml'.";
        assert pieceWhite_4 != null : "fx:id=\"pieceWhite_4\" was not injected: check your FXML file 'checkersBoard.fxml'.";
        assert pieceWhite_3 != null : "fx:id=\"pieceWhite_3\" was not injected: check your FXML file 'checkersBoard.fxml'.";
        assert pieceWhite_2 != null : "fx:id=\"pieceWhite_2\" was not injected: check your FXML file 'checkersBoard.fxml'.";
        assert pieceWhite_1 != null : "fx:id=\"pieceWhite_1\" was not injected: check your FXML file 'checkersBoard.fxml'.";

    }*/
}
