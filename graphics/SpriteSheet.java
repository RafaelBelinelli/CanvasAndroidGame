package br.unicamp.canvasandroidgame.graphics;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import br.unicamp.canvasandroidgame.R;

public class SpriteSheet {
    private static final int SPRITE_WIDTH_PIXELS = 64;
    private static final int SPRITE_HEIGHT_PIXELS = 64;

    private Bitmap bitmap;

    public SpriteSheet(Context context) {
        BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();
        bitmapOptions.inScaled = false;
        this.bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.sprite_sheet, bitmapOptions);
    }

    public Sprite[] getPlayerSpriteArrayUp() {
        Sprite[] spriteArray = new Sprite[3];
        spriteArray[0] = new Sprite(this, new Rect(64, 0, 128, 64));
        spriteArray[1] = new Sprite(this, new Rect(64, 64, 128, 128));
        spriteArray[2] = new Sprite(this, new Rect(64, 128, 128, 192));
        return spriteArray;
    }

    public Sprite[] getPlayerSpriteArrayDown() {
        Sprite[] spriteArray = new Sprite[3];
        spriteArray[0] = new Sprite(this, new Rect(0, 0, 64, 64));
        spriteArray[1] = new Sprite(this, new Rect(0, 64, 64, 128));
        spriteArray[2] = new Sprite(this, new Rect(0, 128, 64, 192));
        return spriteArray;
    }

    public Sprite[] getPlayerSpriteArrayRight() {
        Sprite[] spriteArray = new Sprite[3];
        spriteArray[0] = new Sprite(this, new Rect(128, 0, 192, 64));
        spriteArray[1] = new Sprite(this, new Rect(128, 64, 192, 128));
        spriteArray[2] = new Sprite(this, new Rect(128, 128, 192, 192));
        return spriteArray;
    }

    public Sprite[] getPlayerSpriteArrayLeft() {
        Sprite[] spriteArray = new Sprite[3];
        spriteArray[0] = new Sprite(this, new Rect(192, 0, 256, 64));
        spriteArray[1] = new Sprite(this, new Rect(192, 64, 256, 128));
        spriteArray[2] = new Sprite(this, new Rect(192, 128, 256, 192));
        return spriteArray;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public Sprite getGroundSprite() {
        return getSpriteByIndex(3, 0);
    }

    public Sprite getWaterSprite() {
        return getSpriteByIndex(3, 1);
    }

    public Sprite getLavaSprite() {
        return getSpriteByIndex(3, 2);
    }

    public Sprite getGroundTwoSprite() {
        return getSpriteByIndex(3, 3);
    }

    public Sprite getGrassSprite() {
        return getSpriteByIndex(4, 0);
    }

    public Sprite getTreeSprite() {
        return getSpriteByIndex(4, 1);
    }

    private Sprite getSpriteByIndex(int idxRow, int idxCol) {
        return new Sprite(this, new Rect(
                idxCol*SPRITE_WIDTH_PIXELS,
                idxRow*SPRITE_HEIGHT_PIXELS,
                (idxCol + 1)*SPRITE_WIDTH_PIXELS,
                (idxRow + 1)*SPRITE_HEIGHT_PIXELS
        ));
    }
}
