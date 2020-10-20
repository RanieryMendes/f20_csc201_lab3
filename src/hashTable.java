import java.util.ArrayList;
import java.util.Hashtable;

public class hashTable {
   Freq [] ht;
   private int tableLentgh =101;

   hashTable(){
       ht = new Freq [101] ;
   }

   hashTable(int size){
       ht = new Freq[size];
       this.tableLentgh=size;
   }

   public int h (Freq el) {

      int value =  el.getColor().getR() * el.getColor().getB() * el.getColor().getG();

      int resultToHash = value % this.tableLentgh;

      return resultToHash;

   }

   public void insert (Freq item){

       //it will get the index to element be hashed
       int index = h(item);


   }


}
