import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComputerPlayerAvailableFieldsSetGenerator {

    private Integer col;
    private Integer row;

    public List<ArrayList<Integer>> getUpperAdjacentFieldsCoordinates (Integer[] pieceCoordinates) {
        col = pieceCoordinates[0];
        row = pieceCoordinates[1];

        List<ArrayList<Integer>> list = new ArrayList<>();

        if (col + 1 <= 8 && row - 1 >= 1) {
            ArrayList<Integer> subList_RightUp = new ArrayList<>();
            subList_RightUp.add(col + 1);
            subList_RightUp.add(row - 1);
            list.add(subList_RightUp);
        }
        if (col - 1 >= 1 && row - 1 >= 1) {
            ArrayList<Integer> subList_LeftUp = new ArrayList<>();
            subList_LeftUp.add(col- 1);
            subList_LeftUp.add(row - 1);
            list.add(subList_LeftUp);
        }
        return list;
    }

    public List<ArrayList<Integer>> getLowerAdjacentFieldsCoordinates (Integer[] pieceCoordinates) {
        col = pieceCoordinates[0];
        row = pieceCoordinates[1];

        List<ArrayList<Integer>> list = new ArrayList<>();
        if (col + 1 <= 8 && row + 1 <= 8) {
            ArrayList<Integer> subList_RightDown = new ArrayList<>();
            subList_RightDown.add(col + 1);
            subList_RightDown.add(row + 1);
            list.add(subList_RightDown);
        }
        if (row + 1 <= 8 && col - 1 >= 1) {
            ArrayList<Integer> subList_LeftDown = new ArrayList<>();
            subList_LeftDown.add(col - 1);
            subList_LeftDown.add(row + 1);
            list.add(subList_LeftDown);
        }
        return list;
    }

    public Map<ArrayList<Integer>, ArrayList<Integer>> getAdjacentToAdjacentFieldsCoordinates (Integer[] pieceCoordinates) {
        col = pieceCoordinates[0];
        row = pieceCoordinates[1];

        Map<ArrayList<Integer>, ArrayList<Integer>> map = new HashMap<>();
        if (col+2 <=8 && row-2 >= 1) {
            ArrayList<Integer> subList_RightUp = new ArrayList<>();
            subList_RightUp.add(col + 1);
            subList_RightUp.add(row - 1);
            ArrayList<Integer> subList_RightUpUp = new ArrayList<>();
            subList_RightUpUp.add(col + 2);
            subList_RightUpUp.add(row - 2);
            map.put(subList_RightUp, subList_RightUpUp);
        }
        if (col-2 >= 1 && row-2 >= 1) {
            ArrayList<Integer> subList_LeftUp = new ArrayList<>();
            subList_LeftUp.add(col - 1);
            subList_LeftUp.add(row - 1);
            ArrayList<Integer> subList_LeftUpUp = new ArrayList<>();
            subList_LeftUpUp.add(col - 2);
            subList_LeftUpUp.add(row - 2);
            map.put(subList_LeftUp, subList_LeftUpUp);
        }
        if (col + 2 <= 8 && row + 2 <= 8) {
            ArrayList<Integer> subList_RightDown = new ArrayList<>();
            subList_RightDown.add(col + 1);
            subList_RightDown.add(row + 1);
            ArrayList<Integer> subList_RightDownDown = new ArrayList<>();
            subList_RightDownDown.add(col + 2);
            subList_RightDownDown.add(row + 2);
            map.put(subList_RightDown, subList_RightDownDown);
        }
        if (col - 2 >= 1 && row + 2 <= 8) {
            ArrayList<Integer> subList_LeftDown = new ArrayList<>();
            subList_LeftDown.add(col - 1);
            subList_LeftDown.add(row + 1);
            ArrayList<Integer> subList_LeftDownDown = new ArrayList<>();
            subList_LeftDownDown.add(col - 2);
            subList_LeftDownDown.add(row + 2);
            map.put(subList_LeftDown, subList_LeftDownDown);
        }
        return map;
    }
}
