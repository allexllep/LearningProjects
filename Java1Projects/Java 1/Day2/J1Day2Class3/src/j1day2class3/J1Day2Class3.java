package j1day2class3;
public class J1Day2Class3 {
    public static void main(String[] args) {
        
        Point2D p1=new Point2D();
        p1.setX(-2);
        p1.setY(3);
        
        System.out.println(p1.id+": "+p1+" "+p1.getLength());
    
        Point2D p2=new Point2D(1,1);
        
        System.out.println(p2.id+": "+p2+" "+p2.getLength());
        
        Point2D p3=p1.addTo(p2);
        
        System.out.println(p3.id+": "+p3+" "+p3.getLength());
        System.out.println("total points = "+Point2D.getCounter());
        
        int resultOfCompare=p1.compareTo(p2);
        switch (resultOfCompare) {
            case -1: System.out.println("point " + p1.id + " < point " + p2.id); break;
            case 1 : System.out.println("point " + p1.id + " > point " + p2.id); break;
            default: System.out.println("point " + p1.id + " = point " + p2.id);
                throw new AssertionError();
        }
        Points pnt1 = new Points(1,1);
        Points pnt2 = new Points(13,6);
        double dist = pnt1.getDistance(pnt2);
        System.out.println("Distance between point 1 and point 2 equal " + dist);

    }
    
}
