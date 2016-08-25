package com.manik.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.manik.buttons.Button;
import com.manik.imageLoader.ImageLoader;
import com.manik.inputHandler.GameOverStateInput;
import com.manik.inputHandler.OptionStateInput;
import com.manik.soundLoader.SoundLoader;

/**
 * Created by manik on 2016.
 */

public class GameOverState extends State {

    private Button backBtn;
    private StateManager sm;

    public GameOverState(StateManager sm) {
        super(sm);
        this.sm=sm;
        backBtn=new Button();
        Gdx.input.setInputProcessor(new GameOverStateInput(this));
        SoundLoader.gameOver.play();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        ImageLoader.font.draw(sb,"Game Over!", 20,Gdx.graphics.getHeight()/2-50);
        sb.end();
        backBtn.render(sb);
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

    public Button getBackBtn() {
        return backBtn;
    }


}
