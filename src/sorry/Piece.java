package sorry;
import java.awt.*;

public abstract class Piece {
    private Color color;
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
    public Player findPlayer(int row, int column)
    {
            return Player.GetCurrentTurn();
    }
    public int getYaxis()
    {
        return yaxis;
    }
    public abstract void draw(Graphics2D g,int row,int column,int xdelta,int ydelta);
    public abstract void contain();
    public abstract boolean getContain();
    
}