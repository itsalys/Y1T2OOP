package com.mygdx.game.Entities;

import com.badlogic.gdx.graphics.Texture;

public class Enemy extends Entity{

    private static Texture texture = new Texture("alien.png");

    public Enemy(float x, float y, int speed) {
        super(x, y, speed, texture);
    }

    @Override
    public void handleMovement() {
        setPrvPosition(getPosition());
        if(getDirection() == 1) moveRight();
        else moveLeft();
//        applyGravity();
    }

    @Override
    public void reactToCollision(iCollidable other) {
        if (other instanceof Player) {
            // player die
            setDirection( - getDirection());
            getSprite().flip(true, false);
        }
        if (other instanceof Ground || other instanceof Enemy) {
            setDirection( - getDirection());
            getSprite().flip(true, false);
        }
    }
}
