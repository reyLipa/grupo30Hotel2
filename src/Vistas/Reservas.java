package Vistas;

import AccesoDatos.HabitacionData;
import AccesoDatos.HuespedData;
import AccesoDatos.ReservaData;
import Entidades.Habitacion;
import Entidades.Huesped;
import Entidades.Reserva;
import com.toedter.calendar.JDateChooser;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Reservas extends javax.swing.JPanel {

    public Reservas() {
        initComponents();
        mostrar("");
        inhabilitar();
        cargarDias();
    }
    private String accion = "guardar";//cramos una variable para inicializar la obcion de guardar/editar con guardar

    void ocultar_columnas() {//ocultar columnas que no quiero mostrar ej: idHabitacion
        //oculto la columna 0=ID Reserva
        jtTablaReservas.getColumnModel().getColumn(0).setMaxWidth(0);//la columna 0 tiene un maximo de ancho de 0
        jtTablaReservas.getColumnModel().getColumn(0).setMinWidth(0);//la columna 0 tiene un minimo de ancho de 0
        jtTablaReservas.getColumnModel().getColumn(0).setPreferredWidth(0);//ancho preferido en 0
        //oculto la columna 1=ID Húesped
        jtTablaReservas.getColumnModel().getColumn(1).setMaxWidth(1);//la columna 0 tiene un maximo de ancho de 0
        jtTablaReservas.getColumnModel().getColumn(1).setMinWidth(1);//la columna 0 tiene un minimo de ancho de 0
        jtTablaReservas.getColumnModel().getColumn(1).setPreferredWidth(1);//ancho preferido en 0
        //oculto la columna 2=ID Habitación
        jtTablaReservas.getColumnModel().getColumn(3).setMaxWidth(3);//la columna 0 tiene un maximo de ancho de 0
        jtTablaReservas.getColumnModel().getColumn(3).setMinWidth(3);//la columna 0 tiene un minimo de ancho de 0
        jtTablaReservas.getColumnModel().getColumn(3).setPreferredWidth(3);//ancho preferido en 0

    }

    void inhabilitar() {//procedimiento para deshabilitar botones y cajas de texto para algunas operaciones
        jtIDReserva.setVisible(false);
        jtIDHabitacion.setEnabled(false);
        jtNumero.setEnabled(false);
        jtIDHuesped.setEnabled(false);
        jtNombreHuesped.setEnabled(false);
        jtTipoHabitacion.setEnabled(false);
        jtPrecioHabitacion.setEnabled(false);
        jCCantPersonas.setVisible(false);
        jdFReserva.setVisible(false);
        jdFEntrada.setVisible(false);
        jdFSalida.setVisible(false);
        jcTipoReserva.setVisible(false);
        jtPago.setVisible(false);
        jcEstado.setVisible(false);

        jbBuscarHabitacion.setVisible(false);
        jbBuscarHuesped.setVisible(false);
        jbGuardar.setVisible(false);
        //jbBuscar.setVisible(false);
        jbEliminar.setVisible(false);
        jbSalir.setVisible(true);

        jtIDReserva.setText("");
        jtIDHabitacion.setText("");
        jtNumero.setText("");
        jtIDHuesped.setText("");
        jtNombreHuesped.setText("");
        jtTipoHabitacion.setText("");
        jtPrecioHabitacion.setText("");

    }

    void habilitar() {

        jtIDReserva.setVisible(true);
        jtIDHabitacion.setVisible(true);
        // jtIDHabitacion.setEnabled(false);
        jtNumero.setEnabled(false);
        jtIDHuesped.setEnabled(false);
        jtNombreHuesped.setEnabled(false);
        jtTipoHabitacion.setEnabled(true);
        jtPrecioHabitacion.setEnabled(true);
        jCCantPersonas.setVisible(true);
        jdFReserva.setVisible(true);
        jdFEntrada.setVisible(true);
        jdFSalida.setVisible(true);
        jcTipoReserva.setVisible(true);
        jtPago.setVisible(true);
        jcEstado.setVisible(true);

        jbBuscarHabitacion.setVisible(true);
        jbBuscarHuesped.setVisible(true);
        jbGuardar.setVisible(true);
        //jbBuscar.setVisible(false);
        jbEliminar.setVisible(true);
        jbSalir.setVisible(true);

        jtIDReserva.setText("");
        jtIDHabitacion.setText("");
        jtNumero.setText("");
        jtIDHuesped.setText("");
        jtNombreHuesped.setText("");
        jtTipoHabitacion.setText("");
        jtPrecioHabitacion.setText("");
        //jtCanPersonas.setText("");
    }

    void mostrar(String buscar) {//procedimiento para mostrar de acuerdo a la busqueda
        try {
            DefaultTableModel modelo;
            ReservaData func = new ReservaData();
            modelo = func.mostrar(buscar);//el resultado de buscar lo almaceno en mi variable modelo

            jtTablaReservas.setModel(modelo);//le envio a la tabla lo que obtengo con el modelo
            ocultar_columnas();
            jlTotalRegistros.setText("Total de registros" + Integer.toString(func.totalregistros));
        } catch (Exception e) {

            JOptionPane.showConfirmDialog(null, "Errro en el procedimiento mostrar juan");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jlCategoria = new javax.swing.JLabel();
        jlNumero = new javax.swing.JLabel();
        jlDescripción = new javax.swing.JLabel();
        jbNuevo = new javax.swing.JButton();
        jbGuardar = new javax.swing.JButton();
        jtIDHuesped = new javax.swing.JTextField();
        jlEstado = new javax.swing.JLabel();
        jlID = new javax.swing.JLabel();
        jbEliminar = new javax.swing.JButton();
        jtIDHabitacion = new javax.swing.JTextField();
        jdFReserva = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jdFSalida = new com.toedter.calendar.JDateChooser();
        jdFEntrada = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jcEstado = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jtPago = new javax.swing.JTextField();
        jtNombreHuesped = new javax.swing.JTextField();
        jtNumero = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jtIDReserva = new javax.swing.JTextField();
        jcTipoReserva = new javax.swing.JComboBox<>();
        jbBuscarHuesped = new javax.swing.JButton();
        jbBuscarHabitacion = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jtTotalDias = new javax.swing.JTextField();
        jCCantPersonas = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jtTipoHabitacion = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jtPrecioHabitacion = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtTablaReservas = new javax.swing.JTable();
        jlBuscar = new javax.swing.JLabel();
        jTbuscar = new javax.swing.JTextField();
        jbBuscar = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        jlTotalRegistros = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(987, 498));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Dialog", 2, 18)); // NOI18N
        jLabel1.setText("Reserva");

        jPanel1.setBackground(new java.awt.Color(153, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registro de Reservas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 51, 51))); // NOI18N

        jlCategoria.setBackground(new java.awt.Color(51, 51, 51));
        jlCategoria.setText("Habitacion No");

        jlNumero.setText("Nombre Huesped ");

        jlDescripción.setText("Cant.Personas");

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

        jtIDHuesped.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtIDHuespedActionPerformed(evt);
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

        jLabel2.setText("F.Entrada");

        jLabel4.setText("F.Salida");

        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("TipoReserva");

        jcEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Alquiler", "Pagada", "Anulada", " " }));
        jcEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcEstadoActionPerformed(evt);
            }
        });

        jLabel6.setText("Pago Total $");

        jtNombreHuesped.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtNombreHuespedActionPerformed(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("F.Reserva");

        jtIDReserva.setEditable(false);

        jcTipoReserva.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Por confirmar", "conformimada" }));
        jcTipoReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcTipoReservaActionPerformed(evt);
            }
        });

        jbBuscarHuesped.setText("....");
        jbBuscarHuesped.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarHuespedActionPerformed(evt);
            }
        });

        jbBuscarHabitacion.setText("....");
        jbBuscarHabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarHabitacionActionPerformed(evt);
            }
        });

        jLabel3.setText("ID");

        jLabel8.setText("ID");

        jLabel9.setText("Total días");

        jCCantPersonas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));

        jLabel10.setText("Tipo de habitación");

        jButton1.setText(".....");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel11.setText("$");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jdFReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jdFEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jlDescripción)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(45, 45, 45)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jdFSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jlNumero)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jtNombreHuesped, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jlID, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(75, 75, 75)
                                .addComponent(jtIDReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(88, 88, 88)))
                        .addComponent(jtIDHuesped, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbBuscarHuesped)
                        .addGap(4, 4, 4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jlCategoria)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(jtIDHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCCantPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jtTipoHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(22, 22, 22))
                                            .addComponent(jtPrecioHabitacion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbBuscarHabitacion)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jbNuevo)
                        .addGap(67, 67, 67)
                        .addComponent(jbGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbEliminar)
                        .addGap(22, 22, 22))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jlEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(jLabel5))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtTotalDias, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(89, 89, 89)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jtPago, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jcTipoReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlID)
                    .addComponent(jtIDReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlNumero)
                    .addComponent(jtNombreHuesped, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtIDHuesped, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscarHuesped, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlCategoria)
                    .addComponent(jtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jtIDHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscarHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(jtTipoHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)
                        .addComponent(jtPrecioHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlDescripción)
                            .addComponent(jCCantPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 23, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jdFEntrada, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jdFReserva, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(20, 20, 20)
                        .addComponent(jdFSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlEstado)
                    .addComponent(jcEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jcTipoReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jtTotalDias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jtPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbNuevo)
                    .addComponent(jbGuardar)
                    .addComponent(jbEliminar))
                .addGap(20, 20, 20))
        );

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Listado de Reservas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 51, 51))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(255, 204, 204));

        jtTablaReservas.setModel(new javax.swing.table.DefaultTableModel(
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
        jtTablaReservas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtTablaReservasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtTablaReservas);

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
                        .addGap(0, 0, Short.MAX_VALUE)))
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevoActionPerformed
        habilitar();
        jbGuardar.setText("guardar");
        accion = "guardar";

    }//GEN-LAST:event_jbNuevoActionPerformed

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed

        if (jtIDHabitacion.getText().length() == 0) {//no ha ingresado nada

            JOptionPane.showMessageDialog(null, "debe seleccionar una habitación ");
            jtIDHabitacion.requestFocus();
            return;
        }
        if (jtIDHuesped.getText().length() == 0) {

            JOptionPane.showMessageDialog(null, "debe seleccionar un huesped");
            jtIDHuesped.requestFocus();
            return;
             }
             
            if (jtPago.getText().length() == 0) {

                JOptionPane.showMessageDialog(null, "debe ingresar un precio");
                jtPago.requestFocus();
                return;

            }
            Reserva reserva = new Reserva();
            ReservaData func = new ReservaData();

            reserva.setIdHuesped(Integer.parseInt(jtIDHuesped.getText()));
            reserva.setIdHabitacion(Integer.parseInt(jtIDHabitacion.getText()));

            int seleCanPer = jCCantPersonas.getSelectedIndex();//revisar
            reserva.setCantPersonas(jCCantPersonas.getItemAt(seleCanPer));

            Calendar cale;
            int d, m, a;
            cale = jdFReserva.getCalendar();
            d = cale.get(Calendar.DAY_OF_MONTH);
            m = cale.get(Calendar.MONTH);
            a = cale.get(Calendar.YEAR) - 1999;//obtener una fecha correcta
            reserva.setFechaReserva(new Date(d, m, d));

            cale = jdFEntrada.getCalendar();
            d = cale.get(Calendar.DAY_OF_MONTH);
            m = cale.get(Calendar.MONTH);
            a = cale.get(Calendar.YEAR) - 1999;//obtener una fecha correcta
            reserva.setFechaEntrada(new Date(d, m, d));

            cale = jdFSalida.getCalendar();
            d = cale.get(Calendar.DAY_OF_MONTH);
            m = cale.get(Calendar.MONTH);
            a = cale.get(Calendar.YEAR) - 1999;//obtener una fecha correcta
            reserva.setFechaSalida(new Date(d, m, d));
            int selectipor = jcTipoReserva.getSelectedIndex();
            reserva.setTipoReserva(jcTipoReserva.getItemAt(selectipor));

            int selecestado = jcEstado.getSelectedIndex();
            reserva.setEstado(jcEstado.getItemAt(selecestado));

            int selecTipoR = jcTipoReserva.getSelectedIndex();
            reserva.setEstado(jcTipoReserva.getItemAt(selecTipoR));

            // reserva.setTotalDias(Integer.parseInt(jtTotalDias.getText()));
            reserva.setPago(Integer.parseInt(jtPago.getText()));

            if (accion.equals("guardar")) {//condicio para gurdar o modificar,si accion es igual a (guradar) guarda. 
                if (func.guardarReserva(reserva)) {
                    JOptionPane.showMessageDialog(null, "reserva creada exitosamente");
                    mostrar("");//muestra todos los registros
                    inhabilitar();

                }

            } else if (accion.equals("modificar")) {//si la accion es modificar
                reserva.setIdReserva(Integer.parseInt(jtIDReserva.getText()));

                if (func.modificarReserva(reserva)) {
                    JOptionPane.showMessageDialog(null, "reserva modificada exitosamente");
                    mostrar("");
                    inhabilitar();
                }

            }

    }//GEN-LAST:event_jbGuardarActionPerformed


    private void jtIDHuespedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtIDHuespedActionPerformed

    }//GEN-LAST:event_jtIDHuespedActionPerformed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed

        if (!jtIDReserva.getText().equals("")) {//si no esta vacio el campo continuar para eliminar la habitacion.

            int confielim = JOptionPane.showConfirmDialog(null, "esta seguro de eliminar la reserva?", "confirmar", 2);
            if (confielim == 0) {//procedo a eliminar
                ReservaData func = new ReservaData();
                Reserva reserva = new Reserva();//obtenemos todos los valores
                reserva.setIdReserva(Integer.parseInt(jtIDReserva.getText()));
                func.eliminarReserva(reserva);
                mostrar("");
                inhabilitar();

            }

        }

    }//GEN-LAST:event_jbEliminarActionPerformed

    private void jtTablaReservasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtTablaReservasMouseClicked
        //aqui pasamos lo que esta en la tabla a cada uno de los campos
        jbGuardar.setText("modificar");//cambio mi boton gurdar por modificar,
        habilitar();//habilito todas las cajas de texto
        jbEliminar.setEnabled(true);//botón eliminar habilitado
        accion = "modificar";

        int fila = jtTablaReservas.rowAtPoint(evt.getPoint());//almacena de la tabla al estado de cada caja de texto

        jtIDReserva.setText(jtTablaReservas.getValueAt(fila, 0).toString());
        jtIDHuesped.setText(jtTablaReservas.getValueAt(fila, 1).toString());
        jtNombreHuesped.setText(jtTablaReservas.getValueAt(fila, 2).toString());
        jtIDHabitacion.setText(jtTablaReservas.getValueAt(fila, 3).toString());
        jtNumero.setText(jtTablaReservas.getValueAt(fila, 4).toString());
        jtTipoHabitacion.setText(jtTablaReservas.getValueAt(fila, 5).toString());
        jtPrecioHabitacion.setText(jtTablaReservas.getValueAt(fila, 6).toString());
        jCCantPersonas.setSelectedItem(jtTablaReservas.getValueAt(fila, 7).toString());
        jdFReserva.setDate(Date.valueOf(jtTablaReservas.getValueAt(fila, 8).toString()));
        jdFEntrada.setDate(Date.valueOf(jtTablaReservas.getValueAt(fila, 9).toString()));
        jdFSalida.setDate(Date.valueOf(jtTablaReservas.getValueAt(fila, 10).toString()));
        jcTipoReserva.setSelectedItem(jtTablaReservas.getValueAt(fila, 11).toString());
        jtPago.setText(jtTablaReservas.getValueAt(fila, 12).toString());//verificar
        jcEstado.setSelectedItem(jtTablaReservas.getValueAt(fila, 13).toString());


    }//GEN-LAST:event_jtTablaReservasMouseClicked

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

    private void jcEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcEstadoActionPerformed
        jcEstado.transferFocus();
    }//GEN-LAST:event_jcEstadoActionPerformed

    private void jcTipoReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcTipoReservaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcTipoReservaActionPerformed

    private void jbBuscarHabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarHabitacionActionPerformed
        ListadoHabitaciones listadahab = new ListadoHabitaciones();
        listadahab.toFront();
        listadahab.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jbBuscarHabitacionActionPerformed

    private void jbBuscarHuespedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarHuespedActionPerformed
        ListaHuespedes hues = new ListaHuespedes();
        hues.toFront();
        hues.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jbBuscarHuespedActionPerformed

    private void jtNombreHuespedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtNombreHuespedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtNombreHuespedActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ListadoTipoHabitaciones listatipoHab = new ListadoTipoHabitaciones();
        listatipoHab.toFront();
        listatipoHab.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jCCantPersonas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTbuscar;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbBuscarHabitacion;
    private javax.swing.JButton jbBuscarHuesped;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbNuevo;
    private javax.swing.JButton jbSalir;
    private javax.swing.JComboBox<String> jcEstado;
    private javax.swing.JComboBox<String> jcTipoReserva;
    private com.toedter.calendar.JDateChooser jdFEntrada;
    private com.toedter.calendar.JDateChooser jdFReserva;
    private com.toedter.calendar.JDateChooser jdFSalida;
    private javax.swing.JLabel jlBuscar;
    private javax.swing.JLabel jlCategoria;
    private javax.swing.JLabel jlDescripción;
    private javax.swing.JLabel jlEstado;
    private javax.swing.JLabel jlID;
    private javax.swing.JLabel jlNumero;
    private javax.swing.JLabel jlTotalRegistros;
    public static javax.swing.JTextField jtIDHabitacion;
    public static javax.swing.JTextField jtIDHuesped;
    private javax.swing.JTextField jtIDReserva;
    public static javax.swing.JTextField jtNombreHuesped;
    public static javax.swing.JTextField jtNumero;
    private javax.swing.JTextField jtPago;
    public static javax.swing.JTextField jtPrecioHabitacion;
    private javax.swing.JTable jtTablaReservas;
    public static javax.swing.JTextField jtTipoHabitacion;
    private javax.swing.JTextField jtTotalDias;
    // End of variables declaration//GEN-END:variables

    private void Oyente(JDateChooser jd) {//escucha al jdchooser y calcula los dias 
        jd.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent e) {
                try {
                    if (jd != null) {
                        cargarDias();
                    }
                } catch (NullPointerException ex) {
                    JOptionPane.showMessageDialog(null, "error " + jdFEntrada.toString() + ex.getMessage());
                }
            }
        });
    }

    public LocalDate StringALocalDate(String fecha) {//recibe String devuelve LocalDate
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate fechanueva = null;
        if (fecha != null) {
            fechanueva = LocalDate.parse(fecha, formato);
            return fechanueva;
        }

        return null;
    }

    public String obtenerFecha(JDateChooser jd) {
        SimpleDateFormat Formato = new SimpleDateFormat("dd-MM-yyyy");
        if (jd.getDate() != null) {
            return Formato.format(jd.getDate());
        }
        return null;
    }

    public void cargarDias() {//carga los dias cuando la fecha de entrada y salida no es nula
        ReservaData rd = new ReservaData();
        Oyente(jdFSalida);
        Oyente(jdFEntrada);
        if (jdFEntrada.getDate() != null && jdFSalida.getDate() != null) {

            String e = obtenerFecha(jdFEntrada);//estos son metodos 
            String s = obtenerFecha(jdFSalida);

            LocalDate entrada = StringALocalDate(e);
            LocalDate salida = StringALocalDate(s);

            int d = rd.calcularDias(entrada, salida);
            jtTotalDias.setText(d + "");

        }
    }

}
