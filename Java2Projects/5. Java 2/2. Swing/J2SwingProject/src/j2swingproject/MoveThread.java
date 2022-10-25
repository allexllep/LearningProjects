package j2swingproject;
public class MoveThread implements Runnable{
    
    private Thread self;
    private JBoxFrame frame;
    private int delay;
    private volatile boolean canWork;
    
    public MoveThread(JBoxFrame frame, int delay) {
        this.frame = frame;
        this.delay = delay;
        self = new Thread(this);
    }
    
    public void start(){
        canWork = true;
        self.start();
    }
    
    public void stop(){
        canWork = false;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    
    
    @Override
    public void run() {
        try { while (canWork){
            frame.moveBox();
            Thread.sleep(delay);
        }}catch(InterruptedException ex){}
    }
    
}
