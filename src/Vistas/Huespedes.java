/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import AccesoDatos.HabitacionData;
import AccesoDatos.HuespedData;
import Entidades.Habitacion;
import Entidades.Huesped;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Isabel
 */
public class Huespedes extends javax.swing.JPanel {

//    private HuespedDataj hd;
//    private Huesped huesped;
//    private Connection conexion = null;
//    private DefaultTableModel modelo = new DefaultTableModel();

    /**
     * Creates new form RegistroHuespedes
     */
    public Huespedes() {
        initComponents();
        mostrar("");
        inhabilitar();
    }
    private String accion = "guardar";

    void ocultar_columnas() {
        jtHuesped.getColumnModel().getColumn(0).setMaxWidth(0);
        jtHuesped.getColumnModel().getColumn(0).setMinWidth(0);
        jtHuesped.getColumnModel().getColumn(0).setPreferredWidth(0);
    }

    void inhabilitar() {
        jtId.setVisible(false);
        jtDocumento.setVisible(false);
        cboxTipodoc.setVisible(false);
        jtApellido.setVisible(false);
        jtNombre.setVisible(false);
        jtDomicilio.setVisible(false);
        jtTelefono.setVisible(false);
        jtCorreo.setVisible(false);
        jrEstado.setVisible(false);
        jrCancelacion.setVisible(false);

//        jbBuscar.setEnabled(false);
//            jbNuevo.setEnabled(false);
        jbGuardar.setVisible(false);
        jbEliminar.setVisible(false);
        jtSalir.setVisible(true);
        
        jtId.setText(null);
        jtDocumento.setText("");
        jtApellido.setText("");
        jtNombre.setText("");
        jtDomicilio.setText("");
        jtTelefono.setText("");
        jtCorreo.setText("");

    }

    void habilitar() {
        jtId.setVisible(true);
        jtDocumento.setVisible(true);
        cboxTipodoc.setVisible(true);
        jtApellido.setVisible(true);
        jtNombre.setVisible(true);
        jtDomicilio.setVisible(true);
        jtTelefono.setVisible(true);
        jtCorreo.setVisible(true);
        jrEstado.setVisible(true);
        jrCancelacion.setVisible(true);

        jbBuscar.setVisible(true);
        jbNuevo.setVisible(true);
        jbGuardar.setVisible(true);
        jbEliminar.setVisible(true);

        jtId.setText(null);
        jtDocumento.setText("");
        jtApellido.setText("");
        jtNombre.setText("");
        jtDomicilio.setText("");
        jtTelefono.setText("");
        jtCorreo.setText("");
    }

    void mostrar(String buscar) {
        try {
            DefaultTableModel modelo;
            
            HuespedData hd = new HuespedData();
            modelo = hd.mostrar(buscar);
            
            jtHuesped.setModel(modelo);
            ocultar_columnas();
           
            jlTotal.setText("Total registros " + Integer.toString(hd.totalregistros));
           

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error al mostrar registros");

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtHuesped = new javax.swing.JTable();
        jtSalir = new javax.swing.JButton();
        jlTotal = new javax.swing.JLabel();
        jtBusqueda = new javax.swing.JTextField();
        jbBuscar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cboxTipodoc = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jtCorreo = new javax.swing.JTextField();
        jtTelefono = new javax.swing.JTextField();
        jtDomicilio = new javax.swing.JTextField();
        jtNombre = new javax.swing.JTextField();
        jtApellido = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jbGuardar = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jbNuevo = new javax.swing.JButton();
        jrEstado = new javax.swing.JRadioButton();
        jrCancelacion = new javax.swing.JRadioButton();
        jLabel12 = new javax.swing.JLabel();
        jtId = new javax.swing.JTextField();
        jtDocumento = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 0, 255));

        jPanel1.setBackground(new java.awt.Color(255, 153, 153));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Registro de Huespedes");

        jtHuesped.setModel(new javax.swing.table.DefaultTableModel(
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
        jtHuesped.setEnabled(false);
        jtHuesped.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtHuespedMouseClicked(evt);
            }
        });
        jtHuesped.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtHuespedKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(jtHuesped);

        jtSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salida1.png"))); // NOI18N
        jtSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtSalirActionPerformed(evt);
            }
        });

        jlTotal.setText("Total Registros");

        jtBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtBusquedaKeyTyped(evt);
            }
        });

        jbBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar.png"))); // NOI18N
        jbBuscar.setText("Buscar");
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jtSalir)
                .addGap(73, 73, 73)
                .addComponent(jlTotal)
                .addGap(71, 71, 71))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(96, 96, 96)
                            .addComponent(jtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbBuscar))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(186, 186, 186)
                            .addComponent(jLabel2))))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtSalir)
                    .addComponent(jlTotal))
                .addGap(19, 19, 19))
        );

        jLabel1.setText("Registro");

        jPanel2.setBackground(new java.awt.Color(255, 102, 255));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Gestión de Huespedes");

        cboxTipodoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DNI", "Pasaporte", "PartidaNac" }));
        cboxTipodoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxTipodocActionPerformed(evt);
            }
        });

        jLabel4.setText("Tipo de Documento");

        jLabel5.setText("Nro");

        jLabel6.setText("Apellido");

        jLabel7.setText("Nombre");

        jLabel8.setText("Domicilio");

        jLabel9.setText("Telefono");

        jtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtCorreoActionPerformed(evt);
            }
        });
        jtCorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtCorreoKeyTyped(evt);
            }
        });

        jtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtTelefonoActionPerformed(evt);
            }
        });
        jtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtTelefonoKeyTyped(evt);
            }
        });

        jtDomicilio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtDomicilioActionPerformed(evt);
            }
        });
        jtDomicilio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtDomicilioKeyTyped(evt);
            }
        });

        jtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtNombreActionPerformed(evt);
            }
        });
        jtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtNombreKeyTyped(evt);
            }
        });

        jtApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtApellidoActionPerformed(evt);
            }
        });
        jtApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtApellidoKeyTyped(evt);
            }
        });

        jLabel10.setText("Correo");

        jbGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/guardar.png"))); // NOI18N
        jbGuardar.setText("Guardar");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        jbEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminar.png"))); // NOI18N
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });

        jbNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/nuevo.png"))); // NOI18N
        jbNuevo.setText("Nuevo");
        jbNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNuevoActionPerformed(evt);
            }
        });

        jrEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrEstadoActionPerformed(evt);
            }
        });

        jLabel12.setText("ID");

        jtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtIdActionPerformed(evt);
            }
        });
        jtId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtIdKeyTyped(evt);
            }
        });

        jtDocumento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtDocumentoKeyTyped(evt);
            }
        });

        jLabel11.setText("Estado");

        jLabel13.setText("Cancelación");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(jbNuevo)
                .addGap(46, 46, 46)
                .addComponent(jbGuardar)
                .addGap(49, 49, 49)
                .addComponent(jbEliminar)
                .addGap(68, 68, 68))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(jtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(jtDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel9))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                                    .addComponent(jtCorreo)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cboxTipodoc, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jrCancelacion)
                            .addComponent(jrEstado))
                        .addGap(58, 58, 58))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jtDocumento)
                        .addContainerGap())))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(jtId, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboxTipodoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jrEstado)
                    .addComponent(jLabel11))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jtDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jrCancelacion)
                            .addComponent(jLabel13))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbGuardar)
                    .addComponent(jbEliminar)
                    .addComponent(jbNuevo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(64, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        // TODO add your handling code here:
        mostrar(jtBusqueda.getText());
//        if (jtBusqueda.getText().length()==0) {
//             JOptionPane.showMessageDialog(null, "debe ingresar un numero de documento");
//            jtBusqueda.requestFocus();
//            return;
//        }
//        mostrar(jtBusqueda.getText());
        
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jtHuespedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtHuespedMouseClicked
        // TODO add your handling code here:
HuespedData hd=new HuespedData();
Huesped huesped=new Huesped();

        jbGuardar.setText("modificar");
        habilitar();
        jbEliminar.setEnabled(true);
        accion = "modificar";
        int fila = jtHuesped.rowAtPoint(evt.getPoint());
        jtId.setText(jtHuesped.getValueAt(fila, 0).toString());
        cboxTipodoc.setSelectedItem(jtHuesped.getValueAt(fila, 0).toString());
        jtDocumento.setText(jtHuesped.getValueAt(fila, 1).toString());
        jtApellido.setText(jtHuesped.getValueAt(fila, 2).toString());
        jtNombre.setText(jtHuesped.getValueAt(fila, 3).toString());
        jtDomicilio.setText(jtHuesped.getValueAt(fila, 4).toString());
        jtTelefono.setText(jtHuesped.getValueAt(fila, 5).toString());
        jtCorreo.setText(jtHuesped.getValueAt(fila, 6).toString());
        jrEstado.setText(jtHuesped.getValueAt(fila, 7).toString());
        jrCancelacion.setText(jtHuesped.getValueAt(fila, 8).toString());
        huesped=hd.buscarHuespedPorDocumento(Integer.parseInt(jtDocumento.getText()));
        
        jtId.setText(String.valueOf(huesped.getIdHuesped()));
        

//       
//     
//     jtNumero.setText(jtTablaHabitaciones.getValueAt(fila, 3).toString());
//     jtDescripcion.setText(jtTablaHabitaciones.getValueAt(fila, 4).toString());
//     jrEstado.setText(jtTablaHabitaciones.getValueAt(fila, 5).toString());

    }//GEN-LAST:event_jtHuespedMouseClicked

    private void jtSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtSalirActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);

    }//GEN-LAST:event_jtSalirActionPerformed

    private void jtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtIdActionPerformed

    private void jbNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevoActionPerformed
        // TODO add your handling code here:
        habilitar();
        jbGuardar.setText("guardar");
        accion = "guardar";
    }//GEN-LAST:event_jbNuevoActionPerformed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        // TODO add your handling code here:

        if (!jtId.getText().equals("")) {
            int confirmaeliminar = JOptionPane.showConfirmDialog(null, "estas seguro de eliminar registro", "confirmar", 2);

            if (confirmaeliminar == 0) {
                HuespedData hd = new HuespedData();
                Huesped huesped = new Huesped();

                huesped.setIdHuesped(Integer.parseInt(jtId.getText()));
                hd.eliminarTotalHuesped(huesped);
                mostrar("");
                inhabilitar();

            }
        }
    }//GEN-LAST:event_jbEliminarActionPerformed

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        // TODO add your handling code here:
        //        jbGuardar.setEnabled(true);
        if (jtDocumento.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "debes ingresar el numero de documento");
            jtDocumento.requestFocus();
            return;
        }
        System.out.println("1");
        if (jtApellido.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "debes ingresar el apellido");
            jtApellido.requestFocus();
            return;
        }

        if (jtNombre.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "debes ingresar el nombre");
            jtNombre.requestFocus();
            return;
        }

        if (jtDomicilio.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "debes ingresar el domicilio");
            jtDomicilio.requestFocus();
            return;
        }

        if (jtTelefono.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "debes ingresar el telefono");
            jtTelefono.requestFocus();
            return;
        }

        if (jtCorreo.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "debes ingresar el correo");
            jtCorreo.requestFocus();
            return;
        }

        
        System.out.println("tipodedocumento"+cboxTipodoc.getSelectedItem().toString());
        
        if (accion.equals("guardar")) {
            HuespedData hd=new HuespedData();
            Huesped huesped2=new Huesped();
            huesped2.setNumDocumento(jtDocumento.getText());
        huesped2.setApellido(jtApellido.getText());
        huesped2.setNombre(jtNombre.getText());
        huesped2.setDomicilio(jtDomicilio.getText());
        huesped2.setCelular(jtTelefono.getText());
        huesped2.setCorreo(jtCorreo.getText());
        huesped2.setEstado(jrEstado.isSelected());
        huesped2.setCancelacion(jrCancelacion.isSelected());
        huesped2.setTipoDocumento(cboxTipodoc.getSelectedItem().toString());
            
            if (hd.guardarHuesped1(huesped2)) {
                JOptionPane.showMessageDialog(null, "huesped creado exitosamente");
                mostrar("");//muestra todos los registros
                inhabilitar();

            }

        
        } else if (!accion.equals("guardar")) {
            
            
            Huesped huesped = new Huesped();
        HuespedData hd = new HuespedData();

        //           huesped.setTipoDocumento(cboxTipodoc.getSelectedIndex()+"");
        huesped.setIdHuesped(Integer.parseInt(jtId.getText()));///cambio
        int selecciontipo = cboxTipodoc.getSelectedIndex();
//        huesped.setTipoDocumento((String) cboxTipodoc.getItemAt(selecciontipo));
        huesped.setNumDocumento(jtDocumento.getText());
        huesped.setApellido(jtApellido.getText());
        huesped.setNombre(jtNombre.getText());
        huesped.setDomicilio(jtDomicilio.getText());
        huesped.setCelular(jtTelefono.getText());
        huesped.setCorreo(jtCorreo.getText());
        huesped.setEstado(jrEstado.isSelected());
        huesped.setCancelacion(jrCancelacion.isSelected());
        huesped.setTipoDocumento(cboxTipodoc.getSelectedItem().toString());

//            huesped.setNumDocumento(jtDocumento.getText());

            if (hd.modificarHuesped3(huesped)) {
                JOptionPane.showMessageDialog(null, "huesped modificado exitosamente");
                mostrar("");
                inhabilitar();
            }

        }

    }//GEN-LAST:event_jbGuardarActionPerformed

    private void jtApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtApellidoActionPerformed
        // TODO add your handling code here:
        jtApellido.transferFocus();
    }//GEN-LAST:event_jtApellidoActionPerformed

    private void jtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtNombreActionPerformed
        // TODO add your handling code here:
        jtNombre.transferFocus();
    }//GEN-LAST:event_jtNombreActionPerformed

    private void jtDomicilioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtDomicilioActionPerformed
        jtDomicilio.transferFocus();        // TODO add your handling code here:
    }//GEN-LAST:event_jtDomicilioActionPerformed

    private void jtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtTelefonoActionPerformed
        // TODO add your handling code here:
        jtTelefono.transferFocus();
    }//GEN-LAST:event_jtTelefonoActionPerformed

    private void jtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtCorreoActionPerformed
        // TODO add your handling code here:
        jtCorreo.transferFocus();
    }//GEN-LAST:event_jtCorreoActionPerformed

    private void cboxTipodocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxTipodocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboxTipodocActionPerformed

    private void jrEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrEstadoActionPerformed
        // TODO add your handling code here:
        jrEstado.transferFocus();
    }//GEN-LAST:event_jrEstadoActionPerformed

    private void jtApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtApellidoKeyTyped
        // TODO add your handling code here:
       if (!Character.isLetter(evt.getKeyChar()) && evt.getKeyChar() != ' ') { // Permite escribir SOLo caracteres y espacios
            evt.consume();
        }
    }//GEN-LAST:event_jtApellidoKeyTyped

    private void jtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtNombreKeyTyped
        // TODO add your handling code here:
       
        if (!Character.isLetter(evt.getKeyChar()) && evt.getKeyChar() != ' ') { // Permite escribir SOLo caracteres y espacios
            evt.consume();
        }
//        char c=evt.getKeyChar();
//        if (!(Character.isLetter(c))) {
//            evt.consume();
//            
//        }
    }//GEN-LAST:event_jtNombreKeyTyped

    private void jtDomicilioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtDomicilioKeyTyped
        // TODO add your handling code here:
        if (!Character.isLetter(evt.getKeyChar()) && evt.getKeyChar() != ' ') { // Permite escribir SOLo caracteres y espacios
            evt.consume();
        }
    }//GEN-LAST:event_jtDomicilioKeyTyped

    private void jtDocumentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtDocumentoKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if (!(Character.isDigit(c))) {
            evt.consume();
           
        }
    }//GEN-LAST:event_jtDocumentoKeyTyped

    private void jtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtTelefonoKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if (!(Character.isDigit(c))) {
            evt.consume();
           
        }
    }//GEN-LAST:event_jtTelefonoKeyTyped

    private void jtBusquedaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtBusquedaKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if (!(Character.isDigit(c))) {
            evt.consume();
           
        }
    }//GEN-LAST:event_jtBusquedaKeyTyped

    private void jtCorreoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtCorreoKeyTyped
        // TODO add your handling code here:
        char c= evt.getKeyChar();
        
        if(!(Character.isDigit(c) || c=='.'||Character.isLetter(c)||c=='@') ){
            evt.consume();
        }
    }//GEN-LAST:event_jtCorreoKeyTyped

    private void jtIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtIdKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if (Character.isDigit(c)||Character.isLetter(c)) {
            evt.consume();
            
        }
    }//GEN-LAST:event_jtIdKeyTyped

    private void jtHuespedKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtHuespedKeyTyped
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jtHuespedKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cboxTipodoc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbNuevo;
    private javax.swing.JLabel jlTotal;
    private javax.swing.JRadioButton jrCancelacion;
    private javax.swing.JRadioButton jrEstado;
    private javax.swing.JTextField jtApellido;
    private javax.swing.JTextField jtBusqueda;
    private javax.swing.JTextField jtCorreo;
    private javax.swing.JTextField jtDocumento;
    private javax.swing.JTextField jtDomicilio;
    private javax.swing.JTable jtHuesped;
    private javax.swing.JTextField jtId;
    private javax.swing.JTextField jtNombre;
    private javax.swing.JButton jtSalir;
    private javax.swing.JTextField jtTelefono;
    // End of variables declaration//GEN-END:variables
//private void armarCabecera(){
//    modelo.addColumn("ID");
//    modelo.addColumn("Tipo Documento");
//    modelo.addColumn("Numero");
//    modelo.addColumn("Apellido");
//    modelo.addColumn("Nombre");
//    modelo.addColumn("Domicilio");
//    modelo.addColumn("Telefono");
//    modelo.addColumn("Correo");
//    modelo.addColumn("Estado");
//    modelo.addColumn("Cancelación");
//    jtHuesped.setModel(modelo);
//    
//}

//    private void cargarCombo(){
//        cboxTipo.addItem(new Huesped("tipoDocumento")+"");
//    }
}

/////////////////

