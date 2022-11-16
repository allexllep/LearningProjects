package J1Day5publishersubscriber;
public class J1Day5PublisherSubscriber {
    public static void main(String[] args) {
        
        FSServer server = new FSServer(".");
        server.addClient(new Client()); // добавляем клиента сразу инвче программа уйдет в цикл, и не сможем оповестить.
        server.start();
        
    }
    
}
