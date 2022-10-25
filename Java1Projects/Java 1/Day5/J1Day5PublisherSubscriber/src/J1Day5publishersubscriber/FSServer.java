package J1Day5publishersubscriber;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.ArrayList;

public class FSServer {
    
    private String dirPath;
    private ArrayList<FSMonitor> clients;
    private volatile boolean canWark;

    public FSServer(String dirPath) {
        this.dirPath = dirPath;
        clients = new ArrayList();
    }
    
    //т.к. мы работаем по ссылкам, то мы можем по ссылкам добавлять клиентов и удалять их
   public void addClient(FSMonitor client){
       clients.add(client);
   }
                    
   public void removeClient(FSMonitor client){
       clients.remove(client);
   }
   public void start(){
        canWark = true;
        run();
   }
    
   public void stop(){
        canWark = false;
   }
   
   public void run(){
        try{
            WatchService watch = FileSystems.getDefault().newWatchService(); //newWatchService() - система наблюдателя, отслеживающая изменения файловой системы. Объект типа интерфейса, он нужен только для связи FS с классами, которые могут следить за файловой системой.
            Paths.get(dirPath).register(watch,
                    StandardWatchEventKinds.ENTRY_CREATE,
                    StandardWatchEventKinds.ENTRY_DELETE); // привязка наблюдателя watch к файловой системе, а именно указание директории и отслеживаемые события. Также называется регистрацией наблюдателя.
            
            while(canWark){
                WatchKey key = watch.take();// WatchKey - описатель, инструмент в ЯП, описывающие слюжебную информацию, наблюдаемую в конкретной программе. Это интерфейс, позволяющий понять, какое событие произошло. Возможно  interrupted exeption. Существуют блокирующие и неблокирующие методы. Неблокирующие - это когда вызывается метод и продолжается работа, не дожидаясь возвращаемого значения. Блокирующие - пока мы не получим возвращаемое значение метода, мы из метода не выйдем. Таких методов большинство. Метод take() - это метод, который при помощи наблюдателя получает информацию о событии в FS. Если файлы не создаются и не удаляются, то метод take() повиснет. В таком случае из цикла можно выйтипри помощи специальной комманды управления потоками interrupt(прерывание) - это аварийная остановка. Если аварийно остановить зависший поток, эта остановка приведет к исключению прерывания Interrupted exception. 
                
                for (WatchEvent<?> pollEvent : key.pollEvents()) { // в каждом ключе м/б несколько событий, поэтому их надо перебрать в цикле foreach. pollEvent - это событие.
                    String fName = pollEvent.context().toString(); // берем из контекста. Метаданные - это данные о данных, а контекст - это данные вокруг данных, они делают данные целостными. В данном случае, имя файла - это контекст события, произошедшего с этим файлом.
                    int kind;
                    if(pollEvent.kind() == StandardWatchEventKinds.ENTRY_CREATE) kind = FSMonitor.CREATED;
                    else kind = FSMonitor.REMOVED;
                    
                    for(FSMonitor client : clients){ // оповеаем клиентов
                        client.fireEvent(kind, fName);
                    }
                }
                key.reset(); //освобождаем ключ - аналог close для ресурсов. Если ключ не освободить, то уже после первого действия мы перестанем принимать сообщения об изменениях
            }
            
            watch.close();//watch - это ресурс, поэтому его обязательно надо закрыть. Ресурсы, требующие закрытия лучше обрабатывать в специальном try  с ресурсами или обрабатывать специальные исключительные ситуации.
            
        }  catch(IOException ex){
            System.out.println(ex.getMessage());
        }  catch(InterruptedException ex){ //inerrupted exeption
            //.....
        }
   }
}
