package j2day5server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class J2Day5Server {

    public static void main(String[] args) throws IOException {
        
// Сервер вкл. первым и открывает порт.
        ServerSocket server = new ServerSocket(30333); // при выполнении этой строки открывается порт и сокет вешается на него.
       
        while(true){
            Socket sock = server.accept(); // в случае подключения к вышеуказанному порту клиента, метод accept устанавливает сетевое соединение с увдаленным пк. Это блокирующий вызов, но interrupted ex нет, т.к. исключение будет в ОС и мы получим IO exception. Програмно, accept нужно размещать в отдельном потоке, чтобы могли подключаться много клиентов.
            System.out.println("client " + sock.getInetAddress().getCanonicalHostName() + " connected");
            new ClientThread(sock).startProcessing();
            
        }
        
//        BufferedReader reader = new BufferedReader(new InputStreamReader(sock.getInputStream())); //socket-ы это потоки, они универсальны и предназначены для передачи произвольных данных по сети. Поэтому для чтения данных по сети нам нужен конвертер.
//        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
        
        
//        String str;
//        
//        while(true){
//            str = reader.readLine();
//            if("exit".equals(str)) break;
//            System.out.println("client sent: " + str);
//            
//
//            writer.write("accepted\n");
//            writer.flush(); //принудительный сброс потока, чтобы дать понять, что сообщение передано полностью. Если этого не сделать, то читалка зависнет в ожидании следующего сообщения.
//            // закрывать ридер и райьтер командой close() не нужно, т.к. при разрыве соединения, файлы закроются сами.
//        }
//        System.out.println("client disconnected");
    }
}
