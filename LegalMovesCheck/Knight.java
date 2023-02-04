package LegalMovesCheck;

import TileStatus.tileStatus;
import frontEnd.*;
public class Knight
{

    static int pieceCoordinateStatic;
    static int legal[]=new int[8];
    static int index=0;
    static GameScreenWhite currentGame;
    static GameScreenBlack currentGame1;
    boolean black=false;
    public Knight(int pieceCoordinate,GameScreenWhite game)
    {
        currentGame=game;
        pieceCoordinateStatic=pieceCoordinate;
        for(int i=0;i<legal.length;i++)
        {
            legal[i]=-1;
        }
        black=false;
    }
    public Knight(int pieceCoordinate,GameScreenBlack game)
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
            for(int i=0;i<64;i++)
            {
                try{
                if(currentGame.friendlyPiecePresent(i))
                {
                    continue;
                }
                }
                catch(Exception e)
                {
                    System.out.println(i);
                }
                if((pieceCoordinateStatic+6)==i || (pieceCoordinateStatic-6)==i || (pieceCoordinateStatic+10)==i || (pieceCoordinateStatic-10)==i || (pieceCoordinateStatic+15)==i || (pieceCoordinateStatic-15)==i || (pieceCoordinateStatic+17)==i || (pieceCoordinateStatic-17)==i)
                {
                    if(tileStatus.getTile(i).toString().charAt(0)-1==tileStatus.getTile(pieceCoordinateStatic).toString().charAt(0) || tileStatus.getTile(i).toString().charAt(0)+1==tileStatus.getTile(pieceCoordinateStatic).toString().charAt(0) ||tileStatus.getTile(i).toString().charAt(0)+2==tileStatus.getTile(pieceCoordinateStatic).toString().charAt(0) || tileStatus.getTile(i).toString().charAt(0)-2==tileStatus.getTile(pieceCoordinateStatic).toString().charAt(0))
                    {
                        legal[index]=i;
                        index++;
                    }

                }
            }
        }
        else
        {
            index=0;
            for(int i=0;i<64;i++)
            {
                try{
                if(currentGame1.friendlyPiecePresent(i))
                {
                    continue;
                }
                }
                catch(Exception e)
                {
                    System.out.println(i);
                }
                if((pieceCoordinateStatic+6)==i || (pieceCoordinateStatic-6)==i || (pieceCoordinateStatic+10)==i || (pieceCoordinateStatic-10)==i || (pieceCoordinateStatic+15)==i || (pieceCoordinateStatic-15)==i || (pieceCoordinateStatic+17)==i || (pieceCoordinateStatic-17)==i)
                {
                    if(tileStatus.getTile(i).toString().charAt(0)-1==tileStatus.getTile(pieceCoordinateStatic).toString().charAt(0) || tileStatus.getTile(i).toString().charAt(0)+1==tileStatus.getTile(pieceCoordinateStatic).toString().charAt(0) ||tileStatus.getTile(i).toString().charAt(0)+2==tileStatus.getTile(pieceCoordinateStatic).toString().charAt(0) || tileStatus.getTile(i).toString().charAt(0)-2==tileStatus.getTile(pieceCoordinateStatic).toString().charAt(0))
                    {
                        legal[index]=i;
                        index++;
                    }

                }
            }
        }
    }
    
    public int[] legal()
    {
        check();
        return legal;
    }
}
