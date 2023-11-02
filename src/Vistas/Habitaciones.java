package Vistas;

import AccesoDatos.HabitacionData;
import AccesoDatos.TipoHabitacionData;
import Entidades.Habitacion;
import Entidades.TipoHabitacion;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Habitaciones extends javax.swing.JPanel {

    public Habitaciones() {
        initComponents();
        mostrar("");
        inhabilitar();
        llenarcomboBox();
    }
    private String accion = "guardar";//cramos una variable para inicializar la obcion de guardar/editar con guardar

    public void llenarcomboBox() {
        jComboBox1.removeAllItems();
        TipoHabitacionData thd = new TipoHabitacionData();
        TipoHabitacion hab = null;
        List<TipoHabitacion> habs = thd.listarTipoHabitaciones();

        for (TipoHabitacion aux : habs) {//itera a traves de la lista y agrega cada materia al combobox
            jComboBox1.addItem(aux);
        }
    }

    void ocultar_columnas() {//ocultar columnas que no quiero mostrar ej: idHabitacion
        jtTablaHabitaciones.getColumnModel().getColumn(0).setMaxWidth(0);//la columna 0 tiene un maximo de ancho de 0
        jtTablaHabitaciones.getColumnModel().getColumn(0).setMinWidth(0);//la columna 0 tiene un minimo de ancho de 0
        jtTablaHabitaciones.getColumnModel().getColumn(0).setPreferredWidth(0);//ancho preferido en 0
    }

    void inhabilitar() {//procedimiento para deshabilitar botones y cajas de texto para algunas operaciones
        jtIdHabitacion.setVisible(false);
        jcCategoria.setEnabled(false);
        jtNumero.setEnabled(false);
        jtDescripcion.setVisible(false);
        jlEstado.setVisible(false);
        jrEstado.setVisible(false);
        jbGuardar.setVisible(false);
        jbEliminar.setVisible(false);
        jbSalir.setVisible(true);
        jtIdHabitacion.setText("");
        jtNumero.setText("");
        jtDescripcion.setText("");
        jComboBox1.setEnabled(false);
    }

    void habilitar() {

        jtIdHabitacion.setVisible(true);
        jcCategoria.setEnabled(true);
        jtNumero.setEnabled(true);
        jtDescripcion.setVisible(true);
        jlEstado.setVisible(true);
        jrEstado.setVisible(true);
        jbNuevo.setVisible(true);
        jbGuardar.setVisible(true);
        jbBuscar.setVisible(true);
        jbEliminar.setVisible(true);
        jbSalir.setVisible(true);
        jtIdHabitacion.setText("");
        jtNumero.setText("");
        jtDescripcion.setText("");
        jComboBox1.setEnabled(true);

    }

    void mostrar(String buscar) {//procedimiento para mostrar de acuerdo a la busqueda
        try {
            DefaultTableModel modelo;
            HabitacionData func = new HabitacionData();
            modelo = func.mostrar(buscar);//el resultado de buscar lo almaceno en mi variable modelo

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

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jlCategoria = new javax.swing.JLabel();
        jcCategoria = new javax.swing.JComboBox<>();
        jlNumero = new javax.swing.JLabel();
        jlDescripción = new javax.swing.JLabel();
        jbNuevo = new javax.swing.JButton();
        jbGuardar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtDescripcion = new javax.swing.JTextArea();
        jtNumero = new javax.swing.JTextField();
        jtIdHabitacion = new javax.swing.JTextField();
        jrEstado = new javax.swing.JRadioButton();
        jlEstado = new javax.swing.JLabel();
        jlID = new javax.swing.JLabel();
        jbEliminar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtTablaHabitaciones = new javax.swing.JTable();
        jlBuscar = new javax.swing.JLabel();
        jTbuscar = new javax.swing.JTextField();
        jbBuscar = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        jlTotalRegistros = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Dialog", 2, 18)); // NOI18N
        jLabel1.setText("Habitación");

        jPanel1.setBackground(new java.awt.Color(153, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registro de habitaciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 16), new java.awt.Color(0, 0, 153))); // NOI18N

        jlCategoria.setBackground(new java.awt.Color(51, 51, 51));
        jlCategoria.setText("Categoria");

        jcCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Estandar Simple", "Doble", "Triple", "Suit Lujo" }));
        jcCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcCategoriaActionPerformed(evt);
            }
        });

        jlNumero.setText("Número");

        jlDescripción.setText("Descripción ");

        jbNuevo.setBackground(new java.awt.Color(255, 153, 153));
        jbNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/nuevo.png"))); // NOI18N
        jbNuevo.setText("Nuevo");
        jbNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNuevoActionPerformed(evt);
            }
        });

        jbGuardar.setBackground(new java.awt.Color(255, 153, 153));
        jbGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/modificar.png"))); // NOI18N
        jbGuardar.setText("Gurdar");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        jtDescripcion.setColumns(20);
        jtDescripcion.setRows(5);
        jScrollPane1.setViewportView(jtDescripcion);

        jtNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtNumeroActionPerformed(evt);
            }
        });
        jtNumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtNumeroKeyTyped(evt);
            }
        });

        jtIdHabitacion.setEditable(false);

        jrEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrEstadoActionPerformed(evt);
            }
        });

        jlEstado.setText("Estado");

        jlID.setText("ID");

        jbEliminar.setBackground(new java.awt.Color(204, 255, 204));
        jbEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminar.png"))); // NOI18N
        jbEliminar.setText("Eliminar");
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });

        jLabel3.setText("Tipo hab");

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlNumero)
                            .addComponent(jlCategoria))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(52, 52, 52)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jlID, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jtIdHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jlDescripción)
                                    .addGap(48, 48, 48)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jbNuevo)
                                .addGap(18, 18, 18)
                                .addComponent(jbGuardar)
                                .addGap(39, 39, 39)
                                .addComponent(jbEliminar)))
                        .addContainerGap(16, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jlEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jrEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jcCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlCategoria)
                            .addComponent(jcCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtIdHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlID))
                        .addGap(49, 49, 49)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlNumero)
                    .addComponent(jtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlDescripción)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jrEstado)
                    .addComponent(jlEstado))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbNuevo)
                    .addComponent(jbGuardar)
                    .addComponent(jbEliminar))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Listado de habitaciones"));
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
        jtTablaHabitaciones.setEnabled(false);
        jtTablaHabitaciones.setPreferredSize(new java.awt.Dimension(350, 64));
        jtTablaHabitaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtTablaHabitacionesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtTablaHabitaciones);

        jlBuscar.setText("Buscar por:");

        jTbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTbuscarKeyTyped(evt);
            }
        });

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

        jLabel2.setText("No.Habitación");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(175, 175, 175)
                .addComponent(jbSalir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jbBuscar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jlTotalRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 17, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlBuscar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2))
                    .addComponent(jbBuscar))
                .addGap(48, 48, 48)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addComponent(jbSalir)
                .addGap(26, 26, 26)
                .addComponent(jlTotalRegistros)
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed

        if (jtNumero.getText().length() == 0) {//no ha ingresado nada

            JOptionPane.showMessageDialog(null, "debes ingresar un numero de habitacion");
            jtNumero.requestFocus();
            return;
        }
        if (jtDescripcion.getText().length() == 0) {

            JOptionPane.showMessageDialog(null, "debes ingresar una descripcion para la habitacion");
            jtDescripcion.requestFocus();
            return;
        }
        Habitacion habitacion = new Habitacion();
        HabitacionData func = new HabitacionData();

        habitacion.setNumHabitacion(jtNumero.getText());
        
        Object selectobj = jComboBox1.getSelectedItem();
        TipoHabitacion th = (TipoHabitacion) selectobj;
        
        habitacion.setIdTipoHab(th.getIdTipoHab());
        
        String seleccateg = (String) jcCategoria.getSelectedItem();
        
        habitacion.setCategoriaHabitacion(seleccateg);
        habitacion.setDescripcion(jtDescripcion.getText());
        habitacion.setEstado(jrEstado.isSelected());

        if (accion.equals("guardar")) {//condicio para gurdar o modificar,si accion es igual a (guradar) guarda. 
            if (func.guardarHabitacion(habitacion)) {
                JOptionPane.showMessageDialog(null, "habitacion creada exitosamente");
                mostrar("");//muestra todos los registros
                inhabilitar();

            }

        } else if (accion.equals("modificar")) {//si la accion es modificar
            habitacion.setIdHabitacion(Integer.parseInt(jtIdHabitacion.getText()));

            if (func.modificarHabitacion(habitacion)) {
                JOptionPane.showMessageDialog(null, "habitacion modificada exitosamente");
                mostrar("");
                inhabilitar();
            }

        }


    }//GEN-LAST:event_jbGuardarActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        this.setVisible(false);

    }//GEN-LAST:event_jbSalirActionPerformed

    private void jbNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevoActionPerformed
        habilitar();
        jbGuardar.setText("guardar");
        accion = "guardar";


    }//GEN-LAST:event_jbNuevoActionPerformed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed

        if (!jtIdHabitacion.getText().equals("")) {//si no esta vacio el campo continuar para eliminar la habitacion.

            int confielim = JOptionPane.showConfirmDialog(null, "esta seguro de eliminar la habitacion?", "confirmar", 2);
            if (confielim == 0) {//procedo a eliminar
                HabitacionData func = new HabitacionData();
                Habitacion habitacion = new Habitacion();//obtenemos todos los valores
                habitacion.setIdHabitacion(Integer.parseInt(jtIdHabitacion.getText()));
                func.eliminarHabitacion(habitacion);
                mostrar("");
                inhabilitar();

            }

        }

    }//GEN-LAST:event_jbEliminarActionPerformed

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed

        if (jTbuscar.getText().length() == 0) {//no ha ingresado nada

            JOptionPane.showMessageDialog(null, "debe ingresar un numero de habitación");
            jTbuscar.requestFocus();
            return;

        }
        mostrar(jTbuscar.getText());
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jtNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtNumeroActionPerformed
        jtNumero.transferFocus();

    }//GEN-LAST:event_jtNumeroActionPerformed

    private void jrEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrEstadoActionPerformed
        jrEstado.transferFocus();

    }//GEN-LAST:event_jrEstadoActionPerformed

    private void jtTablaHabitacionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtTablaHabitacionesMouseClicked
        //aqui pasamos lo que esta en la tabla a cada uno de los campos
        jbGuardar.setText("modificar");//cambio mi boton gurdar por modificar,
        habilitar();//habilito todas las cajas de texto
        jbEliminar.setEnabled(true);//eliminar habilitado
        accion = "modificar";

        int fila = jtTablaHabitaciones.rowAtPoint(evt.getPoint());//almacena de la tabla al estado de cada caja de texto

        jtIdHabitacion.setText(jtTablaHabitaciones.getValueAt(fila, 0).toString());
        jtNumero.setText(jtTablaHabitaciones.getValueAt(fila, 1).toString());
        jrEstado.setText(jtTablaHabitaciones.getValueAt(fila, 2).toString());
        jcCategoria.setSelectedItem(jtTablaHabitaciones.getValueAt(fila, 3));
        jtDescripcion.setText(jtTablaHabitaciones.getValueAt(fila, 4).toString());


    }//GEN-LAST:event_jtTablaHabitacionesMouseClicked

    private void jcCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcCategoriaActionPerformed
        jcCategoria.transferFocus();

    }//GEN-LAST:event_jcCategoriaActionPerformed

    private void jtNumeroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtNumeroKeyTyped
        char c = evt.getKeyChar();//codigo para solo mostrar numeros
        if (!(Character.isDigit(c))) {
            evt.consume();

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtNumeroKeyTyped

    private void jTbuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTbuscarKeyTyped
        char c = evt.getKeyChar();//codigo para solo mostrar numeros
        if (!(Character.isDigit(c))) {
            evt.consume();

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jTbuscarKeyTyped

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<TipoHabitacion> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTbuscar;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbNuevo;
    private javax.swing.JButton jbSalir;
    private javax.swing.JComboBox<String> jcCategoria;
    private javax.swing.JLabel jlBuscar;
    private javax.swing.JLabel jlCategoria;
    private javax.swing.JLabel jlDescripción;
    private javax.swing.JLabel jlEstado;
    private javax.swing.JLabel jlID;
    private javax.swing.JLabel jlNumero;
    private javax.swing.JLabel jlTotalRegistros;
    private javax.swing.JRadioButton jrEstado;
    private javax.swing.JTextArea jtDescripcion;
    private javax.swing.JTextField jtIdHabitacion;
    private javax.swing.JTextField jtNumero;
    private javax.swing.JTable jtTablaHabitaciones;
    // End of variables declaration//GEN-END:variables

}
