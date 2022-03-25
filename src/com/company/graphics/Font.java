package com.company.graphics;

import com.company.Vector2f;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

//class that loads fonts into the program while its running

public class Font {

        private BufferedImage FONTSHEET = null;
        private BufferedImage[][] fontArray;
        private final int TILE_SIZE = 32;
        public int w;
        public int h;
        private int wLetter;
        private int hLetter;

        public Font(String file) {
            w = TILE_SIZE;
            h = TILE_SIZE;

            System.out.println("Loading:" + file + " . . .");
            FONTSHEET = loadFont(file);

            wLetter = FONTSHEET.getWidth() / w;
            hLetter = FONTSHEET.getHeight()/h;
            loadSpriteArray();
        }

        public Font(String file, int w, int h) {
            this.w = w;
            this.h = h;

            System.out.println("loading: " + file + " . . . ");
            FONTSHEET = loadFont(file);

            wLetter = FONTSHEET.getWidth() / w;
            hLetter = FONTSHEET.getHeight()/h;

        }

        public void setSize(int width, int height) {
            setWidth(width);
            setHeight(height);

        }

        public void setWidth(int i) {
            w = i;
            wLetter = FONTSHEET.getWidth() / w; //total number of columns in spritesheet

        }

        public void setHeight(int i) {
            h = i;
            hLetter = FONTSHEET.getHeight() / h; //total number of rows in spritesheet
        }

        public int getWidth() { return w; }
        public int getHeight() { return h; }

        private BufferedImage loadFont(String file) {
            BufferedImage font = null;
            try {
                font = ImageIO.read(getClass().getClassLoader().getResourceAsStream(file));
            } catch (Exception e) {
                System.out.println("could not load file" + file);
            }
            return font;
        }

        public void loadSpriteArray() {
            fontArray = new BufferedImage[wLetter][hLetter];

            for (int x = 0; x < wLetter; x++){
                for(int y = 0; y < hLetter; y++){
                    fontArray[x][y] = getLetter(x,y);
                }
            }
        }
        public BufferedImage getFontSheet() {
            return FONTSHEET;
        }
        public BufferedImage getLetter(int x, int y) { return FONTSHEET.getSubimage(x*w,y*h,w,h);}

        public BufferedImage getFont(char letter) {
            int value = letter;

            int x = value % wLetter;
            int y = value / wLetter;
            System.out.println(x + "," + y);

            return FONTSHEET.getSubimage(x ,y ,w ,h);
        }

        public BufferedImage[] getFontArray(int i) {
            return fontArray[i];
        }

        public BufferedImage[][] getFontArray2(int i) {
            return fontArray;
        }

        public static void drawArray(Graphics2D g, ArrayList<BufferedImage> img, Vector2f pos, int width, int height, int xOffset, int yOffset) {
            float x = pos.x;
            float y = pos.y;

            for(int i = 0; i < img.size(); i++){
                if (img.get(i) != null) {
                    g.drawImage(img.get(i), (int) x, (int) y, width, height, null);
                }

                x+= xOffset;
                y += yOffset;

            }
        }

        public static void drawArray(Graphics2D g, Font f, String word, Vector2f pos, int width, int height, int xOffset, int yOffset) {
            float x = pos.y;
            float y = pos.y;

            for(int i = 0; i < word.length(); i++) { //cropping of letters in font file
                if (word.charAt(i) != 32){
                    g.drawImage(f.getFont(word.charAt(i)), (int) x, (int) y, width, height, null);
                }
                x += xOffset;
                y += yOffset;

            }
}}
