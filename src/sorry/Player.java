package sorry;
import java.awt.Color;

public class Player {
    private static Player currentTurn;
    private static Player players[] = new Player[4];
    private Color color;
    private boolean winner;
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
    }
    public static void SwitchTurn()
    {
        int newturn = GetCurrentTurn().id + 1;
        if (newturn > 3)
            newturn = 0;
        currentTurn = players[newturn];
    }
    public void makeWinner()
    {
        winner = true;
    }
    
    public static Player GetCurrentTurn()
    {
        return (currentTurn);
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
}
