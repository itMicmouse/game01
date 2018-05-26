package com.yangyakun.game.handlers;

import com.yangyakun.game.MyGdxGame;
import com.yangyakun.game.states.GameState;
import com.yangyakun.game.states.Play;

import java.util.Stack;

public class GameStateManage {

    private MyGdxGame myGdxGame;

    private Stack<GameState> gameStates;

    public static final int PLAY = 1;

    public GameStateManage(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
        gameStates = new Stack<GameState>();
        pushState(PLAY);
    }

    public MyGdxGame getMyGdxGame() {
        return myGdxGame;
    }

    public void update(float dt){
        gameStates.peek().update(dt);
    }
    public void render(){
        gameStates.peek().render();
    }
    private GameState getState(int state){
        if(state==PLAY){
            return new Play(this);
        }
        return null;
    }
    public void setState(int state){
        popState();
        pushState(state);
    }
    public void pushState(int state){
        gameStates.push(getState(state));
    }
    public void popState(){
        GameState pop = gameStates.pop();
        pop.dispose();
    }
}
