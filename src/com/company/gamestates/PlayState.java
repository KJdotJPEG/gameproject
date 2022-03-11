package com.company.gamestates;

import com.company.KeyHandler;
import com.company.Sprite;
import com.company.Vector2f;

import java.awt.*;

//when the main game is running

public class PlayState extends GameState {

    private com.company.Font font;

    public PlayState (GameStateManager gsm) {
        super(gsm);
        font = new com.company.Font("com/company/assets/Spritesheets/font-hand-24x32.png", 24,32);
    }

    public void update(){

    };
    public void input(KeyHandler Key){
        if (Key.up.down) {
            System.out.println("input : W");
        }
        if (Key.left.down) {
            System.out.println("input : A");
        }
        if (Key.right.down) {
            System.out.println("input : D");
        }
        if (Key.down.down) {
            System.out.println("input : S");
        }
        if (Key.escape.down) {
            System.out.println("input : F1");
        }
        if (Key.enter.down) {
            System.out.println("input : ENTER");
        }
        if (Key.menu.down) {
            System.out.println("input : ESCAPE");
        }
        if (Key.attack.down) {
            System.out.println("input : J ");
        }
    };


    public void render(Graphics2D g){
        Sprite.drawArray(g, font, " YOUR MUM ", new Vector2f(100,100), 32, 32, 32,0);
    };
}
