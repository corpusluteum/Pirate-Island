package com.manik.gameObject;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.manik.imageLoader.ImageLoader;



public class Rock implements GameObject{


    private Vector2 rockPosition;
    private Vector2 size;
    private Rectangle collisionRect;
    private SpriteBatch spriteBatch;

    public Rock(float xKord)
    {
        size=new Vector2(50,50);
        rockPosition=new Vector2();
        rockPosition.x=xKord;
        rockPosition.y=Gdx.graphics.getHeight()-(Gdx.graphics.getHeight()/3)-
                (Gdx.graphics.getHeight()/12)+(Gdx.graphics.getHeight()/6)-20;
        collisionRect=new Rectangle(rockPosition.x,rockPosition.y,size.x,size.y);
    }

    @Override
    public void render(SpriteBatch sb) {
        this.spriteBatch=sb;
        spriteBatch.begin();
        spriteBatch.draw(ImageLoader.rockRegion,rockPosition.x,rockPosition.y,size.x,size.y);
        spriteBatch.end();
    }

    @Override
    public void update(float delta) {

    }

    public Vector2 getRockPosition() {
        return rockPosition;
    }

    public Rectangle getCollisionRect() {
        return collisionRect;
    }
}
