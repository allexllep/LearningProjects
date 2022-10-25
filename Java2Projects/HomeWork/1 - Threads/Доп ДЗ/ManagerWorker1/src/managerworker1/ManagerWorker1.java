package managerworker1;
public class ManagerWorker1 {
    public static void main(String[] args) throws InterruptedException {
        
        Task tsk = new Task();
        Manager man = new Manager(tsk,10,15,true); // Задание 1: taskNumber1 == true, Задание 2: taskNumber1 = false.
        man.start();
        man.join();
    }
}

class Task{
    public void taskForWorker(){
       System.out.print(Thread.currentThread().getName() + " ");
    }
    
    public void taskForManager(){
        System.out.println();
    }
}
