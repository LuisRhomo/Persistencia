
package com.mycompany.alumnopersistencia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class AlumnoDAOImpl implements AlumnoDAO{

    private Map<Integer,Alumno> alumnos = new HashMap<>();
    
    @Override
    public void agregarAlumno(Alumno alumno) {
        alumnos.put(alumno.getMatricula(), alumno);
    }

    @Override
    public List<Alumno> recuperarAlumnos() {
        return new ArrayList<Alumno> (alumnos.values());
    }

    @Override
    public Alumno recuperarAlumno(int matricula) {
        return alumnos.get(matricula);
    }

    @Override
    public void actualizarAlumno(Alumno alumno) {
        alumnos.replace(alumno.getMatricula(), alumno);
    }

    @Override
    public void eliminarAlumno(int matricula) { 
    alumnos.remove(matricula);
    }
    
}
