package com.mygdx.game;

import com.mygdx.game.Entities.Assets;
import com.mygdx.game.Entities.Collidable;
import com.mygdx.game.Entities.Entity;

import java.util.ArrayList;

public  class EntityLifecycleManager<T> {

    public MyGdxGame game;
    public ArrayList<Assets> list;

    public EntityLifecycleManager() {
        this.game = MyGdxGame.getInstance();
        list = new ArrayList<Assets>();
    }

    public void create(T entity) { // create & initialise
        list.add((Assets) entity);
        if (entity instanceof Collidable) {
            game.getCollisionManager().addCollidable(((Collidable) entity));
        }
        if (entity instanceof Entity) {
            game.getBehaviourManager().addEntity(((Entity) entity));
        }
    }

    public void render() {
        for (Assets asset : list) {
            if (asset instanceof Entity) {
                ((Entity) asset).draw(game.getBatch());
            }
//            asset.drawBoundary(game.getShapeRenderer()); // draw boundary - for debuggin
        }
    }

    public void updateAll() {
        game.getBehaviourManager().updateAll();
        game.getCollisionManager().updateAll();
    }

    public void updateOne(Assets entity)
    {
        if (entity instanceof Collidable) {
            game.getCollisionManager().updateOne(((Collidable) entity));
        }
        if (entity instanceof Entity) {
            game.getBehaviourManager().updateOne(((Entity) entity));
        }
    }

    public void dispose() {
        list.clear();
        game.getBehaviourManager().dispose();
        game.getCollisionManager().dispose();
    }
}

