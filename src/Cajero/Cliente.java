
package Cajero;


public class Cliente {
    
     private String nombre;
    private int[] carroCompras;
    
    public Cliente() {
    }

    public Cliente(String nombre, int[] carroCompras) {
        this.nombre = nombre;
        this.carroCompras = carroCompras;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int[] getCarroCompras() {
        return carroCompras;
    }

    public void setCarroCompras(int[] carroCompras) {
        this.carroCompras = carroCompras;
    }
}
