/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tallercompuertas;


public class Not 
{
    private int entrada;
    private int salida;
    
    public Not (int entrada) //Constructor
    {
        this.entrada = entrada;
     } 
    
    
    private void setSaldia(int salida) //Metodo
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
        if (this.entrada == 0) 
        {
            setSaldia(1);
        } 
        else if(this.entrada == 1)
        {
            setSaldia(0);
        }
    }
    
}
