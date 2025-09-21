package Resources.Components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Wire extends Component{
    private Pin start;
    private Pin end;
    
    //BUILDER
    //**************************************************************************
    public Wire(Pin start, Pin end)
    {
        this.start = start;
        this.end = end;
    }
    
    //ABSTRACT METHODS
    //**************************************************************************
    @Override
    public void draw(Graphics g) 
    {
     Point pos1 = start.getOrigen();
     pos1.x += start.getPinSize()/2;
     pos1.y += start.getPinSize()/2;
     Point pos2 = end.getOrigen();
     pos2.x += end.getPinSize()/2;
     pos2.y += end.getPinSize()/2;
     g.setColor(Color.black);
     
        if (pos1.x == pos2.x || pos1.y == pos2.y) {
            g.drawLine(pos1.x, pos1.y, pos2.x, pos2.y);
        }
        else{
            int midX = (pos1.x + pos2.x) / 2;
            g.drawLine(pos1.x, pos1.y, midX, pos1.y);
            g.drawLine(midX, pos1.y, midX, pos2.y);
            g.drawLine(midX, pos2.y, pos2.x, pos2.y);
        }
          
    }

    @Override
    public void applyShadow(Graphics g) {
        
    }
    
    @Override
    public boolean isIn(int x, int y) {
        Point startPoint = start.getOrigen();
        Point endPoint = end.getOrigen();
        if(startPoint.y == endPoint.y && startPoint.x < endPoint.x) {
            return (x >= startPoint.x && x <= endPoint.x && y >= startPoint.y -1 && y <= startPoint.y+1);
        }
        else if(startPoint.y == endPoint.y && startPoint.x > endPoint.x) {
            return (x >= endPoint.x && x <= startPoint.x && y >= startPoint.y -1 && y <= startPoint.y+1);
        }
        return false;
    }
    
    
    //NOT ABSTRACT METHODS
    //**************************************************************************
    //Common methods
    public void transferValue(){
        int outputValue = start.getPinValue();
        end.setPinValue(outputValue);
        start.setIsConected(true);
        end.setIsConected(true);
    }
    
    
    //GET and SET methods
    public Pin getOutput(){
        return start;
    }
    
    public Pin getInput(){
        return end;
    }
}
