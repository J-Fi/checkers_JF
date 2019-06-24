package shared;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;

public class NodeCoordinatesFinder {
    public Integer[] getCoordinates(Node n) {
        Integer x = GridPane.getColumnIndex(n);
        Integer y = GridPane.getRowIndex(n);
        Integer[] coordinates = {x,y};
        return coordinates;
    }
}
