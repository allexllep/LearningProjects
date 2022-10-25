package j2threadatomicvars;
public class CounterTread implements Runnable{
    
    private Thread self;
    private int steps;

    public CounterTread(int steps) {
        this.steps = steps;
        self = new Thread(this);
//        self.start();
    }
    
    public void start(){
        self.start();
    }
    public void join() throws InterruptedException{
      self.join();
    }

    @Override
    public void run() {
        for (int i = 0; i < steps; i++) {
            GlobalData.value++;
            GlobalData.aValue.getAndIncrement();// - аналог ++ для атомарной переменной
        }
    }
}
 