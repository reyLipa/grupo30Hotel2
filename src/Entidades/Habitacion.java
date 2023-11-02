package Entidades;

public class Habitacion {

    private int idHabitacion;
    private int idTipoHab;
    private String numHabitacion;
    private boolean estado;
    private String categoriaHabitacion;
    private String descripcion;

    public Habitacion(int idHabitacion, int idTipoHab, String numHabitacion, boolean estado, String categoriaHabitacion, String descripcion) {
        this.idHabitacion = idHabitacion;
        this.idTipoHab = idTipoHab;
        this.numHabitacion = numHabitacion;
        this.estado = estado;
        this.categoriaHabitacion = categoriaHabitacion;
        this.descripcion = descripcion;
    }

    public Habitacion(int idTipoHab, String numHabitacion, boolean estado, String categoriaHabitacion, String descripcion) {
        this.idTipoHab = idTipoHab;
        this.numHabitacion = numHabitacion;
        this.estado = estado;
        this.categoriaHabitacion = categoriaHabitacion;
        this.descripcion = descripcion;
    }

    public Habitacion() {
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public int getIdTipoHab() {
        return idTipoHab;
    }

    public void setIdTipoHab(int idTipoHab) {
        this.idTipoHab = idTipoHab;
    }

    public String getNumHabitacion() {
        return numHabitacion;
    }

    public void setNumHabitacion(String numHabitacion) {
        this.numHabitacion = numHabitacion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getCategoriaHabitacion() {
        return categoriaHabitacion;
    }

    public void setCategoriaHabitacion(String categoriaHabitacion) {
        this.categoriaHabitacion = categoriaHabitacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Habitacion{" + "idHabitacion=" + idHabitacion + ", idTipoHab=" + idTipoHab + ", numHabitacion=" + numHabitacion + ", estado=" + estado + ", categoriaHabitacion=" + categoriaHabitacion + ", descripcion=" + descripcion + '}';
    }

}
