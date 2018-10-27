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
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Alex
 */
public class productos {
    
     static ResultSet rs;
    private final Conexion con = new Conexion();
    private final Connection cn=con.conectar();
    
    
    
    
    public DefaultTableModel mostrarProductos(){
        DefaultTableModel model;
        try{
            CallableStatement csta=cn.prepareCall("{call verProductos(?)}");
            csta.registerOutParameter(1, OracleTypes.CURSOR);
            rs=csta.executeQuery();
            //ResultSet rs =(ResultSet)csta.getObject("out_data");
            ResultSet rs =((OracleCallableStatement)csta).getCursor(1);
            
            Object Datos[]=new Object[5];
            model=new DefaultTableModel();
            model.addColumn("ID");
            model.addColumn("nombre");
            model.addColumn("marca");
            model.addColumn("proveedor");
            model.addColumn("categoria");
        
        
          
          
        
            while(rs.next()){
                for(int i=0;i<5;i++)
                    Datos[i]=rs.getObject(i+1);
                 model.addRow(Datos);
            }
           
            return model;
        }
        catch(Exception e)
        {
            return null;
        }
      //  return model;
    }
    
    
    
      public void insertarProductos(String nombre, String marca, int proveedor, int categoria){
            
           try{
               
               
               CallableStatement csta=cn.prepareCall("{call aggProductos(?,?,?,?)}");
               //csta.setInt(1,'2');
               csta.setString(1,nombre);
               csta.setString(2,marca);
               csta.setInt(3,proveedor);
               csta.setInt(4,categoria);
               
               rs=csta.executeQuery();
           }
           catch(SQLException e){
               
               JOptionPane.showMessageDialog(null, "no pudo insertarse " + e);
                
           }
       }
    
    
}
