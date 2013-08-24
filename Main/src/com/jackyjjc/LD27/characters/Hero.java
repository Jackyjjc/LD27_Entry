package com.jackyjjc.LD27.characters;

import com.badlogic.gdx.math.Vector2;

/**
 * @author Junjie CHEN(jacky.jjchen@gmail.com)
 */
public class Hero {

    public boolean male;
    public int type;

    private Vector2 pos;

    public int atk;
    public int def;
    public int range;
    public int hp;

    public Hero(int type, boolean isMale) {
        this.type = type;
        this.male = isMale;
    }

    public void setPos(Vector2 pos) {
        this.pos = pos;
    }

    public Vector2 getPos() {
        return new Vector2(pos);
    }
}
