
package tallercompuertas;

/**
 *
 * @author usuario
 */
public class Nor 
{
    private int []entradas;
    private int salida;
            
    public Nor (int entradas[]) //Constructor
    {
        this.entradas = entradas;
        Comportamiento();
     }
    
    public void setSalida(int salida) //Metodo
    {
        this.salida = salida;
    }
    
    public int getSalida() //Metodo
    {
        return this.salida;
    }
    
    private void Comportamiento() //Metodo
    {
        int sum = 0;
        for (int i = 0; i < entradas.length; i++) 
        {
            sum = sum + this.entradas[i];
        }
        if (sum >= 1) 
        {
            setSalida(0);
        } 
        else
        {
            setSalida(1);
        }
    }
    
}
