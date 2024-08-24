/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tallercompuertas;

/**
 *
 * @author usuario
 */
public class Nand 
{
    private int []entradas;         
    private int salida;   
    
    public Nand (int entradas[]) //Constructor
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
        int prod = 1;
        for (int i = 0; i < entradas.length; i++) 
        {
            prod = prod * this.entradas[i];
        }
        if (prod == 0) 
        {
            setSalida(1);
        } 
        else if(prod == 1)
        {
            setSalida(0);
        }
    }
    

}
