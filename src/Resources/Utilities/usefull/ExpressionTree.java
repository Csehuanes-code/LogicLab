package Resources.Utilities.usefull;

import Resources.Enums.GateType;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ExpressionTree {
    public TreeNode root;

//    public ExpressionTree(String expression) {
//        this.root = parseExpression(expression);
//    }
    
    private int findMainOperator(String expression) {
        int parenCount = 0;
        int lastOperatorIndex = -1;

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '(') parenCount++;
            else if (ch == ')') parenCount--;

            // Solo consideramos operadores si no estamos dentro de paréntesis
            if (parenCount == 0 && isOperator(ch)) {
                lastOperatorIndex = i;
                if (ch == '+') break;  // `Or` tiene baja prioridad, preferible para raíz
            }
        }
        return lastOperatorIndex;
    }

    private boolean isOperator(char ch) {
        return ch == '+' || ch == '*' || ch == '~' || ch == '|' || ch == '!';
    }
    
//    private TreeNode parseLeaf(String expression) {
//        expression = expression.trim();
//
//        // Maneja el caso de negación de una variable, como `A'`
//        if (expression.length() > 1 && expression.endsWith("'")) {
//            String variableName = expression.substring(0, expression.length() - 1);
//            char ch = variableName.charAt(0);
//            TreeNode variableNode = new TreeNode(ch); // Asumimos valor 1 por defecto
//            TreeNode notNode = new TreeNode(GateType.Not);
//            notNode.children[0] = variableNode;
//            return notNode;
//        }
//        // Para el caso de una variable individual, como `A`
//        return new TreeNode(1, expression); // Asumimos que los valores se asignarán luego
//    }

    private String[] splitOperands(String expression, int operatorIndex) {
        String left = expression.substring(0, operatorIndex).trim();
        String right = expression.substring(operatorIndex + 1).trim();
        return new String[]{left, right};
    }
    
    private GateType getGateType(char operator) {
    return switch (operator) {
        case '+' -> GateType.Or;
        case '*' -> GateType.NAnd;
        case '~' -> GateType.NOr;
        case '|' -> GateType.XOr;
        case '!' -> GateType.XNOr;
        default -> GateType.And;
    };
}


    
    // Método de análisis sintáctico (parseo)
//    private TreeNode parseExpression(String expression) {
//        // Implementación del análisis para construir el árbol
//        expression = expression.trim();
//    
//        // Identificar el operador principal y dividir la expresión
//        int mainOperatorIndex = findMainOperator(expression);
//        if (mainOperatorIndex == -1) {
//            // Caso base: es una variable o una negación
//            return parseLeaf(expression);
//        }
//
//        // Crear nodo raíz con el operador principal
//        char operator = expression.charAt(mainOperatorIndex);
//        GateType gateType = getGateType(operator);
//        TreeNode root = new TreeNode(gateType);
//
//        // Dividir los operandos y construir el árbol recursivamente
//        String[] operands = splitOperands(expression, mainOperatorIndex);
//        for (int i = 0; i < operands.length; i++) {
//            root.children[i] = parseExpression(operands[i]);
//        }
//
//        return root;
//    }
    
    public void deleteExpressionTree(){
        this.root = null;
    }
    
//    public List<List<TreeNode>> bottomUpLevelOrderTraversal() {
//        List<List<TreeNode>> levels = new ArrayList<>();
//        if (root == null) return levels;
//
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//
//        while (!queue.isEmpty()) {
//            int levelSize = queue.size();
//            List<TreeNode> currentLevel = new ArrayList<>();
//
//            for (int i = 0; i < levelSize; i++) {
//                TreeNode currentNode = queue.poll();
//                currentLevel.add(currentNode);
//
//                // Agrega los hijos a la cola para el siguiente nivel
//                for (var child : currentNode.children) {
//                    if (child != null) queue.offer(child);
//                }
//            }
//
//            // Agrega el nivel al inicio de la lista para que queden en orden Bottom-Up
//            levels.add(0, currentLevel);
//        }
//
//        return levels;
//    }

    
}

