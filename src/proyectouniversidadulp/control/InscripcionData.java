/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectouniversidadulp.control;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import proyectouniversidadulp.modelo.*;
import proyectouniversidadulp.modelo.Conexion;

public class InscripcionData {
    private Connection con;

    public InscripcionData(Conexion conexion) {
  
        try {
            con = conexion.getConexion();
            
        } catch (SQLException ex) {
            System.out.println("Error en la conexion ");
        }
    
    }
    
    public List<Materia> materiasXAlumno(int id){
    
        List<Materia> materias= new ArrayList<>();
        
    Materia materia=null;
    
    String sql="SELECT materia.* FROM inscripcion WHERE alumno.idAlumno=?";
    
        try {
            PreparedStatement ps= con.prepareStatement(sql);
                       
            ResultSet rs =ps.executeQuery();
            while (rs.next()){
                materia = new Materia();
                
                materia.setIdMateria(rs.getInt("idMateria"));                           
                materia.setNombre(rs.getString(2));
                materia.setAnio(rs.getInt(3));
                materia.setActivo(rs.getBoolean(4));
                
                materias.add(materia);
            }         
            
            ps.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al buscar alumno");
        }    
       return materias;    
       
    }
    
    public List<Alumno> alumnosXMateria(int id){
    List<Alumno> alumnos= new ArrayList<>();
        
    Alumno alumno=null;
    
    String sql="SELECT materia.* FROM inscripcion WHERE materia.idMateria=?";
    
        try {
            PreparedStatement ps= con.prepareStatement(sql);
                       
            ResultSet rs =ps.executeQuery();
            while (rs.next()){
                alumno = new Alumno();
                
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setLegajo(rs.getInt(2));
                alumno.setNombre(rs.getString(3));
                alumno.setApellido(rs.getString(4));
                alumno.setFechNac(rs.getDate(5).toLocalDate());  //date a LocalDate
                alumno.setActivo(rs.getBoolean(6));
                alumnos.add(alumno);
            }          
            
            ps.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al buscar alumno");
        }    
       return alumnos;    
       
    }
    
    //UPDATE `inscripcion` SET `nota` = '8' WHERE `inscripcion`.`idInsc` = 8;
    
    public void registrarNota(Inscripcion inscripcion){
        String swl="UPDATE inscripcion SET idAlumno = ?, idMateria = ?, nota = ? WHERE inscripcion.idInsc = ?";
        
        
    }
    
}

/*

    public void inscribirAlumno(Inscripcion inscripcion){
        String sql = "INSERT INTO inscripcion (idAlumno, idMateria) VALUES (?, ?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, inscripcion.getAlumno().getIdAlumno());
            ps.setInt(2, inscripcion.getMateria().getIdMateria());
            
            ps.executeUpdate();
            ResultSet rs= ps.getGeneratedKeys(); 
            if (rs.next()){
                inscripcion.setIdInsc(rs.getInt(1)); 
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al inscribir "+ex);
        }
    }
    
    public void desinscribirAlumno(Inscripcion inscripcion){
        String sql = "DELETE FROM inscripcion WHERE idAlumno = ? AND idMateria = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, inscripcion.getAlumno().getIdAlumno());
            ps.setInt(2, inscripcion.getMateria().getIdMateria());
            
            ps.executeUpdate();
            ResultSet rs= ps.getGeneratedKeys(); //recupero el idAlumno
            
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al desinscribir "+ex);
        }
    }
    
    public void agregarNota(Inscripcion inscripcion){
        String sql = "UPDATE universidad.inscripcion SET nota = ? WHERE idInsc = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            
            ps.setDouble(1, inscripcion.getNota());
            ps.setInt(2, inscripcion.getIdInsc());
            
            ps.executeUpdate();
            
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al agregar nota "+ex);
        }
    }

*/