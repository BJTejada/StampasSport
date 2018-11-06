/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import clases.ColorT;
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
    static Connection conn=null;
    
    public DefaultTableModel mostrarCliente(){
        DefaultTableModel model;
        try{
            CallableStatement csta=cn.prepareCall("{call ver_clientes(?)}");
            csta.registerOutParameter(1, OracleTypes.CURSOR);
            rs=csta.executeQuery();
            //ResultSet rs =(ResultSet)csta.getObject("out_data");
            ResultSet rs =((OracleCallableStatement)csta).getCursor(1);
            Object Datos[]=new Object[7];
            model=new DefaultTableModel();
            model.addColumn("ID");
            model.addColumn("nombre");
            model.addColumn("apellido");
            model.addColumn("telefono");
            model.addColumn("dui");
            model.addColumn("nit");
            model.addColumn("estado");
            while(rs.next()){
                for(int i=0;i<7;i++)
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
    
    public void insertarCliente(String nombre,String apellido,String Telefono,String Dui,String Nit,int estado){
       int dui=-1;
       int nit=-1;
        try{
                conn=Conexion.conectar(conn);
                String sql="{call insertarClientes(?,?,?,?,?,?,?,?)}";
                CallableStatement pst=conn.prepareCall(sql);
                pst.setString(1,nombre);
                pst.setString(2,apellido);
                pst.setString(3,Telefono);
                pst.setString(4,Dui);
                pst.setString(5,Nit);
                pst.setInt(6,1);
                pst.registerOutParameter(7, java.sql.Types.NUMERIC);
                pst.registerOutParameter(8, java.sql.Types.NUMERIC);
                pst.execute();
                dui = pst.getInt(7);
                nit = pst.getInt(8);
              if((dui==0)&&(nit==0)){
             JOptionPane.showMessageDialog(null,"cliente ingresado");
                dui=-1;
                nit=-1;
              }
              else if((dui==1)&&(nit==1)){
              JOptionPane.showMessageDialog(null,"El campo \"Dui\" o \"Nit\" estan ya ingresados en algun registro de un cliente");
              dui=-1;
                nit=-1;
              }
            }catch(Exception e){
                System.out.println(e.getCause());//OBTENER ERROR
                JOptionPane.showMessageDialog(null, "no pudo insertarse " + e);
            }finally{
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println("Error: " + ex.getMessage());
                }
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
            Object Datos[]=new Object[7];
            model=new DefaultTableModel();
            model.addColumn("ID");
            model.addColumn("nombre");
            model.addColumn("apellido");
            model.addColumn("telefono");
            model.addColumn("dui");
            model.addColumn("nit");
            model.addColumn("estado");
            while(rs.next()){
                for(int i=0;i<7;i++)
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
     public DefaultTableModel mostrarClienteConPa2(String Bus){
        DefaultTableModel model;
        try{
            CallableStatement csta=cn.prepareCall("{call ver_clientesCpa2(?,?)}");
            csta.registerOutParameter(1, OracleTypes.CURSOR);
            csta.setString(2,Bus);
            rs=csta.executeQuery();
            //ResultSet rs =(ResultSet)csta.getObject("out_data");
            ResultSet rs =((OracleCallableStatement)csta).getCursor(1);
            Object Datos[]=new Object[7];
            model=new DefaultTableModel();
            model.addColumn("ID");
            model.addColumn("nombre");
            model.addColumn("apellido");
            model.addColumn("telefono");
            model.addColumn("dui");
            model.addColumn("nit");
            model.addColumn("estado");
            while(rs.next()){
                for(int i=0;i<7;i++)
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
          public DefaultTableModel mostrarClienteConPa3(String Bus){
        DefaultTableModel model;
        try{
            CallableStatement csta=cn.prepareCall("{call ver_clientesCpa3(?,?)}");
            csta.registerOutParameter(1, OracleTypes.CURSOR);
            csta.setString(2,Bus);
            rs=csta.executeQuery();
            //ResultSet rs =(ResultSet)csta.getObject("out_data");
            ResultSet rs =((OracleCallableStatement)csta).getCursor(1);
            Object Datos[]=new Object[7];
            model=new DefaultTableModel();
            model.addColumn("ID");
            model.addColumn("nombre");
            model.addColumn("apellido");
            model.addColumn("telefono");
            model.addColumn("dui");
            model.addColumn("nit");
            model.addColumn("estado");
            while(rs.next()){
                for(int i=0;i<7;i++)
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
public void ActualizarCliente(int id,String nombre,String apellido,String telefono,String dui,String nit,int estado){
        int mdui=-1;
        int mnit=-1;
        try{
                conn=Conexion.conectar(conn);
                String sql="{call editar_cliente(?,?,?,?,?,?,?,?,?)}";
                CallableStatement pst=conn.prepareCall(sql);
                pst.setInt(1,id);
                pst.setString(2,nombre);
                pst.setString(3,apellido);
                pst.setString(4,telefono);
                pst.setString(5,dui);
                pst.setString(6,nit);
                pst.setInt(7,estado);
                pst.registerOutParameter(8, java.sql.Types.NUMERIC);
                pst.registerOutParameter(9, java.sql.Types.NUMERIC);
                pst.execute();
                mdui = pst.getInt(8);
                mnit = pst.getInt(9);
              if((mdui==00)&&(mnit==0)){
             JOptionPane.showMessageDialog(null,"cliente actualizado");
              }
            }catch(Exception e){
                System.out.println(e.getCause());//OBTENER ERROR
                JOptionPane.showMessageDialog(null, "no pudo insertarse " + e);
            }finally{
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println("Error: " + ex.getMessage());
                }
            }
        mdui=-1;
        mnit=-1;
}
}
