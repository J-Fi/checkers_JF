import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.util.*;

public class ComputerPlayerMoveAheadGenerator {
    ComputerPlayerAvailableFieldsSetGenerator availableFieldsSetGenerator = new ComputerPlayerAvailableFieldsSetGenerator();
    NodeCoordinatesFinder coordinatesFinder = new NodeCoordinatesFinder();
    FieldStatusChecker fieldStatusChecker = new FieldStatusChecker();
    ComputerPlayerNodeGetter nodeGetter = new ComputerPlayerNodeGetter();

    /*creates list of all empty fields around a piece allowing to move ahead*/
    public List<Rectangle> getFieldsToMoveAhead (Circle blackPiece, List<Circle> allPieces, List<Rectangle> allBronzeFields) {
        Integer[] blackPieceCoordinates = coordinatesFinder.getCoordinates(blackPiece);
        List<Rectangle> fieldsToMoveAhead = new ArrayList<>();
        List<ArrayList<Integer>> twoAdjacentFieldsList = availableFieldsSetGenerator.getUpperAdjacentFieldsCoordinates(blackPieceCoordinates);
        for(ArrayList<Integer> arrayList : twoAdjacentFieldsList) {
            if (!fieldStatusChecker.isPieceOnTheField(allPieces, arrayList.get(0), arrayList.get(1))) {
                Rectangle rectangle = nodeGetter.getRectangle(allBronzeFields, arrayList.get(0), arrayList.get(1));
                fieldsToMoveAhead.add(rectangle);
            }
        }
        return fieldsToMoveAhead;
    }

    /*creates a set of all empty fields available for all pieces together*/
    public List<Rectangle> getAllFieldsToMoveAhead (List<Circle> blackPieces, List<Circle> allPieces, List<Rectangle> allBronzeFields) {
        Set<Rectangle> allFieldsToMoveAheadSet = new HashSet<>();

        for (Circle blackPiece : blackPieces) {
            List<Rectangle> fieldsToMoveAhead = getFieldsToMoveAhead(blackPiece, allPieces, allBronzeFields);
            for (Rectangle fieldToMoveAhead : fieldsToMoveAhead) {
                allFieldsToMoveAheadSet.add(fieldToMoveAhead);
            }
        }
        List<Rectangle> allFieldsToMoveAhead = new ArrayList<>(allFieldsToMoveAheadSet);
        return allFieldsToMoveAhead;
    }

    public Rectangle getRandomEmptyField (List<Circle> blackPieces, List<Circle> allPieces, List<Rectangle> allBronzeField) {
        Random numberGenerator = new Random();
        List<Rectangle> allFieldsToMoveAhead = getAllFieldsToMoveAhead(blackPieces, allPieces, allBronzeField);
        int fieldNumberInArray = numberGenerator.nextInt(allFieldsToMoveAhead.size());
        List<Rectangle> allFieldsToMoveAheadAsList = new ArrayList<>(allFieldsToMoveAhead);
        Rectangle randomEmptyField = allFieldsToMoveAheadAsList.get(fieldNumberInArray);
        return randomEmptyField;
    }

    public List<Circle> getPiecesToMoveAhead (Rectangle randomEmptyField, List<Circle> blackPieces) {
        Integer[] randomEmptyFieldCoordinates = coordinatesFinder.getCoordinates(randomEmptyField);
        List<Circle> piecesToMoveAhead = new ArrayList<>();
        List<ArrayList<Integer>> twoLowerAdjacentFieldsList = availableFieldsSetGenerator.getLowerAdjacentFieldsCoordinates(randomEmptyFieldCoordinates);
        for(ArrayList<Integer> arrayList : twoLowerAdjacentFieldsList) {
            if (fieldStatusChecker.isPieceOnTheField(blackPieces, arrayList.get(0), arrayList.get(1))) {
                Circle piece = nodeGetter.getPiece(blackPieces, arrayList.get(0), arrayList.get(1));
                piecesToMoveAhead.add(piece);
            }
        }
        return piecesToMoveAhead;
    }

    public Circle getRandomPieceToMoveAhead (Rectangle randomEmptyField, List<Circle> blackPieces) {
        List<Circle> piecesToMoveAhead = getPiecesToMoveAhead(randomEmptyField, blackPieces);
        Random numberGenerator = new Random();
        int fieldNumberInArray = numberGenerator.nextInt(piecesToMoveAhead.size());
        Circle randomPieceToMoveAhead = piecesToMoveAhead.get(fieldNumberInArray);
        return randomPieceToMoveAhead;
    }
}
