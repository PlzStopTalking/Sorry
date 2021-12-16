package sorry;
import sorry.Window;
import sorry.Piece;
import java.awt.*;

public class RectPiece extends Piece {
    boolean highlight;
    RectPiece(Color _color)
    {
        super(_color);
    }
    
    public void draw(Graphics2D g,int row,int column,int xdelta,int ydelta) 
    {
        if (highlight)
        {
            g.setColor(Color.yellow);
            int[] x  = {42,52,72,52,60,40,15,28,9,32,42};
            int [] y = {38,62,68,80,105,85,102,75,58,20,38};
            g.fillPolygon(x, y, 11);
        }
        g.setColor(getColor());
        g.fillRect(Window.getX(column*xdelta), Window.getY(row*ydelta), xdelta, ydelta);
    }
    public void contain(){}
    public void highlight()
    {
        highlight = !highlight;
    }
    public boolean getHighlight()
    {
        return highlight;
    }
    public boolean checkSafezone()
    {
        return false;
    }
    public boolean checkOval()
    {
        return false;
    }
    public boolean getContain() 
    {
        return false;
    }
}
