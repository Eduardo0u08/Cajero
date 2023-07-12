
package Cajero;



  public class Cajera {
    
    private String nombre;
    
    public Cajera() {
    }

    public Cajera(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void procesarCompra(Cliente cliente, long timeStamp) {
        System.out.println("La cajera " + this.nombre 
                + " comienza la compra del cliente " + cliente.getNombre()
                + " en el tiempo " + (System.currentTimeMillis() - timeStamp) / 1000
                + " segundos");
        
        // Procesamos los productos
        for (int i = 0; i < cliente.getCarroCompras().length; i++) {
            this.esperarXsegundos(cliente.getCarroCompras()[i]);
            System.out.println("Procesando producto " + (i + 1) 
                    + " -> Tiempo " + (System.currentTimeMillis() - timeStamp) / 1000
                    + " segundos");
        }
        
        // Finaliza el procesamiento de la cajera
        System.out.println("La cajera " + this.nombre + " ha terminado de "
                + "procesar la compra de " + cliente.getNombre() + " en el tiempo: "
                + (System.currentTimeMillis() - timeStamp) / 1000 + " segundos");
    }

    private void esperarXsegundos(int segundos) {
        try {
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException ex) {
            System.out.println("Mensaje: " + ex.getMessage());
            Thread.currentThread().interrupt();
        }
    }
}
  

