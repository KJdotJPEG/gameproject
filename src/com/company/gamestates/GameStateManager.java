package com.company.gamestates;

import com.company.GamePanel;
import com.company.Vector2f;
import com.company.handlers.KeyHandler;

import java.awt.*;
import java.util.ArrayList;



// handles the game states (Play, Menu, Pause, Game Over)

public class GameStateManager  {

    private ArrayList<GameState> states;

    public static Vector2f map;

    //game states
    public static final int PLAY = 0;
    public static final int MENU = 1;
    public static final int PAUSE = 2;
    public static final int GAMEOVER = 3;

    public GameStateManager(){
        map = new Vector2f(GamePanel.width, GamePanel.height);
        Vector2f.setWorldVar(map.x,map.y);

        states = new ArrayList<GameState>();

        states.add(new PlayState(this));
    }

    public void pop(int state) {
        states.remove(state);
    }

    //adds states from other classes

    public void add(int state) {
        if (state == PLAY) {
            states.add(new PlayState(this));

        }
        if (state==MENU) {
            states.add(new MenuState(this));
        }
        if (state ==PAUSE) {
            states.add(new PauseState(this));
        }
        if (state == GAMEOVER) {
            states.add(new GameOverState(this));
        }
    }

    public void addAndpop(int state) {
        states.remove(0);
        add(state);
    }

    public void update() {
        for(int i = 0; i < states.size() ; i++){
            states.get(i).update();
        }

    }
    public void input (KeyHandler Key) {
        for (int i = 0; i < states.size(); i++) {
            states.get(i).input(Key);

        }
    }
    public void render(Graphics2D g) {
            for(int i = 0; i < states.size() ; i++){
                states.get(i).render(g);
            }
        }


}
