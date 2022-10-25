package j1day2class3;
public class Point2D implements Comparable<Point2D>{
    
   private int x,y;
   private double length;
   
//   private final int id;
   public final int id;
   private static int counter;
   
    public Point2D() {
        this(0,0);
    }
   
    public Point2D(int x, int y) { // полный конструктор - инициализирует все поля класса
        this.x = x;
        this.y = y;
        length();
        id=counter++;
    }
    
    public void setX(int x) {
        this.x = x;
        length();
    }
    
    public void setY(int y) {
        this.y = y;
        length();
    }    
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double getLength() {
        return length;
    }

//    public int getId() {
//        return id;
//    }

    public static int getCounter() {
        return counter;
    }
    
    @Override // @ - аннотация Override - когда новый метод заменяет старый переопределяет старый метод
    public String toString() {
        return "(" + x + "," + y + ")";
    }
   public Point2D addTo(Point2D rightValue){
       return new Point2D(this.x + rightValue.x, this.y+rightValue.y);
   }
    private void length(){
        length = Math.sqrt(x*x+y*y);
    }

    public int compareTo(Point2D secondPoint) {
        if (this.length< secondPoint.length){
            return -1;
        }else if(this.length>secondPoint.length){
            return 1;
        } else
            return 0;
    }
    
    
}
