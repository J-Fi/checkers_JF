import javafx.scene.shape.Circle;

import java.util.*;

public class ComputerPlayerMoveToBeatGenerator {
    ComputerPlayerAvailableFieldsSetGenerator availableFieldsSetGenerator = new ComputerPlayerAvailableFieldsSetGenerator();
    NodeCoordinatesFinder coordinatesFinder = new NodeCoordinatesFinder();
    FieldStatusChecker fieldStatusChecker = new FieldStatusChecker();
    ComputerPlayerNodeGetter nodeGetter = new ComputerPlayerNodeGetter();

    public List<Circle> getUserPiecesToBeat (Circle computerPiece, List<Circle> userPieces, List<Circle> allPieces) {
        List<Circle> userPiecesToBeat = new ArrayList<>();
        Integer[] coordinates = coordinatesFinder.getCoordinates(computerPiece);
        Map<ArrayList<Integer>, ArrayList<Integer>> fourCornerFieldsList = availableFieldsSetGenerator.getAdjacentToAdjacentFieldsCoordinates(coordinates);
        for (Map.Entry<ArrayList<Integer>, ArrayList<Integer>> arrayListCorner : fourCornerFieldsList.entrySet()) {
            if (fieldStatusChecker.isPieceOnTheField(userPieces, arrayListCorner.getKey().get(0), arrayListCorner.getKey().get(1))) {
                if (!fieldStatusChecker.isPieceOnTheField(allPieces, arrayListCorner.getValue().get(0), arrayListCorner.getValue().get(1))) {
                    Circle userPieceToBeat = nodeGetter.getPiece(userPieces, arrayListCorner.getKey().get(0), arrayListCorner.getKey().get(1));
                    userPiecesToBeat.add(userPieceToBeat);
                }
            }
        }
        return userPiecesToBeat;
    }

    public List<Circle> getAllUserPiecesToBeat (List<Circle> computerPieces, List<Circle> userPieces, List<Circle> allPieces) {
        Set<Circle> allUserPiecesToBeatSet = new HashSet<>();

        for (Circle computerPiece : computerPieces) {
            List<Circle> userPiecesToBeat = getUserPiecesToBeat(computerPiece, userPieces, allPieces);
            for (Circle userPieceToBeat : userPiecesToBeat) {
                allUserPiecesToBeatSet.add(userPieceToBeat);
            }
        }
        List<Circle> allUserPiecesToBeat = new ArrayList<>(allUserPiecesToBeatSet);
        return allUserPiecesToBeat;
    }

    public Circle getRandomUserPieceToBeat (List<Circle> computerPieces, List<Circle> userPieces, List<Circle> allPieces) {
        Random numberGenerator = new Random();
        List<Circle> allUserPiecesToBeat = getAllUserPiecesToBeat(computerPieces, userPieces, allPieces);
        int fieldNumberInArray = numberGenerator.nextInt(allUserPiecesToBeat.size());
        Circle randomUserPieceToBeat = allUserPiecesToBeat.get(fieldNumberInArray);
        return randomUserPieceToBeat;
    }

    public List<Circle> getComputerPiecesToBeatUserPiece (Circle randomUserPieceToBeat, List<Circle> computerPieces, List<Circle> allPieces) {
        Integer[] randomUserPieceToBeatCoordinates = coordinatesFinder.getCoordinates(randomUserPieceToBeat);
        List<Circle> computerPiecesToBeatUserPiece = new ArrayList<>();
        List<ArrayList<Integer>> lowerAdjacentFieldsList = availableFieldsSetGenerator.getLowerAdjacentFieldsCoordinates(randomUserPieceToBeatCoordinates);
        List<ArrayList<Integer>> upperAdjacentFieldsList = availableFieldsSetGenerator.getUpperAdjacentFieldsCoordinates(randomUserPieceToBeatCoordinates);
        List<ArrayList<Integer>> allAdjacentFieldsList = new ArrayList<>(lowerAdjacentFieldsList);
        allAdjacentFieldsList.addAll(upperAdjacentFieldsList);
        for(ArrayList<Integer> arrayList : allAdjacentFieldsList) {
            if (fieldStatusChecker.isPieceOnTheField(computerPieces, arrayList.get(0), arrayList.get(1))) {
                if (!fieldStatusChecker.isPieceOnTheFieldOpposite(randomUserPieceToBeatCoordinates, allPieces, arrayList.get(0), arrayList.get(1))) {
                    Circle computerPieceToBeatUserPiece = nodeGetter.getPiece(computerPieces, arrayList.get(0), arrayList.get(1));
                    computerPiecesToBeatUserPiece.add(computerPieceToBeatUserPiece);
                }
            }
        }
        return computerPiecesToBeatUserPiece;
    }

    public Circle getRandomComputerPieceToBeatUserPiece (List<Circle> computerPieces, List<Circle> userPieces, List<Circle> allPieces) {
        Circle randomUserPieceToBeat = getRandomUserPieceToBeat(computerPieces, userPieces, allPieces);
        List<Circle> computerPiecesToBeatUserPiece = getComputerPiecesToBeatUserPiece(randomUserPieceToBeat, computerPieces, allPieces);
        Random numberGenerator = new Random();
        int fieldNumberInArray = numberGenerator.nextInt(computerPiecesToBeatUserPiece.size());
        Circle randomComputerPieceToBeatUserPiece = computerPiecesToBeatUserPiece.get(fieldNumberInArray);
        return randomComputerPieceToBeatUserPiece;
    }
}
