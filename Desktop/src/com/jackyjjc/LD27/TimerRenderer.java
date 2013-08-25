/*
 * Copyright (C) 2013  Junjie CHEN
 *
 * This program is free software; you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation; Version 2 of the License.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details.
 */

package com.jackyjjc.LD27;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.HashMap;

/**
 * @author Junjie CHEN(jacky.jjchen@gmail.com)
 */
public class TimerRenderer {

    private GameGraphics graphics;
    private Timer timer;

    public TimerRenderer(GameGraphics graphics, Timer timer) {
        this.graphics = graphics;
        this.timer = timer;
    }

    public void render() {

        String text = String.valueOf(timer.time);

        int textLen = text.length();

        TextureRegion[][] textTexture = TextureRegion.split(graphics.assetManager.get("Desktop/assets/font.png", Texture.class), 24, 24);
        graphics.spriteBatch.begin();
        graphics.spriteBatch.draw(textTexture[3][15], 10, 417);
        graphics.spriteBatch.draw(textTexture[3][4 + (textLen - 4 >= 0 ? (text.charAt(textLen - 4) - '0') : 0)], 44, 416);
        graphics.spriteBatch.draw(textTexture[3][14], 68, 416);
        graphics.spriteBatch.draw(textTexture[3][4 + (textLen - 3 >= 0 ? (text.charAt(textLen - 3) - '0') : 0)], 92, 416);
        graphics.spriteBatch.draw(textTexture[3][4 + (textLen - 2 >= 0 ? (text.charAt(textLen - 2) - '0') : 0)], 116, 416);
        graphics.spriteBatch.draw(textTexture[3][4 + (textLen - 1 >= 0 ? (text.charAt(textLen - 1) - '0') : 0)], 140, 416);
        graphics.spriteBatch.end();
    }
}
