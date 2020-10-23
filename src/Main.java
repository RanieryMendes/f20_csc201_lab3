import java.io.InputStream;
import java.io.FileInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.sql.SQLOutput;
import java.time.Instant;
import java.time.Duration;
public class Main {



    public static void main(String[] args) throws IOException {

        Instant start = Instant.now();

        String path = "/Users/ranierymendes/Documents/Lab3/src/Ollie300x400.raw";

       //Use four command-line arguments for your program: image file name, n, m, and array size.

        /*String imageName = args[0];

        int height = Integer.parseInt(args[1]);
        int width = Integer.parseInt(args[2]);

        int arraySize = Integer.parseInt(args[3]);
*/
        //declare a hash table ht here
        hashTable HT = new hashTable(10);

       // System.out.println(HT.ht[37].getF());


        try {
            InputStream is = new FileInputStream(path);
            // create data input stream
            Freq element = new Freq();
            DataInputStream input = new DataInputStream(is);
            for (int i = 0; i < 300; i++)
                for (int j = 0; j < 400; j++) {

                    RGB pixel = new RGB();

                    pixel.setR(input.readUnsignedByte());
                    pixel.setG(input.readUnsignedByte());
                    pixel.setB(input.readUnsignedByte());


                    element.setColor(pixel);

                    System.out.println("Baby me conta  suas cores: ");
                    System.out.println("R: " + element.getColor().getR() + " G: " + element.getColor().getG() + " B: " + element.getColor().getB());


                    HT.insert(element);


                    System.out.println(" Denovo so p confirmar   R: " + element.getColor().getR() + " G: " + element.getColor().getG() + " B: " + element.getColor().getB());



                    //Now, use the hash table somehow to add this RGB color to the frequency count
                }

        } catch (IOException ex) {
            ex.printStackTrace();




        }

        Instant finish = Instant.now();

        long duration = Duration.between(start, finish).toSeconds();

        System.out.println( HT.ht[0].getF());
        System.out.println( HT.ht[1].getF());
        System.out.println( HT.ht[2].getF());
        System.out.println("This is the size of the final ht: " + HT.ht.length);

        for(int i =0; i< HT.ht.length; i++){

            if(HT.ht[i].getF()!=3043050){
                System.out.println("Index: "+ i + " has this freq: "+ HT.ht[i].getColor().getR()+ ", " + HT.ht[i].getColor().getG() + ", " + HT.ht[i].getColor().getB()  +"  Freq is: " +HT.ht[i].getF() );
            }

        }

        System.out.println("Essa brincadeira  lasted " + duration +" seconds.");
    }

}

