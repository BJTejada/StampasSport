/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import static Datos.compras.rs;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class Ventas {
       static ResultSet rs;
    private final Conexion con = new Conexion();
    private final Connection cn=con.conectar();
    
     public void insertarVenta(String Fecha,String factura,double subtotal,double total,int idcli,int idempleado){
           try{
               CallableStatement csta=cn.prepareCall("{call ingresarVenta(?,?,?,?,?,?)}");
               //csta.setInt(1,'2');
               csta.setString(1,Fecha);
               csta.setString(2,factura);
               csta.setDouble(3,subtotal);
               csta.setDouble(4,total);
               csta.setInt(5,idcli);
               csta.setInt(6,idempleado);
               rs=csta.executeQuery();
           }
           catch(SQLException e){
               JOptionPane.showMessageDialog(null, "no pudo insertarse " + e);
           }
       }
    public void insertarDetalle(DefaultTableModel modelo1){
           try{
               for(int i=0;modelo1.getRowCount()>i;i++){
               CallableStatement csta=cn.prepareCall("{call insertarDetalleventa(?,?,?)}");
               csta.setInt(1,Integer.parseInt(modelo1.getValueAt(i,0).toString()));
            csta.setDouble(2,Double.parseDouble(modelo1.getValueAt(i,1).toString()));
             csta.setInt(3,Integer.parseInt(modelo1.getValueAt(i,2).toString()));
            
             // csta.setString(6,modelo1.getValueAt(i,5).toString());
               
               
               
           //JOptionPane.showMessageDialog(null,"dato " + i + " :" + modelo1);    
           rs=csta.executeQuery();
            
               }
           }
           catch(SQLException e){
               
               JOptionPane.showMessageDialog(null,"no se puede" + e);
                
           }
           
           
       }        
    
    
}
