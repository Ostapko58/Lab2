package main;

public class Matrix2 {
    private Vector2[] m = new Vector2[3];


    public Matrix2(){
        m[0]=new Vector2();
        m[1]=new Vector2();
        m[2]=new Vector2();
        identify();
    }

    public static Matrix2 matrixAdd(Matrix2 m1, Matrix2 m2){
        Matrix2 tmp= new Matrix2();
        tmp.getM()[0]=Vector2.vectorsAdd(m1.getM()[0],m2.getM()[0]);
        tmp.getM()[1]=Vector2.vectorsAdd(m1.getM()[1],m2.getM()[1]);
        tmp.getM()[2]=Vector2.vectorsAdd(m1.getM()[2],m2.getM()[2]);
        return tmp;
    }

    public static Matrix2 matrixMin(Matrix2 m1, Matrix2 m2){
        Matrix2 tmp= new Matrix2();
        tmp.getM()[0]=Vector2.vectorsMin(m1.getM()[0],m2.getM()[0]);
        tmp.getM()[1]=Vector2.vectorsMin(m1.getM()[1],m2.getM()[1]);
        tmp.getM()[2]=Vector2.vectorsMin(m1.getM()[2],m2.getM()[2]);
        return tmp;
    }

    public static Matrix2 matrixProd(Matrix2 m1, Matrix2 m2){
        Matrix2 tmp= new Matrix2();
        for (int i=0;i<3;i++){
            tmp.getM()[i]=m1.getM()[i].vectorsProdByMatrix(m2);
        }
        return tmp;
    }

    public Vector2 vector2(double x,double y,double w){
        return new Vector2(x,y,w);
    }


    public Vector2[] getM() {
        return m;
    }

    public void setM(Vector2[] m) {
        this.m = m;
    }

    public void identify() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) m[j].setByIndex(i, 1);
                else m[i].setByIndex(j, 0);
            }
        }
    }


}
