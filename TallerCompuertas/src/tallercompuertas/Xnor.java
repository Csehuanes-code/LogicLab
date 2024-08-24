/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tallercompuertas;

/**
 *
 * @author usuario
 */
public class Xnor 
{ 
    private int []entradas;
    private int salida;
    
    public Xnor(int []entradas) //Constructor
    {
        this.entradas = entradas;
        comportamiento();
    }
        
    public void setSalida(int salida) //Metodo
    {
        this.salida = salida;
    }
    
    public int getSalida() //Metodo
    {
        return this.salida;
    }
    
    private void comportamiento() //Metodo
    {
        int sum = 0;
        for (int i = 0; i < entradas.length; i++) 
        {
            sum = sum + entradas[i];
        }
        if (sum % 2 == 0) 
        {
            setSalida(1);
        } 
        else 
        {
            setSalida(0);
        }
    }
}
