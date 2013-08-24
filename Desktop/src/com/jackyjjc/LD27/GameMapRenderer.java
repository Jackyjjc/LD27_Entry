package com.jackyjjc.LD27;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.jackyjjc.LD27.characters.Hero;

import java.util.List;

/**
 * @author Junjie CHEN(jacky.jjchen@gmail.com)
 */
public class GameMapRenderer {

    private static final int NUM_COLS = 33;
    private static final int NUM_ROWS = 12;

    private GameGraphics graphics;

    private Vector2 curPos;
    private GameMap gameMap;

    private TextureRegion[][] mapTexture;
    private TextureRegion[][] heroTexture;

    public GameMapRenderer(GameMap gameMap, GameGraphics graphics) {
        this.graphics = graphics;
        this.curPos = new Vector2(0,0);
        this.gameMap = gameMap;
    }

    public void render() {

        this.mapTexture = TextureRegion.split(graphics.assetManager.get("Desktop/assets/environments.png", Texture.class), 32, 32);
        this.heroTexture = TextureRegion.split(graphics.assetManager.get("Desktop/assets/heroes.png", Texture.class), 24, 24);

        SpriteBatch batch = graphics.spriteBatch;

        batch.begin();

        //render basic map
        for(int row = 0; row < NUM_ROWS; row++) {
            for(int col = 0; col < NUM_COLS; col++) {

                int tile = gameMap.getData((int)curPos.x + col, (int)curPos.y + row) - 1;
                int textureRow = tile / mapTexture[0].length;
                int textureCol = tile % mapTexture[0].length;
                TextureRegion region = mapTexture[textureRow][textureCol];

                batch.draw(region, col * region.getRegionWidth(), 384 - (row * region.getRegionHeight()));
            }
        }

        //render heroes
        List<Hero> heroList = gameMap.getHeroes();
        for (Hero hero : heroList) {

            Vector2 heroPos = hero.getPos();

            if(heroPos.x >= curPos.x) {
                int textureRow = hero.male ? 0 : 1;
                TextureRegion region = heroTexture[textureRow][hero.type];
                batch.draw(region, (heroPos.x - curPos.x) * 32 + 4, 384 - (heroPos.y * 32 - 4));
            }
        }

        batch.end();
    }

    public void panHorizontal(int dir) {

        if(dir > 0) {
          curPos.x = Math.min(curPos.x + 1, gameMap.width() - NUM_COLS);
        } else {
          curPos.x = Math.max(curPos.x - 1, 0);
        }
    }
}
