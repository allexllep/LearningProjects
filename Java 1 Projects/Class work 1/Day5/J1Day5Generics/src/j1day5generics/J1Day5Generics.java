package j1day5generics;

import java.util.ArrayList;

public class J1Day5Generics {
    public static void main(String[] args) {
        
        //var list = new ArrayList<Storage<Integer>> (); - то же, что и ниже
        ArrayList<Storage<Integer>> list = new ArrayList();
        list.add(new Storage(10));
        list.add(new Storage(2));
        if(list.get(0).isGreater(list.get(1).getData()))
            System.out.println("ok");
    }
    
}
