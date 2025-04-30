
package utp.edu.hdd.librum.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import utp.edu.hdd.librum.dto.DTOLibro;
public class DAOLibro {
    private DAOConexion daoConexion;
    
    public DAOLibro(){
    daoConexion =new DAOConexion();
    
    }   
    public boolean insertarLibro(DTOLibro libro) {
        daoConexion.Conectar();
        String sql = "INSERT INTO libro (isbn, titulo, descripcion, autor, genero) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = daoConexion.getConexion().prepareStatement(sql)) {
            stmt.setString(1, libro.getIsbn());
            stmt.setString(2, libro.getTitulo());
            stmt.setString(3, libro.getDescripcion());
            stmt.setString(4, libro.getAutor());
            stmt.setString(5, libro.getGenero());

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

    public List<DTOLibro> listarLibros() {
        daoConexion.Conectar();
        List<DTOLibro> lista = new ArrayList<>();
        String sql = "SELECT * FROM libro";

        try (Statement stmt = daoConexion.getConexion().createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                DTOLibro libro = new DTOLibro(
                        rs.getString("isbn"),
                        rs.getString("titulo"),
                        rs.getString("descripcion"),
                        rs.getString("autor"),
                        rs.getString("genero")

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

    public boolean actualizarLibro(DTOLibro libro) {
        daoConexion.Conectar();
        String sql = "UPDATE libro SET titulo = ?, descripcion = ?, autor = ?, genero = ? WHERE isbn = ?";
        try (PreparedStatement stmt = daoConexion.getConexion().prepareStatement(sql)) {
            stmt.setString(1, libro.getTitulo());
            stmt.setString(2, libro.getAutor());
            stmt.setString(3, libro.getDescripcion());
            stmt.setString(4, libro.getGenero());
            stmt.setString(5, libro.getIsbn());

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

    public boolean eliminarLibro(String Isbn) {
        daoConexion.Conectar();
        String sql = "DELETE FROM libro WHERE isbn = ?";
        try (PreparedStatement stmt = daoConexion.getConexion().prepareStatement(sql)) {
            stmt.setString(1, Isbn);

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

    public DTOLibro buscarLibroPorIsbn(String Isbn) {
        daoConexion.Conectar();
        String sql = "SELECT * FROM libro WHERE isbn = ?";
        try (PreparedStatement stmt = daoConexion.getConexion().prepareStatement(sql)) {
            stmt.setString(1, Isbn);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new DTOLibro(
                        rs.getString("isbn"),
                        rs.getString("titulo"),
                        rs.getString("descripcion"),
                        rs.getString("autor"),
                        rs.getString("genero")
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