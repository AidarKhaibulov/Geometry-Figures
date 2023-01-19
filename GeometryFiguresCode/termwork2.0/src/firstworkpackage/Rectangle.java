package firstworkpackage;

public class Rectangle extends QGon{
    public Rectangle(Point2D[] p) {
        super(p);
    }

    public double square() {
        double res=0;
        double a,b;
        a=Math.sqrt((this.getP(0).getX(0)-(this.getP(1)).getX(0))*((this.getP(0)).getX(0)-(this.getP(1)).getX(0))+((this.getP(0)).getX(1)-(this.getP(1)).getX(1))*((this.getP(0)).getX(1)-(this.getP(1)).getX(1)));
        b=Math.sqrt((this.getP(0).getX(0)-(this.getP(3)).getX(0))*((this.getP(0)).getX(0)-(this.getP(3)).getX(0))+((this.getP(0)).getX(1)-(this.getP(3)).getX(1))*((this.getP(0)).getX(1)-(this.getP(3)).getX(1)));
        return a*b;
    }
}