/*
 * Copyright (C) 2013  Junjie CHEN
 *
 * This program is free software; you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation; Version 2 of the License.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details.
 */

package com.jackyjjc.LD27.items;

import com.jackyjjc.LD27.Unit;

/**
 * @author Junjie CHEN(jacky.jjchen@gmail.com)
 */
public class SmallHeart extends Item {

    public SmallHeart() {
        super(0);
    }

    @Override
    public void interact(Unit unit) {
        unit.hp = Math.min(unit.hp + 20, unit.maxHp);
    }
}
