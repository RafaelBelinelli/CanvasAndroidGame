package br.unicamp.canvasandroidgame.map;

import android.graphics.Canvas;
import android.graphics.Rect;

import br.unicamp.canvasandroidgame.graphics.Sprite;
import br.unicamp.canvasandroidgame.graphics.SpriteSheet;

public class GroundTwoTile extends Tile {
    private final Sprite sprite;

    public GroundTwoTile(SpriteSheet spriteSheet, Rect mapLocationRect) {
        super(mapLocationRect);
        sprite = spriteSheet.getGroundTwoSprite();
    }

    @Override
    public void draw(Canvas canvas) {
        sprite.draw(canvas, mapLocationRect.left, mapLocationRect.top);
    }
}
