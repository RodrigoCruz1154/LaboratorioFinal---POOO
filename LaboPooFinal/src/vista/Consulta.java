/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import dao.FiltroDao;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.Filtro;

/**
 *
 * @author LN710Q
 */
public class Consulta extends JFrame {

    public JLabel lblNumero, lblNombrePerro, lblPropietario, lblEdad, lblRaza, lblEstado;

    public JTextField numero,nombre,propietario,edad, descripcion, estado;
    public JComboBox raza;

    ButtonGroup estados = new ButtonGroup();
    public JRadioButton no;
    public JRadioButton si;
    public JTable resultados;

    public JPanel table;

    public JButton buscar, eliminar, insertar, limpiar, actualizar;

    private static final int ANCHOC = 130, ALTOC = 30;

    DefaultTableModel tm;

    public Consulta() {
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
        setSize(600, 600);
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
//OJO

    private void formulario() {
        numero = new JTextField();
        raza = new JComboBox();
        estado = new JTextField();
        nombre = new JTextField();
        propietario = new JTextField();
        edad = new JTextField();
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

        numero.setBounds(10, 10, ANCHOC, ALTOC);
        raza.setBounds(10, 150, ANCHOC, ALTOC);
        nombre.setBounds(10, 200, ANCHOC, ALTOC);
        propietario.setBounds(150, 200, ANCHOC, ALTOC);
        edad.setBounds(10, 250, ANCHOC, ALTOC);
        estado.setBounds(10, 300, ANCHOC, ALTOC);
        si.setBounds(10, 200, ANCHOC, ALTOC);
        no.setBounds(10, 200, ANCHOC, ALTOC);

        buscar.setBounds(300, 10, ANCHOC, ALTOC);
        insertar.setBounds(10, 210, ANCHOC, ALTOC);
        actualizar.setBounds(150, 210, ANCHOC, ALTOC);
        eliminar.setBounds(300, 210, ANCHOC, ALTOC);
        limpiar.setBounds(450, 210, ANCHOC, ALTOC);
        resultados = new JTable();
        table.setBounds(10, 250, 500, 200);
        table.add(new JScrollPane(resultados));

    }
//fin de ojo :V

    private void llenarTabla() {
        tm = new DefaultTableModel() {
            public Class<?> getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return String.class;
                    case 1:
                        return String.class;
                    case 2:
                        return String.class;
                    default:
                        return Boolean.class;
                }
            }
        };

        tm.addColumn("N° inscripción");
        tm.addColumn("Nombre");
        tm.addColumn("Propietario");
        tm.addColumn("Raza");
        tm.addColumn("Estado");

        FiltroDao fd = new FiltroDao();
        ArrayList<Filtro> filtros = fd.readAll();

        for (Filtro fi : filtros) {
            tm.addRow(new Object[]{fi.getNum(), fi.getNombrePerro(), fi.getPropietario(), fi.getRaza(), fi.isEstado()});
        }

        resultados.setModel(tm);
    }

    private void eventos() {
        insertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FiltroDao fd = new FiltroDao();
                Filtro f = new Filtro(numero.getText(), Integer.parseInt(edad.getText()),nombre.getText(), propietario.getText(), raza.getActionCommand(), true);

                if (no.isSelected()) {
                    f.setEstado(false);
                }
                if (fd.create(f)) {
                    JOptionPane.showMessageDialog(null, "Filtro registrado con exito.");
                    limpiarCampos();
                    llenarTabla();
                } else {
                    JOptionPane.showMessageDialog(null, "Ocurrió un problema al momento de modificar el filtro.");
                }
            }
        });

        eliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FiltroDao fd = new FiltroDao();
                if (fd.delete(numero.getText())) {
                    JOptionPane.showMessageDialog(null, "Filtro Eliminado con éxito.");
                    limpiarCampos();
                    llenarTabla();
                } else {
                    JOptionPane.showMessageDialog(null, "Ocurrió un problema al momento de eliminar el filtro.");
                }
            }
        });

        buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FiltroDao fd = new FiltroDao();
                Filtro f = fd.read(numero.getText());
                if (f == null) {
                    JOptionPane.showMessageDialog(null, "El filtro buscado no se ha encontrado.");
                } else {

                    numero.setText(f.getNum());
                    nombre.setText(f.getNombrePerro());
                    propietario.setText(f.getPropietario());
                    raza.setSelectedItem(f.getRaza());
                    edad.setText(Integer.toString(f.getEdad()));

                    if (f.isEstado()) {
                        si.setSelected(true);
                    } else {
                        no.setSelected(true);
                    }
                }
            }
        });

        limpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarCampos();
            }
        });
    }

    public void limpiarCampos() {
        
        nombre.setText("");
        numero.setText("");
        propietario.setText("");
        edad.setText("");
        raza.setSelectedItem("Pitbull");
        estado.setText("");
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Consulta().setVisible(true);
            }
        });
    }

}
