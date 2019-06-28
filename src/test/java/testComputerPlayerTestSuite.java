import computerPlayer.ComputerPlayer;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class testComputerPlayerTestSuite {
    private ComputerPlayer computerPlayer = new ComputerPlayer();
    private GridPane gridPane = new GridPane();

    private Rectangle field1 = new Rectangle();
    private Rectangle field2 = new Rectangle();
    private Rectangle field3 = new Rectangle();
    private Rectangle field4 = new Rectangle();
    private Rectangle field5 = new Rectangle();
    private Rectangle field6 = new Rectangle();
    private Rectangle field7 = new Rectangle();
    private Rectangle field8 = new Rectangle();

    private List<Rectangle> fieldsList = new ArrayList<>();

    private List<Circle> blackPieces = new ArrayList<>();
    private List<Circle> whitePieces = new ArrayList<>();
    private List<Circle> allPieces = new ArrayList<>();
    private List<Rectangle> allBronzeFields = new ArrayList<>();

    @Before
    public void testInit() {
        fieldsList.add(field1);
        fieldsList.add(field2);
        fieldsList.add(field3);
        fieldsList.add(field4);
        fieldsList.add(field5);
        fieldsList.add(field6);
        fieldsList.add(field7);
        fieldsList.add(field8);

        gridPane.add(field1,0,0);
        gridPane.add(field2,0,2);
        gridPane.add(field3,1,1);
        gridPane.add(field4,1,3);
        gridPane.add(field5,2,0);
        gridPane.add(field6,2,2);
        gridPane.add(field7,3,1);
        gridPane.add(field8,3,3);
    }
    @Test
    public void testComputerMovesPieceToBeat() {
        //Given
        Circle whitePiece = new Circle();
        Circle blackPiece = new Circle();

        whitePieces.add(whitePiece);
        blackPieces.add(blackPiece);

        allPieces.add(whitePiece);
        allPieces.add(blackPiece);

        allBronzeFields.addAll(fieldsList);

        whitePiece.setFill(Color.web("#e4f5de"));
        gridPane.add(whitePiece,2,2);

        blackPiece.setFill(Color.web("black"));
        gridPane.add(blackPiece,1,1);

        //when
        int check = computerPlayer.computerMovesPiece(blackPieces, whitePieces, allPieces, allBronzeFields, gridPane, "yellow", "black");

        //then
        assertEquals(check, 1);
    }

    @Test
    public void testComputerMovesPieceAhead() {
        //Given
        Circle blackPiece = new Circle();

        blackPieces.add(blackPiece);

        allPieces.add(blackPiece);

        allBronzeFields.addAll(fieldsList);

        blackPiece.setFill(Color.web("black"));
        gridPane.add(blackPiece,2,2);

        //when
        int check = computerPlayer.computerMovesPiece(blackPieces, whitePieces, allPieces, allBronzeFields, gridPane, "yellow", "black");

        //then
        assertEquals(check, 2);
    }

    @Test
    public void testComputerHasNoMoreMoves() {
        //Given
        Circle blackPiece = new Circle();
        Circle whitePiece1 = new Circle();
        Circle whitePiece2 = new Circle();

        blackPieces.add(blackPiece);

        whitePieces.add(whitePiece1);
        whitePieces.add(whitePiece2);

        allPieces.add(blackPiece);
        allPieces.add(whitePiece1);
        allPieces.add(whitePiece2);

        allBronzeFields.addAll(fieldsList);

        blackPiece.setFill(Color.web("black"));
        gridPane.add(blackPiece,1,1);

        whitePiece1.setFill(Color.web("#e4f5de"));
        gridPane.add(whitePiece1,2,2);

        whitePiece2.setFill(Color.web("#e4f5de"));
        gridPane.add(whitePiece2,3,3);

        //when
        int check = computerPlayer.computerMovesPiece(blackPieces, whitePieces, allPieces, allBronzeFields, gridPane, "yellow", "black");

        //then
        assertEquals(check, 0);
    }
}
