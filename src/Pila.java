import java.util.Stack;

public class Pila {

    private Stack<Paquete> almacenamiento;

    public Pila() {
        almacenamiento = new Stack<>();
    }

    public boolean estaVaacia() {
        return almacenamiento.isEmpty();
    }

    public void apilar(Paquete paquete) {
        if (paquete != null) {
            almacenamiento.push(paquete);
        } else {
            throw new IllegalArgumentException("El paquete no puede ser null.");
        }
    }

    public Paquete desapilar() {
        if (!estaVaacia()) {
            return almacenamiento.pop();
        } else {
            throw new IllegalStateException("No puedes desapilar de una pila vacía.");
        }
    }

    public int buscarElemento(String numeroPaquete) {
        for (int i = almacenamiento.size() - 1; i >= 0; i--) {
            if (almacenamiento.get(i).getNumero().equals(numeroPaquete)) {
                return i;
            }
        }
        return -1; // Si no se encuentra, devolvemos -1
    }

    public int getTamano() {
        return almacenamiento.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = almacenamiento.size() - 1; i >= 0; i--) {
            sb.append("Caja ").append(i + 1).append(": ").append(almacenamiento.get(i).toString()).append("\n");
        }
        return sb.toString();
    }
}
