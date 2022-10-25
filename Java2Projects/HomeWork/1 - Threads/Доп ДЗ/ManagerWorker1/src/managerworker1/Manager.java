package managerworker1;
public class Manager implements Runnable{
    
    private Thread self;
    private Task task;
    private int numberOfThreads;
    private int repeatNumber;
    private boolean taskNumber1;
    private Monitor mon;

    public Manager(Task task, int numberOfThreads, int repeatNumber,boolean taskNumber1) {
        self = new Thread(this);
        this.task = task;
        this.numberOfThreads = numberOfThreads;
        this.repeatNumber = repeatNumber;
        this.taskNumber1 = taskNumber1;
        this.mon = new Monitor();       
    }
        
    public void start(){
        self.start();
    }
     
    public void join() throws InterruptedException{
        self.join();
    }

    @Override
    public void run() {
        
        Monitor mon = new Monitor();
        if (taskNumber1) {         
            taskOne();
        } else {
            taskTwo();
        }   
    }     
    
    private void taskOne(){
        
        Worker[] workers = new Worker[numberOfThreads];
        for (int i = 0; i < this.numberOfThreads; i++) {
            workers[i] = new Worker(task, repeatNumber, mon);
            workers[i].start();
        }
        
        try{ for (int i = 0; i < this.repeatNumber; i++) {
            synchronized(mon){
                while(mon.monitorcounter<numberOfThreads) mon.wait(); 
                task.taskForManager();
                mon.monitorcounter = 0;
                for (int j = 0; j < numberOfThreads; j++) workers[j].setCanWork(true);  
                mon.notifyAll();
            }
        }} catch (InterruptedException ex) {}
        
        try{
            for (int i = 0; i < this.numberOfThreads; i++) workers[i].join();
        } catch (InterruptedException ex) {}
    }
    
    private void taskTwo(){
        
            Thread[] workers = new Thread[numberOfThreads];
            for (int i = 0; i < numberOfThreads; i++) {
                workers[i] = new Thread(() -> {   
                    synchronized (mon) {
                        while (mon.monitorcounter<repeatNumber){
                            try {
                                task.taskForWorker();
                                mon.monitorcounter++;
                                mon.notifyAll();
                                if (mon.monitorcounter<repeatNumber) mon.wait();
                            } catch (InterruptedException ex) {           }
                        }  
                    }
                });
                workers[i].start();
            }
            
            try{ synchronized(mon){
                while(mon.monitorcounter<repeatNumber) mon.wait(); 
                task.taskForManager();
            }} catch (InterruptedException ex) {}
            
            try{ for (int i = 0; i < this.numberOfThreads; i++) {
                workers[i].join();
            }} catch (InterruptedException ex) {}
        }
    }
    
class Monitor{
    int monitorcounter=0;
}
