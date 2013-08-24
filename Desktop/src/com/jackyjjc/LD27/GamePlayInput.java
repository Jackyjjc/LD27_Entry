package com.jackyjjc.LD27;

/**
 * @author Junjie CHEN(jacky.jjchen@gmail.com)
 */
public class GamePlayInput {

    private GameMapRenderer mapRenderer;
    private HeroController heroController;

    public GamePlayInput(GameMap gameMap, GameMapRenderer mapRenderer) {
        this.mapRenderer = mapRenderer;
        this.heroController = new HeroController(gameMap);
    }

    public void tick() {
        heroController.tick();
    }
}
