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
            InscripcionData id=new InscripcionData(conexion);
            AlumnoData ad=new AlumnoData(conexion);
            MateriaData md=new MateriaData(conexion);
            
            Alumno a1=new Alumno(9,9943,"juan","lopes",LocalDate.of(2000,02, 24),true);
           // ad.guardarAlumno(a1);
            Materia m1=new Materia(31,"frances",4,true);
            //md.guardarMateria(m1);
            Inscripcion i1=new Inscripcion(a1,m1,0);
            
            Alumno a2=new Alumno(9,99,"daniel","lopes",LocalDate.of(2000,02, 24),true);
            ad.guardarAlumno(a2);
            Materia m2=new Materia(99,"computo",4,true);
            md.guardarMateria(m2);
            Inscripcion i2=new Inscripcion(a2,m2,0);
            
           
            //id.guardarInscripcion(i2);
           //System.out.println(id.obtenerAlumnosMateria(67));
//            System.out.println(id.obtenerMateriasCursadasAlumno(9));
            System.out.println(id.obtenerInscripciones());
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProyectoUniversidadULP.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    
}}
