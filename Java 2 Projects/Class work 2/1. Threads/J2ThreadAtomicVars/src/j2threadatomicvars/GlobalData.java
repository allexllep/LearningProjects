package j2threadatomicvars;

import java.util.concurrent.atomic.AtomicInteger; //concurrency - многопоточность

public class GlobalData {
    public static int value; //static чтобы привязать value к классу
    public static AtomicInteger aValue = new AtomicInteger();// атомарное Value
    
}
