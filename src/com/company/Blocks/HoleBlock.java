package com.company.Blocks;

import com.company.Collisions;
import com.company.Vector2f;
import com.company.graphics.Sprite;

import java.awt.*;
import java.awt.Graphics2D;

import java.awt.image.BufferedImage;


public class HoleBlock extends Block {

    public HoleBlock(Sprite img, Vector2f pos, int w, int h) {
        super(img, pos, w, h);
    }

    public boolean update(Collisions p) {
        return false;
    }

    public Sprite getImage() {
        return img;
    }

    public boolean isInside(Collisions p) {

        if(p.getpos().x + p.getXOffset() < pos.x) return false;
        if(p.getpos().y + p.getYOffset() < pos.y) return false;
        if(w + pos.x < p.getWidth() + (p.getpos().x + p.getXOffset())) return false;
        if(h + pos.y < p.getHeight() + (p.getpos().y + p.getYOffset())) return false;

        return true;
    }

    public void render(Graphics2D g){
        super.render(g);

    }



}
