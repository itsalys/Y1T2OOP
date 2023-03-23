package com.mygdx.game.Scenes;


import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.SceneManager;

public class GameWinScene implements Scene {

    private Stage stage;
    private Skin skin;

    private TextButton mainMenu;

    private Image background;

    @Override
    public void createScene() {
        stage = new Stage(new ScreenViewport());
        skin = new Skin(Gdx.files.internal("uiskin.json"));
        int row_height = Gdx.graphics.getWidth() / 10;
        int col_width = Gdx.graphics.getWidth() / 10;

        // set the background of the game
        background = new Image(new Texture(Gdx.files.internal("MainMenuBackground.jpg")));
        background.setWidth(Gdx.graphics.getWidth());
        background.setHeight(Gdx.graphics.getHeight());
        stage.addActor(background);

        // set the text of "You Win!"
        BitmapFont font = new BitmapFont(Gdx.files.internal("default.fnt"));
        font.getData().setScale(40f / font.getLineHeight());
        Label.LabelStyle style = new Label.LabelStyle();
        style.font = font;
        style.fontColor = Color.GREEN;
        Label Result = new Label("You Win!", style);
        Result.setPosition(240,300);

        // create back to home button
        mainMenu = new TextButton("Back to Main Menu", skin);
        mainMenu.setSize(Gdx.graphics.getWidth()/2,row_height);
        mainMenu.setX(160);
        mainMenu.setY(100);
        stage.addActor(mainMenu);
        stage.addActor(Result);
        /**mainMenu.addListener(new ClickListener()
        {
            @Override
            public void clicked(InputEvent event, float x, float y)
            {
                GameManager.getInstance().SetScene(GameManager.MainMenu);
            };
        }); **/

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
        // when "Back to Home" is pressed, bring user back to Main Menu
        if(mainMenu.isPressed()) {
            MyGdxGame.getInstance().getSceneManager().SetNextScene(SceneManager.MainMenu);
        }
    }

    @Override
    public void disposeScene() {

    }
}
