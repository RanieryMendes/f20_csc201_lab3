import java.io.InputStream;
import java.io.FileInputStream;
import java.io.DataInputStream;
import java.io.IOException;

public class Main {



    public static void main(String[] args) throws IOException {



        String path = "/Users/ranierymendes/Documents/Lab3/src/Fall800x1200.raw";

       //Use four command-line arguments for your program: image file name, n, m, and array size.

        /*String imageName = args[0];

        int height = Integer.parseInt(args[1]);
        int width = Integer.parseInt(args[2]);

        int arraySize = Integer.parseInt(args[3]);
*/
        //declare a hash table ht here
        try {
            InputStream is = new FileInputStream(path);
            // create data input stream
            DataInputStream input = new DataInputStream(is);
            for (int i = 0; i < 1200; i++)
                for (int j = 0; j < 800; j++) {

                    RGB pixel = new RGB();

                    pixel.setR(input.readUnsignedByte());
                    pixel.setG(input.readUnsignedByte());
                    pixel.setB(input.readUnsignedByte());


                    //Now, use the hash table somehow to add this RGB color to the frequency count
                }

        } catch (IOException ex) {
            ex.printStackTrace();




        }
}}

