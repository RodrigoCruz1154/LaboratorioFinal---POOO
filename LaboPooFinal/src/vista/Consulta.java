/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Container;
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
    
    private static final int ANCHOC = 130, ALTOC = 30;
    
    DefaultTableModel tm;
    
    public Consulta(){
        super("Inscripciones");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        agregarLabels();
        formulario();
        llenarTabla();
        
        Container containter = getContentPane();
        containter.add(lblNumero);
        containter.add(lblNombrePerro);
        containter.add(lblPropietario);
        containter.add(lblEdad);
        containter.add(lblRaza);
        containter.add(lblEstado);
        containter.add(numero);
        containter.add(raza);
        containter.add(estado);
        containter.add(no);
        containter.add(si);
        containter.add(buscar);
        containter.add(insertar);
        containter.add(actualizar);
        containter.add(eliminar);
        containter.add(limpiar);
        containter.add(table);
        setSize(600,600);
        eventos();
    }

    private void agregarLabels() {
        lblNumero = new JLabel("N° Inscripción");
        lblNombrePerro = new JLabel("Nombre");
        lblPropietario = new JLabel("Propietario");
        lblEdad = new JLabel("Edad");
        lblRaza = new JLabel("Raza");
        lblEstado = new JLabel("Estado");
        
        lblNumero.setBounds(10, 10, ANCHOC, ALTOC);
        lblNombrePerro.setBounds(10, 60, ANCHOC, ALTOC);
        lblPropietario.setBounds(160, 60, ANCHOC, ALTOC);
        lblEdad.setBounds(10, 100, ANCHOC, ALTOC);
        lblRaza.setBounds(10, 150, ANCHOC, ALTOC);
        lblEstado.setBounds(10, 200, ANCHOC, ALTOC);
        
    }

    private void formulario() {
        numero = new JTextField();
        raza = new JComboBox();
        estado = new JTextField();
        si = new JRadioButton("Si", true);
        no = new JRadioButton("No");
        resultados = new JTable();
        buscar = new JButton("Buscar");
        insertar = new JButton("Insertar");
        eliminar = new JButton("Eliminar");
        actualizar = new JButton("Actualizar");
        limpiar = new JButton("Limpiar");
        
        table = new JPanel();
        raza.addItem("Pitbull");
        raza.addItem("Pastor Alemán");
        raza.addItem("Gran Danés");
        raza.addItem("Dálmata");
        raza.addItem("Rottweiler");
        
        estados = new ButtonGroup();
        estados.add(si);
        estados.add(no);
    }

    private void llenarTabla() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void eventos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
