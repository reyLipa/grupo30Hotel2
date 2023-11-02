
package Vistas;

import AccesoDatos.HuespedData;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ListaHuespedes extends javax.swing.JFrame {

    public ListaHuespedes() {
        initComponents();
        mostrar("");//muestra todos los clientes
        setLocationRelativeTo(null);//para mostrar en el centro de la pantalla
    }

    void ocultar_columnas() {//ocultar columnas que no quiero mostrar ej: idHabitacion
        jtTablaClientes.getColumnModel().getColumn(0).setMaxWidth(0);//la columna 0 tiene un maximo de ancho de 0
        jtTablaClientes.getColumnModel().getColumn(0).setMinWidth(0);//la columna 0 tiene un minimo de ancho de 0
        jtTablaClientes.getColumnModel().getColumn(0).setPreferredWidth(0);//ancho preferido en 0
    }
    void mostrar(String buscar) {//procedimiento para mostrar de acuerdo a la busqueda
        try {
            DefaultTableModel modelo;
            HuespedData func = new HuespedData();
            modelo = func.mostrar(buscar);//el resultado de buscar lo almaceno en mi variable modelo

            jtTablaClientes.setModel(modelo);//le envio a la tabla lo que obtengo con el modelo
            ocultar_columnas();
            jlTotalRegistros.setText("Total de registros" + Integer.toString(func.totalregistros));
        } catch (Exception e) {

            JOptionPane.showConfirmDialog(null, "Errro en el procedimiento mostrar");
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTablaClientes = new javax.swing.JTable();
        jtBuscar = new javax.swing.JTextField();
        jlTotalRegistros = new javax.swing.JTextField();
        jbBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 0, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista Huespedes"));
        jPanel2.setForeground(new java.awt.Color(204, 0, 204));

        jtTablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtTablaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtTablaClientesMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtTablaClientesMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtTablaClientes);

        jlTotalRegistros.setText("jTextField1");

        jbBuscar.setText("Buscar");
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jlTotalRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)
                                .addComponent(jbBuscar)))))
                .addGap(117, 117, 117))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jlTotalRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 719, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(2, 2, 2)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(28, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 396, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtTablaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtTablaClientesMouseClicked
        //aqui pasamos lo que esta en la tabla a cada uno de los campos
        
    }//GEN-LAST:event_jtTablaClientesMouseClicked

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        if (jtBuscar.getText().length() == 0) {//no ha ingresado nada

            JOptionPane.showMessageDialog(null, "debe ingresar un numero de documento");
            jtBuscar.requestFocus();
            return;

        }
        mostrar(jtBuscar.getText());


    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jtTablaClientesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtTablaClientesMousePressed

    if (evt.getClickCount()==2) {
            int fila=jtTablaClientes.getSelectedRow();
            String cod;
            String valor;
            cod=jtTablaClientes.getValueAt(fila, 0).toString();
            valor=jtTablaClientes.getValueAt(fila, 3).toString() +" " +jtTablaClientes.getValueAt(fila, 4).toString();
            
            Reservas1.jtIDHuesped.setText(cod);
            Reservas1.jtNombreHuesped.setText(valor);
            dispose();
            }        
    }//GEN-LAST:event_jtTablaClientesMousePressed

   
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
            java.util.logging.Logger.getLogger(ListaHuespedes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaHuespedes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaHuespedes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaHuespedes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaHuespedes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JTextField jlTotalRegistros;
    private javax.swing.JTextField jtBuscar;
    private javax.swing.JTable jtTablaClientes;
    // End of variables declaration//GEN-END:variables
}
