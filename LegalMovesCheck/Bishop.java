/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LegalMovesCheck;
import TileStatus.tileStatus;
import frontEnd.*;
/**
 *
 * @author admin
 */
public class Bishop {
    
    static int pieceCoordinateStatic;
    static int legal[]=new int[13];
    static int index=0;
    static GameScreenWhite currentGame;
    static GameScreenBlack currentGame1;
    static boolean top,bottom,left,right;
    boolean black=false;
    
    public Bishop(int pieceCoordinate,GameScreenWhite game)
    {
        currentGame=game;
        pieceCoordinateStatic=pieceCoordinate;
        for(int i=0;i<legal.length;i++)
        {
            legal[i]=-1;
        }
        black=false;
    }
    public Bishop(int pieceCoordinate,GameScreenBlack game)
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
            //figuring out for top left diagonal
            for(int i=pieceCoordinateStatic-9;i>=0;i-=9)
            {
                if(currentGame.friendlyPiecePresent(i))
                {
                    break;
                }
                else 
                {
                    if(!(tileStatus.top(pieceCoordinateStatic,i)&&tileStatus.left(pieceCoordinateStatic,i)))
                    {
                        break;
                    }
                    legal[index]=i;
                    index++;
                    if(currentGame.opposingPiecePresent(i))
                    {
                        break;
                    }
                }
            }
            //figuring out for bottom right diagonal
            for(int i=pieceCoordinateStatic+9;i<64;i+=9)
            {
                if(currentGame.friendlyPiecePresent(i))
                {
                    break;
                }
                else 
                {
                    if(!(tileStatus.bottom(pieceCoordinateStatic,i)&&tileStatus.right(pieceCoordinateStatic,i)))
                    {
                        break;
                    }
                    legal[index]=i;
                    index++;
                    if(currentGame.opposingPiecePresent(i))
                    {
                        break;
                    }
                }
            }
            //figuring out for top right diagonal
            for(int i=pieceCoordinateStatic-7;i>0;i-=7)
            {
                if(currentGame.friendlyPiecePresent(i))
                {
                    break;
                }
                else 
                {
                    if(!(tileStatus.top(pieceCoordinateStatic,i)&&tileStatus.right(pieceCoordinateStatic,i)))
                    {
                        break;
                    }
                    legal[index]=i;
                    index++;
                    if(currentGame.opposingPiecePresent(i))
                    {
                        break;
                    }
                }
            }
            //figuring out for bottom left diagonal
            for(int i=pieceCoordinateStatic+7;i<63;i+=7)
            {
                if(currentGame.friendlyPiecePresent(i))
                {
                    break;
                }
                else 
                {
                    if(!(tileStatus.bottom(pieceCoordinateStatic,i)&&tileStatus.left(pieceCoordinateStatic,i)))
                    {
                        break;
                    }
                    legal[index]=i;
                    index++;
                    if(currentGame.opposingPiecePresent(i))
                    {
                        break;
                    }
                }
            }
        }
        else
        {
            index=0;
            //figuring out for top left diagonal
            for(int i=pieceCoordinateStatic-9;i>=0;i-=9)
            {
                if(currentGame1.friendlyPiecePresent(i))
                {
                    break;
                }
                else 
                {
                    if(!(tileStatus.top(pieceCoordinateStatic,i)&&tileStatus.left(pieceCoordinateStatic,i)))
                    {
                        break;
                    }
                    legal[index]=i;
                    index++;
                    if(currentGame1.opposingPiecePresent(i))
                    {
                        break;
                    }
                }
            }
            //figuring out for bottom right diagonal
            for(int i=pieceCoordinateStatic+9;i<64;i+=9)
            {
                if(currentGame1.friendlyPiecePresent(i))
                {
                    break;
                }
                else 
                {
                    if(!(tileStatus.bottom(pieceCoordinateStatic,i)&&tileStatus.right(pieceCoordinateStatic,i)))
                    {
                        break;
                    }
                    legal[index]=i;
                    index++;
                    if(currentGame1.opposingPiecePresent(i))
                    {
                        break;
                    }
                }
            }
            //figuring out for top right diagonal
            for(int i=pieceCoordinateStatic-7;i>0;i-=7)
            {
                if(currentGame1.friendlyPiecePresent(i))
                {
                    break;
                }
                else 
                {
                    if(!(tileStatus.top(pieceCoordinateStatic,i)&&tileStatus.right(pieceCoordinateStatic,i)))
                    {
                        break;
                    }
                    legal[index]=i;
                    index++;
                    if(currentGame1.opposingPiecePresent(i))
                    {
                        break;
                    }
                }
            }
            //figuring out for bottom left diagonal
            for(int i=pieceCoordinateStatic+7;i<63;i+=7)
            {
                if(currentGame1.friendlyPiecePresent(i))
                {
                    break;
                }
                else 
                {
                    if(!(tileStatus.bottom(pieceCoordinateStatic,i)&&tileStatus.left(pieceCoordinateStatic,i)))
                    {
                        break;
                    }
                    legal[index]=i;
                    index++;
                    if(currentGame1.opposingPiecePresent(i))
                    {
                        break;
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
