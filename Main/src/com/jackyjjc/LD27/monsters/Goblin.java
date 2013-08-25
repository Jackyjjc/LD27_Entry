package com.jackyjjc.LD27.monsters;

import com.jackyjjc.LD27.Unit;

/**
 * @author Junjie CHEN(jacky.jjchen@gmail.com)
 */
public class Goblin extends Unit {

    public Goblin() {
        this.maxHp = 50;
        this.hp = maxHp;
        this.atk = 3;
        this.def = 0;
        this.range = 1;
        this.moveSpeed = 1;
    }
}
