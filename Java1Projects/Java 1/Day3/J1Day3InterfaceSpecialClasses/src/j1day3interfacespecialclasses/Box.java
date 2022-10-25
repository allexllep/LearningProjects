package j1day3interfacespecialclasses;

import java.util.Comparator;

public class Box implements Comparable<Box>{
    private int a, b, c;

    public Box(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public String toString() {
        return "Box{" + "a=" + a + ", b=" + b + ", c=" + c + '}';
    }

    public int getA() {
        return a;
    }
    
    @Override
    public int compareTo(Box rightValue){
        return this.volume() - rightValue.volume();
    }

    private int volume(){
        return a*b*c;
    }
    
    // 3. Локальные классы local class // класс, который видно только в методе, в котором он объявлен и больше нигде. Даже внутри этого класса к нему обратиться не получится.
//    public static Comparator<Box> compareByA(){ //если неизвестен класс возвращаемого значения, то можно вернуть интерфейс, который этот класс реализует
//        class CMP implements Comparator<Box>{          
//
//            @Override
//            public int compare(Box b1, Box b2) {
//                return b1.a - b2.a;
//            }
//        }
//        return new CMP();
//    }
    
    
    // 4. анонимный локальный класс anonimous local class
    public static Comparator<Box> compareByA(){ 
        return new Comparator<Box>() {
            {
                //..... {...} - конструктор анонимного класса, в том числе локального. Конструктором не называют - это инициализация экземпляром. Используется например в анимации в JavaFX - в нем можно указать длительность анимации
            }
            
            @Override
            public int compare(Box b1, Box b2) {
                return b1.a - b2.a;
            }
        };
        
    }
    
    // 1. Внутренний класс или inner class Класс Box для CopareByA является внешним.
//    public class CompareByA implements Comparator<Box> {
        
    // 2. Статический внутренный класс Static inner class (привязан к классу, един для всех объектов)
        public static class CompareByA implements Comparator<Box> {
            
        @Override
        public int compare(Box b1, Box b2){
            return  b1.a - b2.a;
        }
    }

    
    
}
