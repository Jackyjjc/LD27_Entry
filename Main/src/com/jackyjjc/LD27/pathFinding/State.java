/*
 * Copyright (C) 2013  Junjie CHEN
 *
 * This program is free software; you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation; Version 2 of the License.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details.
 */

package com.jackyjjc.LD27.pathFinding;

import com.jackyjjc.LD27.GameMap;
import com.jackyjjc.LD27.Unit;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Junjie CHEN(jacky.jjchen@gmail.com)
 */
public class State implements Comparable<State> {

    public int x;
    public int y;
    public int dx;
    public int dy;
    private int destX;
    private int destY;
    private int gcost;

    public State(int x, int y, int destX, int destY, int gcost) {
        this.x = x;
        this.y = y;
        this.dx = 0;
        this.dy = 0;
        this.destX = destX;
        this.destY = destY;
        this.gcost = gcost;
    }

    public List<State> getSuccessorStates(GameMap map) {

        List<State> states = new LinkedList<>();

        int[][] possibleSteps = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < possibleSteps.length; i++) {
            int dx = possibleSteps[i][0];
            int dy = possibleSteps[i][1];
            if(map.canMoveTo(this.x + dx, this.y + dy)
               || (this.x + dx == destX && this.y + dy == destY)) {

                State newState = new State(this.x + dx, this.y + dy,
                                            this.destX, this.destY,
                                            this.gcost + 1);

                if(this.dx == 0 && this.dy == 0) {
                    newState.dx = dx;
                    newState.dy = dy;
                } else {
                    newState.dx = this.dx;
                    newState.dy = this.dy;
                }

                states.add(newState);
            }
        }

        return states;
    }

    public int getCost() {
        return Math.abs(destX - x) + Math.abs(destY - y) + gcost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof State)) return false;

        State state = (State) o;

        if (x != state.x) return false;
        if (y != state.y) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (x << 16) ^ y;
    }

    @Override
    public int compareTo(State o) {
        if(this.equals(o)) {
            return 0;
        } else if(o == null) {
            return 1;
        } else {
            return this.getCost() - o.getCost();
        }
    }
}
