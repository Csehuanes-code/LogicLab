package Resources.Components;

import Resources.Enums.ComponentType;
import Resources.Enums.PinID;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;

public class Led extends Component{
    //private Pin inPut = new Pin(true, PinID.Input1, ComponentType.LED);
    private Color color;
    
    //BUILDERS
    //****************************************************************
    public Led(){
        super();
    }
    public Led(Point org){
        super(org, 30, 30,ComponentType.LED, 1, 0 );
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();
        Point org = this.getOrigen();
        //Smoothing edges
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        if(getMouseIsOnIt()){
            applyShadow(g);
        }
        int value = getPinsList().getFirst().getPinValue();
        if(value == 1){
            //Turned on drawing
            g2d.setColor(color.RED);
            g2d.fillArc(org.x, org.y, width, height, 0, 180);
            g2d.fillRect(org.x, org.y + height/2, width, height/4);
            
//            g2d.setColor(Color.BLACK);
//            g2d.drawRect(org.x, org.y, width, height/4);
//            g2d.drawLine(org.x, org.y, org.x, org.y - height/4);
//            g2d.drawLine(org.x + width, org.y, org.x + width, org.y - height/4);
//            g2d.drawArc(org.x, org.y - height/2 - height/4, width, height, 0, 180);
//            g2d.drawLine(org.x + width/3, org.y +height/4, org.x + width/3, org.y + height/4 + height/2);
//            g2d.drawLine(org.x + 2*(width/3), org.y + height/4, org.x + 2*(width/3), org.y + height/4 + height/3);
//            this.getPinsList().getFirst().setOrigen(new Point((org.x + width/3) - this.getPinsList().getFirst().getPinSize()/2, (org.y + height/4 + height/2)));
//            this.getPinsList().getFirst().draw(g);
        }
        g2d.setColor(color.BLACK);
        g2d.drawArc(org.x, org.y, width, height, 0, 180);
        g2d.drawLine(org.x, org.y + height/2, org.x, org.y + height/2 + height/4);
        g2d.drawLine(org.x + width, org.y + height/2, org.x + width, org.y + height/2 + height/4);
        g2d.drawRect(org.x, org.y + height/2 + height/4, width, height/4);
        g2d.drawLine(org.x + width/3, org.y + height, org.x + width/3, org.y + height+ height/2);
        g2d.drawLine(org.x + 2*(width/3), org.y + height, org.x + 2*(width/3), org.y + height + height/4 + height/8);
        Pin input = getPinsList().getFirst();
        input.setOrigen(new Point(org.x + width/3 - input.getPinSize()/2, org.y + height + height/2));
        input.draw(g);
        
        
        
        //Default drawing
//        g2d.setColor(Color.BLACK);
//        g2d.drawRect(org.x, org.y, width, height/4);
//        g2d.drawLine(org.x, org.y, org.x, org.y - height/4);
//        g2d.drawLine(org.x + width, org.y, org.x + width, org.y - height/4);
//        g2d.drawArc(org.x, org.y - height/2 - height/4, width, height, 0, 180);
//        g2d.drawLine(org.x + width/3, org.y +height/4, org.x + width/3, org.y + height/4 + height/2);
//        g2d.drawLine(org.x + 2*(width/3), org.y + height/4, org.x + 2*(width/3), org.y + height/4 + height/3);
//        this.getPinsList().getFirst().setOrigen(new Point((org.x + width/3) - this.getPinsList().getFirst().getPinSize()/2, (org.y + height/4 + height/2)));
//        this.getPinsList().getFirst().draw(g);
        
        
        
    }

    @Override
    public void applyShadow(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();
        Point org = this.getOrigen();
        
        g2d.setColor(new Color(0, 0, 0, 50));
        g2d.drawArc(org.x -1, org.y, width+1, height+1, 0, 180);
        g2d.drawLine(org.x-1, org.y + height/2, org.x-1, org.y + height); //lateral izq
        g2d.drawLine(org.x + width +1, org.y + height/2, org.x + width +1, org.y + height); // lateral der
        g2d.drawLine(org.x, org.y + height, org.x + width, org.y + height); // base
        
        g2d.drawArc(org.x -2, org.y, width +2, height +2, 0, 180);
        g2d.drawLine(org.x-2, org.y + height/2, org.x-2, org.y + height);
        g2d.drawLine(org.x + width, org.y + height/2, org.x + width, org.y + height);
        g2d.drawLine(org.x, org.y + height +1, org.x + width, org.y + height +1); 
        
        
//        g2d.drawLine(org.x, org.y + height/4 +1, org.x + width, org.y + height/4 +1); // base
//        g2d.drawLine(org.x-1, org.y + height/4, org.x-1, org.y - height/4); //Lateral izq
//        g2d.drawLine(org.x + width+1, org.y + height/4, org.x + width+1, org.y - height/4); // lateral derecho
//        g2d.drawArc(org.x-1, org.y - height/2 - height/4, width+2, height+2, 0, 180);
//        
//        g2d.drawLine(org.x, org.y + height/4 +2, org.x + width, org.y + height/4 +2);
//        g2d.drawLine(org.x-2, org.y + height/4, org.x-2, org.y - height/4);
//        g2d.drawLine(org.x + width+2, org.y + height/4, org.x + width+2, org.y - height/4);
//        g2d.drawArc(org.x-2, org.y - height/2 - height/4, width+4, height+4, 0, 180);
    }
    
    public void setPinXvalue(int value){
        this.getPinsList().getFirst().setPinValue(value);
    }

    public Pin getInPut() {
        return this.getPinsList().getFirst();
    }
    
    
}
