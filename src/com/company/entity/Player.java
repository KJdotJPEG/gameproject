package com.company.entity;

import com.company.Vector2f;
import com.company.graphics.Sprite;
import com.company.handlers.KeyHandler;

import java.awt.*;

public class Player extends Entity {

    public Player(Sprite sprite, Vector2f origin, int size) {
        super(sprite, origin, size);
    }

    public void move() {
        if (Up) {
            directionspeedy -= acceleration;
            if(directionspeedy < -maxspeed) {
                directionspeedy = -maxspeed;
            }
        } else {
            if (directionspeedy < 0) {
                directionspeedy += deceleration;
                if(directionspeedy > 0) {
                    directionspeedy = 0;
                }
            }

        }
        if (Down) {
            directionspeedy += acceleration;
            if(directionspeedy < maxspeed) {
                directionspeedy = maxspeed;
            }
        } else {
            if (directionspeedy > 0) {
                directionspeedy -= deceleration;
                if(directionspeedy < 0) {
                    directionspeedy = 0;
                }
            }

        }
        if (Left) {
            directionspeedx -= acceleration;
            if(directionspeedx < -maxspeed) {
                directionspeedx = -maxspeed;
            }
        } else {
            if (directionspeedx < 0) {
                directionspeedx += deceleration;
                if(directionspeedx > 0) {
                    directionspeedx = 0;
                }
            }

        }
        if (Right) {
            directionspeedx += acceleration;
            if(directionspeedx > maxspeed) {
                directionspeedx = maxspeed;
            }
        } else {
            if (directionspeedx > 0) {
                directionspeedx -= deceleration;
                if(directionspeedx < 0) {
                    directionspeedx = 0;
                }
            }

        }
    }

    public void update() {
        super.update();
        move();
        pos.x += directionspeedx;
        pos.y += directionspeedy;
    }

    @Override
    public void render(Graphics2D g) {
        g.drawImage(ani.getImage(), (int) (pos.x), (int) (pos.y), size, size, null);
    }

    public void input(KeyHandler key) {

        //If you want mouse inputs: if (mouse.getButton() == 1) {
        //System.out.println("Player: " + pos.x + "," + pos.y);
        //}

        if (key.up.down) {
            Up = true;
        } else {
            Up = false;
        }


        if (key.down.down) {
            Down = true;
        }else{
            Down = false;
        }


         if (key.left.down) {
            Left = true;
        }else{
             Left = false;
         }


         if (key.right.down) {
             Right = true;
        } else {
             Right = false;
         }


         if (key.attack.down) {
             attack = true;
        } else {
             attack = false;
         }
    }
}
