package main;

public class Vector2 {
    private double x;
    private double y;
    private double w;

    public Vector2() {
        this.x = 0;
        this.y = 0;
        this.w = 1;
    }

    public Vector2(double x, double y, double w) {
        this.x = x;
        this.y = y;
        this.w = w;
    }

    public Vector2(Vector2 m) {
        this.x = m.getX();
        this.y = m.getY();
        this.w = m.getW();
    }

    public static Vector2 vectorsAdd(Vector2 o1, Vector2 o2) {
        Vector2 tmp = new Vector2();
        tmp.setX(o1.getX() + o2.getX());
        tmp.setY(o1.getY() + o2.getY());
        tmp.setW(o1.getX() + o2.getW());
        return tmp;
    }

    public static Vector2 vectorsMin(Vector2 o1, Vector2 o2) {
        Vector2 tmp = new Vector2();
        tmp.setX(o1.getX() - o2.getX());
        tmp.setY(o1.getY() - o2.getY());
        tmp.setW(o1.getX() - o2.getW());
        return tmp;
    }

    public Vector2 vectorsProd(double c) {
        Vector2 tmp = new Vector2();
        tmp.setX(x * c);
        tmp.setX(y * c);
        tmp.setX(w * c);
        return tmp;
    }

    public Vector2 vectorsProdByMatrix(Matrix2 ... m) {
        Vector2 tmp = new Vector2();
        for (int i =0;i<m.length;i++) {
            tmp.setX(x * m[i].getM()[0].getByIndex(0) + y * m[i].getM()[1].getByIndex(0) + w * m[i].getM()[2].getByIndex(0));
            tmp.setY(x * m[i].getM()[0].getByIndex(1) + y * m[i].getM()[1].getByIndex(1) + w * m[i].getM()[2].getByIndex(1));
            tmp.setW(x * m[i].getM()[0].getByIndex(2) + y * m[i].getM()[1].getByIndex(2) + w * m[i].getM()[2].getByIndex(2));
        }
        return tmp;
    }


    public void clear() {
        x = 0;
        y = 0;
        w = 1;
    }

    public Vector2 setAll(double x, double y, double w) {
        this.x = x;
        this.y = y;
        this.w = w;
        return this;
    }

    public double getByIndex(int i) {
        switch (i) {
            case 0:
                return x;
            case 1:
                return y;
            case 2:
                return w;
            default:
                throw new IndexOutOfBoundsException();
        }
    }

    public void setByIndex(int i, double value) {
        switch (i) {
            case 0: {
                x = value;
                break;
            }
            case 1: {
                y = value;
                break;
            }
            case 2: {
                w = value;
                break;
            }
            default:
                throw new IndexOutOfBoundsException();
        }
    }


    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setW(double w) {
        this.w = w;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getW() {
        return w;
    }
}
