package com.company.assets.tilemap;

import java.awt.Graphics2D;

import com.company.Collisions;
import com.company.Blocks.Block;

public abstract class tilemap extends Tilemanager {

    public abstract Block[] getBlocks();
    public abstract void render(Graphics2D g, Collisions cam);

    public void render(Graphics2D g) {
        for(int i = 0; i < tm.size() ; i++) {
            tm.get(i).render(g);

        }
}}

