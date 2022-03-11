package com.company;


import javax.swing.JFrame;

//handles the opening, closing and resolution of the window that opens when the program is running

public class Window extends JFrame {

    public Window() { //the window for the game thats running
        setTitle("shooter game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //closing tab stops program from running
        setContentPane(new GamePanel(1280,720)); //current resolution
        setResizable(false); //stays on false because the user can easily adjust the resolution without it

        pack();
        setLocationRelativeTo(null);
        setVisible(true); //makes window visible
    }
}
