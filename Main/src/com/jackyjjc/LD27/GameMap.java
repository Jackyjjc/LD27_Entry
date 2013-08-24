package com.jackyjjc.LD27;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.tiled.TiledLoader;
import com.badlogic.gdx.graphics.g2d.tiled.TiledMap;
import com.badlogic.gdx.math.Vector2;
import com.jackyjjc.LD27.heroes.Hero;
import com.jackyjjc.LD27.heroes.Swordman;
import com.jackyjjc.LD27.monsters.Goblin;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Junjie CHEN(jacky.jjchen@gmail.com)
 */
public class GameMap {

    private TiledMap map;
    private int[][] mapData;
    private Unit[][] mapUnits;

    private List<Hero> heroes;
    private List<Unit> enemies;

    public GameMap() {
        heroes = new ArrayList<Hero>();
        heroes.add(new Swordman(true));

        enemies = new ArrayList<Unit>();
        enemies.add(new Goblin());
    }

    public int width() {
        assert map != null;
        return map.width;
    }

    public List<Unit> getAllUnits() {
        List<Unit> list = new ArrayList<>(heroes.size() + enemies.size());
        list.addAll(heroes);
        list.addAll(enemies);
        return list;
    }

    public void removeUnit(Unit unit) {
        mapUnits[unit.y()][unit.x()] = null;
        if(heroes.contains(unit)) {
            heroes.remove(unit);
        }

        if(enemies.contains(unit)) {
            enemies.remove(unit);
        }
    }

    public List<Hero> getHeroes() {
        return heroes;
    }

    public List<Unit> getEnemies() {
        return enemies;
    }

    public Unit getAt(int col, int row) {
        assert contains(col, row);
        return mapUnits[row][col];
    }

    public int getData(int col, int row) {
        assert contains(col, row);
        return mapData[row][col];
    }

    public boolean walkable(int col, int row) {
        assert contains(col, row);
        return mapData[row][col] == 3;
    }

    public boolean contains(int col, int row) {
        return col >= 0 && col < map.width && row >= 0 && row < map.height;
    }

    public void moveUnitTo(Unit unit, int col, int row) {
        this.mapUnits[unit.y()][unit.x()] = null;
        unit.setPos(col, row);
        this.mapUnits[row][col] = unit;

    }

    public void loadLevel(int level) {

        this.map = TiledLoader.createMap(Gdx.files.internal("Main/assets/level" + level + ".tmx"));
        this.mapData = map.layers.get(0).tiles;
        this.mapUnits = new Unit[mapData.length][mapData[0].length];

        //set the init pos of the hero
        this.heroes.get(0).setPos(5, 5);
        this.mapUnits[5][5] = heroes.get(0);

        //set the init pos of the enemy
        this.enemies.get(0).setPos(7, 7);
        this.mapUnits[7][7] = enemies.get(0);
    }
}
