package j1day4arraylist;

import java.util.ArrayList;

public class J1Day4ArrayList {
    public static void main(String[] args) {
        ArrayList<Number> list=new ArrayList(); //Number - базовый класс, на основании которого строятся все числа.
        list.add(10);
        list.add(20);
        list.add(0,30);
        list.add(9.7);
        
        for (Number number : list) {
            System.out.println(number);
        }
    
        System.out.println(list.get(1));
        
        ArrayList<ArrayList<String>> sList=new ArrayList();
        //ArrayList<Comparable<>> - коллекция, которую можно сравнивать
    }
    
}
