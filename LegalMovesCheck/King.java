package LegalMovesCheck;
import frontEnd.*;
import TileStatus.tileStatus;
import piece.piece;
public class King
{
    static int pieceCoordinateStatic;
    static int legal[]=new int[10];
    static int index=0;
    static GameScreenWhite currentGame;
    static GameScreenBlack currentGame1;
    boolean black=false;
    piece p;
    public King(int pieceCoordinate,GameScreenWhite game,piece p)
    {
        currentGame=game;
        pieceCoordinateStatic=pieceCoordinate;
        for(int i=0;i<legal.length;i++)
        {
            legal[i]=-1;
        }
        this.p=p;
        black=false;
    }
    public King(int pieceCoordinate,GameScreenBlack game,piece p)
    {
        currentGame1=game;
        pieceCoordinateStatic=pieceCoordinate;
        for(int i=0;i<legal.length;i++)
        {
            legal[i]=-1;
        }
        this.p=p;
        black=true;
    }
    private void check()    
    {
        System.out.println("black:"+black);
        if(black==false)
        {
            boolean a=false;
            index=0;
            if(currentGame.check(pieceCoordinateStatic)==false)
            {
                for(int i=0;i<64;i++)
                {
                    if(currentGame.friendlyPiecePresent(i))
                    {
                        continue;
                    }
                    if((pieceCoordinateStatic+9)==i || (pieceCoordinateStatic-9)==i || (pieceCoordinateStatic+8)==i || (pieceCoordinateStatic-8)==i || (pieceCoordinateStatic+7)==i || (pieceCoordinateStatic-7)==i || (pieceCoordinateStatic+1)==i || (pieceCoordinateStatic-1)==i)
                    {
                        if(tileStatus.getTile(i).toString().charAt(0)-1==tileStatus.getTile(pieceCoordinateStatic).toString().charAt(0) || tileStatus.getTile(i).toString().charAt(0)+1==tileStatus.getTile(pieceCoordinateStatic).toString().charAt(0) || tileStatus.getTile(i).toString().charAt(0)==tileStatus.getTile(pieceCoordinateStatic).toString().charAt(0))
                        {
                            if(currentGame.opposingPiecePresent(i))
                            {
                                if(currentGame.check(p,i)==false)
                                {
                                    legal[index]=i;
                                    index++;
                                }
                            }
                            else
                            {
                                if(currentGame.check(p,i)==false)
                                {
                                    legal[index]=i;
                                    index++;
                                }
                            }
                        }
                    }
                }
                if(castle())//first checks whether any castling piece is moved
                {
                    switch(pieceCoordinateStatic)
                    {
                        case 60:
                            for(int i=61;i<63;i++)
                            {
                                if(currentGame.check(i) || currentGame.friendlyPiecePresent(i) ||currentGame.opposingPiecePresent(i))
                                {
                                    a=true;
                                    break;
                                }
                            }
                            if(currentGame.check(63) || currentGame.opposingPiecePresent(63))
                            {
                                a=true;
                            }
                            if(a==false)
                            {
                                legal[index]=62;
                                index++;
                            }
                            a=false;
                            for(int i=59;i>57;i--)
                            {
                                if(currentGame.check(i) || currentGame.friendlyPiecePresent(i) || currentGame.opposingPiecePresent(i))
                                {
                                    a=true;
                                    break;
                                }
                            }
                            if(currentGame.check(57) || currentGame.opposingPiecePresent(57))
                            {
                                a=true;
                            }
                            if(a==false)
                            {
                                legal[index]=58;
                                index++;
                            }
                            break;
                        case 4:
                            for(int i=5;i<7;i++)
                            {
                                if(currentGame.check(i) || currentGame.friendlyPiecePresent(i) ||currentGame.opposingPiecePresent(i))
                                {
                                    a=true;
                                    break;
                                }
                            }
                            if(currentGame.check(7) || currentGame.opposingPiecePresent(7))
                            {
                                a=true;
                            }
                            if(a==false)
                            {
                                legal[index]=6;
                                index++;
                            }
                            a=false;
                            for(int i=3;i>0;i--)
                            {
                                if(currentGame.check(i) || currentGame.friendlyPiecePresent(i) || currentGame.opposingPiecePresent(i))
                                {
                                    a=true;
                                    break;
                                }
                            }
                            if(currentGame.check(0) || currentGame.opposingPiecePresent(0))
                            {
                                a=true;
                            }
                            if(a==false)
                            {
                                legal[index]=2;
                                index++;
                            }
                            break;
                    }
                }
            }
            else
            {
                for(int i=0;i<64;i++)
                {
                    if(currentGame.friendlyPiecePresent(i))
                    {
                        continue;
                    }
                    if((pieceCoordinateStatic+9)==i || (pieceCoordinateStatic-9)==i || (pieceCoordinateStatic+8)==i || (pieceCoordinateStatic-8)==i || (pieceCoordinateStatic+7)==i || (pieceCoordinateStatic-7)==i || (pieceCoordinateStatic+1)==i || (pieceCoordinateStatic-1)==i)
                    {
                        if(tileStatus.getTile(i).toString().charAt(0)-1==tileStatus.getTile(pieceCoordinateStatic).toString().charAt(0) || tileStatus.getTile(i).toString().charAt(0)+1==tileStatus.getTile(pieceCoordinateStatic).toString().charAt(0) || tileStatus.getTile(i).toString().charAt(0)==tileStatus.getTile(pieceCoordinateStatic).toString().charAt(0))
                        {
                            if(currentGame.opposingPiecePresent(i)){
                                if(currentGame.check(p,i)==false)
                                {
                                    legal[index]=i;
                                    index++;
                                }
                            }
                            else
                            {
                                if(currentGame.check(p,i)==false)
                                {
                                    legal[index]=i;
                                    index++;
                                }
                            }
                        }
                    }
                }
            }
        }
        else
        {
            boolean a=false;
            index=0;
            if(currentGame1.check(pieceCoordinateStatic)==false)
            {
                for(int i=0;i<64;i++)
                {
                    if(currentGame1.friendlyPiecePresent(i))
                    {
                        continue;
                    }
                    if((pieceCoordinateStatic+9)==i || (pieceCoordinateStatic-9)==i || (pieceCoordinateStatic+8)==i || (pieceCoordinateStatic-8)==i || (pieceCoordinateStatic+7)==i || (pieceCoordinateStatic-7)==i || (pieceCoordinateStatic+1)==i || (pieceCoordinateStatic-1)==i)
                    {
                        if(tileStatus.getTile(i).toString().charAt(0)-1==tileStatus.getTile(pieceCoordinateStatic).toString().charAt(0) || tileStatus.getTile(i).toString().charAt(0)+1==tileStatus.getTile(pieceCoordinateStatic).toString().charAt(0) || tileStatus.getTile(i).toString().charAt(0)==tileStatus.getTile(pieceCoordinateStatic).toString().charAt(0))
                        {
                            if(currentGame1.opposingPiecePresent(i))
                            {
                                if(currentGame1.check(p,i)==false)
                                {
                                    legal[index]=i;
                                    index++;
                                }
                            }
                            else
                            {
                                if(currentGame1.check(p,i)==false)
                                {
                                    legal[index]=i;
                                    index++;
                                }
                            }
                        }
                    }
                }
                if(castle())//first checks whether any castling piece is moved
                {
                    switch(pieceCoordinateStatic)
                    {
                        case 60:
                            for(int i=61;i<63;i++)
                            {
                                if(currentGame1.check(i) || currentGame1.friendlyPiecePresent(i) ||currentGame1.opposingPiecePresent(i))
                                {
                                    a=true;
                                    break;
                                }
                            }
                            if(currentGame1.check(63) || currentGame1.opposingPiecePresent(63))
                            {
                                a=true;
                            }
                            if(a==false)
                            {
                                legal[index]=62;
                                index++;
                            }
                            a=false;
                            for(int i=59;i>57;i--)
                            {
                                if(currentGame1.check(i) || currentGame1.friendlyPiecePresent(i) || currentGame1.opposingPiecePresent(i))
                                {
                                    a=true;
                                    break;
                                }
                            }
                            if(currentGame1.check(57) || currentGame1.opposingPiecePresent(57))
                            {
                                a=true;
                            }
                            if(a==false)
                            {
                                legal[index]=58;
                                index++;
                            }
                            break;
                        case 4:
                            for(int i=5;i<7;i++)
                            {
                                if(currentGame1.check(i) || currentGame1.friendlyPiecePresent(i) ||currentGame1.opposingPiecePresent(i))
                                {
                                    a=true;
                                    break;
                                }
                            }
                            if(currentGame1.check(7) || currentGame1.opposingPiecePresent(7))
                            {
                                a=true;
                            }
                            if(a==false)
                            {
                                legal[index]=6;
                                index++;
                            }
                            a=false;
                            for(int i=3;i>0;i--)
                            {
                                if(currentGame1.check(i) || currentGame1.friendlyPiecePresent(i) || currentGame1.opposingPiecePresent(i))
                                {
                                    a=true;
                                    break;
                                }
                            }
                            if(currentGame1.check(0) || currentGame1.opposingPiecePresent(0))
                            {
                                a=true;
                            }
                            if(a==false)
                            {
                                legal[index]=2;
                                index++;
                            }
                            break;
                    }
                }
            }
            else
            {
                for(int i=0;i<64;i++)
                {
                    if(currentGame1.friendlyPiecePresent(i))
                    {
                        continue;
                    }
                    if((pieceCoordinateStatic+9)==i || (pieceCoordinateStatic-9)==i || (pieceCoordinateStatic+8)==i || (pieceCoordinateStatic-8)==i || (pieceCoordinateStatic+7)==i || (pieceCoordinateStatic-7)==i || (pieceCoordinateStatic+1)==i || (pieceCoordinateStatic-1)==i)
                    {
                        if(tileStatus.getTile(i).toString().charAt(0)-1==tileStatus.getTile(pieceCoordinateStatic).toString().charAt(0) || tileStatus.getTile(i).toString().charAt(0)+1==tileStatus.getTile(pieceCoordinateStatic).toString().charAt(0) || tileStatus.getTile(i).toString().charAt(0)==tileStatus.getTile(pieceCoordinateStatic).toString().charAt(0))
                        {
                            if(currentGame1.opposingPiecePresent(i)){
                                if(currentGame1.check(p,i)==false)
                                {
                                    legal[index]=i;
                                    index++;
                                }
                            }
                            else
                            {
                                if(currentGame1.check(p,i)==false)
                                {
                                    legal[index]=i;
                                    index++;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    private boolean castle()//this bassically checking if any of your kings/rooks have moved
    {
        boolean a=true;
        if(black==false)
        {
            piece pieces[]=currentGame.getPiece();//getting all the pieces for its castles see get getPiece() function in GameScreenWhite to have better understanding
            for(piece p:pieces)
            {
                //getting whether the piece has actually moved
                if(p.getMoved())
                {
                    a=false;
                    break;
                }
            }
        }
        else
        {
            piece pieces[]=currentGame1.getPiece();//getting all the pieces for its casles see get getPiece() function in GameScreenWhite to have better understanding
            for(piece p:pieces)
            {
                //getting whether the piece has actually moved
                if(p.getMoved())
                {
                    a=false;
                    break;
                }
            }
        }
        return a;
    }
    public int[] legal()
    {
        check();
        return legal;
    }
}
