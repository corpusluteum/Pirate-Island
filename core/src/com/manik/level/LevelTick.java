package com.manik.level;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.manik.imageLoader.ImageLoader;




public class LevelTick {


    private float xKord;
    private float yKord;
    private float width;
    private float height;


    private Rectangle collisionRect;

    public LevelTick(float xKord, float yKord, float width, float height){
        this.xKord=xKord;
        this.yKord=yKord;
        this.width=width;
        this.height=height;

        collisionRect=new Rectangle(xKord, yKord, width, height);

    }

    public void render(SpriteBatch sb){

        sb.begin();
        sb.draw(ImageLoader.mapRegion,xKord,yKord,width,height);
        sb.end();
    }

    public void update(float delta){
        collisionRect.x=xKord;
        collisionRect.y=yKord;
        collisionRect.width= width;
        collisionRect.height=height;

    }

    public Rectangle getCollisionRect() {
        return collisionRect;
    }

    public void setCollisionRect(Rectangle collisionRect) {
        this.collisionRect = collisionRect;
    }
}
