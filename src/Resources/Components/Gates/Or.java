package Resources.Components.Gates;

import Resources.Components.Pin;
import Resources.Enums.GateType;
import Resources.Enums.PinID;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.geom.Path2D;

public class Or extends Gate{

    //BUILDERS
    //**************************************************************************
    public Or(Point org){
        super(org, GateType.Or);
    }
    public Or(Point org, int width, int height, int pinCount){
        super(org, width, height, pinCount, GateType.Or);
    }

    //ABSTRACT METHODS
    //**************************************************************************
    @Override
    public void evaluateInputs() {
       int sum = 0;
        int dato;
        for (int i = 0; i < getInputPinCount(); i++){
            dato = this.getPinsList().get(i).getPinValue();
            if(dato==1){
                getOutPutPin().setPinValue(1);
                return;
            }
            sum += dato;
        }
        if (sum >= 1) getOutPutPin().setPinValue(1);
        else getOutPutPin().setPinValue(0);
    }

    @Override
    public void draw(Graphics g) {
        int faltante = 0;
        int pinRadius = this.getPinsList().getFirst().getPinSize()/2;
        Point org = getOrigen();
        int width = getWidth();
        int height = getHeight();
        int inPutPinCount = getInputPinCount();
        int spaceToCut = ((height + width)/2) / inPutPinCount+1;
        int heightStart = spaceToCut /inPutPinCount;
        
        Graphics2D g2d = (Graphics2D) g;

        // Suavizado de bordes
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if(getMouseIsOnIt())applyShadow(g);
        
        // Dibujar fondo de la compuerta OR
        g2d.setColor(Color.LIGHT_GRAY);  // Fondo
        Path2D path = new Path2D.Double();
        path.moveTo(org.x, org.y + height);
        path.curveTo(org.x + width / 2, org.y + height, org.x + width / 2, org.y, org.x, org.y);  // Curva izquierda
        path.curveTo(org.x + width, org.y, org.x + width, org.y + height, org.x, org.y + height);  // Curva derecha
        g2d.fill(path);  // Rellenar compuerta OR


        // Dibujar contorno de la compuerta OR
        g2d.setColor(Color.BLACK);  // Color del borde
        g2d.draw(path);
        

        // Entradas
        for (Pin x: getPinsList()){
            switch (inPutPinCount) {
                case 2:
                    faltante = width / 16 + inPutPinCount;
                    break;
                case 3:
                    if(x.getID().compareTo(PinID.Input1) == 0 || x.getID().compareTo(PinID.Input3) == 0){
                        faltante = width / 16 - inPutPinCount;
                    }
                    else faltante = width / 8;
                    break;
                case 4:
                    if(x.getID().compareTo(PinID.Input1) == 0 || x.getID().compareTo(PinID.Input4) == 0){
                        faltante = 0;
                        if(x.getID().compareTo(PinID.Input1) == 0) faltante = - inPutPinCount;
                    }
                    else faltante = width /16 + inPutPinCount - width/32;
                    break;
            }
            if(x.getPinType()){
            g2d.setColor(Color.BLACK);
            //g2d.drawLine(org.x, org.y + heightStart, org.x + width / 2, org.y + heightStart);
            g2d.drawLine(org.x - (width / 4), org.y + heightStart, org.x + (width / 4) + faltante, org.y + heightStart);
            x.setOrigen(new Point(org.x - pinRadius - width/4, org.y + heightStart - pinRadius));
            x.draw(g);
            heightStart += spaceToCut;
            //faltante += width / 16 + getInputPinCount();
            }
        }

        // Salida
        g2d.setColor(Color.BLACK);
        g2d.drawLine(org.x + width - width/4, org.y + height/2, org.x + width + width/4, org.y + height/2);
        getOutPutPin().setOrigen(new Point(org.x + width + width / 4, org.y + (height / 2) - pinRadius));
        getOutPutPin().draw(g);
    }

    @Override
    public void applyShadow(Graphics g) {
        
        Point org = getOrigen();
        int width = getWidth();
        int height = getHeight();
        Graphics2D g2d = (Graphics2D) g;
        Path2D path = new Path2D.Double();
        path.moveTo(org.x, org.y + height);
        path.curveTo(org.x + width / 2 -1, org.y + height -1, org.x + width / 2 -1, org.y +1, org.x-1, org.y-1);  // Curva izquierda
        path.curveTo(org.x + width +1, org.y +1, org.x + width +1, org.y + height -1, org.x-1, org.y + height+1);  // Curva derecha
        

        g2d.setColor(new Color(0,0,0,50));
        g2d.draw(path);
        
        path = new Path2D.Double();
        path.moveTo(org.x , org.y + height );
        path.curveTo(org.x + width / 2 -2, org.y + height -2, org.x + width / 2 -2, org.y +2, org.x-2, org.y-2);  // Curva izquierda
        path.curveTo(org.x + width +2, org.y +2, org.x + width +2, org.y + height -2, org.x-2, org.y + height+2);  // Curva derecha
        g2d.draw(path);
    }
    
}
