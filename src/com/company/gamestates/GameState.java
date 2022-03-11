package com.company.gamestates;

import java.awt.*;

// a secondary to game state manager that assists with rendering

public abstract class GameState {

    private GameStateManager gsm;
    public GameState (GameStateManager gsm){
        this.gsm = gsm;
    }
    public abstract void update();
    public abstract void input(com.company.KeyHandler Key);
    public abstract void render(Graphics2D g);


}
