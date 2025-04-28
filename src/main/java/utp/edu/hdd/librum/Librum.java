/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package utp.edu.hdd.librum;

import utp.edu.hdd.librum.dao.DAOConexion;

/**
 *
 * @author #RoaAlyc '^'
 */
public class Librum {

    public static void main(String[] args) {
        
        //probando conexion
        DAOConexion conexion = new DAOConexion();

        conexion.Conectar();

        try {
            conexion.Desconectar();
            System.out.println("Conexion cerrada correctamente.");
        } catch (Exception e) {
            System.out.println("Error al cerrar la conexión: " + e.toString());
        }
    }
}
