package com.manik.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.manik.buttons.Button;
import com.manik.imageLoader.ImageLoader;
import com.manik.inputHandler.AboutStateInput;
import com.manik.inputHandler.OptionStateInput;

/**
 * Created by manik on 2016.
 */

public class AboutState extends State {

    private SpriteBatch spriteBatch;
    private StateManager sm;
    private Button backButton;

    public AboutState(StateManager sm) {
        super(sm);
        this.sm=sm;
        backButton=new Button();
        Gdx.input.setInputProcessor(new AboutStateInput(this));
    }

    @Override
    public void render(SpriteBatch sb) {
        this.spriteBatch=sb;
        spriteBatch.begin();
        spriteBatch.draw(ImageLoader.aboutBgRegion, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        spriteBatch.end();
        backButton.render(sb);
    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void HandleInput() {
    }

    public Button getBackButton(){
        return backButton;
    }

    public StateManager getSm(){
        return sm;
    }



}
