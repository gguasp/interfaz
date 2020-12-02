package Interfaz;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControlPanel extends JPanel implements ActionListener, ChangeListener {
    private JButton fileButton;
    private Canvas viewer;
    private JButton image1;
    private JButton image2;
    private JButton image3;
    private JButton todo;
    private JButton recuadro;
    private JSlider sizeSlider;
    private JButton resetBrillo;
    private JSlider sliderBrillo;
    private JSlider sliderRed;
    private JSlider sliderGreen;
    private JSlider sliderBlue;
    private JButton greyConverter;
    private JSlider sliderFocus;
    private JButton aplicar;
    private GridBagConstraints gbc = new GridBagConstraints();

    public ControlPanel(Canvas viewer){
        super();
        this.setViewer(viewer);
        this.setBackground(Color.lightGray);
        this.setLayout(new GridBagLayout());
        addFileButton();
        addImageChooser();
        addBrilloRGB();
        addGreyConverter();
        addFilter();
        addListeners();
        this.setVisible(true);
    }

    public void addFileButton(){
        this.fileButton = new JButton("Inserte archivo:");
        fileButton.addActionListener(this);
        JLabel labelFile = new JLabel("Archivo");

        gbc.gridx=0;
        gbc.gridy=0;
        gbc.ipadx = 1;
        gbc.ipady = 1;
        this.add(labelFile,gbc);

        gbc.gridx=1;
        gbc.gridy=0;
        gbc.gridheight=3;
        gbc.gridwidth=3;
        gbc.fill = GridBagConstraints.BOTH;
        this.add(fileButton,gbc);

    }

    public void addImageChooser(){
        JLabel labelImageChooser = new JLabel("Imágenes");
        this.image1 = new JButton("Imagen 1");
        this.image2 = new JButton("Imagen 2");
        this.image3 = new JButton("Imagen 3");
        image1.addActionListener(this);
        image2.addActionListener(this);
        image3.addActionListener(this);


        gbc.gridx=0;
        gbc.gridy=3;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        gbc.weightx=1;
        gbc.weighty=1;

        this.add(labelImageChooser,gbc);

        gbc.gridx=1;
        gbc.gridy=3;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        gbc.weightx=1;
        gbc.weighty=1;
        this.add(image1,gbc);

        gbc.gridx=2;
        gbc.gridy=3;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        gbc.weightx=1;
        gbc.weighty=1;
        this.add(image2,gbc);

        gbc.gridx=3;
        gbc.gridy=3;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        gbc.weightx=1;
        gbc.weighty=1;
        this.add(image3,gbc);

    }

    public void addBrilloRGB(){
        JLabel brilloLabel = new JLabel("Brillo");
        this.resetBrillo = new JButton("Reset brillo");
        resetBrillo.addActionListener(this);
        JLabel totalLabel = new JLabel("Total");
        this.sliderBrillo = new JSlider();
        JLabel redLabel = new JLabel("Canal Rojo");
        this.sliderRed = new JSlider();
        JLabel greenLabel = new JLabel("Canal Verde");
        this.sliderGreen = new JSlider();
        JLabel blueLabel = new JLabel("Canal Azul");
        this.sliderBlue = new JSlider();

        gbc.gridx=0;
        gbc.gridy=4;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        gbc.weightx=1;
        gbc.weighty=1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.NORTH;
        this.add(brilloLabel,gbc);

        gbc.gridx=1;
        gbc.gridy=4;
        gbc.gridwidth=3;
        gbc.gridheight=1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        gbc.weighty = 1;

        this.add(resetBrillo,gbc);

        gbc.gridx=0;
        gbc.gridy=5;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        gbc.weightx=1;
        gbc.weighty=1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.NORTH;
        this.add(totalLabel,gbc);

        gbc.gridx=1;
        gbc.gridy=5;
        gbc.gridwidth=3;
        gbc.gridheight=1;
        gbc.weightx=1;
        gbc.weighty=1;
        this.add(sliderBrillo,gbc);

        gbc.gridx=0;
        gbc.gridy=6;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        gbc.weightx=1;
        gbc.weighty=1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.NORTH;
        this.add(redLabel,gbc);

        gbc.gridx=1;
        gbc.gridy=6;
        gbc.gridwidth=3;
        gbc.gridheight=1;
        gbc.weightx=1;
        gbc.weighty=1;
        this.add(sliderRed,gbc);

        gbc.gridx=0;
        gbc.gridy=7;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        gbc.weightx=1;
        gbc.weighty=1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.NORTH;
        this.add(greenLabel,gbc);

        gbc.gridx=1;
        gbc.gridy=7;
        gbc.gridwidth=3;
        gbc.gridheight=1;
        gbc.weightx=1;
        gbc.weighty=1;
        this.add(sliderGreen,gbc);

        gbc.gridx=0;
        gbc.gridy=8;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        gbc.weightx=1;
        gbc.weighty=1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.NORTH;
        this.add(blueLabel,gbc);

        gbc.gridx=1;
        gbc.gridy=8;
        gbc.gridwidth=3;
        gbc.gridheight=1;
        gbc.weightx=1;
        gbc.weighty=1;
        this.add(sliderBlue,gbc);

    }

    public void addGreyConverter(){
        this.greyConverter = new JButton("Convertir a gris");
        greyConverter.addActionListener(this);
        JLabel colorLabel = new JLabel("Color");

        gbc.gridx=0;
        gbc.gridy=9;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        gbc.weightx=1;
        gbc.weighty=1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.NORTH;
        this.add(colorLabel,gbc);

        gbc.gridx=1;
        gbc.gridy=9;
        gbc.gridwidth=3;
        gbc.gridheight=1;
        gbc.weightx=1;
        gbc.weighty=1;
        this.add(greyConverter,gbc);
    }

    public void addFilter(){
        this.sliderFocus = new JSlider();
        JLabel filtroLabel = new JLabel("Filtros");
        JLabel minSlider = new JLabel("Focus");
        JLabel maxSlider = new JLabel("Unfocus");
        this.aplicar = new JButton("Aplicar");
        aplicar.addActionListener(this);

        gbc.gridx=0;
        gbc.gridy=10;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        gbc.weightx=1;
        gbc.weighty=1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.NORTH;
        this.add(filtroLabel,gbc);

        gbc.gridx=0;
        gbc.gridy=11;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        gbc.weightx=1;
        gbc.weighty=1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.NORTH;
        this.add(minSlider,gbc);

        gbc.gridx=1;
        gbc.gridy=11;
        gbc.gridwidth=2;
        gbc.gridheight=1;
        gbc.weightx=1;
        gbc.weighty=1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.NORTH;
        this.add(sliderFocus,gbc);

        gbc.gridx=3;
        gbc.gridy=11;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        gbc.weightx=1;
        gbc.weighty=1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.NORTH;
        this.add(maxSlider,gbc);

        gbc.gridx=0;
        gbc.gridy=12;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        gbc.weightx=1;
        gbc.weighty=1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.NORTH;
        this.add(aplicar,gbc);
    }

    public void addListeners(){

        //Cambiar color rojo
        sliderRed.addChangeListener(new ChangeListener(){
            public void stateChanged(ChangeEvent e) {
                viewer.getCurrentImage().setRed(getSliderRed().getValue());
                viewer.getCurrentImage().changeRGB(viewer.getOriginalImage());
                viewer.repaint();
            }});

        //Cambiar color verde
        sliderGreen.addChangeListener(new ChangeListener(){
            public void stateChanged(ChangeEvent e) {
                viewer.getCurrentImage().setGreen(getSliderGreen().getValue());
                viewer.getCurrentImage().changeRGB(viewer.getOriginalImage());
                viewer.repaint();
            }});

        //Cambiar color azul
        sliderBlue.addChangeListener(new ChangeListener(){
            public void stateChanged(ChangeEvent e) {
                viewer.getCurrentImage().setBlue(getSliderBlue().getValue());
                viewer.getCurrentImage().changeRGB(viewer.getOriginalImage());
                viewer.repaint();
            }});

        //Cambiar brillo total
        sliderBrillo.addChangeListener(new ChangeListener(){
            public void stateChanged(ChangeEvent e) {
                viewer.getCurrentImage().setBrightness(getSliderBrillo().getValue());
                viewer.getCurrentImage().changeRGB(viewer.getOriginalImage());
                viewer.repaint();
            }});

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        switch (e.getActionCommand()){
            case "Inserte archivo:":

                FileDialog fileDialog = new FileDialog(new JFrame(),"Image choser", FileDialog.LOAD);
                fileDialog.setVisible(true);
                String path = fileDialog.getDirectory() + fileDialog.getFile();

                try {

                    Image imgTest = new Image(path);
                    viewer.setOriginalImage(imgTest);
                    imgTest = new Image(path);
                    viewer.setImage1(imgTest);
                    imgTest = new Image(path);
                    viewer.setImage2(imgTest);
                    imgTest = new Image(path);
                    viewer.setImage3(imgTest);

                } catch (Exception exc) {
                    System.out.println(exc);
                }

                viewer.repaint();
                break;
            case "Imagen 1":
                viewer.setCurrentImage(viewer.getImage1());
                System.out.println(viewer.getCurrentImage());
                break;
            case "Imagen 2":
                viewer.setCurrentImage(viewer.getImage2());
                break;
            case "Imagen 3":
                viewer.setCurrentImage(viewer.getImage3());
                break;
            case "Convertir a gris":
                viewer.getCurrentImage().setGray(!viewer.getCurrentImage().isGray());
                viewer.getCurrentImage().changeRGB((viewer.getOriginalImage()));
                viewer.repaint();
                break;
            case "Reset brillo":
                viewer.getCurrentImage().setBrightness(viewer.getOriginalImage().getBrightness());
                viewer.getCurrentImage().setBlue(viewer.getOriginalImage().getBlue());
                viewer.getCurrentImage().setRed(viewer.getOriginalImage().getRed());
                viewer.getCurrentImage().setGreen(viewer.getOriginalImage().getGreen());
                viewer.getCurrentImage().changeRGB(viewer.getOriginalImage());
                viewer.repaint();
                break;
            case "Aplicar":
                viewer.getCurrentImage().setFocus(getSliderFocus().getValue());
                viewer.getCurrentImage().changeFocus(viewer.getOriginalImage());
                viewer.repaint();
                break;
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {

    }



    public JButton getFileButton() {
        return fileButton;
    }

    public void setFileButton(JButton fileButton) {
        this.fileButton = fileButton;
    }

    public void setViewer(Canvas viewer) {
        this.viewer = viewer;
    }

    public JButton getImage1() {
        return image1;
    }

    public void setImage1(JButton image1) {
        this.image1 = image1;
    }

    public JButton getImage2() {
        return image2;
    }

    public void setImage2(JButton image2) {
        this.image2 = image2;
    }

    public JButton getImage3() {
        return image3;
    }

    public void setImage3(JButton image3) {
        this.image3 = image3;
    }

    public JButton getTodo() {
        return todo;
    }

    public void setTodo(JButton todo) {
        this.todo = todo;
    }

    public JButton getRecuadro() {
        return recuadro;
    }

    public void setRecuadro(JButton recuadro) {
        this.recuadro = recuadro;
    }

    public JSlider getSizeSlider() {
        return sizeSlider;
    }

    public void setSizeSlider(JSlider sizeSlider) {
        this.sizeSlider = sizeSlider;
    }

    public JButton getResetBrillo() {
        return resetBrillo;
    }

    public void setResetBrillo(JButton resetBrillo) {
        this.resetBrillo = resetBrillo;
    }

    public JSlider getSliderBrillo() {
        return sliderBrillo;
    }

    public void setSliderBrillo(JSlider sliderBrillo) {
        this.sliderBrillo = sliderBrillo;
    }

    public JSlider getSliderRed() {
        return sliderRed;
    }

    public void setSliderRed(JSlider sliderRed) {
        this.sliderRed = sliderRed;
    }

    public JSlider getSliderGreen() {
        return sliderGreen;
    }

    public void setSliderGreen(JSlider sliderGreen) {
        this.sliderGreen = sliderGreen;
    }

    public JSlider getSliderBlue() {
        return sliderBlue;
    }

    public void setSliderBlue(JSlider sliderBlue) {
        this.sliderBlue = sliderBlue;
    }

    public JButton getGreyConverter() {
        return greyConverter;
    }

    public void setGreyConverter(JButton greyConverter) {
        this.greyConverter = greyConverter;
    }

    public JSlider getSliderFocus() {
        return sliderFocus;
    }

    public void setSliderFocus(JSlider sliderFocus) {
        this.sliderFocus = sliderFocus;
    }

    public GridBagConstraints getGbc() {
        return gbc;
    }

    public void setGbc(GridBagConstraints gbc) {
        this.gbc = gbc;
    }

}
