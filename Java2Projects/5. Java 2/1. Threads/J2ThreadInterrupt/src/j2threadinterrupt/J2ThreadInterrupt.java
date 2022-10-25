package j2threadinterrupt;
public class J2ThreadInterrupt {
    public static void main(String[] args) {
       StopDemo demo=new StopDemo();
       
        System.out.println("start:"+demo.start());
        System.out.println("join: "+demo.join());
        //System.out.println("interr: "+demo.interrupt());
        System.out.println("stop: "+demo.stop());
        System.out.println("end of main");
    }
    
}