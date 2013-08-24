package com.jackyjjc.LD27;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * @author Junjie CHEN(jacky.jjchen@gmail.com)
 */
public class DesktopController implements Controller {

    private Screen startScreen;

    @Override
    public void initialize(Rogue rogue) {
        this.startScreen = new GamePlayScreen(rogue,
                                              new BitmapFont(),
                                              new SpriteBatch());
    }

    @Override
    public Screen getStartScreen() {
        return startScreen;
    }
}
