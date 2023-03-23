package com.mygdx.game.Entities;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class Assets {
    private Vector2 position;
    private int height;
    private int width;

    private Rectangle boundary = new Rectangle();

    public Assets(float x, float y, int height, int width) {
        this.position = new Vector2(x,y);
        this.height = height;
        this.width = width;

        // initialise boundary
        boundary.x = x;
        boundary.y = y;
        boundary.height = height;
        boundary.width = width;
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position.x = position.x;
        this.position.y = position.y;
    }

    public float getX() {
        return position.x;
    }
    public void setX(float x) {
        this.position.x = x;
    }

    public float getY() {
        return position.y;
    }
    public void setY(float y) {
        this.position.y = y;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Rectangle getNewBoundary() {
        boundary.x = position.x;
        boundary.y = position.y;
        return boundary;
    }

    public Rectangle getBoundary() {
        return boundary;
    }

    public void setBoundary(Rectangle boundary) {
        this.boundary = boundary;
    }
    public void setBoundary(int x, int y) {
        boundary.x = position.x;
        boundary.y = position.y;
    }

    public void drawBoundary(ShapeRenderer shapeRenderer) {
        boundary = getNewBoundary();
        shapeRenderer.setColor(Color.RED);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.rect(boundary.x, boundary.y, boundary.width, boundary.height);
        shapeRenderer.end();
    }
}
