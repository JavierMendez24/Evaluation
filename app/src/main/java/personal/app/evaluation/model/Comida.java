package personal.app.evaluation.model;

public class Comida {

    String nombre;

    public Comida(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return this.nombre;
    }
}
