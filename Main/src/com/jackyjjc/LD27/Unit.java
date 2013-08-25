package com.jackyjjc.LD27;

/**
 * @author Junjie CHEN(jacky.jjchen@gmail.com)
 */
public class Unit {

    private int x;
    private int y;

    public int atk;
    public int def;
    public int range;
    public int moveSpeed;
    public int maxHp;
    public int hp;

    public boolean moved;

    public void setPos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int x() {
        return this.x;
    }

    public int y() {
        return this.y;
    }

    public void attack(Unit other) {
        int damage = (int) Math.max(0, (this.atk - other.def) * (Math.random() * 1000.0 - 200.0) / 400);
        other.hp = Math.max(0, other.hp - damage);
    }
}
