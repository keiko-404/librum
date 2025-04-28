package utp.edu.hdd.librum.dao;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOConexion {

    private Connection con;

    private static final Dotenv dotenv = Dotenv.load();

    private String url = dotenv.get("DB_URL");
    private String usuario = dotenv.get("DB_USER");
    private String password = dotenv.get("DB_PASSWORD");

    public void Conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, usuario, password);
            System.out.println("Conexion exitosa \n");

        } catch (Exception e) {
            System.out.println("Error al conectar a la base de datos: " + e.toString());
        }
    }

    public Connection getConexion() {
        return con;
    }

    public void Desconectar() throws SQLException {
        if (con != null && !con.isClosed()) {
            con.close();
        }
    }

}
