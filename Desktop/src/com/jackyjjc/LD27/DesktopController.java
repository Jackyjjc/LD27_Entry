package com.jackyjjc.LD27;

import com.badlogic.gdx.Screen;

/**
 * @author Junjie CHEN(jacky.jjchen@gmail.com)
 */
public class DesktopController implements Controller {

    public enum Screens {

        LOAD(0),
        PLAY(1);

        private int id;

        private Screens(int id) {
            this.id = id;
        }
    }

    private Rogue rogue;
    private Screen[] screens;
    private GameGraphics graphics;

    @Override
    public void initialize(Rogue rogue) {

        this.rogue = rogue;
        this.graphics = new GameGraphics();

        this.screens = new Screen[Screens.values().length];
        this.screens[Screens.LOAD.id] = new LoadScreen(this, graphics);
        this.screens[Screens.PLAY.id] = new GamePlayScreen(rogue, graphics);
    }

    @Override
    public Screen getStartScreen() {
        return this.screens[0];
    }

    public void setScreen(Screens screen) {
        rogue.setScreen(screens[screen.id]);
    }
}
