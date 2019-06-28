import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import org.junit.Before;
import org.junit.Test;
import userPlayer.UserPlayer;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class testUserPlayerTestSuite {

    private UserPlayer userPlayer = new UserPlayer();
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
    public void testMovePieceByUserToBeat() {
        //Given
        Circle whitePiece = new Circle();
        Circle blackPiece = new Circle();

        whitePieces.add(whitePiece);
        blackPieces.add(blackPiece);

        allPieces.add(whitePiece);
        allPieces.add(blackPiece);

        allBronzeFields.addAll(fieldsList);

        whitePiece.setFill(Color.web("yellow"));
        gridPane.add(whitePiece,1,1);

        blackPiece.setFill(Color.web("black"));
        gridPane.add(blackPiece,2,2);

        //when
        boolean check = userPlayer.movePieceByUser(blackPiece, whitePieces, gridPane, "#e4f5de", "yellow", "black", allPieces);

        //then
        assertTrue(check);
    }

    @Test
    public void testMovePieceByUserAhead() {
        //Given
        Circle whitePiece = new Circle();

        whitePieces.add(whitePiece);

        allPieces.add(whitePiece);

        allBronzeFields.addAll(fieldsList);

        whitePiece.setFill(Color.web("yellow"));
        gridPane.add(whitePiece,1,1);

        //when
        boolean check = userPlayer.movePieceByUser(field6, whitePieces, gridPane, "#e4f5de", "yellow", "black", allPieces);

        //then
        assertTrue(check);
    }
}
