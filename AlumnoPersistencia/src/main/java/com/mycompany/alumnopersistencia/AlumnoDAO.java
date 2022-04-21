package com.mycompany.alumnopersistencia;

import java.util.List;

public interface AlumnoDAO {

    public void agregarAlumno(Alumno alumno);
    public List<Alumno> recuperarAlumnos();
    public Alumno recuperarAlumno(int matricula);
    public void actualizarAlumno(Alumno alumno);
    public void eliminarAlumno(int matricula);
    
}
