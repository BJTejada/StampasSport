/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import Datos.*;
import clases.ColorT;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author eduardo
 */
public class Clientes extends javax.swing.JFrame {
    int estado;
    int codigo;
    public Clientes() {
        initComponents();
        mostrar();
        bloquear();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        JP = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        txt_apellido = new javax.swing.JTextField();
        txt_tel = new javax.swing.JTextField();
        txt_dui = new javax.swing.JTextField();
        txt_nit = new javax.swing.JTextField();
        CBestado = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        btn_agregar = new javax.swing.JButton();
        btn_editar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        rb_nombre = new javax.swing.JRadioButton();
        rb_apellido = new javax.swing.JRadioButton();
        rb_dui = new javax.swing.JRadioButton();
        btn_buscar = new javax.swing.JButton();
        txt_buscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btn_salir = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        btn_cancecar = new javax.swing.JButton();
        btn_guardar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1050, 570));
        setMinimumSize(new java.awt.Dimension(1050, 570));
        setResizable(false);
        setSize(new java.awt.Dimension(1050, 570));
        getContentPane().setLayout(null);

        JP.setBackground(new java.awt.Color(0, 204, 204));
        JP.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Clientes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        JP.setForeground(new java.awt.Color(255, 255, 255));
        JP.setOpaque(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Nombre:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Apellido:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Telefono:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("DUI:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("NIT:");

        txt_nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nombreKeyTyped(evt);
            }
        });

        txt_apellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_apellidoKeyTyped(evt);
            }
        });

        txt_tel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_telKeyTyped(evt);
            }
        });

        txt_dui.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_duiKeyTyped(evt);
            }
        });

        txt_nit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nitKeyTyped(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Estado:");

        javax.swing.GroupLayout JPLayout = new javax.swing.GroupLayout(JP);
        JP.setLayout(JPLayout);
        JPLayout.setHorizontalGroup(
            JPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel1))
                .addGap(22, 22, 22)
                .addGroup(JPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_apellido)
                    .addComponent(txt_nombre)
                    .addComponent(txt_dui)
                    .addComponent(txt_tel)
                    .addComponent(txt_nit, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                    .addComponent(CBestado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        JPLayout.setVerticalGroup(
            JPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_tel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_dui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_nit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(JPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CBestado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        getContentPane().add(JP);
        JP.setBounds(10, 140, 242, 251);

        btn_agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/signo-mas-para-agregar.png"))); // NOI18N
        btn_agregar.setText("Agregar nuevo");
        btn_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_agregar);
        btn_agregar.setBounds(270, 100, 150, 41);

        btn_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/editar.png"))); // NOI18N
        btn_editar.setText("Editar");
        btn_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_editar);
        btn_editar.setBounds(10, 400, 100, 50);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar por:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel1.setOpaque(false);

        rb_nombre.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup2.add(rb_nombre);
        rb_nombre.setSelected(true);
        rb_nombre.setText("Nombre");
        rb_nombre.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        rb_nombre.setOpaque(false);
        rb_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_nombreActionPerformed(evt);
            }
        });

        buttonGroup2.add(rb_apellido);
        rb_apellido.setText("Apellido");
        rb_apellido.setOpaque(false);

        buttonGroup2.add(rb_dui);
        rb_dui.setText("Dui");
        rb_dui.setOpaque(false);

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
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_buscarKeyReleased(evt);
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
                        .addComponent(rb_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(rb_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(rb_dui, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 108, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_buscar)
                        .addGap(18, 18, 18)
                        .addComponent(btn_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(rb_apellido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rb_dui, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rb_nombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                        .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(430, 10, 370, 110);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(260, 150, 765, 318);

        btn_salir.setBackground(new java.awt.Color(204, 0, 0));
        btn_salir.setForeground(new java.awt.Color(255, 255, 255));
        btn_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/salida.png"))); // NOI18N
        btn_salir.setText("Regresar");
        btn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salirActionPerformed(evt);
            }
        });
        getContentPane().add(btn_salir);
        btn_salir.setBounds(900, 480, 120, 40);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/clientes.jpg"))); // NOI18N
        getContentPane().add(jLabel9);
        jLabel9.setBounds(70, 10, 131, 130);

        btn_cancecar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/cancelar.png"))); // NOI18N
        btn_cancecar.setText("Cancelar");
        btn_cancecar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancecarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_cancecar);
        btn_cancecar.setBounds(60, 460, 120, 50);

        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/guardar.png"))); // NOI18N
        btn_guardar.setText("Guardar");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_guardar);
        btn_guardar.setBounds(127, 400, 120, 50);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/W2.jpeg"))); // NOI18N
        jLabel8.setMaximumSize(new java.awt.Dimension(1050, 570));
        jLabel8.setMinimumSize(new java.awt.Dimension(1050, 570));
        jLabel8.setPreferredSize(new java.awt.Dimension(1050, 570));
        getContentPane().add(jLabel8);
        jLabel8.setBounds(0, 0, 1050, 570);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rb_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rb_nombreActionPerformed

    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirActionPerformed
        this.dispose();
        PrincipalAdmin from = new PrincipalAdmin();
        from.setVisible(true);
    }//GEN-LAST:event_btn_salirActionPerformed

    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarActionPerformed
        setearTextBox();
        desbloquear();
        this.btn_editar.setEnabled(false);
        this.btn_guardar.setEnabled(true);
    }//GEN-LAST:event_btn_agregarActionPerformed

    private void txt_buscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscarKeyReleased
    if(this.rb_nombre.isSelected()){
                busquedaN();
    }
    else if(this.rb_apellido.isSelected()){
                busquedaA();
    }
    else if(this.rb_dui.isSelected()){
                busquedaP();
    }
    }//GEN-LAST:event_txt_buscarKeyReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        setearTextBox();
        int col=jTable1.getSelectedRow();
        codigo = Integer.parseInt(jTable1.getModel().getValueAt(col,0).toString());
        txt_nombre.setText(jTable1.getModel().getValueAt(col,1).toString());
        txt_apellido.setText(jTable1.getModel().getValueAt(col,2).toString());
           txt_tel.setText(jTable1.getModel().getValueAt(col,3).toString());
              txt_dui.setText(jTable1.getModel().getValueAt(col,4).toString());
           txt_nit.setText(jTable1.getModel().getValueAt(col,5).toString());
         estado=Integer.parseInt(jTable1.getModel().getValueAt(col,6).toString());
         if(estado==1){
         this.CBestado.removeAllItems();
         this.CBestado.addItem("activo");
         this.CBestado.addItem("inactivo");
         }
         else if(estado==0){
         this.CBestado.removeAllItems();
         this.CBestado.addItem("inactivo");
         this.CBestado.addItem("activo");
         }
         estado=-1;
         desbloquear();
         this.btn_guardar.setEnabled(false);
         this.btn_editar.setEnabled(true);
    }//GEN-LAST:event_jTable1MouseClicked

    private void btn_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editarActionPerformed
            if((this.txt_nombre.getText().length()!=0)&&(this.txt_apellido.getText().length()!=0)
                &&(this.txt_dui.getText().length()!=0)&&(this.txt_nit.getText().length()!=0)
                &&(this.txt_tel.getText().length()!=0)){
                int r= JOptionPane.showConfirmDialog(null,"confirme la edicion del registro. ¿desea continuar?","CONTINUAR!",JOptionPane.YES_NO_OPTION);
                if(r==JOptionPane.YES_OPTION){
                 int Est=-1;
                    String es = (String)this.CBestado.getSelectedItem();
                    if(es.equals("activo")){
                        Est =1;
                    }
                    else if(es.equals("inactivo")){
                        Est=0;
                    }
                    String nombre = this.txt_nombre.getText();
                    String apellido =this.txt_apellido.getText();
                    String telefono =this.txt_tel.getText();
                    String dui =this.txt_dui.getText();
                    String nit = this.txt_nit.getText();
                   clientes ActC=new clientes();
                   ActC.ActualizarCliente(codigo, nombre, apellido, telefono, dui, nit,Est);
                   mostrar();
                   setearTextBox();
                }
                else if(r==JOptionPane.NO_OPTION){
                
                }
                else if(r==JOptionPane.CLOSED_OPTION){
            
                }
            }
            else{
            JOptionPane.showMessageDialog(rootPane, "Algun campo esta sin llenar, revise por favor");
            }
    }//GEN-LAST:event_btn_editarActionPerformed

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        int Est=-1;
        String es = (String)this.CBestado.getSelectedItem();
        if(es.equals("activo")){
        Est =1;
        }
        else if(es.equals("inactivo")){
        Est=0;
        }
        if(txt_nombre.getText().equals("") || txt_apellido.getText().equals("") || txt_tel.getText().equals("") || txt_dui.getText().equals("") || txt_nit.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane, "Ingrese Datos ");
        }
        else{
        clientes clien=new clientes();
        clien.insertarCliente(txt_nombre.getText(),txt_apellido.getText(),
                txt_tel.getText(),txt_dui.getText(),txt_nit.getText(),Est);
        mostrar();
        }
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void txt_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_buscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_buscarActionPerformed

    private void btn_cancecarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancecarActionPerformed
        setearTextBox();
    }//GEN-LAST:event_btn_cancecarActionPerformed

    private void txt_nombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nombreKeyTyped
        if(!Character.isAlphabetic(evt.getKeyChar())&&(evt.getKeyChar()!=' ')) {
            evt.consume();
        }
        if((evt.getKeyChar()==' ')&&(this.txt_nombre.getText().contains(" "))) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_nombreKeyTyped

    private void txt_duiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_duiKeyTyped
        if((!Character.isDigit(evt.getKeyChar()))&&((evt.getKeyChar()!='-'))) {
            evt.consume();
        }
        if((evt.getKeyChar()=='-')&&(this.txt_dui.getText().contains("-"))) {
            evt.consume();
        } 
    }//GEN-LAST:event_txt_duiKeyTyped

    private void txt_nitKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nitKeyTyped
        if((!Character.isDigit(evt.getKeyChar()))&&((evt.getKeyChar()!='-'))) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_nitKeyTyped

    private void txt_apellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_apellidoKeyTyped
        if(!Character.isAlphabetic(evt.getKeyChar())&&(evt.getKeyChar()!=' ')) {
            evt.consume();
        }
        if((evt.getKeyChar()==' ')&&(this.txt_apellido.getText().contains(" "))) {
            evt.consume();
        }        
    }//GEN-LAST:event_txt_apellidoKeyTyped

    private void txt_telKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_telKeyTyped
        if(!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }        
    }//GEN-LAST:event_txt_telKeyTyped

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        if(this.rb_nombre.isSelected()){
                busquedaN();
        }
        else if(this.rb_apellido.isSelected()){
                busquedaA();
        }
        else if(this.rb_dui.isSelected()){
                busquedaP();
        }
    }//GEN-LAST:event_btn_buscarActionPerformed

    public void bloquear(){
   for(int i=0;i<this.JP.getComponents().length;i++) {
        this.JP.getComponent(i).setEnabled(false);
       }
    }
     public void desbloquear(){
   for(int i=0;i<this.JP.getComponents().length;i++) {
        this.JP.getComponent(i).setEnabled(true);
       }
    }
    public void setearTextBox(){
          txt_apellido.setText("");
          txt_nombre.setText("");
          txt_tel.setText("");
          txt_dui.setText("");
          txt_nit.setText("");
          this.CBestado.removeAllItems();
          this.CBestado.addItem("activo");
          this.CBestado.addItem("inactivo");
    }
    public void busquedaN(){
                DefaultTableModel model;
                if(txt_buscar.getText().equals("")){
                    mostrar();
                }
                else{
                    clientes cli =new clientes();
                    model= cli.mostrarClienteConPa(txt_buscar.getText());
                    jTable1.setModel(model);
                }
    }
    public void busquedaA(){
                DefaultTableModel model;
                if(txt_buscar.getText().equals("")){
                    mostrar();
                }
                else{
                    clientes cli =new clientes();
                    model= cli.mostrarClienteConPa2(txt_buscar.getText());
                    jTable1.setModel(model);
                }    
    }
        public void busquedaP(){
                DefaultTableModel model;
                if(txt_buscar.getText().equals("")){
                    mostrar();
                }
                else{
                    clientes cli =new clientes();
                    model= cli.mostrarClienteConPa3(txt_buscar.getText());
                    jTable1.setModel(model);
                }    
    }
    
    public void mostrar(){
        
        try{
            DefaultTableModel model;
            clientes cl=new clientes();
            model=cl.mostrarCliente();
            jTable1.setModel(model);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, e);
            
        }
        
        
    }

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
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Clientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CBestado;
    private javax.swing.JPanel JP;
    private javax.swing.JButton btn_agregar;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_cancecar;
    private javax.swing.JButton btn_editar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_salir;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JRadioButton rb_apellido;
    private javax.swing.JRadioButton rb_dui;
    private javax.swing.JRadioButton rb_nombre;
    private javax.swing.JTextField txt_apellido;
    private javax.swing.JTextField txt_buscar;
    private javax.swing.JTextField txt_dui;
    private javax.swing.JTextField txt_nit;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_tel;
    // End of variables declaration//GEN-END:variables
}
