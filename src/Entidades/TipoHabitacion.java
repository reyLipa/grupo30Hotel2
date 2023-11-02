
package Entidades;


public class TipoHabitacion {
    
    private int idTipoHab;
    private String codigo;
    private String cantPersonas;
    private String cantCamas;
    private String categoriaCama;
    private String tipoHabitacion;    
    private double precioNoche;

    public TipoHabitacion(int idTipoHab, String codigo, String cantPersonas, String cantCamas, String categoriaCama, String tipoHabitacion, double precioNoche) {
        this.idTipoHab = idTipoHab;
        this.codigo = codigo;
        this.cantPersonas = cantPersonas;
        this.cantCamas = cantCamas;
        this.categoriaCama = categoriaCama;
        this.tipoHabitacion = tipoHabitacion;
        this.precioNoche = precioNoche;
    }

    public TipoHabitacion(String codigo, String cantPersonas, String cantCamas, String categoriaCama, String tipoHabitacion, double precioNoche) {
        this.codigo = codigo;
        this.cantPersonas = cantPersonas;
        this.cantCamas = cantCamas;
        this.categoriaCama = categoriaCama;
        this.tipoHabitacion = tipoHabitacion;
        this.precioNoche = precioNoche;
    }

    public TipoHabitacion() {
    }

    public int getIdTipoHab() {
        return idTipoHab;
    }

    public void setIdTipoHab(int idTipoHab) {
        this.idTipoHab = idTipoHab;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCantPersonas() {
        return cantPersonas;
    }

    public void setCantPersonas(String cantPersonas) {
        this.cantPersonas = cantPersonas;
    }

    public String getCantCamas() {
        return cantCamas;
    }

    public void setCantCamas(String cantCamas) {
        this.cantCamas = cantCamas;
    }

    public String getCategoriaCama() {
        return categoriaCama;
    }

    public void setCategoriaCama(String categoriaCama) {
        this.categoriaCama = categoriaCama;
    }

    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public double getPrecioNoche() {
        return precioNoche;
    }

    public void setPrecioNoche(double precioNoche) {
        this.precioNoche = precioNoche;
    }

    @Override
    public String toString() {
        return idTipoHab +  ", " + tipoHabitacion;
    }
    
   
   
}
