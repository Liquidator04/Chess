/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piece;
import Alliances.Tile;
import javax.swing.JLabel;
import java.awt.Color;
/**
 *
 * @author admin
 */
public class tile {
    JLabel l;
    Tile t;
    int i;      //tile coordinate
    Color c;
    public tile(JLabel label,Tile tile)
    {
        l=label;
        t=tile;
        Tile[] tileEnums=Tile.values();
        for(int i=0;i<64;i++)
        {
            if(tileEnums[i].equals(t))
            {
                this.i=i;
                break;
            }
        }
        c=l.getBackground();
    }
    public void setBackground()
    {
        l.setBackground(c);
    }
    public JLabel getLabel()
    {
        return l;
    }
    public Tile getTile()
    {
        return t;
    }
    public int getTileCoordinate()
    {
        return i;
    }
    public int getX()
    {
        return l.getX();
    }
    public int getY()
    {
        return l.getY();
    }
    public Color getBackground()
    {
        return c;
    }
}
