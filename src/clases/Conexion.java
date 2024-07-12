package clases;

import java.sql.*;

public class Conexion {
//con esta clase nosotros no vamos a tener q escribir varias veces lineas de codigo para conectarnos a la bd.
//si queremos conectarnos a otra bd, solo debemos cambiar el nombre de la bd.
    public static Connection conectar(){
        try {                
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/bd_ds", "root", "");
            return cn;//super importante siempre retornar cn.
        } catch (SQLException e) {
            System.out.println("ERROR, no conecta a la base de datos." + e);
        }
        return null;   
    }
}
