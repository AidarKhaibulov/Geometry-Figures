package firstworkpackage;

public interface IShape {
    double square();
    double length();
    IShape shift(Point2D a);
    IShape rot(double phi);
    IShape symAxis(int i);
    boolean cross(IShape s);
}