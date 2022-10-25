package j1day4exception;

public class J1Day4Exception {
    public static void main(String[] args) {
        try{
            demo(0);
        } catch(ArithmeticException ex){ // ex - локальные переменные
            System.out.println("/ by 0");
            System.out.println(ex.getMessage());
        }finally{ //выполняется в любом случае, но он не нужен в современной Java, если try пишется с ресурсами
            
        }
        System.out.println("end of main()");
    }

    private static void demo(int a) {
           switch(a){
               case 0: int x=1/a; break;
               default: System.out.println("all is well");
           }
    }
    
}
