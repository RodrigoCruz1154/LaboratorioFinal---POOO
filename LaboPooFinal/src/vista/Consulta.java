/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LN710Q
 */
public class Consulta extends JFrame{
    
    public JLabel lblNumero,lblNombrePerro, lblPropietario, lblEdad, lblRaza, lblEstado;
    
    public JTextField numero,descripcion,estado;
    public JComboBox raza;
    
    ButtonGroup estados = new ButtonGroup();
    public JRadioButton no;
    public JRadioButton si;
    public JTable resultados;
    
    public JPanel table;
    
    public JButton buscar,eliminar,insertar,limpiar,actualizar;
    
    private static final int ANCHOC = 600, ALTOC = 600;
    
    DefaultTableModel tm;
    
    public Consulta(){
        super("Inscripciones");
    }
    
}
