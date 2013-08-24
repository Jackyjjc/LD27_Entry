/*
 * Copyright (C) 2013  Junjie CHEN
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; Version 2
 * of the License.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 */

package com.jackyjjc.LD27;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

/**
 * @author Junjie CHEN(jacky.jjchen@gmail.com)
 */
public class DesktopStarter {

    public static void main(String[] args) {
        LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
        cfg.title = "LD27";
        cfg.useGL20 = true;
        cfg.width = 800;
        cfg.height = 448;
        cfg.vSyncEnabled = false;
        cfg.resizable = false;

        DesktopController controller = new DesktopController();
        Rogue rogue = new Rogue(controller);

        new LwjglApplication(rogue, cfg);
    }
}
