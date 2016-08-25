package com.manik.inputHandler;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
import com.manik.gameObject.GameWord;
import com.manik.imageLoader.ImageLoader;
import com.manik.soundLoader.SoundLoader;
import com.manik.states.MenuState;
import com.manik.states.PlayState;


public class PlayInputHandler implements InputProcessor {

    private PlayState playState;

    public PlayInputHandler(PlayState playState){
        this.playState=playState;
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

        //ateş etme butonuna basıldığında
        if(playState.getGameWord().getBangButton().getBtnRect().contains(screenX,screenY)){
            playState.getGameWord().getPlayerFireHandler().setBang(true);
        }
        //zıplama butonuna basıldığında
        if(!playState.getGameWord().getController().isJumpUpdate()) {
            if (playState.getGameWord().getJumpButton().getBtnRect().contains(screenX, screenY)) {
                playState.getGameWord().getController().setJump(true);
                playState.getGameWord().getController().setJumpUpdate(true);
            }
        }

        if(playState.getGameWord().getMoveRightBtn().getBtnRect().contains(screenX,screenY)){
            if(playState.getGameWord().getController().isMoveLeft()){
                ImageLoader.playerRegion1.flip(true,false);
                ImageLoader.playerRegion2.flip(true,false);
                ImageLoader.playerRegion3.flip(true,false);
                ImageLoader.playerRegion4.flip(true,false);
                playState.getGameWord().getController().setMoveLeft(false);
                playState.getGameWord().getController().setMoveRight(true);
                playState.getGameWord().getPlayer().setChangeDirection(true);
            }
        }
        if(playState.getGameWord().getMoveLeftBtn().getBtnRect().contains(screenX,screenY)){
            if(playState.getGameWord().getController().isMoveRight()){
                ImageLoader.playerRegion1.flip(true,false);
                ImageLoader.playerRegion2.flip(true,false);
                ImageLoader.playerRegion3.flip(true,false);
                ImageLoader.playerRegion4.flip(true,false);
                playState.getGameWord().getController().setMoveRight(false);
                playState.getGameWord().getController().setMoveLeft(true);
                playState.getGameWord().getPlayer().setChangeDirection(true);
            }
        }
        if(playState.getGameWord().getExitPlayBtn().getBtnRect().contains(screenX,screenY)){
            playState.getSm().pushState(new MenuState(playState.getSm()));
            SoundLoader.playSound.stop();
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
