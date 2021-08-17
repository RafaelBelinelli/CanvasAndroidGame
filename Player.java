package br.unicamp.canvasandroidgame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import androidx.core.content.ContextCompat;

public class Player {
    private double positionX;
    private double positionY;
    private double radius;

    private Paint paint;
    private Context context;

    public Player(Context context, double positionX, double positionY, double radius) {
        this.context = context;

        this.positionX = positionX;
        this.positionY = positionY;
        this.radius = radius;


        paint = new Paint();
        int color = ContextCompat.getColor(context, R.color.player);
        paint.setColor(color);
        paint.setStyle(Paint.Style.FILL);
    }

    public void draw(Canvas canvas) {
        canvas.drawCircle((float) positionX, (float) positionY, (float) radius, paint);
    }

    public void update() {
    }

    public void setPosition(double positionX, double positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }
}
