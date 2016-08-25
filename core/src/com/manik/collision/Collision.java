package com.manik.collision;

import com.manik.gameObject.Enemy;
import com.manik.gameObject.Player;
import com.manik.gameObject.TreasureMap;
import com.manik.handler.EnemyFireHandler;
import com.manik.handler.EnemyHandler;
import com.manik.handler.GoldHandler;
import com.manik.handler.PlayerFireHandler;
import com.manik.handler.RockHandler;
import com.manik.states.PlayState;

public class Collision {


    //tek bir düşman için
    public static boolean isThereCollision(Player player, Enemy enemy){

        if(player.getCollisionRect().overlaps(enemy.getCollisionRect())){
            return true;
        }

        return false;
    }

    public static boolean isThereCollision(Player player, EnemyHandler enemyHandler){


        for(int i=0;i<enemyHandler.getEnemyList().size();i++){
            if(player.getCollisionRect().overlaps(enemyHandler.getEnemyList().get(i).getCollisionRect())){
                return true;
            }
        }

        return false;
    }

    public static boolean isThereCollision(PlayerFireHandler playerFireHandler, EnemyHandler enemyHandler) {
        for (int i = 0; i < enemyHandler.getEnemyList().size(); i++) {
            for (int j = 0; j < playerFireHandler.getBulletList().size(); j++) {
                if (enemyHandler.getEnemyList().get(i).getCollisionRect().overlaps(playerFireHandler.getBulletList().get(i).getCollisionRect())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isThereCollision(EnemyFireHandler enemyFireHandler, Player player){
        for(int i=0; i<enemyFireHandler.getFireList().size(); i++){
            if(player.getCollisionRect().overlaps(enemyFireHandler.getFireList().get(i).getCollisionRect())){
                return true;
            }
        }
        return false;
    }

    public static boolean isThereCollision(GoldHandler goldHandler, Player player){
        for(int i=0; i<goldHandler.getGoldList().size(); i++){
            if(player.getCollisionRect().overlaps(goldHandler.getGoldList().get(i).getCollisionRect())){
                return true;
            }
        }
        return false;
    }

    public static boolean isThereCollision(TreasureMap treasureMap, Player player){
        if(player.getCollisionRect().overlaps(treasureMap.getCollisionRect())){
            return true;
        }
        else return false;
    }

    public static boolean isThereCollision(RockHandler rockHandler, Player player){
        for(int i=0; i<rockHandler.getRockList().size(); i++){
            if(player.getCollisionRect().overlaps(rockHandler.getRockList().get(i).getCollisionRect())){
                return true;
            }
        }
        return false;
    }


}
