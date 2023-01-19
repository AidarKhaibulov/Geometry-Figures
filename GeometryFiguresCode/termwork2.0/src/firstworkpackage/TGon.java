package firstworkpackage;

public class TGon extends NGon {
    public TGon(Point2D [] pp){
        super(pp);
    }
    public double square()
    {       double res=0;
        double a,b,c;
        a=Math.sqrt((this.getP(0).getX(0)-(this.getP(1)).getX(0))*((this.getP(0)).getX(0)-(this.getP(1)).getX(0))+((this.getP(0)).getX(1)-(this.getP(1)).getX(1))*((this.getP(0)).getX(1)-(this.getP(1)).getX(1)));
        b=Math.sqrt((this.getP(1).getX(0)-(this.getP(2)).getX(0))*((this.getP(1)).getX(0)-(this.getP(2)).getX(0))+((this.getP(1)).getX(1)-(this.getP(2)).getX(1))*((this.getP(1)).getX(1)-(this.getP(2)).getX(1)));
        c=Math.sqrt((this.getP(0).getX(0)-(this.getP(2)).getX(0))*((this.getP(0)).getX(0)-(this.getP(2)).getX(0))+((this.getP(0)).getX(1)-(this.getP(2)).getX(1))*((this.getP(0)).getX(1)-(this.getP(2)).getX(1)));
        double p;
        p=(a+b+c)/2;
        res+=Math.sqrt(p*(p-a)*(p-b)*(p-c));
        return res;
    }
}
