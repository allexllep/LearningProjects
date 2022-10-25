package j1day4file;

import java.io.File;
import java.io.IOException;


public class J1Day4File {
    public static void main(String[] args){// throws IOException {
        File file= new File("text.txt");
        try {
            file.createNewFile();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
        //файлы, хранящиеся в дирректории
        File dir = new File(".");
        File[] files = dir.listFiles(File::isFile); // список файлов в директории File::isFile - member reference
        for (File f : files) {
            System.out.println(f.getName());
        }
    }
    
}
