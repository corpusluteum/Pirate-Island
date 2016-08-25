package com.manik.gameObject;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.manik.imageLoader.ImageLoader;

import java.util.Random;


public class Enemy implements GameObject {

    private Vector2 position;
    private Vector2 size;
    private Vector2 speed;

    private Rectangle collisionRect;

    //tek bir düşman oluşturma işlemi için geçerli kod. Bunu kullanmayacaksın
    public Enemy(){
        position=new Vector2(Gdx.graphics.getWidth()/2,Gdx.graphics.getWidth());
        size=new Vector2(Gdx.graphics.getWidth()/5,Gdx.graphics.getHeight()/6);
        speed=new Vector2(100,-100);
        collisionRect=new Rectangle(position.x,position.y,size.x,size.y);
    }

    public Enemy(float xKord, float yKord)
    {
        position=new Vector2();
        size=new Vector2(Gdx.graphics.getWidth()/5,Gdx.graphics.getHeight()/6);
        speed=new Vector2(-50,0);
        position.x=xKord;
        position.y=yKord;
        collisionRect=new Rectangle(position.x,position.y,size.x,size.y);
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();

        sb.draw(ImageLoader.enemyRegion,position.x,position.y,size.x,size.y);

        sb.end();
    }

    @Override
    public void update(float delta) {
        position.add(speed.cpy().scl(delta));
        collisionRect.x=position.x;
        collisionRect.y=position.y;
    }

    public Rectangle getCollisionRect() {
        return collisionRect;
    }

    public Vector2 getPosition() {
        return position;
    }
}
