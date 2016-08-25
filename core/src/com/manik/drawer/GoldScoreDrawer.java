package com.manik.drawer;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.manik.imageLoader.ImageLoader;
import com.manik.states.PlayState;



public class GoldScoreDrawer {

    private PlayState playState;

    public GoldScoreDrawer(PlayState playState){
        this.playState=playState;
    }

    public void render(SpriteBatch sb){
        sb.begin();
        ImageLoader.font.draw(sb, "Gold:" + String.valueOf(playState.getGoldScore()), playState.getCam().position.x - 220, 20);
        sb.end();
    }
}
