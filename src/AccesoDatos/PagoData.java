
package AccesoDatos;

import Entidades.Pago;
import Entidades.Reserva;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class PagoData {
    
   private Connection conexion = null;
    

    public PagoData() {
        conexion = Conexion.getConexion();
    
}
    public void guardarPago(Pago pago){
        
        String sql="INSERT INTO pago(fechaPago, estado) VALUES (?,?,?)";
        
               
        try {
            PreparedStatement ps=conexion.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS );
           
            ps.setDate(2, Date.valueOf(pago.getFechaPago()));
            ps.setBoolean(3, pago.isEstado());
            
            
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if (rs.next()) {
                pago.setIdPago(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Pago guardado");
                
            }
            ps.close();
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al aceder a la tabla pago");
        }
        
    }
    public void modificarPago(Pago pago) {
         String sql="UPDATE pago SET fechaPago = ?,estado = ? WHERE idPago = ?";
        
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(pago.getFechaPago()));
            ps.setBoolean(2, pago.isEstado());
            ps.setInt(3, pago.getIdPago());
           
                    
            
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Pago Modificado Exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "El pago no existe");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Pago " + ex.getMessage());
        }

    }
public void eliminarPago(int id) {
        try {
            String sql="UPDATE pago SET estado= 0 WHERE idPago =?";
        
           
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            int fila = ps.executeUpdate();
            if (fila == 1) {
                JOptionPane.showMessageDialog(null, " Se eliminó el pago.");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Pago");
        }
    }
    public Pago buscarPago(int id) {
        Pago pago = null;
        String sql="SELECT pagoTotal, fechaPago, estado FROM pago WHERE idPago=?";
        
        
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                pago = new Pago();
                pago.setIdPago(id);
                pago.setFechaPago(rs.getDate("fechaPago").toLocalDate());
                pago.setEstado(true);
               
                
                
            } else {
                JOptionPane.showMessageDialog(null, "No existe el pago");

            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Pago " + ex.getMessage());

        }

        return pago;
    }
    
      
    }
