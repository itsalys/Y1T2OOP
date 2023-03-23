package com.mygdx.game.Entities;

public interface iCollidable {

    boolean collidesWith(iCollidable other);

    void handleCollision(iCollidable other);

    void reactToCollision(iCollidable other);
}
