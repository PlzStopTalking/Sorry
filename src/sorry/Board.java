package sorry;
import java.awt.*;
import java.util.ArrayList;

public class Board {
    private final static int NUM_ROWS = 16;
    private final static int NUM_COLUMNS = 16;
    private static boolean cont;
    public static Piece board[][] = new Piece[NUM_ROWS][NUM_COLUMNS];
    private static ArrayList<Piece> spaces = new ArrayList<Piece>();
    private static ArrayList<Piece> notspaces = new ArrayList<Piece>();
    public static ArrayList<Piece> activeP = new ArrayList<Piece>();

    private static ArrayList<Piece> safeZoneR = new ArrayList<Piece>();
    private static ArrayList<Piece> safeZoneB = new ArrayList<Piece>();
    private static ArrayList<Piece> safeZoneY = new ArrayList<Piece>();
    private static ArrayList<Piece> safeZoneG = new ArrayList<Piece>();

    private static ArrayList<Piece> startR = new ArrayList<Piece>();
    private static ArrayList<Piece> startB = new ArrayList<Piece>();
    private static ArrayList<Piece> startY = new ArrayList<Piece>();
    private static ArrayList<Piece> startG = new ArrayList<Piece>();
    
    private static Slide slides[] = new Slide[8];
    
    private static boolean CheckWin(int row, int column, Player _player)
    {
        
        return false;
    }
    
    // COC monumetus achivement
    public static void Reset() {
        cont = false;
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
                //Red Start
                for (int x = 14; x > 13; x--)
                {
                    startR.add(board[x][11]);
                }
                //Blue Start
                for (int x = 1; x < 2; x++)
                {
                    startB.add(board[11][x]);
                }
                //Yellow Start
                for (int x = 1; x < 2; x++)
                {
                    startY.add(board[x][4]);
                }
                //Green Start
                for (int x = 14; x > 13; x--)
                {
                    startG.add(board[4][x]);
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

                        for (Piece space : startR)
                        {
                            if (board[j][i] == space) 
                            {
                                board[j][i] = null;
                                notspaces.remove(board[j][i]);
                                board[j][i] = new SafeZone(Color.red);
                            }
                        }
                        for (Piece space : startB)
                        {
                            if (board[j][i] == space) 
                            {
                                board[j][i] = null;
                                notspaces.remove(board[j][i]);
                                board[j][i] = new SafeZone(Color.blue);
                            }
                        }
                        for (Piece space : startY)
                        {
                            if (board[j][i] == space) 
                            {
                                board[j][i] = null;
                                notspaces.remove(board[j][i]);
                                board[j][i] = new SafeZone(Color.yellow);
                            }
                        }
                        for (Piece space : startG)
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

                slides[0] = new Slide(0, 1, 4);
                slides[1] = new Slide(0, 9, 5);
                slides[2] = new Slide(15, 14, 4);
                slides[3] = new Slide(15, 6, 5);
                slides[4] = new Slide(14, 0, 4);
                slides[5] = new Slide(6, 0, 5);
                slides[6] = new Slide(1, 15, 4);
                slides[7] = new Slide(9, 15, 4);

                
                //red
                board[15][11] = new OvalPiece(Player.GetCurrentTurn().getColor());
                activeP.add(board[15][15]);
                Player.SwitchTurn();
                //blue
                board[11][0] = new OvalPiece(Player.GetCurrentTurn().getColor());
                activeP.add(board[15][0]);
                Player.SwitchTurn();
                //yellow
                board[0][4] = new OvalPiece(Player.GetCurrentTurn().getColor());
                activeP.add(board[15][0]);
                Player.SwitchTurn();
               //green
                board[4][15] = new OvalPiece(Player.GetCurrentTurn().getColor());
                activeP.add(board[0][0]);
                Player.SwitchTurn();


    }
    
    public static void Move(int xpixel,int ypixel,int card)
    {
        if (card == 0)
        {
            Player.SwitchTurn();
            Cards.PullCard();
            return;
        }
        int ydelta = Window.getHeight2()/NUM_ROWS;
        int xdelta = Window.getWidth2()/NUM_COLUMNS;
        int xpixelOffset;
        int ypixelOffset;
        int column;
        int row;
            if (!cont)
            {
                ydelta = Window.getHeight2()/NUM_ROWS;
                xdelta = Window.getWidth2()/NUM_COLUMNS;
                xpixelOffset = xpixel - Window.getX(0);
                ypixelOffset = ypixel - Window.getY(0);
                //Return if the left mouse click is outside the board.        
                if (xpixelOffset < 0  ||  xpixelOffset > Window.getWidth2())
                    return;
                if (ypixelOffset < 0  ||  ypixelOffset > Window.getHeight2())
                    return;
                //Use xdelta, xpixelOffset, ydelta, ypixelOffset to determine the actual row and column.    
                column = xpixelOffset/xdelta;
                row = ypixelOffset/ydelta;
                //System.out.println("row:" + row + " col:" + column);
                if(board[row][column] == null)
                    return;
                for (Piece space : notspaces)
                    {
                        if (board[row][column] == space)
                            return;
                    }
                if (board[row][column].getPlayer() != Player.GetCurrentTurn())
                    return;
            }
            else
            {
                row = xpixel;
                column = ypixel;
            }
        //safezone red
        if (board[row][column].getColor() == Color.red) // temporary logic in if statement, change later
        {
            if (row -1 >= 0 && board[row-1][column] != null)
                if (board[row][column].getColor() == Color.red && board[row-1][column] == board[14][13])
                {
                    board[14][13].contain();
                    board[row][column] = null;
                    Player.SwitchTurn(14, 13, card);
                    return;
                }
            else if (board[row][column] == board[10][13] && board[10][13].getContain())
            {
                board[row][column].contain();
                board[row][column].getPlayer().addPoint();
                ChangeCont();
                Player.SwitchTurn();
                return;
            }
            else
                for (int x = 0; x < 4; x++)
                    {
                        if (board[row][column] == board[14-x][13] && board[14-x][13].getContain())
                        {
                            board[row-1][column].contain();
                            board[row][column].contain();
                            Player.SwitchTurn(row-1, column, card);
                            Player.CheckDeathR();
                            return;
                        }
                    }
        }
        //safezone blue
        else if (board[row][column].getColor() == Color.blue) // temporary logic in if statement, change later
        {
            if (column +1 < NUM_COLUMNS && board[row][column+1] != null)
                if (board[row][column].getColor() == Color.blue && board[row][column+1] == board[13][1])
                {
                    board[13][1].contain();
                    board[row][column] = null;
                    Player.SwitchTurn(13, 1, card);
                    return;
                }
            else if (board[row][column] == board[13][5] && board[13][5].getContain())
            {
                board[row][column].contain();
                board[row][column].getPlayer().addPoint();
                ChangeCont();
                Player.SwitchTurn();
                return;
            }
            else
                for (int x = 0; x < 4; x++)
                    {
                        if (board[row][column] == board[13][1+x] && board[13][1+x].getContain())
                        {
                            board[row][column+1].contain();
                            board[row][column].contain();
                            Player.SwitchTurn(row, column+1, card);
                            Player.CheckDeathB();
                            return;
                        }
                    }
        }
        //safezone yellow
        else if (board[row][column].getColor() == Color.yellow) // temporary logic in if statement, change later
        {
            if (row +1 < NUM_ROWS && board[row+1][column] != null)
                if (board[row][column].getColor() == Color.yellow && board[row+1][column] == board[1][2])
                {
                    board[1][2].contain();
                    board[row][column] = null;
                    Player.SwitchTurn(1, 2, card);
                    return;
                }
            else if (board[row][column] == board[5][2] && board[5][2].getContain())
            {
                board[row][column].contain();
                board[row][column].getPlayer().addPoint();
                ChangeCont();
                Player.SwitchTurn();
                return;
            }
            else
                for (int x = 0; x < 4; x++)
                    {
                        if (board[row][column] == board[1+x][2] && board[1+x][2].getContain())
                        {
                            board[row+1][column].contain();
                            board[row][column].contain();
                            Player.SwitchTurn(row+1, column, card);
                            Player.CheckDeathY();
                            return;
                        }
                    }
        }
        //safezone green
        else if (board[row][column].getColor() == Color.green) // temporary logic in if statement, change later
        {
            if (column -1 >= 0 && board[row][column-1] != null)
                if (board[row][column].getColor() == Color.green && board[row][column-1] == board[2][14])
                {
                    board[2][14].contain();
                    board[row][column] = null;
                    Player.SwitchTurn(2, 14, card);
                    return;
                }
            else if (board[row][column] == board[2][10] && board[2][10].getContain())
            {
                board[row][column].contain();
                board[row][column].getPlayer().addPoint();
                ChangeCont();
                Player.SwitchTurn();
                return;
            }
            else
                for (int x = 0; x < 4; x++)
                    {
                        if (board[row][column] == board[2][14-x] && board[2][14-x].getContain())
                        {
                            board[row][column-1].contain();
                            board[row][column].contain();
                            Player.SwitchTurn(row, column-1, card);
                            Player.CheckDeathG();
                            return;
                        }
                    }
        }
        if (board[row][column].getColor() == Player.GetCurrentTurn().getColor() && row - 1 >= 0 && column == 0)
        {
            board[row - 1][column] = board[row][column];
            board[row][column] = null;
            Player.SwitchTurn(row-1, column, card);
        }
        else if (board[row][column].getColor() == Player.GetCurrentTurn().getColor() && row + 1 < NUM_ROWS && column == NUM_COLUMNS - 1)
        {
            board[row + 1][column] = board[row][column];
            board[row][column] = null;
            Player.SwitchTurn(row+1, column, card);
        }
        else if (board[row][column].getColor() == Player.GetCurrentTurn().getColor() && column + 1 < NUM_COLUMNS && row == 0)
        {
            board[row][column + 1] = board[row][column];
            board[row][column] = null;
            Player.SwitchTurn(row, column+1, card);
        }
        else if (board[row][column].getColor() == Player.GetCurrentTurn().getColor() && column - 1 >= 0 && row == NUM_ROWS - 1)
        {
            board[row][column - 1] = board[row][column];
            board[row][column] = null;
            Player.SwitchTurn(row, column-1, card);
        }
    }
    
    public static void Draw(Graphics2D g)
    {
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
        for (int i = 0; i < 8; i++)
        {
            slides[i].draw(g, xdelta, ydelta);
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
    public static void ChangeCont()
    {
        cont = !cont;
    }
    public static boolean GetCont()
    {
        return cont;
    }
}

