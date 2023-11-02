package AccesoDatos;

import Entidades.Habitacion;
import Entidades.TipoHabitacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class HabitacionData {

    private Connection conexion = null;
    //private TipoHabitacionData thd = new TipoHabitacionData();
    public Integer totalregistros;

    public HabitacionData() {
        conexion = Conexion.getConexion();

    }

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;
        String[] titulos = {"ID", "Numero", "Estado", "Categoria", "Descripcion",};
        String[] registro = new String[5];
        totalregistros = 0; 
        modelo = new DefaultTableModel(null, titulos);
        String sql = "SELECT * FROM habitacion WHERE numHabitacion like'%" + buscar + "%'";//filtra las habitaciones por el numero de habitacion

        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                registro[0] = rs.getString("idHabitacion");
                registro[1] = rs.getString("numHabitacion");
                registro[2] = rs.getString("estado");
                registro[3] = rs.getString("categoriaHabitacion");
                registro[4] = rs.getString("descripcion");

                totalregistros = totalregistros + 1;
                modelo.addRow(registro);
            }
            return modelo;
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, "eror en el programa mostrar registros habitacion");

            return null;
        }
    }

    public DefaultTableModel mostrarListadoHab(String buscar) {
        DefaultTableModel modelo;
        String[] titulos = {"ID", "Numero", "Estado", "Categoria", "Descripcion",};
        String[] registro = new String[5];
        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        String sql = "SELECT * FROM habitacion WHERE numHabitacion like'%" + buscar + "%'";//filtra las habitaciones por el numero de habitacion

        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                registro[0] = rs.getString("idHabitacion");
                registro[1] = rs.getString("numHabitacion");
                registro[2] = rs.getString("estado");
                registro[3] = rs.getString("categoriaHabitacion");
                registro[4] = rs.getString("descripcion");

                totalregistros = totalregistros + 1;//suma los registros agregados
                modelo.addRow(registro);//agregamos a la variable modelo el vector registro
            }
            return modelo;
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, "eror en el programa mostrar registros habitacion");

            return null;
        }
    }

    public boolean guardarHabitacion(Habitacion habitacion) {

        String sql = "INSERT INTO habitacion ( idTipoHab, numHabitacion,estado,"
                + " categoriaHabitacion, descripcion) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            ps.setInt(1, habitacion.getIdTipoHab());
            ps.setString(2, habitacion.getNumHabitacion());
            ps.setBoolean(3, habitacion.isEstado());
            ps.setString(4, habitacion.getCategoriaHabitacion());
            ps.setString(5, habitacion.getDescripcion());
            
            int n = ps.executeUpdate();//variable para almacenar el estado de la ejecucion del ps
            
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    habitacion.setIdHabitacion(rs.getInt(1));
                    JOptionPane.showMessageDialog(null, "Habitacion registrada");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al registrar");
                }
            }
            if (n != 0) {//declaramos una condicion para ver si se cumple la insercion de registros
                return true;//se insertaron
            } else {
                System.out.println("CC");
                return false;//no se insertaron

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al conectar a la tabla de datos gurdar,verifique los datos");

            return false;
        }
    }

    public boolean modificarHabitacion(Habitacion habitacion) {

        String sql = "UPDATE habitacion SET numHabitacion=?,estado=?,"
                + "categoriaHabitacion=?,descripcion=? WHERE idHabitacion=?";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);

            ps.setString(1, habitacion.getNumHabitacion());
            ps.setBoolean(2, habitacion.isEstado());
            ps.setString(3, habitacion.getCategoriaHabitacion());
            ps.setString(4, habitacion.getDescripcion());
            ps.setInt(5, habitacion.getIdHabitacion());
            int n = ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (n != 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al conectar la tabla modificar registros");
            return false;
        }

    }

    public boolean eliminarHabitacion(Habitacion habitacion) {
        String sql = "DELETE FROM habitacion WHERE idHabitacion=?";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);

            ps.setInt(1, habitacion.getIdHabitacion());
            int n = ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (n != 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "habitacion eliminada");
            return false;
        }
    }
    
    
    public List<TipoHabitacion> listarHabitaciones() {
        List<Habitacion> listaHabitaciones = new ArrayList<>();
        String sql = "SELECT * FROM habitacion";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Habitacion habitacion = new Habitacion();
                
                habitacion.setIdTipoHab(rs.getInt("idTipoHab"));
               habitacion.setNumHabitacion(rs.getNString("numHabitacion"));
               habitacion.setEstado(rs.getBoolean("estado"));
               habitacion.setCategoriaHabitacion(rs.getNString("categoriaHabitacion"));
               habitacion.setDescripcion(rs.getString("descripcion"));              
              

                listaHabitaciones.add(habitacion);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar TipoHabitaciones: " + e);
        }

        return listarHabitaciones();
    }

}
