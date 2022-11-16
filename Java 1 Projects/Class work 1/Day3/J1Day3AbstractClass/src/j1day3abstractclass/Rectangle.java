package j1day3abstractclass;
public class Rectangle extends Shape{
    private int a,b;

    public Rectangle(int a, int b, int x, int y, String name) {
        super(x, y, name);
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return super.toString() + ", a=" + a + ", b=" + b;
    }
    
    @Override
    public double area(){
        return a*b;
    }
}
