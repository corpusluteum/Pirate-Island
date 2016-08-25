package com.manik.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.manik.buttons.Button;
import com.manik.imageLoader.ImageLoader;
import com.manik.inputHandler.AboutStateInput;
import com.manik.inputHandler.OnePieceInput;

/**
 * Created by manik on 2016.
 */

public class OnePiece extends State {

    private StateManager sm;
    private Button backButton;

    public OnePiece(StateManager sm) {
        super(sm);
        this.sm=sm;
        backButton=new Button();
        Gdx.input.setInputProcessor(new OnePieceInput(this));
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(ImageLoader.onePieceRegion, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        sb.end();
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
