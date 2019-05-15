package cursos;

import java.util.Arrays;
import static java.util.Arrays.copyOf;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class CursoOnline extends Curso {
    private final int nivel;
    private Map<String, Integer> seguimiento;
    private final Curso[] cursosPrevios;

    public CursoOnline(String titulo, Calendar fechaInicio, Calendar fechaFinal, int numeroDias, double precio, int nivel, Curso... cursos) {
        super(titulo, fechaInicio, fechaFinal, numeroDias, precio);
        this.nivel = nivel;
        this.seguimiento = new HashMap<>();
        this.cursosPrevios = copyOf(cursos, cursos.length);
    }
    
    public int consultarNivel(Alumno alumno){
        for(int i = 0;i<alumnosMatriculados.size();i++ ){
            if(alumnosMatriculados.get(i).getNombre().equals(alumno.getNombre())){
                if(Objects.equals(seguimiento.get(alumno.getNombre()), null)){
                    return 0;
                }else{
                    return (int)seguimiento.get(alumno.getNombre());
                }
            }
        }
        return -1;
    }
    
    public void superarNivel(Alumno alumno){
        int ahora;
        for(int i = 0;i<alumnosMatriculados.size();i++ ){
            if(alumnosMatriculados.get(i).getNombre().equals(alumno.getNombre())){
                if(Objects.equals(seguimiento.get(alumno.getNombre()), null)){
                    seguimiento.put(alumno.getNombre(), 1);
                }else{
                    ahora = seguimiento.get(alumno.getNombre());
                    if(this.nivel <= ahora){
                        seguimiento.replace(alumno.getNombre(), ahora++);
                    }
                }
            }
        }
    }
    
    @Override
    public boolean matriculacion(Alumno alumno){
        if(alumno.getCredito() >= precio && Arrays.equals(alumno.getCursosMatriculados().toArray(), cursosPrevios)){
        	Arrays.equals(alumno.getCursosMatriculados().toArray(), cursosPrevios);
            alumno.decrementarCredito(precio);
            alumnosMatriculados.add(alumno);
            return true;
        }else{
            return false;
        }
    }
    
    @Override
    public boolean vacio() {
        return this.alumnosMatriculados.isEmpty() && this.alumnosAptos.isEmpty() && seguimiento.isEmpty();
    }
    
    @Override
    public boolean alumnoApto(Alumno alumno) {
        return (this.nivel)/2 >= seguimiento.get(alumno.getNombre());
    }
}