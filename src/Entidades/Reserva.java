
package Entidades;

import java.sql.Date;
import java.time.LocalDate;

public class Reserva {
    
    private int idReserva;
    private int idHuesped;
    private int idHabitacion;   
    private String cantPersonas;
    private Date fechaReserva,fechaEntrada, fechaSalida;
    private String estado;
    private String tipoReserva;
    private int totalDias;
    private int pago;

    public Reserva(int idReserva, int idHuesped, int idHabitacion, String cantPersonas, Date fechaReserva, Date fechaEntrada, Date fechaSalida, String estado, String tipoReserva, int totalDias, int pago) {
        this.idReserva = idReserva;
        this.idHuesped = idHuesped;
        this.idHabitacion = idHabitacion;
        this.cantPersonas = cantPersonas;
        this.fechaReserva = fechaReserva;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.estado = estado;
        this.tipoReserva = tipoReserva;
        this.totalDias = totalDias;
        this.pago = pago;
    }

    public Reserva(int idHuesped, int idHabitacion, String cantPersonas, Date fechaReserva, Date fechaEntrada, Date fechaSalida, String estado, String tipoReserva, int totalDias, int pago) {
        this.idHuesped = idHuesped;
        this.idHabitacion = idHabitacion;
        this.cantPersonas = cantPersonas;
        this.fechaReserva = fechaReserva;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.estado = estado;
        this.tipoReserva = tipoReserva;
        this.totalDias = totalDias;
        this.pago = pago;
    }

    public Reserva() {
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getIdHuesped() {
        return idHuesped;
    }

    public void setIdHuesped(int idHuesped) {
        this.idHuesped = idHuesped;
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public String getCantPersonas() {
        return cantPersonas;
    }

    public void setCantPersonas(String cantPersonas) {
        this.cantPersonas = cantPersonas;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipoReserva() {
        return tipoReserva;
    }

    public void setTipoReserva(String tipoReserva) {
        this.tipoReserva = tipoReserva;
    }

    public int getTotalDias() {
        return totalDias;
    }

    public void setTotalDias(int totalDias) {
        this.totalDias = totalDias;
    }

    public int getPago() {
        return pago;
    }

    public void setPago(int pago) {
        this.pago = pago;
    }

    @Override
    public String toString() {
        return "Reserva{" + "idReserva=" + idReserva + ", idHuesped=" + idHuesped + ", idHabitacion=" + idHabitacion + ", cantPersonas=" + cantPersonas + ", fechaReserva=" + fechaReserva + ", fechaEntrada=" + fechaEntrada + ", fechaSalida=" + fechaSalida + ", estado=" + estado + ", tipoReserva=" + tipoReserva + ", totalDias=" + totalDias + ", pago=" + pago + '}';
    }

    
    
}