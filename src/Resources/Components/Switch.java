package Resources.Components;

import Resources.Enums.ComponentType;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;

public class Switch extends Component{
    private int value = 0;
        private int ovalSize;
        private boolean touched = false;
        
        //BUILDER
        //**********************************************************************
        public Switch(){
            super();
        }
        public Switch(Point org){
            super(org, ComponentType.Switch);
        }
        public Switch(Point org, int ovalSize){
            super(org, ComponentType.Switch);
            this.ovalSize = ovalSize;
        }

        //ABSTRACT METHODS
        //**********************************************************************
        @Override
        public void draw(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            Point org = this.getOrigen();
            //Smoothing edges
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            
            if(this.value == 1){
                //Filling switch with GREEN color
                g2d.setColor(Color.GREEN);
                g2d.fillArc(org.x, org.y, ovalSize, ovalSize, 270, -180);
                g2d.fillRect(org.x + ovalSize/2, org.y, ovalSize, ovalSize);
                g2d.setColor(Color.WHITE);
                g2d.fillOval(org.x + ovalSize, org.y, ovalSize, ovalSize);

                //Drawing switch borders
                g2d.setColor(Color.BLACK);
                g2d.drawOval(org.x + ovalSize, org.y, ovalSize, ovalSize);
                g2d.drawArc(org.x, org.y, ovalSize, ovalSize, 270, -180);
                g2d.drawLine(org.x + ovalSize/2, org.y, org.x + ovalSize + ovalSize/2, org.y);
                g2d.drawLine(org.x + ovalSize/2, org.y + ovalSize, org.x + ovalSize + ovalSize/2, org.y + ovalSize);
            } else if(this.value == 0){
                //Filling switch with GREEN color
                g2d.setColor(Color.RED);
                g2d.fillArc(org.x + ovalSize, org.y, ovalSize, ovalSize, -90, 180);
                g2d.fillRect(org.x + ovalSize/2, org.y, ovalSize+1, ovalSize);
                g2d.setColor(Color.WHITE);
                g2d.fillOval(org.x, org.y, ovalSize, ovalSize);
                
                //Drawing switch borders
                g2d.setColor(Color.BLACK);
                g2d.drawOval(org.x, org.y, ovalSize, ovalSize);
                g2d.drawArc(org.x + ovalSize, org.y, ovalSize, ovalSize, -90, 180);
                g2d.drawLine(org.x + ovalSize/2, org.y, org.x + ovalSize/2 + ovalSize, org.y);
                g2d.drawLine(org.x + ovalSize/2, org.y + ovalSize, org.x + ovalSize/2 + ovalSize, org.y + ovalSize);
            }
        }

        @Override
        public void applyShadow(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            Point org = getOrigen();
            g2d.setColor(new Color(0,0,0,50));
            g2d.drawArc(org.x-1, org.y-1, ovalSize+1, ovalSize+1, 270, -180);
            g2d.drawArc(org.x + ovalSize, org.y-1, ovalSize+1, ovalSize+1, -90, 180);
            g2d.drawLine(org.x + ovalSize/2, org.y-1, org.x + ovalSize/2 + ovalSize, org.y);
            g2d.drawLine(org.x + ovalSize/2, org.y + ovalSize +1, org.x + ovalSize/2 + ovalSize, org.y + ovalSize);
            
        }
        
        //NOT ABSTRACT METHODS
        //**********************************************************************
        
        //GET and SET methods
        public int getSwitchValue(){
            return this.value;
        }
        public void setSwtichValue(int newValue){
            this.value = newValue;
        }

    public void setOvalSize(int ovalSize) {
        this.ovalSize = ovalSize;
    }

    public int getOvalSize() {
        return ovalSize;
    }
    
        
}
