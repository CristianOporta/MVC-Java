package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexion {
    // Definición de variables para la conexión
    String base = "tienda";
    String user = "root";
    String password = "CrisJOC&260802";
    String url = "jdbc:mysql://localhost:3307/" + base;
    
    private Connection con = null;
    
    public Connection getConexion() {
        try {
            // Carga el driver de MySQL en memoria para que se pueda usar JDBC
            Class.forName("com.mysql.jdbc.Driver");
            
            // Establece la conexión a la base de datos utilizando la información proporcionada
            con = (Connection) DriverManager.getConnection(url, user, password);
            
            // Muestra un mensaje de éxito en un cuadro de diálogo
            // JOptionPane.showMessageDialog(null, "Conectado");
        } catch (SQLException e) {
            // En caso de un error de SQL, muestra el mensaje de error y un cuadro de diálogo de error
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error");
        } catch (ClassNotFoundException ex) {
            // En caso de que el driver de MySQL no se encuentre, muestra el mensaje de error y registra la excepción
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Devuelve la conexión establecida (puede ser nula si hubo un error)
        return con;
    }
}

