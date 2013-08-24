package com.jackyjjc.LD27;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.jackyjjc.LD27.heroes.Hero;

import java.util.List;

/**
 * @author Junjie CHEN(jacky.jjchen@gmail.com)
 */
public class HeroController {

    private GameMap gameMap;

    public HeroController(GameMap gameMap) {
        this.gameMap = gameMap;
    }

    public void tick() {

        int dx = 0;
        int dy = 0;

        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            dx = 1;
        } else if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            dx = -1;
        } else if(Gdx.input.isKeyPressed(Input.Keys.UP)) {
            dy = -1;
        } else if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            dy = 1;
        }

        List<Hero> heroList = gameMap.getHeroes();
        for(Hero hero : heroList) {
            if(canMove(hero, dx, dy)) {
                gameMap.moveUnitTo(hero, hero.x() + dx, hero.y() + dy);
            }
        }
    }

    public boolean canMove(Hero hero, int dx, int dy) {

        int newX = hero.x() + dx;
        int newY = hero.y() + dy;

        //filter out the ones that is not in the valid range
        if(!gameMap.contains(newX, newY)) {
            return false;
        }

        //check if there is already unit there
        if(gameMap.getAt(newX, newY) != null) {
            return false;
        }

        //check if tile walkable
        if(!gameMap.walkable(newX, newY)) {
            return false;
        }

        return true;
    }
}
