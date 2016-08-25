package com.manik.inputHandler;

import com.badlogic.gdx.InputProcessor;
import com.manik.gameObject.GameWord;
import com.manik.states.GameOverState;
import com.manik.states.MenuState;


public class GameOverStateInput implements InputProcessor {

    private GameOverState gameOverState;

    public GameOverStateInput(GameOverState gameOverState){
        this.gameOverState=gameOverState;
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {

        if(gameOverState.getBackBtn().getBtnRect().contains(screenX,screenY)){
           gameOverState.getSm().pushState(new MenuState(gameOverState.getSm()));
        }
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
