package j2threadinterrupt;
public class StopDemo implements Runnable{
    
    private Thread self; //self-thread собственный поток
    private int counter;
    private volatile boolean canWork=true;

    public StopDemo() {
        counter=0;
        self=new Thread(this);
    }
    
    public int start(){
        canWork=true;
        self.start();
        return counter;
    }
    
    public int join(){
        try { self.join(2000);
        } catch (InterruptedException ex) {}
        return counter;
    }
    
    public int interrupt(){
        System.out.println("sending interrupt");
        self.interrupt();
        return counter;
    }

    public int stop(){
        canWork=false;
        System.out.println(canWork);
        return  counter;
    }
    
    @Override
    public void run() {   
//        while(true){
//            counter++; 
//            try {
//                Thread.sleep(100);//sleep позволяет перевести поток в состояние WAITING, а try-catch - поймать interrupt(прерывание) без этого interrupt() не работает
//            } catch (InterruptedException ex) {
//                System.out.println("caught interrupt and exit");
//                break;
//            }
//        }    

        while(canWork){
            counter++;
        }
    }
    
}
