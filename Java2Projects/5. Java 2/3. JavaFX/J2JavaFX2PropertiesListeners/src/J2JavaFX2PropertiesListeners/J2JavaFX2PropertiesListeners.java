package J2JavaFX2PropertiesListeners;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class J2JavaFX2PropertiesListeners {
    
    public static void main(String[] args) {
        DemoProperty dp = new DemoProperty();
        dp.setAge(30);
        
        IntegerProperty p = new SimpleIntegerProperty();
        p.bind(dp.ageProperty());
        
        System.out.println(p.get()); // привязка потокобезопасна. Если начинает привязанное свойство менятьсяв момент запроса этого свойства, просто будет передано неизмененное значение.
    }
    
}

class DemoProperty{
    private IntegerProperty age = new SimpleIntegerProperty(); // К property можно привязать Listener для отслеживания изменений

    public DemoProperty() {
        age.addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number oldValue, Number newValue) {
                System.out.println("oldValue = " + oldValue + ", newValue = " + newValue);
            }
        });
    }
    
    public int getAge(){
        return age.get();
    }
    
    public void setAge(int age){
        this.age.set(age);
    }
    
    public IntegerProperty ageProperty(){ // является нарушением инкапсуляции. Использовать аккуратно, т.к. дается доступ к Listener-у.
        return age;
    }
}