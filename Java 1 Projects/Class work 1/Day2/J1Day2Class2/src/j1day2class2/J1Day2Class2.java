package j1day2class2;
public class J1Day2Class2 {
    public static void main(String[] args) {
        Test test=new Test();
        test.setX(-101);
        System.out.println(test.getX());
    }
    
}

class Test {
    private int x;
    
    public void setX(int x){
      if(x<0) x=-x;
      this.x=x;
    }
    
    public int getX(){
        return x;
    }
}
