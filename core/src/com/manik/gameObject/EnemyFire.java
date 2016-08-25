package com.manik.gameObject;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.manik.imageLoader.ImageLoader;



public class EnemyFire implements GameObject{

    private Vector2 firePosition;
    private Vector2 size;
    private Vector2 speed;

    private Rectangle collisionRect;

    public EnemyFire(float xKord, float yKord)
    {
        firePosition=new Vector2();
        size=new Vector2(20,10);
        speed=new Vector2(-300,0);
        firePosition.x=xKord;
        firePosition.y=yKord;
        collisionRect=new Rectangle(firePosition.x,firePosition.y,size.x,size.y);
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();

        sb.draw(ImageLoader.bulletRegion,firePosition.x,firePosition.y,size.x,size.y);

        sb.end();
    }

    @Override
    public void update(float delta) {
        firePosition.add(speed.cpy().scl(delta));
        collisionRect.x=firePosition.x;
        collisionRect.y=firePosition.y;
    }

    public Rectangle getCollisionRect() {
        return collisionRect;
    }

    public Vector2 getFirePosition() {
        return firePosition;
    }
}
