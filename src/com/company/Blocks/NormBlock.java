package com.company.Blocks;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.company.Vector2f;
import com.company.Collisions;
import com.company.graphics.Sprite;

public class NormBlock extends Block {

    public NormBlock(Sprite img, Vector2f pos, int w, int h) {
        super(img, pos, w, h);

        img.setEffect(Sprite.effect.DECAY);
    }

    public boolean update(Collisions p) {
        return false;
    }

    public boolean isInside(Collisions p) {
        return false;
    }

    public Sprite getImage() { return img; }

    public void render(Graphics2D g){
        super.render(g);
    }

    public String toString() {
        return "position: " + pos;
    }
}