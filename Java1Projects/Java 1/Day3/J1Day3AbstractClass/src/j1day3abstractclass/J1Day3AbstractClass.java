package j1day3abstractclass;
public class J1Day3AbstractClass {
    //создать массив, который может хранить rectangles и cirles
    public static void main(String[] args) {
        Shape[] shapes={
            new Rectangle(2, 3, -1, 2, "Rectangle0"),
            new Circle(10, 2, -3, "Circle0"),
            new Rectangle(4, 5, 9, 1, "Rectangle1")
        };
        for (Shape shape : shapes) {
                    System.out.println(shape.area());             
        }
          
        for (Shape shape: shapes){
            if(shape instanceof Rectangle){
                Rectangle rect=(Rectangle) shape;
                System.out.println(rect.area());
            } else if(shape instanceof Circle)
                    System.out.println(((Circle)shape).area());
        }
                
    }
}
