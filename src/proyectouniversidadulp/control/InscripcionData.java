/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectouniversidadulp.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import proyectouniversidadulp.modelo.*;
import proyectouniversidadulp.modelo.Conexion;

public class InscripcionData {
    private Connection con;
    Conexion conexion;
    
    

    public InscripcionData(Conexion conexion) {
        try {
            this.conexion = new Conexion();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InscripcionData.class.getName()).log(Level.SEVERE, null, ex);
        }
  
        try {
            con = conexion.getConexion();
            
        } catch (SQLException ex) {
            System.out.println("Error en la conexion ");
        }
    
    }
    public void guardarInscripcion(Inscripcion ins){
        String sql= "INSERT INTO  inscripcion (idAlumno,idMateria, nota) VALUES(?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
       ps.setInt(1,ins.getAlumno().getIdAlumno());
       ps.setInt(2, ins.getMateria().getIdMateria());
       ps.setDouble(3, ins.getNota());
       ps.executeUpdate();
       ResultSet rs= ps.getGeneratedKeys(); //recupero el idAlumno
            
            if (rs.next()){
            ins.setIdInsc(rs.getInt(1));
            }
            ps.close();
        
        } catch (SQLException ex) {
           System.out.println("error al insertar inscripcion");
        }
    }
    public List<Inscripcion> obtenerInscripcionesMateria(int id){
        List<Inscripcion> lista =new ArrayList<>();
        String sql="SELECT * FROM inscripcion,alumno,materia WHERE inscripcion.idAlumno=alumno.idAlumno and inscripcion.idMateria=materia.idMateria and materia.idMateria = ?";
        
        Inscripcion ins;
        Alumno alumno;
        Materia materia;
        
       
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                ins =new Inscripcion();
                alumno=buscarAlumno(rs.getInt(2));
                ins.setAlumno(alumno);
                materia=buscarMateria(rs.getInt(3));
                ins.setMateria(materia);
                ins.setNota(rs.getDouble(rs.getInt(4)));
                lista.add(ins);
                        
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(InscripcionData.class.getName()).log(Level.SEVERE, null, ex);
        }
       return lista;
    } 
    
    public Alumno buscarAlumno(int id){
        AlumnoData ad=new AlumnoData(conexion);
        return ad.buscarAlumno(id);
        
    }
    public Materia buscarMateria(int id){
        MateriaData md=new MateriaData(conexion);
        return md.buscarMaterias(id);
    }
    
    public void borrarInscripcion(int idInsc){
       String sql="DELETE FROM inscripcion WHERE inscripcion.idInsc = ?";

      PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idInsc);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
             System.out.println("Error al borrar "+ex);
        }
        }


    }
    

    
    