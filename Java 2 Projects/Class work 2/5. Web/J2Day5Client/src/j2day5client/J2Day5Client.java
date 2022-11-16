package j2day5client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class J2Day5Client {
    public static void main(String[] args) throws IOException {
        
        Socket sock = new Socket("localhost", 30333);
          
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
        BufferedReader reader = new BufferedReader(new InputStreamReader(sock.getInputStream()));
        String str;
        Scanner scan = new Scanner(System.in);
        
        while(true) {
            str = scan.nextLine();
            writer.write(str);
            writer.write("\n");
            writer.flush();

            if("exit".equals(str)) break;
            
            str = reader.readLine();
            System.out.println("server sent: " + str);
        }
    }   
}
