package br.unicamp.canvasandroidgame.gameobject;

import android.content.Context;
import android.graphics.Canvas;

import androidx.core.content.ContextCompat;

import br.unicamp.canvasandroidgame.GameDisplay;
import br.unicamp.canvasandroidgame.Gameloop;
import br.unicamp.canvasandroidgame.Utils;
import br.unicamp.canvasandroidgame.gamepanel.HealthBar;
import br.unicamp.canvasandroidgame.gamepanel.Joystick;
import br.unicamp.canvasandroidgame.R;
import br.unicamp.canvasandroidgame.graphics.Sprite;
import br.unicamp.canvasandroidgame.graphics.SpriteSheet;

/**
 * Player is the main character of the game, which the user can control with a touch joystick.
 * The player class is an extension of a Circle, which is an extension of GameObject
 */
public class Player extends Circle {
    public static final double SPEED_PIXELS_PER_SECOND = 400.0;
    public static final int MAX_HEALTH_POINTS = 5;
    private static final double MAX_SPEED = SPEED_PIXELS_PER_SECOND / Gameloop.MAX_UPS;

    private final Joystick joystick;
    private HealthBar healthBar;
    private int healthPoints;
    private SpriteSheet spriteSheet;

    public Player(Context context, Joystick joystick, double positionX, double positionY, double radius, SpriteSheet spriteSheet) {
        super(context, ContextCompat.getColor(context, R.color.player), positionX, positionY, radius);
        this.joystick = joystick;
        this.healthBar = new HealthBar(context, this);
        this.healthPoints = MAX_HEALTH_POINTS;
        this.spriteSheet = spriteSheet;
    }

    public void update() {
        // Update velocity based on actuator of joystick
        velocityX = joystick.getActuatorX() * MAX_SPEED;
        velocityY = joystick.getActuatorY() * MAX_SPEED;

        // Update position
        positionX += velocityX;
        positionY += velocityY;

        // Update direction
        if (velocityX != 0 || velocityY != 0) {
            // Normalize velocity to get direction (unit vector of velocity)
            double distance = Utils.getDistanceBetweenPoints(0, 0, velocityX, velocityY);
            directionX = velocityX/distance;
            directionY = velocityY/distance;
        }
    }

    public void draw(Canvas canvas, GameDisplay gameDisplay) {
        Sprite sprite;

        if (directionY < 0) {
            sprite = spriteSheet.getPlayerSpriteUp();
        } else {
            sprite = spriteSheet.getPlayerSpriteDown();
        }

        sprite.draw(
                canvas,
                (int) gameDisplay.gameToDisplayCoordinatesX(getPositionX()) - sprite.getWidth() / 2,
                (int) gameDisplay.gameToDisplayCoordinatesY(getPositionY()) - sprite.getHeight() / 2
        );

        /*if (directionY < 0) {
            sprite.draw2(
                    canvas,
                    (int) gameDisplay.gameToDisplayCoordinatesX(getPositionX()) - sprite.getWidth() / 2,
                    (int) gameDisplay.gameToDisplayCoordinatesY(getPositionY()) - sprite.getHeight() / 2);
        } else {

            sprite.draw(
                    canvas,
                    (int) gameDisplay.gameToDisplayCoordinatesX(getPositionX()) - sprite.getWidth() / 2,
                    (int) gameDisplay.gameToDisplayCoordinatesY(getPositionY()) - sprite.getHeight() / 2
            );
        }*/

        healthBar.draw(canvas, gameDisplay);
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        if (healthPoints >= 0)
            this.healthPoints = healthPoints;
    }
}
