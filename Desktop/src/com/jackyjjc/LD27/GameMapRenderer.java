package com.jackyjjc.LD27;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

/**
 * @author Junjie CHEN(jacky.jjchen@gmail.com)
 */
public class GameMapRenderer {

    private static final int NUM_COLS = 33;
    private static final int NUM_ROWS = 16;
    private static final int SIZE = 24;

    private ShapeRenderer debugRenderer;

    private Vector2 curPos;
    private GameMap gameMap;

    public GameMapRenderer(GameMap gameMap, ShapeRenderer debugRenderer) {

        this.debugRenderer = debugRenderer;
        this.gameMap = gameMap;
        this.curPos = new Vector2(0,0);
    }

    public void render() {

        debugRenderer.begin(ShapeRenderer.ShapeType.Rectangle);
        for(int row = 0; row < NUM_ROWS; row++) {
            for(int col = 0; col < NUM_COLS; col++) {

                int tile = gameMap.getData(col, row);

                if(tile == 0) {
                    debugRenderer.setColor(new Color(1, 0, 0, 1));
                } else {
                    debugRenderer.setColor(new Color(0, 1, 0, 1));
                }

                debugRenderer.rect(5 + col * SIZE, 384 - (row * SIZE), SIZE, SIZE);
            }
        }
        debugRenderer.end();
    }
}
