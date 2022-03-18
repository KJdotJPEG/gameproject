package com.company;

import com.company.gamestates.GameStateManager;
import com.company.handlers.KeyHandler;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.BufferedImage;

// the main code (handles fps, resolution and graphics)

public class GamePanel extends JPanel implements Runnable {

    public static int width;
    public static int height;

    private Thread thread;
    private boolean running = false;

    private BufferedImage img;
    private Graphics2D g;

    private KeyHandler Key;
    private GameStateManager gsm;

    public GamePanel(int width, int height){
        this.width = width;
        this.height = height;

        setPreferredSize(new Dimension(width,height));
        setFocusable(true);
        requestFocus();
    }

    public void addNotify() {
        super.addNotify();

        if (thread == null) {
            thread = new Thread(this, "Gamethread");
            thread.start();
        }
    }
    public void init(){
        running = true;

        img = new BufferedImage(width,height, BufferedImage.TYPE_INT_ARGB);
        g = (Graphics2D) img.getGraphics(); //graphics drawn onto the screen

        Key = new KeyHandler(this); //handles anything to do with the keyboard, and refers to the KeyHandler Class

        gsm = new GameStateManager(); //handles game states (e.g. game over, pause, etc.) in the GameStateManager Class


    }


// start of gameloop

    public void run(){ //fixed time gameloop here

        init();

        final double GAME_HERTZ = 60.0;
        final double TBU = 1000000000 / GAME_HERTZ; // TBU = time before update

        final int MUBR = 5; // MUBR = most updates before a render

        double LUT = System.nanoTime(); //LUT = last update time
        double LRT; //LRT = last render time

        final double TARGET_FPS = 60.0;
        final double TTBR = 1000000000 / TARGET_FPS; //TTBR = total time before render

        int framecount = 0;
        int lastsecondtime = (int) (LUT/1000000000);
        int oldframecount = 0;



        while(running) {
            double now = System.nanoTime();
            int updatecount = 0;

            while(((now - LUT)>TBU) && (updatecount < MUBR) ) { //checks if the game's hertz is on time
                update();
                input(Key);
                LUT += TBU;
                updatecount++;
            }

            if (now - LUT > TBU) {
                LUT = now - TBU;
            }

            input(Key);
            update();
            render();
            draw();
            LRT = now;
            framecount++;

            int thisSecond = (int) (LUT / 1000000000);
            if(thisSecond > LUT) {
                if (framecount != oldframecount) {
                    System.out.println("NEW SECOND " + thisSecond + " " + framecount);
                    oldframecount = framecount;
                }
                framecount = 0;
                lastsecondtime = thisSecond;
            }
            while(now - LRT < TTBR && now - LUT < TBU){
                Thread.yield();

                try{
                    Thread.sleep(1);
                }catch (Exception e) {
                    System.out.println(e);
                }

                now = System.nanoTime();
            }
        }

        }

        //end of gameloop





        public void update(){
        gsm.update();
        }
        public void input(KeyHandler Key){
        gsm.input(Key);
        }


        public void render(){ //this is what is drawing the black box onto the screen when it runs
            if (g != null) {
                g.setColor(new Color(80,80,80));
                g.fillRect(0,0,width,height); //fills a rectangle with the set parameters (which is the whole screen)
                gsm.render(g);

            }
        }

        public void draw(){
            Graphics g2 = (Graphics2D) this.getGraphics();
            g2.drawImage(img, 0, 0, width, height, null);
            g2.dispose(); //if this wasn't in the method, the image displaced would stay on screen.
        }

}
