
package Forms;

import clases.ColorT;
import Datos.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class Empleados extends javax.swing.JFrame {
  //creando variables de conexion a la base de datos
    static Connection conn=null;
    static Statement s=null;
    static ResultSet rs=null;
     public int count=0; 
     DateFormat formatoFecha;
     public Date date = null;
     public int idPA=-1;
     public int idPA2=-1;
     public int bandera =-1;
     public int duiPA =-1;
     String fecha ;
     public boolean mostrarP=false;
     public String sql="select ee.EMP_ID,ee.EMP_NOMBRE,ee.EMP_APELLIDO,uu.usuario_nom,uu.usuario_contra,"
             + "cc.idtipousuario,ee.SALARIO,ee.EMP_TELEFONO,ee.EMP_DUI,ee.FECHAINGRESO,ee.CARGO_ID,ee.ESTADO "
             + "from VentasSport.empleado ee join VentasSport.usuarios uu on ee.usuario_id=uu.usuario_id "
             + "join VentasSport.cargos cc on ee.cargo_id=cc.idtipousuario order by ee.estado desc,ee.emp_nombre asc";
     public int UsuarioSel =0;
    //Para establecer el modelo al JTable
    DefaultTableModel modelo = new DefaultTableModel();
    JScrollPane Scroll= new JScrollPane();
    public Empleados() {
        initComponents();
                tbEmp(sql);
     deshabilitar();
     formatoFecha = new SimpleDateFormat("dd-MM-yy");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Popup = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        grupoRBT = new javax.swing.ButtonGroup();
        GroupRBTFecha = new javax.swing.ButtonGroup();
        PanelEmp = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cb_estado = new javax.swing.JComboBox<>();
        cb_cargo = new javax.swing.JComboBox<>();
        txt_nombre = new javax.swing.JTextField();
        txt_apellido = new javax.swing.JTextField();
        txt_dui = new javax.swing.JTextField();
        txt_tel = new javax.swing.JTextField();
        txt_usuario = new javax.swing.JTextField();
        btn_guardar = new javax.swing.JButton();
        btn_editar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        TxtSalario = new javax.swing.JTextField();
        RBTManual = new javax.swing.JRadioButton();
        RBTPorSis = new javax.swing.JRadioButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        DCCalendario = new com.toedter.calendar.JDateChooser();
        jButton2 = new javax.swing.JButton();
        TxtContraseña = new javax.swing.JPasswordField();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        rb_apellido = new javax.swing.JRadioButton();
        rb_nombre = new javax.swing.JRadioButton();
        btn_buscar = new javax.swing.JButton();
        txt_buscar = new javax.swing.JTextField();
        rb_usuario = new javax.swing.JRadioButton();
        jLabel16 = new javax.swing.JLabel();
        btn_nuevo = new javax.swing.JButton();
        btn_salir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTBEmp = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();

        Popup.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jMenuItem1.setText("modificar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        Popup.add(jMenuItem1);

        jMenuItem2.setText("ver empleado");
        Popup.add(jMenuItem2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1300, 760));
        setMinimumSize(new java.awt.Dimension(1300, 760));
        setPreferredSize(new java.awt.Dimension(1300, 760));
        setSize(new java.awt.Dimension(1300, 760));
        getContentPane().setLayout(null);

        PanelEmp.setBorder(javax.swing.BorderFactory.createTitledBorder("Empleado"));
        PanelEmp.setOpaque(false);

        jLabel1.setText("Nombre:");

        jLabel2.setText("Apellido:");

        jLabel3.setText("DUI:");

        jLabel5.setText("Telefono:");

        jLabel6.setText("Cargo:");

        jLabel7.setText("Usuario:");

        jLabel8.setText("Clave:");

        jLabel10.setText("Estado:");

        cb_estado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_estadoActionPerformed(evt);
            }
        });

        cb_cargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_cargoActionPerformed(evt);
            }
        });

        txt_nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nombreKeyTyped(evt);
            }
        });

        txt_apellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_apellidoActionPerformed(evt);
            }
        });
        txt_apellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_apellidoKeyTyped(evt);
            }
        });

        txt_dui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_duiActionPerformed(evt);
            }
        });
        txt_dui.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_duiKeyTyped(evt);
            }
        });

        txt_tel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_telActionPerformed(evt);
            }
        });
        txt_tel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_telKeyTyped(evt);
            }
        });

        txt_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usuarioActionPerformed(evt);
            }
        });

        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/guardar.png"))); // NOI18N
        btn_guardar.setText("guardar");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });

        btn_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/editar.png"))); // NOI18N
        btn_editar.setText("editar");
        btn_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editarActionPerformed(evt);
            }
        });

        btn_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/cancelar.png"))); // NOI18N
        btn_cancelar.setText("cancelar");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });

        jLabel14.setText("Salario: ");

        TxtSalario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtSalarioKeyTyped(evt);
            }
        });

        GroupRBTFecha.add(RBTManual);
        RBTManual.setText("Manual");
        RBTManual.setOpaque(false);
        RBTManual.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RBTManualMouseClicked(evt);
            }
        });
        RBTManual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBTManualActionPerformed(evt);
            }
        });

        GroupRBTFecha.add(RBTPorSis);
        RBTPorSis.setSelected(true);
        RBTPorSis.setText("Por Sistema");
        RBTPorSis.setOpaque(false);
        RBTPorSis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBTPorSisActionPerformed(evt);
            }
        });

        jLabel15.setText("fecha:");

        jLabel9.setText("fecha de ingreso :");

        DCCalendario.setDateFormatString("dd-MM-yyyy");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/mostrar.png"))); // NOI18N
        jButton2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelEmpLayout = new javax.swing.GroupLayout(PanelEmp);
        PanelEmp.setLayout(PanelEmpLayout);
        PanelEmpLayout.setHorizontalGroup(
            PanelEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelEmpLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelEmpLayout.createSequentialGroup()
                        .addGroup(PanelEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelEmpLayout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                .addGroup(PanelEmpLayout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(8, 8, 8)))
                            .addGroup(PanelEmpLayout.createSequentialGroup()
                                .addGroup(PanelEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)
                                    .addGroup(PanelEmpLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel7)))
                                .addGap(5, 5, 5)))
                        .addGroup(PanelEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_usuario)
                            .addComponent(txt_tel)
                            .addComponent(txt_dui)
                            .addComponent(txt_nombre)
                            .addComponent(txt_apellido, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(PanelEmpLayout.createSequentialGroup()
                        .addGroup(PanelEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelEmpLayout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cb_estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelEmpLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cb_cargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelEmpLayout.createSequentialGroup()
                                .addComponent(btn_editar)
                                .addGap(10, 10, 10)
                                .addGroup(PanelEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_cancelar)
                                    .addComponent(btn_guardar)))
                            .addComponent(DCCalendario, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PanelEmpLayout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(PanelEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addGroup(PanelEmpLayout.createSequentialGroup()
                                        .addComponent(RBTPorSis)
                                        .addGap(18, 18, 18)
                                        .addComponent(RBTManual))
                                    .addComponent(jLabel15)
                                    .addGroup(PanelEmpLayout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(TxtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(PanelEmpLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TxtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        PanelEmpLayout.setVerticalGroup(
            PanelEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelEmpLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_dui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_tel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(PanelEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(25, 25, 25)
                .addGroup(PanelEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(TxtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(TxtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RBTPorSis)
                    .addComponent(RBTManual))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(DCCalendario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(PanelEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(cb_estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cb_cargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_guardar)
                    .addComponent(btn_editar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_cancelar)
                .addContainerGap(134, Short.MAX_VALUE))
        );

        getContentPane().add(PanelEmp);
        PanelEmp.setBounds(20, 30, 280, 660);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Busqueda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel4.setOpaque(false);

        jLabel11.setText("Buscar empleado por");

        grupoRBT.add(rb_apellido);
        rb_apellido.setText("Apellido");
        rb_apellido.setOpaque(false);
        rb_apellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_apellidoActionPerformed(evt);
            }
        });

        grupoRBT.add(rb_nombre);
        rb_nombre.setSelected(true);
        rb_nombre.setText("Nombre");
        rb_nombre.setOpaque(false);
        rb_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_nombreActionPerformed(evt);
            }
        });

        btn_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/lupa-herramienta (1).png"))); // NOI18N
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });

        txt_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_buscarActionPerformed(evt);
            }
        });
        txt_buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_buscarKeyTyped(evt);
            }
        });

        grupoRBT.add(rb_usuario);
        rb_usuario.setText("usuario");
        rb_usuario.setOpaque(false);

        jLabel16.setText("BUSCAR");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rb_nombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rb_apellido)
                        .addGap(18, 18, 18)
                        .addComponent(rb_usuario)
                        .addGap(0, 375, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(rb_nombre)
                    .addComponent(rb_apellido)
                    .addComponent(rb_usuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel16)
                            .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4);
        jPanel4.setBounds(430, 20, 720, 110);

        btn_nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/signo-mas-para-agregar.png"))); // NOI18N
        btn_nuevo.setText("NUEVO");
        btn_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevoActionPerformed(evt);
            }
        });
        getContentPane().add(btn_nuevo);
        btn_nuevo.setBounds(310, 40, 110, 50);

        btn_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/salida.png"))); // NOI18N
        btn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salirActionPerformed(evt);
            }
        });
        getContentPane().add(btn_salir);
        btn_salir.setBounds(1210, 20, 50, 50);

        JTBEmp.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        JTBEmp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        JTBEmp.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        JTBEmp.setComponentPopupMenu(Popup);
        JTBEmp.getTableHeader().setResizingAllowed(false);
        JTBEmp.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(JTBEmp);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(310, 160, 940, 560);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/W2.jpeg"))); // NOI18N
        jLabel12.setMaximumSize(new java.awt.Dimension(1300, 760));
        jLabel12.setMinimumSize(new java.awt.Dimension(1300, 760));
        jLabel12.setPreferredSize(new java.awt.Dimension(1300, 760));
        getContentPane().add(jLabel12);
        jLabel12.setBounds(0, 0, 1300, 760);

        pack();
    }// </editor-fold>//GEN-END:initComponents
void tbEmp(String SQL){
            String []titulos={"ID","NOMBRE","APELLIDO","USUARIO","CONTRASEÑA","TIPO"
                    ,"SALARIO","TELEFONO","DUI","INGRESO","CARGO","ESTADO"};//CREANDO UN STRING PARA LO TITULOS 
            String []Registros=new String[12];
           modelo= new DefaultTableModel(null,titulos);//ASIGNAR LA MATRIZ TITUTLO A NUESTRO MODELO DEL JTABLE
            try{          //
            rs=Conexion.Consulta(rs,SQL);//LLAMAMA AL METODO EnEst, EJECTURA UNA CONSULTA A LA TABLA JTBEMP
             while(rs.next())//RECORRER LA CONSULTA COLUMNA POR COLUMNA
              {
                Registros[0]= rs.getString("emp_id");
                 Registros[1]= rs.getString("emp_nombre");
                 Registros[2]= rs.getString("emp_apellido");
                 Registros[3]= rs.getString("usuario_nom");
                 Registros[4]= rs.getString("usuario_contra");
                 Registros[5]= rs.getString("idtipousuario");
                 Registros[6]= rs.getString("salario");
                 Registros[7]= rs.getString("emp_telefono");
                 Registros[8]= rs.getString("emp_dui");
                 Registros[9]= rs.getString("fechaingreso");
                 Registros[10]= rs.getString("cargo_id");
                 Registros[11]= rs.getString("estado");
                 //AÑADIR LAS COLUMNAS AL MODELO JTABLE
                 ColorT renderizado = new ColorT(11);
                 this.JTBEmp.setDefaultRenderer(Object.class, renderizado);
                 modelo.addRow(Registros);
              }
             //AÑADIR EL MODELO A NUESTRA TABLA
              this.JTBEmp.setModel(modelo);
              this.JTBEmp.setDefaultEditor(Object.class, null); 
              this.JTBEmp.add(Scroll);  
            } catch (Exception ex) {
        ex.printStackTrace();//RECIBIR UN ERROR
       }
    }
public boolean validarcampos(){
    Date fechaActual = new Date();
    boolean validar =false;
    if (this.RBTPorSis.isSelected()) {
        fecha = formatoFecha.format(fechaActual);
    }
    else if ((this.RBTManual.isSelected())&&(this.DCCalendario.getDate()!=null)){
        fecha = String.valueOf(formatoFecha.format(this.DCCalendario.getDate()));
    }
    else if ((this.RBTManual.isSelected())&&(this.DCCalendario.getDate()==null)){
        fecha =null;
    }
    if((this.txt_nombre.getText().length()!=0)&&(this.txt_apellido.getText().length()!=0)&&(this.txt_dui.getText().length()!=0)&&
                (this.txt_tel.getText().length()!=0)&&(this.TxtSalario.getText().length()!=0)&&
                (String.copyValueOf(this.TxtContraseña.getPassword()).length()!=0)&&(this.txt_usuario.getText().length()!=0)&&(fecha!=null)){
        validar = true;
    }
       else if((this.txt_nombre.getText().length()==0)||(this.txt_apellido.getText().length()==0)||(this.txt_dui.getText().length()==0)||
                (this.txt_tel.getText().length()==0)||(this.TxtSalario.getText().length()==0)||
                (String.copyValueOf(this.TxtContraseña.getPassword()).length()==0)||(this.txt_usuario.getText().length()==0)||
                (fecha==null)){
        validar =false;
        }
    return validar;
}
void llenar(){
int fila = this.JTBEmp.getSelectedRow();//VARIABLE TIPO INT PARA OBTENER LOS DATOS DE JTABLE
        String nombre="",apellido="",telefono="",direccion="",ingreso="",clave="",dui="",salario="",usuario="";//VARIABLES STRING
        int cargo=-1,estado=-1;
        //OBTENER LOS VALORES DE JTABLE
         if (fila>=0){
            UsuarioSel=Integer.parseInt(JTBEmp.getValueAt(fila,0).toString());
            nombre=JTBEmp.getValueAt(fila,1).toString();
            apellido=JTBEmp.getValueAt(fila,2).toString();
            usuario=JTBEmp.getValueAt(fila,3).toString();
            clave=JTBEmp.getValueAt(fila,4).toString();
            salario=JTBEmp.getValueAt(fila,6).toString();
            telefono=JTBEmp.getValueAt(fila,7).toString();
            dui=JTBEmp.getValueAt(fila,8).toString();
            ingreso=JTBEmp.getValueAt(fila,9).toString();
            try {
            date = new SimpleDateFormat("yyy-MM-dd").parse((String)modelo.getValueAt(fila,9));
            } catch (ParseException ex) {
            Logger.getLogger(Empleados.class.getName()).log(Level.SEVERE, null, ex);
            }
            cargo=Integer.parseInt(JTBEmp.getValueAt(fila,10).toString());
            estado=Integer.parseInt(JTBEmp.getValueAt(fila,11).toString());
         }
         //ASIGNAR LOS VALORES OBTENIDO A LAS VARIABLES STRING
         this.txt_nombre.setText(nombre);
         this.txt_apellido.setText(apellido);
         this.txt_dui.setText(dui);
         this.txt_tel.setText(telefono);
         this.txt_usuario.setText(usuario);
         this.TxtContraseña.setText(clave);
         this.RBTManual.setSelected(true);
         this.DCCalendario.setDate(date);   
         this.TxtSalario.setText(salario);
         this.btn_editar.setEnabled(true);//BOTON MODIFICAR HABILITADO
         this.btn_guardar.setEnabled(false);     
         if (cargo==1) {
             cb_cargo.removeAllItems();
             cb_cargo.addItem("administrador");
             cb_cargo.addItem("vendedor");
         }
         if (cargo==2) {
             cb_cargo.removeAllItems();
             cb_cargo.addItem("vendedor");
             cb_cargo.addItem("administrador");
         }  
         if (estado==1) {
             cb_estado.removeAllItems();
             cb_estado.addItem("activo");
             cb_estado.addItem("inactivo");
         }
         if (estado==0) {
             cb_estado.removeAllItems();
             cb_estado.addItem("inactivo");
             cb_estado.addItem("activo");
         }
}
void limpiar(){
        this.txt_nombre.setText(null);
        this.txt_apellido.setText(null);
        this.txt_dui.setText(null);
        this.txt_tel.setText(null);
        this.txt_usuario.setText(null);
        this.DCCalendario.setDate(null);
        this.txt_dui.setText(null);
        this.TxtSalario.setText(null);
        this.cb_cargo.removeAllItems();
        this.cb_estado.removeAllItems();
        this.TxtContraseña.setText(null);
}
void deshabilitar(){
   for(int i=0;i<this.PanelEmp.getComponents().length;i++) {
        this.PanelEmp.getComponent(i).setEnabled(false);
        }
}
void habilitar(){
for(int i=0;i<this.PanelEmp.getComponents().length;i++) {
        this.PanelEmp.getComponent(i).setEnabled(true);
        }
}
void VInsercionEmp(){
//IF((MDUI=0)AND(MBANDERA=1)AND(MIDUSER!=-2)){
//MSJ="INSERTADO"
//}
//ELSE IF((MIDUSER=-2)AND(MDUI=1)AND(MBANDERA=0)){
//MSJ="NO SE INSERTO dui o usuario ya en registro"
//}
    if ((bandera==1)&&(duiPA==0)&&(idPA2!=-2)) {
        JOptionPane.showMessageDialog(null, "Registro exitoso","Registro",JOptionPane.INFORMATION_MESSAGE);
        tbEmp(sql);
        bandera=-1;
        duiPA=-1;
        idPA2=-1;
    }
    if ((bandera==0)&&(duiPA==1)&&(idPA2==-2)) {
        JOptionPane.showMessageDialog(null, "Campo 'usuario' ya esta registrado por favor modifiquelo","Registro",JOptionPane.INFORMATION_MESSAGE);
        bandera=-1;
        duiPA=-1;
        idPA2=-1;
    }
}
void validarPNuevo(){
        habilitar();
        limpiar();
        if (this.RBTPorSis.isSelected()) {
            this.DCCalendario.setEnabled(false);
        }
        this.btn_editar.setEnabled(false);
        this.cb_cargo.removeAllItems();
        this.cb_cargo.addItem("administrador");
        this.cb_cargo.addItem("vendedor");
        this.cb_estado.removeAllItems();
        this.cb_estado.addItem("activo");
        this.cb_estado.addItem("inactivo");
}
void busqueda(){
        //busqueda total(con activos e inactivos) sin campo de busqueda
        if ((this.rb_nombre.isSelected()==true)&&(this.txt_buscar.getText().trim().length()==0)) {
            tbEmp(sql);
        }
        if ((this.rb_apellido.isSelected()==true)&&(this.txt_buscar.getText().trim().length()==0)) {
            tbEmp(sql);
        }
        if ((this.rb_usuario.isSelected()==true)&&(this.txt_buscar.getText().trim().length()==0)) {
            tbEmp(sql);
        }
        //busqueda total(con activos e inactivos) con cualquier opcion(nombre, apellido, usuario)
        if ((this.txt_buscar.getText().trim().length()>0)&&(this.rb_nombre.isSelected()==true)) {
           String sql= "select ee.EMP_ID,ee.EMP_NOMBRE,ee.EMP_APELLIDO,uu.usuario_nom,uu.usuario_contra,"
             + "cc.idtipousuario,ee.SALARIO,ee.EMP_TELEFONO,ee.EMP_DUI,ee.FECHAINGRESO,ee.CARGO_ID,ee.ESTADO "
             + "from VentasSport.empleado ee join VentasSport.usuarios uu on ee.usuario_id=uu.usuario_id "
             + "join VentasSport.cargos cc on ee.cargo_id=cc.idtipousuario "
             + "where regexp_like"+""+" (ee.emp_nombre,'"+this.txt_buscar.getText().trim()+"','i')"
                   + " order by ee.estado desc,ee.emp_nombre asc";
            tbEmp(sql);
        }
        if ((this.txt_buscar.getText().trim().length()>0)&&(this.rb_apellido.isSelected()==true)) {
            String sql="select ee.EMP_ID,ee.EMP_NOMBRE,ee.EMP_APELLIDO,uu.usuario_nom,uu.usuario_contra,"
             + "cc.idtipousuario,ee.SALARIO,ee.EMP_TELEFONO,ee.EMP_DUI,ee.FECHAINGRESO,ee.CARGO_ID,ee.ESTADO "
             + "from VentasSport.empleado ee join VentasSport.usuarios uu on ee.usuario_id=uu.usuario_id "
             + "join VentasSport.cargos cc on ee.cargo_id=cc.idtipousuario "
             + "where regexp_like(ee.emp_apellido,'"+this.txt_buscar.getText().trim()+"','i') "
            + " order by ee.estado desc,ee.emp_nombre asc";
            tbEmp(sql);
        }
        if ((this.txt_buscar.getText().trim().length()>0)&&(this.rb_usuario.isSelected()==true)) {
            String sql="select ee.EMP_ID,ee.EMP_NOMBRE,ee.EMP_APELLIDO,uu.usuario_nom,uu.usuario_contra,"
             + "cc.idtipousuario,ee.SALARIO,ee.EMP_TELEFONO,ee.EMP_DUI,ee.FECHAINGRESO,ee.CARGO_ID,ee.ESTADO "
             + "from VentasSport.empleado ee join VentasSport.usuarios uu on ee.usuario_id=uu.usuario_id "
             + "join VentasSport.cargos cc on ee.cargo_id=cc.idtipousuario "
             + "where regexp_like (uu.usuario_nom,'"+this.txt_buscar.getText().trim()+"','i') "
            + " order by ee.estado desc,ee.emp_nombre asc";
            tbEmp(sql);
        }
}
void VActualizacionEmp(){
//si idPA=1; usuarioPA=0; duiPA=0 se actualiza el usuario
//si idPA=1; usuarioPA=1; duiPA=1 el campo usuario o dui ya estan en registro
//si idPA=0; usuarioPA=0; duiPA=0 el usuario no se encontro por algun motivo
    if ((idPA==1)&&(bandera==0)&&(duiPA==0)) {
        JOptionPane.showMessageDialog(null, "Actualizacion exitosa","Modificacion",JOptionPane.INFORMATION_MESSAGE);
        tbEmp(sql);
        bandera=-1;
        duiPA=-1;
        idPA=-1;
    }
    if ((idPA==1)&&(bandera==1)&&(duiPA==1)) {
        JOptionPane.showMessageDialog(null, "Campos 'usuario' o 'dui' ya estan en registro por favor modifiquelos","Modificacion",JOptionPane.INFORMATION_MESSAGE);
        bandera=-1;
        duiPA=-1;
        idPA=-1;
    }
    if ((idPA==0)&&(bandera==0)&&(duiPA==0)) {
        JOptionPane.showMessageDialog(null, "por algun motivo el empleado no se encuentra en los registros","Modificacion",JOptionPane.INFORMATION_MESSAGE);
        bandera=-1;
        duiPA=-1;
        idPA=-1;
    }
}
    private void cb_estadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_estadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_estadoActionPerformed

    private void cb_cargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_cargoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_cargoActionPerformed

    private void txt_nombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nombreKeyTyped
        if(!Character.isAlphabetic(evt.getKeyChar())&&(evt.getKeyChar()!=' ')) {
            evt.consume();
        }
        if((evt.getKeyChar()==' ')&&(this.txt_nombre.getText().contains(" "))) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_nombreKeyTyped

    private void txt_apellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_apellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_apellidoActionPerformed

    private void txt_apellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_apellidoKeyTyped
        if(!Character.isAlphabetic(evt.getKeyChar())&&(evt.getKeyChar()!=' ')) {
            evt.consume();
        }
        if((evt.getKeyChar()==' ')&&(this.txt_apellido.getText().contains(" "))) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_apellidoKeyTyped

    private void txt_duiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_duiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_duiActionPerformed

    private void txt_duiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_duiKeyTyped
        if(!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_duiKeyTyped

    private void txt_telActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_telActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_telActionPerformed

    private void txt_telKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_telKeyTyped
        if(!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_telKeyTyped

    private void txt_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usuarioActionPerformed

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        int usuario=-1;
        int contra=-1;
        int id=-1;
        if (validarcampos()==true) {
            int estado=0,cargo=0;
            if (this.cb_estado.getSelectedIndex()==0) {
                estado=1;
            }
            if (this.cb_estado.getSelectedIndex()==1) {
                estado=0;
            }
            if (this.cb_cargo.getSelectedIndex()==0) {
                cargo=1;
            }
            if (this.cb_cargo.getSelectedIndex()==1) {
                cargo=2;
            }
            try{
                conn=Conexion.conectar(conn);
                String sql="{call insertusuario(?,?,?,?,?)}";
                CallableStatement pst=conn.prepareCall(sql);
                pst.setString(1,this.txt_usuario.getText());
                pst.setString(2,String.valueOf(this.TxtContraseña.getPassword()));
                pst.registerOutParameter(3, java.sql.Types.NUMERIC);
                pst.registerOutParameter(4, java.sql.Types.NUMERIC);
                pst.registerOutParameter(5, java.sql.Types.NUMERIC);
                pst.execute();
                usuario = pst.getInt(3);
                contra = pst.getInt(4);
                id = pst.getInt(5);
            }catch(Exception e){
                System.out.println(e.getCause());//OBTENER ERROR
            }finally{
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println("Error: " + ex.getMessage());
                }
            }
            try{
                conn=Conexion.conectar(conn);//INVOCANDO LA CONEXION DESDE LA CLASE main
                String sql="{call insertemp(?,?,?,?,?,?,?,?,?,?,?,?)}";//QUERY
                CallableStatement pst=conn.prepareCall(sql);//EJECUCION DE QUERY POR MEDIO DE STATEMENT
//                pnombre in varchar2,papellido in varchar2,ptelefono in char,pcargo in number,
//                pusuarioid in number,estado in number,pdui in varchar2,pfechaingreso in date,
//                psalario in float,mdui out number,mbandera out number,miduser out number
                //ASIGANAR DE VARIABLES A LOS PARAMETROS DE QUERY
                pst.setString(1, this.txt_nombre.getText());
                pst.setString(2, this.txt_apellido.getText());
                pst.setString(3,this.txt_tel.getText());
                pst.setInt(4,cargo);
                pst.setInt(5,id);
                pst.setInt(6,estado);
                pst.setString(7,this.txt_dui.getText());
                pst.setString(8,fecha);
                pst.setDouble(9,Double.parseDouble(this.TxtSalario.getText()));
                pst.registerOutParameter(10, java.sql.Types.NUMERIC);
                pst.registerOutParameter(11, java.sql.Types.NUMERIC);
                pst.registerOutParameter(12, java.sql.Types.NUMERIC);
                pst.execute();//EJECUTAR
                duiPA = pst.getInt(10);
                bandera = pst.getInt(11);
                idPA2 = pst.getInt(12);
            }catch(Exception e){
                System.out.println(e.getCause());//OBTENER ERROR
            }finally {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println("Error: " + ex.getMessage());
                }
            }
            VInsercionEmp();
        }
        else if(validarcampos()==false){
            JOptionPane.showMessageDialog(null, "Algun campo esta vacio","Registro",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void btn_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editarActionPerformed
        validarcampos();
        if (validarcampos()==true) {
            int estado=0,cargo=0;
            if (this.cb_estado.getSelectedIndex()==0) {
                estado=1;
            }
            if (this.cb_estado.getSelectedIndex()==1) {
                estado=0;
            }
            if (this.cb_cargo.getSelectedIndex()==0) {
                cargo=1;
            }
            if (this.cb_cargo.getSelectedIndex()==1) {
                cargo=2;
            }
            try{
                conn=Conexion.conectar(conn);//INVOCANDO LA CONEXION DESDE LA CLASE main
                String sql1="{call actualizarEmp(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";//QUERY
                CallableStatement pst=conn.prepareCall(sql1);//EJECUCION DE QUERY POR MEDIO DE STATEMENT
                //ASIGANAR DE VARIABLES A LOS PARAMETROS DE QUERY
                pst.setString(1, this.txt_nombre.getText());
                pst.setString(2, this.txt_apellido.getText());
                pst.setString(3,this.txt_dui.getText());

                pst.setString(4,this.txt_tel.getText());
                pst.setString(5,this.txt_usuario.getText());
                pst.setString(6,String.valueOf(this.TxtContraseña.getPassword()));
                pst.setDouble(7,Double.parseDouble(this.TxtSalario.getText()));
                pst.setString(8,fecha);
                pst.setInt(9,estado);
                pst.setInt(10,cargo);
                pst.setInt(11,UsuarioSel);
                pst.registerOutParameter(12, java.sql.Types.NUMERIC);
                pst.registerOutParameter(13, java.sql.Types.NUMERIC);
                pst.registerOutParameter(14, java.sql.Types.NUMERIC);
                pst.execute();//EJECUTAR
                idPA = Integer.parseInt(pst.getString(12));
                bandera = Integer.parseInt(pst.getString(13));
                duiPA = Integer.parseInt(pst.getString(14));
            }catch(Exception e){
                System.out.println(e.getCause());//OBTENER ERROR
            }finally {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println("Error: " + ex.getMessage());
                }
            }
            VActualizacionEmp();
            estado=0;
            cargo=0;
        }
        else if(validarcampos()==false){
            JOptionPane.showMessageDialog(null, "Algun campo esta vacio","Registro",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btn_editarActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        limpiar();
        this.cb_cargo.removeAllItems();
        this.cb_cargo.addItem("administrador");
        this.cb_cargo.addItem("vendedor");
        this.cb_estado.removeAllItems();
        this.cb_estado.addItem("activo");
        this.cb_estado.addItem("inactivo");
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void TxtSalarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtSalarioKeyTyped
        if((!Character.isDigit(evt.getKeyChar()))&&(evt.getKeyChar()!='.')) {
            evt.consume();
        }
        if((evt.getKeyChar()=='.')&&(this.TxtSalario.getText().contains("."))){
            evt.consume();
        }
    }//GEN-LAST:event_TxtSalarioKeyTyped

    private void RBTManualMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RBTManualMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_RBTManualMouseClicked

    private void RBTManualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBTManualActionPerformed
        this.DCCalendario.setDate(null);
        this.DCCalendario.setEnabled(true);
    }//GEN-LAST:event_RBTManualActionPerformed

    private void RBTPorSisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBTPorSisActionPerformed
        this.DCCalendario.setDate(null);
        this.DCCalendario.setEnabled(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_RBTPorSisActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (mostrarP==false) {
            this.TxtContraseña.setEchoChar((char)0);
            mostrarP=true;
        }
        else if(mostrarP==true){
            this.TxtContraseña.setEchoChar('*');
            mostrarP=false;
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void rb_apellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_apellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rb_apellidoActionPerformed

    private void rb_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rb_nombreActionPerformed

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        busqueda();
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void txt_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_buscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_buscarActionPerformed

    private void btn_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevoActionPerformed
        if((this.txt_nombre.getText().length()!=0)||(this.txt_apellido.getText().length()!=0)||
                (this.txt_dui.getText().length()!=0)||
                (this.txt_tel.getText().length()!=0)||(this.TxtSalario.getText().length()!=0)||
                (String.copyValueOf(this.TxtContraseña.getPassword()).length()!=0)||(this.txt_usuario.getText().length()!=0)||
                (fecha!=null)){
                    int r= JOptionPane.showConfirmDialog(null,"AVISO! si acepta perdera los datos digitados en los campos.¿desea continuar?","CONTINUAR!",JOptionPane.YES_NO_OPTION);
            if(r==JOptionPane.YES_OPTION){
                validarPNuevo();
            }
            else if(r==JOptionPane.NO_OPTION){
                
            }
            else if(r==JOptionPane.CLOSED_OPTION){
            
            }
        }
        else{
                validarPNuevo();
        }
    }//GEN-LAST:event_btn_nuevoActionPerformed

    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirActionPerformed
                    if((this.txt_nombre.getText().length()!=0)||(this.txt_apellido.getText().length()!=0)||
                (this.txt_dui.getText().length()!=0)||
                (this.txt_tel.getText().length()!=0)||(this.TxtSalario.getText().length()!=0)||
                (String.copyValueOf(this.TxtContraseña.getPassword()).length()!=0)||(this.txt_usuario.getText().length()!=0)||
                (fecha!=null)){
                    int r= JOptionPane.showConfirmDialog(null,"AVISO! si acepta perdera los datos digitados en los campos.¿desea continuar?","CONTINUAR!",JOptionPane.YES_NO_OPTION);
            if(r==JOptionPane.YES_OPTION){
                  this.dispose();
                  PrincipalAdmin from = new PrincipalAdmin();
                  from.setVisible(true);
            }
            else if(r==JOptionPane.NO_OPTION){
                
            }
            else if(r==JOptionPane.CLOSED_OPTION){
            
            }
        }
        else{
             this.dispose();
             PrincipalAdmin from = new PrincipalAdmin();
             from.setVisible(true);   
        }
       
    }//GEN-LAST:event_btn_salirActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
             if((this.txt_nombre.getText().length()!=0)||(this.txt_apellido.getText().length()!=0)||
                (this.txt_dui.getText().length()!=0)||
                (this.txt_tel.getText().length()!=0)||(this.TxtSalario.getText().length()!=0)||
                (String.copyValueOf(this.TxtContraseña.getPassword()).length()!=0)||(this.txt_usuario.getText().length()!=0)||
                (fecha!=null)){
                    int r= JOptionPane.showConfirmDialog(null,"AVISO! si acepta perdera los datos digitados en los campos.¿desea continuar?","CONTINUAR!",JOptionPane.YES_NO_OPTION);
            if(r==JOptionPane.YES_OPTION){
                 habilitar();
                 llenar();
            }
            else if(r==JOptionPane.NO_OPTION){
                
            }
            else if(r==JOptionPane.CLOSED_OPTION){
            
            }
        }
        else{
             habilitar();
             llenar();   
        }   
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void txt_buscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscarKeyTyped
    busqueda();
    }//GEN-LAST:event_txt_buscarKeyTyped

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
            java.util.logging.Logger.getLogger(Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Empleados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DCCalendario;
    private javax.swing.ButtonGroup GroupRBTFecha;
    private javax.swing.JTable JTBEmp;
    private javax.swing.JPanel PanelEmp;
    private javax.swing.JPopupMenu Popup;
    private javax.swing.JRadioButton RBTManual;
    private javax.swing.JRadioButton RBTPorSis;
    private javax.swing.JPasswordField TxtContraseña;
    private javax.swing.JTextField TxtSalario;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_editar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_nuevo;
    private javax.swing.JButton btn_salir;
    private javax.swing.JComboBox<String> cb_cargo;
    private javax.swing.JComboBox<String> cb_estado;
    private javax.swing.ButtonGroup grupoRBT;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rb_apellido;
    private javax.swing.JRadioButton rb_nombre;
    private javax.swing.JRadioButton rb_usuario;
    private javax.swing.JTextField txt_apellido;
    private javax.swing.JTextField txt_buscar;
    private javax.swing.JTextField txt_dui;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_tel;
    private javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables
}
