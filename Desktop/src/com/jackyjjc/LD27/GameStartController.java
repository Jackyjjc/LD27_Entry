/*
 * Copyright (C) 2013  Junjie CHEN
 *
 * This program is free software; you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation; Version 2 of the License.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details.
 */

package com.jackyjjc.LD27;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;

/**
 * @author Junjie CHEN(jacky.jjchen@gmail.com)
 */
public class GameStartController {

    private Rogue rogue;
    private GameGraphics graphics;

    public GameStartController(Rogue rogue, GameGraphics graphics) {
        this.rogue = rogue;
        this.graphics = graphics;
    }

    public void render() {
        if(!rogue.started) {
            Texture startTexture = graphics.assetManager.get("Desktop/assets/title.png", Texture.class);
            graphics.spriteBatch.begin();
            graphics.spriteBatch.draw(startTexture, 190, 90);
            graphics.spriteBatch.end();
        } else if(rogue.finished && rogue.gameMap.getHeroes().isEmpty()) {
            Texture startTexture = graphics.assetManager.get("Desktop/assets/lose.png", Texture.class);
            graphics.spriteBatch.begin();
            graphics.spriteBatch.draw(startTexture, 190, 90);
            graphics.spriteBatch.end();
        } else if(rogue.finished) {
            Texture startTexture = graphics.assetManager.get("Desktop/assets/win.png", Texture.class);
            graphics.spriteBatch.begin();
            graphics.spriteBatch.draw(startTexture, 190, 90);
            graphics.spriteBatch.end();
        }
    }

    public void tick() {
        if(rogue.finished || !rogue.started) {
            if(Gdx.input.isKeyPressed(Input.Keys.ENTER)) {
                rogue.restart();
            }
        }
    }
}
