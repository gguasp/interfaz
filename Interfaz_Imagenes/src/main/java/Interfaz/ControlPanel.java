package Interfaz;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


public class ControlPanel extends JPanel implements ActionListener, ChangeListener {

    private GridBagConstraints gbc = new GridBagConstraints();

    private int top = 3, left = 6, bottom = 3, right = 3;
    private Insets i = new Insets(top, left, bottom, right);

    private Canvas canvas;
    private JButton fileButton;
    private JTable table;
    private JToggleButton image1;
    private JToggleButton image2;
    private JToggleButton image3;
    private JToggleButton allButton;
    private JToggleButton clipButton;
    private JSlider sliderSize;
    private JButton resetBrillo;
    private JSlider sliderBrillo;
    private JSlider sliderRed;
    private JSlider sliderGreen;
    private JSlider sliderBlue;
    private JButton greyConverter;
    private JSlider sliderFocus;

    private float titleFont = 16.0f;

    public ControlPanel(Canvas viewer){
        super();
        this.setCanvas(viewer);
        this.setLayout(new GridBagLayout());
        //Agregamos la separación entre todos los elementos.
        gbc.insets = i;
        //Añadimos los elementos
        addElements();
        this.setVisible(true);
    }

    public void addElements(){
        bloc1();
        bloc2();
        bloc3();
        bloc4();
        bloc5();
        addListeners();
    }

    //Bloc de ficheros.
    public void bloc1(){

        JLabel labelFile = new JLabel("File: ");
        labelFile.setFont (labelFile.getFont ().deriveFont (titleFont));
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.gridheight=1;
        gbc.gridwidth=1;
        this.add(labelFile,gbc);


        this.fileButton = new JButton("LOAD");
        fileButton.setFont(labelFile.getFont ().deriveFont (titleFont));
        fileButton.setMargin(new Insets(10,40,10,40));
        fileButton.addActionListener(this);
        gbc.gridx=1;
        gbc.gridy=0;
        gbc.gridheight=3;
        gbc.gridwidth=4;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(fileButton,gbc);

        String[][] datos = {
                {"KPixels Totals","0"},
                {"Kbytes Totals","0"},
                {"Pixels Amplada","0"},
                {"Pixels alçada","0"},
                {"Canal Alpha","0"},
        };

        String[] colName = {"Descripción", "Valor"};

        table = new JTable(datos, colName);
        table.setRowHeight(20);
        gbc.gridx=0;
        gbc.gridy=4;
        gbc.gridheight=1;
        gbc.gridwidth=6;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(table,gbc);

        JLabel labelImageChooser = new JLabel("Image: ");
        gbc.gridx=0;
        gbc.gridy=5;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        this.add(labelImageChooser,gbc);

        ButtonGroup btnGroup = new ButtonGroup();

        this.image1 = new JToggleButton("1");
        image1.addActionListener(this);
        image1.setMargin(new Insets(20,40,20,40));
        gbc.gridx=1;
        gbc.gridy=5;
        gbc.gridwidth=1;
        gbc.gridheight=2;
        this.add(image1,gbc);
        btnGroup.add(image1);

        this.image2 = new JToggleButton("2");
        image2.addActionListener(this);
        image2.setMargin(new Insets(20,40,20,40));
        gbc.gridx=2;
        gbc.gridy=5;
        gbc.gridwidth=1;
        gbc.gridheight=2;
        this.add(image2,gbc);
        btnGroup.add(image2);

        this.image3 = new JToggleButton("3");
        image3.addActionListener(this);
        image3.setMargin(new Insets(20,40,20,40));
        gbc.gridx=3;
        gbc.gridy=5;
        gbc.gridwidth=1;
        gbc.gridheight=2;
        this.add(image3,gbc);
        btnGroup.add(image3);

    }

    //Bloc de selector de modo (Los modos no funcionan)
    public void bloc2(){

        JLabel modeLabel = new JLabel("Mode: ");
        modeLabel.setFont (modeLabel.getFont ().deriveFont (titleFont));
        gbc.gridx=0;
        gbc.gridy=7;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        gbc.weightx = 0;
        gbc.weighty = 0;
        this.add(modeLabel,gbc);

        ButtonGroup btnGroup2 = new ButtonGroup();

        this.allButton = new JToggleButton("All");
        allButton.setMargin(new Insets(20,40,20,40));
        gbc.gridx=1;
        gbc.gridy=7;
        gbc.gridwidth=2;
        gbc.gridheight=2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(allButton,gbc);
        btnGroup2.add(allButton);

        this.clipButton = new JToggleButton("Clip");
        clipButton.setMargin(new Insets(20,40,20,40));
        gbc.gridx=3;
        gbc.gridy=7;
        gbc.gridwidth=1;
        gbc.gridheight=2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(clipButton,gbc);
        btnGroup2.add(clipButton);

        JLabel sizeLabel = new JLabel("Size: ");
        gbc.gridx=0;
        gbc.gridy=9;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        this.add(sizeLabel,gbc);

        this.sliderSize = new JSlider(JSlider.HORIZONTAL, 4, 1);
        sliderSize.setPaintTicks(true);
        //sliderSize.setMajorTickSpacing(25);
        sliderSize.setMinorTickSpacing(1);
        sliderSize.setPaintLabels(true);
        gbc.gridx=1;
        gbc.gridy=9;
        gbc.gridwidth=3;
        gbc.gridheight=1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(sliderSize,gbc);


    }

    //Bloc de Brillo
    public void bloc3(){

        JLabel brilloLabel = new JLabel("Brillo");
        brilloLabel.setFont (brilloLabel.getFont ().deriveFont (titleFont));
        gbc.gridx=0;
        gbc.gridy=10;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.NORTH;
        this.add(brilloLabel,gbc);

        this.resetBrillo = new JButton("Reset brillo");
        resetBrillo.addActionListener(this);
        gbc.gridx=1;
        gbc.gridy=10;
        gbc.gridwidth=3;
        gbc.gridheight=1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(resetBrillo,gbc);

        JLabel totalLabel = new JLabel("Total");
        gbc.gridx=0;
        gbc.gridy=11;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        this.add(totalLabel,gbc);

        this.sliderBrillo = new JSlider();
        sliderBrillo.setBackground(Color.LIGHT_GRAY);
        sliderBrillo.setPaintTicks(true);
        sliderBrillo.setMajorTickSpacing(25);
        sliderBrillo.setMinorTickSpacing(5);
        sliderBrillo.setPaintLabels(true);
        gbc.gridx=1;
        gbc.gridy=11;
        gbc.gridwidth=3;
        gbc.gridheight=1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(sliderBrillo,gbc);

        JLabel redLabel = new JLabel("Red");
        gbc.gridx=0;
        gbc.gridy=12;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        this.add(redLabel,gbc);

        this.sliderRed = new JSlider();
        sliderRed.setBackground(Color.RED);
        sliderRed.setPaintTicks(true);
        sliderRed.setMajorTickSpacing(25);
        sliderRed.setMinorTickSpacing(5);
        gbc.ipady= 15;
        gbc.gridx=1;
        gbc.gridy=12;
        gbc.gridwidth=3;
        gbc.gridheight=1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(sliderRed,gbc);

        JLabel greenLabel = new JLabel("Green");
        gbc.ipady= 0;
        gbc.gridx=0;
        gbc.gridy=13;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        this.add(greenLabel,gbc);

        this.sliderGreen = new JSlider();
        sliderGreen.setBackground(Color.GREEN);
        sliderGreen.setPaintTicks(true);
        sliderGreen.setMajorTickSpacing(25);
        sliderGreen.setMinorTickSpacing(5);
        gbc.ipady= 15;
        gbc.gridx=1;
        gbc.gridy=13;
        gbc.gridwidth=3;
        gbc.gridheight=1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(sliderGreen,gbc);

        JLabel blueLabel = new JLabel("Blue");
        gbc.ipady= 0;
        gbc.gridx=0;
        gbc.gridy=14;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        this.add(blueLabel,gbc);

        this.sliderBlue = new JSlider();
        sliderBlue.setBackground(Color.BLUE);
        sliderBlue.setPaintTicks(true);
        sliderBlue.setMajorTickSpacing(25);
        sliderBlue.setMinorTickSpacing(5);
        gbc.ipady= 15;
        gbc.gridx=1;
        gbc.gridy=14;
        gbc.gridwidth=3;
        gbc.gridheight=1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(sliderBlue,gbc);

        gbc.ipady= 0;

    }

    //Bloc de Colores
    public void bloc4(){

        JLabel colorLabel = new JLabel("Color");
        colorLabel.setFont (colorLabel.getFont ().deriveFont (titleFont));
        gbc.gridx=0;
        gbc.gridy=15;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        this.add(colorLabel,gbc);

        this.greyConverter = new JButton("Gray");
        greyConverter.addActionListener(this);
        gbc.gridx=1;
        gbc.gridy=15;
        gbc.gridwidth=3;
        gbc.gridheight=1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(greyConverter,gbc);
    }

    //Bloc de Filtros y focus slider
    public void bloc5(){

        JLabel filtroLabel = new JLabel("Filtros");
        filtroLabel.setFont (filtroLabel.getFont ().deriveFont (titleFont));
        gbc.gridx=0;
        gbc.gridy=16;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        this.add(filtroLabel,gbc);

        JLabel focusLabel = new JLabel("Focus");
        gbc.gridx=0;
        gbc.gridy=17;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        this.add(focusLabel,gbc);

        this.sliderFocus = new JSlider(JSlider.HORIZONTAL, 4, 2);
        sliderFocus.setPaintTicks(true);
        sliderFocus.setMinorTickSpacing(1);
        gbc.gridx=1;
        gbc.gridy=17;
        gbc.gridwidth=2;
        gbc.gridheight=1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(sliderFocus,gbc);

        JLabel unfocusLabel = new JLabel("Unfocus");
        gbc.gridx=3;
        gbc.gridy=17;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        this.add(unfocusLabel,gbc);
    }

    public void addListeners(){

        //Cambiar color rojo
        sliderRed.addChangeListener(new ChangeListener(){
            public void stateChanged(ChangeEvent e) {
                canvas.getCurrentImage().setRed(getSliderRed().getValue());
                canvas.getCurrentImage().changeRGB(canvas.getOriginalImage());
                canvas.repaint();
            }});

        //Cambiar color verde
        sliderGreen.addChangeListener(new ChangeListener(){
            public void stateChanged(ChangeEvent e) {
                canvas.getCurrentImage().setGreen(getSliderGreen().getValue());
                canvas.getCurrentImage().changeRGB(canvas.getOriginalImage());
                canvas.repaint();
            }});

        //Cambiar color azul
        sliderBlue.addChangeListener(new ChangeListener(){
            public void stateChanged(ChangeEvent e) {
                canvas.getCurrentImage().setBlue(getSliderBlue().getValue());
                canvas.getCurrentImage().changeRGB(canvas.getOriginalImage());
                canvas.repaint();
            }});

        //Cambiar brillo total
        sliderBrillo.addChangeListener(new ChangeListener(){
            public void stateChanged(ChangeEvent e) {
                canvas.getCurrentImage().setBrightness(getSliderBrillo().getValue());
                canvas.getCurrentImage().changeRGB(canvas.getOriginalImage());
                canvas.repaint();
            }});

        //Focus unfocus
        sliderFocus.addChangeListener(new ChangeListener(){
            public void stateChanged(ChangeEvent e) {
                int num = getSliderFocus().getValue()-2;
                canvas.getCurrentImage().setFocus(num);
                canvas.getCurrentImage().changeFocus(canvas.getOriginalImage());
                canvas.repaint();
            }});

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        switch (e.getActionCommand()){
            case "LOAD":

                FileDialog fileDialog = new FileDialog(new JFrame(),"Image choser", FileDialog.LOAD);
                fileDialog.setVisible(true);
                String path = fileDialog.getDirectory() + fileDialog.getFile();

                try {

                    Image imgTest = new Image(path);
                    File imageFile = new File(path);
                    canvas.setOriginalImage(imgTest);
                    imgTest = new Image(path);
                    canvas.setImage1(imgTest);
                    imgTest = new Image(path);
                    canvas.setImage2(imgTest);
                    imgTest = new Image(path);
                    canvas.setImage3(imgTest);

                    //Llenamos la tabla

                    String str = "";

                    table.setValueAt((Object)str.valueOf(imgTest.getWidth()*imgTest.getHeight()/1024), 0, 1);
                    table.setValueAt((Object)str.valueOf(imageFile.length()/1024), 1, 1);
                    table.setValueAt((Object)str.valueOf(imgTest.getWidth()), 2, 1);
                    table.setValueAt((Object)str.valueOf(imgTest.getHeight()), 3, 1);
                    if(imgTest.getImg().getColorModel().hasAlpha()){
                        table.setValueAt((Object)"Yes", 4, 1);
                    }else{
                        table.setValueAt((Object)"No", 4, 1);
                    }

                } catch (Exception exc) {
                    System.out.println(exc);
                }

                canvas.repaint();
                break;
            case "1":
                canvas.setCurrentImage(canvas.getImage1());
                System.out.println(canvas.getCurrentImage());
                break;
            case "2":
                canvas.setCurrentImage(canvas.getImage2());
                break;
            case "3":
                canvas.setCurrentImage(canvas.getImage3());
                break;
            case "Gray":
                if(canvas.getCurrentImage() != null){
                    canvas.getCurrentImage().setGray(!canvas.getCurrentImage().isGray());
                    canvas.getCurrentImage().changeRGB((canvas.getOriginalImage()));
                    canvas.repaint();
                }
                break;
            case "Reset brillo":
                if(canvas.getCurrentImage() != null){
                    canvas.getCurrentImage().setBrightness(canvas.getOriginalImage().getBrightness());
                    canvas.getCurrentImage().setBlue(canvas.getOriginalImage().getBlue());
                    canvas.getCurrentImage().setRed(canvas.getOriginalImage().getRed());
                    canvas.getCurrentImage().setGreen(canvas.getOriginalImage().getGreen());
                    canvas.getCurrentImage().changeRGB(canvas.getOriginalImage());
                    canvas.repaint();
                }
                break;
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {

    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    public JSlider getSliderBrillo() {
        return sliderBrillo;
    }

    public JSlider getSliderRed() {
        return sliderRed;
    }

    public JSlider getSliderGreen() {
        return sliderGreen;
    }

    public JSlider getSliderBlue() {
        return sliderBlue;
    }


    public JSlider getSliderFocus() {
        return sliderFocus;
    }


}
