package com.company.assets.tilemap;

import com.company.Blocks.NormBlock;
import com.company.Collisions;
import com.company.Vector2f;
import com.company.graphics.Sprite;
import com.company.Blocks.Block;

import java.awt.*;
import java.util.ArrayList;

public class TileMapNorm extends tilemap {

    public Block[] blocks;

    private int tileWidth;
    private int tileHeight;
    private int height;

    public TileMapNorm(String data, Sprite sprite, int width, int height, int tilewidth, int tileheight, int tilecolumns) {
        blocks = new Block[width * height];

        this.tileWidth = tileWidth;
        this.tileHeight = tileHeight;

        this.height = height;

        String[] block = data.split(",");

        for(int i = 0; i < (width * height); i++) {
            int temp = Integer.parseInt(block[i].replaceAll("\\s+",""));
            if (temp != 0) {
                blocks[i] = new NormBlock(sprite.getNewSprite((int) ((temp - 1) % tilecolumns), (int) ((temp - 1) / tilecolumns) ), new Vector2f((int) (i % width) * tileWidth, (int) (i / height) * tileHeight), tileWidth, tileHeight);

            }

        }
    }

    @Override
    public Block[] getBlocks() {
        return new Block[0];
    }

    public void render(Graphics2D g, Collisions cam) {
        int x = (int) ((cam.getpos().x) / tileWidth);
        int y = (int) ((cam.getpos().y) / tileHeight);

        for(int i = x; i < x + (cam.getWidth() / tileWidth); i++) {
            for(int j = y; j < y + (cam.getHeight() / tileHeight); j++) {
                if(i + (j * height) > -1 && i + (j * height) < blocks.length && blocks[i + (j * height)] != null) {
                    blocks[i + (j * height)].render(g);
                }

    }
}}}