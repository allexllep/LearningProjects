package j1lab2;
public class J1Lab2 {
    public static void main(String[] args) {
        ComLineParser clp=new ComLineParser(new String[]{"?","r","w"});
        clp.Parse(args);
    }
    
}
