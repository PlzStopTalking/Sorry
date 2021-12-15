package sorry;
import java.awt.*;

public class OvalPiece extends Piece {
    boolean highlight;
    OvalPiece(Color _color)
    {
        super(_color);
        highlight = false;
    }    
    
    public void draw(Graphics2D g,int row,int column,int xdelta,int ydelta)
    {
        
        g.setColor(Color.black);
        if (highlight)
            g.drawOval(Window.getX(column*xdelta), Window.getY(row*ydelta), xdelta, ydelta);
        g.setColor(getColor());
        if (color != Color.pink)
            g.fillOval(Window.getX(column*xdelta), Window.getY(row*ydelta), xdelta, ydelta);
    }
    public void highlight()
    {
        highlight = true;
    }
    public void contain(){}
    public boolean getContain() 
    {
        return false;
    }
}