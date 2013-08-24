package com.jackyjjc.LD27;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.tiled.TiledLoader;
import com.badlogic.gdx.graphics.g2d.tiled.TiledMap;
import com.badlogic.gdx.math.Vector2;
import com.jackyjjc.LD27.characters.Hero;
import com.jackyjjc.LD27.characters.Swordman;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Junjie CHEN(jacky.jjchen@gmail.com)
 */
public class GameMap {

    private TiledMap map;
    private int[][] mapData;
    private List<Hero> heroes;

    public GameMap() {
        heroes = new ArrayList<Hero>();
        heroes.add(new Swordman(true));
    }

    public int width() {
        assert map != null;
        return map.width;
    }

    public List<Hero> getHeroes() {
        return heroes;
    }

    public int getData(int col, int row) {

        assert col >= 0 && col < map.width;
        assert row >= 0 && row < map.height;

        return mapData[row][col];
    }

    public void loadLevel(int level) {
        this.map = TiledLoader.createMap(Gdx.files.internal("Main/assets/level" + level + ".tmx"));
        this.mapData = map.layers.get(0).tiles;
        this.heroes.get(0).setPos(new Vector2(5,5));
    }
}
