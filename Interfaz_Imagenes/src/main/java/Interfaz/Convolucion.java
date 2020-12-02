package Interfaz;

public class Convolucion {

    int[][] values;
    int colNum;
    int rowNum;

    public Convolucion(int rows, int cols) {
        this.colNum = cols;
        this.rowNum = rows;
        this.setValues(new int[rows][cols]);
    }

    public void fillFocus(){
        this.getValues()[0][0]=0;
        this.getValues()[0][1]=-1;
        this.getValues()[0][2]=0;
        this.getValues()[1][0]=-1;
        this.getValues()[1][1]=5;
        this.getValues()[1][2]=-1;
        this.getValues()[2][0]=0;
        this.getValues()[2][1]=-1;
        this.getValues()[1][2]=0;
    }


    public void fillBlur(){
        this.getValues()[0][0]=1;
        this.getValues()[0][1]=1;
        this.getValues()[0][2]=1;
        this.getValues()[1][0]=1;
        this.getValues()[1][1]=1;
        this.getValues()[1][2]=1;
        this.getValues()[2][0]=1;
        this.getValues()[2][1]=1;
        this.getValues()[2][2]=1;
    }


    public static int findK(Convolucion convolucion){

        int k=0;

        for (int i = 0; i < convolucion.getValues().length; i++) {
            for (int j = 0; j < convolucion.getValues()[0].length ; j++) {
                k=+ convolucion.getValues()[i][j];
            }
        }

        if(k==0){
            k=1;
        }

        return k;
    }



    public int getRowNum() {
        return rowNum;
    }

    public void setRowNum(int rowNum) {
        this.rowNum = rowNum;
    }

    public int getColNum() {
        return colNum;
    }

    public void setColNum(int colNum) {
        this.colNum = colNum;
    }

    public int[][] getValues() {
        return values;
    }

    public void setValues(int[][] values) {
        this.values = values;
    }

}
