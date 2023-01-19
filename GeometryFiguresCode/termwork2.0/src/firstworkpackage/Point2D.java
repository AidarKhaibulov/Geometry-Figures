package firstworkpackage;

public class Point2D extends Point {
    public Point2D() {
        super(2);
    }

    public Point2D(double[] x) {
        super(2, x);
    }

    static Point2D rot(Point2D p, double phi) {
        double x = p.getX(0);
        double y = p.getX(1);
        double xres = x * Math.cos(phi) - y * Math.sin(phi);
        double yres = y * Math.cos(phi) + x * Math.sin(phi);
        return new Point2D(new double[]{xres, yres});
    }

    Point2D rot(double phi) {
        double x = this.getX(0);
        double y = this.getX(1);
        double xres = x * Math.cos(phi) - y * Math.sin(phi);
        double yres = y * Math.cos(phi) + x * Math.sin(phi);
        return new Point2D(new double[]{xres, yres});
    }
}
