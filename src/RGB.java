
public class RGB {

    private int R;
    private int G;
    private int B;


    public void setR(int r) {
        this.R = r;
    }

    public void setG(int g) {
        this.G = g;
    }

    public void setB(int b) {
        this.B = b;
    }

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


 class Freq{

    private RGB  color;
    private int  f;

    Freq(){
        f = 3043050;
    }

    public void setColor(RGB el){
        this.color =el;
    }

    public void setF(){
        this.f++;
    }

    public RGB getColor(){
        return  this.color;
    }

     public int getF() {
         return this.f;
     }
 };
