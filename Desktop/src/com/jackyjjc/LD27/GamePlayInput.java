package com.jackyjjc.LD27;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

/**
 * @author Junjie CHEN(jacky.jjchen@gmail.com)
 */
public class GamePlayInput {

    private GameMapRenderer mapRenderer;

    public GamePlayInput(GameMapRenderer mapRenderer) {
        this.mapRenderer = mapRenderer;
    }

    public void tick() {

        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) mapRenderer.panHorizontal(1);
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) mapRenderer.panHorizontal(-1);
    }
}
