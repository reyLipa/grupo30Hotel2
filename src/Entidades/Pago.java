
package Entidades;
import java.time.LocalDate;


public class Pago {
    private int idPago;
    private LocalDate fechaPago;
    private boolean estado;

    public Pago(int idPago, LocalDate fechaPago, boolean estado) {
        this.idPago = idPago;
        this.fechaPago = fechaPago;
        this.estado = estado;
    }

    public Pago(LocalDate fechaPago, boolean estado) {
        this.fechaPago = fechaPago;
        this.estado = estado;
    }

    public Pago() {
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public LocalDate getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDate fechaPago) {
        this.fechaPago = fechaPago;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Pago{" + "idPago=" + idPago + ", fechaPago=" + fechaPago + ", estado=" + estado + '}';
    }

   
    
}
