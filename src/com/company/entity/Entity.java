package com.company.entity;

import com.company.graphics.Animation;
import com.company.Collisions;
import com.company.graphics.Sprite;
import com.company.Vector2f;
import com.company.handlers.KeyHandler;

import java.awt.*;
import java.awt.image.BufferedImage;

// anything that can move goes here (enemies, player, etc.)
public abstract class Entity {

    private final int up = 0;
    private final int down = 1;
    private final int left = 3;
    private final int right = 2;

    protected Animation ani;
    protected Sprite sprite;
    protected Vector2f pos;
    protected int size;

    private int currentAnimation;

    protected boolean Up;
    protected boolean Down;
    protected boolean Left;
    protected boolean Right;
    protected boolean attack;
    protected int attackspeed;
    protected int attacktime;

    protected float directionspeedx;
    protected float directionspeedy;

    protected float maxspeed;
    protected float acceleration;
    protected float deceleration;

    protected Collisions hitBounds;
    protected Collisions bounds;



    public Entity(Sprite sprite, Vector2f origin, int size) {
        this.sprite = sprite;
        pos = origin;
        this.size = size;

        bounds = new Collisions(origin, size, size);
        hitBounds = new Collisions(new Vector2f(origin.x + (size / 2), origin.y), size, size); //offsets hitbounds

        ani = new Animation();
        setAnimation(right, sprite.getSpriteArray(right), 10);

    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    public void setSize(int i) { size = i;}
    public void setMaxSpeed(float f) {maxspeed = f; }
    public void setAcc(float f) {acceleration = f; }
    public void setDeacc(float f) {deceleration = f; }

    public Collisions getBounds() {return bounds; }

    public int getSize() { return size; }
    public Animation getAnimation() { return ani; }

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

    private void setHitBoxDirection() {
        if (Up) {
            hitBounds.setYoffset(-size / 2);
            hitBounds.setXoffset(-size / 2);

        }if (Left) {
            hitBounds.setXoffset(-size);
            hitBounds.setYoffset(0);

        }if (Right) {
            hitBounds.setXoffset(0);
            hitBounds.setYoffset(0);

        }if (Down) {
            hitBounds.setYoffset(size / 2);
            hitBounds.setXoffset(size / 2);

        }
    }

    public abstract void render(Graphics2D g);
    public void input(KeyHandler key){} //update this if mousehandler is going to be added

    public void animate() {
        if (Up){
            if(currentAnimation != up || ani.getDelay() == -1) {
                setAnimation(up,sprite.getSpriteArray(up), 5);
            }
        }
        else if (Down){
            if(currentAnimation != down || ani.getDelay() == -1) {
                setAnimation(down,sprite.getSpriteArray(down), 5);
            }
        }
        else if (Left){
            if(currentAnimation != left || ani.getDelay() == -1) {
                setAnimation(left,sprite.getSpriteArray(left), 5);
            }
        }
        else if (Right){
            if(currentAnimation != right || ani.getDelay() == -1) {
                setAnimation(right,sprite.getSpriteArray(right), 5);
            }
        }
        else {
            setAnimation(currentAnimation, sprite.getSpriteArray(currentAnimation), -1);
        }
    }
}
