package com.jackyjjc.LD27;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * @author Junjie CHEN(jacky.jjchen@gmail.com)
 */
public class GamePlayScreen implements Screen {

    private static final long TICKS_PER_SEC = 5;
    private static final double MILLISEC_PER_TICK = 1000.0 / TICKS_PER_SEC;

    private static final double INPUT_MILLISEC_PER_TICK = 100;

    private Rogue rogue;
    private double timeDiff;
    private double timeAcc;
    private double inputTimeAcc;

    private GameStartController gameStartController;
    private TimerRenderer timerRenderer;
    private GameMapRenderer gameMapRenderer;

    private GamePlayInput input;
    private Timer timer;


    public GamePlayScreen(Rogue rogue, GameGraphics graphics) {

        this.rogue = rogue;

        this.timeDiff = 0;
        this.timeAcc = 0;
        this.inputTimeAcc = 0;
        this.timer = new Timer();
        rogue.setTimer(timer);

        this.gameMapRenderer = new GameMapRenderer(rogue.gameMap, graphics);
        this.timerRenderer = new TimerRenderer(graphics, timer);
        this.gameStartController = new GameStartController(rogue, graphics);
        this.input = new GamePlayInput(rogue.gameMap, this.gameMapRenderer);
    }

    @Override
    public void render(float delta) {

        if(!timer.start) {
            timer.start();
        }

        if(!rogue.finished && rogue.started) {
            timeAcc += delta * 1000 - timeDiff;
            inputTimeAcc += delta * 1000 - timeDiff;

            long startTime = System.currentTimeMillis();

            while(inputTimeAcc > INPUT_MILLISEC_PER_TICK) {
                input.tick();
                inputTimeAcc -= INPUT_MILLISEC_PER_TICK;
            }

            while(timeAcc > MILLISEC_PER_TICK) {
                rogue.tick();
                timeAcc -= MILLISEC_PER_TICK;
            }

            timer.tick();

            timeDiff = (System.currentTimeMillis() - startTime) / 1000.0;
        } else {
            this.gameStartController.tick();
        }

        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

        //render the game map
        this.gameMapRenderer.render();
        this.timerRenderer.render();
        this.gameStartController.render();

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
