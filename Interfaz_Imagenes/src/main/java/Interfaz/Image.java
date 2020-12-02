package Interfaz;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.IOException;

public class Image {

    private BufferedImage img;

    private int height;
    private int width;
    private int prof;
    private byte[] vector;

    private boolean gray;
    private int blue;
    private int green;
    private int red;
    private int focus;
    private int brightness;

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
    //</editor-fold>

    public Image(String path) throws IOException {
        this.setImg(ImageIO.read(new File(path)));
        this.setHeight(this.getImg().getHeight());
        this.setWidth(this.getImg().getWidth());
        this.setProf(this.getImg().getColorModel().getNumComponents());
        this.setVector(((DataBufferByte) this.getImg().getRaster().getDataBuffer()).getData());
        this.setGray(false);
        this.setBrightness(1);

    }

    private int getVectorPosition(int row, int col, int target) {
        int pos = ((row) * (this.getWidth()) * this.getProf()) + ((col) * this.getProf()) + (target);
        return pos;
    }

    private void changeBrightness(int porcentaje) {
        for (int i = 0; i < this.getHeight(); i++) {
            for (int j = 0; j < this.getWidth(); j++) {
                for (int k = 0; k < this.getProf(); k++) {
                    int posicionVector = getVectorPosition(i, j, k);
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
    }


    private void changeRed(int porcentaje) {
        for (int i = 0; i < this.getHeight(); i++) {
            for (int j = 0; j < this.getWidth(); j++) {
                int posicionVector = getVectorPosition(i, j, 2);
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


    private void changeGreen(int porcentaje) {
        for (int i = 0; i < this.getHeight(); i++) {
            for (int j = 0; j < this.getWidth(); j++) {
                int posicionVector = getVectorPosition(i, j, 1);
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

    private void changeBlue(int porcentaje) {
        for (int i = 0; i < this.getHeight(); i++) {
            for (int j = 0; j < this.getWidth(); j++) {
                int posicionVector = getVectorPosition(i, j, 0);
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

    private void resetImage(Image imagenOriginal) {
        for (int i = 0; i < vector.length; i++) {
            this.vector[i] = imagenOriginal.vector[i];
        }
    }

    private void suavizarImagen(Image origen, Convolucion convolucion, int divisor, int vueltas) {
        for (int aux = 0; aux <vueltas ; aux++) {
            if(aux!=0){
                origen=this;
            }
            for (int i = 0; i < this.getHeight(); i++) {
                for (int j = 0; j < this.getWidth(); j++) {
                    for (int k = 0; k < this.getProf(); k++) {
                        if (i == 0 || j == 0 || i == this.getHeight() - 1 || j == this.getWidth() - 1) {
                        } else {
                            int valor = calcularValor(origen, convolucion, i, j, k, divisor);
                            this.getVector()[getVectorPosition(i, j, k)] = (byte) valor;
                        }
                    }
                }
            }
        }
    }

    private int calcularValor(Image origen, Convolucion convolucion, int fila, int columna, int profundidad, int divisor) {
        int valor = 0;
        byte[] origenVector = origen.getVector();
        int posicionVector;

        for (int i = -1; i < convolucion.getRowNum() - 1; i++) {
            for (int j = -1; j < convolucion.getColNum() - 1; j++) {
                posicionVector = getVectorPosition(fila + i, columna + j, profundidad);
                valor += Byte.toUnsignedInt(origenVector[posicionVector]) * convolucion.getValues()[i + 1][j + 1];
            }
        }

        valor = valor / divisor;
        if (valor > 255) {
            valor = 255;
        } else if (valor < 0) {
            valor = 0;
        }
        return valor;
    }

    /**
     * Calcula el valor medio de los colores rgb del pixel dado
     *
     * @param posicionVector posicion del primer color del pixel
     * @return valor medio
     */
    private int actualizarValorMedioBGR(int posicionVector, Image imagenOriginal) {
        int valor = 0;
        for (int i = 0; i < this.getProf(); i++) {
            valor += Byte.toUnsignedInt(imagenOriginal.getVector()[posicionVector + i]);
        }
        valor = valor / 3;
        for (int i = 0; i < this.getProf(); i++) {
            this.getVector()[posicionVector + i] = (byte) (valor);
        }
        return valor / 3;
    }

    private void grayToggle(Image imgOrignal) {
        for (int i = 0; i < this.getHeight(); i++) {
            for (int j = 0; j < this.getWidth(); j++) {
                int posicionVector = getVectorPosition(i, j, 0);
                actualizarValorMedioBGR(posicionVector, imgOrignal);
            }
        }
    }

    public void changeRGB(Image imagenOriginal) {
        resetImage(imagenOriginal);

        changeBrightness(this.getBrightness());
        changeBlue(this.getBlue());
        changeGreen(this.getGreen());
        changeRed(this.getRed());

        if (gray) {
            this.grayToggle(imagenOriginal);
        }

    }

    public void changeFocus(Image imagenOriginal){
        if (this.getFocus() != 0) {
            System.out.println("AAAA");
            if (this.getFocus() > 0) {
                Convolucion matriz = new Convolucion(3, 3);
                matriz.fillBlur();
                suavizarImagen(imagenOriginal, matriz, Convolucion.findK(matriz), getFocus());

            } else {
                Convolucion aux = new Convolucion(3,3);
                aux.fillFocus();
                suavizarImagen(imagenOriginal,aux,3, getFocus()*-1);
            }
        }
    }
}
