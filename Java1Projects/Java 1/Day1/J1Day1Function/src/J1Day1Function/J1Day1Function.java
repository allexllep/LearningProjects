
package J1Day1Function;

public class J1Day1Function {

    public static void main(String[] args) {
     
        System.out.println("sum = " + sum(1,2));
        System.out.println("sum = "+sum(1,2,3,4,5,6));
    }

//    private static int sum(int a, int b) {
//        
//        return a+b;
//    }
//
//    private static int sum(int a, int b, int c) {
//        return a+b+c;
//    }
 
    
    
    private static int sum(int ... x){
        int s=0;
//        for (int i=0;i<x.length;i++){
//            s+=x[i];
//        }
        for(int xi:x){
            s+=xi;
        }
        return s;
    }
}
