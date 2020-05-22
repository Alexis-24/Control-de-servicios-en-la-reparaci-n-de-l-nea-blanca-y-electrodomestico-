/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personal;

import Index.Consultar;
import conexion.Database;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author roy_b
 */
public class Tecnicos extends javax.swing.JFrame {

    DefaultTableModel dtm;
    private ResultSet rs;
    private PreparedStatement ps;
    private ResultSetMetaData rsm;
    public Tecnicos() {
        initComponents();
        Mostrardatos();
        Border panel =BorderFactory.createMatteBorder(5, 5, 4, 4,Color.black);
         jPanel1.setBorder(panel);
       
        Tecnicos.getSelectionModel().addListSelectionListener(new ListSelectionListener(){

            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(Tecnicos.getSelectedRow() != -1)
            {
                int fila = Tecnicos.getSelectedRow();
                jTextField_id.setText(Tecnicos.getValueAt(fila, 0).toString());
                jTextField_nombre.setText(Tecnicos.getValueAt(fila, 1).toString());
                jTextField_apellido.setText(Tecnicos.getValueAt(fila, 2).toString());
                jTextField_rfc.setText(Tecnicos.getValueAt(fila, 3).toString());
                jTextField_direccion.setText(Tecnicos.getValueAt(fila, 4).toString());
                jTextField_tel.setText(Tecnicos.getValueAt(fila, 5).toString());
               }
            }
    });
    }

     void Mostrardatos(){
        QueryTableBusqueda("SELECT * FROM public.personal\n" +
"WHERE tipo_personal = 'emp' " + "ORDER BY idpersonal ASC;");

        
     }
     public void QueryTableBusqueda(String SQL){

 
        try {
            Statement estatuto = Database.getConexion().createStatement();
            rs = estatuto.executeQuery(SQL);
            rsm = rs.getMetaData();

            ArrayList<Object[]> datos = new ArrayList<>();
            while (rs.next()) {
                Object[] filas = new Object[rsm.getColumnCount()];
                for (int i = 0; i < filas.length; i++) {
                    filas[i] = rs.getObject(i + 1);

                }
                datos.add(filas);
            }
            dtm = (DefaultTableModel) Tecnicos.getModel();
            for (int i = 0; i < datos.size(); i++) {
                dtm.addRow(datos.get(i));
            }

            System.out.println("Llenado Automatico");
            System.out.println("Query Exitoso");
            estatuto.close();
            

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Algo anda mal...  "); //Manda mensaje de error
        } finally {
       
        }
       
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabelmin = new javax.swing.JLabel();
        jLabelcerrar = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tecnicos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField_nombre = new javax.swing.JTextField();
        jTextField_rfc = new javax.swing.JTextField();
        jTextField_tel = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField_apellido = new javax.swing.JTextField();
        jTextField_direccion = new javax.swing.JTextField();
        jButton_volver = new javax.swing.JButton();
        jButton_modificar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jTextField_id = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Cservicios1.png"))); // NOI18N

        jLabelmin.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabelmin.setText("-");
        jLabelmin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelminMouseClicked(evt);
            }
        });

        jLabelcerrar.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabelcerrar.setText("x");
        jLabelcerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelcerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelcerrarMouseClicked(evt);
            }
        });

        Tecnicos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Tecnicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Apellidos", "RFC", "Dirección", "Teléfono"
            }
        ));
        jScrollPane1.setViewportView(Tecnicos);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Nombre");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("RFC");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Teléfono");

        jTextField_nombre.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_nombreActionPerformed(evt);
            }
        });

        jTextField_rfc.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField_rfc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_rfcActionPerformed(evt);
            }
        });

        jTextField_tel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField_tel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_telActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Apellidos");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Dirección");

        jTextField_apellido.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jTextField_direccion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jButton_volver.setBackground(new java.awt.Color(192, 57, 43));
        jButton_volver.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_volver.setForeground(new java.awt.Color(255, 255, 255));
        jButton_volver.setText("Volver");
        jButton_volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_volverActionPerformed(evt);
            }
        });

        jButton_modificar.setBackground(new java.awt.Color(34, 167, 240));
        jButton_modificar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_modificar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_modificar.setText("Modificar");
        jButton_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_modificarActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("ID");

        jTextField_id.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_idActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelmin, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelcerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField_id, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTextField_rfc)
                    .addComponent(jTextField_nombre)
                    .addComponent(jTextField_tel, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField_direccion))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 917, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(226, 226, 226)
                .addComponent(jButton_volver)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton_modificar)
                .addGap(292, 292, 292))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelmin)
                        .addComponent(jLabelcerrar))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField_rfc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jTextField_tel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton_volver, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(jButton_modificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelminMouseClicked

        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabelminMouseClicked

    private void jLabelcerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelcerrarMouseClicked

        System.exit(0);
    }//GEN-LAST:event_jLabelcerrarMouseClicked

    private void jTextField_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_nombreActionPerformed

    private void jTextField_rfcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_rfcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_rfcActionPerformed

    private void jButton_volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_volverActionPerformed
        Consultar form = new Consultar();
        form.setVisible(true);
        form.pack();
        form.setLocationRelativeTo(null);
        //Cerra el formulario actual
        this.dispose();
    }//GEN-LAST:event_jButton_volverActionPerformed

    private void jButton_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_modificarActionPerformed
        String id = jTextField_id.getText();
        String nomb = jTextField_nombre.getText();
        String apell = jTextField_apellido.getText();
        String rfc = jTextField_rfc.getText();
        String direccion = jTextField_direccion.getText();
        String telefono = jTextField_tel.getText();
        
        if(veryfiel()){

            String SQL = ("UPDATE personal"+

                " SET nombre='"+nomb+"', apellidos='"+apell+"', rfc='"+rfc+"', direccion='"+direccion+"', telefono='"+telefono+"'" +
                " WHERE idpersonal='"+id+"';");

            try {
                Statement estatuto = Database.getConexion().createStatement();
                estatuto.executeUpdate(SQL);
                JOptionPane.showMessageDialog(null, "Se ha modificado Exitosamente","Informacion",JOptionPane.INFORMATION_MESSAGE); //Manda mensaje de registro exitoso
                estatuto.close();

            } catch (SQLException e) {
                System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(null, "No se Modifico "); //Manda mensaje de error
            }
        }
        
    }//GEN-LAST:event_jButton_modificarActionPerformed
 public boolean veryfiel(){
    String nomb = jTextField_nombre.getText();
    String apell = jTextField_apellido.getText();
    String rfc = jTextField_rfc.getText();
    String direccion = jTextField_direccion.getText();
    String telefono = jTextField_tel.getText();
    //Cmprueba los campos vacios
    if(nomb.trim().equals("") || apell.trim().equals("") || rfc.trim().equals("") || direccion.trim().equals("") ||
     telefono.trim().equals("") )
    {
        JOptionPane.showMessageDialog(null,"Uno o mas campos están vacíos");
        return false;
    }else{
        return true; 
    }
}
    private void jTextField_telActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_telActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_telActionPerformed

    private void jTextField_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_idActionPerformed

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
            java.util.logging.Logger.getLogger(Tecnicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tecnicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tecnicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tecnicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tecnicos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tecnicos;
    private javax.swing.JButton jButton_modificar;
    private javax.swing.JButton jButton_volver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelcerrar;
    private javax.swing.JLabel jLabelmin;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField_apellido;
    private javax.swing.JTextField jTextField_direccion;
    private javax.swing.JTextField jTextField_id;
    private javax.swing.JTextField jTextField_nombre;
    private javax.swing.JTextField jTextField_rfc;
    private javax.swing.JTextField jTextField_tel;
    // End of variables declaration//GEN-END:variables
}
