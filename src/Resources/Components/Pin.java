package Resources.Components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import Resources.Enums.PinID;
import Resources.Enums.ComponentType;
import java.awt.RenderingHints;

public class Pin extends Component{
    private int pinSize = 5;
    private int pinValue;
    private boolean pinType; // False for OutPut Pin  || True for InPut Pin
    private boolean isConected = false;
    private PinID ID;
    private ComponentType belongsTo;

    //BUILDERS
    //***************************************************************
    public Pin(boolean pinType, PinID ID, ComponentType belongsTo)
    {
        super();
        if(belongsTo.compareTo(ComponentType.Variable) == 0){
            this.setWidth(2);
            this.setHeight(200);
        }
        else{
            this.setHeight(pinSize);
            this.setWidth(pinSize);
        }
        this.pinType = pinType;
        this.ID = ID;
        this.belongsTo = belongsTo;
    }
    public Pin(Point origen, boolean pinType, PinID ID, ComponentType belongsTo)
    {
        super(origen, 5, 5, ComponentType.None); // 8 is the Pin's size
        //Ask if the Pin was called by a Variable
        if(belongsTo.compareTo(ComponentType.Variable) == 0){
            //Change Pin's dimension because the drawing is different
            //so the isIn() function will do as well
            this.setWidth(2);
            this.setHeight(200);
        }
        this.pinType = pinType;
        this.ID = ID;
        this.belongsTo = belongsTo;
    }
    
    //ABSTRACT METHODS
    //****************************************************************
    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Point org = this.getOrigen();
        //Smoothing edges
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if(this.getMouseIsOnIt()){
            applyShadow(g);
        }
        if(pinType == false){
            // drawing is different for Variables
            if(belongsTo.compareTo(ComponentType.Variable) == 0){
                int height = this.getHeight();
                if(pinValue == 1) g2d.setColor(Color.GREEN);
                else g2d.setColor(Color.LIGHT_GRAY);
                g2d.drawLine(org.x, org.y, org.x, org.y + height);
                g2d.drawLine(org.x-1, org.y, org.x-1, org.y + height);
                g2d.drawLine(org.x+1, org.y, org.x +1, org.y + height);
            }
            else{
                //Defining fill color
                //GREEN when the pin is been use, else would be LIGH_GRAY
                if(isConected) g2d.setColor(Color.GREEN);
                else g2d.setColor(Color.LIGHT_GRAY);
                g2d.fillOval(org.x, org.y, pinSize, pinSize);
                
                //OutPut's edge
                g2d.setColor(Color.RED);
                g2d.drawOval(org.x, org.y, pinSize, pinSize);
            }
        } else{
            //Defining fill color
            //GREEN when the pin is been use, else would be LIGH_GRAY
            if(isConected) g2d.setColor(Color.GREEN);
            else g2d.setColor(Color.LIGHT_GRAY);
            g2d.fillOval(org.x, org.y, pinSize, pinSize);
            
            //InPut's border
            g2d.setColor(Color.BLUE);
            g2d.drawOval(org.x, org.y, pinSize, pinSize);
        }
    }
    @Override
    public void applyShadow(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Point org = getOrigen();
        g2d.setColor(new Color(0, 0, 0, 50));
        if(belongsTo.compareTo(ComponentType.Variable) == 0){
            int height = this.getHeight();
            if(pinValue == 1) g2d.setColor(Color.GREEN);
            else g2d.setColor(Color.LIGHT_GRAY);
            g2d.drawLine(org.x-2, org.y, org.x-2, org.y + height);
            g2d.drawLine(org.x+2, org.y, org.x +2, org.y + height);
        }
        else{
            g2d.drawOval(org.x-1, org.y-1, pinSize +2, pinSize +2);
            g2d.drawOval(org.x-2, org.y-2, pinSize +4, pinSize +4);
        }
    }
    

    //NOT ABSTRACT METHODS
    //**************************************************************************
    //Special methods
    public Pin getByID(PinID ID){
        if(this.ID == ID){
            return this;
        }
        return null;
    }
    
    public void setIsConected(boolean isConected)
    {
        this.isConected=isConected;
    }
    public boolean getIsConected() {
        return this.isConected;
    }
    
    //Get and Set Methods
    public int getPinValue(){
        return this.pinValue;
    }
    public void setPinValue(int newPinValue){
        this.pinValue = newPinValue;
    }

    public boolean getPinType(){
        return this.pinType;
    }
    
    public int getPinSize(){
        return this.pinSize;
    }

    public PinID getID() {
        return ID;
    }

    public ComponentType getBelongsTo() {
        return belongsTo;
    }
}
