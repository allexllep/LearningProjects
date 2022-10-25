package j2javafxobservablecollections;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

public class J2JavaFXObservableCollections {
       public static void main(String[] args) {

           ArrayList<Person> oldList = new ArrayList();
           oldList.add(new Person("Name1", 20));
           oldList.add(new Person("Name2", 30));

           ObservableList<Person> fxList = FXCollections.observableArrayList(oldList); // добавляем в fxList данные из oldList, первичное заполнение коллекции.
           fxList.addListener(new ListChangeListener<Person>() { // добавляем Listener-а вида ChangeListener, который отслеживает ТОЛЬКО указанные изменения прослушиваемого объекта. InvalivateListener отслеживает все действия с объектом и реагирует на неправильное заполнение прослушиваемого объекта.
               @Override
               public void onChanged(ListChangeListener.Change<? extends Person> change) { // onChange - это обработчик изменения, переопределяемый в интерфейсе ListChangeListener, где Change - внутренний статический класс
                   while(change.next()){
                       if(change.wasAdded()){
                           for (Person person : change.getAddedSubList()) {
                               oldList.add(person);
                           }
                       }
                       if(change.wasRemoved()){
                           for (Person person : change.getRemoved()) {
                               oldList.remove(person);
                           }
                       }
                   }
               }
           });

           fxList.add(new Person("Name3", 40));
           fxList.remove(0);

           for (Person person : oldList) {
               System.out.println(person);
           }
    }

}

class Person {

    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", age=" + age + '}';
    }
}