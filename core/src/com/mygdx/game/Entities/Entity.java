package com.mygdx.game.Entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.Gdx;

public abstract class Entity extends Collidable{

    private Vector2 prvPosition;
    private float velocityY = 0f;
    private Sprite sprite;
    private int direction;
    private boolean gravity;
    private static Texture texture = new Texture("img.png");

    private int speed;

    private boolean control = false;

    public Entity(float x, float y, int speed) {
        super(x, y, texture.getHeight(), texture.getWidth());
        this.prvPosition = new Vector2(x, y);
        this.sprite = new Sprite(this.texture);
        this.direction = 1; // looking right
        this.gravity = true;
        this.speed = speed;
    }

    public Entity(float x, float y, int speed, Texture texture) {
        super(x, y, texture.getHeight(), texture.getWidth());
        this.prvPosition = new Vector2(x, y);
        this.sprite = new Sprite(texture);
        this.direction = 1; // looking right
        this.gravity = true;
        this.speed = speed;
    }

    public abstract void handleMovement();

    public void applyGravity() {
        if (gravity) {
            velocityY -= speed * Gdx.graphics.getDeltaTime();
            setY(getY() + velocityY * Gdx.graphics.getDeltaTime());

            if (getY() <= 0) {
                setY(0);
                velocityY = 0;
                gravity = false;
            }
        } else if (getY() > 0) {
            gravity = true;
        }
    }
    public void moveLeft() {
        float temp = getX() - speed * Gdx.graphics.getDeltaTime();
        if (temp > 0) {
            setX( getX() - speed * Gdx.graphics.getDeltaTime());
            if(direction == 1) {
                sprite.flip(true, false);
                direction = -1;
            }
        }
    }

    public void moveRight() {
        float temp = getX() + speed * Gdx.graphics.getDeltaTime();
        if (temp < Gdx.graphics.getWidth() - sprite.getWidth()) {
            setX( temp );
            if(direction == -1) {
                sprite.flip(true, false);
                direction = 1;
            }
        }
    }

    public void moveJump() {
        if (!gravity) {
            velocityY = 140f;
            gravity = true;
        }
    }

    @Override
    public void handleCollision(iCollidable other) {
        if(this.collidesWith(other)) {
            reactToCollision(other);
            if (other instanceof Ground) gravity = false;
            else gravity = true;
        }
    }


    public void draw(SpriteBatch batch) {
        batch.begin();
        sprite.setPosition(getX(), getY());
        sprite.draw(batch);
        batch.end();
    }


    public Vector2 getPrvPosition() {
        return prvPosition;
    }

    public void setPrvPosition(Vector2 prvPosition) {
        this.prvPosition.x = prvPosition.x;
        this.prvPosition.y = prvPosition.y;
    }

    public float getPrvX() {
        return prvPosition.x;
    }
    public void setPrvX(float x) {
        this.prvPosition.x = x;
    }

    public float getPrvY() {
        return prvPosition.y;
    }
    public void setPrvY(float y) {
        this.prvPosition.y = y;
    }

    public boolean isControl() {
        return control;
    }

    public void setControl(boolean control) {
        this.control = control;
    }

    public float getVelocityY() {
        return velocityY;
    }

    public void setVelocityY(float velocityY) {
        this.velocityY = velocityY;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public boolean isGravity() {
        return gravity;
    }

    public void setGravity(boolean gravity) {
        this.gravity = gravity;
    }

    public static Texture getTexture() {
        return texture;
    }

    public static void setTexture(Texture texture) {
        Entity.texture = texture;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
