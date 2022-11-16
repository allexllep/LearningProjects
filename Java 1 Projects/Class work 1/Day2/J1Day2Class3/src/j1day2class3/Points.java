package j1day2class3;
public class Points extends Point2D{

    public Points(int x, int y) {
        super(x, y);
    }

    public double getDistance(Points secondPoint){
        
        int dx = (this.getX()<secondPoint.getX()) ? secondPoint.getX()-this.getX() : this.getX()-secondPoint.getX();
        
        int dy = (this.getY()<secondPoint.getY()) ? secondPoint.getY()-this.getY() : this.getY()-secondPoint.getY();
        

        return Math.sqrt(dx*dx+dy*dy);
    }
}
