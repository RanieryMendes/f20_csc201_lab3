/*
Raniery Mendes
CSC201 Fall 2020
Programming Assignment 3
October 27, 2020
 */


//The RGB class manages the RGB values got from the pixel that is read from the picture in main
public class RGB {

    //RGB values
    private int R =0;
    private int G = 0;
    private int B = 0;

    //setter methods for the RGB values

    public void setR(int r) {
        this.R = r;
    }

    public void setG(int g) {
        this.G = g;
    }

    public void setB(int b) {
        this.B = b;
    }

    //getter methods for the RGB values

    public int getR() {
        return this.R;
    }

    public int getG() {
        return this.G;
    }

    public int getB() {
        return this.B;
    }
}


