package TileStatus;

import Alliances.*;


public class tileStatus 
{
    public static Tile getTile(int tileCoordinate)
    {
        Tile[] t=Tile.values();
        
        return t[tileCoordinate];
    }
    public static int getTileCoordinate(Tile tile)
    {
        Tile[] t=Tile.values();
        int i;
        for(i=0;i<64;i++)
        {
            if(t[i]==tile)
            {
                break;
            }
        }
        return i;
    }
    //Checks whether tC2 is above tC1
    public static boolean top(int tileCoordinate1,int tileCoordinate2)
    {
        boolean a=false;
        Tile tile1=getTile(tileCoordinate1),tile2=getTile(tileCoordinate2);
        if(tile1.toString().charAt(1)<tile2.toString().charAt(1))
        {
            a=true;
        }
        return a;
    }
    public static boolean bottom(int tileCoordinate1,int tileCoordinate2)
    {
        boolean a=false;
        Tile tile1=getTile(tileCoordinate1),tile2=getTile(tileCoordinate2);
        if(tile1.toString().charAt(1)>tile2.toString().charAt(1))
        {
            a=true;
        }
        return a;
    }
    public static boolean left(int tileCoordinate1,int tileCoordinate2)
    {
        boolean a=false;
        Tile tile1=getTile(tileCoordinate1),tile2=getTile(tileCoordinate2);
        if(tile1.toString().charAt(0)>tile2.toString().charAt(0))
        {
            a=true;
        }
        return a;
    }
    public static boolean right(int tileCoordinate1,int tileCoordinate2)
    {
        boolean a=false;
        Tile tile1=getTile(tileCoordinate1),tile2=getTile(tileCoordinate2);
        if(tile1.toString().charAt(0)<tile2.toString().charAt(0))
        {
            a=true;
        }
        return a;
    }
}
