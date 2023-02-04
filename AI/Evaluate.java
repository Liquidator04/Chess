package AI;

import Alliances.Tile;
import piece.piece;
import TileStatus.tileStatus;

public class Evaluate 
{
    private piece p;
    private Tile t;
    protected piece AIPieces[];
    protected piece OpposingPieces[];
    protected Evaluate(MakeAMove obj)
    {
        this.AIPieces=obj.AIPieces;
        this.OpposingPieces=obj.OpposingPieces;
    }
    protected boolean freePiece()
    {
        boolean a=false;
        outer:
        for(piece temp:AIPieces)
        {
            temp.setTileCoordinate();
            temp.setLegalTileCoordinates();
            for(piece OP:OpposingPieces)
            {
                if(OP.getCaptured()==false)
                {
                    for(int i:temp.getLegal())
                    {
                        if(i==OP.getTileCoordinate())
                        {
                            p=temp;
                            t=tileStatus.getTile(OP.getTileCoordinate());
                            a=true;
                            break outer;
                        }
                    }   
                }
            }
        }
        return a;
    }
    protected piece Piece()
    {
        return p;
    }
    protected Tile tile()
    {
        return t;
    }
}
