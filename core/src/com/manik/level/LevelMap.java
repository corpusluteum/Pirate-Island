package com.manik.level;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.manik.imageLoader.ImageLoader;


public class LevelMap {

    private float xKord;
    private float yKord;
    private float width;
    private float height;

    public LevelMap(float xKord, float yKord, float width, float height){
        this.xKord=xKord;
        this.yKord=yKord;
        this.width=width;
        this.height=height;

    }

    public void render(SpriteBatch sb){

        sb.begin();
        sb.draw(ImageLoader.optionsIslandRegion,xKord,yKord,width,height);
        sb.end();
    }

    public void update(float delta){
    }
}
