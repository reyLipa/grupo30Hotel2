
package Vistas;

import AccesoDatos.HabitacionData;
import AccesoDatos.HuespedData;
import AccesoDatos.ReservaData;
import AccesoDatos.TipoHabitacionData;
import Entidades.Habitacion;
import Entidades.Huesped;
import Entidades.Reserva;
import com.toedter.calendar.JDateChooser;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class Reservas1 extends javax.swing.JPanel {

    
    public Reservas1() {
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

    private void inhabilitar() {//procedimiento para deshabilitar botones y cajas de texto para algunas operaciones
       jlIdRes.setVisible(false);
        jtIDReserva.setVisible(false);
        jlnumHab.setVisible(false);
        jtNumero.setEnabled(false);
        jlIdHab.setVisible(false);
        jtIDHabitacion.setEnabled(false);
        jbHuesped.setVisible(false);
        jtNombreHuesped.setEnabled(false);
        jtIDHuesped.setEnabled(false);
        jlReserva.setVisible(false);
        jdFReserva.setVisible(false);
        jlEntrada.setVisible(false);
        jdFEntrada.setVisible(false);
        jlSalida.setVisible(false);
        jdFSalida.setVisible(false);
        jlPersonas.setVisible(false);
        jtcantPersonas.setVisible(false);
        jlDias.setVisible(false);
        jCCantPersonas.setVisible(false);
        jlEstadia.setVisible(false);
        jtTotalDias.setVisible(false);
        jcTipoReserva.setVisible(false);
        jlCategoriaHabitacion.setVisible(false);
        jcTipoReserva.setVisible(false);
        jlCama.setVisible(false);
        jcCama.setVisible(false);
        jlPrecioNoche.setVisible(false);
        jtPrecioNoche.setVisible(false);
        jbTotal.setVisible(false);
        jtPago.setVisible(false);
        jrbEstado.setVisible(false);
        
       // jbBuscarHabitacion.setVisible(false);
       // jbBuscarHuesped.setVisible(false);
        jbGuardar.setVisible(false);
        //jbBuscar.setVisible(false);
        jbEliminar.setVisible(false);
        jbSalir.setVisible(true);
        

        jtIDReserva.setText("");
        jtIDHabitacion.setText("");
        jtNumero.setText("");
        jtIDHuesped.setText("");
        jtNombreHuesped.setText("");
        
        
        
        
    }

                
    void habilitar() {
        
           jlIdRes.setVisible(true);
        jtIDReserva.setVisible(true);
        jlnumHab.setVisible(true);
        jtNumero.setEnabled(true);
        jlIdHab.setVisible(true);
        jtIDHabitacion.setEnabled(true);
        jbHuesped.setVisible(true);
        jtNombreHuesped.setEnabled(true);
        jtIDHuesped.setEnabled(true);
        jlReserva.setVisible(true);
        jdFReserva.setVisible(true);
        jlEntrada.setVisible(true);
        jdFEntrada.setVisible(true);
        jlSalida.setVisible(true);
        jdFSalida.setVisible(true);
        jlPersonas.setVisible(true);
        jtcantPersonas.setVisible(true);
        jlDias.setVisible(true);
        jCCantPersonas.setVisible(true);
        jlEstadia.setVisible(true);
        jtTotalDias.setVisible(true);
        jcTipoReserva.setVisible(true);
        jlCategoriaHabitacion.setVisible(true);
        jcTipoReserva.setVisible(true);
        jlCama.setVisible(true);
        jcCama.setVisible(true);
        jlPrecioNoche.setVisible(true);
        jtPrecioNoche.setVisible(true);
        jbTotal.setVisible(true);
        jtPago.setVisible(true);
        jrbEstado.setVisible(true);
        
       // jbBuscarHabitacion.setVisible(false);
       // jbBuscarHuesped.setVisible(false);
        jbGuardar.setVisible(true);
        //jbBuscar.setVisible(false);
        jbEliminar.setVisible(true);
         jbSalir.setVisible(true);
        

        jtIDReserva.setText("");
        jtIDHabitacion.setText("");
        jtNumero.setText("");
        jtIDHuesped.setText("");
        jtNombreHuesped.setText("");
        
        
//       
//        jtIDReserva.setVisible(true);
//        jtIDHabitacion.setVisible(true);
//       // jtIDHabitacion.setEnabled(false);
//        jtNumero.setEnabled(false);
//        jtIDHuesped.setEnabled(false);
//        jtNombreHuesped.setEnabled(false);
//        jCCantPersonas.setVisible(true);
//        jdFReserva.setVisible(true);
//        jdFEntrada.setVisible(true);
//        jdFSalida.setVisible(true);
//        jcTipoReserva.setVisible(true);
//        jtPago.setVisible(true);
//        jcCama.setVisible(true);
//        
//       
//        jbGuardar.setVisible(true);
//        //jbBuscar.setVisible(false);
//        jbEliminar.setVisible(true);
//        jbSalir.setVisible(true);
//
//        jtIDReserva.setText("");
//        jtIDHabitacion.setText("");
//        jtNumero.setText("");
//        jtIDHuesped.setText("");
//        jtNombreHuesped.setText("");
//        //jtCanPersonas.setText("");
    }
    private void mostrar(String buscar) {//procedimiento para mostrar de acuerdo a la busqueda
        try {
            DefaultTableModel modelo;
            ReservaData func = new ReservaData();
            modelo = func.mostrar(buscar);//el resultado de buscar lo almaceno en mi variable modelo

            jtTablaReservas.setModel(modelo);//le envio a la tabla lo que obtengo con el modelo
            //ocultar_columnas();
            jlTotalRegistros.setText("Total de registros" + Integer.toString(func.totalregistros));
        } catch (Exception e) {

            JOptionPane.showConfirmDialog(null, "Errro en el procedimiento mostrar juan");
        }
    }
    void mostrarHabitaciones(String buscar,String Buscar) {//procedimiento para mostrar de acuerdo a la busqueda
        
        try {
            DefaultTableModel modelo;
            ReservaData func = new ReservaData();
            modelo = func.mostrarHabitaciones(buscar,Buscar);//el resultado de buscar lo almaceno en mi variable modelo

            jtTablaReservas.setModel(modelo);//le envio a la tabla lo que obtengo con el modelo
            //ocultar_columnas();
            jlTotalRegistros.setText("Total de registros" + Integer.toString(func.totalregistros));
        } catch (Exception e) {

            JOptionPane.showConfirmDialog(null, "Error en el procedimiento mostrar Habitaciones");
        }
    }
    
    
    void mostrarHuesped(String buscar) {//procedimiento para mostrar de acuerdo a la busqueda
        try {
            DefaultTableModel modelo;
            HuespedData func = new HuespedData();
            modelo = func.mostrarHuesped(buscar);//el resultado de buscar lo almaceno en mi variable modelo

            jtTablaReservas.setModel(modelo);//le envio a la tabla lo que obtengo con el modelo
            //ocultar_columnas();
            jlTotalRegistros.setText("Total de registros" + Integer.toString(func.totalregistros));
        } catch (Exception e) {

            JOptionPane.showConfirmDialog(null, "Error en el procedimiento mostrarHuesped  linea 152   "+e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jlnumHab = new javax.swing.JLabel();
        jbNuevo = new javax.swing.JButton();
        jbGuardar = new javax.swing.JButton();
        jtIDHuesped = new javax.swing.JTextField();
        jlIdRes = new javax.swing.JLabel();
        jbEliminar = new javax.swing.JButton();
        jtIDHabitacion = new javax.swing.JTextField();
        jdFReserva = new com.toedter.calendar.JDateChooser();
        jlEntrada = new javax.swing.JLabel();
        jlSalida = new javax.swing.JLabel();
        jdFSalida = new com.toedter.calendar.JDateChooser();
        jdFEntrada = new com.toedter.calendar.JDateChooser();
        jtPago = new javax.swing.JTextField();
        jtNombreHuesped = new javax.swing.JTextField();
        jtNumero = new javax.swing.JTextField();
        jlReserva = new javax.swing.JLabel();
        jtIDReserva = new javax.swing.JTextField();
        jcTipoReserva = new javax.swing.JComboBox<>();
        jlIdHab = new javax.swing.JLabel();
        jlDias = new javax.swing.JLabel();
        jtTotalDias = new javax.swing.JTextField();
        jlPersonas = new javax.swing.JLabel();
        jCCantPersonas = new javax.swing.JComboBox<>();
        jcCama = new javax.swing.JComboBox<>();
        jlPrecioNoche = new javax.swing.JLabel();
        jtPrecioNoche = new javax.swing.JTextField();
        jrbEstado = new javax.swing.JRadioButton();
        jlCama = new javax.swing.JLabel();
        jlCategoriaHabitacion = new javax.swing.JLabel();
        jlEstadia = new javax.swing.JLabel();
        jtcantPersonas = new javax.swing.JTextField();
        jbTotal = new javax.swing.JButton();
        jbHuesped = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtTablaReservas = new javax.swing.JTable();
        jlBuscar = new javax.swing.JLabel();
        jTbuscar = new javax.swing.JTextField();
        jbBuscar = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        jlTotalRegistros = new javax.swing.JLabel();

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTable2);

        setPreferredSize(new java.awt.Dimension(987, 498));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Dialog", 2, 18)); // NOI18N
        jLabel1.setText("Reserva");

        jPanel1.setBackground(new java.awt.Color(153, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registro de Reservas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 51, 51))); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(486, 385));

        jlnumHab.setBackground(new java.awt.Color(51, 51, 51));
        jlnumHab.setText("Habitacion No");

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
        jbGuardar.setText("Guardar");
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

        jlIdRes.setText("ID");

        jbEliminar.setBackground(new java.awt.Color(204, 255, 204));
        jbEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminar.png"))); // NOI18N
        jbEliminar.setText("Eliminar");
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });

        jlEntrada.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jlEntrada.setText("Entrada");

        jlSalida.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jlSalida.setText("Salida");

        jtPago.setText("$ 00.00");
        jtPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtPagoActionPerformed(evt);
            }
        });

        jtNombreHuesped.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtNombreHuespedActionPerformed(evt);
            }
        });

        jlReserva.setBackground(new java.awt.Color(0, 0, 0));
        jlReserva.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jlReserva.setText("Reserva");

        jtIDReserva.setEditable(false);

        jcTipoReserva.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ESTANDAR", "DOBLE", "TRIPLE", "SUIT_LUJO " }));
        jcTipoReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcTipoReservaActionPerformed(evt);
            }
        });

        jlIdHab.setText("ID");

        jlDias.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jlDias.setText("Dias");

        jtTotalDias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtTotalDiasActionPerformed(evt);
            }
        });

        jlPersonas.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jlPersonas.setText("Personas");

        jCCantPersonas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));

        jcCama.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SENCILLA", "QUEEN", "KING_SIZE" }));
        jcCama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcCamaActionPerformed(evt);
            }
        });

        jlPrecioNoche.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jlPrecioNoche.setText("Precio/Noche");

        jtPrecioNoche.setText("$ 00.00");
        jtPrecioNoche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtPrecioNocheActionPerformed(evt);
            }
        });

        jrbEstado.setText("Estado");

        jlCama.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jlCama.setText("Cama");

        jlCategoriaHabitacion.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jlCategoriaHabitacion.setText("Categoria");

        jlEstadia.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jlEstadia.setText("Estadia");

        jtcantPersonas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtcantPersonasActionPerformed(evt);
            }
        });

        jbTotal.setText("Total");
        jbTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbTotalActionPerformed(evt);
            }
        });

        jbHuesped.setText("HUESPED");
        jbHuesped.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbHuespedActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jlIdRes, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtIDReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jlnumHab)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jlIdHab, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtIDHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(jbHuesped)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtNombreHuesped, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlCategoriaHabitacion)
                                    .addComponent(jcTipoReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jdFReserva, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(38, 38, 38)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlCama)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jlEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(54, 54, 54)
                                        .addComponent(jlSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jdFEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jcCama, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jlReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(219, 219, 219)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jdFSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jlPrecioNoche, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jtPrecioNoche))))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jbTotal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtPago, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlPersonas)
                                    .addComponent(jtcantPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(66, 66, 66)
                                        .addComponent(jlDias, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(57, 57, 57)
                                        .addComponent(jCCantPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(55, 55, 55)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jrbEstado)
                            .addComponent(jlEstadia)
                            .addComponent(jtTotalDias, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbGuardar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jbEliminar, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jtIDHuesped, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbNuevo)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jbGuardar)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jlCategoriaHabitacion))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jrbEstado)
                            .addComponent(jbEliminar))))
                .addGap(0, 23, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlIdRes)
                    .addComponent(jtIDReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlnumHab)
                    .addComponent(jtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtIDHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlIdHab)
                    .addComponent(jtIDHuesped, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtNombreHuesped, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbHuesped, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jlEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jlReserva)
                                .addComponent(jlSalida))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jlPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jlDias))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlEstadia)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jdFSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jdFEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jdFReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCCantPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtTotalDias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jtcantPersonas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jlCama))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlPrecioNoche)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jcTipoReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jcCama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtPrecioNoche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbTotal)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Listado de Reservas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 51, 51))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(255, 204, 204));
        jPanel2.setPreferredSize(new java.awt.Dimension(486, 385));

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
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jlTotalRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(256, 256, 256)
                        .addComponent(jbBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jlBuscar)
                                .addGap(195, 195, 195)
                                .addComponent(jTbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 894, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(20, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlBuscar))
                .addGap(9, 9, 9)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlTotalRegistros)
                    .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addContainerGap(920, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 938, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 936, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
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
    }//GEN-LAST:event_jbGuardarActionPerformed
//    if (jCCantPersonas.getText().length() == 0) {
//
//            JOptionPane.showMessageDialog(null, "debe seleccionar cantidad de personas");
//            jtCanPersonas.requestFocus();
//            return;
//    } 
    if (jtPago.getText().length() == 0) {

            JOptionPane.showMessageDialog(null, "debe ingresar un precio");
            jtPago.requestFocus();
            return;
            
            
    }   Reserva reserva = new Reserva();
        ReservaData func = new ReservaData();
        
        reserva.setIdHuesped(Integer.parseInt(jtIDHuesped.getText()));
        reserva.setIdHabitacion(Integer.parseInt(jtIDHabitacion.getText()));
        
        
        int seleCanPer =jCCantPersonas.getSelectedIndex();//revisar
        reserva.setCantPersonas(jCCantPersonas.getItemAt(seleCanPer));
        
        Calendar cale;
        int d,m,a;
        cale=jdFReserva.getCalendar();
        d=cale.get(Calendar.DAY_OF_MONTH);
        m=cale.get(Calendar.MONTH);
        a=cale.get(Calendar.YEAR)-1999;//obtener una fecha correcta
        reserva.setFechaReserva(new Date(d,m,d));
        
        cale=jdFEntrada.getCalendar();
        d=cale.get(Calendar.DAY_OF_MONTH);
        m=cale.get(Calendar.MONTH);
        a=cale.get(Calendar.YEAR)-1999;//obtener una fecha correcta
        reserva.setFechaEntrada(new Date(d,m,d));
        
        cale=jdFSalida.getCalendar();
        d=cale.get(Calendar.DAY_OF_MONTH);
        m=cale.get(Calendar.MONTH);
        a=cale.get(Calendar.YEAR)-1999;//obtener una fecha correcta
        reserva.setFechaSalida(new Date(d,m,d));
        int selectipor =jcTipoReserva.getSelectedIndex();
        reserva.setTipoReserva(jcTipoReserva.getItemAt(selectipor));
        
        int selecestado =jcCama.getSelectedIndex();
        reserva.setEstado(jcCama.getItemAt(selecestado));
        
        int selecTipoR =jcTipoReserva.getSelectedIndex();
        reserva.setEstado(jcTipoReserva.getItemAt(selecTipoR));
        
       // reserva.setTotalDias(Integer.parseInt(jtTotalDias.getText()));
       String preciototal=jtPago.getText();
       int total=Integer.parseInt(preciototal);
        reserva.setPago(total);
      
        

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

    }    

    
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
       int fila = jtTablaReservas.rowAtPoint(evt.getPoint());//almacena de la tabla al estado de cada caja de texto
        if(jtTablaReservas.getColumnName(0)=="ID"){
          
        jbGuardar.setText("modificar");//cambio mi boton gurdar por modificar,
        habilitar();//habilito todas las cajas de texto
        jbEliminar.setEnabled(true);//botón eliminar habilitado
        accion = "modificar";

        //int fila = jtTablaReservas.rowAtPoint(evt.getPoint());//almacena de la tabla al estado de cada caja de texto

        jtIDReserva.setText(jtTablaReservas.getValueAt(fila, 0).toString());
        jdFReserva.setDate(Date.valueOf(jtTablaReservas.getValueAt(fila, 1).toString()));
        jdFEntrada.setDate(Date.valueOf(jtTablaReservas.getValueAt(fila, 2).toString()));
        jdFSalida.setDate(Date.valueOf(jtTablaReservas.getValueAt(fila, 3).toString()));
        jtNombreHuesped.setText(jtTablaReservas.getValueAt(fila, 4).toString());
        jtNumero.setText(jtTablaReservas.getValueAt(fila, 5).toString());
        jtcantPersonas.setText((jtTablaReservas.getValueAt(fila, 6).toString()));
        jtTotalDias.setText((jtTablaReservas.getValueAt(fila, 7).toString()));
        jtPago.setText((jtTablaReservas.getValueAt(fila, 8).toString()));
        jrbEstado.setText(jtTablaReservas.getValueAt(fila, 9).toString());
       ReservaData rd=new ReservaData();
       int r=Integer.parseInt(jtTablaReservas.getValueAt(fila, 0).toString());
       String [] datos = rd.reservas(r);
        for(int i=0;i<datos.length;i++){
            jtIDHabitacion.setText(datos[0]);
            jtIDHuesped.setText(datos[1]);
            jcTipoReserva.setSelectedItem(datos[2]);
            jcCama.setSelectedItem(datos[3]);
            jrbEstado.isSelected();
        }
       }else{           
           
           if(jtTablaReservas.getColumnName(0)=="ID."){//Tabla Habitacion y tipo
               
               String r=(jtTablaReservas.getValueAt(fila, 1).toString());
               jtNumero.setText(r);
               jtIDHabitacion.setText(jtTablaReservas.getValueAt(fila, 0)+"");
               jtPrecioNoche.setText(jtTablaReservas.getValueAt(fila, 6).toString());
               
                 
           }else if (jtTablaReservas.getColumnName(0)=="Id."){//Tabla Huesped
               String id = (jtTablaReservas.getValueAt(fila, 0).toString());
               String nombre =(jtTablaReservas.getValueAt(fila,3).toString()+" "+(jtTablaReservas.getValueAt(fila, 4)));
               jtIDHuesped.setText(id);
               jtNombreHuesped.setText(nombre);
              
            }        
               
               
        }   
       

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

    private void jcCamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcCamaActionPerformed

        ReservaData rd=new ReservaData();
        String catHab=jcTipoReserva.getSelectedItem().toString();
        String cama=jcCama.getSelectedItem().toString();
        
        mostrarHabitaciones(catHab,cama);
                
    }//GEN-LAST:event_jcCamaActionPerformed

    private void jcTipoReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcTipoReservaActionPerformed
        // TODO add your handling code here:
        ReservaData rd=new ReservaData();
        String catHabitacion=jcTipoReserva.getSelectedItem().toString();
        String cama="";
        mostrarHabitaciones(catHabitacion, cama);

    }//GEN-LAST:event_jcTipoReservaActionPerformed

    private void jtNombreHuespedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtNombreHuespedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtNombreHuespedActionPerformed

    private void jtTotalDiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtTotalDiasActionPerformed
        // TODO add your handling code here:
    
    }//GEN-LAST:event_jtTotalDiasActionPerformed

    private void jtPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtPagoActionPerformed
        // TODO add your handling code here:
       

    }//GEN-LAST:event_jtPagoActionPerformed

    private void jtPrecioNocheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtPrecioNocheActionPerformed
        // TODO add your handling code here:
       if (jtcantPersonas.getText() != "" && jtPrecioNoche.getText()!= " $ 00.00"){
            precioTotal();
        } 
        
    }//GEN-LAST:event_jtPrecioNocheActionPerformed

    private void jbTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbTotalActionPerformed
 try{
           int d=Integer.parseInt(jtTotalDias.getText());
           int precio=Integer.parseInt(jtPrecioNoche.getText());
                      JOptionPane.showMessageDialog(null,"double"+precio+"  int "+d);

           if(d!=0 && precio!=0){
               int total=(d*precio);
               jtPago.setText(""+total);
           }
           }catch(Exception ex){
               JOptionPane.showMessageDialog(null,"Error en Metodo Total linea :996.    "+ ex.getMessage());
           }
    }//GEN-LAST:event_jbTotalActionPerformed

    private void jbHuespedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbHuespedActionPerformed
        // TODO add your handling code here:
//        ListaHuespedes hues = new ListaHuespedes();
//        hues.toFront();
//        hues.setVisible(true);
mostrarHuesped("");
        
    }//GEN-LAST:event_jbHuespedActionPerformed

    private void jtcantPersonasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtcantPersonasActionPerformed
        // TODO add your handling code here:
        if (jtcantPersonas.getText() != "" ){
            precioTotal();
        }
    }//GEN-LAST:event_jtcantPersonasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jCCantPersonas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTbuscar;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbHuesped;
    private javax.swing.JButton jbNuevo;
    private javax.swing.JButton jbSalir;
    private javax.swing.JButton jbTotal;
    private javax.swing.JComboBox<String> jcCama;
    private javax.swing.JComboBox<String> jcTipoReserva;
    private com.toedter.calendar.JDateChooser jdFEntrada;
    private com.toedter.calendar.JDateChooser jdFReserva;
    private com.toedter.calendar.JDateChooser jdFSalida;
    private javax.swing.JLabel jlBuscar;
    private javax.swing.JLabel jlCama;
    private javax.swing.JLabel jlCategoriaHabitacion;
    private javax.swing.JLabel jlDias;
    private javax.swing.JLabel jlEntrada;
    private javax.swing.JLabel jlEstadia;
    private javax.swing.JLabel jlIdHab;
    private javax.swing.JLabel jlIdRes;
    private javax.swing.JLabel jlPersonas;
    private javax.swing.JLabel jlPrecioNoche;
    private javax.swing.JLabel jlReserva;
    private javax.swing.JLabel jlSalida;
    private javax.swing.JLabel jlTotalRegistros;
    private javax.swing.JLabel jlnumHab;
    private javax.swing.JRadioButton jrbEstado;
    public static javax.swing.JTextField jtIDHabitacion;
    public static javax.swing.JTextField jtIDHuesped;
    private javax.swing.JTextField jtIDReserva;
    public static javax.swing.JTextField jtNombreHuesped;
    public static javax.swing.JTextField jtNumero;
    private javax.swing.JTextField jtPago;
    public static javax.swing.JTextField jtPrecioNoche;
    private javax.swing.JTable jtTablaReservas;
    public static javax.swing.JTextField jtTotalDias;
    private javax.swing.JTextField jtcantPersonas;
    // End of variables declaration//GEN-END:variables

//AGregado
    public String obtenerFecha(JDateChooser jd){
    SimpleDateFormat Formato = new SimpleDateFormat("dd-MM-yyyy");
    if (jd.getDate()!=null){
        return Formato.format(jd.getDate());
    }
    return null;
}

public java.util.Date StringADate(String fecha){
    SimpleDateFormat formato=new SimpleDateFormat("dd-MM-yyyy");
    java.util.Date Fecha=null;
    try{
        Fecha=formato.parse(fecha);
    return Fecha;
    }catch (ParseException ex){
        return null;
    }
}
public LocalDate StringALocalDate(String fecha){//recibe String devuelve LocalDate
    DateTimeFormatter formato=DateTimeFormatter.ofPattern("dd-MM-yyyy");
    LocalDate fechanueva=null;
    if(fecha!=null){
        fechanueva=LocalDate.parse(fecha, formato);
        return fechanueva;
    }
    
    return null;
}

private void cargarDias(){//carga los dias cuando la fecha de entrada y salida no es nula
    ReservaData rd=new ReservaData();
    Oyente(jdFSalida);
    Oyente(jdFEntrada);
    if(jdFEntrada.getDate()!= null && jdFSalida.getDate()!=null){
    
        String e=obtenerFecha(jdFEntrada);//estos son metodos 
        String s=obtenerFecha(jdFSalida);
        
        LocalDate entrada=StringALocalDate(e);
        LocalDate salida=StringALocalDate(s);
        
        int d=rd.calcularDias(entrada, salida);
        jtTotalDias.setText(d+"");
       
        }
}

private void Oyente(JDateChooser jd) {//escucha al jdchooser y calcula los dias 
jd.getDateEditor().addPropertyChangeListener (new PropertyChangeListener() {
    @Override
    public void propertyChange(PropertyChangeEvent e) {
        try{
            if(jd!=null){
                cargarDias();
            }
        }catch(NullPointerException ex){
            JOptionPane.showMessageDialog(null,"error "+jdFEntrada.toString()+ex.getMessage());
        } 
    }
    });
}
       
        public void precioTotal(){
            int dias = Integer.parseInt(jtcantPersonas.getText());
            double precio=(double) Integer.parseInt(jtPrecioNoche.getText());
         if(jtcantPersonas.getText()!= "" && jtPrecioNoche.getText() != "$ 00.00"){
             
            double total=dias*precio;
            jtPago.setText("$"+total);
             }
            }
      
     
}
