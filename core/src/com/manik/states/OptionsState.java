package com.manik.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.manik.buttons.Button;
import com.manik.imageLoader.ImageLoader;
import com.manik.inputHandler.OptionStateInput;
import com.manik.level.LevelBoard;

/**
 * Created by manik on 2016.
 */
public class OptionsState extends State {
    private Button backBtn;
    private StateManager sm;

    private LevelBoard levelBoard;

    public OptionsState(StateManager sm) {
        super(sm);
        this.sm=sm;
        backBtn=new Button();
        Gdx.input.setInputProcessor(new OptionStateInput(this));
        levelBoard=new LevelBoard(2,3);
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(ImageLoader.optionsBgRegion, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        sb.end();
        backBtn.render(sb);
        levelBoard.render(sb);
    }

    @Override
    public void update(float delta) {
        levelBoard.update(delta);
    }

    @Override
    public void HandleInput() {

    }

    public StateManager getSm(){
        return sm;
    }

    public Button getBackBtn(){
        return backBtn;
    }

    public LevelBoard getLevelBoard() {
        return levelBoard;
    }

    public void setLevelBoard(LevelBoard levelBoard) {
        this.levelBoard = levelBoard;
    }
}
