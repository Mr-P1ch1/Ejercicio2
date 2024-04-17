import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

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

    Pila pila1= new Pila();
    Pila pila2 = new Pila();
    Pila pila3 = new Pila();
    Pila pilaAuxiliar = new Pila();

    public VistaPaquete() {

        buttonGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numPila = Objects.requireNonNull(comboBoxPila.getSelectedItem()).toString();
                int numPila2=Integer.parseInt(numPila);

                switch (numPila2){
                    case 1:
                        if (pila1.getTamano() < 6) {
                            pila1.apilar(textFieldNombre.getText(), comboBoxContenido.getSelectedItem().toString(), textFieldNumero.getText());
                            JOptionPane.showMessageDialog(null, "Ingresada con éxito");
                        } else {
                            JOptionPane.showMessageDialog(null, "La pila está llena");
                        }
                        break;
                    case 2:
                        if (pila2.getTamano() < 6) {
                            pila2.apilar(textFieldNombre.getText(), comboBoxContenido.getSelectedItem().toString(), textFieldNumero.getText());
                            JOptionPane.showMessageDialog(null, "Ingresada con éxito");
                        } else {
                            JOptionPane.showMessageDialog(null, "La pila está llena");
                        }
                        break;
                    case 3:
                        if (pila3.getTamano() < 6) {
                            pila3.apilar(textFieldNombre.getText(), comboBoxContenido.getSelectedItem().toString(), textFieldNumero.getText());
                            JOptionPane.showMessageDialog(null, "Ingresada con éxito");
                        } else {
                            JOptionPane.showMessageDialog(null, "La pila está llena");
                        }
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "La pila seleccionada no es válida");
                        break;

                }
            }
        });
        ButtonSacar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numPila = Objects.requireNonNull(textFieldNumero).toString();
                Paquete caja=null;
                for (int i= 1; i < 4; i++) {
                    switch (i) {
                        case 1:
                                try{
                                   Paquete encontrado = pila1.obtenerPosicionEnPila(numPila);
                                }
                               /* try {
                                    caja = pila1.desapilar();
                                }*/ catch (Exception ex) {
                                    throw new RuntimeException(ex);
                                }
                               /* if (caja.getNumero().equals(numPila)) {
                                    JOptionPane.showMessageDialog(null, "La caja esta en la pila 1, posicion" + caja);
                                } else {
                                    JOptionPane.showMessageDialog(null, "No se encontró el paquete");
                                }*/

                    }
                    }
            }

        });
    }

    /*public VistaPaquete() {
        buttonGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               try {
                   Object selectedItem = comboBoxPila.getSelectedItem();
                   if (selectedItem == null) {
                       JOptionPane.showMessageDialog(null, "Seleccione una pila");
                       return;
                   }
                    int pila = Integer.parseInt(comboBoxPila.getSelectedItem().toString());


                    /*if (pilaElegida == null) {
                        JOptionPane.showMessageDialog(null, "Seleccione una pila");
                        return;*/
                    //}

                   /* int pila = Integer.parseInt(pilaElegida);
                    pila--;*/

                    /*if (pila < 0 || pila >= pila1.length) {
                        JOptionPane.showMessageDialog(null, "La pila seleccionada no es válida");
                        return;
                    }

                    if (pila1[pila-1].getTamano() < 6) {
                        pila1[pila].apilar(textFieldNombre.getText().toString(), comboBoxContenido.getSelectedItem().toString(), textFieldNumero.getText().toString());
                        JOptionPane.showMessageDialog(null, "Ingresada con éxito");
                    } else {
                        JOptionPane.showMessageDialog(null, "La pila está llena");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Error al convertir el número de pila");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });
    }*/




    public static void main(String[] args) {
        JFrame frame = new JFrame("VistaPaquete");
        frame.setContentPane(new VistaPaquete().Almacenamiento);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
