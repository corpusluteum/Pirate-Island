package com.manik.gameObject;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.manik.imageLoader.ImageLoader;



public class Bullet implements GameObject {

    private Vector2 bulletPosition;
    private Vector2 size;
    private Vector2 speed;

    private Rectangle collisionRect;

    public Bullet(float xKord, float yKord)
    {
        bulletPosition=new Vector2();
        size=new Vector2(20,10);
        speed=new Vector2(600,0);
        bulletPosition.x=xKord;
        bulletPosition.y=yKord;
        collisionRect=new Rectangle(bulletPosition.x,bulletPosition.y,size.x,size.y);
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();

        sb.draw(ImageLoader.bulletRegion,bulletPosition.x,bulletPosition.y,size.x,size.y);

        sb.end();
    }

    @Override
    public void update(float delta) {
        bulletPosition.add(speed.cpy().scl(delta));
        collisionRect.x=bulletPosition.x;
        collisionRect.y=bulletPosition.y;
    }

    public Rectangle getCollisionRect() {
        return collisionRect;
    }

    public Vector2 getBulletPosition() {
        return bulletPosition;
    }
}
