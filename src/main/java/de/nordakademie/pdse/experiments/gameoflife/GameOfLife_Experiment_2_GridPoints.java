package de.nordakademie.pdse.experiments.gameoflife;

import de.nordakademie.pdse.config.ConfigReader;
import de.nordakademie.pdse.gamelogic.Game;
import de.nordakademie.pdse.grid.IGrid;

import java.awt.*;
import java.io.File;

/**
 * @author Georg Mezlaw, Rane Petersen
 */
public class GameOfLife_Experiment_2_GridPoints {

    private static Point createPoint(int x, int y) {
        return new Point(x, y);
    }

    public static void main(String[] args) throws Exception {
        ConfigReader configReader = new ConfigReader(new File("src/main/resources/config.properties"));
        configReader.setGridLength("100");
        configReader.setGridWidth("100");
        configReader.setModel("Moore");
        configReader.setGameType("GameOfLife");
        configReader.setTerminationType("ttl");
        configReader.setTimeToLive("100");
        configReader.setLoggingType("file");
        configReader.setDatastructure("GridPoint");
        Game game = new Game(configReader,"GameOfLife_Experiment_2_GridPoints");
        IGrid grid = game.getGird();
        for (int length = 0; length < configReader.getGridLength(); length++) {
            for (int width = 0; width < configReader.getGridWidth(); width++) {
                if (width % 2 == 0) {
                    if ((length % 2 == 1)) {
                        grid.setValue(createPoint(length, width), false);
                    } else {
                        grid.setValue(createPoint(length, width), true);
                    }
                } else {
                    if ((length % 2 == 1)) {
                        grid.setValue(createPoint(length, width), true);
                    } else {
                        grid.setValue(createPoint(length, width), false);
                    }
                }
            }
        }
        game.setGrid(grid);
        game.run();
    }
}