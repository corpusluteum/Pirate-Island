package com.manik.gameObject;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.manik.controller.Controller;
import com.manik.imageLoader.ImageLoader;


public class Player implements GameObject{

    private Vector2 position;
    private Vector2 speed;
    private Vector2 maxSpeedRight;
    private Vector2 maxSpeedLeft;
    private Vector2 size;

    private boolean changeDirection=false;

    private Rectangle collisionRect;

    private Vector2 direction;
    private Controller controller;
    private SpriteBatch sb;
    private int character=1;

    public Player(float xKordinat, float yKordinat, float width, float height, Controller controller)
    {
        sb= new SpriteBatch();
        this.controller=controller;
        size=new Vector2(width,height);
        position= new Vector2(xKordinat,yKordinat);
        speed=new Vector2(0,0);
        maxSpeedRight=new Vector2(5,-15);
        maxSpeedLeft=new Vector2(-5,-15);
        direction=new Vector2();
        collisionRect=new Rectangle(position.x,position.y, size.x,size.y);
    }

    @Override
    public void render(SpriteBatch sb) {
        this.sb=sb;
    }

    @Override
    public void update(float delta) {

        sb.begin();

        if(controller.isMoveRight()){
            if (character < 10) {
                sb.draw(ImageLoader.playerRegion1, position.x, position.y, size.x, size.y);
                character++;
            } else if (character < 20) {
                sb.draw(ImageLoader.playerRegion2, position.x, position.y, size.x, size.y);
                character++;
            } else if (character < 30) {
                sb.draw(ImageLoader.playerRegion3, position.x, position.y, size.x, size.y);
                character++;
            } else if (character < 40) {
                sb.draw(ImageLoader.playerRegion4, position.x, position.y, size.x, size.y);
                character++;
                if (character == 39) {
                    character = 1;
                }
            }
        }
        else {
            if (character < 10) {
                sb.draw(ImageLoader.playerRegion1, position.x, position.y, size.x, size.y);
                character++;
            } else if (character < 20) {
                sb.draw(ImageLoader.playerRegion2, position.x, position.y, size.x, size.y);
                character++;
            } else if (character < 30) {
                sb.draw(ImageLoader.playerRegion3, position.x, position.y, size.x, size.y);
                character++;
            } else if (character < 40) {
                sb.draw(ImageLoader.playerRegion4, position.x, position.y, size.x, size.y);
                character++;
                if (character == 39) {
                    character = 1;
                }
            }
        }

        sb.end();

        collisionRect.x=position.x;
        collisionRect.y=position.y;
        direction.x=controller.getDirection().x;
        direction.y=controller.getDirection().y;
        speed.x=direction.x/40;
        speed.y=direction.y/40;
        if((speed.x)>(maxSpeedRight.x)){
            speed.x=maxSpeedRight.x;
        }
        if((speed.x)<(maxSpeedLeft.x)){
            speed.x=maxSpeedLeft.x;
        }
        position.add(speed);
    }

    public Vector2 getPosition() {
        return position;
    }

    public Vector2 getSpeed() {
        return speed;
    }

    public Rectangle getCollisionRect() {
        return collisionRect;
    }

    public boolean isChangeDirection() {
        return changeDirection;
    }

    public void setChangeDirection(boolean changeDirection) {
        this.changeDirection = changeDirection;
    }
}
