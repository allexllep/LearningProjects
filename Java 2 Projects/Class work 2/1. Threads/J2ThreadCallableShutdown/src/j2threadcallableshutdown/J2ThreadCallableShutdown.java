package j2threadcallableshutdown;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class J2ThreadCallableShutdown {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        
        ArrayList<Future<String>>results = new ArrayList();
        
        ExecutorService exec = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 12; i++) {
            results.add(exec.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    Thread.sleep(1000);
//                    System.out.println(Thread.currentThread().getName());
//                    return null;
                   return Thread.currentThread().getName();
                }
            }));
        }
        
        //......... - та часть main-а, которая будет исполняться ассинхронно к задачам пула (без синхронизации). Эта часть называется основной задачей. Побочный исполняется в executor-е.
        
        exec.shutdown();//shutdown - завершить, shutdownNow - выключить, выключает executor не давая решить задачу
        
        for (Future<String> result : results) {
            System.out.println(result.get());
        }
        
        System.out.println("end of main");
    }
    
}
