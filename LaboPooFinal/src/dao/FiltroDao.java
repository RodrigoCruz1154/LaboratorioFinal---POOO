/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import interfaces.metodos;
import java.util.ArrayList;
import modelo.Filtro;

/**
 *
 * @author LN710Q
 */
public class FiltroDao implements metodos <Filtro>{
    
    private static final String SQL_INSERT = "INSERT INTO mascotas (numInscripcion,nombre,propietario,edad,raza,estado) VALUES (?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE mascotas SET nombre = ?, propietario = ?, edad = ?, raza = ?, estado = ? WHERE numInscripcion = ?";
    private static final String SQL_DELETE = "DELETE FROM mascotas WHERE numInscripcion = ?";
    private static final String SQL_READ = "SELECT * FROM mascotas WHERE numInscripcion = ?";
    private static final String SQL_READALL = "SELECT * FROM mascotas";

    @Override
    public boolean create(Filtro g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Filtro c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Filtro read(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Filtro> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
