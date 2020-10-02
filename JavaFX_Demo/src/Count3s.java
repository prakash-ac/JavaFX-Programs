import java.io.*;


/*
Student Name: Prakash Acharya
Course: Software Engineering
Instructor: Courtney Brown
Date: 2020-09-20
File Name: Count3s.java
Description: Reads the threesData.bin file, counts the number of 3's stored in 
             the file as 32-bit signed integers, and prints the count on the output console.
*/

public class Count3s{
   public static void main(String[] args) throws IOException {
      int count = 0;
      byte [] bytes = new byte[4];
      int num;
      FileInputStream ifStream = new FileInputStream("/Users/prakash/eclipse-workspace/threesData.bin");
      DataInputStream idStream = new DataInputStream(ifStream); 
      while(ifStream.read(bytes) != -1){
    	   num = idStream.readInt();
    	   if(num==3)
    		   count++;
     }
     System.out.println("Number of 3's in the file is: " + count);
       
 }
}
      
      
