package tictak;

public class ThreadTwo implements Runnable
{
    private Thread thread;
    private Monitor monitor;
    private int numOfThisThread;

    public Thread getThread () {
        return thread;
    }

    public ThreadTwo(Monitor mon, int numOfThread) {
        thread = new Thread (this);
        monitor = mon;
        numOfThisThread = numOfThread;
    }
    
    public void run() {
        try{
            for (int i = 0; i < TicTak.num; i++) {
                synchronized (monitor) {
                    while (numOfThisThread != monitor.next) monitor.wait();
                }
                
                if (numOfThisThread != TicTak.numOfThreads){
                    System.out.print(numOfThisThread + " - ");             
                } else {
                    System.out.println(TicTak.numOfThreads);
                }
                
                synchronized (monitor) {
                    monitor.next = (numOfThisThread != TicTak.numOfThreads) ? numOfThisThread+1 : 1 ;
                    monitor.notifyAll();
                }
            }
        } catch (InterruptedException e) { e.printStackTrace(); }
    }
}
