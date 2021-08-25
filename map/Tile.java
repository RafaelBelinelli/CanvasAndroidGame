package br.unicamp.canvasandroidgame.map;

import android.graphics.Canvas;
import android.graphics.Rect;

import br.unicamp.canvasandroidgame.graphics.SpriteSheet;

abstract class Tile {

    protected final Rect mapLocationRect;

    public Tile(Rect mapLocationRect) {
        this.mapLocationRect = mapLocationRect;
    }

    public enum TileType {
        GROUND_TILE,
        WATER_TILE,
        LAVA_TILE,
        GROUND2_TILE,
        GRASS_TILE,
        TREE_TILE
    }

    public static Tile getTile(int idxTileType, SpriteSheet spriteSheet, Rect mapLocationRect) {
        switch (TileType.values()[idxTileType]) {
            case GROUND_TILE:
                return new GroundTile(spriteSheet, mapLocationRect);
            case WATER_TILE:
                return new WaterTile(spriteSheet, mapLocationRect);
            case LAVA_TILE:
                return new LavaTile(spriteSheet, mapLocationRect);
            case GROUND2_TILE:
                return new GroundTwoTile(spriteSheet, mapLocationRect);
            case GRASS_TILE:
                return new GrassTile(spriteSheet, mapLocationRect);
            case TREE_TILE:
                return new TreeTile(spriteSheet, mapLocationRect);
            default:
                return null;
        }
    }

    public abstract void draw(Canvas canvas);
}
