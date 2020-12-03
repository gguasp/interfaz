package Interfaz;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;

public class Image {

    private BufferedImage img;

    private int height;
    private int width;
    private int prof;
    private byte[] vector;

    private int red;
    private int blue;
    private int green;

    private int focus;
    private int brightness = 1;

    private boolean gray = false;

    public BufferedImage getImg() {
        return img;
    }

    public void setImg(BufferedImage img) {
        this.img = img;
        this.height = this.img.getHeight();
        this.width = this.img.getWidth();
        this.prof = this.img.getColorModel().getNumComponents();
        this.vector = ((DataBufferByte) this.getImg().getRaster().getDataBuffer()).getData();
    }

    public Image(String path) {
        try {
            this.setImg(ImageIO.read(new File(path)));
            this.setWidth(this.getImg().getWidth());
            this.setHeight(this.getImg().getHeight());
            this.setProf(this.getImg().getColorModel().getNumComponents());
            this.setVector(((DataBufferByte) this.getImg().getRaster().getDataBuffer()).getData());
        } catch (Exception e) {
            System.out.println(e);
        }


    }

    private int getPos(int row, int col, int target) {
        return ((row) * (this.getWidth()) * this.getProf()) + ((col) * this.getProf()) + (target);
    }

    private void resetImage(Image imagenOriginal) {
        System.arraycopy(imagenOriginal.vector, 0, this.vector, 0, vector.length);
    }


    private int findValue(Image origen, Convolucion convolucion, int fila, int columna, int profundidad, int divisor) {

        int num = 0;
        int pos;

        byte[] origenVector = origen.getVector();
        for (int i = -1; i < convolucion.getRowNum() - 1; i++) {
            for (int j = -1; j < convolucion.getColNum() - 1; j++) {
                pos = getPos(fila + i, columna + j, profundidad);
                num += Byte.toUnsignedInt(origenVector[pos]) * convolucion.getValues()[i + 1][j + 1];
            }
        }

        num = num / divisor;
        if(num < 0) {
            num = 0;
        }
        return num;
    }


    public void changeFocus(Image imagenOriginal) {

        resetImage(imagenOriginal);

        Convolucion matriz = new Convolucion(3, 3);
        matriz.fillFocus();
        if (this.getFocus() > 0) {
            transfromImage(imagenOriginal, matriz, Convolucion.findK(matriz), getFocus());
        } else {
            transfromImage(imagenOriginal, matriz, 3, getFocus() * -1);
        }

    }

    private void transfromImage(Image img, Convolucion convolucion, int k, int repeats) {
        for (int aux = 0; aux < repeats; aux++) {
            if (aux != 0) {
                img = this;
            }
            for (int i = 0; i < this.getHeight(); i++) {
                for (int j = 0; j < this.getWidth(); j++) {
                    for (int x = 0; x < this.getProf(); x++) {
                        if (i != 0 && j != 0 && j != this.getWidth() - 1 && i != this.getHeight() - 1 ) {
                            int valor = findValue(img, convolucion, i, j, x, k);
                            this.getVector()[getPos(i, j, x)] = (byte) valor;
                        }
                    }
                }
            }
        }
    }


    public void changeRGB(Image img) {

        resetImage(img);

        changeBrightness(this.getBrightness());
        changeColor(this.getRed(), 2);
        changeColor(this.getGreen(), 1);
        changeColor(this.getBlue(), 0);

        if (gray) {
            for (int i = 0; i < this.getHeight(); i++) {
                for (int j = 0; j < this.getWidth(); j++) {
                    int posicionVector = getPos(i, j, 0);
                    updateRGB(img, posicionVector);
                }
            }
        }
    }

    private int updateRGB( Image img, int pos) {
        int rgb = 0;
        for (int i = 0; i < this.getProf(); i++) {
            rgb += Byte.toUnsignedInt(img.getVector()[pos + i]);
        }
        rgb = rgb / 3;
        for (int i = 0; i < this.getProf(); i++) {
            this.getVector()[pos + i] = (byte) (rgb);
        }
        return rgb / 3;
    }

    private void changeColor(int porcentaje, int prof) {
        for (int i = 0; i < this.getHeight(); i++) {
            for (int j = 0; j < this.getWidth(); j++) {
                int posicionVector = getPos(i, j, prof);
                int valor = Byte.toUnsignedInt(this.getVector()[posicionVector]);
                valor = (valor * (100 + porcentaje) / 100);
                if (valor <= 255) {
                    this.getVector()[posicionVector] = (byte) valor;
                } else {
                    this.getVector()[posicionVector] = (byte) 255;
                }
            }
        }
    }


    private void changeBrightness(int porcentaje) {
        for (int i = 0; i < this.getHeight(); i++) {
            for (int j = 0; j < this.getWidth(); j++) {
                for (int k = 0; k < this.getProf(); k++) {
                    int pos = getPos(i, j, k);
                    int valor = Byte.toUnsignedInt(this.getVector()[pos]);
                    valor = (valor * (100 + porcentaje) / 100);
                    if (valor <= 255) {
                        this.getVector()[pos] = (byte) valor;
                    } else {
                        this.getVector()[pos] = (byte) 255;
                    }
                }
            }
        }
    }


    public int getBrightness() {
        return brightness;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getProf() {
        return prof;
    }

    public void setProf(int prof) {
        this.prof = prof;
    }

    public int getFocus() {
        return focus;
    }

    public void setFocus(int focus) {
        this.focus = focus;
    }

    public void setBrightness(int brightness) {
        this.brightness = brightness;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public byte[] getVector() {
        return vector;
    }

    public void setVector(byte[] vector) {
        this.vector = vector;
    }

    public boolean isGray() {
        return gray;
    }

    public void setGray(boolean gray) {
        this.gray = gray;
    }

}
