package j1day3interfacespecialclasses;

import java.util.Arrays;

public class J1Day3InterfaceSpecialClasses {
    public static void main(String[] args) {
        Box[] boxes={
            new Box(1,10,10),
            new Box(3,3,3),
            new Box(2,1,1)
        };
        
        Arrays.sort(boxes);
        
        for (Box box : boxes) {
            System.out.println(box);
        }
        
//        1. Использование внутреннего класса inner class
//        Box.CompareByA cmp=boxes[0].new CompareByA(); // new пишем у объекта, чтобы создать экземпляр внутреннего класса. Такой код всегда спрятан в main-е.
//        Arrays.sort(boxes,cmp);


//        2. Использование статического внутреннего класса
//        Box.CompareByA cmp=new Box.CompareByA();
//        Arrays.sort(boxes, new Box.CompareByA());
        

//        3 и 4 вариант локального и анонимного локального класса
//        Arrays.sort(boxes, Box.compareByA());

//        5. Анонимные классы (пишутся в том месте, где они требуются)
//        Arrays.sort(boxes, new Comparator<Box>() {
//            @Override
//            public int compare(Box b1, Box b2) {
//                return b1.getA()-b2.getA();
//            }
//        });

//        6. Использование Лямбда-выражения Если есть b1 и b2, то с ними нужно сделать b1.getA()-b2.getA()
        Arrays.sort(boxes, (b1,b2) -> b1.getA()-b2.getA());

        for (Box box : boxes) {
            System.out.println(box);
        }    
    }
    
}
