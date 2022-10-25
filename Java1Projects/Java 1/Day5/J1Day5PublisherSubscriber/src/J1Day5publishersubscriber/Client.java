package J1Day5publishersubscriber;
public class Client implements FSMonitor{

    @Override
    public void fireEvent(int kind, String fileName) {
        switch (kind) {
            case FSMonitor.CREATED: System.out.println(fileName + " - created");
            break;
            case FSMonitor.REMOVED: System.out.println(fileName + " - removed");
            break;
            default: System.out.println("Smth strange happend");

        }
    }
    
}
