import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class VistaPaquete {
    private JPanel Almacenamiento;
    private JTextField textFieldNombre;
    private JTextField textFieldNumero;
    private JLabel Texto1;
    private JLabel TextoNumero;
    private JLabel TextoContenido;
    private JButton buttonGuardar;
    private JButton ButtonSacar;
    private JButton ButtonBuscar;
    private JButton verPilaButton;
    private JTextField textField1;
    private JComboBox comboBoxPila;
    private JComboBox comboBoxContenido;
    private JLabel LabelNombre;

    Pila[] pilas = {new Pila(), new Pila(), new Pila()};
    Pila pilaAuxiliar = new Pila();

    public VistaPaquete() {
        buttonGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = textFieldNombre.getText();
                String contenido = (String) comboBoxContenido.getSelectedItem();
                String numero = textFieldNumero.getText();
                int numPila = comboBoxPila.getSelectedIndex();

                if (pilas[numPila].getTamano() < 6) {
                    pilas[numPila].apilar(new Paquete(nombre, contenido, numero));
                    JOptionPane.showMessageDialog(null, "Caja guardada en la Pila " + (numPila + 1));
                } else {
                    JOptionPane.showMessageDialog(null, "No hay espacio en la Pila " + (numPila + 1));
                }
            }
        });

        ButtonSacar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigo = textFieldNumero.getText();
                int numPila = comboBoxPila.getSelectedIndex();
                boolean cajaEncontrada = false;

                Stack<Paquete> pilaTemporal = new Stack<>();
                while (!pilas[numPila].estaVaacia() && !cajaEncontrada) {
                    Paquete paquete = pilas[numPila].desapilar();
                    if (paquete.getNumero().equals(codigo)) {
                        cajaEncontrada = true;
                        JOptionPane.showMessageDialog(null, "Caja retirada: " + paquete);
                    } else {
                        pilaTemporal.push(paquete);
                    }
                }

                // Reapilamos los paquetes que se desapilaron
                while (!pilaTemporal.isEmpty()) {
                    pilas[numPila].apilar(pilaTemporal.pop());
                }

                if (!cajaEncontrada) {
                    JOptionPane.showMessageDialog(null, "Caja no encontrada en la Pila " + (numPila + 1));
                }
            }
        });

        ButtonBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigo = textFieldNumero.getText();
                boolean encontrado = false;
                for (int i = 0; i < pilas.length; i++) {
                    int posicion = pilas[i].buscarElemento(codigo);
                    if (posicion != -1) {
                        JOptionPane.showMessageDialog(null, "Caja encontrada en la Pila " + (i + 1) + ", Posición " + (posicion + 1));
                        encontrado = true;
                        break;
                    }
                }
                if (!encontrado) {
                    JOptionPane.showMessageDialog(null, "Caja no encontrada en ninguna pila.");
                }
            }
        });

        verPilaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < pilas.length; i++) {
                    sb.append("Pila ").append(i + 1).append(":\n");
                    sb.append(pilas[i].toString()).append("\n");
                }
                JOptionPane.showMessageDialog(null, sb.toString());
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Gestión de Almacén");
        frame.setContentPane(new VistaPaquete().Almacenamiento);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
