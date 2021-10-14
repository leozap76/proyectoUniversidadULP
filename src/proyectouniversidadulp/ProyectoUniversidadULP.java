/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectouniversidadulp;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import proyectouniversidadulp.control.AlumnoData;
import proyectouniversidadulp.control.InscripcionData;
import proyectouniversidadulp.control.MateriaData;
import proyectouniversidadulp.modelo.Alumno;
import proyectouniversidadulp.modelo.Conexion;
import proyectouniversidadulp.modelo.Inscripcion;
import proyectouniversidadulp.modelo.Materia;

/**
 *
 * @author Admin
 */
public class ProyectoUniversidadULP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     Conexion conexion ;
        try {
            conexion = new Conexion();
         Alumno juan=new Alumno(9,9943,"juan","lopes",LocalDate.of(2000,02, 24),true);
            Materia frances=new Materia(31,"frances",4,true);
            Inscripcion i1=new Inscripcion(juan,frances,0);
            InscripcionData d1=new InscripcionData(conexion);
            //d1.guardarInscripcion(i1);
            System.out.println(d1.obtenerAlumnosMateria(31));
            System.out.println(d1.obtenerMateriasCursadasAlumno(9));
        
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProyectoUniversidadULP.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    
}}
