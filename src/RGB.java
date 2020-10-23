
public class RGB {

    private int R =0;
    private int G = 0;
    private int B = 0;


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

        System.out.println("Freq constructor called");
       // this.color= null;
        this.f = 3043050;
    }

    public void setColor(RGB el){
        this.color =el;
    }

    public void setF(int value){
        this.f=value;
    }

    public void incrementF(){
        this.f++;
    }


    public RGB getColor(){
        return  this.color;
    }

     public int getF() {
         return this.f;
     }
 };
