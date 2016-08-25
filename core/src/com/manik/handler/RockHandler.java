package com.manik.handler;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.particles.influencers.ColorInfluencer;
import com.manik.gameObject.Rock;
import com.manik.states.PlayState;

import java.util.ArrayList;
import java.util.Random;



public class RockHandler {

    private ArrayList<Rock> rockList;
    private PlayState playState;
    int xKord;
    private float beginTime=0, endTime;
    private Random rnd;
    private SpriteBatch spriteBatch;

    public RockHandler(PlayState playState)
    {
        this.playState=playState;
        rockList=new ArrayList<Rock>();
        xKord=Gdx.graphics.getWidth();
        rockList.add(new Rock(xKord));
        rnd=new Random();
    }

    public void render(SpriteBatch spriteBatch)
    {
        this.spriteBatch=spriteBatch;
        for(int i=0; i<rockList.size(); i++){
            rockList.get(i).render(spriteBatch);
        }
    }

    public void update(float delta)
    {
        for(int i=0; i<rockList.size(); i++){
            rockList.get(i).update(delta);
        }
        if(playState.getLevelStatus()==1){
            if(rockList.size()<10) {
                if (beginTime > endTime) {
                    xKord += rnd.nextInt(1000) + (Gdx.graphics.getHeight())+((Gdx.graphics.getHeight()/3)*2);
                    rockList.add(new Rock(xKord));
                    beginTime = endTime;
                    endTime = beginTime+ 5;
                } else {
                    beginTime += delta;
                }
            }
        }
        else if(playState.getLevelStatus()==2){
            if(rockList.size()<10) {
                if (beginTime > endTime) {
                    xKord += rnd.nextInt(900) +  (Gdx.graphics.getHeight())+((Gdx.graphics.getHeight()/3)*2);
                    rockList.add(new Rock(xKord));
                    beginTime = endTime;
                    endTime = beginTime+ 5;
                } else {
                    beginTime += delta;
                }
            }
        }
        else if(playState.getLevelStatus()==3){
            if(rockList.size()<10) {
                if (beginTime > endTime) {
                    xKord += rnd.nextInt(800) +  (Gdx.graphics.getHeight())+((Gdx.graphics.getHeight()/3));
                    rockList.add(new Rock(xKord));
                    beginTime = endTime;
                    endTime = beginTime+ 5;
                } else {
                    beginTime += delta;
                }
            }
        }
        else if(playState.getLevelStatus()==4){
            if(rockList.size()<10) {
                if (beginTime > endTime) {
                    xKord += rnd.nextInt(600) +  (Gdx.graphics.getHeight())+((Gdx.graphics.getHeight()/3));
                    rockList.add(new Rock(xKord));
                    beginTime = endTime;
                    endTime = beginTime+ 5;
                } else {
                    beginTime += delta;
                }
            }
        }
        else if(playState.getLevelStatus()==5){
            if(rockList.size()<10) {
                if (beginTime > endTime) {
                    xKord += rnd.nextInt(500) +  (Gdx.graphics.getHeight());
                    rockList.add(new Rock(xKord));
                    beginTime = endTime;
                    endTime = beginTime+ 5;
                } else {
                    beginTime += delta;
                }
            }
        }
        else if(playState.getLevelStatus()==6){
            if(rockList.size()<10) {
                if (beginTime > endTime) {
                    xKord += rnd.nextInt(300) + (Gdx.graphics.getHeight());
                    rockList.add(new Rock(xKord));
                    beginTime = endTime;
                    endTime = beginTime+ 5;
                } else {
                    beginTime += delta;
                }
            }
        }

    }

    public ArrayList<Rock> getRockList() {
        return rockList;
    }
}
