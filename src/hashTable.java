/*
Raniery Mendes
CSC201 Fall 2020
Programming Assignment 3
October 29, 2020
 */

//This class implements the Hash table of Freq objects.

import java.util.ArrayList;
import java.util.Arrays;




public class hashTable {

    //HT data structure
   Freq [] ht;
   ArrayList <Control> controlAllB = new ArrayList<>();
   ArrayList <Control> controlAllR = new ArrayList<>();
   ArrayList <Control> controlAllG = new ArrayList<>();

   ArrayList <RGB> possibleColors = new ArrayList<>();
   private final int  RGB_VALUE = 256;

   //variable that
   private int tableLentgh;

   private int trackSize = 0;

   //
   private int collisionCounter=0;

   //variable that tracks the number of rehashing per
   private int rehashingCounter=0;

   Palete Red = new Palete();
   Palete Blue = new Palete();
   Palete Green = new Palete();


   hashTable(){
       ht = new Freq [101] ;
       this.tableLentgh=101;
   }

   //constructor to create a hashtable from the size inserted by the user
   hashTable(int size){

       ht = new Freq[size];

       this.tableLentgh=size;

       //populating the array of Freq elements

       for (int i = 0; i < size; i++){

           // creates new Freq object and stores at Hashtable (array of Freqs)
           Freq init = new Freq();
           ht[i] = init;

       }
       //store -1 in all index so I know index is free to receive a Freq element



   }

   //Hash function
   public int h (Freq el) {

       //multiply the RGB values from Freq el
      int value =  el.getColor().getR() * el.getColor().getB() * el.getColor().getG();

      //module the RGB value
      int resultToHash = value % this.tableLentgh;

      return resultToHash;

   }



   //insert function that stores Freq elements into the hashtable
   public void insert (Freq item){


       //checks if the table is more than half full, if yes it rehashes the table
        if(trackSize> tableLentgh/2){

            //call function to increase table
            increaseArray(tableLentgh*2);


        }



        //check if RGB color is already stored in the table, if findColor(item) is false then, it is a new color,
       // so store it into the table
        if(findColor(item)== false) {

            //integer counter for
            int k= 1;

            //get the index the element has to be hashed to
            int index = h(item);


            //While loop that looks for an available spot in the table.
            //Freq elements are initialized with f=3043050, so if they have this value it means the slot is availabel
            // to store a  Freq element (with a new color)
            //it gets into the loop only if the index assigned is already taken by another Freq element
            while (ht[index].getF() != -1) {

                //collision resolution - Quadratic probing
                index = index + k * k;


                //ensure the index is within the table's boundaries
                index %= ht.length;

                //increases the value of
                k++;

                //track the total number of collisions that happened while reading the pixels of a picture
                collisionCounter++;

            }


            //when slot in table is found, set the color into the freq element that is in the array
            // and  set the frequency counter for that color = to 1.
            this.ht[index].setColor(item.getColor());
            ht[index].setF(1);

            //increments variable that tracks the number of Freq elements with colors already placed in the table
            //it will be used to avoid the table gets more than half full
            trackSize++;





        }



    }

    //insert function called only for rehashing process
    public void insert_Rehash (Freq item){


        //checks if the table is more than half full, if yes it rehashes the table
        if(trackSize> tableLentgh/2){


            //call function to increase table
            increaseArray(tableLentgh*2);


        }


        //check if RGB color is already stored in the table, if findColor(item) is false then, it is a new color,
        // so store it into the table

        if(findColor(item)== false) {



            int k= 1;

            //get the index the element has to be hashed to
            int index = h(item);





            //While loop that looks for an available spot in the table.
            //Freq elements are initialized with f=3043050, so if they have this value it means the slot is availabel
            // to store a  Freq element (with a new color)
            //it gets into the loop only if the index assigned is already taken by another Freq element
            while (ht[index].getF() != -1) {

                //collision resolution - Quadratic probing
                index = index + k * k;


                //ensure the index is within the table's boundaries
                index %= ht.length;

                k++;

                //track the total number of collisions that happened while reading the pixels of a picture
                collisionCounter++;

            }


            //when slot in table is found, set the color into the freq element that is in the array
            // and  set the frequency counter for that color = to 1.
            this.ht[index].setColor(item.getColor());
            ht[index].setF(item.getF());


            //increments variable that tracks the number of Freq elements with colors already placed in the new
            // rehashed table. It will be used to avoid the table gets more than half full
            trackSize++;


        }



    }



   //function to check if color is already in the HT
   public boolean findColor(Freq key){


       int k = 1;

       //get the first index the element has to be hashed to
       int indexHashed = h(key);

        //if not in the first index, check if it is in any of the possible slots that Freq element could be hashed to


       while(ht[indexHashed].getF() != -1){

           //check if the Freq element in the HT has the same color of the Freq element's RGB color being inserted into the HT
           if(ht[indexHashed].getColor().getR() == key.getColor().getR() && ht[indexHashed].getColor().getG() == key.getColor().getG()&&ht[indexHashed].getColor().getB() == key.getColor().getB()){

               //if color is already in a Freq element of the HT, just increase its frequency
               ht[indexHashed].incrementF();

               return true;
           }

           //going to next possible slot the Freq element could be hashed to
           indexHashed= indexHashed + k * k;


           //ensure that the next slot is within the HT's boundaries
           indexHashed %= getTableLentgh();


           k++;
       }

       //color not find, so it is a new color and need to be stored in the Hashtable
       return false;
   }

   //method to check is a number is prime. This function will be used during the rehashing process
    public boolean isPrime(int n)
    {
        // Check for corner cases
        if (n <= 1) return false;
        if (n <= 3) return true;

        // This is checked so that we can skip
        // middle five numbers in below loop
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }

        for (int i = 5; i * i <= n; i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;

        return true;
    }

    // Function to return the smallest
    // prime number greater than N
    public int nextPrime(int N)
    {

        // Base case
        if (N <= 1)
            return 2;

        int prime = N;
        boolean found = false;

        // Loop continuously until isPrime returns
        // true for a number greater than n
        while (!found)
        {
            prime++;

            if (isPrime(prime))
                found = true;
        }


        return prime;
    }


    //function called to increase the HT
    //it will double the HT's size and find the next prime number after that. This will be the next size of the HT

   public void increaseArray (int minArraySize){

       //track size of the total number of rehashes carried out
       rehashingCounter++;

       //gets the new size, which will be a prime
       int newSize = nextPrime(minArraySize);

       //call function to build the new larger HT
       increaseOld(newSize);


   }



   //function will increase the HT's size by creating a new larger HT and inserting the already stored Freq elements to the new HT
   public void increaseOld(int newArraySize){


       //create an array that contains only the Freq elements that contain RGB colors.
       Freq [] cleanFromOld = removeEmptySlots(this.ht);



       // create the new HT with the new size
       ht = new Freq[newArraySize];

       //update the HT size
       this.tableLentgh = newArraySize;

       //populate the array with Freq elements so it can receive the Freq elements with actual colors
     for (int i = 0; i < newArraySize; i++) {
           Freq init = new Freq();
           ht[i] = init;

       }

       //hash clean data to the new array
       for (Freq obj: cleanFromOld){

           //use the especial insert function to arrange the already stored Freq elements into the new larger HT
           insert_Rehash(obj);
       }


   }

   //function that will return an array based on the HT, however, without the empty slots
   public Freq[] removeEmptySlots(Freq[] arrayToBeCleaned){

       //create an ArrayList that will receive the Freq elements already stored in the HT
       ArrayList<Freq> list = new ArrayList<>();


       //add the Freq elements that were already stored in the HT

       for(Freq obj : arrayToBeCleaned){
           if(obj.getF()!=-1){

               list.add(obj);
           }

       }


        //transform the ArrayList into an array and return it
       return list.toArray(new Freq[list.size()]);
   }

   //function that sorts the HT and print the 256 most frequent colors
   public void sortArray (){

       //create an array with only the Freq elements inserted into the HT
       Freq [] clean = removeEmptySlots(this.ht);

       //sort array using compareTo method declared in Freq class
       Arrays.sort(clean);

       this.ht = clean;


       //case the image has less than 256 RGB colors
       if(clean.length < 256){

           System.out.println("Top " + clean.length + " most frequent colors");


           for(int i= clean.length-1; i >=0;  i--){

               System.out.println("Color: ("+  clean[i].getColor().getR() + ", " +clean[i].getColor().getG() +", "+  clean[i].getColor().getB() + "). Frequency in the picture: " + clean[i].getF());
           }

       }


       else {

           System.out.println("Top 256 most frequent colors");
           for (int i = clean.length - 1; i > clean.length - 257; i--) {

               System.out.println("Color: (" + clean[i].getColor().getR() + ", " + clean[i].getColor().getG() + ", " + clean[i].getColor().getB() + "). Frequency in the picture: " + clean[i].getF());
           }
       }





   }


   //need to get the most used R, G, and B.

   //

   public  void setSlices(int numberR, int numberG, int numberB){



       int sizeSlicesR =  RGB_VALUE / numberR;

       for( int i = 0; i < RGB_VALUE; i = i + sizeSlicesR){

           Control color = new Control();

           color.setStartV(i);

           color.setFinalV((i + sizeSlicesR - 1));


           System.out.println(color.getStartV() + " to " + color.getFinalV() );

           color.setMinVal(color.getFinalV());
           color.setMaxVal(0);

           controlAllR.add(color);




       }



       int sizeSlicesB =  RGB_VALUE / numberB;


       for( int i = 0; i < RGB_VALUE; i = i + sizeSlicesB){

           Control color = new Control();

           color.setStartV(i);

           color.setFinalV((i + sizeSlicesB - 1));

           color.setMinVal(color.getFinalV());
           color.setMaxVal(0);

           System.out.println(color.getStartV() + " to " + color.getFinalV() );

           controlAllB.add(color);




       }

       int sizeSlicesG =  RGB_VALUE / numberG;



       for( int i = 0; i < RGB_VALUE; i = i + sizeSlicesG){

           Control color = new Control();

           color.setStartV(i);

           color.setFinalV((i + sizeSlicesG - 1));


           System.out.println(color.getStartV() + " to " + color.getFinalV() );

           controlAllG.add(color);


       }







   }


   public void getMinMaxColor (){


       System.out.println("Size: " + ht.length);

       //RED

       for (int i = 0; i < this.ht.length; i++){

          int v =  ht[i].getColor().getR();

           System.out.println("aqui " + controlAllR.size());
           System.out.println("v: " + v);



          for(int k= 0; k <controlAllR.size(); k++){


              System.out.println("Start "+ controlAllR.get(k).getStartV() + " Final: " + controlAllR.get(k).getFinalV());

              if(  controlAllR.get(k).getStartV() <= v && v <= controlAllR.get(k).getFinalV()){

                  System.out.println("v is in: " +v );

                  System.out.println("Current max: " + controlAllR.get(k).getMaxVal());





                  if(controlAllR.get(k).getMaxVal() < v){

                      controlAllR.get(k).setMaxVal(v);
                      System.out.println("New max: " + controlAllR.get(k).getMaxVal());
                      if(v == 159){
                          System.out.println("to aqui 31");
                      }
                  }

                  if(v >= 0 && controlAllR.get(k).getMinVal() > v){
                      controlAllR.get(k).setMinVal(v);
                  }

              }
          }


       }
       for (int p = 0; p < controlAllR.size(); p++){

           System.out.println(controlAllR.get(p).getStartV() + " to " + controlAllR.get(p).getFinalV() + " has Min: " + controlAllR.get(p).getMinVal() + " and max: " + controlAllR.get(p).getMaxVal());
       }

       //GREEN

       for (int i = 0; i < this.ht.length; i++){

           int v =  ht[i].getColor().getG();

           System.out.println("aqui " + controlAllG.size());
           System.out.println("v: " + v);



           for(int k= 0; k <controlAllG.size(); k++){


               System.out.println("Start "+ controlAllG.get(k).getStartV() + " Final: " + controlAllG.get(k).getFinalV());

               if(  controlAllG.get(k).getStartV() <= v && v <= controlAllG.get(k).getFinalV()){

                   System.out.println("v is in: " +v );

                   System.out.println("Current max: " + controlAllG.get(k).getMaxVal());





                   if(controlAllG.get(k).getMaxVal() < v){

                       controlAllG.get(k).setMaxVal(v);
                       System.out.println("New max: " + controlAllG.get(k).getMaxVal());
                       if(v == 191){
                           System.out.println("to aqui 31");
                       }
                   }

                   if(v >= 0 && controlAllG.get(k).getMinVal() > v){
                       controlAllG.get(k).setMinVal(v);
                   }

               }
           }

       }

       for (int p = 0; p < controlAllG.size(); p++){

           System.out.println(controlAllG.get(p).getStartV() + " to " + controlAllG.get(p).getFinalV() + " has Min: " + controlAllG.get(p).getMinVal() + " and max: " + controlAllG.get(p).getMaxVal());
       }

       //BLUE
       for (int i = 0; i < this.ht.length; i++){

           int v =  ht[i].getColor().getB();

           System.out.println("aqui " + controlAllB.size());
           System.out.println("v: " + v);



           for(int k= 0; k <controlAllB.size(); k++){


               System.out.println("Start "+ controlAllB.get(k).getStartV() + " Final: " + controlAllB.get(k).getFinalV());

               if(  controlAllB.get(k).getStartV() <= v && v <= controlAllB.get(k).getFinalV()){

                   System.out.println("v is in: " +v );

                   System.out.println("Current max: " + controlAllB.get(k).getMaxVal());





                   if(controlAllB.get(k).getMaxVal() < v){

                       controlAllB.get(k).setMaxVal(v);
                       System.out.println("New max: " + controlAllB.get(k).getMaxVal());
                       if(v == 191){
                           System.out.println("to aqui 31");
                       }
                   }

                   if(v >= 0 && controlAllB.get(k).getMinVal() > v){
                       controlAllB.get(k).setMinVal(v);
                   }

               }
           }

       }

       for (int p = 0; p < controlAllR.size(); p++){

           System.out.println(controlAllR.get(p).getStartV() + " to " + controlAllR.get(p).getFinalV() + " has Min: " + controlAllR.get(p).getMinVal() + " and max: " + controlAllR.get(p).getMaxVal());
       }

       for (int p = 0; p < controlAllG.size(); p++){

           System.out.println(controlAllG.get(p).getStartV() + " to " + controlAllG.get(p).getFinalV() + " has Min: " + controlAllG.get(p).getMinVal() + " and max: " + controlAllG.get(p).getMaxVal());
       }

       for (int p = 0; p < controlAllB.size(); p++){

           System.out.println(controlAllB.get(p).getStartV() + " to " + controlAllB.get(p).getFinalV() + " has Min: " + controlAllB.get(p).getMinVal() + " and max: " + controlAllB.get(p).getMaxVal());
       }



   }

   public void setPieceColorValues (){

       Red.setColor_range(controlAllR);
       Green.setColor_range(controlAllG);
       Blue.setColor_range(controlAllB);


       for( int i=0; i < Red.color_range.length; i++){

           for(int k=0 ; k < Green.color_range.length; k++){


               for (int p = 0; p < Blue.color_range.length; p++){



                   RGB pixel = new RGB();

                   pixel.setR(Red.color_range[i]);
                   pixel.setG(Green.color_range[k]);
                   pixel.setB(Blue.color_range[p]);

                   possibleColors.add(pixel);

               }
           }

       }


       System.out.println("Those are the " + possibleColors.size()  +" colors:  ");

       for (int m = 0; m < possibleColors.size(); m++){


           System.out.println(" Color R: " + possibleColors.get(m).getR() + " G: " + possibleColors.get(m).getG() + " B: " + possibleColors.get(m).getB());
       }



   }





   public int number_collision(){
       return this.collisionCounter;
   }

   public int getTableLentgh(){
       return this.tableLentgh;
   }


   public int getRehashingCounter(){
       return this.rehashingCounter;
   }

}
