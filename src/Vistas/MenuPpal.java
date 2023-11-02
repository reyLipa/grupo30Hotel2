package Vistas;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import AccesoDatos.HabitacionData;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class MenuPpal extends javax.swing.JFrame {

    private HabitacionData hd;

    public MenuPpal() {

        initComponents();
        //this.setExtendedState(MAXIMIZED_BOTH);//mostrar en pantalla completa
        this.setTitle("sistema de gestion el gran hotel  !!GRUPO 30 !!");//cambiar el titulo de la ventana
        loadIcons();
        hd = new HabitacionData();
        this.setLocationRelativeTo(null);

        Inicio inicio = new Inicio();
        Reservas reserva = new Reservas();
        Habitaciones habitaciones = new Habitaciones();
        Huespedes huespedes = new Huespedes();
        TipoHabitaciones tipohabitaciones = new TipoHabitaciones();

        ShowPanel(inicio);
    }

    private void loadIcons() {
        Imagen mImagen = new Imagen(jPanel1);
        jPanel1.add(mImagen).repaint();
    }

    private void ShowPanel(JPanel p) {

        p.setSize(1152, 800);
        p.setLocation(0, 0);
        jPanel2Contenido.removeAll();
        jPanel2Contenido.repaint();

        jPanel2Contenido.add(p, BorderLayout.CENTER);
        jPanel2Contenido.revalidate();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        JBInicio = new javax.swing.JButton();
        jBReserva = new javax.swing.JButton();
        jBRecepcion = new javax.swing.JButton();
        jPanel2Contenido = new javax.swing.JPanel();
        jbClientes = new javax.swing.JButton();
        jbHabitaciones = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JBInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/inicio1.png"))); // NOI18N
        JBInicio.setText("Inicio");
        JBInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBInicioActionPerformed(evt);
            }
        });

        jBReserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reserva.png"))); // NOI18N
        jBReserva.setText("Reserva");
        jBReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBReservaActionPerformed(evt);
            }
        });

        jBRecepcion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cama.png"))); // NOI18N
        jBRecepcion.setText("Tipo Habitación");
        jBRecepcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRecepcionActionPerformed(evt);
            }
        });

        jPanel2Contenido.setBackground(new java.awt.Color(255, 204, 153));
        jPanel2Contenido.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2Contenido.setForeground(new java.awt.Color(255, 204, 102));
        jPanel2Contenido.setPreferredSize(new java.awt.Dimension(1152, 775));

        javax.swing.GroupLayout jPanel2ContenidoLayout = new javax.swing.GroupLayout(jPanel2Contenido);
        jPanel2Contenido.setLayout(jPanel2ContenidoLayout);
        jPanel2ContenidoLayout.setHorizontalGroup(
            jPanel2ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1036, Short.MAX_VALUE)
        );
        jPanel2ContenidoLayout.setVerticalGroup(
            jPanel2ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 515, Short.MAX_VALUE)
        );

        jbClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/clientes.png"))); // NOI18N
        jbClientes.setText("Clientes");
        jbClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbClientesActionPerformed(evt);
            }
        });

        jbHabitaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/habitacion.png"))); // NOI18N
        jbHabitaciones.setText("Habitaciones");
        jbHabitaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbHabitacionesActionPerformed(evt);
            }
        });

        jbSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salida1.png"))); // NOI18N
        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JBInicio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBReserva, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbClientes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbHabitaciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBRecepcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel2Contenido, javax.swing.GroupLayout.DEFAULT_SIZE, 1040, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(JBInicio)
                        .addGap(37, 37, 37)
                        .addComponent(jBReserva)
                        .addGap(27, 27, 27)
                        .addComponent(jbHabitaciones)
                        .addGap(18, 18, 18)
                        .addComponent(jBRecepcion)
                        .addGap(18, 18, 18)
                        .addComponent(jbClientes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbSalir))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2Contenido, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBInicioActionPerformed
        Inicio inicio = new Inicio();
        ShowPanel(inicio);

    }//GEN-LAST:event_JBInicioActionPerformed

    private void jBReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBReservaActionPerformed
//        Reservas reserva = new Reservas();
//        ShowPanel(reserva);
Reservas1 reserva = new Reservas1();
ShowPanel(reserva);
    }//GEN-LAST:event_jBReservaActionPerformed

    private void jBRecepcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRecepcionActionPerformed
    TipoHabitaciones tipohabitaciones = new TipoHabitaciones();
        ShowPanel(tipohabitaciones);
    }//GEN-LAST:event_jBRecepcionActionPerformed

    private void jbClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbClientesActionPerformed
        Huespedes huespedes = new Huespedes();

        ShowPanel(huespedes);

    }//GEN-LAST:event_jbClientesActionPerformed

    private void jbHabitacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbHabitacionesActionPerformed
        Habitaciones habitaciones = new Habitaciones();
        ShowPanel(habitaciones);


    }//GEN-LAST:event_jbHabitacionesActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        dispose();

    }//GEN-LAST:event_jbSalirActionPerformed

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
            java.util.logging.Logger.getLogger(MenuPpal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPpal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPpal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPpal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPpal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBInicio;
    private javax.swing.JButton jBRecepcion;
    private javax.swing.JButton jBReserva;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2Contenido;
    private javax.swing.JButton jbClientes;
    private javax.swing.JButton jbHabitaciones;
    private javax.swing.JButton jbSalir;
    // End of variables declaration//GEN-END:variables

}
