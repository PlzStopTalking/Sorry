package sorry;
import java.awt.*;

public class SafeZone extends Piece{
    private boolean containsPiece;
    SafeZone(Color _color)
    {
        super(_color);
        containsPiece = false;
    }
    public void draw(Graphics2D g,int row,int column,int xdelta,int ydelta) 
    {
        g.setColor(getColor());
        g.fillRect(Window.getX(column*xdelta), Window.getY(row*ydelta), xdelta, ydelta);
        g.setColor(Color.black);
        g.drawRect(Window.getX(column*xdelta), Window.getY(row*ydelta), xdelta, ydelta);
        if (containsPiece)
            g.drawOval(Window.getX(column*xdelta), Window.getY(row*ydelta), xdelta, ydelta);
    }
    public void contain()
    {
        containsPiece = !(containsPiece);
    }
    public boolean getContain()
    {
        return containsPiece;
    }
}
