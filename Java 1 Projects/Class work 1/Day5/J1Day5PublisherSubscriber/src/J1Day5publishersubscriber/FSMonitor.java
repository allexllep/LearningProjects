
package J1Day5publishersubscriber;

public interface FSMonitor {
    
    public int CREATED = 1;
    public int REMOVED = 2;
    
    public void fireEvent(int kind, String fileName); // как правило полезно через возвращаемое значение следить о принятии оповещения или об ошибке
    
}
