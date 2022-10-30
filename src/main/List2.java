package main;

import java.awt.*;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class List2 {
    private Vector2[] ls =new Vector2[6];

    public Vector2[] getList(){
        return ls;
    }

    public List2(){
        Vector2 tmp = new Vector2(0,0,1);
        for (int i = 0; i < 6; i++) {
            ls[i]=tmp;
        }
    }

    public Vector2 getVectorByIndex(int i){
        if (i<0||i>5) throw new IndexOutOfBoundsException();
        return ls[i];

    }
    public void setVectorByIndex(int i,Vector2 vector){
        if (i<0||i>5) throw new IndexOutOfBoundsException();
         ls[i]=vector;

    }

    public void drawList(Graphics g){
        for(int i =0;i<3;i++){
            g.drawLine((int)ls[i].getX(),(int)ls[i].getY(),(int)ls[i+1].getX(),(int)ls[i+1].getY());
        }

        g.drawLine((int)ls[0].getX(),(int)ls[0].getY(),(int)ls[3].getX(),(int)ls[3].getY());
        g.drawLine((int)ls[4].getX(),(int)ls[4].getY(),(int)ls[2].getX(),(int)ls[2].getY());
        g.drawLine((int)ls[2].getX(),(int)ls[2].getY(),(int)ls[5].getX(),(int)ls[5].getY());

    }

    public void rotateSquare(List2 list, double degree,Vector2 cp){
        Matrix2 mf = new Matrix2();
        Matrix2 mtc = new Matrix2();
        Matrix2 mt = new Matrix2();
        Matrix2 mb = new Matrix2();
        double cosx=(cos(Math.PI*degree/180));
        double sinx=(sin(Math.PI*degree/180));
        mf.identify();
        mt.identify();
        mtc.identify();
        mf.getM()[0].setByIndex(0,cosx);
        mf.getM()[1].setByIndex(1,cosx);
        mf.getM()[0].setByIndex(1,sinx);
        mf.getM()[1].setByIndex(0,-sinx);

        mb.getM()[0].setByIndex(0,1.004);
        mb.getM()[1].setByIndex(1,1.004);


        mtc.getM()[2].setByIndex(0,-cp.getX());
        mtc.getM()[2].setByIndex(1,-cp.getY());

        mt.getM()[2].setByIndex(0, cp.getX());
        mt.getM()[2].setByIndex(1, cp.getY());

        for (int i=0; i<6; i++) {
           // list.setVectorByIndex(i, list.getVectorByIndex(i).vectorsProdByMatrix(mtc,mf,mt));
            list.setVectorByIndex(i, list.getVectorByIndex(i).vectorsProdByMatrix(mtc));
            list.setVectorByIndex(i, list.getVectorByIndex(i).vectorsProdByMatrix(mf));
            list.setVectorByIndex(i, list.getVectorByIndex(i).vectorsProdByMatrix(mt));
            list.setVectorByIndex(i, list.getVectorByIndex(i).vectorsProdByMatrix(mb));
        }
        for (int i=0; i<6; i++) {
            list.getVectorByIndex(i).setY(list.getVectorByIndex(i).getY()+1);
        }

    }

}
