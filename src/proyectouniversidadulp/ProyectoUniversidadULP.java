/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectouniversidadulp;

import java.time.LocalDate;
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
        try {
            // TODO code application logic here
            Conexion conexion= new Conexion();
            AlumnoData ad = new AlumnoData(conexion);
            MateriaData md = new MateriaData(conexion);
            InscripcionData id = new InscripcionData(conexion);
            
            
            
            Alumno a1 = new Alumno(9943, "Juan","Lopez", LocalDate.of(2000,2, 24),true);
            Alumno a2 = new Alumno(9944, "Jose","marquiñio", LocalDate.of(1997,1, 31),true);
            Alumno a3 = new Alumno(9945, "Lucas","Isarola", LocalDate.of(1995,6, 15),true);
            
            Materia m1=new Materia("Frances",4,true);
            Materia m2=new Materia("Logica",2,true);
            Materia m3=new Materia("Estadistica",3,true);
          
            ad.guardarAlumno(a1);
            ad.guardarAlumno(a2);
            ad.guardarAlumno(a3);
            
            md.guardarMateria(m1);
            md.guardarMateria(m2);
            md.guardarMateria(m3);
            
         
            
            
                    
            //System.out.println(id.materiasXAlumno(1));
             
            
            
            //a2.setApellido("Cuevas");
            //System.out.println(a2.getApellido());
            
            //ad.actualizarAlumno(a2);
            //System.out.println(a2.getApellido());
            
          
            
//            System.out.println("Alumno :"+ad.buscarAlumno(3));
            System.out.println("\nLista de Alumnos ");
            for(Alumno a:ad.obtenerAlumnos()){ //imprime lista de Alumnos
                
                System.out.println(a);
            }
            System.out.println("\nLista de Materias");
            for(Materia m:md.obtenerMateria()){ //imprime lista de Materias
               
                System.out.println(m);
            }
//             System.out.println("Lista de Materias x alumno");
//            for(Materia i:in.materiasXAlumno(2)){ //imprime lista de Materias
//               
//                System.out.println(i);
//            }
//            
//            System.out.println("Lista de alumnos x materia");
//            for(Alumno i:in.alumnosXMateria(2)){ //imprime lista de Materias
//               
//                System.out.println(i);
//            }
//            
//            //System.out.println(md.buscarMateriasXAlumno(1)); //imprime lista de Materias
//              a1 = new Alumno(9943, "Juan","Lopez Lopez", LocalDate.of(2000,2, 24),true);
//             
//             ad.actualizarAlumno(a1);
//            System.out.println(a1);
            
            
             
            
        } catch (ClassNotFoundException ex) {
            System.out.println("En el main"+ ex);
        }
    }
    
}
