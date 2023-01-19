package firstworkpackage;

 import java.util.Arrays;

public class Segment extends OpenFigure {
    private Point2D start;
    private Point2D finish ;
    public Segment(Point2D s, Point2D f){
        start=s;
        finish=f;
    }
    public Point2D getStart(){
        return start;
    }
    public Point2D getFinish(){
        return finish;
    }
    public void setStart(Point2D pstart) {
        start=pstart;
    }
    public void setFinish(Point2D pfinish) {
        finish=pfinish;
    }

    public double length(){
        double res;
        res=(start.getX(0)-finish.getX(0))*(start.getX(0)-finish.getX(0))+(start.getX(1)-finish.getX(1))*(start.getX(1)-finish.getX(1));
        return Math.sqrt(res);
    }
    public Segment shift(Point2D a){
        Point2D r1= new Point2D();
        Point2D r2= new Point2D();
        Segment res= new Segment(r1,r2);
        (res.start).setX((start.add(a)).getX());
        (res.finish).setX((finish.add(a)).getX());
        return res;
    }
    public Segment rot(double phi){
        double xs = start.getX(0);
        double ys = start.getX(1);

        double xf = finish.getX(0);
        double yf = finish.getX(1);
        double xsres = xs * Math.cos(phi) - ys * Math.sin(phi);
        double ysres = ys * Math.cos(phi) + xs * Math.sin(phi);

        double xfres = xf * Math.cos(phi) - yf * Math.sin(phi);
        double yfres = yf * Math.cos(phi) + xf * Math.sin(phi);

        double [] a= {xsres,ysres};
        Point2D ps = new Point2D(a);

        double [] b= {xfres,yfres};
        Point2D pf = new Point2D(b);

        return new Segment(ps,pf);
    }
    public Segment symAxis(int axis){
        double[] a = new double[2];
        for (int i = 0; i < 2; i++)
            a[i] = start.getX(i);
        for (int i = 0; i < 2; i++) {
            if(i != axis)
                a[i] = start.getX(i) * -1;
        }

        double[] b = new double[2];
        for (int i = 0; i < 2; i++)
            b[i] = finish.getX(i);


        for (int i = 0; i < 2; i++) {
            if(i != axis)
                b[i] = finish.getX(i) * -1;
        }
        Point2D ps = new Point2D(a);
        Point2D pf = new Point2D(b);

        Segment res= new Segment(ps,pf);
        return res;
    }
    public boolean cross(IShape s){
        Segment ps= (Segment) s;
        double A1,B1,C1,A2,B2,C2;
        if((start.getX(0)==ps.getStart().getX(0) && finish.getX(0)==getFinish().getX(0) )&& (start.getX(1)==ps.getStart().getX(1) && finish.getX(1)==getFinish().getX(1)))
            return true;
        A1=start.getX(1)-finish.getX(1);
        B1=-start.getX(0)+finish.getX(0);
        C1=-finish.getX(0)*A1+finish.getX(1)*(-B1);

        A2=ps.getStart().getX(1)-ps.getFinish().getX(1);
        B2=-ps.getStart().getX(0)+ps.getFinish().getX(0);
        C2=-ps.getFinish().getX(0)*A2+ps.getFinish().getX(1)*(-B2);
        double x,y;
        if(A1==0)
        {
            y=-C1/B1;
            x=(-C2-B2*y)/A2;
        }
        else
        if(B1==0)
        {
            x=-C1/A1;
            y=(-C2-A2*x)/B2;
        }
        else
        {
            y = (A2 * C1 / A1 - C2) / (-A2 * B1 / A1 + B2);
            x = (-C1 - B1 * y) / A1;
        }
        boolean y1,y2;
        y1=((start.getX(0)<=x && x<=finish.getX(0)) ||(start.getX(0)>=x && x>=finish.getX(0))) && ((ps.getStart().getX(0)<=x && x<=ps.getFinish().getX(0)) ||(ps.getStart().getX(0)>=x && x>=ps.getFinish().getX(0)));
        y2=((start.getX(1)<=y && y<=finish.getX(1)) ||(start.getX(1)>=y && y>=finish.getX(1)))&& ((ps.getStart().getX(1)<=y && y<=ps.getFinish().getX(1)) ||(ps.getStart().getX(1)>=y && y>=ps.getFinish().getX(1)));
        if(y1&&y2==true)
            return true;
        else return false;
    }
    public String toString(){
        return "Отрезок:  Start: " + Arrays.toString(start.getX()) + " Finish: " +  Arrays.toString(finish.getX());
    }
}
