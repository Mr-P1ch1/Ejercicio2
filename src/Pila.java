import java.util.Stack;

public class Pila {


        private Stack<Paquete> almacenamiento;

        public Pila() {
            almacenamiento = new Stack<Paquete>();

        }


        public boolean estaVaacia(){
            return almacenamiento.empty();
        }//metodo para verificar si esta vacio, retorna verdadero o falso

        public void apilar(String nombre, String contenido, String numero){
            Paquete paquete = new Paquete(nombre, contenido, numero);
            almacenamiento.push(paquete);
        }

        public Paquete desapilar() throws Exception {
            if (estaVaacia())
                throw new Exception("No hay elementos");
            return almacenamiento.pop();
            //POP PARA SACAR ELEMENTOS
        }
        public String sacar(){
            String binario = "";
            do {
                binario += almacenamiento.pop();
            }while (estaVaacia()==false);
            return binario;
        }

        public Paquete cima() throws Exception{
            if (estaVaacia())
                throw new Exception("No hay elementos");
            return almacenamiento.peek();
        }

        public int buscarElemento(String i) throws Exception{
            if (estaVaacia())
                throw new Exception("No hay elementos");
            for (int j=almacenamiento.size()-1; j<= 0; j--){
                if (almacenamiento.get(j).getNumero().equals(i)) {
                    return j;
                }

            }
            throw new  Exception("No hay el elemento ");
}

    public int getTamano(){
            return almacenamiento.size();
    }
        @Override
        public String toString(){
            String mensaje = "";
            for (int i = almacenamiento.size()-1; i>= 0; i--){
                mensaje += almacenamiento.get(i)+ "\n";
            }
            return mensaje;
        }

    public Paquete obtenerPosicionEnPila(String elementoBuscado) {
        Stack<Paquete> pilaAuxiliar = new Stack<>();
        int posicion = 0;
        Paquete elementoActual = null;

        while (estaVaacia()) {
            elementoActual = almacenamiento.pop();
            pilaAuxiliar.push(elementoActual);
            posicion++;

            if (elementoActual.getNumero().equals(elementoBuscado)){
                break;
            }

        }
        // Restaurar la pila original
        while (!pilaAuxiliar.isEmpty()) {
            almacenamiento.push(pilaAuxiliar.pop());
        }

        return elementoActual;
    }



    }

