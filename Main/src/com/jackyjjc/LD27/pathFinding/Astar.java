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
import java.util.PriorityQueue;

/**
 * @author Junjie CHEN(jacky.jjchen@gmail.com)
 */
public class Astar {

    public static State pathSearch(int startX, int startY, int destX, int destY, GameMap map) {

        PriorityQueue<State> pq = new PriorityQueue<>();
        List<State> closedList = new LinkedList<>();

        int counter = 0;

        pq.add(new State(startX, startY, destX, destY, 0));
        while(!pq.isEmpty()) {

            counter++;

            //check if goal, if it is, return
            State cur = pq.poll();
            if((cur.x == destX && cur.y == destY) || counter > 100) {

                State backup = null;

                if (!pq.isEmpty()) {
                    backup = pq.poll();
                }

                if(cur != null && backup != null && backup.getCost() == cur.getCost()) {
                    cur = (Math.random() * 1000 > 500) ? backup : cur;
                }

                return cur;
            }

            closedList.add(cur);

            List<State> successors = cur.getSuccessorStates(map);
            for (State s : successors) {

                if(closedList.contains(s)) {
                    continue;
                }

                boolean found = false;
                State old = null;

                for (State state : pq) {
                    if(state.equals(s)) {
                        found = true;
                        old = state;
                        break;
                    }
                }

                if(!found) {
                    pq.add(s);
                } else {
                    if(old.getCost() > s.getCost()) {
                        pq.remove(old);
                        pq.add(s);
                    }
                }
            }
        }

        return null;
    }

}
