/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package utp.edu.hdd.librum.gui;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utp.edu.hdd.librum.dao.DAOLibro;
import utp.edu.hdd.librum.dto.DTOLibro;

/**
 *
 * @author SONY
 */
public class GestionLibro extends javax.swing.JFrame {

    /**
     * Creates new form GestionLibro1
     */
    public GestionLibro() {
        initComponents();
        pack();                    // Ajusta el tamaño según los componentes
        setLocationRelativeTo(null);
        cargarTablaLibros(); // Luego centra la ventana
    }

    private void cargarTablaLibros() {
    try {
        String[] columnas = {"ISBN", "Título", "Descripción", "Autor", "Género"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);

        DAOLibro dao = new DAOLibro();
        List<DTOLibro> lista = dao.listarLibros();

        for (DTOLibro libro : lista) {
            Object[] fila = new Object[5];
            fila[0] = libro.getIsbn();
            fila[1] = libro.getTitulo();
            fila[2] = libro.getDescripcion();
            fila[3] = libro.getAutor();
            fila[4] = libro.getGenero();
            modelo.addRow(fila);
        }

        jTable1.setModel(modelo);
    } catch (Exception e) {
        e.printStackTrace(); // Muestra el error en consola
        JOptionPane.showMessageDialog(this, "Error cargando datos: " + e.getMessage());
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Background = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        JAgregar = new javax.swing.JButton();
        JEditar = new javax.swing.JButton();
        JEliminar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Background.setBackground(new java.awt.Color(255, 204, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel1.setText("Gestiona el libro de forma adecuada");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Isbn", "Titulo", "Descripcion", "Autor", "Genero"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        JAgregar.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        JAgregar.setText("AGREGAR");
        JAgregar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        JAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JAgregarActionPerformed(evt);
            }
        });

        JEditar.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        JEditar.setText("EDITAR");
        JEditar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        JEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JEditarActionPerformed(evt);
            }
        });

        JEliminar.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        JEliminar.setText("ELIMINAR");
        JEliminar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        JEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JEliminarActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utp/edu/hd/librum/icons/gestlibro.png"))); // NOI18N

        jButton1.setBackground(new java.awt.Color(255, 102, 102));
        jButton1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jButton1.setText("VOLVER");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BackgroundLayout = new javax.swing.GroupLayout(Background);
        Background.setLayout(BackgroundLayout);
        BackgroundLayout.setHorizontalGroup(
            BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackgroundLayout.createSequentialGroup()
                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BackgroundLayout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(JAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(JEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(JEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(BackgroundLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BackgroundLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BackgroundLayout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))))
            .addGroup(BackgroundLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        BackgroundLayout.setVerticalGroup(
            BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackgroundLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BackgroundLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BackgroundLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88)))
                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(JAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(JEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JAgregarActionPerformed
       
        ArgLibro agregar =new ArgLibro();
         agregar.setVisible(true); // Muestra el formulario Principal
        this.dispose();
        setLocationRelativeTo(null);
        
    }//GEN-LAST:event_JAgregarActionPerformed

    private void JEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JEditarActionPerformed
     
       // 1) Comprueba que se haya seleccionado una fila
    int fila = jTable1.getSelectedRow();
       
    if (fila == -1) {
        JOptionPane.showMessageDialog(this, "Selecciona primero un libro en la tabla.");
        return;
    }

    // 2) Extrae los datos de esa fila
    DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
    String isbn        = modelo.getValueAt(fila, 0).toString();
    String titulo      = modelo.getValueAt(fila, 1).toString();
    String descripcion = modelo.getValueAt(fila, 2).toString();
    String autor       = modelo.getValueAt(fila, 3).toString();
    String genero      = modelo.getValueAt(fila, 4).toString();

    // 3) Crea el DTO con esos valores
    DTOLibro libroDTO = new DTOLibro(isbn, titulo, descripcion, autor, genero);

    // 4) Llama al constructor de EditLibro que recibe el DTO
    EditLibro editar = new EditLibro(libroDTO);
    editar.setVisible(true);

    // 5) Cierra esta ventana
    this.dispose();
    }//GEN-LAST:event_JEditarActionPerformed

    private void JEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JEliminarActionPerformed
        // 1) Comprueba que se haya seleccionado una fila
    int fila = jTable1.getSelectedRow();
       
    if (fila == -1) {
        JOptionPane.showMessageDialog(this, "Debes seleccionar primero un libro en la tabla.");
        return;
    }

    // 2) Obtén el ISBN (columna 0) de esa fila
    DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
    String isbn = modelo.getValueAt(fila, 0).toString();
    String Titulo =modelo.getValueAt(fila, 1).toString();

    // 3) Pide confirmación al usuario
    int opcion = JOptionPane.showConfirmDialog(
        this,
        "¿Eliminar el libro con ISBN: " + isbn +" "+"con el titulo de :"+" ' "+Titulo+" ' " + "?",
        "Confirmar eliminación",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.WARNING_MESSAGE
    );
    if (opcion != JOptionPane.YES_OPTION) {
        return; // si no confirma, salir
    }

    // 4) Llama al DAO para eliminar
    DAOLibro dao = new DAOLibro();
    boolean eliminado = dao.eliminarLibro(isbn);

    // 5) Muestra resultado y recarga tabla
    if (eliminado) {
        JOptionPane.showMessageDialog(this, "Libro eliminado correctamente.");
        cargarTablaLibros();
    } else {
        JOptionPane.showMessageDialog(this, "Error al eliminar el libro.");
    }
    
    
    
    }//GEN-LAST:event_JEliminarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Principal principal = new Principal();
        principal.setVisible(true); // Muestra el formulario Principal
        this.dispose();
        setLocationRelativeTo(null);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GestionLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionLibro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Background;
    private javax.swing.JButton JAgregar;
    private javax.swing.JButton JEditar;
    private javax.swing.JButton JEliminar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
