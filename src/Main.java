/*
Raniery Mendes
CSC201 Fall 2020
Programming Assignment 3
October 29, 2020
 */

//This program uses a hash table to perform the  count the frequencies of different colors in an uncompressed RGB digital image.
// The 256 most frequently occurring colors are print  out in a table with their RGB values.


//Input values are taken from the command line
//Image file that is read by the program must be located at the src folder.



import java.io.*;
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
        long start = System.nanoTime();



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
        long finish = System.nanoTime();

        //get durantion for the hashtable to allocate  all  pixels
        long duration =  finish - start;

        long time_in_miliseconds= duration/1000000;

        long time_in_seconds = time_in_miliseconds /1000;


        //method to sort the hash table and print the 256 most frequent colors.
        HT.sortArray();


        //Printing important information about program the program and test cases' implementation

        System.out.println(" \nMethod Implemented: Quadratic Probing ");

        System.out.println("File Name: " + imageName);

        System.out.println("Dimensions: " + height + " X " + width);

        System.out.println("Initial Table size: " + arraySize);


        System.out.println("\nTest Case Findings");


        System.out.println("Runtime: " + time_in_miliseconds +" milliseconds.");

        System.out.println("Number of Collisions: "  +  HT.number_collision());

        System.out.println("Final Table size: " + HT.getTableLentgh());

        System.out.println("Number of Rehashes: " + HT.getRehashingCounter());


    }



}

