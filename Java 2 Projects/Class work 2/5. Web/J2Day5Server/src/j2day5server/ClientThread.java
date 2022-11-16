package j2day5server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ClientThread implements Runnable{
    
    private  Thread self;
    private Socket sock;
    private static int counter;
    private int id;
    private BufferedReader reader;
    private BufferedWriter writer;
    
    public ClientThread(Socket sock) {
        this.sock = sock;
        id = counter++;
        self = new Thread(this, "ClisentThread-" + id);
    }
    
   public void startProcessing() throws IOException {
        reader = new BufferedReader(new InputStreamReader(sock.getInputStream()));
        writer = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
        self.start();
    }

    @Override
    public void run() {
        String str;
        
        try{ while(true){
            
            str = reader.readLine();
            if("exit".equals(str)) break;
            System.out.println("client " + id + " sent: " + str);
            

            writer.write("accepted\n");
            writer.flush();
        }} catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        
        System.out.println("client " + id + " disconnected");
    }
    
}
