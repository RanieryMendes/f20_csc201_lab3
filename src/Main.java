


import java.io.*;
import java.time.Instant;
import java.time.Duration;
public class Main {



    public static void main(String[] args) throws IOException {





       //Setting the command-line arguments into the program: image file name, height, width, and array size.

        String imageName = args[0];

        String path = "src/" +imageName; //setting the proper path to the file

        int height = Integer.parseInt(args[1]);

        int width = Integer.parseInt(args[2]);

        int arraySize = Integer.parseInt(args[3]);

        //declare a hash table ht here
        hashTable HT = new hashTable(arraySize);



        //start clock counter
        Instant start = Instant.now();


        try {
            InputStream is = new FileInputStream(path);


            // create data input stream
            DataInputStream input = new DataInputStream(is);

            //create Freq object that will store RGB object and int frequency counter
            Freq element = new Freq();


            for (int i = 0; i < height; i++)
                for (int j = 0; j < width; j++) {

                    RGB pixel = new RGB();

                    pixel.setR(input.readUnsignedByte());
                    pixel.setG(input.readUnsignedByte());
                    pixel.setB(input.readUnsignedByte());



                    //set the RGB object into the Freq object
                    element.setColor(pixel);


                    //insert the Freq object into the Hashtable
                    HT.insert(element);


                }

        } catch (IOException ex) {
            ex.printStackTrace();




        }

        //stop clock
        Instant finish = Instant.now();

        //get durantion for the hashtable to allocate  all  pixels
        long duration = Duration.between(start, finish).toSeconds();



        //method to sort the hashtable and print the 256 most frequent colors.
        HT.sortArray();


        try{
            File report = new File("src/results.txt");
            if(report.isFile()){
                System.out.println("File opened");
            }


            FileWriter resul = new FileWriter(report, true);


            resul.write("\nMethod Implemented: Quadratic Probing");

            resul.write("\nFile Name: " + imageName);

            resul.write("\nDimensions: " + height + " X " + width);

            resul.write("\nInitial Table size: " + arraySize);


            resul.write("\nTestCase Findings");



            resul.write("\nRuntime " + duration +" seconds.");

            resul.write("\nNumber of Collisions: "  +  HT.number_collision());

            resul.write("\nFinal Table size: " + HT.getTableLentgh());

            resul.write("\nNumber of Rehashes: " + HT.getRehashingCounter() + "\n");

            resul.close();


        }catch(IOException e){
            System.out.println(e);

        };




        //Printing important information about program the program and test cases' implementation

        System.out.println(" \n Method Implemented: Quadratic Probing ");

        System.out.println("File Name: " + imageName);

        System.out.println("Dimensions: " + height + " X " + width);

        System.out.println("Initial Table size: " + arraySize);


        System.out.println("\nTestCase Findings");


        System.out.println("Runtime: " + duration +" seconds.");

        System.out.println("Number of Collisions: "  +  HT.number_collision());

        System.out.println("Final Table size: " + HT.getTableLentgh());

        System.out.println("Number of Rehashes: " + HT.getRehashingCounter());


    }



}

