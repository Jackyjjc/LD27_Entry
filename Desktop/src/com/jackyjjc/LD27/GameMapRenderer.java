package com.jackyjjc.LD27;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.jackyjjc.LD27.heroes.Hero;

import java.util.List;

/**
 * @author Junjie CHEN(jacky.jjchen@gmail.com)
 */
public class GameMapRenderer {

    private static final int NUM_COLS = 33;
    private static final int NUM_ROWS = 12;

    private GameGraphics graphics;

    private int xOff;
    private int yOff;
    private GameMap gameMap;

    public GameMapRenderer(GameMap gameMap, GameGraphics graphics) {
        this.graphics = graphics;
        this.xOff = 0;
        this.yOff = 0;
        this.gameMap = gameMap;
    }

    public void render() {

        TextureRegion[][] mapTexture = TextureRegion.split(graphics.assetManager.get("Desktop/assets/environments.png", Texture.class), 32, 32);
        TextureRegion[][] heroTexture = TextureRegion.split(graphics.assetManager.get("Desktop/assets/heroes.png", Texture.class), 24, 24);
        TextureRegion[][] enemyTexture = TextureRegion.split(graphics.assetManager.get("Desktop/assets/enemies.png", Texture.class), 24, 24);

        SpriteBatch batch = graphics.spriteBatch;

        batch.begin();

        //render basic map
        for(int row = 0; row < NUM_ROWS; row++) {
            for(int col = 0; col < NUM_COLS; col++) {

                int tile = gameMap.getData(xOff + col, yOff + row) - 1;
                int textureRow = tile / mapTexture[0].length;
                int textureCol = tile % mapTexture[0].length;
                TextureRegion region = mapTexture[textureRow][textureCol];

                batch.draw(region, col * region.getRegionWidth(), 384 - (row * region.getRegionHeight()));
            }
        }

        batch.end();

        //render heroes
        List<Hero> heroList = gameMap.getHeroes();
        for (Hero hero : heroList) {

            if(hero.x() >= xOff) {

                int textureRow = hero.male ? 0 : 1;
                TextureRegion region = heroTexture[textureRow][hero.type];

                renderUnit(batch, region, hero, -2);
            }

        }

        //render enemies
        List<Unit> enemies = gameMap.getEnemies();
        for (Unit enemy : enemies) {
            if(enemy.x() >= xOff) {
                TextureRegion region = enemyTexture[2][0];
                region.flip(true, false);
                renderUnit(batch, region, enemy, 1);
            }
        }
    }

    public void renderUnit(SpriteBatch batch, TextureRegion region, Unit unit, int offset) {

        float screenX = (unit.x() - xOff) * 32 + 4;
        float screenY = 384 - (unit.y() * 32 - 4);

        batch.begin();
        batch.draw(region, screenX, screenY);
        batch.end();

        //render the hp bar
        graphics.shapeRenderer.begin(ShapeRenderer.ShapeType.FilledRectangle);
        graphics.shapeRenderer.setColor(Color.GREEN);
        graphics.shapeRenderer.filledRect(screenX + offset, screenY - 7, ((float)unit.hp) / unit.maxHp * 24, 4);
        graphics.shapeRenderer.end();
    }

    public void panHorizontal(int dir) {

        if(dir > 0) {
          xOff = Math.min(xOff + 1, gameMap.width() - NUM_COLS);
        } else {
          xOff = Math.max(xOff - 1, 0);
        }
    }
}
