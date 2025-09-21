package Resources.Components;


import java.awt.Graphics;
import java.awt.Point;

import Resources.Enums.ComponentType;
import Resources.Enums.PinID;
import java.util.ArrayList;

public abstract class Component implements Shadeable{
private Point org;
    private boolean draw = false;
    private boolean isSelected = false;
    private boolean mouseOnIt = false;
    private int width;
    private int height;
    private ComponentType componentType;
    private ArrayList<Pin> InPutsList = new ArrayList<>();
    private int inputPinCount;
    private int outputPin;
    //origen, 8, 8, ComponentType.None
    //BUILDERS
    //**************************************************************************
    public Component(){
        this.componentType = ComponentType.None;
    }
    
    public Component(Point org, ComponentType typeComponent)
    {
        this.org = org;
        this.componentType = typeComponent;
        
    }
    public Component(Point org,int width, int height, ComponentType typeComponent)
    {
        this.org = org;
        this.width = width;
        this.height = height;
        this.componentType = typeComponent;
        
    }
    public Component(Point org, int width, int height, ComponentType typeComponent, int inputPinCount, int outputPin)
    {
        this.org = org;
        this.width = width;
        this.height = height;
        this.componentType = typeComponent;
        this.inputPinCount = inputPinCount;
        this.addPins(inputPinCount, outputPin , typeComponent);
    }
    
    
    //ABSTRACT METHODS
    //**************************************************************************
    public abstract void draw(Graphics g);

    
    
    //NOT ABSTRACT METHODS
    //**************************************************************************
    
    //Common methods
    public boolean isIn(int x, int y)
    {
        return x >= getOrigen().x && x <= getOrigen().x + getWidth() && y <= getOrigen().y + getHeight() && y >= getOrigen().y;
    }
    
    public void addInPutPin(ComponentType typeComponent){
        //To add one Input Pin to the gate
        if(this.inputPinCount < 4){
            //It'll get here only if there are at most 3 InPuts
            PinID ID;
            switch(this.inputPinCount){
                case 1 -> ID = PinID.Input2; //If the count of InPut is 1, the it'll add a second one
                case 2 -> ID = PinID.Input3;
                case 3 -> ID = PinID.Input4;
                default -> ID = PinID.None;
            }
            this.setInputPinCount(inputPinCount + 1); //Change the actual count of InPut pins
            this.InPutsList.add(new Pin(true, ID , typeComponent)); //Add the new Input pin to the list
        }
    }

    public void addPins(int pinCount, int output ,ComponentType typeComponent){
        //To add n inPut pins to the gate
        if(pinCount <= 4){
            int i=0;
            PinID ID;
            for(; i < pinCount; i++){
                switch(i){
                    case 0 -> ID = PinID.Input1;
                    case 1 -> ID = PinID.Input2;
                    case 2 -> ID = PinID.Input3;
                    case 3 -> ID = PinID.Input4;
                    default -> ID = PinID.None;
                }
                this.InPutsList.add(new Pin(true, ID, typeComponent)); //Adding each InPut to the list
            }
           if (output != 0) this.InPutsList.add(new Pin(false, PinID.None, typeComponent));
        }
    }

     public Pin findPinByID(PinID ID){
        Pin found = null;
        for(Pin input : InPutsList){
            if(input.getID().equals(ID)){
                found = input;
                break;
            }
        }
        return found;
    }
    //Get and Set Methods
    public void setInputPinCount(int inputPinCount)
    {
        this.inputPinCount = inputPinCount;
    }
    public int getInputPinCount(){
        return this.inputPinCount;
    }
    public Pin getOutPutPin()
    {
       Pin output = findPinByID(PinID.None);
       return output;
    }
    
    public ArrayList<Pin> getPinsList(){
        return this.InPutsList;
    }
    
    public void setOrigen(Point newOrg){
        this.org = newOrg;
    }
    public Point getOrigen(){
        return this.org;
    }
    
    public void setDrawValue(boolean newValue){
        this.draw = newValue;
    }
    public boolean getDrawValue(){
        return this.draw;
    }
    
    public void setWidth(int newWidth){
        this.width = newWidth;
    }
    public int getWidth(){
        return this.width;
    }
    
    public void setHeight(int newHeight){
        this.height = newHeight;
    }
    public int getHeight(){
        return this.height;
    }
    
    public void setIsSelected(boolean value){
        this.isSelected = value;
    }
    public boolean getIsSelected(){
        return this.isSelected;
    }

    public ComponentType getTypeComponent() {
        return componentType;
    }

    public void setTypeComponent(ComponentType componentType) {
        this.componentType = componentType;
    }

    public void setMouseOnIt(boolean mouseOnIt) {
        this.mouseOnIt = mouseOnIt;
    }
    public boolean getMouseIsOnIt(){
        return this.mouseOnIt;
    }
}
