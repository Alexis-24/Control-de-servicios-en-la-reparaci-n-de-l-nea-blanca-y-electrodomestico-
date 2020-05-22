/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Refacciones;

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
public class Refacciones extends javax.swing.JFrame {

    DefaultTableModel dtm;
    private ResultSet rs;
    private PreparedStatement ps;
    private ResultSetMetaData rsm;
    public Refacciones() {
        initComponents();
        Mostrardatos();
     
        this.setLocationRelativeTo(null); //Poner el form en el centro
         
         Border panel =BorderFactory.createMatteBorder(5, 5, 4, 4,Color.black);
         jPanel1.setBorder(panel);
         
          Jengi.getSelectionModel().addListSelectionListener(new ListSelectionListener(){

            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(Jengi.getSelectedRow() != -1)
            {
                int fila = Jengi.getSelectedRow();
                jTextField_id.setText(Jengi.getValueAt(fila, 0).toString());
                jTextField_mod.setText(Jengi.getValueAt(fila, 1).toString());
                jTextField_desc.setText(Jengi.getValueAt(fila, 2).toString());
                jTextField_stock.setText(Jengi.getValueAt(fila, 3).toString());
                jTextField_precio.setText(Jengi.getValueAt(fila, 4).toString());
                
               }
            }
    });
    }
    

    void Mostrardatos(){
        QueryTableBusqueda("SELECT * FROM public.refaccion\n" +
"ORDER BY idrefaccion ASC;");

        
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
            dtm = (DefaultTableModel) Jengi.getModel();
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
        jScrollPane2 = new javax.swing.JScrollPane();
        Jengi = new javax.swing.JTable();
        jButton_volver = new javax.swing.JButton();
        jButton_modificar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField_mod = new javax.swing.JTextField();
        jTextField_desc = new javax.swing.JTextField();
        jTextField_stock = new javax.swing.JTextField();
        jTextField_precio = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
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

        Jengi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Modelo", "Descripción", "Stock", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Jengi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JengiMouseclicked(evt);
            }
        });
        jScrollPane2.setViewportView(Jengi);

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

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Modelo");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Descripción");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Stock");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Precio");

        jTextField_stock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_stockActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Id");

        jTextField_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_idActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 38, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 929, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelmin, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabelcerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(264, 264, 264)
                .addComponent(jButton_volver)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton_modificar)
                .addGap(258, 258, 258))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField_id, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField_mod, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextField_precio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                        .addComponent(jTextField_desc)
                        .addComponent(jTextField_stock)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelmin)
                        .addComponent(jLabelcerrar))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField_mod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField_desc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField_stock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jTextField_precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton_volver, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(jButton_modificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelminMouseClicked

        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabelminMouseClicked

    private void jLabelcerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelcerrarMouseClicked

        System.exit(0);
    }//GEN-LAST:event_jLabelcerrarMouseClicked

    private void JengiMouseclicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JengiMouseclicked
        PreparedStatement cs;
        ResultSet rs;;
        int filaPulsada;
        filaPulsada =Jengi.getSelectedRow();
        if(filaPulsada>=0){
            //int identificador=(int)dtm.getValueAt(filaPulsada,0);
            try{
                System.err.println(dtm.getValueAt(filaPulsada,0));
                cs=Database.getConexion().prepareStatement("SELECT idrefaccion FROM refaccion WHERE idrefaccion = "+dtm.getValueAt(filaPulsada,0)+";");
                System.out.println("SELECT idrefaccion FROM refaccion WHERE idrefaccion = "+dtm.getValueAt(filaPulsada,0)+";");
                //cs.setInt(1,identificador);
                //String codigo=(String)dtm.getValueAt(filaPulsada, 0);
                //codigo=idempleado;
                rs=cs.executeQuery();
                /*
                cs=Database.getConexion().prepareStatement("SELECT id_empleado FROM empleados WHERE id_empleado = ?");
                cs.setInt(1,identificador);
                rs=cs.executeQuery();
                if(rs.next()){
                    System.err.println(dtm.getValueAt(filaPulsada,0));
                }*/
            }catch(SQLException e){
                System.err.println("Error al cargar un cliente");
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_JengiMouseclicked

    private void jButton_volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_volverActionPerformed
        Consultar form = new Consultar();
        form.setVisible(true);
        form.pack();
        form.setLocationRelativeTo(null);
        //Cerra el formulario actual
        this.dispose();
    }//GEN-LAST:event_jButton_volverActionPerformed

    private void jButton_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_modificarActionPerformed
        String id= jTextField_id.getText();
        String modelo = jTextField_mod.getText();
        String desc = jTextField_desc.getText();
        String stock = jTextField_stock.getText();
        String precio = jTextField_precio.getText();
       

        if(veryfiel()){

            String SQL = ("UPDATE refaccion"+
                " SET modelo='"+modelo+"', descrip='"+desc+"', stock='"+stock+"', precio='"+precio+"'"+ " WHERE idrefaccion='"+id+"'");

            try {
                Statement estatuto = Database.getConexion().createStatement();
                estatuto.executeUpdate(SQL);
                JOptionPane.showMessageDialog(null, "Se ha modificado Exitosamente","Informacion",JOptionPane.INFORMATION_MESSAGE); //Manda mensaje de registro exitoso
                estatuto.close();

            } catch (SQLException e) {
                System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(null, "No se Modifico "); //Manda mensaje de error
            }finally {

            }
        }
    }//GEN-LAST:event_jButton_modificarActionPerformed
public boolean veryfiel(){//Metodo que verifica que no haya campos
    String modelo = jTextField_mod.getText();
    String descripcion = jTextField_desc.getText();
    String stock = jTextField_stock.getText();
    String precio = jTextField_precio.getText();
    //Cmprueba los campos vacios
    if(modelo.trim().equals("") || descripcion.trim().equals("") || stock.trim().equals("") || precio.trim().equals("") )
    {
        JOptionPane.showMessageDialog(null,"Uno o mas campos están vacíos");
        return false;
    }else{
        return true; 
    }
}
    private void jTextField_stockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_stockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_stockActionPerformed

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
            java.util.logging.Logger.getLogger(Refacciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Refacciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Refacciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Refacciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Refacciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Jengi;
    private javax.swing.JButton jButton_modificar;
    private javax.swing.JButton jButton_volver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelcerrar;
    private javax.swing.JLabel jLabelmin;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField_desc;
    private javax.swing.JTextField jTextField_id;
    private javax.swing.JTextField jTextField_mod;
    private javax.swing.JTextField jTextField_precio;
    private javax.swing.JTextField jTextField_stock;
    // End of variables declaration//GEN-END:variables
}
