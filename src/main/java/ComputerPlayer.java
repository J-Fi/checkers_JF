import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.util.*;
import java.util.stream.Collectors;


public class ComputerPlayer {
//Random numberGenerator = new Random();
//PieceMover pieceMover = new PieceMover();

/*public Circle computerChoosesPiece (List<Circle> blackPieces, String blackPieceColorWhenChosen) {
int pieceNumber = numberGenerator.nextInt(8);
Circle chosenPiece = blackPieces.get(pieceNumber);
chosenPiece.setFill(Paint.valueOf(blackPieceColorWhenChosen));
return chosenPiece;
}*/

public void computerMovesPiece (List<Circle> blackPieces, List<Circle> whitePieces, List<Circle> allPieces, List<Rectangle> allBronzeFields, GridPane gridPane) {
    Map<Circle, Circle> movePieceToBeatMap = movePieceToBeatMapGenerator(blackPieces, whitePieces, allPieces);
    System.out.println("movePieceToBeatMap " + movePieceToBeatMap.size());
    PieceMover pieceMover = new PieceMover();

    if (movePieceToBeatMap.size() > 0) {

        Map.Entry<Circle, Circle> pieceAndMoveToBeat = getPieceAndMoveToBeat(movePieceToBeatMap, whitePieces);

        Circle chosenPiece = pieceAndMoveToBeat.getValue();
        System.out.println("chosenPiece " + chosenPiece.getId());
        Circle clickedNode = pieceAndMoveToBeat.getKey();
        System.out.println("clickedNode " + clickedNode.getId());


        Integer[] chosenPieceCoordinates = pieceMover.getCoordinates(chosenPiece);
        Integer[] clickedNodeCoordinates = pieceMover.getCoordinates(clickedNode);

        pieceMover.movePieceToBeat(chosenPiece,chosenPieceCoordinates,clickedNodeCoordinates);
        gridPane.getChildren().remove(clickedNode);


    } else {
        Set<Rectangle> allFieldsToMoveAhead = getAllFieldsToMoveAhead(blackPieces, allPieces, allBronzeFields);
        if (allFieldsToMoveAhead.size() != 0) {
            Rectangle randomEmptyField = getRandomEmptyField(allFieldsToMoveAhead);
            List<Circle> piecesToMoveAhead = getPiecesToMoveAhead(randomEmptyField, blackPieces);
            Circle randomPieceToMoveAhead = getRandomPieceToMoveAhead(piecesToMoveAhead);
            Integer[] randomEmptyFieldCoordinates = pieceMover.getCoordinates(randomEmptyField);
            pieceMover.movePieceAhead(randomPieceToMoveAhead, randomEmptyFieldCoordinates);
        } else {
            System.out.println("Game OVER!");
        }
    }
}
/*creates list of all empty fields around a piece allowing to move ahead*/
public List<Rectangle> getFieldsToMoveAhead (Circle blackPiece, List<Circle> allPieces, List<Rectangle> allBronzeFields) {
        PieceMover pieceMover = new PieceMover();
        Integer[] blackPieceCoordinates = pieceMover.getCoordinates(blackPiece);
        List<Rectangle> fieldsToMoveAhead = new ArrayList<>();
        List<ArrayList<Integer>> twoAdjecentFieldsList = getUpperAdjecentFieldsCoordinates(blackPieceCoordinates);
        for(ArrayList<Integer> arrayList : twoAdjecentFieldsList) {
            if (!pieceMover.isPieceOnTheField(allPieces, arrayList.get(0), arrayList.get(1))) {
                Rectangle rectangle = pieceMover.getRectangle(allBronzeFields, arrayList.get(0), arrayList.get(1));
                fieldsToMoveAhead.add(rectangle);
        }
    }
        return fieldsToMoveAhead;
}
/*creates a set of all empty fields available for all pieces together*/
public Set<Rectangle> getAllFieldsToMoveAhead (List<Circle> blackPieces, List<Circle> allPieces, List<Rectangle> allBronzeFields) {
    Set<Rectangle> allFieldsToMoveAheadSet = new HashSet<>();

    for (Circle blackPiece : blackPieces) {
        List<Rectangle> fieldsToMoveAhead = getFieldsToMoveAhead(blackPiece, allPieces, allBronzeFields);
        System.out.println(blackPiece.getId() + " fieldsToMoveAhead " + fieldsToMoveAhead.size());
        for (Rectangle fieldToMoveAhead : fieldsToMoveAhead) {
            allFieldsToMoveAheadSet.add(fieldToMoveAhead);
        }
    }
    System.out.println("allFieldsToMoveAheadSet " + allFieldsToMoveAheadSet.size());
    return allFieldsToMoveAheadSet;
}

public Rectangle getRandomEmptyField (Set<Rectangle> allFieldsToMoveAhead) {
    Random numberGenerator = new Random();
    int fieldNumberInArray = numberGenerator.nextInt(allFieldsToMoveAhead.size());
    List<Rectangle> allFieldsToMoveAheadAsList = new ArrayList<>(allFieldsToMoveAhead);
    System.out.println("allFieldsToMoveAheadAsList " + allFieldsToMoveAheadAsList.size());
    Rectangle randomEmptyField = allFieldsToMoveAheadAsList.get(fieldNumberInArray);
    System.out.println("randomEmptyField " + randomEmptyField.getId());
    return randomEmptyField;
}

public List<Circle> getPiecesToMoveAhead (Rectangle randomEmptyField, List<Circle> blackPieces) {
    PieceMover pieceMover = new PieceMover();
    Integer[] randomEmptyFieldCoordinates = pieceMover.getCoordinates(randomEmptyField);
    List<Circle> piecesToMoveAhead = new ArrayList<>();
    List<ArrayList<Integer>> twoAdjecentFieldsList = getLowerAdjecentFieldsCoordinates(randomEmptyFieldCoordinates);
    System.out.println("twoAdjecentFieldsList " + twoAdjecentFieldsList.size());
    for(ArrayList<Integer> arrayList : twoAdjecentFieldsList) {
        if (pieceMover.isPieceOnTheField(blackPieces, arrayList.get(0), arrayList.get(1))) {
            Circle piece = pieceMover.getPiece(blackPieces, arrayList.get(0), arrayList.get(1));
            piecesToMoveAhead.add(piece);
        }
    }
    System.out.println("piecesToMoveAhead " + piecesToMoveAhead.size());
    return piecesToMoveAhead;
}

public Circle getRandomPieceToMoveAhead (List<Circle> piecesToMoveAhead) {
    Random numberGenerator = new Random();
    int fieldNumberInArray = numberGenerator.nextInt(piecesToMoveAhead.size());
    Circle randomPieceToMoveAhead = piecesToMoveAhead.get(fieldNumberInArray);
    return randomPieceToMoveAhead;
}


public Map.Entry<Circle, Circle> getPieceAndMoveToBeat (Map<Circle, Circle> movePieceToBeatMap, List<Circle> whitePieces){
    System.out.println("whitePieces " + whitePieces.size());
    System.out.println("movePieceToBeatMap " + movePieceToBeatMap.size());
    List<Circle> commonWhitePieces = new ArrayList<>();
    for (Circle whitePiece : whitePieces) {
        System.out.println("fx:id whitePiece " + whitePiece.getId());
        for (Map.Entry<Circle, Circle> pieceAndMoveToBeat : movePieceToBeatMap.entrySet()) {
            if (pieceAndMoveToBeat.getKey().getId().equals(whitePiece.getId())) {
                commonWhitePieces.add(whitePiece);
            }
        }
    }
    System.out.println("commonWhitePiece " + commonWhitePieces.size());
    Random numberGenerator = new Random();

        int pieceNumberInArray = numberGenerator.nextInt(commonWhitePieces.size());
    System.out.println("getPieceAndMoveToBeat random" + pieceNumberInArray);
        Circle clickedNode = commonWhitePieces.get(pieceNumberInArray);
        for (Map.Entry<Circle, Circle> pieceAndMoveToBeat : movePieceToBeatMap.entrySet()) {
            if ((pieceAndMoveToBeat.getKey().getId()).equals(clickedNode.getId())) {
                return pieceAndMoveToBeat;
            }
        }
    return null;
}

    public Map.Entry<Rectangle, Circle> getPieceAndMove (Map<Rectangle, Circle> movePieceAheadMap, List<Rectangle> allBronzeFields) {
    System.out.println("Liczność mapy ruchów pionków " + movePieceAheadMap.size());
    List<Rectangle> commonBronzeFields = new ArrayList<>();
        for (Rectangle bronzeField : allBronzeFields) {
            for (Map.Entry<Rectangle, Circle> pieceAndMove : movePieceAheadMap.entrySet()) {
                if ((pieceAndMove.getKey().getId()).equals(bronzeField.getId())) {
                    commonBronzeFields.add(bronzeField);
                }
            }
        }
        System.out.println("commonBronzeFields " + commonBronzeFields.size());
        Random numberGenerator = new Random();

        int pieceNumberInArray = numberGenerator.nextInt(commonBronzeFields.size());
        System.out.println("getPieceAndMove " + pieceNumberInArray);
        Rectangle chosenField = commonBronzeFields.get(pieceNumberInArray);
        for (Map.Entry<Rectangle, Circle> pieceAndMove : movePieceAheadMap.entrySet()) {
            if ((pieceAndMove.getKey().getId()).equals(chosenField.getId())) {
                return pieceAndMove;
            }
        }
        return null;
    }

public Map<Rectangle, Circle> movePieceAheadMapGenerator (List<Circle> blackPieces, List<Circle> allPieces, List<Rectangle> allBronzeFields) {
    PieceMover pieceMover = new PieceMover();
    Map<Rectangle, Circle> movePieceAheadMap = new HashMap<>();
    for (Circle piece : blackPieces) {

        Integer[] coordinates = pieceMover.getCoordinates(piece);
        List<ArrayList<Integer>> twoAdjecentFieldsList = getAdjecentFieldsCoordinates(coordinates, false);
        for(ArrayList<Integer> arrayList : twoAdjecentFieldsList) {

            if (!pieceMover.isPieceOnTheField(allPieces, arrayList.get(0), arrayList.get(1))) {
                Rectangle rectangle = pieceMover.getRectangle(allBronzeFields, arrayList.get(0), arrayList.get(1));
                movePieceAheadMap.put(rectangle, piece);
            }
        }
    }
    return movePieceAheadMap;
}

public Map<Circle, Circle> movePieceToBeatMapGenerator (List<Circle> blackPieces, List<Circle> whitePieces, List<Circle> allPieces) {
    PieceMover pieceMover = new PieceMover();
    Map<Circle, Circle> movePieceToBeatMap = new HashMap<>();
        for (Circle piece : blackPieces) {
            Integer[] coordinates = pieceMover.getCoordinates(piece);
            Map<ArrayList<Integer>, ArrayList<Integer>> fourCornerFieldsList = getFourCornerFieldsCoordinates(coordinates);
            System.out.println("fourCornerFieldsList " + fourCornerFieldsList.size());
            for (Map.Entry<ArrayList<Integer>, ArrayList<Integer>> arrayListCorner : fourCornerFieldsList.entrySet()) {
                if (pieceMover.isPieceOnTheField(whitePieces, arrayListCorner.getKey().get(0), arrayListCorner.getKey().get(1))) {
                    if (!pieceMover.isPieceOnTheField(allPieces, arrayListCorner.getValue().get(0), arrayListCorner.getValue().get(1))) {
                        Circle pieceToBeat = pieceMover.getPiece(whitePieces, arrayListCorner.getKey().get(0), arrayListCorner.getKey().get(1));
                        movePieceToBeatMap.put(pieceToBeat, piece);
                    }
                }
            }
        }
        return movePieceToBeatMap;
}

public List<ArrayList<Integer>> getAdjecentFieldsCoordinates (Integer[] pieceCoordinates, boolean isBeatingMove) {
     List<ArrayList<Integer>> list = new ArrayList<>();

    if (pieceCoordinates[0]+1 <=8 && pieceCoordinates[0]-1 >= 1 && pieceCoordinates[1]+1 <=8 && pieceCoordinates[1]-1 >= 1) {
        ArrayList<Integer> subList_RightUp = new ArrayList<>();
        subList_RightUp.add(pieceCoordinates[0] + 1);
        subList_RightUp.add(pieceCoordinates[1] - 1);
        ArrayList<Integer> subList_LeftUp = new ArrayList<>();
        subList_LeftUp.add(pieceCoordinates[0] - 1);
        subList_LeftUp.add(pieceCoordinates[1] - 1);
        list.add(subList_RightUp);
        list.add(subList_LeftUp);
        if (isBeatingMove) {
            ArrayList<Integer> subList_RightDown = new ArrayList<>();
            subList_RightDown.add(pieceCoordinates[0] + 1);
            subList_RightDown.add(pieceCoordinates[1] + 1);
            ArrayList<Integer> subList_LeftDown = new ArrayList<>();
            subList_LeftDown.add(pieceCoordinates[0] - 1);
            subList_LeftDown.add(pieceCoordinates[1] + 1);
            list.add(subList_RightDown);
            list.add(subList_LeftDown);
        }
    }
    return list;
}

    public List<ArrayList<Integer>> getUpperAdjecentFieldsCoordinates (Integer[] pieceCoordinates) {
        List<ArrayList<Integer>> list = new ArrayList<>();

        if (pieceCoordinates[0] + 1 <= 8 && pieceCoordinates[1] - 1 >= 1) {
                ArrayList<Integer> subList_RightUp = new ArrayList<>();
                subList_RightUp.add(pieceCoordinates[0] + 1);
                subList_RightUp.add(pieceCoordinates[1] - 1);
                list.add(subList_RightUp);
            }
        if (pieceCoordinates[0] - 1 >= 1 && pieceCoordinates[1] - 1 >= 1) {
            ArrayList<Integer> subList_LeftUp = new ArrayList<>();
            subList_LeftUp.add(pieceCoordinates[0] - 1);
            subList_LeftUp.add(pieceCoordinates[1] - 1);
            list.add(subList_LeftUp);
        }
        return list;
    }

    public List<ArrayList<Integer>> getLowerAdjecentFieldsCoordinates (Integer[] pieceCoordinates) {
        List<ArrayList<Integer>> list = new ArrayList<>();
        if (pieceCoordinates[0] + 1 <= 8 && pieceCoordinates[1] + 1 <= 8) {
            ArrayList<Integer> subList_RightDown = new ArrayList<>();
            subList_RightDown.add(pieceCoordinates[0] + 1);
            subList_RightDown.add(pieceCoordinates[1] + 1);
            list.add(subList_RightDown);
        }
        if (pieceCoordinates[1] + 1 <= 8 && pieceCoordinates[0] - 1 >= 1) {
            ArrayList<Integer> subList_LeftDown = new ArrayList<>();
            subList_LeftDown.add(pieceCoordinates[0] - 1);
            subList_LeftDown.add(pieceCoordinates[1] + 1);
            list.add(subList_LeftDown);
        }
        return list;
    }

public Map<ArrayList<Integer>, ArrayList<Integer>> getFourCornerFieldsCoordinates (Integer[] pieceCoordinates) {
    Map<ArrayList<Integer>, ArrayList<Integer>> map = new HashMap<>();
    if (pieceCoordinates[0]+2 <=8 && pieceCoordinates[1]-2 >= 1) {
        ArrayList<Integer> subList_RightUp = new ArrayList<>();
        subList_RightUp.add(pieceCoordinates[0] + 1);
        subList_RightUp.add(pieceCoordinates[1] - 1);
        ArrayList<Integer> subList_RightUpUp = new ArrayList<>();
        subList_RightUpUp.add(pieceCoordinates[0] + 2);
        subList_RightUpUp.add(pieceCoordinates[1] - 2);
        map.put(subList_RightUp, subList_RightUpUp);
    }
        if (pieceCoordinates[0]-2 >= 1 && pieceCoordinates[1]-2 >= 1) {
            ArrayList<Integer> subList_LeftUp = new ArrayList<>();
            subList_LeftUp.add(pieceCoordinates[0] - 1);
            subList_LeftUp.add(pieceCoordinates[1] - 1);
            ArrayList<Integer> subList_LeftUpUp = new ArrayList<>();
            subList_LeftUpUp.add(pieceCoordinates[0] - 2);
            subList_LeftUpUp.add(pieceCoordinates[1] - 2);
            map.put(subList_LeftUp, subList_LeftUpUp);
        }
        if (pieceCoordinates[0] + 2 <= 8 && pieceCoordinates[1] + 2 <= 8) {
            ArrayList<Integer> subList_RightDown = new ArrayList<>();
            subList_RightDown.add(pieceCoordinates[0] + 1);
            subList_RightDown.add(pieceCoordinates[1] + 1);
            ArrayList<Integer> subList_RightDownDown = new ArrayList<>();
            subList_RightDownDown.add(pieceCoordinates[0] + 2);
            subList_RightDownDown.add(pieceCoordinates[1] + 2);
            map.put(subList_RightDown, subList_RightDownDown);
        }
        if (pieceCoordinates[0] - 2 >= 8 && pieceCoordinates[1] + 2 <= 8) {
            ArrayList<Integer> subList_LeftDown = new ArrayList<>();
            subList_LeftDown.add(pieceCoordinates[0] - 1);
            subList_LeftDown.add(pieceCoordinates[1] + 1);
            ArrayList<Integer> subList_LeftDownDown = new ArrayList<>();
            subList_LeftDownDown.add(pieceCoordinates[0] - 2);
            subList_LeftDownDown.add(pieceCoordinates[1] + 2);
            map.put(subList_LeftDown, subList_LeftDownDown);
        }
    return map;
    }
}


