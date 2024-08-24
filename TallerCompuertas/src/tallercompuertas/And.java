/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tallercompuertas;

/**
 *
 * @author usuario
 */
public class And 
{
    private int []entradas;         
    private int salida;                
    
        public And(int entradas[]) //Constructor
    {
        this.entradas = entradas;
     }
        
        
    private void setSalida(int salida) //Metodo
    {
        this.salida = salida;
    }
    
    public int getSalida() //Metodo
    {
        comportamiento();
        return this.salida;
    }
    
    private void comportamiento() //Metodo
    {
        int prod = 1;
        for (int i = 0; i < entradas.length; i++) 
        {
            prod = prod * this.entradas[i];
        }
        setSalida(prod);
    }
}
