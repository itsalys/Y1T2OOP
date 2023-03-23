package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class MyGdxGame extends ApplicationAdapter {

	private static MyGdxGame game;

	public static MyGdxGame getInstance() {
		if (game == null) {
			game = new MyGdxGame();
		}
		return game;
	}

	private EntityLifecycleManager entityLifecycleManager;
	private CollisionManager collisionManager;
	private BehaviourManager behaviourManager;
	private InputManager inputManager;
	private SceneManager sceneManager;

	private SpriteBatch batch;
	private ShapeRenderer shapeRenderer;

	public MyGdxGame () {
		game = this;
		entityLifecycleManager = new EntityLifecycleManager();
		collisionManager = new CollisionManager();
		behaviourManager = new BehaviourManager();
		inputManager = new InputManager();
		sceneManager = new SceneManager();
	}

	@Override
	public void create () {
		batch = new SpriteBatch();
		shapeRenderer = new ShapeRenderer();

		sceneManager.SetNextScene(sceneManager.MainMenu);
	}

	@Override
	public void render () {
		sceneManager.RunCurrentScene();
	}

	@Override
	public void dispose () {
		batch.dispose();
	}

	public EntityLifecycleManager getEntityLifecycleManager() {
		return entityLifecycleManager;
	}

	public void setEntityLifecycleManager(EntityLifecycleManager entityLifecycleManager) {
		this.entityLifecycleManager = entityLifecycleManager;
	}

	public CollisionManager getCollisionManager() {
		return collisionManager;
	}

	public void setCollisionManager(CollisionManager collisionManager) {
		this.collisionManager = collisionManager;
	}

	public BehaviourManager getBehaviourManager() {
		return behaviourManager;
	}

	public void setBehaviourManager(BehaviourManager behaviourManager) {
		this.behaviourManager = behaviourManager;
	}

	public InputManager getInputManager() {
		return inputManager;
	}

	public void setInputManager(InputManager inputManager) {
		this.inputManager = inputManager;
	}

	public SceneManager getSceneManager() {
		return sceneManager;
	}

	public void setSceneManager(SceneManager sceneManager) {
		this.sceneManager = sceneManager;
	}

	public SpriteBatch getBatch() {
		return batch;
	}

	public void setBatch(SpriteBatch batch) {
		this.batch = batch;
	}

	public ShapeRenderer getShapeRenderer() {
		return shapeRenderer;
	}

	public void setShapeRenderer(ShapeRenderer shapeRenderer) {
		this.shapeRenderer = shapeRenderer;
	}
}
