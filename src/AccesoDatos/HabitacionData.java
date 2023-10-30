package AccesoDatos;


import Entidades.Habitacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class HabitacionData {//conección con la base de datos

    private Connection conexion = null;
    //private TipoHabitacionData thd = new TipoHabitacionData();
    public Integer totalregistros;//Creamos una variable para levar el total de registros

    public HabitacionData() {
        conexion = Conexion.getConexion();

    }

    public DefaultTableModel mostrar(String buscar) {//mostrar los registros de la base de datos
        DefaultTableModel modelo;
        String[] titulos = {"ID","Numero","Estado", "Categoria", "Descripcion",};
        String[] registro = new String[5];//almacena los registros de los titulos
        totalregistros = 0;//Inicializo la variable en ceros 
        modelo = new DefaultTableModel(null, titulos);//agrego los titulos que ya tengo
        String sql ="SELECT * FROM habitacion WHERE numHabitacion AND estado like'%"+buscar+"%'";//filtra las habitaciones por el numero de habitacion
              
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);//ejecutamos la consulta del sql

            while (rs.next()) {//obtenemos los resutados recorriendo uno a uno los registros.
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
public DefaultTableModel mostrarListadoHab(String buscar) {//mostrar los registros de la base de datos
        DefaultTableModel modelo;
        String[] titulos = {"ID","Numero","Estado", "Categoria", "Descripcion",};
        String[] registro = new String[5];//almacena los registros de los titulos
        totalregistros = 0;//Inicializo la variable en ceros 
        modelo = new DefaultTableModel(null, titulos);//agrego los titulos que ya tengo
        String sql ="SELECT * FROM habitacion WHERE numHabitacion like'%"+buscar+"%'";//filtra las habitaciones por el numero de habitacion
              
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);//ejecutamos la consulta del sql

            while (rs.next()) {//obtenemos los resutados recorriendo uno a uno los registros.
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
        

            String sql = "INSERT INTO habitacion ( numHabitacion,estado,"
                    + " categoriaHabitacion, descripcion) VALUES (?,?,?,?)";
            try {
                PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

                ps.setString(1, habitacion.getNumHabitacion());
                ps.setBoolean(2, habitacion.isEstado());
                ps.setString(3, habitacion.getCategoriaHabitacion());
                ps.setString(4, habitacion.getDescripcion());
                
                int n = ps.executeUpdate();//variable para almacenar el estado de la ejecucion del ps
                ResultSet rs = ps.getGeneratedKeys();
                if (n != 0) {//declaramos una condicion para ver si se cumple la insercion de registros
                    return true;//se insertaron
                } else {
                    return false;//no se insertaron
                }
            }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al conectar a la tabla de datos gurdar,verifique los datos");
        
        return false;
    }
        }
    public boolean modificarHabitacion(Habitacion habitacion) {
        
            String sql ="UPDATE habitacion SET numHabitacion=?,estado=?,"
                    + "categoriaHabitacion=?,descripcion=? WHERE idHabitacion=?" ;
                    
            try {
                PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                
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
        String sql ="DELETE FROM habitacion WHERE idHabitacion=?";
               
            
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
    
    }catch(Exception e){
        
        JOptionPane.showMessageDialog(null, "habitacion eliminada");
        return false;
    }
    }

}
  
