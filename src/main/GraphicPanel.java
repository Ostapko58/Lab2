package main;

import javax.swing.*;
import java.awt.*;
public class GraphicPanel extends JPanel implements Runnable{
    private Point center = null;
    Point tmp =null;
    private List list = null;

    JFrame main=null;
    GraphicPanel(JFrame main){
        this.main=main;
        center =new Point(main.getWidth()-main.getWidth()/4,main.getHeight()/4);
        System.out.println(main.getWidth()+" "+main.getHeight());
        tmp = new Point(main.getWidth()/2,main.getHeight()/2);
        list = new List(center);
        (new Thread(this)).start();
    }

//    @Override
//    protected void paintComponent(Graphics g) {
//        System.out.println(this);
//        super.paintComponent(g);
//        center =new Point(getWidth()-this.getWidth()/4,this.getHeight()/4);
//        System.out.println(center.getX()+" "+center.getY());
//        drawList(g,new Point(getWidth()-getWidth()/4,getHeight()/4));
//        g.fillRect(tmp.getX(),tmp.getY(),10,10);
//        drawList(g,tmp);
//        System.out.println(center.getX()+" "+center.getY());
//        g.fillRect(center.getX(), center.getY(),10,10);
//    }

    public void paint(Graphics g){
        super.paintComponent(g);
        //center =new Point(main.getWidth()-main.getWidth()/4,main.getHeight()/4);
        //System.out.println(center.getX()+" "+center.getY());
        drawList(g,center);
        g.fillRect(tmp.getX(),tmp.getY(),10,10);
        drawList(g,tmp);
        //System.out.println(center.getX()+" "+center.getY());
        //g.fillRect(center.getX(), center.getY(),10,10);
    }

    private void drawList(Graphics g,Point center){
//        Point a = new Point(center.getX()-50,center.getY()-10);
//        Point b = new Point(center.getX(),center.getY()-20);
//        Point c = new Point(center.getX()+30,center.getY());
//        Point d = new Point(center.getX(),center.getY()+20);
//        Point e = new Point(center.getX()+10,center.getY()-1);
//        Point f = new Point(c.getX()+20,c.getY()-12);
//        draw(g,a,b);
//        draw(g,b,c);
//        draw(g,a,d);
//        draw(g,d,c);
//        draw(g,e,c);
//        draw(g,c,f);
        list = new List(center);
        draw(g,list.getA(),list.getB());
        draw(g,list.getB(),list.getC());
        draw(g,list.getA(),list.getD());
        draw(g,list.getD(),list.getC());
        draw(g,list.getE(),list.getC());
        draw(g,list.getC(),list.getF());

    }

    private void draw(Graphics g, Point o1, Point o2){
        int x1 = o1.getX(), y1 = o1.getY(), x2 = o2.getX(), y2 = o2.getY();
        int x, y, dx, dy, incx, incy, pdx, pdy, es, el, err;

        dx = x2 - x1;
        dy = y2 - y1;

        incx = sign(dx);

        incy = sign(dy);


        if (dx < 0) dx = -dx;
        if (dy < 0) dy = -dy;


        if (dx > dy) {
            pdx = incx;
            pdy = 0;
            es = dy;
            el = dx;
        } else {
            pdx = 0;
            pdy = incy;
            es = dx;
            el = dy;
        }

        x = x1;
        y = y1;
        err = el / 2;
        g.fillRect(x, y, 3, 3);


        for (int t = 0; t < el; t++) {
            err -= es;
            if (err < 0) {
                err += el;
                x += incx;
                y += incy;
            } else {
                x += pdx;
                y += pdy;
            }
            g.fillRect(x, y, 3, 3);
        }
    }

    private int sign(int x) {
        return (x > 0) ? 1 : (x < 0) ? -1 : 0;
    }

    @Override
    public void run() {
        int i =0;
        while(true){
            try {
                System.out.println(center.getX()+" "+center.getY());
                System.out.println(i);
                i+=10;
                center.setX(center.getX()-50);
                center.setY(center.getY());
                System.out.println(center.getX()+" "+center.getY());
                tmp.setX(tmp.getX()+i);
                tmp.setY(tmp.getY()+i);
                repaint();
                System.out.println(center.getX()+" "+center.getY());
                list.repaintPoint(center);
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
