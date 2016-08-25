package com.manik.inputHandler;

import com.badlogic.gdx.InputProcessor;
import com.manik.states.MenuState;
import com.manik.states.OptionsState;
import com.manik.states.PlayState;


public class OptionStateInput implements InputProcessor {

    private OptionsState optionsState;
    private float difficulty;

    public OptionStateInput(OptionsState optionsState){
        this.optionsState=optionsState;
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

        if(optionsState.getBackBtn().getBtnRect().contains(screenX,screenY)){
            optionsState.getSm().pushState(new MenuState(optionsState.getSm()));
        }
        for(int i=0; i< optionsState.getLevelBoard().getRow();i++){
            for(int j=0; j<optionsState.getLevelBoard().getCol(); j++){
                if(optionsState.getLevelBoard().getLevelTicks()[i][j].getCollisionRect().contains(screenX,screenY)){
                    difficulty=(i*optionsState.getLevelBoard().getCol())+(j+1);
                    optionsState.getSm().pushState(new PlayState(optionsState.getSm(),difficulty, true));
                }
            }

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
