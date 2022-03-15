package com.company;

import java.awt.*;
import java.awt.image.BufferedImage;

// anything that can move goes here (enemies, player, etc.)
public abstract class Entity {

    private final int up = 0;
    private final int down = 1;
    private final int left = 2;
    private final int right = 3;

    protected Animation ani;
    protected Sprite sprite;
    protected Vector2f pos;
    protected int size;

    private int currentAnimation;

    protected boolean up;
    protected boolean down;
    protected boolean left;
    protected boolean right;
    protected boolean attack;
    protected int attackspeed;
    protected int attacktime;

    protected float directionspeedx;
    protected float directionspeedy;

    protected float maxspeed;
    protected float acceleration;
    protected float deceleration;


    public Entity(Sprite sprite, Vector2f origin, int size) {
        this.sprite = sprite;
        pos = origin;
        this.size = size;

        ani = new Animation();
        setAnimation(right, sprite.getSpriteArray(right), 10);

    }
    public void setAnimation(int i, BufferedImage[] frames, int delay) {
        currentAnimation = i;
        ani.setFrames(frames);
        ani.setDelay(delay);

    }

    public void update() {
        animate();
        setHitBoxDirection();
        ani.update();
    }

    public abstract void render(Graphics2D g);
    public void input(KeyHandler key){} //update this if mousehandler is going to be added

    public void animate() {
        if (up){
            if(currentAnimation != up || ani.getDelay() == -1) {
                setAnimation(up,sprite.getSpriteArray(up), 5);
            }
        }
        else if (down){
            if(currentAnimation != down || ani.getDelay() == -1) {
                setAnimation(down,sprite.getSpriteArray(down), 5);
            }
        }
        else if (left){
            if(currentAnimation != left || ani.getDelay() == -1) {
                setAnimation(left,sprite.getSpriteArray(left), 5);
            }
        }
        else if (right){
            if(currentAnimation != right || ani.getDelay() == -1) {
                setAnimation(right,sprite.getSpriteArray(right), 5);
            }
        }
        else {
            setAnimation(currentAnimation, sprite.getSpriteArray(currentAnimation), -1);
        }
    }
}
