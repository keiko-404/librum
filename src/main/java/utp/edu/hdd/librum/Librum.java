package utp.edu.hdd.librum;

import java.util.List;
import java.util.Scanner;

import utp.edu.hdd.librum.dao.DAOLibro;
import utp.edu.hdd.librum.dto.DTOLibro;

public class Librum {

    public static void main(String[] args) {
        DAOLibro dao = new DAOLibro();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== MENÚ LIBRUM ===");
            System.out.println("1. Insertar libro");
            System.out.println("2. Listar libros");
            System.out.println("3. Actualizar libro");
            System.out.println("4. Eliminar libro");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    System.out.print("Isbn: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("descripcion: ");
                    String descripcion = scanner.nextLine();
                    System.out.print("Autor: ");
                    String autor = scanner.nextLine();
                    System.out.print("Género: ");
                    String genero = scanner.nextLine();

                    DTOLibro nuevoLibro = new DTOLibro(isbn, titulo, descripcion, autor, genero);
                    if (dao.insertarLibro(nuevoLibro)) {
                        System.out.println("Libro insertado correctamente.");
                    } else {
                        System.out.println("Error al insertar el libro.");
                    }
                    break;

                case 2:
                    List<DTOLibro> libros = dao.listarLibros();
                    if (libros.isEmpty()) {
                        System.out.println("No hay libros registrados.");
                    } else {
                        for (DTOLibro libro : libros) {
                            System.out.println("Isbn: " + libro.getIsbn());
                            System.out.println("Título: " + libro.getTitulo());
                            System.out.println("Descripcion: " + libro.getDescripcion());
                            System.out.println("Autor: " + libro.getAutor());
                            System.out.println("Género: " + libro.getGenero());
                            System.out.println("---------------------------");
                        }
                    }
                    break;

                case 3:
                    System.out.print("Ingrese el Isbn del libro a actualizar: ");
                    String isbnActualizar = scanner.nextLine();
                    DTOLibro libroExistente = dao.buscarLibroPorIsbn(isbnActualizar);

                    if (libroExistente != null) {
                        System.out.println("Deja el campo vacío si no deseas modificarlo.");

                        System.out.print("Nuevo título (actual: " + libroExistente.getTitulo() + "): ");
                        String nuevoTitulo = scanner.nextLine();
                        if (!nuevoTitulo.isEmpty()) {
                            libroExistente.setTitulo(nuevoTitulo);
                        }

                        System.out.print("Nueva descripcion (actual: " + libroExistente.getDescripcion() + "): ");
                        String nuevaDescripcion = scanner.nextLine();
                        if (!nuevaDescripcion.isEmpty()) {
                            libroExistente.setDescripcion(nuevaDescripcion);
                        }

                        System.out.print("Nuevo autor (actual: " + libroExistente.getAutor() + "): ");
                        String nuevoAutor = scanner.nextLine();
                        if (!nuevoAutor.isEmpty()) {
                            libroExistente.setAutor(nuevoAutor);
                        }

                        System.out.print("Nuevo género (actual: " + libroExistente.getGenero() + "): ");
                        String nuevoGenero = scanner.nextLine();
                        if (!nuevoGenero.isEmpty()) {
                            libroExistente.setGenero(nuevoGenero);
                        }

                        if (dao.actualizarLibro(libroExistente)) {
                            System.out.println("Libro actualizado correctamente.");
                        } else {
                            System.out.println("Error al actualizar el libro.");
                        }
                    } else {
                        System.out.println("No se encontró un libro con ese ID.");
                    }
                    break;

                case 4:
                    System.out.print("Ingrese el ID del libro a eliminar: ");
                    String idEliminar = scanner.nextLine();
                    if (dao.eliminarLibro(idEliminar)) {
                        System.out.println("Libro eliminado correctamente.");
                    } else {
                        System.out.println("Error al eliminar el libro.");
                    }
                    break;

                case 0:
                    System.out.println("Saliendo del programa.");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);

        scanner.close();
    }
}
