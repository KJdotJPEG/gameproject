package com.company.assets.tilemap;

import com.company.Blocks.HoleBlock;
import com.company.Blocks.Block;
import com.company.Blocks.ObjBlock;
import com.company.Collisions;
import com.company.Vector2f;
import com.company.graphics.Sprite;
import com.company.graphics.SpriteSheet;

import java.awt.*;
import java.util.HashMap;

import java.util.ArrayList;

import static com.company.GamePanel.height;

public class TileMapObj extends tilemap {

    public static Block[] event_blocks;

    private int tileWidth;
    private int tileHeight;

    public static int width;
    public static int height;

    public TileMapObj(String data, SpriteSheet sprite, int width, int height, int tileWidth, int tileHeight, int tileColumns) {
        Block tempBlock;
        event_blocks = new Block[width * height];

        this.tileWidth = tileWidth;
        this.tileHeight = tileHeight;

        TileMapObj.width = width;
        TileMapObj.height = height;

        String[] block = data.split(",");
        for(int i = 0; i < (width * height); i++) {
            int temp = Integer.parseInt(block[i].replaceAll("\\s+",""));
            if(temp != 0) {
                if(temp == 172) {
                    tempBlock = new HoleBlock(sprite.getSprite((int) ((temp - 1) % tileColumns), (int) ((temp - 1) / tileColumns) ), new Vector2f((int) (i % width) * tileWidth, (int) (i / height) * tileHeight), tileWidth, tileHeight);
                } else {
                    tempBlock = new ObjBlock(sprite.getSprite((int) ((temp - 1) % tileColumns), (int) ((temp - 1) / tileColumns) ), new Vector2f((int) (i % width) * tileWidth, (int) (i / height) * tileHeight), tileWidth, tileHeight);
                }
                event_blocks[i] = tempBlock;
            }
        }
    }

    public TileMapObj(String datum, Sprite sprite, int width, int height, int blockwidth, int blockheight, int tilecolumns) {
        super();
    }

    public Block[] getBlocks() { return event_blocks; }

    public void render(Graphics2D g, Collisions cam) {
        int x = (int) ((cam.getpos().x) / tileWidth);
        int y = (int) ((cam.getpos().y) / tileHeight);

        for(int i = x; i < x + (cam.getWidth() / tileWidth); i++) {
            for(int j = y; j < y + (cam.getHeight() / tileHeight); j++) {
                if(i + (j * height) > -1 && i + (j * height) < event_blocks.length && event_blocks[i + (j * height)] != null)
                    event_blocks[i + (j * height)].render(g);
            }

    }}}

