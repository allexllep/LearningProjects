package j1day5generics;
public class Storage<T extends Comparable<? super T>> { //Storage может хранить данные типа T (может быть обозначен T, U, V, E, TypeName - это не имеет значения), который наследуется  от Comparable интерфейса (не реализует его!). Это нужно, чтобы можно было переходить по ссылке типа Comparable к данным типа T. В дженерике самого интерфейса описан тип данных, с которым возможно сравнение типа T, а именно, запись ? super T означает, что сравнивать можно со всеми классами, унаследованными от типа T (в том числе с самим типом T).
    
    private T data;

    public Storage(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Storage{" + "data=" + data + '}';
    }
    
   public boolean isGreater(T value){
       return data.compareTo(value)>0;
       
   }
}
