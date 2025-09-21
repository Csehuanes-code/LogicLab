package Resources.Components.Gates;

import Resources.Enums.GateType;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.geom.Arc2D;

public class And extends Gate{
    
    //BUILDERS
    //**************************************************************************
    public And(Point org){
        super(org, GateType.And);
    }
    public And(Point org, int width, int height, int pinCount){
        super(org, width, height, pinCount, GateType.And);
    }
    
    
    //ABSTRACT METHODS
    //**************************************************************************
    @Override
    public void evaluateInputs() {
        int prod = 1;
        int dato;
        for (int i = 0; i < this.getInputPinCount(); i++){
            dato = this.getPinsList().get(i).getPinValue();
            if(dato==0){
                this.getOutPutPin().setPinValue(0);
                return;
            }
            prod = prod * dato;
        }
        this.getOutPutPin().setPinValue(prod);
    }

    @Override
    public void draw(Graphics g) {
        int pinRadius = this.getOutPutPin().getPinSize()/2;
        Point org = this.getOrigen();
        int width = this.getWidth();
        int height = this.getHeight();
        int inPutPinCount = this.getInputPinCount();
        int spaceToCut = ((height + width)/2) / inPutPinCount+1;
        int heightStart = spaceToCut /inPutPinCount;
        
        Graphics2D g2d = (Graphics2D) g;
        // Smothing edges
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if(getMouseIsOnIt())applyShadow(g);
        
        // Gate background
        g2d.setColor(Color.LIGHT_GRAY);  // Background color
        g2d.fill(new Arc2D.Double(org.x, org.y, width, height, -90, 180, Arc2D.OPEN));

        // Gate edges
        g2d.setColor(Color.BLACK);  // Edge color
        g2d.draw(new Arc2D.Double(org.x, org.y, width, height, -90, 180, Arc2D.OPEN));
        
        // Recta central de la compuerta AND
        g2d.setColor(Color.BLACK);  // Color del borde de la recta
        g2d.drawLine(org.x + width / 2, org.y, org.x + width / 2, org.y + height);
        
        // InPuts
        for (Resources.Components.Pin x: getPinsList() ){
            if (x.getPinType()){
            g2d.drawLine(org.x, org.y + heightStart, org.x + width / 2, org.y + heightStart);
            x.setOrigen(new Point(org.x - pinRadius, org.y + heightStart - pinRadius));
            x.draw(g);
            heightStart += spaceToCut;
            g2d.setColor(Color.BLACK);
            }
        }
            
        // OutPut
        g2d.drawLine(org.x + width, org.y + height/2, org.x + width + width/2, org.y + height/2);
        this.getOutPutPin().setOrigen(new Point(org.x + width + width/2, org.y + (height / 2) - pinRadius));
        this.getOutPutPin().draw(g);
        
    }

    @Override
    public void applyShadow(Graphics g) {
        Point org = this.getOrigen();
        int width = this.getWidth();
        int height = this.getHeight();
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(0,0,0,50));  // Color del borde
        g2d.draw(new Arc2D.Double(org.x, org.y, width+1, height+1, -90, 180, Arc2D.OPEN));
        // Recta central de la compuerta AND
        g2d.drawLine(org.x + width / 2 -1, org.y, org.x + width / 2 -1, org.y + height);
        g2d.draw(new Arc2D.Double(org.x, org.y, width+2, height+2, -90, 180, Arc2D.OPEN));
        // Recta central de la compuerta AND
        g2d.drawLine(org.x + width / 2 -2, org.y, org.x + width / 2 -2, org.y + height);
    }
    
}
