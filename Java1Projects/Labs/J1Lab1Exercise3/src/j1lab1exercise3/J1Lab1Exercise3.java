package j1lab1exercise3;
public class J1Lab1Exercise3 {
    public static void main(String[] args) {
        System.out.println(getBinary(15));
    }  
 
    private static String getBinary(int num){
       StringBuilder str=new StringBuilder();
        for (int i = 0; i < 32; i++) {
            str.append(((num&1)==1)?1:0);
            num>>=1;
            if (i==7 || i==15 || i==23) str.append(' ');  
        }
        str.reverse();
    return str.toString();
    }   
}
