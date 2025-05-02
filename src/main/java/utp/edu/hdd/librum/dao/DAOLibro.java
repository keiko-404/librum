
package utp.edu.hdd.librum.dao;
import java.sql.Connection;
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
            stmt.setString(1, libro.getTitulo());        // título
        stmt.setString(2, libro.getDescripcion());   // descripción
        stmt.setString(3, libro.getAutor());         // autor
        stmt.setString(4, libro.getGenero());        // género
        stmt.setString(5, libro.getIsbn());          // isbn (WHERE)

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
    
    
    
    public List<DTOLibro> buscarLibrosPorTitulo(String textoBusqueda) {
    List<DTOLibro> libros = new ArrayList<>();
    DAOConexion daoConexion = new DAOConexion();
    daoConexion.Conectar(); // Establecer conexión

    String query = "SELECT * FROM libro WHERE titulo LIKE ?";

    try (Connection con = daoConexion.getConexion(); 
         PreparedStatement pst = con.prepareStatement(query)) {

        pst.setString(1, "%" + textoBusqueda + "%"); // Busca por títulos que contengan el texto
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            DTOLibro libro = new DTOLibro();
            libro.setIsbn(rs.getString("isbn"));
            libro.setTitulo(rs.getString("titulo"));
            libro.setDescripcion(rs.getString("descripcion"));
            libro.setAutor(rs.getString("autor"));
            libro.setGenero(rs.getString("genero"));
            libros.add(libro);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            daoConexion.Desconectar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    return libros;
}


}