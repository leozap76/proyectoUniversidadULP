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
import proyectouniversidadulp.modelo.Alumno;
import proyectouniversidadulp.modelo.Conexion;

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
            Alumno a = new Alumno(9943, "Juan","Lopez", LocalDate.of(2000,2, 24),true);
            System.out.println("Alumno :"+ad.buscarAlumno(3));
            
            for(Alumno a1:ad.obtenerAlumnos()){
               
                System.out.println(a1);
            
            }
            
            
        } catch (ClassNotFoundException ex) {
            System.out.println("En el main"+ ex);
        }
    }
    
}
