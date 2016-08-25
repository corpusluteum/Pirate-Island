package com.manik.drawer;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.manik.imageLoader.ImageLoader;
import com.manik.states.PlayState;


public class BulletScoreDrawer {

    private PlayState playState;

    public BulletScoreDrawer(PlayState playState){
        this.playState=playState;
    }

    public void render(SpriteBatch sb){
        sb.begin();
        ImageLoader.font.draw(sb, "Bullet:" + String.valueOf(playState.getBulletScore()), playState.getCam().position.x - 115, 20);
        sb.end();
    }
}
