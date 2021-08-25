package br.unicamp.canvasandroidgame.map;

import android.graphics.Canvas;
import android.graphics.Rect;

import br.unicamp.canvasandroidgame.graphics.Sprite;
import br.unicamp.canvasandroidgame.graphics.SpriteSheet;

public class TreeTile extends Tile {
    private final Sprite treeSprite;
    private final Sprite grassSprite;

    public TreeTile(SpriteSheet spriteSheet, Rect mapLocationRect) {
        super(mapLocationRect);
        treeSprite = spriteSheet.getTreeSprite();
        grassSprite = spriteSheet.getGrassSprite();
    }

    @Override
    public void draw(Canvas canvas) {
        grassSprite.draw(canvas, mapLocationRect.left, mapLocationRect.top);
        treeSprite.draw(canvas, mapLocationRect.left, mapLocationRect.top);
    }
}
