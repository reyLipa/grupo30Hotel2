
package AccesoDatos;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
    
    private static final String URL ="jdbc:mariadb://localhost/";
    private static final String DB ="grupo30elgranhotel3";
    private static final String USER="root";
    private static final String PASWORD="";
    private static Connection connection;

    public Conexion() {
    }
      public static Connection getConexion(){
          if (connection==null){
          try {
              Class.forName("org.mariadb.jdbc.Driver");
              connection=DriverManager.getConnection(URL+DB,USER, PASWORD);
              JOptionPane.showMessageDialog(null, "CONECTADO");
              
          } catch (ClassNotFoundException ex) {
              JOptionPane.showMessageDialog(null, "error al cargar el Driver");
          }catch(SQLException ex){
              JOptionPane.showMessageDialog(null, "error al conectarse con la base de datos");
          }
    
    
    }
      return connection;
    
      }
}
