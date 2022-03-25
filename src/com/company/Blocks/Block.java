package com.company.Blocks;

import java.awt.Graphics2D;

import java.awt.image.BufferedImage;

import com.company.graphics.Sprite;
import com.company.Vector2f;
import com.company.Collisions;

public abstract class Block {
    protected int w;
    protected int h;

    public Sprite img;
    public Vector2f pos;

    public Block(Sprite img, Vector2f pos, int w, int h) {
        this.img = img;
        this.pos = pos;
        this.w = w;
        this.h = h;
    }

    public int getWidth() { return w; }
    public int getHeight() { return h; }

    public abstract boolean update(Collisions p);
    public abstract boolean isInside(Collisions p);

    public abstract Sprite getImage();
    public Vector2f getPos() { return pos; }

    public void render(Graphics2D g) {
        g.drawImage(img.image, (int) pos.getWorldVar().x, (int) pos.getWorldVar().y, w, h, null);

    }
}
