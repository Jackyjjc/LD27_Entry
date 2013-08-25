/*
 * Copyright (C) 2013  Junjie CHEN
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; Version 2
 * of the License.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 */

package com.jackyjjc.LD27;

import com.badlogic.gdx.Game;
import com.jackyjjc.LD27.heroes.Hero;
import com.jackyjjc.LD27.items.Item;

/**
 * @author Junjie CHEN(jacky.jjchen@gmail.com)
 */
public class Rogue extends Game {

    private Controller controller;

    public GameMap gameMap;

    public Rogue(Controller controller) {
        this.controller = controller;
        this.gameMap = new GameMap();
    }

    @Override
    public void create() {

        this.gameMap.loadLevel(1);

        controller.initialize(this);
        setScreen(controller.getStartScreen());
    }

    public void tick() {

        //loop through all the heroes and see if there are any enemy in attack range
        for (Unit unit : gameMap.getAllUnits()) {
            unit.moved = false;
        }

        //loop through all the heroes and see if there are any enemy in attack range
        for (Hero hero : gameMap.getHeroes()) {
            searchAndAttack(hero);
        }

        //loop through all the enemies and see if there are any heroes in attack range
        for (Unit enemy : gameMap.getEnemies()) {
            searchAndAttack(enemy);
        }

        for (Unit unit : gameMap.getAllUnits()) {
            if(unit.hp <= 0) {
                gameMap.removeUnit(unit);
            }
        }
    }

    public void searchAndAttack(Unit unit) {
        if(!unit.moved) {
            Unit target = getTargetInRange(unit);
            if(target != null) {
                unit.attack(target);
                unit.moved = true;
                target.attack(unit);
                target.moved = true;
            }
        }
    }

    public Unit getTargetInRange(Unit unit) {

        boolean found = false;
        Unit target = null;

        int size = unit.range * 2 + 1;
        int startX = unit.x() - unit.range;
        int startY = unit.y() - unit.range;

        for(int y = startY; y < startY + size && !found; y++) {
            for(int x = startX; x < startX + size && !found; x++) {

                if(!gameMap.contains(x, y)) {
                    continue;
                }

                target = gameMap.getAt(x, y);
                if(target == null || target == unit) {
                    continue;
                }

                if(!(unit instanceof Hero && target instanceof Hero)
                   || (!(unit instanceof Hero) && !(target instanceof Hero))) {
                   found = true;
                }
            }
        }

        return target;
    }
}
