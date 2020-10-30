package de.nordakademie.pdse.gamelogic;

import de.nordakademie.pdse.config.ConfigReader;
import de.nordakademie.pdse.grid.GridFactory;
import de.nordakademie.pdse.grid.IGrid;
import org.junit.Test;
import org.mockito.Mock;

import java.awt.*;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Rane Petersen, Fabian Forthmann
 */

public class GameOfLifeTestOneByOneGrid {

    GridFactory gridFactory = new GridFactory(1, 1, "GridArray");
    IGrid grid = gridFactory.getGrid();
    Point point = new Point(0, 0);

    @Mock
    ConfigReader configReader = mock(ConfigReader.class);

    @Test
    public void oneByOneGridWithFalseValueMoore() throws Exception {
        grid.setValue(point, false);
        when(configReader.getGridLength()).thenReturn(1);
        when(configReader.getGridWidth()).thenReturn(1);
        when(configReader.getModel()).thenReturn("Moore");

        GameOfLife gameOfLife = new GameOfLife(configReader);
        assertFalse(gameOfLife.step(grid).getValue(point));
    }

    @Test
    public void oneByOneGridWithTrueValueMoore() throws Exception {
        grid.setValue(point, true);
        when(configReader.getGridLength()).thenReturn(1);
        when(configReader.getGridWidth()).thenReturn(1);
        when(configReader.getModel()).thenReturn("Moore");

        GameOfLife gameOfLife = new GameOfLife(configReader);
        assertFalse(gameOfLife.step(grid).getValue(point));
    }

    @Test
    public void oneByOneGridWithFalseValueVonNeumann() throws Exception {
        grid.setValue(point, false);
        when(configReader.getGridLength()).thenReturn(1);
        when(configReader.getGridWidth()).thenReturn(1);
        when(configReader.getModel()).thenReturn("vonNeumann");

        GameOfLife gameOfLife = new GameOfLife(configReader);
        assertFalse(gameOfLife.step(grid).getValue(point));
    }

    @Test
    public void oneByOneGridWithTrueValueVonNeumann() throws Exception {
        grid.setValue(point, true);
        when(configReader.getGridLength()).thenReturn(1);
        when(configReader.getGridWidth()).thenReturn(1);
        when(configReader.getModel()).thenReturn("vonNeumann");

        GameOfLife gameOfLife = new GameOfLife(configReader);
        assertFalse(gameOfLife.step(grid).getValue(point));
    }

    @Test(expected = IllegalArgumentException.class)
    public void oneByOneGridWithFalseValueInvalidModel() throws Exception {
        grid.setValue(point, false);
        when(configReader.getGridLength()).thenReturn(1);
        when(configReader.getGridWidth()).thenReturn(1);
        when(configReader.getModel()).thenReturn("");

        GameOfLife gameOfLife = new GameOfLife(configReader);
        gameOfLife.step(grid);
    }

    @Test(expected = IllegalArgumentException.class)
    public void oneByOneGridWithTrueValueInvalidModel() throws Exception {
        grid.setValue(point, true);
        when(configReader.getGridLength()).thenReturn(1);
        when(configReader.getGridWidth()).thenReturn(1);
        when(configReader.getModel()).thenReturn("");

        GameOfLife gameOfLife = new GameOfLife(configReader);
        gameOfLife.step(grid);
    }
}
