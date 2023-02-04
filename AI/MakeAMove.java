package AI;

import frontEnd.GameScreenWhite;
import piece.piece;
import Alliances.Tile;
import TileStatus.tileStatus;

public class MakeAMove
{
    GameScreenWhite CurrentGame;
    String Color;
    piece AIPieces[];
    piece OpposingPieces[];
    piece PieceThatMakesMove;
    Tile TheTile;
    Evaluate obj;
    
    public MakeAMove(GameScreenWhite CurrentGame,String Color)
    {
        this.CurrentGame=CurrentGame;
        this.Color=Color;
        if(Color.equals("W"))
        {
            AIPieces=CurrentGame.WhitePieces;
            OpposingPieces=CurrentGame.BlackPieces;
        }
        else
        {
            AIPieces=CurrentGame.BlackPieces;
            OpposingPieces=CurrentGame.WhitePieces;        
        }
        obj=new Evaluate(this);
    }
    
    private void moveAndPiece()
    {
        int count=0;
        for(piece t:AIPieces)
        {
            t.setTileCoordinate();
            t.setLegalTiles();
        }
        if(obj.freePiece()==false){
            for(;;){
                int r;

                r=(int)(Math.random()*(14-1))+1;
                piece p=AIPieces[r];
                if(p.getCaptured()==false){
                    int legal[];
                    p.setTileCoordinate();
                    p.setLegalTiles();
                    legal=p.getLegal();
                    for(int i=0;i<legal.length&&legal[i]!=-1;i++)
                    {
                        count++;
                    }
                    if(count>0)
                    {
                        int rand;
                        rand = (int) (Math.random() * (2-1))+1;
                        if(rand<2 && rand>0)
                        {
                            PieceThatMakesMove=p;
                            TheTile=tileStatus.getTile(legal[rand]);
                        }
                        break;
                    }
                }
            }
        }
        else
        {
            PieceThatMakesMove=obj.Piece();
            TheTile=obj.tile();
        }
    }
    public piece PieceThatMoves()
    {
        moveAndPiece();
        return PieceThatMakesMove;
    }
    public Tile LegalTile()
    {
        return TheTile;
    }
}
