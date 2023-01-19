package firstworkpackage;
public class QGon extends NGon {
    public QGon(Point2D[] pp) {
        super(pp);
    }

    public double square() {
        double res=0;
        for(int i= 1;i<3;i++)
        {
            double a,b,c;

            a=Math.sqrt(((this.getP(0)).getX(0)-(this.getP(i)).getX(0))*((this.getP(0)).getX(0)-(this.getP(i)).getX(0))+((this.getP(0)).getX(1)-(this.getP(i)).getX(1))*((this.getP(0)).getX(1)-(this.getP(i)).getX(1)));
            b=Math.sqrt(((this.getP(i)).getX(0)-(this.getP(i+1)).getX(0))*((this.getP(i)).getX(0)-(this.getP(i+1)).getX(0))+((this.getP(i)).getX(1)-(this.getP(i+1)).getX(1))*((this.getP(i)).getX(1)-(this.getP(i+1)).getX(1)));
            c=Math.sqrt(((this.getP(0)).getX(0)-(this.getP(i+1)).getX(0))*((this.getP(0)).getX(0)-(this.getP(i+1)).getX(0))+((this.getP(0)).getX(1)-(this.getP(i+1)).getX(1))*((this.getP(0)).getX(1)-(this.getP(i+1)).getX(1)));
            double p;
            p=(a+b+c)/2;
            res+=Math.sqrt(p*(p-a)*(p-b)*(p-c));
        }
        return res;
    }
}
