/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piece;
import javax.swing.JLabel;
import frontEnd.*;
import Alliances.Tile;
import LegalMovesCheck.*;
import TileStatus.tileStatus;
import java.awt.Color;
/**
 *
 * @author admin
 */
public class piece {
    //data members
    boolean captured;
    final int points;
    static GameScreenWhite currentGame;
    static GameScreenBlack currentGame1;
    PromotionOfPawnWhite p;
    PromotionOfPawnBlack p1;
    JLabel label;
    String name;        //example: WhiteKnight1
    String color;       //example: White
    String type;        //example: Knight
    int tileCoordinate;
    boolean clicked=false;
    int[] legal;
    Tile[] legalTiles;
    boolean enPassant=false;
    static boolean black=false;
    boolean Moved=false;/*This is for determination of Whether King Castles
    This variable checks whether the rook or king has moved */
    //constructor
    
    public piece(JLabel l,GameScreenWhite game)
    {
        currentGame=game;
        label=l;
        name=label.getText();
        color=name.substring(0,5);
        type=name.substring(5,name.length()-1);
        tileCoordinate = tileStatus.getTileCoordinate(currentGame.PieceTile(label));
        switch(type)
        {
            case "Knight":
                points=3;
                break;
            case "Bishop":
                points=3;
                break;
            case "Rook":
                points=5;
                break;
            case "Queen":
                points=9;
                break;
            case "King":
                points=40;
                break;
            case "Pawnn":
                points=1;
                break;
            default:
                points=0;
        }
        black=false;
    }
    public piece(JLabel l,GameScreenBlack game)
    {
        currentGame1=game;
        label=l;
        name=label.getText();
        color=name.substring(0,5);
        type=name.substring(5,name.length()-1);
        tileCoordinate = tileStatus.getTileCoordinate(currentGame1.PieceTile(label));
        switch(type)
        {
            case "Knight":
                points=3;
                break;
            case "Bishop":
                points=3;
                break;
            case "Rook":
                points=5;
                break;
            case "Queen":
                points=9;
                break;
            case "King":
                points=40;
                break;
            case "Pawnn":
                points=1;
                break;
            default:
                points=0;
        }
        black=true;
    }
    //setter functions
    //sets game, to be used only once per game
    public static void setGame(GameScreenWhite game,GameScreenBlack game1)
    {
        if(black==false)
            currentGame=game;
        else
            currentGame1=game1;
    }
    public void setCaptured()
    {
        captured=true;
    }
    public void setTileCoordinate()
    {
        if(black==false)
            tileCoordinate=tileStatus.getTileCoordinate(currentGame.PieceTile(label));
        else
            tileCoordinate=tileStatus.getTileCoordinate(currentGame1.PieceTile(label));
    }
    public void setTileCoordinate(int i)
    {
        tileCoordinate=i;
    }
    public void setClicked(boolean b)
    {
        clicked=b;
    }
    //Possible inputs: "clicked", "mouse moved", ""
    public void setJLabel(String s)
    {
        String st=(color+" "+type+" "+s).trim().toLowerCase();
        if(black==false)
            label.setIcon(currentGame.to(st));
        else
            label.setIcon(currentGame1.to(st));
    }
    public void setEnPassant(boolean b) 
    {
        enPassant=b;
    }
    public void setLegalTileCoordinates()
    {
        if(black==false)
        {
            switch(type)
            {
                case "Pawn": legal=new Pawn(tileCoordinate,currentGame).legal();
                break;
                case "Knight": legal=new Knight(tileCoordinate,currentGame).legal();
                break;
                case "Bishop": legal=new Bishop(tileCoordinate,currentGame).legal();
                break;
                case "Rook": legal=new Rook(tileCoordinate,currentGame).legal();
                break;
                case "Queen": legal=new Queen(tileCoordinate,currentGame).legal();
                break;
                case "King":legal=new King(tileCoordinate,currentGame,this).legal();
                break;
            }
        }
        else
        {
            switch(type)
            {
                case "Pawn": legal=new Pawn(tileCoordinate,currentGame1).legal();
                break;
                case "Knight": legal=new Knight(tileCoordinate,currentGame1).legal();
                break;
                case "Bishop": legal=new Bishop(tileCoordinate,currentGame1).legal();
                break;
                case "Rook": legal=new Rook(tileCoordinate,currentGame1).legal();
                break;
                case "Queen": legal=new Queen(tileCoordinate,currentGame1).legal();
                break;
                case "King":legal=new King(tileCoordinate,currentGame1,this).legal();
                break;
            }
        }
    }
    public void setLegalTiles()
    {
        if(black==false)
        {
            setLegalTileCoordinates();
            legalTiles=new Tile[legal.length];
            for(int i=0;i<legal.length;i++)
            {
                if(legal[i]!=-1)
                {
                    if(currentGame.check(this, legal[i])==false)
                    {
                        legalTiles[i]=tileStatus.getTile(legal[i]);
                    }
                }
            }
        }
        else
        {
            setLegalTileCoordinates();
            legalTiles=new Tile[legal.length];
            for(int i=0;i<legal.length;i++)
            {
                if(legal[i]!=-1)
                {
                    if(currentGame1.check(this, legal[i])==false)
                    {
                        legalTiles[i]=tileStatus.getTile(legal[i]);
                    }
                }
            }
        }
    }  
    
    public void colorLegalTiles()
    {
        if(black==false)
        {
            for(int i=0;i<legal.length;i++)
            {
                if(legalTiles[i]!=null)
                    currentGame.getTileInJlabel(legalTiles[i]).setBackground(Color.GREEN);
            }
        }
        else
        {
            for(int i=0;i<legal.length;i++)
            {
                if(legalTiles[i]!=null)
                    currentGame1.getTileInJlabel(legalTiles[i]).setBackground(Color.GREEN);
            }
        }
    }
    //used by pawns to promote, possible inputs: "Knight", "Bishop", "Rook", "Queen"
    public void promote()
    {
        if(black==false)
        {
            if(currentGame.turnCheckerReturner()==1)
            {
                p=new PromotionOfPawnWhite(new javax.swing.JFrame(),true);
                p.setVisible(true);
                String choice;
                while(p.isAnythingSelected()!=true)
                {            

                }
                choice=p.Choice();
                p.setTypeToNull();
                type=choice;
                setJLabel("");
            }
            else
            {
                p1=new PromotionOfPawnBlack(new javax.swing.JFrame(),true);
                p1.setVisible(true);
                String choice;
                while(p1.isAnythingSelected()!=true)
                {            

                }
                choice=p1.Choice();
                p1.setTypeToNull();
                type=choice;
                setJLabel("");
            }
        }
        else
        {
            if(currentGame1.turnCheckerReturner()==1)
            {
                p=new PromotionOfPawnWhite(new javax.swing.JFrame(),true);
                p.setVisible(true);
                String choice;
                while(p.isAnythingSelected()!=true)
                {            

                }
                choice=p.Choice();
                p.setTypeToNull();
                type=choice;
                setJLabel("");
            }
            else
            {
                p1=new PromotionOfPawnBlack(new javax.swing.JFrame(),true);
                p1.setVisible(true);
                String choice;
                while(p1.isAnythingSelected()!=true)
                {            

                }
                choice=p1.Choice();
                p1.setTypeToNull();
                type=choice;
                setJLabel("");
            }
        }
    }
    public void moveForAI(JLabel t)
    {
        getJLabel().move(t.getX(), t.getY());
    }
    //getter functions
    public JLabel getJLabel()
    {
        return label;
    }
    //returns whether it is the turn of the current piece
    public boolean checkTurn()
    {
        boolean result=false;
        if(black==false)
        {
            int turn=currentGame.turnCheckerReturner();
            if((color.equals("White")&&turn==1)||(color.equals("Black")&&turn==-1))
            {
                result=true;
            }
        }
        else
        {
            int turn=currentGame1.turnCheckerReturner();
            if((color.equals("White")&&turn==1)||(color.equals("Black")&&turn==-1))
            {
                result=true;
            }
        }
        return result;
    }
    //returns whether this piece is clicked
    public boolean getClicked()
    {
        return clicked;
    }
    //returns all the string data members
    public void getStrings()
    {
        System.out.println("name: "+name);
        System.out.println("color: "+color);
        System.out.println("type: "+type);
    }
    //used for pawns, returns whether this piece can be captured by en Passant
    public boolean getEnPassant() 
    {
        return enPassant;
    }
    //returns type of piece example: "Pawn"
    public String getType() 
    {
        return type;
    }
    public int[] getLegal()
    {
        return legal;
    }
    public int getTileCoordinate()
    {
        return tileCoordinate;
    }
    public void setMoved()
    /*this function bassically sets rook or king moved.
    For Example,when king has moved then this function is called thus making the king moved*/
    {
        Moved=true;
    }
    public boolean getMoved()//Just a getter for the variable Moved
    {
        return Moved;
    }
    public GameScreenWhite currentGame()
    {
        return currentGame;
    }
    public Tile[] getLegalTile()
    {
        return legalTiles;
    }
    //moves this piece to given tileCoordinate
    public void move(int tileCoordinate)
    {
        if(black==false)
            move(currentGame.tileFromCoordinate(tileCoordinate));
        else
            move(currentGame1.tileFromCoordinate(tileCoordinate));
    }
    public void move(tile t)
    {
        /*
        if(currentGame.hasPieceOnTile(t))
            currentGame.PieceOnTile(t).remove();*/
        label.move(t.getX(),t.getY());
    }
    public String getColor()
    {
        return color;
    }
    public void remove()
    {
        label.move(6000,6000);
        tileCoordinate=100;
    }
    public int getX()
    {
        return label.getX();
    }
    public int getY()
    {
        return label.getY();
    }
    public boolean getCaptured()
    {
        return captured;
    }
}
