package AccesoDatos;
import Entidades.CategoriaHabitacion;
import Entidades.TipoHabitacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.swing.JOptionPane;
import java.lang.Enum;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class TipoHabitacionData {
    
    
    private Connection conexion = null;
    public Integer totalRegistros;

    public TipoHabitacionData() {
        conexion = Conexion.getConexion();
    }

    private void mensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }
      public DefaultTableModel mostrar(String buscar) {

        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("idTipoHab");
        modelo.addColumn("codigo");
        modelo.addColumn("cantPersonas");
        modelo.addColumn("cantCamas");
        modelo.addColumn("categoriaCama");
        modelo.addColumn("tipoHabitacion");
        modelo.addColumn("precioNoche");

        String sql = "SELECT * FROM tipohabitacion WHERE tipoHabitacion LIKE '%" + buscar + "%'";

        String[] registro = new String[7];
        totalRegistros = 0;
//        modelo = new DefaultTableModel();
        try {
            Statement s = conexion.createStatement();
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {

                registro[0] = rs.getString("idTipoHab");
                registro[1] = rs.getString("codigo");
                registro[2] = rs.getString("cantPersonas");
                registro[3] = rs.getString("cantCamas");
                registro[4] = rs.getString("categoriacama");
                registro[5] = rs.getString("tipoHabitacion");
                registro[6] = rs.getString("precioNoche");

                totalRegistros = totalRegistros + 1;
                modelo.addRow(registro);
            }
            return modelo;
        } catch (Exception e) {
            mensaje("Ocurrio un error");
            return null;
        }
    }
public boolean guardar(TipoHabitacion tipoHabitacion) {
        String sql = "INSERT INTO tipohabitacion (codigo, cantPersonas, cantCamas, categoriaCama,"
                + "tipoHabitacion,  precioNoche) VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);

            ps.setString(1, tipoHabitacion.getCodigo());
            System.out.println("1");
            ps.setString(2, tipoHabitacion.getCantPersonas());
            System.out.println("2");
            ps.setString(3, tipoHabitacion.getCantCamas());
            System.out.println("3");
            ps.setString(4, tipoHabitacion.getCategoriaCama());
            System.out.println("4");
            ps.setString(5, tipoHabitacion.getTipoHabitacion());
            System.out.println("5");

            ps.setDouble(6, tipoHabitacion.getPrecioNoche());
            System.out.println("6");

            int n = ps.executeUpdate();
            System.out.println("7");

           // ResultSet rs = ps.getGeneratedKeys();
            
            if (n != 0) {
                mensaje("Se guardó exitosamente");
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
      public boolean modificar(TipoHabitacion tipoHabitacion) {

        String sql = "UPDATE tipohabitacion SET cantPersonas=?, cantCamas=?, categoriaCama=?,"
                + "tipoHabitacion=?,  precioNoche=? WHERE codigo=?";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            System.out.println("A");
            ps.setString(1, tipoHabitacion.getCantPersonas());
            ps.setString(2, tipoHabitacion.getCantCamas());
            ps.setString(3, tipoHabitacion.getCategoriaCama());
            ps.setString(4, tipoHabitacion.getTipoHabitacion());
            try {
                 ps.setDouble(5, tipoHabitacion.getPrecioNoche());
            } catch (NumberFormatException e) {
                mensaje("Debe ingresar un número decimal"+e);
            }
           
            ps.setString(6, tipoHabitacion.getCodigo());
            System.out.println("B");

            int n = ps.executeUpdate();
            //ResultSet rs = ps.getGeneratedKeys();
            System.out.println("C");

            if (n != 0) {
                mensaje("Modificado exitosamente");
                System.out.println("E");
                return true;
            } else {
                System.out.println("D");
                return false;
            }
        } catch (Exception e) {
            mensaje("Error" + e);
            return false;
        }
    }
     public boolean eliminar(TipoHabitacion tipoHabitacion) {

        String sql = "DELETE FROM tipohabitacion  WHERE codigo=?";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);

            System.out.println("1");
            ps.setString(1, tipoHabitacion.getCodigo());
            System.out.println("2");

            int exito = ps.executeUpdate();
//            ResultSet rs= ps.getGeneratedKeys();
            System.out.println("3");

            if (exito != 0) {
                mensaje("TipoHabitacion eliminada");
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;

        }
    }
     }

    
    

