
package utp.edu.hdd.librum.dao;
import utp.edu.hdd.librum.dto.DTOLibro;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class DAOLibro {
    private DAOConexion daoConexion;
    
    public DAOLibro(){
    daoConexion =new DAOConexion();
    
    }   
     public boolean insertarLibro(DTOLibro libro) {
        daoConexion.Conectar();
        String sql = "INSERT INTO libros (id, titulo, autor, genero, disponible) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = daoConexion.getConexion().prepareStatement(sql)) {
            stmt.setString(1, libro.getId());
            stmt.setString(2, libro.getTitulo());
            stmt.setString(3, libro.getAutor());
            stmt.setString(4, libro.getGenero());
            stmt.setBoolean(5, libro.isDisponible());

            int filasInsertadas = stmt.executeUpdate();
            return filasInsertadas > 0;
        } catch (SQLException e) {
            System.out.println("Error insertando libro: " + e.getMessage());
            return false;
        } finally {
            try {
                daoConexion.Desconectar();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Leer - Listar todos los libros
    public List<DTOLibro> listarLibros() {
        daoConexion.Conectar();
        List<DTOLibro> lista = new ArrayList<>();
        String sql = "SELECT * FROM libros";

        try (Statement stmt = daoConexion.getConexion().createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                DTOLibro libro = new DTOLibro(
                        rs.getString("id"),
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getString("genero"),
                        rs.getBoolean("disponible")
                );
                lista.add(libro);
            }
        } catch (SQLException e) {
            System.out.println("Error listando libros: " + e.getMessage());
        } finally {
            try {
                daoConexion.Desconectar();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return lista;
    }

    // Actualizar libro
    public boolean actualizarLibro(DTOLibro libro) {
        daoConexion.Conectar();
        String sql = "UPDATE libros SET titulo = ?, autor = ?, genero = ?, disponible = ? WHERE id = ?";
        try (PreparedStatement stmt = daoConexion.getConexion().prepareStatement(sql)) {
            stmt.setString(1, libro.getTitulo());
            stmt.setString(2, libro.getAutor());
            stmt.setString(3, libro.getGenero());
            stmt.setBoolean(4, libro.isDisponible());
            stmt.setString(5, libro.getId());

            int filasActualizadas = stmt.executeUpdate();
            return filasActualizadas > 0;
        } catch (SQLException e) {
            System.out.println("Error actualizando libro: " + e.getMessage());
            return false;
        } finally {
            try {
                daoConexion.Desconectar();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Eliminar libro
    public boolean eliminarLibro(String Id) {
        daoConexion.Conectar();
        String sql = "DELETE FROM libros WHERE id = ?";
        try (PreparedStatement stmt = daoConexion.getConexion().prepareStatement(sql)) {
            stmt.setString(1, Id);

            int filasEliminadas = stmt.executeUpdate();
            return filasEliminadas > 0;
        } catch (SQLException e) {
            System.out.println("Error eliminando libro: " + e.getMessage());
            return false;
        } finally {
            try {
                daoConexion.Desconectar();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Buscar libro por ISBN
    public DTOLibro buscarLibroPorIsbn(String Id) {
        daoConexion.Conectar();
        String sql = "SELECT * FROM libros WHERE id = ?";
        try (PreparedStatement stmt = daoConexion.getConexion().prepareStatement(sql)) {
            stmt.setString(1, Id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new DTOLibro(
                        rs.getString("id"),
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getString("genero"),
                        rs.getBoolean("disponible")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error buscando libro: " + e.getMessage());
        } finally {
            try {
                daoConexion.Desconectar();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}