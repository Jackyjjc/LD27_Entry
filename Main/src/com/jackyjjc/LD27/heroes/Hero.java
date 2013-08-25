package com.jackyjjc.LD27.heroes;

import com.jackyjjc.LD27.Unit;

/**
 * @author Junjie CHEN(jacky.jjchen@gmail.com)
 */
public class Hero extends Unit {

    public boolean male;
    public int type;

    public Hero(int type, boolean isMale) {
        this.type = type;
        this.male = isMale;
    }


}
