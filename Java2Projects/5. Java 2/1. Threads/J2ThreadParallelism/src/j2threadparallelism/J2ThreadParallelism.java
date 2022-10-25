// вычесление суммы элементов массива с испльзованием нескольких потоков
package j2threadparallelism;

import java.util.Random;

public class J2ThreadParallelism {
    public static void main(String[] args) throws InterruptedException {
        
        GlobalData.array = new int[GlobalData.ARRAY_SIZE];
        GlobalData.results = new long[GlobalData.THEAD_COUNT];
        Random rnd = new Random();
        for (int i = 0; i < GlobalData.ARRAY_SIZE; i++) {
            GlobalData.array[i] = rnd.nextInt(10);
        }
        
        long sum1=0;
        long t1= System.currentTimeMillis();
        for (int i = 0; i < GlobalData.ARRAY_SIZE; i++) {
            sum1+=GlobalData.array[i];
        }
        long t2 = System.currentTimeMillis();
        System.out.println("sum1 = " + sum1 + ", time: " + (t2-t1));
        
        SumThread[] threads = new SumThread[GlobalData.THEAD_COUNT];
        for (int i = 0; i < GlobalData.THEAD_COUNT; i++) {
            threads[i] = new SumThread(i);
        }
        long sum2 = 0;
        long t3 = System.currentTimeMillis();
        
        for (int i = 0; i < GlobalData.THEAD_COUNT; i++) {
            threads[i].start();
        }
        for (int i = 0; i < GlobalData.THEAD_COUNT; i++) {
            threads[i].join();
        }
        for (int i = 0; i < GlobalData.THEAD_COUNT; i++) {
            sum2 += GlobalData.results[i];
        }
        long t4 = System.currentTimeMillis();
        System.out.println("sum2 = "+ sum2 + ", time: " + (t4-t3));   
    }   
}
