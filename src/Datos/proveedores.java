
package Datos;

import static Datos.clientes.rs;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

public class proveedores {
    static ResultSet rs;
    private final Conexion con = new Conexion();
    private final Connection cn=con.conectar();
     public void insertarProveedor(String nombre,String Telefono,String Correo,String Direccion){
           try{
               CallableStatement csta=cn.prepareCall("{call insertarProveedor(?,?,?,?)}");
               //csta.setInt(1,'2');
               csta.setString(1,nombre);
               csta.setString(2,Telefono);
               csta.setString(3,Correo);
               csta.setString(4,Direccion);
               rs=csta.executeQuery();
           }
           catch(SQLException e){
               
               JOptionPane.showMessageDialog(null, "no pudo insertarse " + e);
                
           }
       }
      public DefaultTableModel mostrarProveedor(){
        DefaultTableModel model;
        try{
            CallableStatement csta=cn.prepareCall("{call ver_proveedores(?)}");
            csta.registerOutParameter(1, OracleTypes.CURSOR);
            rs=csta.executeQuery();
            //ResultSet rs =(ResultSet)csta.getObject("out_data");
            ResultSet rs =((OracleCallableStatement)csta).getCursor(1);
            Object Datos[]=new Object[5];
            model=new DefaultTableModel();
            model.addColumn("ID");
            model.addColumn("nombre");
            model.addColumn("Telefono");
            model.addColumn("correo");
            model.addColumn("direccion");
            
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
}
