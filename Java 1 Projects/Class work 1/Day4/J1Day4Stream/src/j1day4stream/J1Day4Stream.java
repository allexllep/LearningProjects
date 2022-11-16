package j1day4stream;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class J1Day4Stream {
    public static void main(String[] args) throws IOException {
        
        int[] m = {1,2,3,4,5};
        
        DataOutputStream dos=new DataOutputStream(new BufferedOutputStream(new FileOutputStream("binary.txt")));
        
        dos.writeInt(m.length);
        for (int mi : m) {
            dos.writeInt(mi);
        }
        
        dos.close();
    }
}
