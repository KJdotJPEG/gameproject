package com.company.Blocks;

import com.company.Collisions;
import com.company.Vector2f;
import com.company.graphics.Sprite;

import java.awt.*;

public class ObjBlock extends Block{

    public ObjBlock(Sprite img, Vector2f pos, int w, int h) {
        super(img, pos, w, h);
    }

    public boolean update(Collisions p) {
        return true;
    }
    public void render(Graphics2D g) {
        super.render(g);
        g.setColor(Color.white);
        g.drawRect((int) pos.getWorldVar().x, (int) pos.getWorldVar().y, w, h);
    }
}
