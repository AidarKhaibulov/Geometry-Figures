package firstworkpackage;

import java.util.Arrays;

public class NGon implements IShape{
    private int n;
    private Point2D [] p;
    public NGon(Point2D [] pp){

        try
        {
            if(pp.length==0) throw new IndexOutOfBoundsException("Ошибки при вводе");
            else {
                n=pp.length;
                p=new Point2D[n];
                for(int i=0;i<n;i++)
                    p[i]=pp[i];
            }
        }
        catch(IndexOutOfBoundsException e)
        {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }
    public int getN(){
        return n;
    }
    public Point2D [] getP(){
        return p;
    }
    public Point2D getP(int i){
        return p[i];
    }
    public void setP(Point2D [] pp) {
        n=pp.length;
        for(int i=0;i<n;i++)
            p[i]=pp[i];
    }
    public void setP(Point2D pp, int x) {
        p[x]=pp;
    }

    public double square() {
        double res=0;
        for(int i= 1;i<n-1;i++)
        {
            double a,b,c;
            a=Math.sqrt((p[0].getX(0)-p[i].getX(0))*(p[0].getX(0)-p[i].getX(0))+(p[0].getX(1)-p[i].getX(1))*(p[0].getX(1)-p[i].getX(1)));
            b=Math.sqrt((p[i].getX(0)-p[i+1].getX(0))*(p[i].getX(0)-p[i+1].getX(0))+(p[i].getX(1)-p[i+1].getX(1))*(p[i].getX(1)-p[i+1].getX(1)));
            c=Math.sqrt((p[0].getX(0)-p[i+1].getX(0))*(p[0].getX(0)-p[i+1].getX(0))+(p[0].getX(1)-p[i+1].getX(1))*(p[0].getX(1)-p[i+1].getX(1)));
            double p;
            p=(a+b+c)/2;
            res+=Math.sqrt(p*(p-a)*(p-b)*(p-c));
        }
        return res;
    }
    public double length(){
        double res=0;
        for(int i=0;i<n-1;i++)
            res+=Math.sqrt((p[i].getX(0)-p[i+1].getX(0))*(p[i].getX(0)-p[i+1].getX(0))+(p[i].getX(1)-p[i+1].getX(1))*(p[i].getX(1)-p[i+1].getX(1)));
        res+=Math.sqrt((p[n-1].getX(0)-p[0].getX(0))*(p[n-1].getX(0)-p[0].getX(0))+(p[n-1].getX(1)-p[0].getX(1))*(p[n-1].getX(1)-p[0].getX(1)));
        return res;
    }
    public NGon shift(Point2D a) {
        Point2D []r;
        r=new Point2D[n];
        for(int i=0;i<n;i++)
            r[i]=new Point2D();
        NGon res=new NGon(r);
        for(int i=0;i<n;i++)
            res.p[i].setX((p[i].add(a)).getX());
        return res;
    }
    public NGon rot(double phi) {

        Point2D []r;
        r=new Point2D[n];
        for(int i=0;i<n;i++)
            r[i]=new Point2D();
        NGon res=new NGon(r);
        for(int i=0;i<n;i++)
        {
            double x = p[i].getX(0);
            double y = p[i].getX(1);

            double xres = x * Math.cos(phi) - y * Math.sin(phi);
            double yres = y * Math.cos(phi) + x * Math.sin(phi);

            double [] a= {xres,yres};
            Point2D p = new Point2D(a);

            res.p[i].setX(p.getX());
        }
        return res;
    }
    public NGon symAxis(int axis) {
        Point2D []r;
        r=new Point2D[n];
        for(int i=0;i<n;i++)
            r[i]=new Point2D();
        NGon res=new NGon(r);
        for(int i=0;i<n;i++)
        {
            double[] a = new double[2];
            for (int j = 0; j < 2; j++)
                a[j] = p[i].getX(j);
            for (int j = 0; j < 2; j++) {
                if(j != axis)
                    a[j] = p[i].getX(j) * -1;
            }

            Point2D p = new Point2D(a);
            res.p[i].setX(p.getX());
        }
        return res;
    }
    public boolean cross(IShape s) {
        NGon ps= (NGon) s;
        double A1,B1,C1,A2,B2,C2;
        double x,y;
        boolean y1,y2;
        for(int i=0;i<n-1;i++)
            for(int j=0;j<ps.getP().length -1;j++)
            {
                if((p[i].getX(0)==ps.getP(j).getX(0) && p[i].getX(1)==ps.getP(j).getX(1)) &&( p[i+1].getX(0)==ps.getP(j+1).getX(0) && p[i+1].getX(1)==ps.getP(j+1).getX(1) ))
                    return true;
                A1=p[i].getX(1)-p[i+1].getX(1);
                B1=-p[i].getX(0)+p[i+1].getX(0);
                C1=-p[i+1].getX(0)*A1+p[i+1].getX(1)*(-B1);

                A2=ps.getP(j).getX(1)-ps.getP(j+1).getX(1);
                B2=-ps.getP(j).getX(0)+ps.getP(j+1).getX(0);
                C2=-ps.getP(j+1).getX(0)*A2+ps.getP(j+1).getX(1)*(-B2);

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
                y1=(((p[i].getX(0)<=x && x<=p[i+1].getX(0))) ||((p[i].getX(0)>=x && x>=p[i+1].getX(0)))) && (((ps.getP(j).getX(0)<=x && x<=ps.getP(j+1).getX(0))) ||((ps.getP(j).getX(0)>=x && x>=ps.getP(j+1).getX(0))));
                y2=(((p[i].getX(1)<=y && y<=p[i+1].getX(1))) ||((p[i].getX(1)>=y && y>=p[i+1].getX(1)))) && (((ps.getP(j).getX(1)<=y && y<=ps.getP(j+1).getX(1))) ||((ps.getP(j).getX(1)>=y && y>=ps.getP(j+1).getX(1))));
                if(y1&&y2==true)
                    return true;
            }
        if(p[n-1].getX(0)==ps.getP(n-1).getX(0) && p[n-1].getX(1)==ps.getP(n-1).getX(1) && p[0].getX(0)==ps.getP(0).getX(0) && p[0].getX(1)==ps.getP(0).getX(1) )
            return true;
        A1=p[n-1].getX(1)-p[0].getX(1);
        B1=-p[n-1].getX(0)+p[0].getX(0);
        C1=-p[0].getX(0)*A1+p[0].getX(1)*(-B1);

        A2=ps.getP(n-1).getX(1)-ps.getP(0).getX(1);
        B2=-ps.getP(n-1).getX(0)+ps.getP(0).getX(0);
        C2=-ps.getP(0).getX(0)*A2+ps.getP(0).getX(1)*(-B2);

        y=(A2*C1/A1-C2)/(-A2*B1/A1+B2);
        x=(-C1-B1*y)/A1;

        y1=(p[n-1].getX(0)<=x && x<=p[0].getX(0)) ||(p[n-1].getX(0)>=x && x>=p[0].getX(0)) && (ps.getP(n-1).getX(0)<=x && x<=ps.getP(0).getX(0)) ||(ps.getP(n-1).getX(0)>=x && x>=ps.getP(0).getX(0));
        y2=(p[n-1].getX(1)<=y && y<=p[0].getX(1)) ||(p[n-1].getX(1)>=y && y>=p[0].getX(1)) && (ps.getP(n-1).getX(1)<=y && y<=ps.getP(0).getX(1)) ||(ps.getP(n-1).getX(1)>=y && y>=ps.getP(0).getX(1));
        if(y1&&y2==true)
            return true;
        return false;
    }
    public String toString(){

        String res="";
        res+="n-угольник: ";
        res+="n: "+ n+" ";
        for(int i=0;i<n;i++)
        {
            res+= Arrays.toString(p[i].getX());
        }
        return res;
    }
}
