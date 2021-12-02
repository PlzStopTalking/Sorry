package sorry;
import sorry.Window;
import sorry.Piece;
import java.awt.*;

public class RectPiece extends Piece {
    
    RectPiece(Color _color)
    {
        super(_color);
    }
    
    public void draw(Graphics2D g,int row,int column,int xdelta,int ydelta) 
    {
        g.setColor(getColor());
        g.fillRect(Window.getX(column*xdelta), Window.getY(row*ydelta), xdelta, ydelta);
    }
    
}
