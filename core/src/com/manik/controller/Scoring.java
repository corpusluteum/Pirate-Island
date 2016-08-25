package com.manik.controller;


import com.manik.states.PlayState;



public class Scoring {

    private PlayState playState;

    private boolean bigBooty;

    private int gold=0;
    private int eat=0;
    private int bullet=10;
    private int power=100;

    private int enemyPower=2;


    public Scoring(PlayState playState){

        this.playState=playState;

    }

    public void render(){

    }

    public void update(float delta){

        //ganimet kontrolü
        if(playState.getGameWord().getGoldHandler().isPlayerCollision()){
            if(bigBooty){
                eat=eat+4;
                gold=gold+3;
            }
            else{
                eat=eat+2;
                gold=gold+2;
            }
        }

        //cephane kontrolü
        if(playState.getGameWord().getPlayerFireHandler().isBang())
        {
           if(bullet>0){
               bullet--;
           }
           else if(gold>0) {
               if(gold>2){
                   bullet=(gold-2)*3;
                   gold=2;
               }
               else{
                   bullet=gold*3;
                   gold=0;
               }
           }
            else{
               playState.getGameWord().getPlayerFireHandler().setBullet(false);
           }
        }
        //güc kontrolü
        if(playState.isPlayerBulletCollision()){
             power=power-10;
             if(power<10){
                if(eat>0){
                    power=10+(eat*5);
                    eat=0;
                }
                else {
                    power = power - 5;
                    playState.setGameOver(true);
                }
            }
            playState.setPlayerBulletCollision(false);
        }

        //düşman gücü kontrolü
        if(playState.isEnemyCollision()){
            if(enemyPower>0){
                enemyPower--;
            }
            else {
                enemyPower = ((int) (Math.random() * 9 + 1)) / 2;
                playState.setEnemyForce(true);
                if(enemyPower>=2){
                    bigBooty=true;
                }
                else bigBooty=false;
            }
            playState.setEnemyCollision(false);
        }

        playState.setGoldScore(gold);
        playState.setBulletScore(bullet);
        playState.setPower(power);
        playState.getGameWord().getGoldHandler().setWichgold(bigBooty);
    }

}
