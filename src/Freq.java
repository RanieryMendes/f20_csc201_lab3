/*
Raniery Mendes
CSC201 Fall 2020
Programming Assignment 3
October 29, 2020
 */


import java.lang.Override;


// Freq class stores the RGB colors and their frequencies

public class Freq implements Comparable<Freq>{

    private RGB  color; // pixel RGB object that stores RGB values
    private int  f; //frequency counter

    //default constructor
    Freq(){

        //The frequency counter is set to 3043050, which is an arbitrary value.
        this.f = -1;
    }

    //setter methods for the RGB and frequency counter variables

    public void setColor(RGB el){
        this.color =el;
    }

    public void setF(int value){
        this.f=value;
    }


    //method that increments the frequency of a color in the HT
    public void incrementF(){
        this.f++;
    }

    //getter methods for the RGB and frequency counter variables
    public RGB getColor(){
        return  this.color;
    }

    public int getF() {
        return this.f;
    }


    //compareTo method that comes in through the implementation of Comparable
    //compare the frequency counters. It is going to be used to sort the HT  based on the frequency

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

};
