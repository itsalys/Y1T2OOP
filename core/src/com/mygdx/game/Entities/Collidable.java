package com.mygdx.game.Entities;

public abstract class Collidable extends Assets implements iCollidable {


    public Collidable(float x, float y, int height, int width) {
        super(x, y, height, width);
    }

    @Override
    public boolean collidesWith(iCollidable other) {
        Collidable entity = (Collidable) other;
        return getNewBoundary().overlaps( entity.getNewBoundary() );
    }

    @Override
    public void handleCollision(iCollidable other) {
        if(this.collidesWith(other)) {
            reactToCollision(other);
        }
    }
}
