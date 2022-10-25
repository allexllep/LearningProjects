package J2threadjoin;
public class DemoThread implements Runnable{//наследование от Thread-а никогда не применяется. Поток как инструмент, а мы используем интерфейс

    @Override
    public void run() {
       try{ for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+ ": "+ i);
            Thread.sleep(100);//таким нельзя пользоваться. Вообще thead.sleep нельзя пользоваться иначе как для иммитации задержки пользователя
        }}catch(InterruptedException ex){}
    }
    
}
