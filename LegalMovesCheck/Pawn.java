/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LegalMovesCheck;

import frontEnd.*;
import TileStatus.*;
/**
 *
 * @author admin
 */
public class Pawn {
            
    static int pieceCoordinateStatic;
    static int legal[]=new int[4];
    static int index=0;
    static GameScreenWhite currentGame;
    boolean black=false;
    static GameScreenBlack currentGame1;
    
    public Pawn(int pieceCoordinate,GameScreenWhite game)
    {
        currentGame=game;
        pieceCoordinateStatic=pieceCoordinate;
        for(int i=0;i<legal.length;i++)
        {
            legal[i]=-1;
        }
        black=false;
    }
    public Pawn(int pieceCoordinate,GameScreenBlack game)
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
            int i,j;
            //Checking 1 tile forward
            if(currentGame.turnCheckerReturner()==1)
            {
                i=pieceCoordinateStatic-8;
            }
            else
            {
                i=pieceCoordinateStatic+8;
            }
            if(i>=0&&i<64&&currentGame.friendlyPiecePresent(i)==false&&currentGame.opposingPiecePresent(i)==false)
            {
                legal[index]=i;
                index++;
            }
            //Checking 2 tiles forward
            if(currentGame.turnCheckerReturner()==1)
            {
                i=pieceCoordinateStatic-16;
                j=pieceCoordinateStatic-8;
            }
            else
            {
                i=pieceCoordinateStatic+16;
                j=pieceCoordinateStatic+8;
            }
            if(((currentGame.turnCheckerReturner()==-1&&pieceCoordinateStatic>7&&pieceCoordinateStatic<16)||(currentGame.turnCheckerReturner()==1&&pieceCoordinateStatic>47&&pieceCoordinateStatic<56))&&(currentGame.friendlyPiecePresent(j)==false&&currentGame.opposingPiecePresent(j)==false)&&(currentGame.friendlyPiecePresent(i)==false&&currentGame.opposingPiecePresent(i)==false))
            {
                legal[index]=i;
                index++;
            }
            //Checking 1 tile forward in the left diagonal
            if(currentGame.turnCheckerReturner()==1)
            {
                i=pieceCoordinateStatic-9;
            }
            else
            {
                i=pieceCoordinateStatic+7;
            }
            if(i>=0&&i<64&&tileStatus.left(pieceCoordinateStatic,i)&&(currentGame.opposingPiecePresent(i)==true||(currentGame.opposingPiecePresent(pieceCoordinateStatic-1)==true&&currentGame.getPieceInTile(pieceCoordinateStatic-1).getEnPassant())))
            {
                legal[index]=i;
                index++;
            }
            //Checking 1 tile forward in the right diagonal
            if(currentGame.turnCheckerReturner()==1)
            {
                i=pieceCoordinateStatic-7;
            }
            else
            {
                i=pieceCoordinateStatic+9;
            }
            if(i>=0&&i<64&&tileStatus.right(pieceCoordinateStatic,i)&&(currentGame.opposingPiecePresent(i)==true||(currentGame.opposingPiecePresent(pieceCoordinateStatic+1)==true&&currentGame.getPieceInTile(pieceCoordinateStatic+1).getEnPassant())))
            {
                legal[index]=i;
                index++;
            }
        }
        else
        {
            index=0;
            int i,j;
            //Checking 1 tile forward
            if(currentGame1.turnCheckerReturner()==-1)
            {
                i=pieceCoordinateStatic-8;
            }
            else
            {
                i=pieceCoordinateStatic+8;
            }
            if(i>=0&&i<64&&currentGame1.friendlyPiecePresent(i)==false&&currentGame1.opposingPiecePresent(i)==false)
            {
                legal[index]=i;
                index++;
            }
            //Checking 2 tiles forward
            if(currentGame1.turnCheckerReturner()==-1)
            {
                i=pieceCoordinateStatic-16;
                j=pieceCoordinateStatic-8;
            }
            else
            {
                i=pieceCoordinateStatic+16;
                j=pieceCoordinateStatic+8;
            }
            if(((currentGame1.turnCheckerReturner()==1&&pieceCoordinateStatic>7&&pieceCoordinateStatic<16)||(currentGame1.turnCheckerReturner()==-1&&pieceCoordinateStatic>47&&pieceCoordinateStatic<56))&&(currentGame1.friendlyPiecePresent(j)==false&&currentGame1.opposingPiecePresent(j)==false)&&(currentGame1.friendlyPiecePresent(i)==false&&currentGame1.opposingPiecePresent(i)==false))
            {
                legal[index]=i;
                index++;
            }
            //Checking 1 tile forward in the left diagonal
            if(currentGame1.turnCheckerReturner()==-1)
            {
                i=pieceCoordinateStatic-9;
            }
            else
            {
                i=pieceCoordinateStatic+7;
            }
            if(i>=0&&i<64&&tileStatus.left(pieceCoordinateStatic,i)&&(currentGame1.opposingPiecePresent(i)==true||(currentGame1.opposingPiecePresent(pieceCoordinateStatic-1)==true&&currentGame1.getPieceInTile(pieceCoordinateStatic-1).getEnPassant())))
            {
                legal[index]=i;
                index++;
            }
            //Checking 1 tile forward in the right diagonal
            if(currentGame1.turnCheckerReturner()==-1)
            {
                i=pieceCoordinateStatic-7;
            }
            else
            {
                i=pieceCoordinateStatic+9;
            }
            if(i>=0&&i<64&&tileStatus.right(pieceCoordinateStatic,i)&&(currentGame1.opposingPiecePresent(i)==true||(currentGame1.opposingPiecePresent(pieceCoordinateStatic+1)==true&&currentGame1.getPieceInTile(pieceCoordinateStatic+1).getEnPassant())))
            {
                legal[index]=i;
                index++;
            }
        }
    }
    public int[] legal()
    {
        check();
        return legal;
    }
}
