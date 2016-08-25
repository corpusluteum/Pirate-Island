package com.manik.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.manik.buttons.Button;
import com.manik.imageLoader.ImageLoader;
import com.manik.inputHandler.MenuStateInput;


/**
 * Created by manik on 2016.
 */
public class MenuState extends State {

    private SpriteBatch spriteBatch;
    private StateManager sm;
    private Button playButton,levelButton,aboutButton;

    private float butonXkord;
    private float butonYkord;

    public MenuState(StateManager sm) {
        super(sm);

        this.sm=sm;
        butonXkord=(Gdx.graphics.getWidth()/3);
        butonYkord= (Gdx.graphics.getHeight()/7);
        Gdx.input.setInputProcessor(new MenuStateInput(this));

        playButton=new Button(butonXkord,butonYkord,butonXkord,butonYkord,ImageLoader.startBtnRegion);
        levelButton=new Button(butonXkord,butonYkord,butonXkord,butonYkord*3,ImageLoader.levelBtnRegion);
        aboutButton=new Button(butonXkord,butonYkord,butonXkord,butonYkord*5,ImageLoader.aboutBtnRegion);
    }

    @Override
    public void render(SpriteBatch sb) {
        this.spriteBatch=sb;

        spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.begin();
        spriteBatch.draw(ImageLoader.menuBgRegion, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        spriteBatch.end();
        playButton.render(sb);
        levelButton.render(sb);
        aboutButton.render(sb);
    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void HandleInput() {
    }

    public StateManager getSm(){
        return sm;
    }

    public Button getPlayButton() {
        return playButton;
    }

    public Button getLevelButton() {
        return levelButton;
    }

    public Button getAboutButton() {
        return aboutButton;
    }

}
