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
 * @author HOME
 */
public class Rook {
        
    static int pieceCoordinateStatic;
    static int legal[]=new int[14];
    static int index=0;
    static GameScreenWhite currentGame;
    static GameScreenBlack currentGame1;
    boolean black=false;
    
    public Rook(int pieceCoordinate,GameScreenWhite game)
    {
        currentGame=game;
        pieceCoordinateStatic=pieceCoordinate;
        for(int i=0;i<legal.length;i++)
        {
            legal[i]=-1;
        }
        black=false;
    }
    public Rook(int pieceCoordinate,GameScreenBlack game)
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
            //figuring out for left
            for(int i=pieceCoordinateStatic-1;i>=0;i--)
            {
                if(currentGame.friendlyPiecePresent(i))
                {
                    break;
                }
                else 
                {
                    if(!(tileStatus.left(pieceCoordinateStatic,i)))
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
            //figuring out for right
            for(int i=pieceCoordinateStatic+1;i<64;i++)
            {
                if(currentGame.friendlyPiecePresent(i))
                {
                    break;
                }
                else 
                {
                    if(!(tileStatus.right(pieceCoordinateStatic,i)))
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
            //figuring out for top 
            for(int i=pieceCoordinateStatic-8;i>=0;i-=8)
            {
                if(currentGame.friendlyPiecePresent(i))
                {
                    break;
                }
                else 
                {
                    if(!(tileStatus.top(pieceCoordinateStatic,i)))
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
            //figuring out for bottom 
            for(int i=pieceCoordinateStatic+8;i<64;i+=8)
            {
                if(currentGame.friendlyPiecePresent(i))
                {
                    break;
                }
                else 
                {
                    if(!(tileStatus.bottom(pieceCoordinateStatic,i)))
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
            //figuring out for left
            for(int i=pieceCoordinateStatic-1;i>=0;i--)
            {
                if(currentGame1.friendlyPiecePresent(i))
                {
                    break;
                }
                else 
                {
                    if(!(tileStatus.left(pieceCoordinateStatic,i)))
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
            //figuring out for right
            for(int i=pieceCoordinateStatic+1;i<64;i++)
            {
                if(currentGame1.friendlyPiecePresent(i))
                {
                    break;
                }
                else 
                {
                    if(!(tileStatus.right(pieceCoordinateStatic,i)))
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
            //figuring out for top 
            for(int i=pieceCoordinateStatic-8;i>=0;i-=8)
            {
                if(currentGame1.friendlyPiecePresent(i))
                {
                    break;
                }
                else 
                {
                    if(!(tileStatus.top(pieceCoordinateStatic,i)))
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
            //figuring out for bottom 
            for(int i=pieceCoordinateStatic+8;i<64;i+=8)
            {
                if(currentGame1.friendlyPiecePresent(i))
                {
                    break;
                }
                else 
                {
                    if(!(tileStatus.bottom(pieceCoordinateStatic,i)))
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
