package Resources.Components.Gates;

import java.awt.Point;
import java.util.ArrayList;

import Resources.Components.Component;
import Resources.Enums.PinID;
import Resources.Enums.ComponentType;
import Resources.Components.Pin;
import Resources.Enums.GateType;

public abstract class Gate extends Component{
  //  private int inputPinCount;
   // private Pin outPut = new Pin(false, PinID.None, ComponentType.Gate); // False for OutPut Pin
   // private ArrayList<Pin> InPutsList = new ArrayList<>();
    private GateType gateType;
    
    //BUILDERS
    //**************************************************************************
    public Gate(GateType type) {
        super();
        this.gateType = type;
    }
    public Gate( Point org, int width, int height, int inputPinCount, GateType gateType){
        //Customized BUILDER
        super(org, width, height, ComponentType.Gate,inputPinCount,1);
        this.gateType = gateType;
        //this.inputPinCount = inputPinCount;
        //this.type = type;
        //this.addInPutPins(inputPinCount);
    }
    public Gate(Point org, GateType gateType){
        //AND and OR BUILDER
        super(org, 40, 40,ComponentType.Gate,2,1);
        this.gateType = gateType;
     //   this.inputPinCount = 2;
     //   this.type = type;
      //  this.addInPutPins(inputPinCount);
    }
    
    
    //ABSTRACT METHODS
    //**************************************************************************
    public abstract void evaluateInputs();
    
    
    //NOT ABSTRACT METHODS
    //**************************************************************************
    //Get and Set methods
    public GateType getGateType(){
        return this.gateType;
    }
  /*  public Pin getOutPutPin(){
        return this.outPut;
    }
    
    public void setInputPinCount(int inputPinCount){
        this.inputPinCount = inputPinCount;
    }
    public int getInputPinCount(){
        return this.inputPinCount;
    }

    public ArrayList<Pin> getInPutsList(){
        return this.InPutsList;
    }
    */
    
    
    //Special methods
  /*  public boolean isInPinOutPut(int x, int y){
        return outPut.isIn(x, y);
    }

    public void addInPutPin(){
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
            this.InPutsList.add(new Pin(true, ID, ComponentType.Gate)); //Add the new Input pin to the list
        }
    }

    public void addInPutPins(int pinCount){
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
                this.InPutsList.add(new Pin(true, ID, ComponentType.Gate)); //Adding each InPut to the list
            }
        }
    }
    */
   /* public Pin findPinByID(PinID ID){
        Pin found = null;
        for(Pin input : InPutsList){
            if(input.getID().equals(ID)){
                found = input;
                break;
            }
        }
        return found;
    }*/
}
