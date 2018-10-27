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
public class clientes {
    static ResultSet rs;
    private final Conexion con = new Conexion();
    private final Connection cn=con.conectar();
    
    
    
    public DefaultTableModel mostrarCliente(){
        DefaultTableModel model;
        try{
            CallableStatement csta=cn.prepareCall("{call ver_clientes(?)}");
            csta.registerOutParameter(1, OracleTypes.CURSOR);
            rs=csta.executeQuery();
            //ResultSet rs =(ResultSet)csta.getObject("out_data");
            ResultSet rs =((OracleCallableStatement)csta).getCursor(1);
            Object Datos[]=new Object[6];
            model=new DefaultTableModel();
            model.addColumn("ID");
            model.addColumn("nombre");
            model.addColumn("apellido");
            model.addColumn("telefono");
            model.addColumn("dui");
            model.addColumn("nit");
            while(rs.next()){
                for(int i=0;i<6;i++)
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
    
    public void insertarCliente(String nombre,String apellido,String Telefono,String Dui,String Nit){
           try{
               
               
               CallableStatement csta=cn.prepareCall("{call insertarClientes(?,?,?,?,?)}");
               //csta.setInt(1,'2');
               csta.setString(1,nombre);
               csta.setString(2,apellido);
               csta.setString(3,Telefono);
               csta.setString(4,Dui);
               csta.setString(5,Nit);

               rs=csta.executeQuery();
           }
           catch(SQLException e){
               
               JOptionPane.showMessageDialog(null, "no pudo insertarse " + e);
                
           }
       }
    
     public DefaultTableModel mostrarClienteConPa(String Bus){
        DefaultTableModel model;
        try{
            CallableStatement csta=cn.prepareCall("{call ver_clientesCpa(?,?)}");
            csta.registerOutParameter(1, OracleTypes.CURSOR);
            csta.setString(2,Bus);
            rs=csta.executeQuery();
            //ResultSet rs =(ResultSet)csta.getObject("out_data");
            ResultSet rs =((OracleCallableStatement)csta).getCursor(1);
            Object Datos[]=new Object[6];
            model=new DefaultTableModel();
            model.addColumn("ID");
            model.addColumn("nombre");
            model.addColumn("apellido");
            model.addColumn("telefono");
            model.addColumn("dui");
            model.addColumn("nit");
            while(rs.next()){
                for(int i=0;i<6;i++)
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
    
    
    
    
    
}
