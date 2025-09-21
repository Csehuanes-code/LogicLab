package Resources.Utilities.usefull;
import Resources.Enums.GateType;

public class TreeNode {
    private GateType gateType; // Tipo de compuerta (And, Or, Not, etc.)
    private TreeNode[] children; // Máximo de 4 hijos
    private boolean isVariable;
    private char variableName; // Usado solo si es una variable
    private int level; // Nivel en el árbol para organizar el dibujo

    // Constructor para operaciones
    public TreeNode(GateType gateType, int numChildren) {
        this.gateType = gateType;
        this.children = new TreeNode[numChildren];
        this.isVariable = false;
    }

    // Constructor para variables
    public TreeNode(char variableName) {
        this.isVariable = true;
        this.variableName = variableName;
        this.children = new TreeNode[0]; // Las variables no tienen hijos
    }
    
    public boolean getIsVariable(){
        return isVariable;
    }

    public GateType getGateType() {
        return gateType;
    }
    
}

