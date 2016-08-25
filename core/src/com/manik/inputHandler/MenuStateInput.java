package com.manik.inputHandler;

import com.badlogic.gdx.InputProcessor;
import com.manik.states.AboutState;
import com.manik.states.MenuState;
import com.manik.states.OptionsState;
import com.manik.states.PlayState;


public class MenuStateInput implements InputProcessor {

    private MenuState menuState;

    public MenuStateInput(MenuState menuState){

        this.menuState=menuState;
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

        if(menuState.getPlayButton().getBtnRect().contains(screenX,screenY))
        {
           menuState.getSm().pushState(new PlayState(menuState.getSm(),1,false));
        }
        if(menuState.getAboutButton().getBtnRect().contains(screenX,screenY))
        {
            menuState.getSm().pushState(new AboutState(menuState.getSm()));
        }
        if(menuState.getLevelButton().getBtnRect().contains(screenX,screenY))
        {
            menuState.getSm().pushState(new OptionsState(menuState.getSm()));
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
