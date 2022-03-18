package com.company.gamestates;

import com.company.entity.Player;
import com.company.graphics.Font;
import com.company.handlers.KeyHandler;
import com.company.graphics.Sprite;
import com.company.Vector2f;

import java.awt.*;

//when the main game is running

public class PlayState extends GameState {

    private Font font;
    private Player player;

    public PlayState (GameStateManager gsm) {
        super(gsm);
        font = new Font("com/company/assets/Spritesheets/font-hand-24x32.png", 24,32);
        player = new Player(new Sprite( "com/company/assets/Spritesheets/placeholderspritesheet.png"), new Vector2f(300,300), 32);
    }

    public void update(){
        player.update();

    };
    public void input(KeyHandler Key){
        player.input(Key);

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
        player.render(g);
    };
}
