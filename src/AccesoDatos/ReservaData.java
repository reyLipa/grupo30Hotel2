
package AccesoDatos;

import Entidades.Huesped;
import Entidades.Reserva;
import com.toedter.calendar.JDateChooser;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ReservaData {
    private Connection conexion = null;
   // private ReservaData red=new ReservaData();
    public Integer totalregistros;//Creamos una variable para levar el total de registros
    
    public ReservaData() {
        conexion = Conexion.getConexion();
    }
    
    public DefaultTableModel mostrar(String buscar) {//mostrar los registros de la base de datos
        DefaultTableModel modelo;
        String[] titulos = {"ID","Reserva","Entrada","Salida","Huesped","Habitacion","Personas ","Dias", "Pago","E"};
        String[] registro = new String[10];//almacena los registros de los titulos
        totalregistros = 0;//Inicializo la variable en ceros 
        modelo = new DefaultTableModel(null, titulos);//agrego los titulos que ya tengo
        
        String sql1 ="SELECT r.idReserva,r.idHuesped, "
                + "(SELECT apellido FROM huesped WHERE idHuesped=r.idHuesped)as huespeda,"
                + "(SELECT nombre FROM huesped WHERE idHuesped=r.idHuesped)as huespedn,"
                + "r.idHabitacion,h.numHabitacion,"
                + "(SELECT tipoHabitacion FROM tipohabitacion WHERE idTipoHab=h.idTipoHab)as tipohab,"
                + "(SELECT precioNoche FROM tipohabitacion WHERE idTipoHab=h.idTipoHab)as preciohab,"
                + "r.cantPersonas,r.fechaReserva,r.fechaEntrada,r.fechaSalida,r.estado,r.tipoReserva,r.totalDias,r.pago"
                + " FROM reserva r inner join habitacion h on r.idHabitacion=h.idHabitacion WHERE r.fechaReserva like'%"+buscar+"%'";//filtra las habitaciones por el numero de habitacion
       
        
        String sql2="SELECT r.idReserva,r.fechaReserva,r.fechaEntrada,r.fechaSalida,\n" +
"(SELECT apellido FROM huesped WHERE idHuesped=r.idHuesped)as apellido,\n" +
"(SELECT nombre FROM huesped WHERE idHuesped=r.idHuesped)as nombre,\n" +
"h.numHabitacion,r.cantPersonas,r.totalDias,r.pago,r.estado\n" +
" FROM reserva r inner join habitacion h on r.idHabitacion=h.idHabitacion ";
              String sql=sql2 ;
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);//ejecutamos la consulta del sql

            while (rs.next()) {//obtenemos los resutados recorriendo uno a uno .
                registro[0] = rs.getString("idReserva");
                registro[1] = rs.getString("fechaReserva");
                registro[2] = rs.getString("fechaEntrada");
                registro[3] = rs.getString("fechaSalida");
                registro[4] = rs.getString("apellido")+" "+(rs.getString("nombre"));
                registro[5] = rs.getString("numHabitacion");
                registro[6] = rs.getString("cantPersonas");
                registro[7] = rs.getString("totalDias");
                registro[8] = rs.getString("pago");
                registro[9] = rs.getString("estado");
                
                
//                registro[0] = rs.getString("idReserva");
//                registro[1] = rs.getString("idHuesped");
//                registro[2] = rs.getString("huespeda")+" "+rs.getString("huespedn");
//                registro[3] = rs.getString("idHabitacion");
//                registro[4] = rs.getString("numHabitacion");
//                registro[5] = rs.getString("tipohab");
//                registro[6] = rs.getString("preciohab");
//                registro[7] = rs.getString("cantPersonas");
//                registro[8] = rs.getString("fechaReserva");
//                registro[9] = rs.getString("fechaEntrada");
//                registro[10] = rs.getString("fechaSalida");
//                registro[11]=rs.getString("estado");
//                registro[12] = rs.getString("tipoReserva");
//                registro[13] = rs.getString("totalDias");
//                registro[14]=rs.getString("pago");
                

                        
                totalregistros = totalregistros + 1;//suma los registros agregados
                modelo.addRow(registro);//agregamos a la variable modelo el vector registro
            }
            return modelo;
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, "error linea 70 "+ex.getMessage());
           
            return null;
        }
    }
    public String [] reservas (int idR){
        
        String [] reservas =new String [5];
         String sql="Select reserva.idHabitacion,reserva.idhuesped,habitacion.categoriaHabitacion,\n" +
"tipoHabitacion.categoriaCama,reserva.estado \n" +
"FROM reserva,habitacion,tipohabitacion\n" +
"WHERE reserva.idReserva= "+idR+" and habitacion.idHabitacion=reserva.idHabitacion "+
"and habitacion.idHabitacion=tipohabitacion.idTipoHab";

        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);//ejecutamos la consulta del sql

            while (rs.next()) {//obtenemos los resutados recorriendo uno a uno .
                reservas[0] = rs.getString("idHabitacion");
                reservas[1] = rs.getString("idHuesped");
                reservas[2] = rs.getString("categoriaHabitacion");
                reservas[3] = rs.getString("categoriaCama");
                reservas[4] = rs.getString("estado");
                
                
               // totalregistros = totalregistros + 1;//suma los registros agregados
            }
            return reservas;
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, "error linea 100 "+ex.getMessage());
           
            return null;
        }
    }
    
     public DefaultTableModel mostrarHabitaciones(String catHab,String catTipoHab) {//mostrar los registros de la base de datos
        DefaultTableModel modelo;
        String[] titulos = {"ID.","H Numero","H Categoria","H Cama","P Max","Camas ","Precio","descripcion"};
        String[] registro = new String[8];//almacena los registros de los titulos
        totalregistros = 0;//Inicializo la variable en ceros 
        modelo = new DefaultTableModel(null, titulos);//agrego los titulos que ya tengo
        
//Muestra todas las habitaciones libres 
        String sql="SELECT  habitacion.idHabitacion,habitacion.numHabitacion,habitacion.categoriaHabitacion,tipohabitacion.categoriaCama,tipohabitacion.cantPersonas,tipohabitacion.cantCamas,tipohabitacion.precioNoche,habitacion.descripcion" +
"FROM habitacion,tipohabitacion" +
"WHERE habitacion.idTipoHab=tipohabitacion.idTipoHab and habitacion.estado=1 " ;
        
        //filtra la categoria de habitacion
        String sql1="SELECT  habitacion.idHabitacion,habitacion.numHabitacion,habitacion.categoriaHabitacion,tipohabitacion.categoriaCama,tipohabitacion.cantPersonas,tipohabitacion.cantCamas,tipohabitacion.precioNoche,habitacion.descripcion\n" +
"FROM habitacion,tipohabitacion\n" +
"WHERE habitacion.idTipoHab=tipohabitacion.idTipoHab and habitacion.estado=1 and  habitacion.categoriaHabitacion LIKE '"+catHab+"%' ";
        
//filtra la categoria de habitacion y la categoria del tipo de cama;
         String sql2="SELECT  habitacion.idHabitacion,habitacion.numHabitacion,habitacion.categoriaHabitacion,tipohabitacion.categoriaCama,tipohabitacion.cantPersonas,tipohabitacion.cantCamas,tipohabitacion.precioNoche,habitacion.descripcion\n" +
"FROM habitacion,tipohabitacion\n" +
"WHERE habitacion.idTipoHab=tipohabitacion.idTipoHab and habitacion.estado=1 and  habitacion.categoriaHabitacion LIKE '"+catHab+"%'"+ 
"AND tipohabitacion.categoriaCama LIKE '"+catTipoHab+"%'";
//        
//        String sql ="   SELECT habitacion.numHabitacion,habitacion.categoriaHabitacion,tipohabitacion.categoriaCama,tipohabitacion.cantPersonasMax,tipohabitacion.cantCamas,tipoHabitacion.precioNoche " +
//"   FROM habitacion,tipohabitacion" +
//"   WHERE habitacion.idTipoHab=tipohabitacion.idTipoHab and habitacion.categoriaHabitacion LIKE '%"+buscar+"%' " ;
//"SELECT r.idReserva,r.idHuesped, "
//                + "(SELECT apellido FROM huesped WHERE idHuesped=r.idHuesped)as huespeda,"
//                + "(SELECT nombre FROM huesped WHERE idHuesped=r.idHuesped)as huespedn,"
//                + "r.idHabitacion,h.numHabitacion,"
//                + "r.cantPersonas,r.fechaReserva,r.fechaEntrada,r.fechaSalida,r.estado,r.tipoReserva,r.totalDias,r.pago"
//                + " FROM reserva r inner join habitacion h on r.idHabitacion=h.idHabitacion WHERE r.fechaReserva like'%"+buscar+"%'";//filtra las habitaciones por el numero de habitacion
              

              if(catHab != "" && catTipoHab==""){
                       sql=sql1;
                   }else{
                           sql=sql2;
                       }
                       
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);//ejecutamos la consulta del sql

            while (rs.next()) {//obtenemos los resutados recorriendo uno a uno .
                registro[0]=rs.getString("idHabitacion");
                registro[1] = rs.getString("numHabitacion");
                registro[2] = rs.getString("categoriaHabitacion");
                registro[3] = rs.getString("CategoriaCama");
                registro[4] = rs.getString("cantPersonas");
                registro[5] = rs.getString("cantCamas");
                registro[6] = rs.getString("PrecioNoche");
                registro[7]=rs.getString("descripcion");
                
                

                        
                totalregistros = totalregistros + 1;//suma los registros agregados
                modelo.addRow(registro);//agregamos a la variable modelo el vector registro
            }
            return modelo;
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, "error en mostrarHabitaciones 82 "+ex.getMessage());
           
            return null;
        }
    
    }

     
     
    
    
    public boolean guardarReserva(Reserva reserva){
        String sql="INSERT INTO reserva(idHuesped, idHabitacion, cantPersonas, fechaReserva,"
                + " fechaEntrada, fechaSalida, estado, tipoReserva,totalDias, pago)"
                + " VALUES (?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps=conexion.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS );
            ps.setInt(1, reserva.getIdHuesped());
            ps.setInt(2, reserva.getIdHabitacion());
            ps.setString(3, reserva.getCantPersonas());
            ps.setDate(4, reserva.getFechaReserva());
            ps.setDate(5, reserva.getFechaEntrada());
            ps.setDate(6, reserva.getFechaSalida());
            ps.setString(7, reserva.getEstado());
            ps.setString(8, reserva.getTipoReserva());
            ps.setInt(9, reserva.getTotalDias());
            ps.setInt(10, reserva.getPago());
            
            int n = ps.executeUpdate();//variable para almacenar el estado de la ejecucion del ps
                ResultSet rs = ps.getGeneratedKeys();
                if (n != 0) {//declaramos una condicion para ver si se cumple la insercion de registros
                    return true;//se insertaron
                } else {
                    return false;//no se insertaron
                }
            
            

                
       } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al aceder a la tabla ¡¡guardar reserva!!");
        }
        return false;
    }
    
    public boolean modificarReserva(Reserva reserva) {
         String sql= "UPDATE reserva SET idHuesped = ?,idHabitacion = ?,cantPersonas = ?,"
                 + "fechaReserva = ?,fechaEntrada = ?,fechaSalida = ?,estado = ?,"
                 + "tipoReserva = ?,totalDias=?,pago = ? WHERE idReserva = ?";
        
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, reserva.getIdHuesped());
            ps.setInt(2, reserva.getIdHabitacion());
            ps.setString(3, reserva.getCantPersonas());
            ps.setDate(4, reserva.getFechaReserva());
            ps.setDate(5, reserva.getFechaEntrada());
            ps.setDate(6, reserva.getFechaSalida());
            ps.setString(7, reserva.getEstado());
            ps.setString(8, reserva.getTipoReserva());
            ps.setInt(9, reserva.getTotalDias());
            ps.setInt(10, reserva.getPago());
            ps.setInt(11, reserva.getIdReserva());
                    
            int n = ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                if (n != 0) {
                    return true;
                } else {
                    return false;
                }
           

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla ¡¡Reserva!! " + ex.getMessage());
        }
        return false;
    }
public boolean eliminarReserva(Reserva reserva) {
        
         String sql = "DELETE FROM reserva WHERE idReserva=?";
            
        try {
            PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, reserva.getIdReserva());
                int n = ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                if (n != 0) {
                    return true;
                } else {
                    return false;
                }
                }catch(Exception e){
        
        JOptionPane.showMessageDialog(null, "Error al conectar la tabla !!Eliminar¡¡");
        return false;
                }

    }
//    public Reserva buscarReserva(int id) {
//        Reserva reserva=null;
//        String sql="SELECT  idHuesped, idHabitacion, cantPersonas, fechaReserva,"
//                + " fechaEntrada, fechaSalida, estado, tipoReserva, "
//                + "idPago FROM reserva WHERE idReserva=?";
//        
//        PreparedStatement ps = null;
//        try {
//            ps = conexion.prepareStatement(sql);
//            ps.setInt(1, id);
//            ResultSet rs = ps.executeQuery();
//              if (rs.next()) {
//                reserva=new Reserva();
//                reserva.setIdReserva(id);
//                reserva.setIdHuesped(rs.getInt("idHuesped"));
//                reserva.setIdHabitacion(rs.getInt("idHabitacion"));
//                reserva.setCantPersonas(rs.getInt("cantPersonas"));
//                reserva.setFechaReserva(rs.getDate("fechaReserva"));
//                reserva.setFechaEntrada(rs.getDate("fechaEntrada"));
//                reserva.setFechaSalida(rs.getDate("fechaSalida"));
//                reserva.setEstado(rs.getString("estado"));
//                reserva.setTipoReserva(rs.getString("tipoReserva"));
//                reserva.setIdPago(rs.getInt("idPago"));
//                
//                } else {
//                JOptionPane.showMessageDialog(null, "No existe la Reserva");
//            }
//            ps.close();
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Reserva " + ex.getMessage());
//         }
//          return reserva;
//    }
    public Reserva buscarReservaPorHuesped(int id) {
        Reserva reserva = null;
        String sql="SELECT  idHuesped, idHabitacion, cantPersonas, fechaReserva,"
                + " fechaEntrada, fechaSalida, estado, tipoReserva,totalDias "
                + "pago FROM reserva WHERE idHuesped =?";
        
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
              if (rs.next()) {
                reserva=new Reserva();
                reserva.setIdReserva(id);
                reserva.setIdHuesped(rs.getInt("idHuesped"));
                reserva.setIdHabitacion(rs.getInt("idHabitacion"));
                reserva.setCantPersonas(rs.getString("cantPersonas"));
                reserva.setFechaReserva(rs.getDate("fechaReserva"));
                reserva.setFechaEntrada(rs.getDate("fechaEntrada"));
                reserva.setFechaSalida(rs.getDate("fechaSalida"));
                reserva.setEstado(rs.getString("estado"));
                reserva.setTipoReserva(rs.getString("tipoReserva"));
                reserva.setTotalDias(rs.getInt("totalDias"));
                reserva.setPago(rs.getInt("pago"));
                
                } else {
                JOptionPane.showMessageDialog(null, "No existe la Reserva");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Reserva " + ex.getMessage());
         }
          return reserva;
    }
//    public int calcularDias(JDateChooser dateChooser) {
//    Date fechaSeleccionada = dateChooser.getDate();
//    LocalDate fechaActual = LocalDate.now();
//    LocalDate fechaSeleccionadaLocalDate = fechaSeleccionada.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//    long cantidadDias = ChronoUnit.DAYS.between(fechaActual, fechaSeleccionadaLocalDate);
//    return (int) cantidadDias;
//}
    public int calcularDias(LocalDate entrada,LocalDate salida){
     
        Duration pd = Duration.between(entrada.atStartOfDay(),salida.atStartOfDay());
        return (int)pd.toDays();
}
    public void calcularDiaMesAño() {
        LocalDate fini = LocalDate.parse("2022-10-17");
        LocalDate ffin = LocalDate.parse("2023-10-18");
        Period tt =Period.between(fini, ffin);
        System.out.println("Total de dias "+tt.getDays());
        System.out.println("Total de meses "+tt.getMonths());
        System.out.println("Total de años "+tt.getYears());
    }
}