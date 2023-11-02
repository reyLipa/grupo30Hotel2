
package AccesoDatos;

import Entidades.Habitacion;
import Entidades.Huesped;
import Entidades.TipoHabitacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class HuespedData {
    private Connection conexion = null;
    public Integer totalregistros;
    
    public HuespedData(){
    conexion =Conexion.getConexion();
    
    }
    
    public DefaultTableModel mostrar(String buscar){
        
        DefaultTableModel modelo;
        
        String[] titulo={ "TipoD", "NumD", "Apellido", "Nombre",
            "Domicilio", "Celular", "Correo", "Estado", "Cancelacion"};
        String[] registro=new String[9];
        totalregistros=0;
        modelo =new DefaultTableModel(null, titulo);
        String sql ="SELECT * FROM huesped WHERE numDocumento like'%"+buscar+"%'";
        
        
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
//                 registro[0] = rs.getString("idHuesped");
                 registro[0] = rs.getString("tipoDocumento");
                 registro[1] = rs.getString("numDocumento");
                 registro[2] = rs.getString("Apellido");
                 registro[3] = rs.getString("Nombre");
                 registro[4] = rs.getString("domicilio");
                  registro[5] = rs.getString("celular");
                  registro[6] = rs.getString("correo"); 
                  registro[7] = rs.getString("estado"); 
                  registro[8] = rs.getString("cancelacion"); 
                  
                  totalregistros=totalregistros+1;
                  modelo.addRow(registro);
            }
            return modelo;
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, "error en el programa mostrar");
            return null;
        }
    }
    
    
    
         public DefaultTableModel mostrarHuesped(String buscar){
        
        DefaultTableModel modelo;
        
        String[] titulo={ "Id.","TipoD", "Numero", "Apellido", "Nombre",
            "Domicilio", "Celular", "Correo", "E", "C"};
        String[] registro=new String[10];
        totalregistros=0;
        modelo =new DefaultTableModel(null, titulo);
        String sql ="SELECT * FROM huesped ";
        
        
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                 registro[0] = rs.getString("idHuesped");
                 registro[1] = rs.getString("tipoDocumento");
                 registro[2] = rs.getString("numDocumento");
                 registro[3] = rs.getString("Apellido");
                 registro[4] = rs.getString("Nombre");
                 registro[5] = rs.getString("domicilio");
                  registro[6] = rs.getString("celular");
                  registro[7] = rs.getString("correo"); 
                  registro[8] = rs.getString("estado"); 
                  registro[9] = rs.getString("cancelacion"); 
                  
                  totalregistros=totalregistros+1;
                  modelo.addRow(registro);
            }
            return modelo;
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, "error en el programa mostrarHuesped linea 67  "+ex.getMessage());
            return null;
        
    }
         }
         
         
    public void guardarHuesped(Huesped huesped){
        String sql="INSERT INTO huesped(tipoDocumento, numDocumento, apellido,"
                + " nombre, domicilio, celular, correo, estado, cancelacion)"
                + " VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps=conexion.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS );
            ps.setString(1, huesped.getTipoDocumento());
            ps.setString(2, huesped.getNumDocumento());
            ps.setString(3, huesped.getApellido());
            ps.setString(4, huesped.getNombre());
            ps.setString(5, huesped.getDomicilio());
            ps.setString(6, huesped.getCelular());
            ps.setString(7, huesped.getCorreo());
            ps.setBoolean(8, huesped.isEstado());
            ps.setBoolean(9, huesped.isEstado());
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()){
              huesped.setIdHuesped(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Huesped guardado");
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al aceder a la tabla huesped");
        }
    }
    
    //buscar forma boolean
    public boolean guardarHuesped1(Huesped huesped){
        String sql="INSERT INTO huesped(tipoDocumento, numDocumento, apellido,"
                + " nombre, domicilio, celular, correo, estado, cancelacion)"
                + " VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps=conexion.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS );
            ps.setString(1, huesped.getTipoDocumento());
            ps.setString(2, huesped.getNumDocumento());
            ps.setString(3, huesped.getApellido());
            ps.setString(4, huesped.getNombre());
            ps.setString(5, huesped.getDomicilio());
            ps.setString(6, huesped.getCelular());
            ps.setString(7, huesped.getCorreo());
            ps.setBoolean(8, huesped.isEstado());
            ps.setBoolean(9, huesped.isEstado());
            int n = ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                if (n != 0) {
                    return true;
                } else {
                    return false;
                }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla huesped");
            return false;
        }
    }
    
    public void eliminarHuesped(int id){
    try{
        String sql=" UPDATE huesped SET estado=0 WHERE idHuesped=?";
        PreparedStatement PS=conexion.prepareStatement(sql);
        PS.setInt(1, id);
        int fila= PS.executeUpdate();
        if(fila==1){
        JOptionPane.showMessageDialog(null, "husped eliminado");
        }
        PS.close();
    }catch(SQLException ex){
       JOptionPane.showMessageDialog(null, "Error al conectar la tabla Husped");
    }
    }
    
    ///eliminar huesped
    public boolean eliminarHuesped(Huesped huesped){
    try{
        String sql=" UPDATE huesped SET estado=0 WHERE idHuesped=?";
        PreparedStatement PS=conexion.prepareStatement(sql);
        PS.setInt(1, huesped.getIdHuesped());
        int fila= PS.executeUpdate();
        if(fila==1){
        //JOptionPane.showMessageDialog(null, "husped eliminado");
        return true;
        }else{
            return false;
        }
        
    }catch(SQLException ex){
       JOptionPane.showMessageDialog(null, "Error al conectar la tabla Husped");
       return false;
    }
    }
    
    public boolean eliminarHuesped1(Huesped huesped) {
        String sql = "DELETE FROM huesped WHERE idHuesped=?";
        System.out.println("eliminado");
            
        try {
            PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

                                    System.out.println("eliminado");

                ps.setInt(1, huesped.getIdHuesped());
                int n = ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                if (n != 0) {
                    return true;
                } else {
                    return false;
                }
    
    }catch(Exception e){
        
        JOptionPane.showMessageDialog(null, "Error al conectar la tabla Eliminar");
        return false;
    }
    }
    
    public void modificarHuesped(Huesped huesped){
     String sql="UPDATE huesped SET tipoDocumento=?,apellido=?,"
             + "nombre=?,domicilio=?,celular=?,correo=? "
             + "WHERE numDocumento= ?";
     PreparedStatement ps =null;
         try {
            ps=conexion.prepareStatement(sql);
            
            ps.setString(1, huesped.getApellido());
            ps.setString(2, huesped.getNombre());
            ps.setString(3, huesped.getDomicilio());
            ps.setString(4, huesped.getCelular());
            ps.setString(5, huesped.getCorreo());
            ps.setString(6, huesped.getNumDocumento());
            
            int exito= ps.executeUpdate();
            if (exito==1) {
                JOptionPane.showMessageDialog(null, "huesped modificado ");
             
         } else{
              JOptionPane.showMessageDialog(null, "huesped no encontrado");
            }
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "no se puede conectar a la tabla huesped");
        }
    }
  //////////////////////////////////////////////////////////////////
    
    
    public List<Huesped> listarHuespedes() {
        List<Huesped> listarHuespedes = new ArrayList<>();
        String sql = "SELECT * FROM tipohabitacion";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {           
                
                Huesped huesped = new Huesped();
                
                huesped.setIdHuesped(rs.getInt("idHuesped"));
                huesped.setTipoDocumento(rs.getString("tipoDocumento"));
                huesped.setNumDocumento(rs.getString("numDocumento"));
                huesped.setApellido(rs.getString("apellido"));
                huesped.setNombre(rs.getString("nombre"));
                huesped.setDomicilio(rs.getString("domicilio"));
                huesped.setCelular(rs.getString("celular"));
                huesped.setCorreo(rs.getString("correo"));
                huesped.setEstado(rs.getBoolean("estado"));
                huesped.setCancelacion(rs.getBoolean("cancelacion"));  
                
                listarHuespedes.add(huesped);
             
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar TipoHabitaciones: " + e);
        }

        return listarHuespedes();
    }
    
    
////////////////////////////////////////////////////////////////////////////////////    
    public boolean modificarHuesped1(Huesped huesped){//editar
     String sql="UPDATE huesped SET tipoDocumento=?, numDocumento=?, apellido=?,"
             + "nombre=?,domicilio=?,celular=?,correo=?, estado=?, cancelacion=? "
             + "WHERE idHuesped=?";
     PreparedStatement ps =null;
         try {
            ps=conexion.prepareStatement(sql);
            ps.setString(1, huesped.getTipoDocumento());
            ps.setString(2, huesped.getNumDocumento());
            ps.setString(3, huesped.getApellido());
            ps.setString(4, huesped.getNombre());
            ps.setString(5, huesped.getDomicilio());
            ps.setString(6, huesped.getCelular());
            ps.setString(7, huesped.getCorreo());
            ps.setBoolean(8, huesped.isEstado());
            ps.setBoolean(9, huesped.isCancelacion());
            ps.setInt(10, huesped.getIdHuesped());
            
            int n = ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                if (n != 0) {
                    return true;
                } else {
                    return false;
                }
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "no se puede conectar a la tabla huesped");
            return false;
        }
    }
    public Huesped buscarHuespedPorDocumento(int documento){
        
        Huesped huesped=null;
        String sql="SELECT idHuesped, tipoDocumento, numDocumento, apellido,"
                + "nombre, domicilio, celular, correo, estado, cancelacion FROM"
                + " huesped WHERE numDocumento=?";
        PreparedStatement ps =null;
        try {
            ps = conexion.prepareStatement(sql);
             ps.setInt(1, documento);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                huesped=new Huesped();
                huesped.setIdHuesped(rs.getInt("idHuesped"));
                
                huesped.setNumDocumento(rs.getString("numDocumento"));
                huesped.setApellido(rs.getString("apellido"));
                huesped.setNombre(rs.getString("nombre"));
                huesped.setDomicilio(rs.getString("domicilio"));
                huesped.setCelular(rs.getString("celular"));
                huesped.setCorreo(rs.getString("correo"));
                huesped.setEstado(rs.getBoolean("estado"));
                huesped.setCancelacion(rs.getBoolean("cancelacion"));
            }else {
                JOptionPane.showMessageDialog(null, "No existe el Huesped");

            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Huesped "+ex.getMessage());
        }
        return huesped;   
    }
    
    public List<Huesped> listarHuespedPorDocumento(int documento){
       List<Huesped> huespedes=new ArrayList<>();
       String sql="SELECT idHuesped, tipoDocumento, numDocumento, apellido, nombre, "
               + "domicilio, celular, correo, estado, cancelacion FROM huesped"
               + " WHERE estado=1 AND numDocumento=?";
       
        try {
           PreparedStatement ps = conexion.prepareStatement(sql);
           ps.setInt(1, documento);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Huesped huesped=new Huesped();
                huesped.setIdHuesped(rs.getInt("idHuesped"));
                
                huesped.setNumDocumento(rs.getString("numDocumento"));
                huesped.setApellido(rs.getString("apellido"));
                huesped.setNombre(rs.getString("nombre"));
                huesped.setDomicilio(rs.getString("domicilio"));
                huesped.setCelular(rs.getString("celular"));
                huesped.setCorreo(rs.getString("cancelacion"));
                huesped.setEstado(rs.getBoolean("estado"));
                huespedes.add(huesped);
                
            }
             ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Huesped "+ ex.getMessage());
        }
            return huespedes;
    }
    
    public boolean eliminarTotalHuesped(Huesped huesped) {
        String sql = "DELETE FROM huesped WHERE idHuesped=?";
            PreparedStatement ps;
        try {
             ps= conexion.prepareStatement(sql);

                
                ps.setInt(1, huesped.getIdHuesped());
                System.out.println("info");
                int n = ps.executeUpdate();
                
//                ResultSet rs = ps.getGeneratedKeys();
                if (n != 0) {
                    return true;
                } else {
                    return false;
                }
    
    }catch(Exception e){
        
        JOptionPane.showConfirmDialog(null, " error conectar tabla");
        return false;
    }
    }
 
    public boolean modificarHuesped2(Huesped huesped){
     String sql="UPDATE huesped SET tipoDocumento=?, apellido=?, nombre=?, domicilio=?, celular=?,"
             + "correo=?, estado=?, cancelacion=? WHERE numDocumento=?";
//             + "// idHuesped=?";
     PreparedStatement ps =null;
         try {
            ps=conexion.prepareStatement(sql);
            ps.setString(1, huesped.getTipoDocumento());
            
            ps.setString(2, huesped.getApellido());
            ps.setString(3, huesped.getNombre());
            ps.setString(4, huesped.getDomicilio());
            ps.setString(5, huesped.getCelular());
            ps.setString(6, huesped.getCorreo());
            ps.setBoolean(7, huesped.isEstado());
            ps.setBoolean(8, huesped.isCancelacion());
            ps.setString(9, huesped.getNumDocumento());
//            ps.setInt(10, huesped.getIdHuesped());
            
            int exito= ps.executeUpdate();
            if (exito!=0) {
                return true;
             
         } else{
              return false;
              
            }
             
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "no se puede conectar a la tabla huesped" + ex.getMessage());
            return false;
        }
    }
    

    public boolean eliminar(Huesped huesped){
       String sql="DELETE FROM huesped WHERE numDocumento=?";
     PreparedStatement ps;
         try {
           ps =conexion.prepareStatement(sql);
            
            ps.setString(1, huesped.getNumDocumento());
            
            int exito= ps.executeUpdate();
            if (exito!=0) {
                return true;
             
         } else{
              return false;
              
            }
             
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "no se puede conectar a la tabla huesped");
            return false;
        }
    
    }

public boolean modificarHuesped3(Huesped huesped){
     String sql="UPDATE huesped SET tipoDocumento=?, numDocumento=?, apellido=?, nombre=?, domicilio=?, celular=?,"
             + "correo=?, estado=?, cancelacion=? WHERE idHuesped=?";

      PreparedStatement ps;
         try {
           ps=conexion.prepareStatement(sql);
            
            ps.setString(1, huesped.getTipoDocumento());
            ps.setString(2, huesped.getNumDocumento());
            ps.setString(3, huesped.getApellido());
            ps.setString(4, huesped.getNombre());
            ps.setString(5, huesped.getDomicilio());
            ps.setString(6, huesped.getCelular());
            ps.setString(7, huesped.getCorreo());
            ps.setBoolean(8, huesped.isEstado());
            ps.setBoolean(9, huesped.isCancelacion());
            
            ps.setInt(10, huesped.getIdHuesped());
            
            int exito= ps.executeUpdate();
            if (exito!=0) {
                System.out.println("modificado con exito");
                JOptionPane.showMessageDialog(null, "huesped modificado");
                return true;
                
             
         } else{
                System.out.println("no se pudo modificar");
              return false;
              
            }
             
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "no se puede conectar a la tabla huesped"+ex.getMessage());
            return false;
        }
    }
}
    
