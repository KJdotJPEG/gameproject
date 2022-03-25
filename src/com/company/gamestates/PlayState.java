package com.company.gamestates;

import com.company.GamePanel;
import com.company.assets.tilemap.Tilemanager;
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
    private Tilemanager tm;

    public PlayState (GameStateManager gsm) {
        super(gsm);
        tm = new Tilemanager("tilemap/tilemap.xml");
        font = new Font("com/company/assets/Spritesheets/font.png", 10,10);
        player = new Player(new Sprite( "com/company/assets/Spritesheets/placeholderspritesheet.png"), new Vector2f(300,300), 100);
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
        tm.render(g);
        Font.drawArray(g, font, GamePanel.oldframecount + " FPS", new Vector2f(GamePanel.width - 192,32), 32, 32, 28,0);
        player.render(g);
    };
}
