package computerPlayer;

import shared.*;

import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.util.*;

public class ComputerPlayer {

    private ComputerPlayerMoveToBeatGenerator moveToBeatGenerator = new ComputerPlayerMoveToBeatGenerator();
    private ComputerPlayerMoveAheadGenerator moveAheadGenerator = new ComputerPlayerMoveAheadGenerator();
    private NodeCoordinatesFinder coordinatesFinder = new NodeCoordinatesFinder();
    private PieceMover pieceMover = new PieceMover();

    public int computerMovesPiece (List<Circle> blackPieces, List<Circle> whitePieces, List<Circle> allPieces, List<Rectangle> allBronzeFields, GridPane gridPane, String whitePieceColorWhenChosen, String blackPieceColor) {
        List<Circle> allUserPiecesToBeat = moveToBeatGenerator.getAllUserPiecesToBeat(blackPieces, whitePieces, allPieces);
        System.out.println("allUserPiecesToBeat " + allUserPiecesToBeat.size());
        List<Rectangle> allFieldsToMoveAhead = moveAheadGenerator.getAllFieldsToMoveAhead(blackPieces, allPieces, allBronzeFields);
        System.out.println("allFieldsToMoveAhead " + allFieldsToMoveAhead.size());
        if (allUserPiecesToBeat.size() > 0) {
            Circle randomUserPieceToBeat = moveToBeatGenerator.getRandomUserPieceToBeat(blackPieces, whitePieces, allPieces);
            Integer[] randomUserPieceToBeatCoordinates = coordinatesFinder.getCoordinates(randomUserPieceToBeat);

            Circle randomComputerPieceToBeatUserPiece = moveToBeatGenerator.getRandomComputerPieceToBeatUserPiece(blackPieces, whitePieces, allPieces);
            Integer[] randomComputerPieceToBeatUserPieceCoordinates = coordinatesFinder.getCoordinates(randomComputerPieceToBeatUserPiece);

            pieceMover.movePieceToBeat(randomComputerPieceToBeatUserPiece,randomComputerPieceToBeatUserPieceCoordinates,randomUserPieceToBeatCoordinates);
            gridPane.getChildren().remove(randomUserPieceToBeat);
            return 1;
        } else {
            if (allFieldsToMoveAhead.size() > 0) {
                Rectangle randomEmptyField = moveAheadGenerator.getRandomEmptyField(blackPieces, allPieces, allBronzeFields);
                Integer[] randomEmptyFieldCoordinates = coordinatesFinder.getCoordinates(randomEmptyField);
                Circle randomPieceToMoveAhead = moveAheadGenerator.getRandomPieceToMoveAhead(randomEmptyField, blackPieces);

                pieceMover.movePieceAhead(randomPieceToMoveAhead, randomEmptyFieldCoordinates, whitePieceColorWhenChosen, blackPieceColor);
                return 2;
            } else {
                System.out.println("Game OVER!");
                return 0;
            }
        }
    }
}


