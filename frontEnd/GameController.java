
package frontEnd;

public class GameController 
{
    GameScreenWhite GW;
    GameScreenBlack GB;
    final public boolean update;
    private boolean End;
    int initialTileCoordinate,FinalTileCoordinate;
    boolean move;
    int moveNumber;
    GameController(GameScreenWhite GW,GameScreenBlack GB,boolean update)
    {
        this.GW=GW;
        this.GB=GB;
        this.update=update;  
        End=false;
        moveNumber=1;
    }
    protected void update()
    {
        
    }
    private void display()
    {
        if(this.update==false)
        {
            if(GW!=null)
            {
                GW.setController(this);
                GW.setVisible(true);
            }   
            else
            {
                GB.setController(this);
                GB.setVisible(true);
            }
        }
        else
        {
            while(End==false)
            {
                GW.setController(this);
                if(moveNumber!=1)
                {
                    GW.setGame(GB.BlackPieces,GB.WhitePieces,GB.wk,GB.bk,1);
                }
                GW.setVisible(true);
                while(GW.getMove()!=true)
                {
                    System.out.print("");
                }
                GW.Move=false;
                GW.setVisible(false);
                if(moveNumber==1)
                {
                    GB=new GameScreenBlack();
                }
                GB.setController(this);
                GB.setVisible(true);
                GB.setGame(GW.BlackPieces,GW.WhitePieces,GW.wk,GW.bk,-1);
                
                while(GB.getMove()!=true)
                {

                }
                move=false;
                GB.setVisible(false);
                moveNumber++;
            }
        }
    }
    protected void setEnd()
    {
        End=true;
    }
    public static void main(String args[])
    {
        new GameController(new GameScreenWhite(),null,false).display();
        System.out.println("Hello world");
    }
}
