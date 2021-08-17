package br.unicamp.canvasandroidgame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import androidx.core.content.ContextCompat;

public class Player {
    private static final double SPEED_PIXELS_PER_SECOND = 400.0;
    private static final double MAX_SPEED = SPEED_PIXELS_PER_SECOND / Gameloop.MAX_UPS;
    private double positionX;
    private double positionY;
    private double radius;

    private Paint paint;
    private Context context;
    private double velocityX;
    private double velocityY;

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

    public void update(Joystick joystick) {
        velocityX = joystick.getActuatorX() * MAX_SPEED;
        velocityY = joystick.getActuatorY() * MAX_SPEED;

        positionX += velocityX;
        positionY += velocityY;
    }

    public void setPosition(double positionX, double positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }
}
