package sorry;
import java.awt.*;

public class Player {
    private static Player currentTurn;
    private static Player players[] = new Player[4];
    private Color color;
    private boolean winner;
    private static boolean GO = false;
    private int points;
    private int id;
    public static void Reset()
    {
        players[0] = new Player(Color.red, 0, 0);
        players[1] = new Player(Color.blue, 1, 0);
        players[2] = new Player(Color.yellow, 2, 0);
        players[3] = new Player(Color.green, 3, 0);
        currentTurn = players[0];
        for (Player aPlayer : players)
        {
            aPlayer.winner = false;
        }
        GO = false;
    }
    Player(Color _color, int _id, int points)
    {
        color = _color;
        winner = false;
        id = _id;
        points = 0;
    }
    public static void SwitchTurn()
    {
        if (Board.GetCont())
                Board.ChangeCont();
        int newturn = GetCurrentTurn().id + 1;
        if (newturn > 3)
            newturn = 0;
        currentTurn = players[newturn];
        Board.StoreReset();
        Board.HighlightReset();
    }
    public static void SwitchTurn(int row,int col,int card)
    {
        if (card > 1)
        {
            if (!Board.GetCont())
                Board.ChangeCont();
            Board.Move(row, col, card-1);
        }
        else
        {
            int newturn = GetCurrentTurn().id + 1;
            if (newturn > 3)
                newturn = 0;
            currentTurn = players[newturn];
            if (Board.GetCont())
                Board.ChangeCont();
            Board.HighlightReset();
            Board.StoreReset();
            Board.SlideCheck(row, col);
            Cards.PullCard();
        }
    }
    public static void SpawnSwitchTurn()
    {
        if (Board.GetCont())
                Board.ChangeCont();
            int newturn = GetCurrentTurn().id + 1;
            if (newturn > 3)
                newturn = 0;
            currentTurn = players[newturn];
            Board.StoreReset();
            Board.HighlightReset();
            Cards.PullCard();
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
    public static void CheckDeathR()
    {
        for (Player player : players)
        {
            if (player.points == 1 || player.points == 2) //make num peices when that variable is added
            {
                //Board.board[15][11] = new OvalPiece(Player.GetCurrentTurn().color.red);
            }
        }
    }
        public static void CheckDeathB()
    {
        for (Player player : players)
        {
            if (player.points == 1 || player.points == 2) //make num peices when that variable is added
            {
                //Board.board[11][0] = new OvalPiece(Player.GetCurrentTurn().color.blue);
            }
        }
    }
        public static void CheckDeathY()
    {
        for (Player player : players)
        {
            if (player.points == 1 || player.points == 2) //make num peices when that variable is added
            {
               // Board.board[0][4] = new OvalPiece(Player.GetCurrentTurn().color.yellow);
            }
        }
    }
        public static void CheckDeathG()
    {
        for (Player player : players)
        {
            if (player.points == 1 || player.points == 2) //make num peices when that variable is added
            {
                //Board.board[4][15] = new OvalPiece(Player.GetCurrentTurn().color.green);
            }
        }
    }
    public void makeWinner()
    {
        winner = !winner;
        GO = !GO;
    }
    public void addPoint()
    {
        points++;
        CheckWin();
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
    public static Player findPlayer(int _id)
    {
        for (Player player : players)
        {
            if (player.id == _id)
                return player;
        }
        return null;
    }
    public static boolean GetGO()
    {
        return GO;
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
    public int getPoints()
    {
        return points;
    }
    public static void Draw(Graphics2D g)
    {
        if (GO)
        {
            g.setColor(currentTurn.color);
            StringCentered(g,Window.getWidth2()/2, 430,currentTurn + " Wins!","Arial",30);
            return;
        }
        g.setColor(Color.red);
        g.setFont(new Font("Arial",Font.PLAIN,15));
        g.drawString("Red has: " + players[0].points + " pawns in home", 440, 633);
        g.setColor(Color.blue);
        g.drawString("Blue has: " + players[1].points + " pawns in home", 30, 633);
        g.setColor(Color.yellow);
        g.drawString("Yellow has: " + players[2].points + " pawns in home", 30, 50);
        g.setColor(Color.green);
        g.drawString("Green has: " + players[3].points + " pawns in home", 440, 50);
        g.setColor(currentTurn.color);
        StringCentered(g,Window.getWidth2()/2, 420,"It's " + currentTurn + "'s turn","Arial",30);
        if (Cards.getVal() != 0)
        {
            StringCentered(g,Window.getWidth2()/2, 370,"Select a piece to move","Arial",30);
            StringCentered(g,Window.getWidth2()/2, 320,Cards.getVal() + " spaces","Arial",30);
            if (Board.getActive(currentTurn.id) < 3)
            {
                StringCentered(g,Window.getWidth2()/2, 260,"Or move a piece out of start","Arial",30);
            }
        } 
        else 
        {
            if (Board.getActive(currentTurn.id) < 3)
            {
                StringCentered(g,Window.getWidth2()/2, 200,"Or move a piece out of start","Arial",30);
            }
            StringCentered(g,Window.getWidth2()/2, 370,"Sorry!","Arial",30);
            if (Board.getStore() == null)
            {
                StringCentered(g,Window.getWidth2()/2, 320,"Select one of your pieces","Arial",30);
                StringCentered(g,Window.getWidth2()/2, 260,"to switch with an opponent's","Arial",30);
            }
            else
            {
                StringCentered(g,Window.getWidth2()/2, 320,"Select an opponnet's piece to switch","Arial",30);
                StringCentered(g,Window.getWidth2()/2, 260,"with or change your selected piece","Arial",30);
            }
        }
        
    }
    public String toString()
    {
        if (color == Color.red)
            return "Red";
        else if (color == Color.blue)
            return "Blue";
        else if (color == Color.yellow)
            return "Yellow";
        else if (color == Color.green)
            return "Green";
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
