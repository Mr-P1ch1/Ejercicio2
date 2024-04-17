public class Paquete {
    private String nombre;
    private String contenido;
    private String numero;


    public Paquete(String nombre, String contenido, String numero) {
        this.nombre = nombre;
        this.contenido = contenido;
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Nombre= " + nombre +
                "\n Contenido= " + contenido+
                "\n Numero= " + numero;
    }
}
