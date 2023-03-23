package com.mygdx.game.Scenes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.SceneManager;

public class InstructionScene implements Scene {

    private Stage stage;
    private Skin skin;
    private SpriteBatch batch;
    private TextButton backbutton;

    private TextButton moveUp;

    //private TextButton moveDown;
    private TextButton moveLeft;

    private TextButton moveRight;

    private TextButton optionButton;

    private Image background;
    @Override
    public void createScene() {
        stage = new Stage(new ScreenViewport());
        skin = new Skin(Gdx.files.internal("uiskin.json"));
        int row_height = Gdx.graphics.getWidth() / 10;
        int col_width = Gdx.graphics.getWidth() / 10;

        background = new Image(new Texture(Gdx.files.internal("MainMenuBackground.jpg")));
        background.setWidth(Gdx.graphics.getWidth());
        background.setHeight(Gdx.graphics.getHeight());
        stage.addActor(background);

        // instruction list words
        Label.LabelStyle labelstyle = new Label.LabelStyle();
        labelstyle.font = new BitmapFont(Gdx.files.internal("default.fnt"));;

        // move down instruction
        /** labelstyle.fontColor = Color.LIME;
        Label downlabel = new Label("Move Down", labelstyle);
        moveDown = new TextButton("S", skin);
        moveDown.setPosition(350,300);
        downlabel.setPosition(200, 300);
        stage.addActor(moveDown);
        stage.addActor(downlabel); **/
        // font color and position of instruction of move left
        labelstyle.fontColor = Color.LIME;
        Label leftLabel = new Label("Move Left", labelstyle);
        moveLeft = new TextButton("A", skin);
        moveLeft.setPosition(350,350);
        leftLabel.setPosition(200, 350);
        stage.addActor(moveLeft);
        stage.addActor(leftLabel);

        // move right instruction
        labelstyle.fontColor = Color.LIME;
        Label rightLabel = new Label("Move Right", labelstyle);
        moveLeft = new TextButton("D", skin);
        moveLeft.setPosition(350,250);
        rightLabel.setPosition(200, 250);
        stage.addActor(moveLeft);
        stage.addActor(rightLabel);

        Label uplabel = new Label("Jump", labelstyle);
        moveUp = new TextButton("W / SPACEBAR", skin);
        moveUp.setPosition(350,150);
        uplabel.setPosition(200, 150);
        stage.addActor(moveUp);
        stage.addActor(uplabel);


        backbutton = new TextButton("Back", skin);
        backbutton.setPosition(200, 40);
        stage.addActor(backbutton);

        Gdx.input.setInputProcessor(stage);

    }

    @Override
    public void renderScene() {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        stage.act();
        stage.draw();
    }

    @Override
    public void updateScene() {
        if(backbutton.isPressed()) {
            MyGdxGame.getInstance().getSceneManager().SetNextScene(SceneManager.MainMenu);
        }
    }

    @Override
    public void disposeScene() {

    }
}
