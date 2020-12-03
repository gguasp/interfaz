package Interfaz;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    public static Canvas viewer;
    private ControlPanel controlPanel;

    public Frame(int width, int height){
        this.setSize(width, height);
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        viewer = new Canvas();
        controlPanel = new ControlPanel(viewer);


        gbc.gridx=0;
        gbc.gridy=0;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        gbc.weightx=0;
        gbc.weighty=0;
        gbc.fill=GridBagConstraints.BOTH;
        add(controlPanel,gbc);

        gbc.gridx=1;
        gbc.gridy=0;
        gbc.gridwidth=2;
        gbc.gridheight=1;
        gbc.weightx=1;
        gbc.weighty=1;
        gbc.fill=GridBagConstraints.BOTH;
        add(viewer,gbc);



        this.setVisible(true);

    }

}
