
package tallercompuertas;


public class Or 
{
    private int []entradas;
    private int salida;
    
    public Or(int entradas[]) //Constructor
    {
        this.entradas = entradas;
    }
    
    private void setSalida(int salida) //Metodo
    {
        this.salida = salida;
    }
    
    public int getSalida() //Metodo
    {
        Comportamiento();
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
            setSalida(1);
        } 
        else 
        {
            setSalida(0);
        }
    }
    
}
