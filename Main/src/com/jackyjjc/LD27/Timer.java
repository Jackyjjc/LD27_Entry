/*
 * Copyright (C) 2013  Junjie CHEN
 *
 * This program is free software; you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation; Version 2 of the License.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details.
 */

package com.jackyjjc.LD27;

/**
 * @author Junjie CHEN(jacky.jjchen@gmail.com)
 */
public class Timer {

    public boolean start;
    public boolean finished;
    private long startTime;
    public long time;

    public Timer() {
        this.start = false;
        finished = false;
        time = 0;
    }

    public void start() {
        start = true;
        finished = false;
        startTime = System.currentTimeMillis();
    }

    public void tick() {
        if(start && !finished) {
            long timePassed = System.currentTimeMillis() - startTime;
            time = Math.max(0, 10000 - timePassed);
            if(time == 0) {
                finished = true;
            }
        }
    }

    public void reset() {
        this.start = false;
        this.finished = false;
        this.time = 10000;
    }
}
