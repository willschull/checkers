package checkers;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;

public class CheckerFrame extends JFrame implements ActionListener{
    
	JButton startButton=new JButton("Start Game");
    JPanel gamePanel=new StartPanel();
    // Constructs the frame
    CheckerFrame(){
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this); //changing the appearance of the frame
        }
        catch (Exception e) {
           //no need to handle exception as it only affect the appearance
        }
        // Setup the GUI
        setupGUI();
        new PlaySound("src//sounds//Start.wav").start();
    }

    private void setupGUI() {
        setLayout(null);
        //Set the bound of the panel. 400,401 makes the frame too thin
        gamePanel.setBounds(0,0,508,401);//400,401 
        //I have no idea what this is
        //gmP.imageUpdate(ne, WIDTH, WIDTH, WIDTH, WIDTH, WIDTH)
        add(gamePanel);
        
        //Create the start button, modify it, then add to the panel
        startButton.setHorizontalAlignment(SwingConstants.LEADING);
        startButton.setIcon(new ImageIcon(getClass().getResource("/images/checkersIcon.jpg")));
        startButton.setBackground(Color.LIGHT_GRAY);
        startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        startButton.setBounds(154,420,200,60);
        startButton.setFont(new Font("Times new roman",Font.BOLD,20));
        startButton.addActionListener(this);
        startButton.setFocusPainted(false);
        add(startButton);
        
        // 
        this.setIconImage(new ImageIcon(getClass().getResource("/images/icon.jpg")).getImage());
        setSize(508,520);
        setLocation((int)getToolkit().getScreenSize().getWidth()/2-254,(int)getToolkit().getScreenSize().getHeight()/2-310);
        setResizable(false);
        setVisible(true);
        setTitle("Play Checkers");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //When the user clicks Start Game, it loads the playable game through Checkers()
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equalsIgnoreCase("Start Game")){
            ((JButton)e.getSource()).setText("New Game");
            new PlaySound("src//sounds//button.wav").start();
            gamePanel=new Checkers();
            gamePanel.setBounds(0,0,508,401);
            this.setContentPane(gamePanel);
        }
    }
}
