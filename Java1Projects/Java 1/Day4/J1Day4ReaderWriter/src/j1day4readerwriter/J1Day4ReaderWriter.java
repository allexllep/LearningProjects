package j1day4readerwriter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class J1Day4ReaderWriter {
    public static void main(String[] args) {
       try(FileWriter writer=new FileWriter("hello.txt")){ //try с ресурсами
           writer.write("Hello from Java!");
       }catch(IOException ex){
           System.out.println(ex.getMessage());
       }
        
        
        try(BufferedReader reader=new BufferedReader( new FileReader("test.txt"))){
       String str=reader.readLine();
            System.out.println(str);
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        
    }
    
}
