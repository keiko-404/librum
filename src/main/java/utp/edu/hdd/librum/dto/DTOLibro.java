package utp.edu.hdd.librum.dto;

/**
 *
 * @author #RoaAlyc '^'
 */
public class DTOLibro {

    private String isbn;
    private String titulo;
    private String descripcion;
    private String autor;
    private String genero;

    public DTOLibro() {
    }

    public DTOLibro(String isbn, String titulo, String descripcion, String autor, String genero) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.autor = autor;
        this.genero = genero;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

}
