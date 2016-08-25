package com.manik.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

/**
 * Created by manik on 2016.
 */
public class StateManager {

    private Stack<State> states;

    public StateManager(){
        states=new Stack<State>();
    }

    //peek son öğeyi döndür
    public void render(SpriteBatch sb){
        states.peek().render(sb);
    }

    public void update(float delta){
        states.peek().update(delta);
        states.peek().HandleInput();
    }

    public void pushState(State state){
        states.push(state);
    }

    public void popState(){
        states.pop();
    }
}
