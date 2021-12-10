package sorry;
import java.awt.*;

public class Slide {
    private int xvals[] = new int[4];
    private int yvals[] = new int [4];
    int row;
    int column;
    int length;
    Slide(int _row, int _col, int _length)
    {
        row = _row;
        column = _col;
        length = _length;
    }
    public void draw(Graphics2D g,int xdelta,int ydelta) 
    {
        if (row == 0)
        {
            //ractangle
            g.setColor(Color.blue);
            g.fillRect(Window.getX(column*xdelta + (int)(.25*xdelta)), Window.getY((int)(.12*ydelta)), (int)((length-.75)*xdelta), Window.getY((int)(.88*ydelta)) -  Window.getY((int)(.12*ydelta)));
            g.setColor(Color.red);
            g.fillRect(Window.getX(column*xdelta + (int)(.25*xdelta)), Window.getY((int)(.12*ydelta)), (int)((length-.75)*xdelta), (int)(.66*(Window.getY((int)(.88*ydelta)) -  Window.getY((int)(.12*ydelta)))));
            g.setColor(Color.green);
            g.fillRect(Window.getX(column*xdelta + (int)(.25*xdelta)), Window.getY((int)(.12*ydelta)), (int)((length-.75)*xdelta), (int)(.33*(Window.getY((int)(.88*ydelta)) -  Window.getY((int)(.12*ydelta)))));
            //circle
            g.setColor(Color.blue);
            g.fillOval(Window.getX((column+length-1)*xdelta + (int)(.133*xdelta)), (Window.getY((int)(row*ydelta -.028*ydelta))) + (int)(.133*ydelta), (int)(.8*xdelta), (int)(.8*ydelta));
            g.setColor(Color.red);
            g.fillOval(Window.getX((column+length-1)*xdelta + (int)(.133*xdelta + .14*xdelta)), Window.getY((int)(row*ydelta -.028*ydelta)) + (int)(.133*ydelta  + .13*xdelta), (int)(.66*.8*xdelta), (int)(.66*.8*ydelta));
            g.setColor(Color.green);
            g.fillOval(Window.getX((column+length-1)*xdelta + (int)(.133*xdelta  + .28*xdelta)), Window.getY((int)(row*ydelta -.028*ydelta)) + (int)(.133*ydelta  + .25*xdelta), (int)(.33*.8*xdelta), (int)(.33*.8*ydelta));
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
        else if (row == 15)
        {
            //ractangle
            g.setColor(Color.blue);
            g.fillRect(Window.getX(column*xdelta + (int)(.25*xdelta)) - (int)((length-1.25)*xdelta), Window.getY((int)(row*ydelta + .12*ydelta)), (int)((length-.75)*xdelta), Window.getY((int)(.88*ydelta)) -  Window.getY((int)(.12*ydelta)));
            g.setColor(Color.yellow);
            g.fillRect(Window.getX(column*xdelta + (int)(.25*xdelta))- (int)((length-1.25)*xdelta), Window.getY((int)(row*ydelta + .12*ydelta)), (int)((length-.75)*xdelta), (int)(.66*(Window.getY((int)(.88*ydelta)) -  Window.getY((int)(.12*ydelta)))));
            g.setColor(Color.green);
            g.fillRect(Window.getX(column*xdelta + (int)(.25*xdelta))  - (int)((length-1.25)*xdelta), Window.getY((int)(row*ydelta + .12*ydelta)), (int)((length-.75)*xdelta), (int)(.33*(Window.getY((int)(.88*ydelta)) -  Window.getY((int)(.12*ydelta)))));
            //circle
            g.setColor(Color.green);
            g.fillOval(Window.getX((column-length+1)*xdelta + (int)(.133*xdelta)), (Window.getY((int)(row*ydelta -.019*ydelta))) + (int)(.133*ydelta), (int)(.8*xdelta), (int)(.8*ydelta));
            g.setColor(Color.yellow);
            g.fillOval(Window.getX((column-length+1)*xdelta + (int)(.133*xdelta + .14*xdelta)), Window.getY((int)(row*ydelta -.019*ydelta)) + (int)(.133*ydelta  + .13*xdelta), (int)(.66*.8*xdelta), (int)(.66*.8*ydelta));
            g.setColor(Color.blue);
            g.fillOval(Window.getX((column-length+1)*xdelta + (int)(.133*xdelta  + .28*xdelta)), Window.getY((int)(row*ydelta -.019*ydelta)) + (int)(.133*ydelta  + .25*xdelta), (int)(.33*.8*xdelta), (int)(.33*.8*ydelta));
            //triangle
            g.setColor(Color.black);
            xvals[0] = Window.getX(column*xdelta + (int)(.75*xdelta));
            xvals[1] = xvals [0];
            xvals[3] = xvals [0];
            xvals[2] = Window.getX(column*xdelta + (int)(.25*xdelta));
            yvals[0] = Window.getY((int)(row*ydelta + .12*ydelta));
            yvals[3] = yvals[0];
            yvals[1] = Window.getY((int)(row*ydelta + .88*ydelta));
            yvals[2] = Window.getY((int)(row*ydelta + .5*ydelta));
                    
        }
        else if (column == 0)
        {
            //ractangle
            g.setColor(Color.red);
            g.fillRect(Window.getX((int)(column*xdelta + .12*xdelta)), Window.getY(row*ydelta + (int)(.25*ydelta)) - (int)((length-1.25)*ydelta), Window.getX((int)(.88*xdelta)) -  Window.getX((int)(.12*xdelta)), (int)((length-.75)*ydelta));
            g.setColor(Color.green);
            g.fillRect(Window.getX((int)(column*xdelta + .12*xdelta)), Window.getY(row*ydelta + (int)(.25*ydelta)) - (int)((length-1.25)*ydelta), (int)(.66*(Window.getX((int)(.88*xdelta)) -  Window.getX((int)(.12*xdelta)))), (int)((length-.75)*ydelta));
            g.setColor(Color.yellow);
            g.fillRect(Window.getX((int)(column*xdelta + .12*xdelta)), Window.getY(row*ydelta + (int)(.25*ydelta)) - (int)((length-1.25)*ydelta), (int)(.33*(Window.getX((int)(.88*xdelta)) -  Window.getX((int)(.12*xdelta)))), (int)((length-.75)*ydelta));
            //circle
            g.setColor(Color.red);
            g.fillOval((Window.getX((int)(column*xdelta -.029*xdelta))) + (int)(.133*xdelta), Window.getY((row-length+1)*ydelta + (int)(.133*ydelta)), (int)(.8*xdelta), (int)(.8*ydelta));
            g.setColor(Color.green);
            g.fillOval(Window.getX((int)(column*xdelta -.019*xdelta)) + (int)(.133*xdelta  + .13*xdelta), Window.getY((row-length+1)*ydelta + (int)(.133*ydelta + .14*ydelta)), (int)(.66*.8*xdelta), (int)(.66*.8*ydelta));
            g.setColor(Color.yellow);
            g.fillOval(Window.getX((int)(column*xdelta -.019*xdelta)) + (int)(.133*xdelta  + .25*xdelta) ,Window.getY((row-length+1)*ydelta + (int)(.133*ydelta  + .28*ydelta)), (int)(.33*.8*xdelta), (int)(.33*.8*ydelta));
            //triangle
            g.setColor(Color.black);
            yvals[0] = Window.getY(row*ydelta + (int)(.75*ydelta));
            yvals[1] = yvals [0];
            yvals[3] = yvals [0];
            yvals[2] = Window.getY(row*ydelta + (int)(.25*ydelta));
            xvals[0] = Window.getX((int)(column*xdelta + .12*xdelta));
            xvals[3] = xvals[0];
            xvals[1] = Window.getX((int)(column*xdelta + .88*xdelta));
            xvals[2] = Window.getX((int)(column*xdelta + .5*xdelta));
        }
                else if (column == 15)
        {
            //ractangle
            g.setColor(Color.red);
            g.fillRect(Window.getX((int)(column*xdelta + .12*xdelta)), Window.getY(row*ydelta + (int)(.25*ydelta)), Window.getX((int)(.88*xdelta)) -  Window.getX((int)(.12*xdelta)), (int)((length-.75)*ydelta));
            g.setColor(Color.blue);
            g.fillRect(Window.getX((int)(column*xdelta + .12*xdelta)), Window.getY(row*ydelta + (int)(.25*ydelta)), (int)(.66*(Window.getX((int)(.88*xdelta)) -  Window.getX((int)(.12*xdelta)))), (int)((length-.75)*ydelta));
            g.setColor(Color.yellow);
            g.fillRect(Window.getX((int)(column*xdelta + .12*xdelta)), Window.getY(row*ydelta + (int)(.25*ydelta)), (int)(.33*(Window.getX((int)(.88*xdelta)) -  Window.getX((int)(.12*xdelta)))), (int)((length-.75)*ydelta));
            //circle
            g.setColor(Color.yellow);
            g.fillOval((Window.getX((int)(column*xdelta -.029*xdelta))) + (int)(.133*xdelta), Window.getY((row+length-1)*ydelta + (int)(.133*ydelta)), (int)(.8*xdelta), (int)(.8*ydelta));
            g.setColor(Color.blue);
            g.fillOval(Window.getX((int)(column*xdelta -.019*xdelta)) + (int)(.133*xdelta  + .13*xdelta), Window.getY((row+length-1)*ydelta + (int)(.133*ydelta + .14*ydelta)), (int)(.66*.8*xdelta), (int)(.66*.8*ydelta));
            g.setColor(Color.red);
            g.fillOval(Window.getX((int)(column*xdelta -.019*xdelta)) + (int)(.133*xdelta  + .25*xdelta) ,Window.getY((row+length-1)*ydelta + (int)(.133*ydelta  + .28*ydelta)), (int)(.33*.8*xdelta), (int)(.33*.8*ydelta));
            //triangle
            g.setColor(Color.black);
            yvals[0] = Window.getY(row*ydelta + (int)(.25*ydelta));
            yvals[1] = yvals [0];
            yvals[3] = yvals [0];
            yvals[2] = Window.getY(row*ydelta + (int)(.75*ydelta));
            xvals[0] = Window.getX((int)(column*xdelta + .12*xdelta));
            xvals[3] = xvals[0];
            xvals[1] = Window.getX((int)(column*xdelta + .88*xdelta));
            xvals[2] = Window.getX((int)(column*xdelta + .5*xdelta));
        }
        g.fillPolygon(xvals, yvals, xvals.length);
    }
}
