package Interfaz;

import javax.swing.*;
import java.awt.*;


public class ControlPanel extends JPanel {
    private JButton fileButton;
    private Viewer viewer;
    private JButton image1;
    private JButton image2;
    private JButton image3;
    private JButton todo;
    private JButton recuadro;
    private JSlider sliderTamaño;
    private JButton resetBrillo;
    private JSlider brillo;
    private JSlider sliderRed;
    private JSlider sliderGreen;
    private JSlider sliderBlue;
    private GridBagConstraints gbc = new GridBagConstraints();



    public ControlPanel(){
        super();
        this.setBackground(Color.red);
        this.setLayout(new GridBagLayout());
        addFileButton();
        addImageChooser();
        this.setVisible(true);
    }

    public void addFileButton(){
        this.fileButton = new JButton("Inserte archivo:");
        JLabel labelFile = new JLabel("Archivo");

        gbc.gridx=0;
        gbc.gridy=0;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx=0.5;
        gbc.weighty=0.5;
        gbc.anchor= GridBagConstraints.NORTH;
        this.add(labelFile,gbc);

        gbc.gridx=1;
        gbc.gridy=0;
        gbc.gridheight=1;
        gbc.gridwidth=3;
        gbc.fill = GridBagConstraints.NONE;
        this.add(fileButton,gbc);
    }

    public void addImageChooser(){
        JLabel labelImageChooser = new JLabel("Imágenes");
        this.image1 = new JButton("Imagen 1");
        this.image2 = new JButton("Imagen 2");
        this.image3 = new JButton("Imagen 3");

        gbc.gridx=1;
        gbc.gridy=0;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx=0.5;
        gbc.weighty=0.5;
        this.add(labelImageChooser,gbc);

        gbc.gridx=1;
        gbc.gridy=1;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        this.add(image1,gbc);

        gbc.gridx=1;
        gbc.gridy=2;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        this.add(image2,gbc);

        gbc.gridx=1;
        gbc.gridy=3;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        this.add(image3,gbc);

    }
}
