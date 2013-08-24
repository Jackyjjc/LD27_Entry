package com.jackyjjc.LD27;

/**
 * @author Junjie CHEN(jacky.jjchen@gmail.com)
 */
public class GameMap {

    private int[][] mapData;

    public GameMap() {

        this.mapData = new int[16][60];

        for (int row = 0; row < 16; row++) {
            for(int col = 0; col < 60; col++) {
                this.mapData[row][col] = 1;
            }
        }

        for (int col = 0; col < 60; col++) {
            this.mapData[0][col] = 0;
            this.mapData[15][col] = 0;
        }
    }

    public int getData(int col, int row) {

        assert col >= 0 && col < this.mapData[0].length;
        assert row >= 0 && row < this.mapData.length;

        return mapData[row][col];
    }
}
