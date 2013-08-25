package com.jackyjjc.LD27;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.tiled.TiledLoader;
import com.badlogic.gdx.graphics.g2d.tiled.TiledMap;
import com.jackyjjc.LD27.heroes.Hero;
import com.jackyjjc.LD27.heroes.Swordman;
import com.jackyjjc.LD27.items.BigHeart;
import com.jackyjjc.LD27.items.Item;
import com.jackyjjc.LD27.monsters.Goblin;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Junjie CHEN(jacky.jjchen@gmail.com)
 */
public class GameMap {

    private TiledMap map;
    private int[][] mapData;
    private Unit[][] mapUnits;
    private Item[][] mapItems;

    private List<Hero> heroes;
    private List<Unit> enemies;
    private List<Item> items;

    public GameMap() {

        heroes = new ArrayList<>();
        enemies = new ArrayList<>();
        items = new ArrayList<>();

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

    public void addItem(Item item, int x, int y) {
        item.setPos(x, y);
        mapItems[item.y()][item.x()] = item;
        items.add(item);
    }

    public void removeItem(Item item) {
        mapUnits[item.y()][item.x()] = null;
        items.remove(item);
    }

    public void addUnit(Unit unit, int x, int y) {
        unit.setPos(x, y);
        mapUnits[unit.y()][unit.x()] = unit;
        if(unit instanceof Hero) {
            heroes.add((Hero) unit);
        } else {
            enemies.add(unit);
        }
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

    public Item[] getItems() {
        Item[] itemArray = items.toArray(new Item[items.size()]);
        return itemArray;
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

        Item item = mapItems[row][col];
        if(item != null) {
            item.interact(unit);
            removeItem(item);
        }
    }

    public void loadLevel(int level) {

        this.map = TiledLoader.createMap(Gdx.files.internal("Main/assets/level" + level + ".tmx"));
        this.mapData = map.layers.get(0).tiles;
        this.mapUnits = new Unit[mapData.length][mapData[0].length];
        this.mapItems = new Item[mapData.length][mapData[0].length];

        //set the init pos of the hero
        addUnit(new Swordman(false), 5, 5);
        addUnit(new Goblin(), 7, 7);
        addUnit(new Goblin(), 10, 10);
        addUnit(new Goblin(), 2, 2);
        addItem(new BigHeart(), 7, 4);
    }
}
