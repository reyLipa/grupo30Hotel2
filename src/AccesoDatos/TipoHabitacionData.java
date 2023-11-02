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
import java.util.ArrayList;
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

    
        public DefaultTableModel mostrarListadoTipoHab(String buscar) {//mostrar los registros de la base de datos
        DefaultTableModel modelo;
        String[] titulos = {"id","Cama","Personas","Camas","Precio/Noche"};
        String[] registro = new String[5];//almacena los registros de los titulos
        totalRegistros = 0;//Inicializo la variable en ceros 
        modelo = new DefaultTableModel(null, titulos);//agrego los titulos que ya tengo
        String sql ="SELECT * FROM tipohabitacion WHERE idTipoHab like'%"+buscar+"%'";//filtra las habitaciones por el numero de habitacion
              
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);//ejecutamos la consulta del sql

            while (rs.next()) {//obtenemos los resutados recorriendo uno a uno los registros.
                registro[0] = rs.getString("idTipoHab");
                registro[1] = rs.getString("categoriaCama");
                registro[2] = rs.getString("cantPersonasMax");
                registro[3] = rs.getString("cantCamas");
                registro[4] = rs.getString("precioNoche");

                totalRegistros = totalRegistros + 1;//suma los registros agregados
                modelo.addRow(registro);//agregamos a la variable modelo el vector registro
            }
            return modelo;
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, "error   linea 27 TipoHabitacionData");
           
            return null;
        }
    }
    
    
    
    
    public boolean guardar(TipoHabitacion tipoHabitacion) {
        String sql = "INSERT INTO tipohabitacion (codigo, cantPersonas, cantCamas, categoriaCama,"
                + "tipoHabitacion,  precioNoche) VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

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
            PreparedStatement ps = conexion.prepareStatement(sql);

            System.out.println("A");
            ps.setString(1, tipoHabitacion.getCantPersonas());
            ps.setString(2, tipoHabitacion.getCantCamas());
            ps.setString(3, tipoHabitacion.getCategoriaCama());
            ps.setString(4, tipoHabitacion.getTipoHabitacion());
            try {
                ps.setDouble(5, tipoHabitacion.getPrecioNoche());
            } catch (NumberFormatException e) {
                mensaje("Debe ingresar un número decimal" + e);
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

    public List<TipoHabitacion> listarTipoHabitaciones() {
        List<TipoHabitacion> listaTipoHabitaciones = new ArrayList<>();
        String sql = "SELECT * FROM tipohabitacion";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                TipoHabitacion tipoHabitacion = new TipoHabitacion();
                tipoHabitacion.setIdTipoHab(rs.getInt("idTipoHab"));
                tipoHabitacion.setCodigo(rs.getString("codigo"));
                tipoHabitacion.setCantPersonas(rs.getString("cantPersonas"));
                tipoHabitacion.setCantCamas(rs.getString("cantCamas"));
                tipoHabitacion.setCategoriaCama(rs.getString("categoriaCama"));
                tipoHabitacion.setTipoHabitacion(rs.getString("tipoHabitacion"));
                tipoHabitacion.setPrecioNoche(rs.getDouble("precioNoche"));

                listaTipoHabitaciones.add(tipoHabitacion);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar TipoHabitaciones: " + e);
        }

        return listaTipoHabitaciones;
    }

    
    
    
    public  String tipohabitacion(int id){
        String sql="SELECT tipohabitacion.categoriaCama,habitacion.categoriaHabitacion\n" +
"FROM tipohabitacion,habitacion\n" +
"WHERE tipohabitacion.idTipoHab=habitacion.idTipoHab and tipoHabitacion.idTipoHab LIKE '%"+id+"%'";
        String categoria []=new String [0];
        String a = null;String b = null;
         try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);//ejecutamos la consulta del sql

            while (rs.next()) {//obtenemos los resutados recorriendo uno a uno los registros.
                a= rs.getString("categoriaHabitacion");
                b=rs.getString("categoriaCama");
               

//                totalregistros = totalregistros + 1;//suma los registros agregados
                //modelo.addRow(registro);//agregamos a la variable modelo el vector registro
                
           }
           //return modelo;
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, "error en el programa mostrar tipo habitacion");
        }
         return a+"-"+b;
    }    

    
    
    public double  calcularMontoEstadia(int id ,int dias){
TipoHabitacionData tp=new TipoHabitacionData();
double total=0;    
for(TipoHabitacion nuevatp:tp.listarTipoHabitacion(id)){
    if(id==nuevatp.getIdTipoHab()){
        total=nuevatp.getPrecioNoche()*dias;
    }
    }

    return total;
}
    


 public List<TipoHabitacion> listarTipoHabitacion(int id) {
        List<TipoHabitacion> tipoHab  = new ArrayList<>();
        String sql = "SELECT * FROM tipohabitacion  WHERE  idTipoHab= ? ";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TipoHabitacion tp = new TipoHabitacion();

                tp.setIdTipoHab(rs.getInt(id));
                tp.setCategoriaCama(rs.getString("CategoriaCama"));
                tp.setCantPersonas(rs.getString("cantPersonasMax"));
                tp.setCantCamas(rs.getString("cantCamas"));
                tp.setPrecioNoche(rs.getDouble("precioNoche"));
                
              
                tipoHab.add(tp);

            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error  tipoHabitacionData  144 " + ex.getMessage());
        }
        return tipoHab;
    }
    


}
