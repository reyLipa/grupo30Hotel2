
package Vistas;

import AccesoDatos.HabitacionData;
import AccesoDatos.ReservaData;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ListadoHabitaciones extends javax.swing.JFrame {

    public ListadoHabitaciones() {
        initComponents();
        mostrar("");//cadena vacia para mostrar todas las habitaciones
        this.setLocationRelativeTo(null);//para mostrar la vista en la parte central de la pantalla
    }
  void ocultar_columnas() {//ocultar columnas que no quiero mostrar ej: idHabitacion
        jtTablaHabitaciones.getColumnModel().getColumn(0).setMaxWidth(0);//la columna 0 tiene un maximo de ancho de 0
        jtTablaHabitaciones.getColumnModel().getColumn(0).setMinWidth(0);//la columna 0 tiene un minimo de ancho de 0
        jtTablaHabitaciones.getColumnModel().getColumn(0).setPreferredWidth(0);//ancho preferido en 0
    }
    void mostrar(String buscar) {//procedimiento para mostrar de acuerdo a la busqueda
        try {
            DefaultTableModel modelo;
            HabitacionData func = new HabitacionData();
            modelo = func.mostrarListadoHab(buscar);//el resultado de buscar lo almaceno en mi variable modelo

            jtTablaHabitaciones.setModel(modelo);//le envio a la tabla lo que obtengo con el modelo
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
        jScrollPane2 = new javax.swing.JScrollPane();
        jtTablaHabitaciones = new javax.swing.JTable();
        jlBuscar = new javax.swing.JLabel();
        jTbuscar = new javax.swing.JTextField();
        jbBuscar = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        jlTotalRegistros = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("listadoHabitaciones");

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Listado de habitaciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(255, 204, 204));

        jtTablaHabitaciones.setModel(new javax.swing.table.DefaultTableModel(
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
        jtTablaHabitaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtTablaHabitacionesMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtTablaHabitacionesMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(jtTablaHabitaciones);

        jlBuscar.setForeground(new java.awt.Color(0, 0, 0));
        jlBuscar.setText("Buscar");

        jbBuscar.setBackground(new java.awt.Color(204, 255, 204));
        jbBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar.png"))); // NOI18N
        jbBuscar.setText("Buscar");
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        jbSalir.setBackground(new java.awt.Color(204, 255, 204));
        jbSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salida1.png"))); // NOI18N
        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        jlTotalRegistros.setText("Registros");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jlTotalRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jlBuscar)
                                .addGap(18, 18, 18)
                                .addComponent(jTbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jbBuscar)))
                        .addGap(0, 54, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(175, 175, 175)
                .addComponent(jbSalir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlBuscar)
                    .addComponent(jTbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscar))
                .addGap(66, 66, 66)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbSalir)
                .addGap(26, 26, 26)
                .addComponent(jlTotalRegistros)
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 541, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 414, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(23, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtTablaHabitacionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtTablaHabitacionesMouseClicked
        //aqui pasamos lo que esta en la tabla a cada uno de los campos
       

    }//GEN-LAST:event_jtTablaHabitacionesMouseClicked

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed

        if (jTbuscar.getText().length() == 0) {//no ha ingresado nada

            JOptionPane.showMessageDialog(null, "debe ingresar un numero de habitación");
            jTbuscar.requestFocus();
            return;

        }
        mostrar(jTbuscar.getText());
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jtTablaHabitacionesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtTablaHabitacionesMousePressed
        if (evt.getClickCount()==2) {
            int fila=jtTablaHabitaciones.getSelectedRow();
            String cod;
            String valor;
            cod=jtTablaHabitaciones.getValueAt(fila, 0).toString();
            valor=jtTablaHabitaciones.getValueAt(fila, 1).toString();
            
            Reservas.jtIDHabitacion.setText(cod);
            Reservas.jtNumero.setText(valor);
            dispose();
            }
        
    }//GEN-LAST:event_jtTablaHabitacionesMousePressed

    
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
            java.util.logging.Logger.getLogger(ListadoHabitaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListadoHabitaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListadoHabitaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListadoHabitaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListadoHabitaciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTbuscar;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbSalir;
    private javax.swing.JLabel jlBuscar;
    private javax.swing.JLabel jlTotalRegistros;
    private javax.swing.JTable jtTablaHabitaciones;
    // End of variables declaration//GEN-END:variables
}
