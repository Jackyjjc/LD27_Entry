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

    }
}
