
import java.lang.Override;

public class Freq implements Comparable<Freq>{

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



    @Override

    public int compareTo (Freq el){

        if(this.getF() < el.getF()){
            return -1;

        }

        else if (this.getF() > el.getF()){

            return 1;
        }

        else{
            return 0;
        }


    }

/*
@Override

public int compareTo(Freq el){

    if(this.getF() <el.getF()){

        return -1;
    }

        }
*/
};
