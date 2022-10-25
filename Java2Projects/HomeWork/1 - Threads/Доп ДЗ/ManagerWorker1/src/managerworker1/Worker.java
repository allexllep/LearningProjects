package managerworker1;

public class Worker implements Runnable{
    private Thread self;
    private Task task;
    private int repeatNumber;
    volatile private boolean canWork;
    private Monitor mon;

    public Worker(Task task, int repeatNumber, Monitor monitor) {
        self = new Thread(this);
        this.canWork = true;
        this.task = task;
        this.repeatNumber = repeatNumber;
        this.mon = monitor;
        
    }
    
    public void start(){
        self.start();
    }
    
    public void join() throws InterruptedException{
        self.join();
    }

    public void setCanWork(boolean canWork) {
        this.canWork = canWork;
    }

    @Override
    public void run() {
        try { for(int i=0; i < repeatNumber; i++){
            synchronized (mon) {
                while(!canWork) mon.wait();
                task.taskForWorker();
                mon.monitorcounter++;
                canWork = false;
                mon.notifyAll(); 
            }
        }} catch (InterruptedException ex) {}  
    }
}

