package Interfaz;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    private ControlPanel controlPanel;
    private Viewer viewer;

    public Frame(int width, int height){
        super("Ventana");
        this.setSize(width, height);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        controlPanel = new ControlPanel();
        viewer = new Viewer();

        gbc.gridx=0;
        gbc.gridy=0;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        gbc.weightx=0;
        gbc.weighty=1.0;
        gbc.fill=GridBagConstraints.VERTICAL;
        add(controlPanel,gbc);

        gbc.gridx=1;
        gbc.gridy=0;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        gbc.weightx=1.0;
        gbc.weighty=1.0;
        gbc.fill=GridBagConstraints.BOTH;
        add(viewer,gbc);

        this.setVisible(true);

    }

}
