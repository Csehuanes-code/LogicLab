package Resources.Components.Gates;

import Resources.Enums.GateType;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.RenderingHints;

public class Not extends Gate{

    //BUILDERS
    //**************************************************************************
    public Not(Point org){
        super(org, 40, 40, 1, GateType.Not);
    }
    public Not(Point org, int withd, int height){
        super(org, withd, height, 1, GateType.Not);
    }
    
    
    //ABSTRACT METHODS
    //**************************************************************************
    @Override
    public void evaluateInputs() {
        int entrada = this.getPinsList().get(0).getPinValue();
        if (entrada == 0) getOutPutPin().setPinValue(1);
        else if(entrada == 1) getOutPutPin().setPinValue(0);
    }

    @Override
    public void draw(Graphics g) {
        int width = getWidth();
        int height = getHeight();
        int invertorSize = height/6;
        Point org = getOrigen();
        if(invertorSize > 16) invertorSize = 16;
        Graphics2D g2d =(Graphics2D) g;
        Resources.Components.Pin inPutPin = this.getPinsList().get(0);
        int pinRadius = inPutPin.getPinSize()/2;

        // Smothing edges
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if(getMouseIsOnIt()) applyShadow(g);
        // Triangle background
        g2d.setColor(Color.LIGHT_GRAY);  // Background color
        Polygon triangle = new Polygon();
        triangle.addPoint(org.x, org.y);
        triangle.addPoint(org.x, org.y + height);
        triangle.addPoint(org.x + width, org.y + height / 2);
        g2d.fillPolygon(triangle);  // Filling the triangle

        // Gate edges
        g2d.setColor(Color.BLACK);  // Edge Color
        g2d.drawPolygon(triangle);

        // InPut
        g2d.drawLine(org.x - width / 2, org.y + height / 2, org.x, org.y + height / 2);
        inPutPin.setOrigen(new Point(org.x - width / 2 - pinRadius, org.y + (height / 2)-pinRadius));
        inPutPin.draw(g);

        // Inversor
        g2d.setColor(Color.GREEN);  // Color del inversor (círculo)
        g2d.drawOval(org.x + width, org.y + (height / 2) - invertorSize / 2, invertorSize, invertorSize);

        // OutPut
        g2d.setColor(Color.BLACK);
        g2d.drawLine(org.x + width + invertorSize, org.y + (height / 2), org.x + width + width/2 + invertorSize, org.y + height/2);
        getOutPutPin().setOrigen(new Point(org.x + width + width/2 + invertorSize + pinRadius, org.y + (height / 2)-pinRadius));
        getOutPutPin().draw(g);
    }

    @Override
    public void applyShadow(Graphics g) {
        int width = getWidth();
        int height = getHeight();
        Point org = getOrigen();
        Graphics2D g2d =(Graphics2D) g;
        g2d.setColor(new Color(0,0,0,50)); 
        Polygon triangle = new Polygon();
        triangle.addPoint(org.x-1, org.y-1);
        triangle.addPoint(org.x-1, org.y + height+1);
        triangle.addPoint(org.x + width +1, org.y + height / 2);
        g2d.drawPolygon(triangle); 
        triangle = new Polygon();
        triangle.addPoint(org.x-2, org.y-2);
        triangle.addPoint(org.x-2, org.y + height+2);
        triangle.addPoint(org.x + width +2, org.y + height / 2);
        g2d.drawPolygon(triangle); 
    }
}
