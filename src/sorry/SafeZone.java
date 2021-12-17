package sorry;
import java.awt.*;

public class SafeZone extends Piece{
    private boolean containsPiece;
    private boolean highlight;
    SafeZone(Color _color)
    {
        super(_color);
        containsPiece = false;
        highlight = false;
    }
    public void draw(Graphics2D g,int row,int column,int xdelta,int ydelta) 
    {
        g.setColor(getColor());
        g.fillRect(Window.getX(column*xdelta), Window.getY(row*ydelta), xdelta, ydelta);
        g.setColor(Color.black);
        g.drawRect(Window.getX(column*xdelta), Window.getY(row*ydelta), xdelta, ydelta);
        if (highlight)
        {
            g.setColor(Color.cyan);
            g.drawOval(Window.getX(column*xdelta), Window.getY(row*ydelta), xdelta, ydelta);
        }
        if (containsPiece)
        {
            g.drawOval(Window.getX(column*xdelta), Window.getY(row*ydelta), xdelta, ydelta);
            if (highlight)
                highlight();
        }
    }
    public boolean checkSafezone()
    {
        return true;
    }
    public boolean checkOval()
    {
        return false;
    }
    public void contain()
    {
        containsPiece = !(containsPiece);
    }
    public void highlight()
    {
        highlight = !highlight;
    }
    public boolean getHighlight()
    {
        return highlight;
    }
    public boolean getContain()
    {
        return containsPiece;
    }
}
