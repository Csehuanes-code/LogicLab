package Resources.Circuit;

import Resources.Components.*;
import Resources.Components.Gates.*;
import Resources.Enums.*;
import Resources.Utilities.usefull.ExpressionTree;
import Resources.Utilities.usefull.TreeNode;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Circuit {
    private String name;
    private boolean isSimulating = false;
    private  List<Component> componentList = new LinkedList<>();
    private ArrayList<Wire> wireList = new ArrayList<>();
    private Component selectedComponent = null;
    private Pin selectedPin = null;
    private Pin selectedOutPut = null;
    private Pin selectedInPut = null;
    private Variable selectedVariable = null;
    private Switch selectedSwitch = null;
    private Gate selectedGate = null;
    private ExpressionTree expressionTree;
    private int xStart;
    private int yStart;
    
    //BUILDERS
    //**************************************************************************
    public Circuit(String name){
        
    }
    public Circuit(){
        
    }
    
    //COMMON METHODS
    //**************************************************************************
    public void addComponent(Point org, Component component){
        this.componentList.add(component);
    }
    
    public void deleteComponent(MouseEvent evt) throws Exception{
        for(Component component : componentList) {
            if(component.isIn(evt.getX(), evt.getY())) {
                componentList.remove(component);
            }
        }
        for(Wire wire : wireList) {
            if(wire.isIn(evt.getX(), evt.getY())) {
                wireList.remove(wire);
            }
        }
    }
    
    public void cleanComponents(){
        this.componentList.clear();
        this.wireList.clear();
        selectedComponent = null;
        selectedGate = null;
        selectedVariable = null;
        selectedOutPut = null;
        selectedInPut = null;
    }
    
    public int getCircuitValue(){
        return 0;
    }
    
    public void switchVariable(MouseEvent evt) {
        if(selectedVariable == null) {
            for(Component element : componentList) {
                if(element.getTypeComponent().compareTo(ComponentType.Variable) == 0) {
                    selectedComponent = element;
                    selectedVariable = (Variable) selectedComponent;
                    selectedPin = selectedVariable.getOutPutPin();
                    selectedSwitch = selectedVariable.getSwitcher();
                    if(selectedSwitch.isIn(evt.getX(), evt.getY())) {
                        if(selectedSwitch.getSwitchValue() == 1) {
                            selectedSwitch.setSwtichValue(0);
                            selectedPin.setPinValue(0);
                        }
                        else if(selectedSwitch.getSwitchValue() == 0) {
                            selectedSwitch.setSwtichValue(1);
                            selectedPin.setPinValue(1);
                        }
                    }
                }
            }
        }
        else selectedVariable = null;
    }
    
    public void mouseNotOnComponent(MouseEvent evt){
        for(Component element : componentList){
            if(!element.isIn(evt.getX(), evt.getY()) && element.getDrawValue()){
                element.setMouseOnIt(false);
            }
            for (Pin pin : element.getPinsList()){
                if(!pin.isIn(evt.getX(), evt.getY()) && pin.getDrawValue()){
                    pin.setMouseOnIt(false);
                }
            }
        }
    }
    
    public void mouseOnComponent(MouseEvent evt){
        for(Component element : componentList){
            if(element.isIn(evt.getX(), evt.getY()) && element.getDrawValue()){
                element.setMouseOnIt(true);
            }
            for (Pin pin : element.getPinsList()){
                if(pin.isIn(evt.getX(), evt.getY()) && pin.getDrawValue()){
                    pin.setMouseOnIt(true);
                }
            }
        }
    }
    
    public void selectComponent(MouseEvent evt) {
        if(selectedComponent == null){
            for (Component element : componentList) {
                if(element.isIn(evt.getX(), evt.getY()) && element.getDrawValue()) {
                    element.setMouseOnIt(true);
                    element.setIsSelected(true);
                    selectedComponent = element;
                    xStart = evt.getX();
                    yStart = evt.getY();
                }
            }
        }
        else{
            selectedComponent.setMouseOnIt(false);
            selectedComponent.setIsSelected(false);
            selectedComponent = null;
        }
    }
    
    public void unSelectComponent(MouseEvent evt) {
        for(Component element : componentList){
            if(!element.isIn(evt.getX(), evt.getY()) && element.getDrawValue()) {
                element.setIsSelected(false);
                element.setMouseOnIt(false);
                selectedComponent = null;
            }
        }
    }
    
    public void dragComponent(MouseEvent evt, Rectangle limits) {
        int xFinal = evt.getPoint().x;
        int yFinal = evt.getPoint().y;

        int width = xFinal - xStart;
        int height = yFinal - yStart;

        xStart = xFinal;
        yStart = yFinal;
        Point org;
        int componentWidth;
        int componentHeight;
        if(selectedComponent != null) {
            org = selectedComponent.getOrigen();
            componentHeight = selectedComponent.getHeight();
            componentWidth = selectedComponent.getWidth();
            if(org.x >= 10 && org.y >= 10 && org.x + componentWidth <= limits.width - 15 &&
                    org.y + componentHeight <= limits.height - 15)
            {
                selectedComponent.setOrigen(new Point(org.x + width, org.y + height));
            }
            else{
                selectedComponent.setOrigen(new Point(limits.width/2, limits.height/2));
            }
        }
    }
    
    public boolean addConection(MouseEvent evt) {
        for (Component component : componentList) {
            for (Pin pin : component.getPinsList()) {
                if (pin.isIn(evt.getX(), evt.getY())) {
                    if (!pin.getPinType()) {
                        selectedOutPut = pin;
                        selectedOutPut.setPinValue(pin.getPinValue());
                    }
                    else if (selectedOutPut != null) {
                        selectedInPut = pin;
                        wireList.add(new Wire(selectedOutPut,selectedInPut));
                        wireList.getLast().setDrawValue(true);
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
//    public void booleanExpresionToDiagram(String booleanExpresion){
//        expressionTree = new ExpressionTree(booleanExpresion);
//    }
    
    
    
    public void editComponentProperties(){
        
    }
    
    
    public void simulateCircuit(){
        
        for(Wire wire : wireList){
            wire.transferValue();
        }
        
        
        for(Component component : componentList){
            for(Pin pin : component.getPinsList()){
                if(pin.getIsConected()){
                    pin.setPinValue(pin.getPinValue());
                }
            }
            if(component.getTypeComponent().compareTo(ComponentType.Gate) == 0){
                selectedGate = (Gate) component;
                selectedGate.evaluateInputs();
                selectedGate.getOutPutPin().setPinValue(selectedGate.getOutPutPin().getPinValue());
            }
            selectedGate = null;
        }
    }
    
    //GET and SET methods
    //**************************************************************************
    public List<Component> getComponentList() {
        return componentList;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Wire> getWireList() {
        return wireList;
    }
    
    public Component getSelectedComponent(){
        return this.selectedComponent;
    }
    
    
    
    //**************************************************************************
//    public void drawCircuitFromTree(Graphics g) {
//        List<List<TreeNode>> levels = expressionTree.bottomUpLevelOrderTraversal();
//        int panelWidth = 600;    // Ancho del panel (ajústalo según necesites)
//        int xStart = 50;         // Punto de inicio en x para el nivel más bajo
//        int xSpacing = 100;      // Espacio en x entre niveles
//        int panelHeight = 500;   // Altura del panel
//        int yMargin = 20;        // Margen superior e inferior en el panel
//
//        for (int level = 0; level < levels.size(); level++) {
//            List<TreeNode> currentLevel = levels.get(level);
//            int nodeCount = currentLevel.size();
//
//            // Calcula el espacio en y entre los nodos del mismo nivel
//            int ySpacing = (panelHeight - 2 * yMargin) / (nodeCount + 1);
//            int x = xStart + level * xSpacing;
//
//            for (int i = 0; i < nodeCount; i++) {
//                TreeNode node = currentLevel.get(i);
//                int y = yMargin + (i + 1) * ySpacing;
//
//                // Dibuja el nodo en la posición calculada
//                drawNode(g, node, x, y);
//            }
//        }
//    }
    
    private void drawNode(Graphics g, TreeNode node, int x, int y) {
        if (node.getIsVariable()) {
            Variable variable = new Variable(new Point(x, y));
            variable.draw(g);
        } else {
            Gate gate = createGateFromType(node.getGateType(), new Point(x, y));
            gate.draw(g);
        }
    }

    private Gate createGateFromType(GateType type, Point position) {
        switch (type) {
            case And -> {
                return new And(position);
            }
            case Or -> {
                return new Or(position);
            }
            case NAnd -> {
                return new NAnd(position);
            }
            case NOr -> {
                return new NOr(position);
            }
            case XOr -> {
                return new XOr(position);
            }
            case XNOr -> {
                return new XNOr(position);
            }
            case Not -> {
                return new Not(position);
            }
            default -> throw new IllegalArgumentException("Tipo de compuerta desconocido");
        }
    }
}
