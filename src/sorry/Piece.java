package sorry;
import java.awt.*;

public abstract class Piece {
    protected Color color;
    private boolean highlight;
    protected int yaxis;
    private int fallcount;
    Piece(Color _color)
    {
        color = _color;
        highlight = false;
        yaxis = 0;
        fallcount = 0;
    }
    public Color getColor()
    {
        return (color);
    }
    public void highlight()
    {
        highlight = true;
    }
    public boolean getHighlight()
    {
        return false;
    }
    public Player getPlayer()
    {
        return Player.findPlayer(color);
    }
    public int getYaxis()
    {
        return yaxis;
    }
    public void drawShadow(Graphics2D g,int row,int column,int xdelta,int ydelta)
    {
        g.setColor(Color.black);
        g.drawOval(Window.getX(column*xdelta), Window.getY(row*ydelta), xdelta, ydelta);
    }
    public abstract void draw(Graphics2D g,int row,int Gcolumn,int xdelta,int ydelta);
    public abstract void contain();
    public abstract boolean getContain();
    
}