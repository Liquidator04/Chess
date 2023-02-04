package LegalMovesCheck;

import frontEnd.*;

public class Queen
{
    static int pieceCoordinateStatic;
    static int legal[]=new int[27];
    static GameScreenWhite currentGame;
    static GameScreenBlack currentGame1;
    static int index=0;
    boolean black=false;
    public Queen(int pieceCoordinate,GameScreenWhite game)
    {
        currentGame=game;
        pieceCoordinateStatic=pieceCoordinate;
        for(int i=0;i<legal.length;i++)
        {
            legal[i]=-1;
        }
        black=false;
    }
    public Queen(int pieceCoordinate,GameScreenBlack game)
    {
        currentGame1=game;
        pieceCoordinateStatic=pieceCoordinate;
        for(int i=0;i<legal.length;i++)
        {
            legal[i]=-1;
        }
        black=true;
    }
    private void check()
    {
        if(black==false)
        {
            index=0;
            Bishop b=new Bishop(pieceCoordinateStatic,currentGame);
            Rook r=new Rook(pieceCoordinateStatic,currentGame);
            int[] bMoves=b.legal();
            int[] rMoves=r.legal();
            for(int i:bMoves)
            {
                if(i==-1)
                    break;
                legal[index++]=i;
            }
            for(int i:rMoves)
            {
                if(i==-1)
                    break;
                legal[index++]=i;
            }
        }
        else
        {
            index=0;
            Bishop b=new Bishop(pieceCoordinateStatic,currentGame1);
            Rook r=new Rook(pieceCoordinateStatic,currentGame1);
            int[] bMoves=b.legal();
            int[] rMoves=r.legal();
            for(int i:bMoves)
            {
                if(i==-1)
                    break;
                legal[index++]=i;
            }
            for(int i:rMoves)
            {
                if(i==-1)
                    break;
                legal[index++]=i;
            }
        }
    }
    
    public int[] legal()
    {
        check();
        return legal;
    }
    
}
