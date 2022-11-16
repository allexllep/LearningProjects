package j2threadsynchronized;
public class J2ThreadSynchronized {
    public static void main(String[] args) throws InterruptedException {
        
        Test test = new Test();
        Thread[] threads = new Thread[5];
        for (int i = 0; i < threads.length; i++) {
            threads[i]=new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    test.increment();
                }
            });
            threads[i].start();
        }
        
        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }
        System.out.println("x= "+test.x);
        
    }
    
}

class Test {
    int x;
    synchronized void increment(){ //не использовать такую синхронизацию по методу
        x++;
    }
}