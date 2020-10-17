import java.awt.*;
import java.util.HashMap;

public class GridPoints extends Grid implements IGrid {
    private final int length;
    private final int depth;
    private HashMap<Point, Boolean> grid;

    public GridPoints(int length, int depth) {
        this.length = length;
        this.depth = depth;
        createGrid();
    }

    private void createGrid() {
        grid = new HashMap<>();
        for (int i = 0; i < depth; i++) {
            for (int j = 0; j < length; j++) {
                grid.put(new Point(j, i), false);
            }
        }
    }

    @Override
    public void changeValue(Point position) {
        if (getGrid().get(position).equals(false)) {
            getGrid().replace(position, true);
        } else {
            getGrid().replace(position, false);
        }


    }

    @Override
    public boolean getValue(Point position) {
        return getGrid().get(position);
    }

    @Override
    public HashMap<Point, Boolean> getGrid() {
        return grid;
    }





}
