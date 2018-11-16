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
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;
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
               CallableStatement csta=cn.prepareCall("{call insertarDetalleventa(?,?,?,?)}");
               csta.setInt(1,Integer.parseInt(modelo1.getValueAt(i,0).toString()));
            csta.setString(2,modelo1.getValueAt(i,1).toString());
             csta.setInt(3,Integer.parseInt(modelo1.getValueAt(i,2).toString()));
            csta.setInt(4,Integer.parseInt(modelo1.getValueAt(i,3).toString()));
             // csta.setString(6,modelo1.getValueAt(i,5).toString());
               
               
               
           //JOptionPane.showMessageDialog(null,"dato " + i + " :" + modelo1);    
           rs=csta.executeQuery();
            
               }
           }
           catch(SQLException e){
               
               JOptionPane.showMessageDialog(null,"no se puede" + e);
                
           }
           
           
       }
    
    
    
    public DefaultTableModel mostrarProductos(){
        DefaultTableModel model;
        try{
            CallableStatement csta=cn.prepareCall("{call verProductosVentas(?)}");
            csta.registerOutParameter(1, OracleTypes.CURSOR);
            rs=csta.executeQuery();
            //ResultSet rs =(ResultSet)csta.getObject("out_data");
            ResultSet rs =((OracleCallableStatement)csta).getCursor(1);
            
            Object Datos[]=new Object[4];
            model=new DefaultTableModel();
            model.addColumn("Codigo de Inventario");
            model.addColumn("Nombre Producto");
            model.addColumn("Cantidad");
            model.addColumn("Precio");
       
        
        
          
          
        
            while(rs.next()){
                for(int i=0;i<4;i++)
                    Datos[i]=rs.getObject(i+1);
                 model.addRow(Datos);
            }
           
            return model;
        }
        catch(SQLException e)
        {
            return null;
        }
      //  return model;
    }
    
    
    public DefaultTableModel mostrarProductoscmp(String Bus){
        DefaultTableModel model;
        try{
            CallableStatement csta=cn.prepareCall("{call verProductosVentascmp(?,?)}");
            csta.registerOutParameter(1, OracleTypes.CURSOR);
            csta.setString(2,Bus);
            rs=csta.executeQuery();
            //ResultSet rs =(ResultSet)csta.getObject("out_data");
            ResultSet rs =((OracleCallableStatement)csta).getCursor(1);
            
            Object Datos[]=new Object[4];
            model=new DefaultTableModel();
          
            model.addColumn("Codigo de Inventario");
            model.addColumn("Nombre Producto");
            model.addColumn("Cantidad");
            model.addColumn("Precio");
       
        
        
          
          
        
            while(rs.next()){
                for(int i=0;i<4;i++)
                    Datos[i]=rs.getObject(i+1);
                 model.addRow(Datos);
            }
           
            return model;
        }
        catch(SQLException e)
        {
            return null;
        }
      //  return model;
    }
    
    
    
    
}
