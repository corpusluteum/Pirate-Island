package com.manik.handler;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;



public class MapStatusHandler {

    public static Preferences pref;

    public static void load(){

        pref = Gdx.app.getPreferences("PrateIsland");

        if(!pref.contains("MapStatus")){
            pref.putInteger("MapStatus",0);
        }
        if(!pref.contains("MapLevelOne")){
            pref.putBoolean("MapLevelOne",false);
        }
        if(!pref.contains("MapLevelTwo")){
            pref.putBoolean("MapLevelTwo",false);
        }
        if(!pref.contains("MapLevelThree")){
            pref.putBoolean("MapLevelThree",false);
        }
        if(!pref.contains("MapLevelFour")){
            pref.putBoolean("MapLevelFour",false);
        }
        if(!pref.contains("MapLevelFive")){
            pref.putBoolean("MapLevelFive",false);
        }
        if(!pref.contains("MapLevelSix")){
            pref.putBoolean("MapLevelSix",false);
        }
    }

    public static void setStatus(int levelStatus){

        if(levelStatus==1){
            pref.putBoolean("MapLevelOne",true);
            pref.putInteger("MapStatus",1);
        }
        if(levelStatus==2){
            pref.putBoolean("MapLevelTwo",true);
            pref.putInteger("MapStatus",2);
        }
        if(levelStatus==3){
            pref.putBoolean("MapLevelThree",true);
            pref.putInteger("MapStatus",3);
        }
        if(levelStatus==4){
            pref.putBoolean("MapLevelFour",true);
            pref.putInteger("MapStatus",4);
        }
        if(levelStatus==5){
            pref.putBoolean("MapLevelFive",true);
            pref.putInteger("MapStatus",5);
        }
        if(levelStatus==6){
            pref.putBoolean("MapLevelSix",true);
            pref.putInteger("MapStatus",6);
        }
        pref.flush();
    }

    public static int getStatus(){
        return pref.getInteger("MapStatus");
    }

    public static boolean getLevelOne(){
        return pref.getBoolean("MapLevelOne");
    }

    public static boolean getLevelTwo(){
        return pref.getBoolean("MapLevelTwo");
    }
    public static boolean getLevelThree(){
        return pref.getBoolean("MapLevelThree");
    }
    public static boolean getLevelFour(){
        return pref.getBoolean("MapLevelFour");
    }
    public static boolean getLevelFive(){
        return pref.getBoolean("MapLevelFive");
    }
    public static boolean getLevelSix(){
        return pref.getBoolean("MapLevelSix");
    }

    public static void levelRestart(){
        pref.putBoolean("MapLevelOne",false);
        pref.putBoolean("MapLevelTwo",false);
        pref.putBoolean("MapLevelThree",false);
        pref.putBoolean("MapLevelFour",false);
        pref.putBoolean("MapLevelFive",false);
        pref.putBoolean("MapLevelSix",false);
        pref.putInteger("MapStatus",0);
        pref.flush();
    }
}
