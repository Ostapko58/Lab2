package main;

import javax.swing.*;
import java.awt.*;

public class GraphicPanel2 extends JPanel implements Runnable {
    List2 list = new List2();
    int cx,cy;
    Graphics g;
    Vector2 cpoint = new Vector2();
    JFrame main;

    GraphicPanel2(JFrame main){
        this.main=main;
        cx=main.getWidth()/2;
        cy=main.getHeight()/2;
        cpoint.setX(cx);
        cpoint.setY(cy);
        list.setVectorByIndex(0,new Vector2(cx-50,cy-10,1));
        list.setVectorByIndex(1,new Vector2(cx,cy-20,1));
        list.setVectorByIndex(2,new Vector2(cx+30,cy,1));
        list.setVectorByIndex(3,new Vector2(cx,cy+20,1));
        list.setVectorByIndex(4,new Vector2(cx+10,cy-1,1));
        list.setVectorByIndex(5,new Vector2(cx+50,cy-12,1));
        new Thread(this::run).start();
    }

//    a = new Point(center.getX()-50,center.getY()-10);
//    b = new Point(center.getX(),center.getY()-20);
//    c = new Point(center.getX()+30,center.getY());
//    d = new Point(center.getX(),center.getY()+20);
//    e = new Point(center.getX()+10,center.getY()-1);
//    f = new Point(c.getX()+20,c.getY()-12);

    public void paint(Graphics g){
        super.paint(g);
        this.g=g;
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3));
        list.drawList(g2);
        System.out.println("before rotate");
//        for (int i =0;i<12;i++)
//        list.rotateSquare(list,2,new Vector2(getWidth()/2,0,1));
//        for (int i =0;i<12;i++)
//            list.rotateSquare(list,-4,new Vector2(getWidth()/2,0,1));
//        for (int i =0;i<12;i++)
//            list.rotateSquare(list,2,new Vector2(getWidth()/2,0,1));

        //list.rotateSquare(list,1,new Vector2(getWidth()/2,0,1));

        //super.paintComponent(g);
        //center =new Point(main.getWidth()-main.getWidth()/4,main.getHeight()/4);
        //System.out.println(center.getX()+" "+center.getY());
       // drawList(g,center);

       // g.fillRect(tmp.getX(),tmp.getY(),10,10);
      //  drawList(g,tmp);
        //System.out.println(center.getX()+" "+center.getY());
        //g.fillRect(center.getX(), center.getY(),10,10);
    }

    @Override
    public void run() {
        try {
                while(true) {
                    System.out.println("dasdas");
                    list.rotateSquare(list, 2, new Vector2(getWidth() / 2, 0, 1));
                    Thread.sleep(1000);
                    repaint();
                }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
