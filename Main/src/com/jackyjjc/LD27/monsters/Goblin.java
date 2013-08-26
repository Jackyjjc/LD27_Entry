package com.jackyjjc.LD27.monsters;

import com.jackyjjc.LD27.Unit;

/**
 * @author Junjie CHEN(jacky.jjchen@gmail.com)
 */
public class Goblin extends Unit {

    public Goblin() {
        this.maxHp = 30;
        this.hp = maxHp;
        this.atk = 5;
        this.def = 0;
        this.range = 1;
        this.moveSpeed = 1;
    }
}
