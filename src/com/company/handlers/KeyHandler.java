package com.company.handlers;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import com.company.GamePanel;


//handles the key presses, holds and releases

public class KeyHandler implements KeyListener { //keylistener keeps track of presses and toggles on the keyboard

    public static List<Key> keys = new ArrayList<Key>();

    public class Key {
        public int presses, absorbs;
        public boolean down, clicked;

        public Key() {
            keys.add(this);
        }


        public void toggle(boolean pressed) { //when a key has been pressed and released
            if(pressed != down) {
                down = pressed;
            }
            if (pressed) {
                presses++;
            }
        }


        public void tick() { // if a key has been clicked or not (different to pressed)
            if(absorbs < presses){
                absorbs++;
                clicked = true;

            }else{
                clicked = false;
            }
        }
    }


    //key variables
    public Key up = new Key();
    public Key down = new Key();
    public Key left = new Key();
    public Key right = new Key();
    public Key attack = new Key();
    public Key menu = new Key();
    public Key enter = new Key();
    public Key escape = new Key();


    public KeyHandler(GamePanel game) {
        game.addKeyListener(this);

    }


    public void ReleaseAll() {
        for(int i = 1; i < keys.size(); i++) {
            keys.get(i).down = false;
        }
    }

    public void tick() {
        for(int i = 0; i < keys.size(); i++){
            keys.get(i).tick();
        }
    }

//key variables being set to a key event (which is just an allocated action)

    public void toggle(KeyEvent e, boolean pressed) { //keybinds
        if(e.getKeyCode() == KeyEvent.VK_W) up.toggle(pressed);
        if(e.getKeyCode() == KeyEvent.VK_A) left.toggle(pressed);
        if(e.getKeyCode() == KeyEvent.VK_S) down.toggle(pressed);
        if(e.getKeyCode() == KeyEvent.VK_D) right.toggle(pressed);
        if(e.getKeyCode() == KeyEvent.VK_F1) escape.toggle(pressed);
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE) menu.toggle(pressed);
        if(e.getKeyCode() == KeyEvent.VK_ENTER) enter.toggle(pressed);
        if(e.getKeyCode() == KeyEvent.VK_J) attack.toggle(pressed);
    }


    @Override
    public void keyTyped(KeyEvent e) {
        //does nothing currently

    }
    @Override
    public void keyPressed(KeyEvent e) { //sets action to true when key is pressed
        toggle(e, true);

    }
    @Override
    public void keyReleased(KeyEvent e) { //sets action to false when said key is released
        toggle (e, false);

    }

}
