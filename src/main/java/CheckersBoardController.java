/**
 * Sample Skeleton for 'checkersBoard.fxml' Controller Class
 */

import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ResourceBundle;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
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

    @FXML // fx:id="piece_C7"
    private Circle piece_C7; // Value injected by FXMLLoader

    @FXML // fx:id="piece_D8"
    private Circle piece_D8; // Value injected by FXMLLoader

    @FXML // fx:id="piece_A7"
    private Circle piece_A7; // Value injected by FXMLLoader

    @FXML // fx:id="piece_B8"
    private Circle piece_B8; // Value injected by FXMLLoader

    @FXML // fx:id="piece_B2"
    private Circle piece_B2; // Value injected by FXMLLoader

    @FXML // fx:id="piece_A1"
    private Circle piece_A1; // Value injected by FXMLLoader

    @FXML // fx:id="piece_G7"
    private Circle piece_G7; // Value injected by FXMLLoader

    @FXML // fx:id="piece_H8"
    private Circle piece_H8; // Value injected by FXMLLoader

    @FXML // fx:id="piece_F8"
    private Circle piece_F8; // Value injected by FXMLLoader

    @FXML // fx:id="piece_E7"
    private Circle piece_E7; // Value injected by FXMLLoader

    @FXML // fx:id="piece_E1"
    private Circle piece_E1; // Value injected by FXMLLoader

    @FXML // fx:id="piece_F2"
    private Circle piece_F2; // Value injected by FXMLLoader

    @FXML // fx:id="piece_C1"
    private Circle piece_C1; // Value injected by FXMLLoader

    @FXML // fx:id="piece_D2"
    private Circle piece_D2; // Value injected by FXMLLoader

    @FXML // fx:id="piece_G1"
    private Circle piece_G1; // Value injected by FXMLLoader

    @FXML // fx:id="piece_H2"
    private Circle piece_H2; // Value injected by FXMLLoader

    @FXML
    private GridPane checkersBoard;

    public Circle getPiece_C7() {
        return piece_C7;
    }

    public Circle getPiece_D8() {
        return piece_D8;
    }

    public Circle getPiece_A7() {
        return piece_A7;
    }

    public Circle getPiece_B8() {
        return piece_B8;
    }

    public Circle getPiece_G7() {
        return piece_G7;
    }

    public Circle getPiece_H8() {
        return piece_H8;
    }

    public Circle getPiece_F8() {
        return piece_F8;
    }

    public Circle getPiece_E7() {
        return piece_E7;
    }


    @FXML
    void markPieceA7 () {
        if ((piece_A7.getFill()).equals(Color.web("#e4f5de"))) {
            piece_A7.setFill(Paint.valueOf("yellow"));
        } else if (piece_A7.getFill().equals(Paint.valueOf("yellow"))){
            piece_A7.setFill(Color.web("#e4f5de"));
        }

    }



    public LinkedList<Circle> whitePiecesCollection() {
        LinkedList<Circle> whitePieces = new LinkedList<>();
        whitePieces.add(piece_A7);
        whitePieces.add(piece_B8);
        whitePieces.add(piece_C7);
        whitePieces.add(piece_D8);
        whitePieces.add(piece_E7);
        whitePieces.add(piece_F8);
        whitePieces.add(piece_G7);
        whitePieces.add(piece_H8);

        return whitePieces;
    }

    public LinkedList<Circle> blackPiecesCollection() {
        LinkedList<Circle> blackPieces = new LinkedList<>();
        blackPieces.add(piece_A1);
        blackPieces.add(piece_B2);
        blackPieces.add(piece_C1);
        blackPieces.add(piece_D2);
        blackPieces.add(piece_E1);
        blackPieces.add(piece_F2);
        blackPieces.add(piece_G1);
        blackPieces.add(piece_H2);

        return blackPieces;
    }

    public Circle findOtherYellowPiece(LinkedList<Circle> list) {
        for (Circle circle : list) {
            if (circle.getFill().equals(Paint.valueOf("yellow"))) {
                return circle;
            }

        }
        return null;
    }


    @FXML
    void markPiece (MouseEvent event) { //
        getCoordinates();
        Node circle = (Circle) event.getSource();
        PiecesCollections pc = new PiecesCollections();
        Circle flag = pc.findOtherYellowPiece(whitePiecesCollection());
        if ((circle.getFill()).equals(Color.web("#e4f5de"))) {
            if (flag == null) {
                circle.setFill(Paint.valueOf("yellow"));
            } else {
                flag.setFill(Color.web("#e4f5de"));
                circle.setFill(Paint.valueOf("yellow"));
            }
        } else if (circle.getFill().equals(Paint.valueOf("yellow"))){
            circle.setFill(Color.web("#e4f5de"));
        }
    }

     int[] getCoordinates(Node n) {
        int x = GridPane.getColumnIndex(n);
        int y = GridPane.getRowIndex(n);
        int[] coordinates = {x,y};
        System.out.println(x + " " + y);

        return coordinates;

    }

    @FXML
    void move (MouseEvent event) {
        Object o = event.getSource();
        int[] coordinates = getCoordinates((Node)o);
        TranslateTransition translateTransition = new TranslateTransition();
        translateTransition.setDuration(Duration.millis(2000));
        if (o instanceof Circle) {
            if(((Circle) o).getFill().equals(Paint.valueOf("black"))) {
                checkersBoard.getChildren().remove(o);

            }
        } else if (o instanceof Rectangle){

        Rectangle rectangle = (Rectangle) event.getSource();

        translateTransition.setNode(piece_E7);
        translateTransition.setByX(-100.0);
        translateTransition.setByY(-100.0);
        translateTransition.play();
        }

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert piece_C7 != null : "fx:id=\"piece_C7\" was not injected: check your FXML file 'checkersBoard.fxml'.";
        assert piece_D8 != null : "fx:id=\"piece_D8\" was not injected: check your FXML file 'checkersBoard.fxml'.";
        assert piece_A7 != null : "fx:id=\"piece_A7\" was not injected: check your FXML file 'checkersBoard.fxml'.";
        assert piece_B8 != null : "fx:id=\"piece_B8\" was not injected: check your FXML file 'checkersBoard.fxml'.";
        assert piece_B2 != null : "fx:id=\"piece_B2\" was not injected: check your FXML file 'checkersBoard.fxml'.";
        assert piece_A1 != null : "fx:id=\"piece_A1\" was not injected: check your FXML file 'checkersBoard.fxml'.";
        assert piece_G7 != null : "fx:id=\"piece_G7\" was not injected: check your FXML file 'checkersBoard.fxml'.";
        assert piece_H8 != null : "fx:id=\"piece_H8\" was not injected: check your FXML file 'checkersBoard.fxml'.";
        assert piece_F8 != null : "fx:id=\"piece_F8\" was not injected: check your FXML file 'checkersBoard.fxml'.";
        assert piece_E7 != null : "fx:id=\"piece_E7\" was not injected: check your FXML file 'checkersBoard.fxml'.";
        assert piece_E1 != null : "fx:id=\"piece_E1\" was not injected: check your FXML file 'checkersBoard.fxml'.";
        assert piece_F2 != null : "fx:id=\"piece_F2\" was not injected: check your FXML file 'checkersBoard.fxml'.";
        assert piece_C1 != null : "fx:id=\"piece_C1\" was not injected: check your FXML file 'checkersBoard.fxml'.";
        assert piece_D2 != null : "fx:id=\"piece_D2\" was not injected: check your FXML file 'checkersBoard.fxml'.";
        assert piece_G1 != null : "fx:id=\"piece_G1\" was not injected: check your FXML file 'checkersBoard.fxml'.";
        assert piece_H2 != null : "fx:id=\"piece_H2\" was not injected: check your FXML file 'checkersBoard.fxml'.";

    }
}
