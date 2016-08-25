package com.manik.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.manik.gameObject.GameWord;
import com.manik.gameObject.Rock;
import com.manik.soundLoader.SoundLoader;
import com.manik.states.PlayState;

import javax.swing.text.PlainDocument;


public class Controller {

    private OrthographicCamera camera;
    //cliked; ekrana basıldığını ve karakterin hareket edebileceğini simgeler.
    //jumpUpdate; zıplama işlemi bitmeden tekrar zıplanmasını engeller.
    // jump; zıplama işlemini simgeler, en yükseğe gelininceye kadar true olur.
    private boolean moveRight=true, moveLeft=false;
    private boolean jump=false , jumpUpdate=false;
    private boolean collisionRock=false;
    private float jumpHeight;
    private int i=0;
    private Vector2 direction;
    private GameWord gameWord;
    PlayState playState;
    private float beginTime=0, endTime=0;

    public Controller(GameWord gameWord, PlayState playState){
        this.gameWord=gameWord;
        this.playState=playState;
        camera=new OrthographicCamera();
        camera.setToOrtho(true, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        direction=new Vector2();
    }

    public void render(){
    }


    public void update(float delta){

        if(gameWord.getPlayer().isChangeDirection()){
            direction.x=0;
            gameWord.getPlayer().setChangeDirection(false);
        }
        //ekrana basıldığında ve zıplama işlemi yokken player x yönünde hareket eder.
        if(moveRight && jumpUpdate==false ){
            if(collisionRock){
                direction.x=10;
                if (beginTime == endTime) {
                    endTime = beginTime+3;
                }
                if(beginTime>endTime){
                    collisionRock=false;
                    beginTime=endTime;
                }
                else {
                    beginTime += delta;
                }
            }
            else {
                direction.x += 3;
            }
        }
        if(moveLeft && jumpUpdate==false){
            if(collisionRock){
                direction.x=(-10);
                if (beginTime == endTime) {
                    endTime = beginTime+3;
                }
                if(beginTime>endTime){
                    collisionRock=false;
                    beginTime=endTime;
                }
                else {
                    beginTime += delta;
                }
            }
            else {
                direction.x -= 3;
            }
        }


        //zıplama işlemi olduğunda
        if(jumpUpdate)
        {
            if(jump){
                //karakterin yukarıya çıkmasını sağlar. jumpHeight ile ne kadar yukarıya çıktığı hesaplanır.
                if (i < 30) {
                    direction.y -= 15;
                    jumpHeight-=1;
                    i++;
                }
                if (i == 30) {
                    jump = false;
                    i = 0;
                }
            }
            else{
                //sürekli azaltıldığı için sıfırlanması gerekir ki tekrar arttırılıp aşağıya inebilsin.
                if((direction.y)<0){
                    direction.y+=450;
                }
                //çıktığı kadar aşağıya inebilmesi için
                if(jumpHeight<0){
                    direction.y+=15;
                    jumpHeight+=1;
                }
                //işlem bittiğinden bir sonraki zıplama işlemi için hazırlanır
                else{
                    direction.y=0;
                    jumpUpdate=false;
                }

            }
        }
    }

    public void setMoveRight(boolean moveRight) { this.moveRight=moveRight; }

    public void setMoveLeft(boolean moveLeft) { this.moveLeft = moveLeft; }

    public boolean isMoveRight() {
        return moveRight;
    }

    public boolean isMoveLeft() {
        return moveLeft;
    }

    public Vector2 getDirection() {
        return direction;
    }

    public void setJump(boolean jump) {
        this.jump = jump;
    }

    public boolean isJumpUpdate() {
        return jumpUpdate;
    }

    public void setJumpUpdate(boolean jumpUpdate) {
        this.jumpUpdate = jumpUpdate;
    }

    public void setCollisionRock(boolean collisionRock) {
        this.collisionRock = collisionRock;
    }

    public PlayState getPlayState() {
        return playState;
    }
}
