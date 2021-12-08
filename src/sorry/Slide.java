package sorry;
import java.awt.*;

public class Slide {
    private int xvals[] = new int[4];
    private int yvals[] = new int [4];
    public void draw(Graphics2D g,int row,int column,int xdelta,int ydelta) 
    {
        if (row == 0)
        {
            //ractangle
            g.setColor(Color.green);
            g.fillRect(Window.getX(column*xdelta + (int)(.25*xdelta)), Window.getY((int)(.12*ydelta)), (int)(3.25*xdelta), Window.getY((int)(.88*ydelta)) -  Window.getY((int)(.12*ydelta)));
            g.setColor(Color.red);
            g.fillRect(Window.getX(column*xdelta + (int)(.25*xdelta)), Window.getY((int)(.12*ydelta)) - (int)(.33*Window.getY((int)(.88*ydelta)) -  Window.getY((int)(.12*ydelta))), (int)(3.25*xdelta), Window.getY((int)(.88*ydelta)) -  (int)(.66*Window.getY((int)(.12*ydelta))));
            //triangle
            g.setColor(Color.black);
            xvals[0] = Window.getX(column*xdelta + (int)(.25*xdelta));
            xvals[1] = xvals [0];
            xvals[3] = xvals [0];
            xvals[2] = Window.getX(column*xdelta + (int)(.75*xdelta));
            yvals[0] = Window.getY((int)(.12*ydelta));
            yvals[3] = yvals[0];
            yvals[1] = Window.getY((int)(.88*ydelta));
            yvals[2] = Window.getY((int)(.5*ydelta));
        }
        g.fillPolygon(xvals, yvals, xvals.length);
    }
}
