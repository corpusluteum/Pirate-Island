package com.manik.drawer;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.manik.imageLoader.ImageLoader;
import com.manik.states.PlayState;



public class PowerDrawer {

    private PlayState playState;

    public PowerDrawer(PlayState playState){
        this.playState=playState;
    }

    public void render(SpriteBatch sb){
        sb.begin();
        ImageLoader.font.draw(sb, "Power:" + String.valueOf(playState.getPower()), playState.getCam().position.x, 20);
        sb.end();
    }
}
