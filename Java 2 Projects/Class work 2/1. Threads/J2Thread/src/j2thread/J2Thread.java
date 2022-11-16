package j2thread;
public class J2Thread {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("start of " + Thread.currentThread().getName());
        
        DemoThread demo = new DemoThread();
        demo.start();
        demo.join();
        
        System.out.println("end of main");
    }
    
}

class DemoThread extends Thread{ 

    @Override
    public void run() { //так никогда делать нельзя. старую реализацию меняем на новую
        System.out.println("hello from " + Thread.currentThread().getName());
    }
    
}