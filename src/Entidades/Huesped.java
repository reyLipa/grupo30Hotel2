package Entidades;

public class Huesped {

    private int idHuesped;
    private String tipoDocumento;
    private String numDocumento;
    private String apellido;
    private String nombre;
    private String domicilio;
    private String celular;
    private String correo;
    private boolean estado;
    private boolean cancelacion;

    public Huesped() {
    }

    public Huesped(String numDocumento, String apellido, String nombre, String domicilio, String celular, String correo, boolean estado, boolean cancelacion) {
        this.numDocumento = numDocumento;
        this.apellido = apellido;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.celular = celular;
        this.correo = correo;
        this.estado = estado;
        this.cancelacion = cancelacion;
    }

    public Huesped(String tipoDocumento, String numDocumento, String apellido, String nombre, String domicilio, String celular, String correo, boolean estado, boolean cancelacion) {
        this.tipoDocumento = tipoDocumento;
        this.numDocumento = numDocumento;
        this.apellido = apellido;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.celular = celular;
        this.correo = correo;
        this.estado = estado;
        this.cancelacion = cancelacion;
    }

    public Huesped(int idHuesped, String tipoDocumento, String numDocumento, String apellido, String nombre, String domicilio, String celular, String correo, boolean estado, boolean cancelacion) {
        this.idHuesped = idHuesped;
        this.tipoDocumento = tipoDocumento;
        this.numDocumento = numDocumento;
        this.apellido = apellido;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.celular = celular;
        this.correo = correo;
        this.estado = estado;
        this.cancelacion = cancelacion;
    }

    public int getIdHuesped() {
        return idHuesped;
    }

    public void setIdHuesped(int idHuesped) {
        this.idHuesped = idHuesped;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public boolean isCancelacion() {
        return cancelacion;
    }

    public void setCancelacion(boolean cancelacion) {
        this.cancelacion = cancelacion;
    }

    @Override
    public String toString() {
        return "Huesped{" + "idHuesped=" + idHuesped + ", tipoDocumento=" + tipoDocumento + ", numDocumento=" + numDocumento + ", apellido=" + apellido + ", nombre=" + nombre + ", domicilio=" + domicilio + ", celular=" + celular + ", correo=" + correo + ", estado=" + estado + ", cancelacion=" + cancelacion + '}';
    }

}
