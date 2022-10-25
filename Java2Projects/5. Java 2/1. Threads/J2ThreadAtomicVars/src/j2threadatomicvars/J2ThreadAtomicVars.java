package j2threadatomicvars;
public class J2ThreadAtomicVars {
    public static void main(String[] args) throws InterruptedException {
        
        CounterTread th1 = new CounterTread(1000);
        CounterTread th2 = new CounterTread(1000);
        
        th1.start();
        th2.start();
                
        th1.join();
        th2.join();
        
        System.out.println("value= "+ GlobalData.value);
        System.out.println("aValue= "+GlobalData.aValue);
                
    }
    
}
