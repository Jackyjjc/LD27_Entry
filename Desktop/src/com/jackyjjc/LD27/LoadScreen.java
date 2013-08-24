package com.jackyjjc.LD27;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

/**
 * @author Junjie CHEN(jacky.jjchen@gmail.com)
 */
public class LoadScreen implements Screen {

    private static final String TEXT = "Loading...";

    private DesktopController controller;
    private GameGraphics graphics;

    public LoadScreen(DesktopController controller, GameGraphics graphics) {
        this.controller = controller;
        this.graphics = graphics;
    }

    @Override
    public void render(float delta) {

        boolean finished = graphics.assetManager.update();

        if(finished) {
            controller.setScreen(DesktopController.Screens.PLAY);
        } else {
            graphics.spriteBatch.begin();

            BitmapFont.TextBounds textBounds = graphics.font.getBounds(TEXT);
            graphics.font.draw(graphics.spriteBatch, "Loading...", (Gdx.graphics.getWidth() - textBounds.width) / 2,
                    (Gdx.graphics.getHeight() + textBounds.height) / 2);

            float percentage = graphics.assetManager.getProgress() * 100;
            String percentageStr = String.valueOf((int) percentage) + "%";
            BitmapFont.TextBounds progressBounds = graphics.font.getBounds(percentageStr);
            graphics.font.draw(graphics.spriteBatch, String.valueOf(percentageStr), (Gdx.graphics.getWidth() - progressBounds.width) / 2,
                    (Gdx.graphics.getHeight() + progressBounds.height) / 2 - textBounds.height - 10);

            graphics.spriteBatch.end();
        }
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
