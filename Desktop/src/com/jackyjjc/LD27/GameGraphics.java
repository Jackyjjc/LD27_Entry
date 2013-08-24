package com.jackyjjc.LD27;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * @author Junjie CHEN(jacky.jjchen@gmail.com)
 */
public class GameGraphics {

    public ShapeRenderer shapeRenderer;
    public SpriteBatch spriteBatch;
    public BitmapFont font;
    public AssetManager assetManager;

    public GameGraphics() {
        this.shapeRenderer = new ShapeRenderer();
        this.spriteBatch = new SpriteBatch();
        this.font = new BitmapFont();

        this.assetManager = new AssetManager();
        this.assetManager.load(Gdx.files.internal("Desktop/assets/environments.png").path(), Texture.class);
        this.assetManager.load(Gdx.files.internal("Desktop/assets/enemies.png").path(), Texture.class);
        this.assetManager.load(Gdx.files.internal("Desktop/assets/heroes.png").path(), Texture.class);
    }
}
