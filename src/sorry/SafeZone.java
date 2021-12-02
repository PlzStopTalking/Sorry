package sorry;
import java.awt.*;

public class SafeZone extends RectPiece{
    
    SafeZone(Color _color)
    {
        super(_color);
    }
    public void draw(Graphics2D g,int row,int column,int xdelta,int ydelta) 
    {
        super.draw(g, row, column, xdelta, ydelta);
        g.setColor(Color.BLACK);
        g.drawRect(Window.getX(column*xdelta), Window.getY(row*ydelta), xdelta, ydelta);
    }
    
}
