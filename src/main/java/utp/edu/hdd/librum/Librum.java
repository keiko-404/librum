/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package utp.edu.hdd.librum;

import utp.edu.hdd.librum.dao.DAOConexion;
import utp.edu.hdd.librum.dao.DAOLibro;
import utp.edu.hdd.librum.dto.DTOLibro;

/**
 *
 * @author #RoaAlyc '^'
 */
public class Librum {

    public static void main(String[] args) {
        // Crear un libro de prueba
        DTOLibro libro = new DTOLibro("ISBN12345", "Cien Años de Soledad", "Gabriel García Márquez", "Realismo mágico", true);
        
        // Insertarlo con el DAO
        DAOLibro dao = new DAOLibro();
        boolean exito = dao.insertarLibro(libro);

        if (exito) {
            System.out.println("✅ Libro insertado correctamente.");
        } else {
            System.out.println("❌ Error al insertar el libro.");
        }
    }
}