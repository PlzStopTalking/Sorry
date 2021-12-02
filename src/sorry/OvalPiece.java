package sorry;
import sorry.Piece;
import java.awt.*;

public class OvalPiece extends Piece {
    
    OvalPiece(Color _color)
    {
        super(_color);
    }    
    
    public void draw(Graphics2D g,int row,int column,int xdelta,int ydelta)
    {
        if (getHighlight())
        {
            g.setColor(Color.yellow);
            g.fillRect(Window.getX(column*xdelta), Window.getY(row*ydelta), xdelta, ydelta);
        }
        g.setColor(getColor());
        g.fillOval(Window.getX(column*xdelta), Window.getY(row*ydelta), xdelta, ydelta);
    }
    
}