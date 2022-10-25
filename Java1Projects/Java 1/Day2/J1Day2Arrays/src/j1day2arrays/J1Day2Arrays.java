
package j1day2arrays;

import java.util.Arrays;
import java.util.Random;

public class J1Day2Arrays {
    public static void main(String[] args) {

        // int[] m1,m2; //m1,m2 - массивы, поэтому [] возле типа, а не имени
          //int[] a[], b; -> int[] a[], b; a-двумерный массивб b- одномерный
         int[] m = new int[10];
        Random rnd= new Random();
        for (int i = 0; i < m.length; i++) {
            m[i]=rnd.nextInt(20);//0-20
        }
        
        System.out.println(Arrays.toString(m));
        Arrays.sort(m);
        System.out.println(Arrays.toString(m));
    }
    
}
