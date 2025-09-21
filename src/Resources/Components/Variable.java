package Resources.Components;

//Local libraries
import Resources.Enums.ComponentType;
import Resources.Enums.PinID;
import java.awt.Color;

//Java libraries
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;

/**
 *
 * @author ₰Andrés₰
 */
public class Variable extends Component{
    private char name;
    private Switch switcher = new Switch();
    //private Pin outPut = new Pin(false, PinID.None, ComponentType.Variable);
    
    //BUILDERs
    //**********************************************************************
    public Variable(Point org, int width, int height){
        super(org, width, height, ComponentType.Variable);
    }
    public Variable(Point org){
        super(org, 40, 30, ComponentType.Variable,0,1);
    }

    //ABSTRACT METHODS
    //**********************************************************************
    @Override
    public void draw(Graphics g) {
        Point org = this.getOrigen();
        Graphics2D g2d = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();
        //Smoothing edges
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if(getMouseIsOnIt()){
            applyShadow(g);
        }
        g2d.setColor(Color.BLACK);
        g2d.drawRect(org.x, org.y, this.getWidth(), this.getHeight());
        switcher.setOrigen(new  Point (org.x + width/3, org.y + height/3));
        switcher.setOvalSize(((width + height)/2)/4);
        switcher.setWidth((((width + height)/2)/4)*2 +1);
        switcher.setHeight(((width + height)/2)/4);
        switcher.draw(g);
        switcher.applyShadow(g);
        this.getOutPutPin().setOrigen(new Point(org.x + getWidth()/2, org.y + getHeight()));
        this.getOutPutPin().draw(g);
        this.getOutPutPin().applyShadow(g);
            
    }

    @Override
    public void applyShadow(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Point org = getOrigen();
        g2d.setColor(new Color(0,0,0,50));
        g2d.drawRect(org.x-1, org.y-1, this.getWidth()+2, this.getHeight()+2);
        g2d.drawRect(org.x-2, org.y-2, this.getWidth()+3, this.getHeight()+3);
        
    }
    
    //NOT ABSTRACT METHODS
    //**********************************************************************
        
    //GET and SET methods

    public Switch getSwitcher() {
        return switcher;
    }

    public Pin getOutPut() {
        Pin output = this.getOutPutPin();
        return output;
    }
    
}
