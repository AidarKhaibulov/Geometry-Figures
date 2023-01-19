package firstworkpackage;

import java.util.Arrays;

public class Circle implements IShape {
    private Point2D p;
    private double r;
    public Circle(Point2D pp, double pr){
        try
        {
            if(pr<0) throw new IndexOutOfBoundsException("Ошибки при вводе");
            else {
                p=pp;
                r=pr;
            }
        }
        catch(IndexOutOfBoundsException e)
        {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }
    public Point2D getP(){
        return p;
    }
    public double getR(){
        return r;
    }
    public void setP(Point2D pp) {
        p=pp;
    }
    public void setR(double pr) {
        r=pr;
    }

    public double square() {
        return Math.PI*r*r;
    }
    public double length() {
        return 2*Math.PI*r;
    }
    public Circle shift(Point2D a) {
        Point2D r1= new Point2D();
        double r2=getR();
        Circle res=new Circle(r1,r2);
        (res.p).setX((p.add(a)).getX());
        return res;
    }
    public Circle rot(double phi) {
        double x = p.getX(0);
        double y = p.getX(1);

        double xres = x * Math.cos(phi) - y * Math.sin(phi);
        double yres = y * Math.cos(phi) + x * Math.sin(phi);

        double [] a= {xres,yres};
        Point2D r1= new Point2D(a);
        double r2=getR();
        Circle res=new Circle(r1,r2);

        return res;
    }
    public Circle symAxis(int axis) {
        double[] a = new double[2];
        for (int i = 0; i < 2; i++)
            a[i] = p.getX(i);
        for (int i = 0; i < 2; i++) {
            if(i != axis)
                a[i] = p.getX(i) * -1;
        }
        Point2D r1 = new Point2D(a);
        double r2=getR();
        Circle res=new Circle(r1,r2);
        return res;
    }
    public boolean cross(IShape s) {
        Circle ps= (Circle) s;
        if( Math.sqrt((ps.getP().getX(0)-p.getX(0))*(ps.getP().getX(0)-p.getX(0)) + (ps.getP().getX(1)-p.getX(1))*(ps.getP().getX(1)-p.getX(1))) <=r+ps.getR() )
            return true;
        else return false;
    }
    public String toString() {
        return "Круг:  Радиус:"+ r+ "; "+"Центр: "+Arrays.toString(p.getX());
    }
}
