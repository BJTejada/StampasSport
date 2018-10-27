/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alex
 */
public class compras {
    
    
    static ResultSet rs;
    private final Conexion con = new Conexion();
    private final Connection cn=con.conectar();
        
     public void insertarCompra(String factura,String Fecha,double total){
           try{
               
               
               CallableStatement csta=cn.prepareCall("{call Comprar(?,?,?)}");
               //csta.setInt(1,'2');
               csta.setString(1,factura);
               csta.setString(2,Fecha);
               csta.setDouble(3,total);
             
           
               

               rs=csta.executeQuery();
           }
           catch(SQLException e){
               
               JOptionPane.showMessageDialog(null, "no pudo insertarse " + e);
                
           }
       }
    
     
     
     
        
     public void insertarDetalle(DefaultTableModel modelo1){
           try{
               
               
               for(int i=0;modelo1.getRowCount()>i;i++){
               CallableStatement csta=cn.prepareCall("{call insertarDetalleCompra(?,?,?,?,?)}");
               csta.setString(1,modelo1.getValueAt(i,0).toString());
            csta.setString(2,modelo1.getValueAt(i,1).toString());
             csta.setString(3,modelo1.getValueAt(i,2).toString());
              csta.setString(4,modelo1.getValueAt(i,3).toString());
              csta.setString(5,modelo1.getValueAt(i,4).toString());
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
