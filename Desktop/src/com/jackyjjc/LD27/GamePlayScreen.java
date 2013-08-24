package com.jackyjjc.LD27;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * @author Junjie CHEN(jacky.jjchen@gmail.com)
 */
public class GamePlayScreen implements Screen {

    private static final long TICKS_PER_SEC = 10;
    private static final double MILLISEC_PER_TICK = 1000.0 / TICKS_PER_SEC;

    private Rogue rogue;
    private double timeDiff;
    private double timeAcc;

    private GameMapRenderer gameMapRenderer;

    private GamePlayInput input;

    public GamePlayScreen(Rogue rogue, GameGraphics graphics) {

        this.rogue = rogue;

        this.timeDiff = 0;
        this.timeAcc = 0;

        this.gameMapRenderer = new GameMapRenderer(rogue.gameMap, graphics);
        this.input = new GamePlayInput(rogue.gameMap, this.gameMapRenderer);
    }

    @Override
    public void render(float delta) {

        timeAcc += delta * 1000 - timeDiff;

        long startTime = System.currentTimeMillis();

        while(timeAcc > MILLISEC_PER_TICK) {
            input.tick();
            rogue.tick();
            timeAcc -= MILLISEC_PER_TICK;
        }

        timeDiff = (System.currentTimeMillis() - startTime) / 1000.0;

        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

        //render the game map
        this.gameMapRenderer.render();
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void show() {

    }

    @Override
    public void hide() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
    }
}
