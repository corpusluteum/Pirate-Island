package com.manik.gameObject;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.manik.imageLoader.ImageLoader;



public class Gold implements GameObject{

    private Vector2 goldPosition;
    private Vector2 size;
    private Rectangle collisionRect;
    private boolean bigGold=false;
    private SpriteBatch spriteBatch;

    public Gold(boolean bigGold, float xKord, float yKord)
    {
        this.bigGold=bigGold;
        size=new Vector2(60,60);
        goldPosition=new Vector2();
        goldPosition.x=xKord;
        goldPosition.y=yKord;
        collisionRect=new Rectangle(goldPosition.x,goldPosition.y,size.x,size.y);
    }

    @Override
    public void render(SpriteBatch sb) {
        this.spriteBatch=sb;
        spriteBatch.begin();
        if(bigGold){
            spriteBatch.draw(ImageLoader.bigBootyRegion,goldPosition.x,goldPosition.y,size.x,size.y);
        }
        else{
            spriteBatch.draw(ImageLoader.bootyRegion,goldPosition.x,goldPosition.y,size.x,size.y);
        }
        spriteBatch.end();
    }

    @Override
    public void update(float delta) {

    }

    public Vector2 getGoldPosition() {
        return goldPosition;
    }

    public Rectangle getCollisionRect() {
        return collisionRect;
    }
}
