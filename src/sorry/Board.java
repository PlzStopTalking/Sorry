package sorry;
import java.awt.*;
import java.util.ArrayList;

public class Board {
    private final static int NUM_ROWS = 16;
    private final static int NUM_COLUMNS = 16;
    private static Piece board[][] = new Piece[NUM_ROWS][NUM_COLUMNS];
    private static ArrayList<Piece> spaces = new ArrayList<Piece>();
    private static ArrayList<Piece> notspaces = new ArrayList<Piece>();
    private static ArrayList<Piece> activeP = new ArrayList<Piece>();
    private static ArrayList<Piece> safeZoneR = new ArrayList<Piece>();
    private static ArrayList<Piece> safeZoneB = new ArrayList<Piece>();
    private static ArrayList<Piece> safeZoneY = new ArrayList<Piece>();
    private static ArrayList<Piece> safeZoneG = new ArrayList<Piece>();

    
    private static boolean CheckWin(int row, int column, Player _player)
    {
        
        return false;
    }
    
    // COC
    public static void Reset() {
//clear the board.
        for (int zrow=0;zrow<NUM_ROWS;zrow++)
            for (int zcol=0;zcol<NUM_COLUMNS;zcol++)
            {
                board[zcol][zrow] = new RectPiece(Color.gray);
                notspaces.add(board[zcol][zrow]);
            }
                //perimiter
                for (int x = 0; x < NUM_COLUMNS; x++)
                {
                    spaces.add(board[x][0]);
                }
                for (int x = 0; x < NUM_COLUMNS; x++)
                {
                    spaces.add(board[x][NUM_ROWS - 1]);
                }
                for (int x = 0; x < NUM_COLUMNS; x++)
                {
                    spaces.add(board[0][x]);
                }
                for (int x = 0; x < NUM_COLUMNS; x++)
                {
                    spaces.add(board[NUM_COLUMNS - 1][x]);
                }
                //red safe
                for (int x = 14; x > 9; x--)
                {
                    safeZoneR.add(board[x][13]);
                }
                 //blue safe
                for (int x = 1; x < 6; x++)
                {
                    safeZoneB.add(board[13][x]);
                }
                //yellow safe
                for (int x = 1; x < 6; x++)
                {
                    safeZoneY.add(board[x][2]);
                }
                //green safe
                for (int x = 14; x > 9; x--)
                {
                    safeZoneG.add(board[2][x]);
                }
                for (int i = 0; i < NUM_COLUMNS; i++)
                {
                    for (int j = 0; j < NUM_ROWS; j++)
                    {
                        for (Piece space : spaces)
                        {
                            if (board[j][i] == space) 
                            {
                                board[j][i] = null;
                                notspaces.remove(board[j][i]);
                            }
                        }
                        for (Piece space : safeZoneR)
                        {
                            if (board[j][i] == space) 
                            {
                                board[j][i] = null;
                                notspaces.remove(board[j][i]);
                                board[j][i] = new SafeZone(Color.red);
                            }
                        }
                        for (Piece space : safeZoneB)
                        {
                            if (board[j][i] == space) 
                            {
                                board[j][i] = null;
                                notspaces.remove(board[j][i]);
                                board[j][i] = new SafeZone(Color.blue);
                            }
                        }
                        for (Piece space : safeZoneY)
                        {
                            if (board[j][i] == space) 
                            {
                                board[j][i] = null;
                                notspaces.remove(board[j][i]);
                                board[j][i] = new SafeZone(Color.yellow);
                            }
                        }
                        for (Piece space : safeZoneG)
                        {
                            if (board[j][i] == space) 
                            {
                                board[j][i] = null;
                                notspaces.remove(board[j][i]);
                                board[j][i] = new SafeZone(Color.green);
                            }
                        }
                    } 
                }
                
                board[15][8] = new OvalPiece(Player.GetCurrentTurn().getColor());
                activeP.add(board[7][0]);
                Player.SwitchTurn();
                board[8][0] = new OvalPiece(Player.GetCurrentTurn().getColor());
                activeP.add(board[8][0]);
                Player.SwitchTurn();
                board[0][4] = new OvalPiece(Player.GetCurrentTurn().getColor());
                activeP.add(board[9][0]);
                Player.SwitchTurn();
                board[7][15] = new OvalPiece(Player.GetCurrentTurn().getColor());
                activeP.add(board[10][0]);
                Player.SwitchTurn();
                board[11][0] = new OvalPiece(Player.GetCurrentTurn().getColor());
                activeP.add(board[11][0]);

    }
    
    public static void Move(int xpixel,int ypixel)
    {
        int ydelta = Window.getHeight2()/NUM_ROWS;
        int xdelta = Window.getWidth2()/NUM_COLUMNS;
        int xpixelOffset = xpixel - Window.getX(0);
        int ypixelOffset = ypixel - Window.getY(0);
        //Return if the left mouse click is outside the board.        
        if (xpixelOffset < 0  ||  xpixelOffset > Window.getWidth2())
            return;
        if (ypixelOffset < 0  ||  ypixelOffset > Window.getHeight2())
            return;
//Use xdelta, xpixelOffset, ydelta, ypixelOffset to determine the actual row and column.    
        int column = xpixelOffset/xdelta;
        int row = ypixelOffset/ydelta;
        if(board[row][column] == null)
            return;
        for (Piece space : notspaces)
            {
                if (board[row][column] == space)
                    return;
            }
        if (row - 1 >= 0 && column == 0)
        {
            board[row - 1][column] = board[row][column];
            board[row][column] = null;
        }
        else if (row + 1 < NUM_ROWS && column == NUM_COLUMNS - 1)
        {
            board[row + 1][column] = board[row][column];
            board[row][column] = null;
        }
        else if (column + 1 < NUM_COLUMNS && row == 0)
        {
            board[row][column + 1] = board[row][column];
            board[row][column] = null;
        }
        else if (column - 1 >= 0 && row == NUM_ROWS - 1)
        {
            board[row][column - 1] = board[row][column];
            board[row][column] = null;
        }
    }
    
    public static void Draw(Graphics2D g) {
//draw grid
        int ydelta = Window.getHeight2()/NUM_ROWS;
        int xdelta = Window.getWidth2()/NUM_COLUMNS;
 
        g.setColor(Color.black);
        for (int zi = 1;zi<NUM_ROWS;zi++)
        {
            g.drawLine(Window.getX(0),Window.getY(zi*ydelta),
                    Window.getX(Window.getWidth2()),Window.getY(zi*ydelta));
        }
        
        for (int zi = 1;zi<NUM_COLUMNS;zi++)
        {
            g.drawLine(Window.getX(zi*xdelta),Window.getY(0),
                    Window.getX(zi*xdelta),Window.getY(Window.getHeight2()));
        }
        for (int zrow=0;zrow<NUM_ROWS;zrow++)
        {
            for (int zcol=0;zcol<NUM_COLUMNS;zcol++)        
            {
                if (board[zrow][zcol] != null)
                    board[zrow][zcol].draw(g, zrow, zcol,xdelta, ydelta);
            }
        }        
    }
        
    
    public static int GetNUM_ROWS()
    {
        return (NUM_ROWS);
    }
}