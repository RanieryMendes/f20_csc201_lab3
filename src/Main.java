import java.io.InputStream;
import java.io.FileInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.time.Instant;
import java.time.Duration;
import java.io.File;
import  java.io.PrintWriter;
import java.util.Collections;
public class Main {



    public static void main(String[] args) throws IOException {

        Instant start = Instant.now();

        String path = "/Users/ranierymendes/Documents/Lab3/src/Ollie200x200.raw";

       //Use four command-line arguments for your program: image file name, n, m, and array size.

        /*String imageName = args[0];

        int height = Integer.parseInt(args[1]);
        int width = Integer.parseInt(args[2]);

        int arraySize = Integer.parseInt(args[3]);
*/
        //declare a hash table ht here
        hashTable HT = new hashTable(1001);

       // System.out.println(HT.ht[37].getF());



        try {
            InputStream is = new FileInputStream(path);
            // create data input stream
            Freq element = new Freq();
            DataInputStream input = new DataInputStream(is);
            for (int i = 0; i < 200; i++)
                for (int j = 0; j < 200; j++) {

                    RGB pixel = new RGB();

                    pixel.setR(input.readUnsignedByte());
                    pixel.setG(input.readUnsignedByte());
                    pixel.setB(input.readUnsignedByte());


                    element.setColor(pixel);

                    System.out.println("Baby me conta  suas cores: ");
                    System.out.println("R: " + element.getColor().getR() + " G: " + element.getColor().getG() + " B: " + element.getColor().getB());
                    if(element.getColor().getG()==255){
                        System.out.println("im green");
                    }

                    HT.insert(element);


                    System.out.println(" Denovo so p confirmar   R: " + element.getColor().getR() + " G: " + element.getColor().getG() + " B: " + element.getColor().getB());



                    //Now, use the hash table somehow to add this RGB color to the frequency count
                }

        } catch (IOException ex) {
            ex.printStackTrace();




        }

        Instant finish = Instant.now();

        long duration = Duration.between(start, finish).toSeconds();


        System.out.println("This is the size of the final ht: " + HT.ht.length);

        for(int i =0; i< HT.getTableLentgh(); i++){

            if(HT.ht[i].getF()!=3043050){
                System.out.println("Index: "+ i + " has this Color: "+ HT.ht[i].getColor().getR()+ ", " + HT.ht[i].getColor().getG() + ", " + HT.ht[i].getColor().getB()  +"  Freq is: " +HT.ht[i].getF() );
            }

        }

       HT.sortArray();

       // int [ ] test = {0,1,2,3,4,5,6,7,8,9};

       // for (int i= test.length -1; i> test.length-6; i--){
          //  System.out.println("This is test i:  " + i );
       // }

        File report = new File("results.txt");

        PrintWriter resul = new PrintWriter(report);


        resul.write("Essa brincadeira  lasted " + duration +" seconds.");

        resul.println("Number of Collisions: "  +  HT.number_collision());

        resul.println("Final Table size: " + HT.getTableLentgh());

        resul.println("Number of Rehashes: " + HT.getRehashingCounter());

        System.out.println("Method Implemented: Quadratic Probing ");

        System.out.println("File Name: ");

        System.out.println("Dimensions: ");

        System.out.println("Initial Table size: ");





        System.out.println("Essa brincadeira  lasted " + duration +" seconds.");

        System.out.println("Number of Collisions: "  +  HT.number_collision());

        System.out.println("Final Table size: " + HT.getTableLentgh());

        System.out.println("Number of Rehashes: " + HT.getRehashingCounter());


    }



}

