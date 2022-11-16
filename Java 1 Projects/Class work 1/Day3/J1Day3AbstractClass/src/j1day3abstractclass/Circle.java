package j1day3abstractclass;
public class Circle extends Shape{
    private int r;

    public Circle(int r, int x, int y, String name) {
        super(x, y, name);
        this.r = r;
    }

    @Override
    public String toString() {
        return super.toString() + ", r=" + r;
    }
    @Override
    public double area(){
        return Math.PI*r*r;
    }
}
