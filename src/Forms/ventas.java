/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import Datos.Conexion;
import Datos.GenerarCodigo;
import Datos.Ventas;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alex
 */
public class ventas extends javax.swing.JFrame {

    /**
     * Creates new form ventas
     */
    double tott;
       private final Conexion con = new Conexion();
       private final Connection cn= con.conectar();
    DefaultTableModel modelo4;
      DefaultTableModel modelo3;
    public ventas() {
        initComponents();
        modelo4 = new DefaultTableModel();
        modelo3 = new DefaultTableModel();
        
            modelo3.addColumn("Lote");
            modelo3.addColumn("Concepto o Referencia");
            modelo3.addColumn("cantidad");
            modelo3.addColumn("Precio Unitario");
            modelo3.addColumn("Importe");
            
            Date myDate = new Date();
            
          txt_fecha.setText(new SimpleDateFormat("dd/MM/yyyy").format(myDate));  
            txt_fecha.enable(false);
        cargarcodigo();
        mostrar();
        verClientes();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_factura = new javax.swing.JTextField();
        txt_fecha = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        cb_cliente = new javax.swing.JComboBox<>();
        btn_nuevo = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        btn_guardar = new javax.swing.JButton();
        btn_salir = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txt_sub_total = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txt_total = new javax.swing.JTextField();
        txt_cantidad = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        cb_vende = new javax.swing.JComboBox<>();
        txtBuscar = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        btn_nuevo1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(960, 600));
        setMinimumSize(new java.awt.Dimension(960, 600));
        setPreferredSize(new java.awt.Dimension(960, 600));
        setResizable(false);
        setSize(new java.awt.Dimension(960, 600));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("No. factura:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(60, 30, 72, 15);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Fecha:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(340, 30, 38, 15);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Vendedor:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(90, 530, 70, 15);
        getContentPane().add(txt_factura);
        txt_factura.setBounds(170, 20, 120, 30);

        txt_fecha.setText("DD/MM/YYYY");
        getContentPane().add(txt_fecha);
        txt_fecha.setBounds(400, 20, 140, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Producto:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(60, 80, 61, 30);

        cb_cliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(cb_cliente);
        cb_cliente.setBounds(640, 20, 120, 30);

        btn_nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/signo-mas-para-agregar.png"))); // NOI18N
        btn_nuevo.setText("Agregar ");
        btn_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevoActionPerformed(evt);
            }
        });
        getContentPane().add(btn_nuevo);
        btn_nuevo.setBounds(270, 130, 120, 30);

        btn_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/cancelar.png"))); // NOI18N
        btn_cancelar.setText("Eliminar Producto");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_cancelar);
        btn_cancelar.setBounds(60, 430, 190, 41);

        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/guardar.png"))); // NOI18N
        btn_guardar.setText("Guardar Venta");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_guardar);
        btn_guardar.setBounds(270, 430, 190, 40);

        btn_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/salida.png"))); // NOI18N
        btn_salir.setText("Regresar");
        btn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salirActionPerformed(evt);
            }
        });
        getContentPane().add(btn_salir);
        btn_salir.setBounds(790, 520, 170, 40);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Sub total:");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(480, 430, 90, 14);
        getContentPane().add(txt_sub_total);
        txt_sub_total.setBounds(540, 450, 153, 30);

        jButton7.setText("Generar factura");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7);
        jButton7.setBounds(790, 480, 130, 30);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Cantidad:");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(60, 140, 59, 15);
        getContentPane().add(txt_total);
        txt_total.setBounds(770, 440, 153, 30);
        getContentPane().add(txt_cantidad);
        txt_cantidad.setBounds(170, 130, 90, 30);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("$");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(760, 430, 30, 50);

        cb_vende.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(cb_vende);
        cb_vende.setBounds(160, 530, 120, 30);

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });
        getContentPane().add(txtBuscar);
        txtBuscar.setBounds(170, 70, 220, 30);

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
        jScrollPane2.setViewportView(jTable2);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(410, 70, 520, 90);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Cliente:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(570, 30, 46, 15);

        btn_nuevo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/signo-mas-para-agregar.png"))); // NOI18N
        btn_nuevo1.setText("Agregar Cliente");
        btn_nuevo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevo1ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_nuevo1);
        btn_nuevo1.setBounds(770, 20, 160, 30);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTable3);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(60, 190, 870, 230);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Total pagar");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(690, 430, 90, 14);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/W4.png"))); // NOI18N
        jLabel6.setToolTipText("");
        jLabel6.setMaximumSize(new java.awt.Dimension(960, 600));
        jLabel6.setMinimumSize(new java.awt.Dimension(960, 600));
        jLabel6.setPreferredSize(new java.awt.Dimension(960, 600));
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, -30, 970, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        // TODO add your handling code here:
        
         int fsel; 
        fsel=jTable3.getSelectedRow();
        double importe, total1;
        importe=Double.parseDouble(jTable3.getValueAt(fsel,3).toString());
       total1=Double.parseDouble(txt_total.getText()) - importe;
           modelo3.removeRow(fsel) ;
        txt_total.setText(""+total1);
    txt_sub_total.setText(""+ total1);
          
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirActionPerformed
  this.dispose();
        PrincipalAdmin from = new PrincipalAdmin();
        from.setVisible(true);
    }//GEN-LAST:event_btn_salirActionPerformed

    void cargarcodigo()
    {
       int j;
       String num="";
       String c = "";
       String SQL="select max(numfactura) from ventas";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if(rs.next())
            {
                c=rs.getString(1);
            }
               
            if(c==null)
            {
                txt_factura.setText("CD0001");
            }else{
                char r1=c.charAt(2);
                char r2=c.charAt(3);
                char r3=c.charAt(4);
                char r4=c.charAt(5);
                String r ="";
                r = "" +r1+r2+r3+r4;
                
                
                j=Integer.parseInt(r);
                GenerarCodigo gen = new GenerarCodigo();
                gen.generar(j);
              txt_factura.setText("CD"+gen.serie());
                txt_factura.enable(false);
            }
            
        } catch (Exception e) {
        }
    }
    
    
    
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void btn_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevoActionPerformed
        // TODO add your handling code here:
          
            if(Integer.parseInt(txt_cantidad.getText())>0){
          try{
         //  
            
        
        
      //  JOptionPane.showMessageDialog(null,""+cadena2[0]);
             
           // 
       
       int fsel=jTable2.getSelectedRow();
       
        String lote=jTable2.getValueAt(fsel,0).toString();
        String nombre=jTable2.getValueAt(fsel,1).toString();
        //String Bcan=tablaExistencias1.getValueAt(fsel,0).toString()-cant;
        
        String precio=jTable2.getValueAt(fsel,3).toString();
        String cant=txt_cantidad.getText();
        //String lote=tablaExistencias1.getValueAt(fsel,3).toString();
        String Bcan=jTable2.getValueAt(fsel,2).toString();
        
        //Plote=lote;
        String Resultado;
        double x;
        x=(Double.parseDouble(precio)*(Double.parseDouble(cant)));
        Resultado=String.valueOf(x);
        String []Datos={lote,nombre,cant,precio,Resultado};
        
        
        modelo3.addRow(Datos);
        
        
        jTable3.setModel(modelo3);
        
        double calcula=(Double.parseDouble(Resultado));
        tott=tott+calcula;
        //String CA;
        
        txt_total.setText(""+tott);
      //  total=total + calcula;
      //  txtTotal.setText(""+total);
        
        }
        catch (Exception ex){
             JOptionPane.showMessageDialog(null,ex.toString());
            
        }
         txt_cantidad.setText("");
         
 
        
        
        
            }
            
            else{
                JOptionPane.showMessageDialog(null,"Mahe Ingresa numeros Positivos");
            
                
            }
        
        
        
    }//GEN-LAST:event_btn_nuevoActionPerformed

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        // TODO add your handling code here:
       DefaultTableModel vacio;
       vacio = new DefaultTableModel();
        vacio.addColumn("lote");
         vacio.addColumn("Producto");
        vacio.addColumn("precio");
          vacio.addColumn("cantidad");
        Ventas nventas = new Ventas();
        String cadena;
        String []cadena2;
        cadena= cb_cliente.getSelectedItem().toString(); 
        cadena2=cadena.split("-");

         String cadena1;
        String []cadena3;
        cadena1= cb_vende.getSelectedItem().toString(); 
        cadena3=cadena1.split("-");
        
        nventas.insertarVenta(txt_fecha.getText(),txt_factura.getText(),Double.parseDouble(txt_sub_total.getText()),Double.parseDouble(txt_total.getText()),Integer.parseInt(cadena2[0]),1);
        
        
        try{
         
        
            
        modelo4.addColumn("lote");
         modelo4.addColumn("Producto");
         modelo4.addColumn("precio");
          modelo4.addColumn("cantidad");
          // modelo4.addColumn("precio * cantidad");
           
  
        //String eje[];
        for(int i=0;i<jTable3.getRowCount();i++)
        {
             
          
           String elemento[]={jTable3.getValueAt(i, 0).toString(),jTable3.getValueAt(i, 1).toString(),jTable3.getValueAt(i, 2).toString(),jTable3.getValueAt(i, 3).toString()};
          
        
         modelo4.addRow(elemento);
        }  
        
       // modelo4.addRow(elemento);
      
       
        
        Ventas func2= new Ventas();
        func2.insertarDetalle(modelo4);
        mostrar();
        cargarcodigo();
      jTable3.setModel(vacio);
        
        }
        catch (Exception e){
             JOptionPane.showMessageDialog(null,e.toString());
            
        }
        
        
    }//GEN-LAST:event_btn_guardarActionPerformed

    
    
      public void mostrar(){
        
        try{
            DefaultTableModel model;
            Ventas cl=new Ventas();
            model=cl.mostrarProductos();
            jTable2.setModel(model);
           
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, e);
            
        }
        
        
    }
      
      
        public void verClientes(){
        
        
//        conexion conec = new conexion();
//        Connection cn=conec.conectar();
        String consulta="select IDCLIENTE,NOMCLIENTE,APELLCLIENTE from clientes order by IDCLIENTE";
        String grados;
        cb_cliente.removeAllItems();
        try {
            Statement sql=(Statement) cn.createStatement();
            ResultSet rsgrados=sql.executeQuery(consulta);
            while (rsgrados.next()) { 
               cb_cliente.addItem((String) rsgrados.getString("IDCLIENTE") + "-"+ rsgrados.getString("NOMCLIENTE")+" "+rsgrados.getString("APELLCLIENTE"));
            }
            cn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error sql, no puede leer los datos: " +e.getMessage().toString());
        }
    }
       
    
    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        // TODO add your handling code here:
        DefaultTableModel model;
        if(txtBuscar.getText().equals("")){
        mostrar();
        }
        else{
        Ventas cli =new Ventas();
       model= cli.mostrarProductoscmp(txtBuscar.getText());
        jTable2.setModel(model);
        }
        
        
        
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void btn_nuevo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_nuevo1ActionPerformed

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
            java.util.logging.Logger.getLogger(ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ventas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_nuevo;
    private javax.swing.JButton btn_nuevo1;
    private javax.swing.JButton btn_salir;
    private javax.swing.JComboBox<String> cb_cliente;
    private javax.swing.JComboBox<String> cb_vende;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txt_cantidad;
    private javax.swing.JTextField txt_factura;
    private javax.swing.JFormattedTextField txt_fecha;
    private javax.swing.JTextField txt_sub_total;
    private javax.swing.JTextField txt_total;
    // End of variables declaration//GEN-END:variables
}
