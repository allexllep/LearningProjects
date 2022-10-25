package tictak;

public class TicTak {
    static int num=20;
    static int numOfThreads=3;
    public static void main(String[] args) {
        Monitor monitor = new Monitor();
        
        ThreadTwo[] threads = new ThreadTwo[numOfThreads];
        for (int i = 0; i < threads.length; i++) {
            threads[i]=new ThreadTwo(monitor, i+1);
            threads[i].getThread().start();
        }

        try {
            for (int i = 0; i < threads.length; i++) {
                threads[i].getThread().join();   
            }}catch (InterruptedException e) { e.printStackTrace();}
    }
}

class Monitor{
    int next=1;
}