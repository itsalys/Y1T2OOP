package com.mygdx.game;

import com.mygdx.game.Entities.Collidable;
import com.mygdx.game.Entities.Entity;

import java.util.ArrayList;

public class CollisionManager {

    public MyGdxGame game;
    private ArrayList<Collidable> list;

    public CollisionManager() {
        this.game = MyGdxGame.getInstance();
        this.list = new ArrayList<Collidable>();
    }

    public void updateAll()
    {
        for (Collidable entity: list) {
            for (Collidable other: list) {
                if(entity.equals(other)) continue;
                entity.handleCollision(other);
            }
        }
    }

    public void updateOne(Collidable entity)
    {
        for (Collidable other: list) {
            if(entity.equals(other)) continue;
            entity.handleCollision(other);
        }
    }

    public void addCollidable(Collidable entity)
    {
        list.add(entity);
    }

    public void dispose() {
        list.clear();
    }
}
