package j2threadparallelism;
public class SumThread implements Runnable{
    
    private Thread self;
    private int position;

    public SumThread(int position) {
        this.position = position;
        self=new Thread(this);
    }
    public void start() {
        self.start();
    }
    
    public void join() throws InterruptedException{
        self.join();
    }

    @Override
    public void run() {
        for (int i = position; i < GlobalData.ARRAY_SIZE; i+=GlobalData.THEAD_COUNT) {
            GlobalData.results[position]+=GlobalData.array[i];
        }
    }
    
}
