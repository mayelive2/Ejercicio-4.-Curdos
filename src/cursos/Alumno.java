package cursos;

import java.util.ArrayList;


public class Alumno {
    private final String nombre;
    private final String dni;
    private double credito;
    private ArrayList<Curso> cursosMatriculados;

    public Alumno(String nombre, String dni, double credito) {
        this.nombre = nombre;
        this.dni = dni;
        this.credito = credito;
        cursosMatriculados = new ArrayList<>();
    }
    
    public Alumno(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
        this.credito = 100;
        cursosMatriculados = new ArrayList<>();
    }
    
    @Override
    public String toString(){
        String inf = nombre + " " + dni + " ";
        if(!cursosMatriculados.isEmpty()){
            for(int i = 0;i<cursosMatriculados.size();i++ ){
                inf += cursosMatriculados.get(i).titulo + " ";
            }
        }else{inf += "No tiene cursos";}
        return inf;
    }
    
    public void incrementarCredito(double credito){
        this.credito = credito + this.credito;
    }
    
    public void decrementarCredito(double credito){
        this.credito = this.credito - credito;
    }
    
    public void anadirCurso(Curso curso) {
        cursosMatriculados.add(curso);
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public double getCredito() {
        return credito;
    }
    
    public ArrayList<Curso> getCursosMatriculados() {
        return cursosMatriculados;
    }
    
}
