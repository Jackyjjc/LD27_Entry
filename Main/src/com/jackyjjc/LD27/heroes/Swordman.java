package com.jackyjjc.LD27.heroes;

/**
 * @author Junjie CHEN(jacky.jjchen@gmail.com)
 */
public class Swordman extends Hero {

    public Swordman(boolean isMale) {
        super(1, isMale);
        this.maxHp = 200;
        this.hp = 200;
        this.atk = 10;
        this.def = 1;
        this.range = 1;
        this.moveSpeed = 1;
    }
}
