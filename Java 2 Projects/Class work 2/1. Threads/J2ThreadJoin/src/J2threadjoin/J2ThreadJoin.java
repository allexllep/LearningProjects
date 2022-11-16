package J2threadjoin;
public class J2ThreadJoin {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new DemoThread(), "DemoThread");
        thread.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("main: "+i);
            Thread.sleep(100);
        }
        thread.join();
        System.out.println("end of main");
    }
    
}
