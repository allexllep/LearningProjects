package j1day5singletonlazyinit;
public class Singleton {
   
    private volatile static Singleton instance; //volitile запрещает оптимизацию переменной, у которой стоит это ключевое слово
    
    private Singleton(){}

    public synchronized static Singleton getInstance() { // никогда не синхронизировать по методу: synchronized - запрещает обращение к методу более чем из одного потока.
        if(instance == null)instance = new Singleton();
        return instance;
    }
 
    
    
}
