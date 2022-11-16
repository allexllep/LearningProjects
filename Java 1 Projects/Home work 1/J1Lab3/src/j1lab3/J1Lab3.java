package j1lab3;
public class J1Lab3 {
    public static void main(String[] args) {
        SimpleParser sp=new SimpleParser(new String[]{"?","r","w"});
        sp.Parse(args);
        System.out.println("inFile: "+sp.getInFile()+" outFile: "+sp.getOutFile());
    }
    
}
