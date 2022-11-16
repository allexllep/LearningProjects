
// Создать 2 потока со схожими задачами, но второй запускается только тогда, когда второй будет выполнен хотя бы на половину.
package j2threadmonitor;
public class J2ThreadMonitor {
    public static void main(String[] args) throws InterruptedException {
       Monitor mon=new Monitor();
       
       Runnable runner1=new Runnable() {
           @Override
           public void run() {
               for (int i = 0; i < 100; i++) {
                   System.out.println("1- "+i);
                   if(i>=50){ //при оповещении никогда не писать явных сравнений иначе м/б dead lock
                       synchronized (mon) {
                            mon.x=i;
                            mon.notify();
                        }
                   }
               }
           }
       };
       
       Runnable runner2=new Runnable() {
           @Override
           public void run() {
               try { 
                   synchronized (mon) {
                       while(mon.x<50) mon.wait(); //ожидание (условие пробуждения) всегда пишутся в цикле т.к. в потоках мы не можем быть уверены ни в каких абсолютных данных (время срабатывания, текущие данные и т.п.)
                    } 
                } catch (InterruptedException ex){}       
               for (int i = 0; i < 100; i++) {
                   System.out.println("2- "+i);
               }
           }
       };
       
       Thread th1 = new Thread(runner1);
       Thread th2 = new Thread(runner2);
       
       th1.start();
       th2.start();
       
       th1.join();
       th2.join(); 
       
    }  
}

class Monitor{
    int x;
}