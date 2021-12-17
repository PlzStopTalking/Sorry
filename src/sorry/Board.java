package sorry;
import java.awt.*;
import java.util.ArrayList;
import static sorry.Player.StringCentered;

public class Board {
    private final static int NUM_ROWS = 16;
    private final static int NUM_COLUMNS = 16;
    private static boolean cont;
    private static int HighlightR;
    private static int HighlightC;
    private static Piece confirm;
    private static Piece skip;
    private static Piece hskip;
    public static Piece board[][] = new Piece[NUM_ROWS][NUM_COLUMNS];
    private static Piece store;
    private static int storeRow;
    private static int storeCol;
    private static ArrayList<Piece> spaces = new ArrayList<Piece>();
    private static ArrayList<Piece> notspaces = new ArrayList<Piece>();
    private static int activeP[] = new int[4];
    
    private static ArrayList<Piece> safeZoneR = new ArrayList<Piece>();
    private static ArrayList<Piece> safeZoneB = new ArrayList<Piece>();
    private static ArrayList<Piece> safeZoneY = new ArrayList<Piece>();
    private static ArrayList<Piece> safeZoneG = new ArrayList<Piece>();

    private static ArrayList<Piece> startR = new ArrayList<Piece>();
    private static ArrayList<Piece> startB = new ArrayList<Piece>();
    private static ArrayList<Piece> startY = new ArrayList<Piece>();
    private static ArrayList<Piece> startG = new ArrayList<Piece>();
    
    private static Slide slides[] = new Slide[8];
    
    // COC monumetus achivement
    public static void Reset() {
        cont = false;
        HighlightR = 16;
        HighlightC = 16;
        store = null;
        skip = null;
        hskip = null;
        confirm = null;
        storeRow = 16;
        storeCol = 16;
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

                for (int i = 3; i >= 0; i--)
                    activeP[i] = 0;
    }
    
    public static void Move(int xpixel,int ypixel,int card)
    {
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
            if (card > 0 && board[row][column].getPlayer() != Player.GetCurrentTurn())
                return;
        }
        else
        {
            row = xpixel;
            column = ypixel;
        }
        if  (activeP[0] < 3 && board[row][column] == board[14][11] && Player.GetCurrentTurn().getColor() == Color.red)
        {
            board[row + 1][column] = new OvalPiece(Player.GetCurrentTurn().getColor());
            Player.SpawnSwitchTurn();
        }
        if  (activeP[1] < 3 && board[row][column] == board[11][1] && Player.GetCurrentTurn().getColor() == Color.blue)
        {
            board[row][column - 1] = new OvalPiece(Player.GetCurrentTurn().getColor());
            Player.SpawnSwitchTurn();
        }
        if  (activeP[2] < 3 && board[row][column] == board[1][4] && Player.GetCurrentTurn().getColor() == Color.yellow)
        {
            board[row - 1][column] = new OvalPiece(Player.GetCurrentTurn().getColor());
            Player.SpawnSwitchTurn();
        }
        if  (activeP[3] < 3 && board[row][column] == board[4][14] && Player.GetCurrentTurn().getColor() == Color.green)
        {
            board[row][column + 1] = new OvalPiece(Player.GetCurrentTurn().getColor());
            Player.SpawnSwitchTurn();
        }
        if (card == 0)
        {
            SorryCard(xpixel, ypixel);
            return;
        }
        if (!cont)
            if (board[row][column] != confirm)
            {
                ChangeConfirm(board[row][column]);
                Highlight(xpixel, ypixel, card);
                return;
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
                board[9][13].highlight();
                if (Player.GetGO())
                    return;
                ChangeCont();
                Player.SwitchTurn();
                Cards.PullCard();
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
                board[13][6].highlight();
                if (Player.GetGO())
                    return;
                ChangeCont();
                Player.SwitchTurn();
                Cards.PullCard();
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
                board[6][2].highlight();
                if (Player.GetGO())
                    return;
                ChangeCont();
                Player.SwitchTurn();
                Cards.PullCard();
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
                board[2][9].highlight();
                if (Player.GetGO())
                    return;
                ChangeCont();
                Player.SwitchTurn();
                Cards.PullCard();
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
            if (skip != null && skip.getColor() == Player.GetCurrentTurn().getColor())
            {
                Piece a = skip;
                skip = board[row - 1][column];
                board[row - 1][column] = board[row][column];
                board[row][column] = a;
            }
            else 
            {
                skip = board[row - 1][column];
                board[row - 1][column] = board[row][column];
                board[row][column] = null;
            }
            Player.SwitchTurn(row-1, column, card);
        }
        else if (board[row][column].getColor() == Player.GetCurrentTurn().getColor() && row + 1 < NUM_ROWS && column == NUM_COLUMNS - 1)
        {
            if (skip != null && skip.getColor() == Player.GetCurrentTurn().getColor())
            {
                Piece a = skip;
                skip = board[row + 1][column];
                board[row + 1][column] = board[row][column];
                board[row][column] = a;
            }
            else 
            {
                skip = board[row + 1][column];
                board[row + 1][column] = board[row][column];
                board[row][column] = null;
            }
            Player.SwitchTurn(row+1, column, card);
        }
        else if (board[row][column].getColor() == Player.GetCurrentTurn().getColor() && column + 1 < NUM_COLUMNS && row == 0)
        {
            if (skip != null && skip.getColor() == Player.GetCurrentTurn().getColor())
            {
                Piece a = skip;
                skip = board[row][column + 1];
                board[row][column + 1] = board[row][column];
                board[row][column] = a;
            }
            else 
            {
                skip = board[row][column + 1];
                board[row][column + 1] = board[row][column];
                board[row][column] = null;
            }
            Player.SwitchTurn(row, column+1, card);
        }
        else if (board[row][column].getColor() == Player.GetCurrentTurn().getColor() && column - 1 >= 0 && row == NUM_ROWS - 1)
        {
            if (skip != null && skip.getColor() == Player.GetCurrentTurn().getColor())
            {
                Piece a = skip;
                skip = board[row][column - 1];
                board[row][column - 1] = board[row][column];
                board[row][column] = a;
            }
            else 
            {
                skip = board[row][column - 1];
                board[row][column - 1] = board[row][column];
                board[row][column] = null;
            }
            Player.SwitchTurn(row, column-1, card);
        }
    }
    
    public static void SorryCard(int xpixel,int ypixel)
    {
        int ydelta = Window.getHeight2()/NUM_ROWS;
        int xdelta = Window.getWidth2()/NUM_COLUMNS;
        int xpixelOffset = xpixel - Window.getX(0);
        int  ypixelOffset = ypixel - Window.getY(0);
        //Return if the left mouse click is outside the board.        
        if (xpixelOffset < 0  ||  xpixelOffset > Window.getWidth2())
            return;
        if (ypixelOffset < 0  ||  ypixelOffset > Window.getHeight2())
            return;
        //Use xdelta, xpixelOffset, ydelta, ypixelOffset to determine the actual row and column.    
        int column = xpixelOffset/xdelta;
        int row = ypixelOffset/ydelta;
        //System.out.println("row:" + row + " col:" + column);
        if(board[row][column] == null)
            return;
        for (Piece space : notspaces)
        {
            if (board[row][column] == space)
                return;
        }
        for (int i = 0; i < 5; i++)
        {
            if (board[row][column] == board[14 - i][13])
                return;
        }
        for (int i = 0; i < 5; i++)
        {
            if (board[row][column] == board[13][1 + i])
                return;
        }
        for (int i = 0; i < 5; i++)
        {
            if (board[row][column] == board[1 + i][2])
                return;
        }
        for (int i = 0; i < 5; i++)
        {
            if (board[row][column] == board[2][14 - i])
                return;
        }
        if (board[row][column] == board[14][11] || board[row][column] == board[11][1] || board[row][column] == board[1][4] || board[row][column] == board[4][14])
            return;
        if (store == null)
        {
            if (board[row][column].getPlayer() != Player.GetCurrentTurn())
                return;
            store = board[row][column];
            storeRow = row;
            storeCol = column;
            return;
        }
        if (board[row][column].getPlayer() == Player.GetCurrentTurn())
        {
            store = board[row][column];
            storeRow = row;
            storeCol = column;
            return;
        }
        board[row][column] = store;
        board[storeRow][storeCol] = null;
        store = null;
        storeRow = 16;
        storeCol = 16;
        Player.SwitchTurn();
        Cards.PullCard();
    }
    
    public static void Highlight(int xpixel,int ypixel, int card)
    {
        boolean _go = false;
        int ydelta = Window.getHeight2()/NUM_ROWS;
        int xdelta = Window.getWidth2()/NUM_COLUMNS;
        int xpixelOffset = xpixel - Window.getX(0);
        int  ypixelOffset = ypixel - Window.getY(0);
        int row;
        int column;
        if (!cont)
        {
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
            if (board[row][column] == board[14][11] || board[row][column] == board[11][1] || board[row][column] == board[1][4] || board[row][column] == board[4][14])
                return;
        }
        else
        {
            column = xpixel;
            row = ypixel;
        }
        for (int i = 0; i < 5; i++)
        {
            if (board[row][column] == board[14 - i][13]  && Player.GetCurrentTurn().getColor() == Color.red)
            {
                if (Player.GetCurrentTurn().getColor() == Color.red && board[row -1][column].getContain())
                    return;
                row -= 1;
                _go = true;
                break;
            }
        }
        for (int i = 0; i < 5; i++)
        {
            if (board[row][column] == board[13][1 + i] && Player.GetCurrentTurn().getColor() == Color.blue)
            {
                if (Player.GetCurrentTurn().getColor() == Color.blue && board[row][column +1].getContain())
                    return;
                column += 1;
                _go = true;
                break;
            }
        }
        for (int i = 0; i < 5; i++)
        {
            if (board[row][column] == board[1 + i][2] && Player.GetCurrentTurn().getColor() == Color.yellow)
            {
                if (Player.GetCurrentTurn().getColor() == Color.yellow && board[row +1][column].getContain())
                    return;
                row += 1;
                _go = true;
                break;
            }        
        }
        for (int i = 0; i < 5; i++)
        {
            if (board[row][column] == board[2][14 - i]  && Player.GetCurrentTurn().getColor() == Color.green)
            {
                if (Player.GetCurrentTurn().getColor() == Color.green && board[row][column -1].getContain())
                    return;
                column -= 1;
                _go = true;
                break;
            }
        }
        if (row == 15 && column == 13 && Player.GetCurrentTurn().getColor() == Color.red)
        {
            if (Player.GetCurrentTurn().getColor() == Color.red && board[row -1][column].getContain())
                return;
            row--;
            _go = true;
        }
        if (row == 13 && column == 0 && Player.GetCurrentTurn().getColor() == Color.blue)
        {
            if (Player.GetCurrentTurn().getColor() == Color.blue && board[row][column +1].getContain())
                    return;
            column++;
            _go = true;
        }
        if (row == 0 && column == 2 && Player.GetCurrentTurn().getColor() == Color.yellow)
        {
            if (Player.GetCurrentTurn().getColor() == Color.yellow && board[row +1][column].getContain())
                    return;
            row++;
            _go = true;
        }
        if (row == 2 && column == 15 && Player.GetCurrentTurn().getColor() == Color.green)
        {
            if (Player.GetCurrentTurn().getColor() == Color.green && board[row][column -1].getContain())
                    return;
            column--;
            _go = true;
        }
        if (!_go)
        {
            if ((cont || board[row][column].getColor() == Player.GetCurrentTurn().getColor()) && row - 1 >= 0 && column == 0)
            {
    //            Piece a = hskip;
    //            hskip = board[row - 1][column];
    //            board[row][column] = a;
                row -=1;
            }
            else if ((cont || board[row][column].getColor() == Player.GetCurrentTurn().getColor()) && row + 1 < NUM_ROWS && column == NUM_COLUMNS - 1)
            {
    //            Piece a = hskip;
    //            hskip = board[row + 1][column];
    //            board[row][column] = a;
                row +=1;
            }
            else if ((cont || board[row][column].getColor() == Player.GetCurrentTurn().getColor()) && column + 1 < NUM_COLUMNS && row == 0)
            {
    //            Piece a = hskip;
    //            hskip = board[row][column + 1];
    //            board[row][column] = a;
                column +=1;
            }
            else if ((cont || board[row][column].getColor() == Player.GetCurrentTurn().getColor()) && column - 1 >= 0 && row == NUM_ROWS - 1)
            {
    //            Piece a = hskip;
    //            hskip = board[row][column - 1];
    //            board[row][column] = a;
                column -=1;
            }
        }
        if (card > 1)
        {
            if (!Board.GetCont())
                Board.ChangeCont();       
            if (row == 9 && column == 13)
            {
                if (cont)
                    ChangeCont();
                ChangeConfirm(null);
                return;
            }
            if (row == 13 && column == 6)
            {
                if (cont)
                    ChangeCont();
                ChangeConfirm(null);
                return;
            }            
            if (row == 6 && column == 2)
            {
                if (cont)
                    ChangeCont();
                ChangeConfirm(null);
                return;
            }            
            if (row == 2 && column == 9)
            {
                if (cont)
                    ChangeCont();
                ChangeConfirm(null);
                return;
            }            
            card--;
            Board.Highlight(column, row, card);
        }
        else
        {
            boolean x = false;
            for (int i = 0; i < 5; i++)
            {
                if (board[14 - i][13].getHighlight())
                {
                    board[14 - i][13].highlight();
                    x = true;
                }
            }
            for (int i = 0; i < 5; i++)
            {
                if (board[13][1 + i].getHighlight())
                {
                    board[13][1 + i].highlight();
                    x = true;
                }
            }
            for (int i = 0; i < 5; i++)
            {
                if (board[1 + i][2].getHighlight())
                {
                    board[1 + i][2].highlight();
                    x = true;
                }        
            }
            for (int i = 0; i < 5; i++)
            {
                if (board[2][14 - i].getHighlight())
                {
                    board[2][14 - i].highlight();
                    x = true;
                }
            }
            if (Board.GetCont())
                Board.ChangeCont();
            if (!x)
            {
                if (HighlightR != 16)
                    board[HighlightR][HighlightC] = null;
            }
            if (board[row][column] == null)
                board[row][column] = new OvalPiece(Color.pink);
            HighlightR = row;
            HighlightC = column;
            board[row][column].highlight();
        }
    }
    public static void HighlightReset()
    {
        HighlightR = 16;
        HighlightC = 16;
        confirm = null;
        for (int z = 0; z < NUM_ROWS; z++)
        {
            for (int x = 0; x < NUM_COLUMNS; x++)
            {
                if (board[z][x] != null)
                {
                    if (board[z][x].getHighlight())
                    {
                        board[z][x].highlight();
                    }
                    else if (board[z][x].checkSafezone() && board[z][x].getHighlight())
                    {
                        board[z][x].highlight();
                    }
                }
            }
        }
    }
    public static void SlideCheck(int row, int column)
    {
        for (Slide aSlide : slides)
        {
            if (board[row][column] == board[aSlide.getRow()][aSlide.getColumn()])
            {
                if (row == 0 && board[row][column].getColor() != Color.yellow)
                {
                    board[row][column+aSlide.getLength()-1] = board[row][column];
                    board[row][column] = null;
                    for (int i = column+aSlide.getLength()-2; i > column; i--)
                    {
                        board[row][i] = null;
                    }
                    return;
                }
                else if (row == 15 && board[row][column].getColor() != Color.red)
                {
                    board[row][column-aSlide.getLength()+1] = board[row][column];
                    board[row][column] = null;
                    for (int i = column-aSlide.getLength()+2; i < column; i++)
                    {
                        board[row][i] = null;
                    }
                    return;
                }
                else if (column == 0 && board[row][column].getColor() != Color.blue)
                {
                    board[row-aSlide.getLength()+1][column] = board[row][column];
                    board[row][column] = null;
                    for (int i = row-aSlide.getLength()+2; i < row; i++)
                    {
                        board[i][column] = null;
                    }
                    return;
                }
                else if (column == 15 && board[row][column].getColor() != Color.green)
                {
                    board[row+aSlide.getLength()-1][column] = board[row][column];
                    board[row][column] = null;
                    for (int i = row+aSlide.getLength()-2; i > row; i--)
                    {
                        board[i][column] = null;
                    }
                    return;
                }
            }
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
                {
                    if (board[zrow][zcol] == store) 
                    {
                        new RectPiece(Color.cyan).draw(g, zrow, zcol, xdelta, ydelta);
                    }
                    board[zrow][zcol].draw(g, zrow, zcol,xdelta, ydelta);
                }
            }
        }
    g.setColor(Color.black);    
    Player.StringCentered(g,Window.getX(11*(xdelta - 1)+2), Window.getY(ydelta - 55),(3 - activeP[0]) +"","Arial",30);   
    Player.StringCentered(g,Window.getX(2*xdelta -48), Window.getY(2*ydelta + 13),(3 - activeP[1]) +"","Arial",30);
    Player.StringCentered(g,Window.getX(4*(xdelta - 1)- 4), Window.getY(14*ydelta - 55),(3 - activeP[2]) +"","Arial",30);
    Player.StringCentered(g,Window.getX(14*xdelta - 9), Window.getY(11*(xdelta - 9)),(3 - activeP[3]) +"","Arial",30);
    StringCentered(g,Window.getWidth2()/2, 114,"Press spacebar to forfiet your turn","Arial",20);
    
    }
    public static void ActiveCheck()
    {
        for (int i = 3; i >= 0; i--)
            activeP[i] = Player.findPlayer(i).getPoints();
        for (int i = 0; i < 16; i++)
        {
            for(int j = 0; j < 16; j++)  
            if (board[i][j] != null)
               {
                  if (i == 0 || i == 15 || j == 15 || j == 0)
                  {
                      if (board[i][j].getColor() == Color.red)
                      {
                          activeP[0] += 1;
                      }
                      else if (board[i][j].getColor() == Color.blue)
                      {
                          activeP[1] += 1;
                      }
                      else if (board[i][j].getColor() == Color.yellow)
                      {
                          activeP[2] += 1;
                      }
                      else if (board[i][j].getColor() == Color.green)
                      {
                          activeP[3] += 1;
                      }
                }
            if (i != 0 && i != 15 && j != 0 && j != 15 && board[i][j] == null)
            {
                board[i][j] = new RectPiece(Color.gray);
            }
            }
        }
        for (int i = 14; i > 9; i--)
        {
            if (!board[i][13].getHighlight())
                if (board[i][13].getContain())
                    activeP[0] += 1;
        }
        for (int i = 1; i < 6; i++)
        {
            if (!board[13][i].getHighlight())
                if (board[13][i].getContain())
                    activeP[1] += 1;
        }
        for (int i = 1; i < 6; i++)
        {
            if (!board[i][2].getHighlight())
                if (board[i][2].getContain())
                    activeP[2] += 1;
        }
        for (int i = 14; i > 9; i--)
        {
            if (!board[2][i].getHighlight())
                if (board[2][i].getContain())
                    activeP[3] += 1;
        }
    }
    public static int GetNUM_ROWS()
    {
        return (NUM_ROWS);
    }
    public static void ChangeConfirm(Piece p)
    {
        confirm = p;
    }
    public static void ChangeCont()
    {
        cont = !cont;
    }
    public static boolean GetCont()
    {
        return cont;
    }
    public static Piece getStore()
    {
        return (store);
    }
    public static void StoreReset()
    {
        store = null;
        storeRow = 16;
        storeCol = 16;
    }
    public static int getActive(int i)
    {
        if (i >= 0 && i <= 3)
            return activeP[i];
        else
            return 0;
    }
}