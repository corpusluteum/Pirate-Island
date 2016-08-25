package com.manik.level;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.manik.handler.MapStatusHandler;


public class LevelBoard {

    private int row;
    private int col;
    private float ara;
    private float xKord;
    private float yKord;
    private float width;
    private float height;


    private LevelMap[][] levelMaps;
    private LevelTick[][] levelTicks;

    public LevelBoard(int row, int col){

        this.row=row;
        this.col=col;
        ara= Gdx.graphics.getWidth()/10;
        xKord=ara;
        yKord=ara;
        width=Gdx.graphics.getWidth()/5;
        height=Gdx.graphics.getHeight()/4;
        levelMaps=new LevelMap[row][col];
        levelTicks=new LevelTick[row][col];
        initLevelMap();
    }

    public void render(SpriteBatch sb){
        for(int i=0;i<row;i++){
            for(int j=0; j<col; j++){
                levelMaps[i][j].render(sb);
            }
        }
        if(MapStatusHandler.getLevelOne()){
            levelTicks[0][0].render(sb);
        }
        if(MapStatusHandler.getLevelTwo()){
            levelTicks[0][1].render(sb);
        }
        if(MapStatusHandler.getLevelThree()){
            levelTicks[0][2].render(sb);
        }
        if(MapStatusHandler.getLevelFour()){
            levelTicks[1][0].render(sb);
        }
        if(MapStatusHandler.getLevelFive()){
            levelTicks[1][1].render(sb);
        }
        if(MapStatusHandler.getLevelSix()){
            levelTicks[1][2].render(sb);
        }

    }

    public void update(float delta){
        for(int i=0;i<row;i++){
            for(int j=0; j<col; j++){
                levelMaps[i][j].update(delta);
            }
        }
        if(MapStatusHandler.getLevelOne()){
            levelTicks[0][0].update(delta);
        }
        if(MapStatusHandler.getLevelTwo()){
            levelTicks[0][1].update(delta);
        }
        if(MapStatusHandler.getLevelThree()){
            levelTicks[0][2].update(delta);
        }
        if(MapStatusHandler.getLevelFour()){
            levelTicks[1][0].update(delta);
        }
        if(MapStatusHandler.getLevelFive()){
            levelTicks[1][1].update(delta);
        }
        if(MapStatusHandler.getLevelSix()){
            levelTicks[1][2].update(delta);
        }
    }

    public void initLevelMap(){
        int [] dizi={40, 150, 78, 134, 28, 125 ,-60, 50 ,-25, -45, 35, -15};
        for(int i=0;i<row;i++){
            for(int j=0; j<col; j++){
                levelMaps[i][j]=new LevelMap(xKord,yKord,width,height);
                levelTicks[i][j]=new LevelTick(xKord+70,yKord+20,width/2,height/2);
                xKord+=(dizi[i+j]+width);
                yKord+=dizi[8-(j+i)];
            }
            xKord=dizi[i];
            yKord+=(ara+height);
        }
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public LevelMap[][] getLevelMaps() {
        return levelMaps;
    }

    public LevelTick[][] getLevelTicks(){ return levelTicks; }
}
