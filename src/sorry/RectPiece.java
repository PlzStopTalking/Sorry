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
        g.setColor(getColor());
        if (highlight)
            g.setColor(Color.cyan);
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
