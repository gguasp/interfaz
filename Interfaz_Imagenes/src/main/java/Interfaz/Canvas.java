package Interfaz;

import java.awt.*;

public class Canvas extends java.awt.Canvas {
    private Image originalImage;
    private Image image1;
    private Image image2;
    private Image image3;
    private Image currentImage = null;

    @Override
    public void paint(Graphics g) {
        System.out.println("Pintando");
        int width = this.getWidth() / 2;
        int height = this.getHeight() / 2;

        if (this.getOriginalImage() != null) {
            System.out.println("No soy nulo");
            g.drawImage(getOriginalImage().getImg(), 0, 0, width, height, this);
            g.drawImage(getImage1().getImg(), width, 0, width, height, this);
            g.drawImage(getImage2().getImg(), 0, height, width, height, this);
            g.drawImage(getImage3().getImg(), width, height, width, height, this);
        } else {
            System.out.println("Soy nulo");
        }
    }

    public Image getOriginalImage() {
        return originalImage;
    }

    public void setOriginalImage(Image originalImage) {
        this.originalImage = originalImage;
    }

    public Image getImage1() {
        return image1;
    }

    public void setImage1(Image image1) {
        this.image1 = image1;
    }

    public Image getImage2() {
        return image2;
    }

    public void setImage2(Image image2) {
        this.image2 = image2;
    }

    public Image getImage3() {
        return image3;
    }

    public void setImage3(Image image3) {
        this.image3 = image3;
    }

    public Image getCurrentImage() {
        return currentImage;
    }

    public void setCurrentImage(Image currentImage) {
        this.currentImage = currentImage;
    }

    public Canvas() {

    }

}
