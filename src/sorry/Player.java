package sorry;
import java.awt.*;

public class Player {
    private static Player currentTurn;
    private static Player players[] = new Player[4];
    private Color color;
    private boolean winner;
    private int points;
    private int id;
    public static void Reset()
    {
        players[0] = new Player(Color.red, 0);
        players[1] = new Player(Color.blue, 1);
        players[2] = new Player(Color.yellow, 2);
        players[3] = new Player(Color.green, 3);
        currentTurn = players[0];
    }
    Player(Color _color, int _id)
    {
        color = _color;
        winner = false;
        id = _id;
        points = 0;
    }
    public static void SwitchTurn()
    {
        int newturn = GetCurrentTurn().id + 1;
        if (newturn > 3)
            newturn = 0;
        currentTurn = players[newturn];
    }
    public static void CheckWin()
    {
        for (Player player : players)
        {
            if (player.points == 3) //make num peices when that variable is added
            {
                player.makeWinner();
                return;
            }
        }
    }
    public void makeWinner()
    {
        winner = true;
    }
    public void addPoint()
    {
        points++;
    }
    public static Player GetCurrentTurn()
    {
        return (currentTurn);
    }
    public static Player findPlayer(Color _color)
    {
        for (Player player : players)
        {
            if (player.color == _color)
            {
                return player;
            }
        } 
        return null;
    }
    public boolean getWinner()
    {
        return (winner);
    }
    public Color getColor()
    {
        return (color);
    }
    public int getId()
    {
        return (id);
    }
    public static void Draw(Graphics2D g)
    {
        g.setColor(Color.red);
        g.setFont(new Font("Rockwell Extra Bold",Font.PLAIN,15));
        g.drawString("Red has: " + players[0].points + " pawns in home", 440, 633);
        g.setColor(Color.blue);
        g.setFont(new Font("Rockwell Extra Bold",Font.PLAIN,15));
        g.drawString("Blue has: " + players[1].points + " pawns in home", 30, 633);
        g.setColor(Color.yellow);
        g.setFont(new Font("Rockwell Extra Bold",Font.PLAIN,15));
        g.drawString("Yellow has: " + players[2].points + " pawns in home", 30, 50);
        g.setColor(Color.green);
        g.setFont(new Font("Rockwell Extra Bold",Font.PLAIN,15));
        g.drawString("Green has: " + players[3].points + " pawns in home", 440, 50);
        g.setColor(currentTurn.color);
        g.setFont(new Font("Rockwell Extra Bold",Font.PLAIN,30));
        StringCentered(g,Window.getWidth2()/2, 380,"It's " + currentTurn + "'s turn","Rockwell Extra Bold",30);
        
    }
    public String toString()
    {
        if (color == Color.red)
            return "red";
        else if (color == Color.blue)
            return "blue";
        else if (color == Color.yellow)
            return "yellow";
        else if (color == Color.green)
            return "green";
        else
            return "player";
    }
    public static void StringCentered(Graphics2D g,int xpos,int ypos,String text,String font,int size)
    {
        g.setFont (new Font (font,Font.PLAIN, size)); 
        int width = g.getFontMetrics().stringWidth(text);
        int height = g.getFontMetrics().getHeight();
        xpos = xpos - width/2;
        ypos = ypos - height/4;
        xpos = Window.getX(xpos);
        ypos = Window.getYNormal(ypos);
        g.drawString(text, xpos, ypos);           
    } 
}
