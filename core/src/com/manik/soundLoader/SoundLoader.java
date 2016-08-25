package com.manik.soundLoader;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;



public class SoundLoader {

    public static Sound bangSoundPlayer;
    public static Sound bisey;
    public static Sound hepy;
    public static Sound dead;
    public static Sound playSound;
    public static Sound hitBullet;
    public static Sound gameOver;

    public static void load(){
        bangSoundPlayer = Gdx.audio.newSound(Gdx.files.internal("soundEffect/bang0.wav"));
        bisey = Gdx.audio.newSound(Gdx.files.internal("soundEffect/bisey.wav"));
        hepy = Gdx.audio.newSound(Gdx.files.internal("soundEffect/hepy.wav"));
        dead = Gdx.audio.newSound(Gdx.files.internal("soundEffect/dead.wav"));
        playSound = Gdx.audio.newSound(Gdx.files.internal("soundEffect/pla.wav"));
        hitBullet = Gdx.audio.newSound(Gdx.files.internal("soundEffect/hit.wav"));
        gameOver=Gdx.audio.newSound(Gdx.files.internal("soundEffect/gameOver.wav"));
    }
    public static void dispose(){
        bangSoundPlayer.dispose();
        bisey.dispose();
        hepy.dispose();
        dead.dispose();
        playSound.dispose();
        hitBullet.dispose();
        gameOver.dispose();
    }
}
