package personal.app.evaluation.model;

public class Encuestado {

    String nombre;
    String edad;
    String comida;

    public Encuestado() {
    }

    public Encuestado(String nombre, String edad, String comida) {
        this.nombre = nombre;
        this.edad = edad;
        this.comida = comida;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getComida() {
        return comida;
    }

    public void setComida(String comida) {
        this.comida = comida;
    }

    @Override
    public String toString() {
        return "nombre='" + nombre + '\'' +
                ", edad='" + edad + '\'' +
                ", comida='" + comida + "'";
    }
}
