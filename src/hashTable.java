import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;


public class hashTable {


   Freq [] ht;

   final double MAX_LOAD= 0.5;

   private int tableLentgh =5;

   private int trackSize = 0;

   private int collisionCounter=0;

   private int rehashingCounter=0;


   hashTable(){
       ht = new Freq [101] ;
   }

   hashTable(int size){

       ht = new Freq[size];




       System.out.println("ht was called " + size);
       this.tableLentgh=size;

       //populating the array of Freq elements

       for (int i = 0; i < size; i++){
           Freq init = new Freq();
           ht[i] = init;
          // test.add(i, init);

           System.out.println("oi");
       }
       //store -1 in all index so I know index is free to receive a Freq element



   }

   public int h (Freq el) {

      int value =  el.getColor().getR() * el.getColor().getB() * el.getColor().getG();

      int resultToHash = value % this.tableLentgh;

      return resultToHash;

   }



   public void insert (Freq item){


        if(trackSize> tableLentgh/2){


            System.out.println("We gotta grow bigger");
            System.out.println("Before my size was: " + tableLentgh);
            increaseArray(tableLentgh*2);
            System.out.println("Now my size is: " +tableLentgh);

        }



        if(findColor(item)== false) {



            int k= 1;
            //it will get the index to element be hashed
            int index = h(item);

            System.out.println("Modulus index: " + index);



            //look for an available
            while (ht[index].getF() != 3043050) {

                index = index + k * k;

                System.out.println("Collision Attempt: " + index + " Instead");

                index %= ht.length;

                k++;

                collisionCounter++;

            }


            System.out.println("Deixa eu ver uma antes: " + "R: " + item.getColor().getR() + " G: " + item.getColor().getG() + " B:" +  item.getColor().getB());

            this.ht[index].setColor(item.getColor());
            System.out.println("Deixa eu ver uma parada: " + "R: " + ht[index].getColor().getR() + " G: " + ht[index].getColor().getG() + " B:" +  ht[index].getColor().getB());
            ht[index].setF(1);
            trackSize++;



            //find index we can store

        }



    }

    public void insert_Rehash (Freq item){


        if(trackSize> tableLentgh/2){


            System.out.println("We gotta grow bigger");
            System.out.println("Before my size was: " + tableLentgh);
            increaseArray(tableLentgh*2);
            System.out.println("Now my size is: " +tableLentgh);

        }



        if(findColor(item)== false) {



            int k= 1;
            //it will get the index to element be hashed
            int index = h(item);

            System.out.println("Modulus index: " + index);



            //look for an available
            while (ht[index].getF() != 3043050) {

                index = index + k * k;

                System.out.println("Collision Attempt: " + index + " Instead");

                index %= ht.length;

                k++;

                collisionCounter++;

            }


            System.out.println("Deixa eu ver uma antes: " + "R: " + item.getColor().getR() + " G: " + item.getColor().getG() + " B:" +  item.getColor().getB());

            this.ht[index].setColor(item.getColor());
            System.out.println("Deixa eu ver uma parada: " + "R: " + ht[index].getColor().getR() + " G: " + ht[index].getColor().getG() + " B:" +  ht[index].getColor().getB());
            ht[index].setF(item.getF());
            trackSize++;



            //find index we can store

        }



    }



   //function to check if color is already in the HT
   public boolean findColor(Freq key){


       System.out.println("This is key's status R: " + key.getColor().getR() + " G: " +key.getColor().getG() + " B: " + key.getColor().getB());

       int k = 1;

       int indexHashed = h(key);

       System.out.println("HashedTo: " + indexHashed);

       while(ht[indexHashed].getF() != 3043050){

           //it is not a new color, so we just need to increase its frequency in the hashtable
           System.out.println("This is the index hashed: " + indexHashed);
           System.out.println("this is its status: R: " + ht[indexHashed].getColor().getR() + " G: " + ht[indexHashed].getColor().getG() + " B: " +  ht[indexHashed].getColor().getB());
           System.out.println("This is key's status R: " + key.getColor().getR() + " G: " +key.getColor().getG() + " B: " + key.getColor().getB());
           if(ht[indexHashed].getColor().getR() == key.getColor().getR() && ht[indexHashed].getColor().getG() == key.getColor().getG()&&ht[indexHashed].getColor().getB() == key.getColor().getB()){

               System.out.println("Key Found. It is already stored in array. Just need to increase. It is at "+ indexHashed);
               ht[indexHashed].incrementF();

               return true;
           }

           indexHashed= indexHashed + k * k;

           // go to following possible slot

           indexHashed %= getTableLentgh();


           k++;
       }

       //color not find, so it is a new color and need to be stored in the Hashtable
       return false;
   }

    public boolean isPrime(int n)
    {
        // Corner cases
        if (n <= 1) return false;
        if (n <= 3) return true;

        // This is checked so that we can skip
        // middle five numbers in below loop
        if (n % 2 == 0 || n % 3 == 0) return false;

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

        System.out.println("This is Prime " + prime);
        return prime;
    }

    public boolean checkPrime(int value){
       if (value % 2 ==0){
           return false;
       }

       for(int i= 3; i * i >= value; i+=2){
           if (value % i == 0){
               return false;
           }
       }
       return true;
   }




   public void increaseArray (int minArraySize){

       rehashingCounter++;

       int newSize = nextPrime(minArraySize);

       increaseOld(newSize);


   }

   public void increaseOld(int newArraySize){

       System.out.println("im in increase Old");

       Freq [] cleanFromOld = removeEmptySlots(this.ht);

       for(int i=0; i< cleanFromOld.length; i++){

           System.out.println("This is f: " + cleanFromOld[i].getF());

           int k=9;
       }

       ht = new Freq[newArraySize];

       this.tableLentgh = newArraySize;

     for (int i = 0; i < newArraySize; i++) {
           Freq init = new Freq();
           ht[i] = init;

       }

       //hash clean data to new

       for (Freq obj: cleanFromOld){
           insert_Rehash(obj);
       }


   }

   public Freq[] removeEmptySlots(Freq[] arrayToBeCleaned){

       ArrayList<Freq> list = new ArrayList<>();


       for(Freq obj : arrayToBeCleaned){
           if(obj.getF()!=3043050){


               list.add(obj);
           }

       }

       for(int i = 0; i< list.size(); i++){
           System.out.println(list.get(i).getColor().getR() + ", "+ list.get(i).getColor().getG() + " , " + list.get(i).getColor().getB());
           System.out.println(list.get(i).getF());
       }

       return list.toArray(new Freq[list.size()]);
   }

   public void sortArray (){



       int size = this.tableLentgh;

       int lastIndexTable = tableLentgh -1;


       Freq [] clean = removeEmptySlots(this.ht);

       Arrays.sort(clean);

       System.out.println("Table size: " + clean.length + "  this: " + this.tableLentgh);

       for(int i= clean.length-1; i > clean.length-257; i--){

           System.out.println("Index: " + i + " "+  clean[i].getColor().getR() + " " +clean[i].getColor().getG() +" "+  clean[i].getColor().getB() + "  " + clean[i].getF());
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
