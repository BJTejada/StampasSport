/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import static Datos.Ventas.rs;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Alex
 */
public class Reportesw {
     static ResultSet rs;
    private final Conexion con = new Conexion();
    private final Connection cn=con.conectar();
    
     public DefaultTableModel obtener(String Fecha,String Fecha2){
         
           try{
                    DefaultTableModel model;
               CallableStatement csta=cn.prepareCall("{call obtnerReporteVenta(?,?,?)}");
               //csta.setInt(1,'2');
               csta.registerOutParameter(1, OracleTypes.CURSOR);
               csta.setString(2,Fecha);
               csta.setString(3,Fecha2);
             
              rs=csta.executeQuery();
              
              
                 ResultSet rs = ((OracleCallableStatement)csta).getCursor(1);
               
               Object Datos[]= new Object[7];// 1-id, 2-nombre, 3-apellido
               model = new DefaultTableModel();
               model.addColumn("ID");
               model.addColumn("Numero de factura");
                model.addColumn("Fecha");
                model.addColumn("Sub Total");
                model.addColumn("total");
               model.addColumn("Nombre cliente");
                model.addColumn("Vendedor");
               
               
               while (rs.next())
            {
              for (int i=0;i<7;i++) Datos[i]=rs.getObject(i+1);
                model.addRow(Datos);
             }           
          return model;
           }
           catch(SQLException e){
               JOptionPane.showMessageDialog(null, "no pudo insertarse " + e);
             return null;  
           }
              
              
           }
     
     
     
     public DefaultTableModel MostrarDetalle(int idv){
         
           try{
                    DefaultTableModel model;
               CallableStatement csta=cn.prepareCall("{call obtnerReportedetalleVenta(?,?)}");
               //csta.setInt(1,'2');
               csta.registerOutParameter(1, OracleTypes.CURSOR);
               csta.setInt(2,idv);
               
             
              rs=csta.executeQuery();
              
              
                 ResultSet rs = ((OracleCallableStatement)csta).getCursor(1);
               
               Object Datos[]= new Object[5];// 1-id, 2-nombre, 3-apellido
               model = new DefaultTableModel();
               model.addColumn("ID");
                model.addColumn("Nombre producto");
                model.addColumn("venta");
                model.addColumn("precio");
                model.addColumn("cantidad");
              
               
               
               while (rs.next())
            {
              for (int i=0;i<5;i++) Datos[i]=rs.getObject(i+1);
                model.addRow(Datos);
             }           
          return model;
           }
           catch(SQLException e){
               JOptionPane.showMessageDialog(null, "no pudo insertarse " + e);
             return null;  
           }
              
              
           }
     
     
     
     
       }

    
    
    
    
    
    
    
