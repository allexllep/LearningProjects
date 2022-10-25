
package J1Day1HelloWorld;

public class J1Day1HelloWorld {

    public static void main(String[] args) {

        System.out.printf("Hello world!\n");
        System.out.println("Hello world!");
        
        int a=10;
        a=a*5;
        a<<=1; //a<<1; (умножение на основание системы счисления)
        System.out.println("a = "+ a);
        
        float b= (float).1; //.1 //.1f
        b=b/0;
        System.out.println("b="+b);
        a++;
        System.out.println("a="+a);
        
    }
    
}
