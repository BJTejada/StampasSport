package Forms;

import javax.swing.JFrame;
import java.sql.*;
import Datos.Conexion;
import javax.swing.JOptionPane;
/**
 *
 * @author Tejada
 */
public class LogIn extends javax.swing.JFrame {
    static Connection conn=null;
    static ResultSet rs=null;
    int usuario=0;
    int clave=0;
    int cargo=0;
    int estado=0;
    /**
     * Creates new form LogIn
     */
    public LogIn() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        TxtUsuario = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        TxtPassword = new javax.swing.JPasswordField();
        btn_Acceder = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        jFormattedTextField1.setText("jFormattedTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LogIn");
        setBackground(new java.awt.Color(255, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(400, 400));
        setMinimumSize(new java.awt.Dimension(400, 400));
        setResizable(false);
        setSize(new java.awt.Dimension(400, 400));
        getContentPane().setLayout(null);

        jLabel5.setFont(new java.awt.Font("Aharoni", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("INICIO DE SESION");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(110, 20, 158, 24);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/User.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(130, 60, 150, 150);

        TxtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(TxtUsuario);
        TxtUsuario.setBounds(150, 210, 120, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Clave");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(90, 270, 31, 14);

        TxtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtPasswordActionPerformed(evt);
            }
        });
        getContentPane().add(TxtPassword);
        TxtPassword.setBounds(150, 260, 120, 30);

        btn_Acceder.setBackground(new java.awt.Color(255, 153, 153));
        btn_Acceder.setText("Acceder");
        btn_Acceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AccederActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Acceder);
        btn_Acceder.setBounds(150, 310, 90, 23);

        btn_cancelar.setBackground(new java.awt.Color(102, 102, 255));
        btn_cancelar.setText("Cancelar");
        btn_cancelar.setActionCommand("");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_cancelar);
        btn_cancelar.setBounds(150, 340, 90, 23);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Usuario");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(80, 220, 43, 14);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/W3.png"))); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 0, 400, 400);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TxtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtUsuarioActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
           // TODO add your handling code here:
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void TxtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtPasswordActionPerformed

    private void btn_AccederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AccederActionPerformed
    //variables a recibir: usuario, clave, cargo,estado
    //si recibe: 1,1,1,1(acceso concedido con cargo administrador) o 1,1,1,2(acceso concedido con cargo administrador)
    //0,0,0,0(acceso denegado)
    //1,1,0,0(acceso concedido pero el usuario esta desactivado)
    try{
    conn=Conexion.conectar(conn);//INVOCANDO LA CONEXION DESDE LA CLASE main
                 String sql="{call ACEPTARL(?,?,?,?,?,?)}";//QUERY

                 CallableStatement pst=conn.prepareCall(sql);//EJECUCION DE QUERY POR MEDIO DE STATEMENT
                 //ASIGANAR DE VARIABLES A LOS PARAMETROS DE QUERY
                 pst.setString(1, this.TxtUsuario.getText());
                 pst.setString(2, String.valueOf(this.TxtPassword.getPassword()));
                 pst.registerOutParameter(3, java.sql.Types.NUMERIC);
                 pst.registerOutParameter(4, java.sql.Types.NUMERIC);
                 pst.registerOutParameter(5, java.sql.Types.NUMERIC);
                 pst.registerOutParameter(6, java.sql.Types.NUMERIC);
                 pst.execute();//EJECUTAR
                 usuario = Integer.parseInt(pst.getString(3));
                 clave = Integer.parseInt(pst.getString(4));
                estado = Integer.parseInt(pst.getString(5));
                cargo = Integer.parseInt(pst.getString(6));
    }catch(Exception e){
                System.out.println(e.getCause());//OBTENER ERROR
    }finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
    }
        if ((usuario==1)&&(clave==1)&&(estado==1)&&(cargo==1)) {
            PrincipalAdmin form = new PrincipalAdmin();
            form.setVisible(true);
            
            JOptionPane.showMessageDialog(null, "acceso concedido","acceso",JOptionPane.INFORMATION_MESSAGE);
        }
        if ((usuario==1)&&(clave==1)&&(estado==1)&&(cargo==2)) {
            Inicio_vendedor form = new Inicio_vendedor();
            form.setVisible(true);
            JOptionPane.showMessageDialog(null, "acceso concedido","acceso",JOptionPane.INFORMATION_MESSAGE);
        }
        if ((usuario==1)&&(clave==1)&&(estado==0)&&(cargo==0)) {
            JOptionPane.showMessageDialog(null, "usuario desactivado","acceso ",JOptionPane.INFORMATION_MESSAGE);
        }
        if ((usuario==0)&&(clave==0)&&(estado==0)&&(cargo==0)) {
            JOptionPane.showMessageDialog(null, "usuario o contraseña incorrectos","acceso",JOptionPane.INFORMATION_MESSAGE);
        }
     usuario=0;
     clave=0;
     cargo=0;
     estado=0;
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_AccederActionPerformed

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
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogIn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField TxtPassword;
    private javax.swing.JTextField TxtUsuario;
    private javax.swing.JButton btn_Acceder;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JProgressBar jProgressBar1;
    // End of variables declaration//GEN-END:variables
}
