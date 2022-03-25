package com.company.assets.tilemap;

import java.awt.Graphics2D;

import com.company.Collisions;
import com.company.Blocks.Block;

public abstract class tilemap {

    public abstract Block[] getBlocks();
    public abstract void render(Graphics2D g, Collisions cam);

}
