
package j1day3inheritance;

public class TestPair extends Test{
    
    private int y;

    public TestPair() {
        super(0);//обращение к суперклассу
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    
    
}
