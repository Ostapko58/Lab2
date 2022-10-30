package main;

public class List {
    Point a = null;
    Point b = null;
    Point c = null;
    Point d = null;
    Point e = null;
    Point f = null;

    public List(Point center){
        a = new Point(center.getX()-50,center.getY()-10);
        b = new Point(center.getX(),center.getY()-20);
        c = new Point(center.getX()+30,center.getY());
        d = new Point(center.getX(),center.getY()+20);
        e = new Point(center.getX()+10,center.getY()-1);
        f = new Point(c.getX()+20,c.getY()-12);
    }

    public Point getA() {
        return a;
    }

    public Point getB() {
        return b;
    }

    public Point getC() {
        return c;
    }

    public Point getD() {
        return d;
    }

    public Point getE() {
        return e;
    }

    public Point getF() {
        return f;
    }

    public void setA(Point a) {
        this.a = a;
    }

    public void setB(Point b) {
        this.b = b;
    }

    public void setC(Point c) {
        this.c = c;
    }

    public void setD(Point d) {
        this.d = d;
    }

    public void setE(Point e) {
        this.e = e;
    }

    public void setF(Point f) {
        this.f = f;
    }

    public void repaintPoint(Point center){
        a.setX(center.getX()-50);
        a.setY(center.getY()-10);
        //a = new Point(center.getX()-50,center.getY()-10);
        b.setX(center.getX());
        b.setY(center.getY()-20);
        //b = new Point(center.getX(),center.getY()-20);
        c.setX(center.getX()+30);
        c.setY(center.getY());
//        c = new Point(center.getX()+30,center.getY());
        d.setX(center.getX());
        d.setY(center.getY()+20);
        //d = new Point(center.getX(),center.getY()+20);
        e.setX(center.getX()+10);
        e.setY(center.getY()-1);
        //e = new Point(center.getX()+10,center.getY()-1);
        f.setX(center.getX()+20);
        f.setY(center.getY()-12);
        //f = new Point(c.getX()+20,c.getY()-12);
    }
}
