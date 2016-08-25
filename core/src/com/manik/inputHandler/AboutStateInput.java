package com.manik.inputHandler;

import com.badlogic.gdx.InputProcessor;
import com.manik.states.AboutState;
import com.manik.states.MenuState;


public class AboutStateInput implements InputProcessor {

    private AboutState aboutState;

    public AboutStateInput(AboutState aboutState){
        this.aboutState=aboutState;
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

        if(aboutState.getBackButton().getBtnRect().contains(screenX,screenY)){
            aboutState.getSm().pushState(new MenuState(aboutState.getSm()));
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
