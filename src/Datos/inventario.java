/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Alex
 */
public class inventario {
    
      static ResultSet rs;
    private final Conexion con = new Conexion();
    private final Connection cn=con.conectar();
    
    
    
    
    public DefaultTableModel mostrarProductosInventario(){
        DefaultTableModel model;
        try{
            CallableStatement csta=cn.prepareCall("{call verinventario(?)}");
            csta.registerOutParameter(1, OracleTypes.CURSOR);
            rs=csta.executeQuery();
            //ResultSet rs =(ResultSet)csta.getObject("out_data");
            ResultSet rs =((OracleCallableStatement)csta).getCursor(1);
            Object Datos[]=new Object[8];
            model=new DefaultTableModel();
            model.addColumn("ID");
            model.addColumn("nombre");
            model.addColumn("Fecha");
            model.addColumn("cantidad");
            model.addColumn("Precio Compra");
            model.addColumn("Precio Venta");
            model.addColumn("Detalle De compra");
            model.addColumn("Encargado");
            while(rs.next()){
                for(int i=0;i<8;i++)
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
