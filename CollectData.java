import java.util.Arrays;
import java.util.Random;
import java.io.File;
import java.io.PrintWriter;
import java.io.*;
import java.util.*;
/**
 *Application to sort an array of random numbers. 
 *
 *Program 1 
 *@author Erika Yardumian 
 *@version 3/16/19
 */

public class CollectData {

   public static void main(String[] args) {
   //Generates random numbers.
      Random random = new Random();
   //Array to store 1000 random values.
      int[] G = new int[100];
      int[] A = new int[100];
      int maxvalue = 100;
      int counter = 0;
      long n;
      ArrayList<Long> time = new ArrayList<Long>(counter);
      ArrayList<Long> size = new ArrayList<Long>(counter);
      ArrayList<Long> timeSquared = new ArrayList<Long>(counter);
      //Generates the random values array.         
      for (int i = 0; i < G.length; i++) {
         G[i] = random.nextInt(maxvalue);
      }        
      for (n = 10; n < G.length; n += 10) { 
      //Copies values from array G to array A.
         for (int k = 0; k < n; k++) {
            A[k] = G[k];
         }
         
         System.out.println(Arrays.toString(A));
      
         //Start timing 
         long startTime = System.nanoTime();
      //Sorts array A.         
         for (int j = 0; j < n - 1; j++) {
            int index = j;
            for (int i = j + 1; i < n; i++) {
               if (A[i] < A[j]) {
                  //swap A[i] and A[j]
                  int buffer = A[i];
                  A[i] = A[j];
                  A[j] = buffer;
               }
            }
         }
         //End timing.
         long endTime = System.nanoTime();
         counter++;
         long totalTime = endTime - startTime;
         long timeSq = totalTime/(n*n);
         //System.out.println(totalTime);
         //System.out.println(n);
         //System.out.println(n*n);
         //System.out.println(timeSq);
         System.out.println(Arrays.toString(A));
         
         time.add(totalTime);
         size.add(n);
         timeSquared.add(timeSq);       
      }
   
      File F = new File("Times.txt");
      try {
         PrintWriter printWriter = new PrintWriter(F);
         for (int i = 0; i < counter; i++) {
            printWriter.println(size.get(i) + ", " + timeSquared.get(i));
         }
         printWriter.close();
      }
      catch (FileNotFoundException ex) {
         System.out.println("File not found.");
      }
   
   }
}
