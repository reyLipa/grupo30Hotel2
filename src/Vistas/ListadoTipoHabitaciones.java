package Vistas;

import AccesoDatos.TipoHabitacionData;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ListadoTipoHabitaciones extends javax.swing.JFrame {

    public ListadoTipoHabitaciones() {
        initComponents();

        mostrar("");//cadena vacia para mostrar todas las habitaciones
        this.setLocationRelativeTo(null);//para mostrar la vista en la parte central de la pantalla
    }

    void ocultar_columnas() {//ocultar columna idHabitacion
        jtListaTipoHab.getColumnModel().getColumn(0).setMaxWidth(0);
        jtListaTipoHab.getColumnModel().getColumn(0).setMinWidth(0);
        jtListaTipoHab.getColumnModel().getColumn(0).setPreferredWidth(0);

    }

    void mostrar(String buscar) {

        try {
            DefaultTableModel modelo;
            TipoHabitacionData thd = new TipoHabitacionData();
            modelo = thd.mostrar(buscar);

            jtListaTipoHab.setModel(modelo);
            ocultar_columnas();
            jtfTotal.setText("Total de códigos " + Integer.toString(thd.totalRegistros));

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(this, e);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtListaTipoHab = new javax.swing.JTable();
        jbSalir = new javax.swing.JButton();
        jtfTotal = new javax.swing.JTextField();
        jbLimpiarTabla = new javax.swing.JButton();
        jtfBuscar = new javax.swing.JTextField();
        jbCargar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tipo de Habitaciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        jPanel3.setMaximumSize(new java.awt.Dimension(650, 400));
        jPanel3.setMinimumSize(new java.awt.Dimension(670, 400));

        jtListaTipoHab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "", "", "", "", "", "", "Precio x noche"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtListaTipoHab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtListaTipoHabMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtListaTipoHabMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtListaTipoHab);

        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        jtfTotal.setEditable(false);

        jbLimpiarTabla.setText("Limpiar");
        jbLimpiarTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimpiarTablaActionPerformed(evt);
            }
        });

        jbCargar.setText("Cargar");
        jbCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCargarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jtfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbSalir))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jtfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(262, 262, 262)
                            .addComponent(jbCargar)
                            .addGap(99, 99, 99)
                            .addComponent(jbLimpiarTabla))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(123, 123, 123))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jtfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbCargar)
                            .addComponent(jbLimpiarTabla))
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbSalir))
                .addGap(54, 54, 54))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 798, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(74, 74, 74)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 440, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(52, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtListaTipoHabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtListaTipoHabMouseClicked

//        ListadoTipoHabitaciones.addMouseListener(new MouseAdapter(){
//            
//        })
//        
//        if (evt.getClickCount()==2) {
//           
//            int fila=jtListaTipoHab.getSelectedRow();
//            String cod;
//            String valor;
//              
//            cod=jtListaTipoHab.getValueAt(fila, 5).toString();
//            valor=jtListaTipoHab.getValueAt(fila, 6).toString();
//           
//            Reservas.jtTipoHabitacion.setText(cod);
//            Reservas.jtPrecioHabitacion.setText(valor);
//            dispose();
//            }
//      
 if (evt.getClickCount()==2) {
            int fila=jtListaTipoHab.getSelectedRow();
            String categoria;
            String precio;
            String id;
            categoria=jtListaTipoHab.getValueAt(fila, 1).toString();
            precio=jtListaTipoHab.getValueAt(fila, 4).toString();
            id=jtListaTipoHab.getValueAt(fila,0).toString();
            
            Reservas1.jtPrecioNoche.setText(precio);
            
           // Reservas1.jtIdTipoHab.setText(id);
            TipoHabitacionData tp= new TipoHabitacionData();
           // Reservas1.jtTipoHab.setText(tp.tipohabitacion(Integer.parseInt(id))+"");
            
            dispose();
            }


    }//GEN-LAST:event_jtListaTipoHabMouseClicked

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jbLimpiarTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimpiarTablaActionPerformed
//        borrarFilaTabla();
//        jtfBuscar.setText("");
    }//GEN-LAST:event_jbLimpiarTablaActionPerformed

    private void jbCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCargarActionPerformed

        if (jtfBuscar.getText().length() == 0) {
//            mensaje("Debe ingresar un tipo de habitación");
//            jtfCodigo.requestFocus();
        }
        mostrar(jtfBuscar.getText());
        //         mostrar("");
    }//GEN-LAST:event_jbCargarActionPerformed

    private void jtListaTipoHabMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtListaTipoHabMousePressed
        if (evt.getClickCount() == 2) {
            int fila = jtListaTipoHab.getSelectedRow();
            String categoria;
            String precio;

            categoria = jtListaTipoHab.getValueAt(fila, 5).toString();
            System.out.println("categoria" + categoria);
            precio = jtListaTipoHab.getValueAt(fila, 6).toString();

            Reservas.jtTipoHabitacion.setText(categoria);
            Reservas.jtPrecioHabitacion.setText(precio);

            dispose();
        }
    }//GEN-LAST:event_jtListaTipoHabMousePressed

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
            java.util.logging.Logger.getLogger(ListadoTipoHabitaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListadoTipoHabitaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListadoTipoHabitaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListadoTipoHabitaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListadoTipoHabitaciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbCargar;
    private javax.swing.JButton jbLimpiarTabla;
    private javax.swing.JButton jbSalir;
    private javax.swing.JTable jtListaTipoHab;
    private javax.swing.JTextField jtfBuscar;
    private javax.swing.JTextField jtfTotal;
    // End of variables declaration//GEN-END:variables
}
